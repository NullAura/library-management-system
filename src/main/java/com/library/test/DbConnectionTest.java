package com.library.test;

import com.library.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnectionTest {
    public static void main(String[] args) {
        DatabaseUtil dbUtil = new DatabaseUtil();
        Connection conn = null;
        
        try {
            System.out.println("尝试连接到数据库...");
            conn = dbUtil.getConnection();
            System.out.println("数据库连接成功！");
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM t_user");
            
            if (rs.next()) {
                System.out.println("用户表中有 " + rs.getInt(1) + " 条记录");
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("数据库连接失败!");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
} 