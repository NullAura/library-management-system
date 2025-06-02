package com.library.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 读者界面类
 */
public class ReaderView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JPanel contentPanel;

    /**
     * 构造函数，初始化读者界面
     */
    public ReaderView() {
        // 设置窗口属性
        super("图书管理系统 - 读者界面");
        setBounds(200, 100, 900, 600);
        setLocationRelativeTo(null);
        
        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
        menuBar.setBackground(new Color(245, 245, 250));
        
        // 创建菜单1：图书检索
        JMenu searchMenu = new JMenu("图书检索");
        searchMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem searchByTitleItem = new JMenuItem("按书名检索");
        JMenuItem searchByAuthorItem = new JMenuItem("按作者检索");
        JMenuItem searchByIsbnItem = new JMenuItem("按ISBN检索");
        
        styleMenuItem(searchByTitleItem);
        styleMenuItem(searchByAuthorItem);
        styleMenuItem(searchByIsbnItem);
        
        searchMenu.add(searchByTitleItem);
        searchMenu.add(searchByAuthorItem);
        searchMenu.add(searchByIsbnItem);

        // 创建菜单2：图书申请
        JMenu requestMenu = new JMenu("图书申请");
        requestMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem borrowItem = new JMenuItem("借阅申请");
        JMenuItem returnItem = new JMenuItem("归还图书");
        JMenuItem renewItem = new JMenuItem("续借申请");
        JMenuItem reserveItem = new JMenuItem("预约图书");
        
        styleMenuItem(borrowItem);
        styleMenuItem(returnItem);
        styleMenuItem(renewItem);
        styleMenuItem(reserveItem);
        
        requestMenu.add(borrowItem);
        requestMenu.add(returnItem);
        requestMenu.add(renewItem);
        requestMenu.add(reserveItem);

        // 创建菜单3：我的
        JMenu myMenu = new JMenu("我的");
        myMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem profileItem = new JMenuItem("个人信息");
        JMenuItem historyItem = new JMenuItem("借阅历史");
        JMenuItem logoutItem = new JMenuItem("退出系统");
        
        styleMenuItem(profileItem);
        styleMenuItem(historyItem);
        styleMenuItem(logoutItem);
        
        myMenu.add(profileItem);
        myMenu.add(historyItem);
        myMenu.addSeparator();
        myMenu.add(logoutItem);
        
        // 添加菜单到菜单栏
        menuBar.add(searchMenu);
        menuBar.add(requestMenu);
        menuBar.add(myMenu);
        
        // 设置退出系统事件
        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                    ReaderView.this, 
                    "确定要退出系统吗?", 
                    "确认退出", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (result == JOptionPane.YES_OPTION) {
                    dispose();
                    new LoginView();
                }
            }
        });
        
        // 创建主内容面板
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(new Color(250, 250, 252));
        
        // 创建欢迎面板
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(new Color(250, 250, 252));
        
        JLabel welcomeLabel = new JLabel("欢迎使用图书管理系统", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("微软雅黑", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(51, 102, 153));
        welcomeLabel.setBorder(new EmptyBorder(30, 0, 30, 0));
        
        // 创建功能面板
        JPanel functionPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        functionPanel.setBackground(new Color(250, 250, 252));
        
        // 添加功能卡片
        functionPanel.add(createFunctionCard("图书检索", "快速查找您需要的图书", new Color(230, 240, 250)));
        functionPanel.add(createFunctionCard("借阅申请", "申请借阅您感兴趣的图书", new Color(230, 250, 240)));
        functionPanel.add(createFunctionCard("归还图书", "归还已借阅的图书", new Color(250, 240, 230)));
        functionPanel.add(createFunctionCard("个人信息", "查看和修改您的个人信息", new Color(240, 230, 250)));
        
        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomePanel.add(functionPanel, BorderLayout.CENTER);
        
        contentPanel.add(welcomePanel, BorderLayout.CENTER);
        
        // 设置窗口属性
        setJMenuBar(menuBar);
        add(contentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    /**
     * 设置菜单项样式
     *
     * @param item 菜单项
     */
    private void styleMenuItem(JMenuItem item) {
        item.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        item.setBackground(Color.WHITE);
    }
    
    /**
     * 创建功能卡片
     *
     * @param title 卡片标题
     * @param description 功能描述
     * @param bgColor 背景颜色
     * @return 卡片面板
     */
    private JPanel createFunctionCard(String title, String description, Color bgColor) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        card.setBackground(bgColor);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        titleLabel.setForeground(new Color(60, 60, 60));
        
        JLabel descLabel = new JLabel(description);
        descLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        descLabel.setForeground(new Color(100, 100, 100));
        descLabel.setBorder(new EmptyBorder(5, 0, 0, 0));
        
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        textPanel.setOpaque(false);
        textPanel.add(titleLabel);
        textPanel.add(descLabel);
        
        card.add(textPanel, BorderLayout.CENTER);
        
        return card;
    }

    /**
     * 程序入口(用于测试)
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> new ReaderView());
    }
} 