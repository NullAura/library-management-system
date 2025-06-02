package com.library.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 管理员界面类
 */
public class AdminView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JPanel contentPanel;

    /**
     * 构造函数，初始化管理员界面
     */
    public AdminView() {
        // 设置窗口属性
        super("图书管理系统 - 管理员界面");
        setBounds(200, 100, 900, 600);
        setLocationRelativeTo(null);
        
        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
        menuBar.setBackground(new Color(245, 245, 250));
        
        // 创建菜单1：图书编目
        JMenu catalogMenu = new JMenu("图书编目");
        catalogMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem addBookItem = new JMenuItem("新书录入");
        JMenuItem editBookItem = new JMenuItem("信息修改");
        JMenuItem searchBookItem = new JMenuItem("图书检索");
        
        styleMenuItem(addBookItem);
        styleMenuItem(editBookItem);
        styleMenuItem(searchBookItem);
        
        catalogMenu.add(addBookItem);
        catalogMenu.add(editBookItem);
        catalogMenu.add(searchBookItem);

        // 创建菜单2：图书征订
        JMenu orderMenu = new JMenu("图书征订");
        orderMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem addOrderItem = new JMenuItem("征订录入");
        JMenuItem editOrderItem = new JMenuItem("征订修改");
        JMenuItem deleteOrderItem = new JMenuItem("征订删除");
        
        styleMenuItem(addOrderItem);
        styleMenuItem(editOrderItem);
        styleMenuItem(deleteOrderItem);
        
        orderMenu.add(addOrderItem);
        orderMenu.add(editOrderItem);
        orderMenu.add(deleteOrderItem);

        // 创建菜单3：读者信息
        JMenu readerMenu = new JMenu("读者信息");
        readerMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem addReaderItem = new JMenuItem("读者录入");
        JMenuItem editReaderItem = new JMenuItem("信息修改");
        JMenuItem deleteReaderItem = new JMenuItem("读者删除");
        
        styleMenuItem(addReaderItem);
        styleMenuItem(editReaderItem);
        styleMenuItem(deleteReaderItem);
        
        readerMenu.add(addReaderItem);
        readerMenu.add(editReaderItem);
        readerMenu.add(deleteReaderItem);
        
        // 创建菜单4：情况分析
        JMenu analysisMenu = new JMenu("情况分析");
        analysisMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem borrowAnalysisItem = new JMenuItem("借阅统计");
        JMenuItem inventoryAnalysisItem = new JMenuItem("库存分析");
        JMenuItem popularBooksItem = new JMenuItem("热门图书");
        
        styleMenuItem(borrowAnalysisItem);
        styleMenuItem(inventoryAnalysisItem);
        styleMenuItem(popularBooksItem);
        
        analysisMenu.add(borrowAnalysisItem);
        analysisMenu.add(inventoryAnalysisItem);
        analysisMenu.add(popularBooksItem);
        
        // 创建菜单5：我的
        JMenu myMenu = new JMenu("我的");
        myMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JMenuItem profileItem = new JMenuItem("个人信息");
        JMenuItem changePasswordItem = new JMenuItem("修改密码");
        JMenuItem logoutItem = new JMenuItem("退出系统");
        
        styleMenuItem(profileItem);
        styleMenuItem(changePasswordItem);
        styleMenuItem(logoutItem);
        
        myMenu.add(profileItem);
        myMenu.add(changePasswordItem);
        myMenu.addSeparator();
        myMenu.add(logoutItem);
        
        // 添加菜单到菜单栏
        menuBar.add(catalogMenu);
        menuBar.add(orderMenu);
        menuBar.add(readerMenu);
        menuBar.add(analysisMenu);
        menuBar.add(myMenu);
        
        // 设置退出系统事件
        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                    AdminView.this, 
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
        
        JLabel welcomeLabel = new JLabel("欢迎使用图书管理系统 - 管理员模式", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("微软雅黑", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(153, 51, 102));
        welcomeLabel.setBorder(new EmptyBorder(30, 0, 30, 0));
        
        // 创建功能面板
        JPanel functionPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        functionPanel.setBackground(new Color(250, 250, 252));
        
        // 添加功能卡片
        functionPanel.add(createFunctionCard("图书编目", "管理图书信息和分类", new Color(255, 240, 245)));
        functionPanel.add(createFunctionCard("图书征订", "管理图书采购和征订", new Color(240, 255, 240)));
        functionPanel.add(createFunctionCard("读者信息", "管理读者账户和权限", new Color(240, 248, 255)));
        functionPanel.add(createFunctionCard("借阅管理", "处理借阅和归还请求", new Color(255, 250, 240)));
        functionPanel.add(createFunctionCard("情况分析", "图书借阅和库存统计", new Color(245, 245, 255)));
        functionPanel.add(createFunctionCard("系统设置", "配置系统参数和备份", new Color(255, 245, 238)));
        
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
        
        SwingUtilities.invokeLater(() -> new AdminView());
    }
} 