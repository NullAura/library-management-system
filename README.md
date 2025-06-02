# 图书管理系统

一个基于Java Swing的图书管理系统，具有用户友好的图形界面和完整的功能集。

## 功能特点

- 用户认证系统（管理员和读者角色）
- 图书检索功能
- 图书借阅、归还、续借和预约管理
- 读者信息管理
- 图书编目管理
- 图书征订管理
- 借阅和库存分析统计

## 技术栈

- Java SE 8+
- Java Swing (GUI)
- JDBC (数据库连接)
- MySQL (数据库)
- Maven (项目管理)

## 项目结构

```
library-management-system/
├── src/main/java/com/library/
│   ├── dao/          - 数据访问对象
│   ├── model/        - 数据模型
│   ├── service/      - 业务逻辑
│   ├── util/         - 工具类
│   └── view/         - 图形界面
├── resources/        - 配置文件和资源
├── lib/              - 外部依赖库
├── pom.xml           - Maven配置
└── README.md         - 项目说明
```

## 数据库设计

系统使用MySQL数据库，主要表结构包括：

- `lmbuser`: 用户信息表
- `book`: 图书信息表
- `borrow_record`: 借阅记录表
- `reader`: 读者信息表
- `book_order`: 图书征订表

## 运行指南

### 环境要求

- JDK 1.8或更高版本
- Maven 3.6或更高版本
- MySQL 5.7或更高版本

### 安装步骤

1. 克隆项目到本地
2. 配置MySQL数据库
3. 修改数据库连接配置（`DatabaseUtil.java`）
4. 使用Maven构建项目：

```bash
mvn clean package
```

5. 运行生成的JAR包：

```bash
java -jar target/library-management-system-1.0.0-jar-with-dependencies.jar
```

## 默认账户

- 管理员：admin/123456
- 读者：reader/123456

## 项目截图

（此处可添加系统各界面的截图）

## 许可证

本项目使用MIT许可证 