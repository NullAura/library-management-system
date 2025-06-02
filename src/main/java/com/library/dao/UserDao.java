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
        String sql = "SELECT * FROM lmbuser WHERE username = ? AND password = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            resultUser = new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUsername(rs.getString("username"));
            resultUser.setPassword(rs.getString("password"));
        }
        
        rs.close();
        pstmt.close();
        return resultUser;
    }
} 