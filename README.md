# 图书管理系统

一个基于Java Swing的图书管理系统，具有现代化的界面设计和完整的图书管理功能。

## 功能特点

- 多角色用户认证（管理员和读者）
- 图书信息管理
- 图书检索和浏览
- 用户友好的操作界面
- 数据库持久化存储

## 技术栈

- Java SE 8+
- Java Swing (GUI界面)
- JDBC (数据库连接)
- MySQL 9.x (数据库)
- Maven (项目构建与依赖管理)

## 项目结构

```
library-management-system/
├── src/main/java/com/library/
│   ├── dao/          - 数据访问对象
│   ├── model/        - 数据模型
│   ├── util/         - 工具类
│   ├── view/         - 图形界面
│   └── test/         - 测试类
├── target/           - 构建输出
├── pom.xml           - Maven配置
├── setup_db.sql      - 数据库初始化脚本
└── README.md         - 项目说明
```

## 数据库设计

系统使用MySQL数据库，主要表结构包括：

- `t_user`: 用户信息表，存储用户名、密码和角色
- `t_book`: 图书信息表，包含书名、作者、出版社、分类和状态

## 安装与配置

### 环境要求

- JDK 1.8或更高版本
- Maven 3.6或更高版本
- MySQL 9.x或更高版本

### 数据库配置

1. 确保MySQL服务已启动
2. 使用以下命令创建并初始化数据库：

```bash
mysql -u root -p < setup_db.sql
```

3. 修改数据库连接配置（如有必要）：
   - 文件位置：`src/main/java/com/library/util/DatabaseUtil.java`
   - 配置项：数据库URL、用户名、密码

### 构建与运行

1. 使用Maven构建项目：

```bash
mvn clean package
```

2. 运行程序：

```bash
# 方法1：直接使用Java命令
java -cp "target/classes:target/dependency/*" com.library.view.LoginView

# 方法2：使用打包后的JAR
java -jar target/library-management-system-1.0.0-jar-with-dependencies.jar
```

## 默认账户

系统预设了以下账户供测试使用：

- **管理员账户**：
  - 用户名：admin
  - 密码：admin
  - 角色：admin

- **普通用户账户**：
  - 用户名：user
  - 密码：user
  - 角色：user

## 使用说明

1. 启动程序后，选择您的身份（管理员或读者）
2. 使用对应的账户名和密码登录
3. 根据界面提示进行相关操作

## 常见问题

### 数据库连接错误

如果遇到数据库连接错误，请检查：
- MySQL服务是否正常运行
- 数据库连接配置是否正确
- 是否已创建所需的数据库和表

### 类路径错误

确保在正确的目录下运行命令，特别是使用相对路径时

## 贡献指南

欢迎提交问题报告和改进建议。如需贡献代码，请遵循以下步骤：
1. Fork本仓库
2. 创建您的特性分支
3. 提交您的更改
4. 推送到您的分支
5. 创建Pull Request

## 许可证

本项目采用MIT许可证 