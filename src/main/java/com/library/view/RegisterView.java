package com.library.view;

import com.library.dao.UserDao;
import com.library.model.User;
import com.library.util.DatabaseUtil;
import com.library.util.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * 用户注册界面
 */
public class RegisterView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JRadioButton readerRadioButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JPasswordField confirmPasswordText;
    private JButton registerButton;
    private JButton backButton;
    
    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private UserDao userDao = new UserDao();

    /**
     * 构造函数，初始化注册界面
     */
    public RegisterView() {
        // 设置窗口属性
        super("用户注册");
        setBounds(400, 400, 450, 400);
        setLocationRelativeTo(null);
        
        // 创建主面板，使用BorderLayout布局
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 245));
        
        // 创建标题面板
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(240, 240, 245));
        JLabel titleLabel = new JLabel("用户注册");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 102, 153));
        titlePanel.add(titleLabel);
        
        // 创建角色选择面板
        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        rolePanel.setBackground(new Color(240, 240, 245));
        readerRadioButton = new JRadioButton("读者");
        
        // 设置单选按钮样式
        readerRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        readerRadioButton.setBackground(new Color(240, 240, 245));
        readerRadioButton.setSelected(true); // 默认选中读者角色
        
        rolePanel.add(readerRadioButton);
        
        // 创建注册表单面板
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(240, 240, 245));
        
        // 设置标签和文本框
        usernameLabel = new JLabel("用户名:");
        usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameText = new JTextField(15);
        
        passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordText = new JPasswordField(15);
        
        confirmPasswordLabel = new JLabel("确认密码:");
        confirmPasswordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        confirmPasswordText = new JPasswordField(15);
        
        // 添加边框和圆角
        usernameText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        passwordText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        confirmPasswordText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        // 组装表单
        formPanel.add(usernameLabel);
        formPanel.add(usernameText);
        formPanel.add(passwordLabel);
        formPanel.add(passwordText);
        formPanel.add(confirmPasswordLabel);
        formPanel.add(confirmPasswordText);
        
        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(240, 240, 245));
        
        // 设置按钮样式
        registerButton = new JButton("注册");
        backButton = new JButton("返回登录");
        
        registerButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        backButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        
        registerButton.setBackground(new Color(70, 130, 180));
        registerButton.setForeground(Color.BLACK);
        registerButton.setPreferredSize(new Dimension(100, 35));
        
        backButton.setBackground(new Color(220, 220, 220));
        backButton.setForeground(new Color(80, 80, 80));
        backButton.setPreferredSize(new Dimension(100, 35));
        
        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);
        
        // 组装主面板
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setBackground(new Color(240, 240, 245));
        centerPanel.add(rolePanel);
        centerPanel.add(formPanel);
        centerPanel.add(buttonPanel);
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // 添加事件监听器
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAction(e);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToLoginAction(e);
            }
        });

        // 设置窗口属性
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * 注册事件处理
     *
     * @param event 事件对象
     */
    private void registerAction(ActionEvent event) {
        String username = this.usernameText.getText();
        String password = new String(this.passwordText.getPassword());
        String confirmPassword = new String(this.confirmPasswordText.getPassword());
        
        if (StringUtil.isEmpty(username)) {
            JOptionPane.showMessageDialog(this, "用户名不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(this, "密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (StringUtil.isEmpty(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "确认密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 默认注册为读者角色
        User user = new User(username, password, "user");
        Connection connection = null;
        
        try {
            connection = databaseUtil.getConnection();
            boolean success = userDao.register(connection, user);
            
            if (success) {
                JOptionPane.showMessageDialog(this, "注册成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                // 注册成功后返回登录界面
                this.dispose();
                new LoginView();
            } else {
                JOptionPane.showMessageDialog(this, "用户名已存在", "错误", JOptionPane.ERROR_MESSAGE);
            }
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库连接错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 返回登录界面事件处理
     *
     * @param event 事件对象
     */
    private void backToLoginAction(ActionEvent event) {
        this.dispose();
        new LoginView();
    }
} 