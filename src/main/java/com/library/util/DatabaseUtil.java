package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 */
public class DatabaseUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_librarymanagementsystem?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "nullaura"; // 如果您的MySQL root用户没有密码，请留空
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     *
     * @return 数据库连接对象
     * @throws Exception 连接异常
     */
    public Connection getConnection() throws Exception {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    /**
     * 关闭数据库连接
     *
     * @param connection 需要关闭的连接对象
     * @throws Exception 关闭异常
     */
    public void closeConnection(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
} 