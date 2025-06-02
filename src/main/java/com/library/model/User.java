package com.library.model;

/**
 * 用户实体类
 */
public class User {
    private int id;          // 用户ID
    private String username; // 用户名
    private String password; // 密码
    private String role;     // 用户角色

    /**
     * 默认构造函数
     */
    public User() {
    }

    /**
     * 带参数的构造函数
     * 
     * @param username 用户名
     * @param password 密码
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * 带全部参数的构造函数
     * 
     * @param username 用户名
     * @param password 密码
     * @param role 用户角色
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * 获取用户ID
     * 
     * @return 用户ID
     */
    public int getId() {
        return id;
    }

    /**
     * 设置用户ID
     * 
     * @param id 用户ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * 
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * 
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * 获取用户角色
     * 
     * @return 用户角色
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置用户角色
     * 
     * @param role 用户角色
     */
    public void setRole(String role) {
        this.role = role;
    }
} 