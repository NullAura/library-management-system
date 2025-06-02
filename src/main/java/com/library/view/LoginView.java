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
 * 登录界面
 */
public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JRadioButton managerRadioButton;
    private JRadioButton readerRadioButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton resetButton;
    
    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private UserDao userDao = new UserDao();

    /**
     * 构造函数，初始化登录界面
     */
    public LoginView() {
        // 设置窗口属性
        super("图书管理系统");
        setBounds(400, 400, 450, 350);
        setLocationRelativeTo(null);
        
        // 创建主面板，使用BorderLayout布局
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 245));
        
        // 创建标题面板
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(240, 240, 245));
        JLabel titleLabel = new JLabel("图书管理系统");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 102, 153));
        titlePanel.add(titleLabel);
        
        // 创建角色选择面板
        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        rolePanel.setBackground(new Color(240, 240, 245));
        managerRadioButton = new JRadioButton("管理员");
        readerRadioButton = new JRadioButton("读者");
        
        // 设置单选按钮样式
        managerRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        readerRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        managerRadioButton.setBackground(new Color(240, 240, 245));
        readerRadioButton.setBackground(new Color(240, 240, 245));
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(managerRadioButton);
        bg.add(readerRadioButton);
        rolePanel.add(managerRadioButton);
        rolePanel.add(readerRadioButton);
        
        // 创建登录表单面板
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBackground(new Color(240, 240, 245));
        
        // 设置标签和文本框
        usernameLabel = new JLabel("用户名:");
        usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameText = new JTextField(15);
        passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordText = new JPasswordField(15);
        
        // 添加边框和圆角
        usernameText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        passwordText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        // 组装表单
        formPanel.add(usernameLabel);
        formPanel.add(usernameText);
        formPanel.add(passwordLabel);
        formPanel.add(passwordText);
        
        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(240, 240, 245));
        
        // 设置按钮样式
        loginButton = new JButton("登录");
        resetButton = new JButton("重置");
        
        loginButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        resetButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.BLACK);
        loginButton.setPreferredSize(new Dimension(100, 35));
        
        resetButton.setBackground(new Color(220, 220, 220));
        resetButton.setForeground(new Color(80, 80, 80));
        resetButton.setPreferredSize(new Dimension(100, 35));
        
        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);
        
        // 组装主面板
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setBackground(new Color(240, 240, 245));
        centerPanel.add(rolePanel);
        centerPanel.add(formPanel);
        centerPanel.add(buttonPanel);
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // 添加事件监听器
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction(e);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAction(e);
            }
        });

        // 设置窗口属性
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * 登录事件处理
     *
     * @param event 事件对象
     */
    private void loginAction(ActionEvent event) {
        String username = this.usernameText.getText();
        String password = new String(this.passwordText.getPassword());
        
        if (!managerRadioButton.isSelected() && !readerRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "请选择你的身份", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (StringUtil.isEmpty(username)) {
            JOptionPane.showMessageDialog(this, "用户名不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(this, "密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        User user = new User(username, password);
        Connection connection = null;
        
        try {
            connection = databaseUtil.getConnection();
            User currentUser = userDao.login(connection, user);
            
            if (currentUser != null) {
                if (managerRadioButton.isSelected()) {
                    this.dispose();
                    new AdminView();
                } else if (readerRadioButton.isSelected()) {
                    this.dispose();
                    new ReaderView();
                }
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
            }
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "数据库连接错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 重置事件处理
     *
     * @param event 事件对象
     */
    private void resetAction(ActionEvent event) {
        this.usernameText.setText("");
        this.passwordText.setText("");
    }

    /**
     * 程序入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> new LoginView());
    }
} 