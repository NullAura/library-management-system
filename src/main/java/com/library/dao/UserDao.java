package com.library.dao;

import com.library.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户数据访问对象
 */
public class UserDao {

    /**
     * 登录验证
     *
     * @param connection 数据库连接
     * @param user 用户对象
     * @return 验证成功的用户对象，验证失败返回null
     * @throws Exception SQL执行异常
     */
    public User login(Connection connection, User user) throws Exception {
        User resultUser = null;
        String sql = "SELECT * FROM t_user WHERE username = ? AND password = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            resultUser = new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUsername(rs.getString("username"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setRole(rs.getString("role"));
        }
        
        rs.close();
        pstmt.close();
        return resultUser;
    }
    
    /**
     * 注册用户
     *
     * @param connection 数据库连接
     * @param user 用户对象
     * @return 注册成功返回true，失败返回false
     * @throws Exception SQL执行异常
     */
    public boolean register(Connection connection, User user) throws Exception {
        // 先检查用户名是否已存在
        String checkSql = "SELECT * FROM t_user WHERE username = ?";
        PreparedStatement checkStmt = connection.prepareStatement(checkSql);
        checkStmt.setString(1, user.getUsername());
        ResultSet rs = checkStmt.executeQuery();
        
        if (rs.next()) {
            // 用户名已存在
            rs.close();
            checkStmt.close();
            return false;
        }
        
        // 用户名不存在，执行注册
        String sql = "INSERT INTO t_user (username, password, role) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getRole());
        
        int result = pstmt.executeUpdate();
        
        rs.close();
        checkStmt.close();
        pstmt.close();
        
        return result > 0;
    }
} 