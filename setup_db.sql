CREATE DATABASE IF NOT EXISTS db_librarymanagementsystem;
USE db_librarymanagementsystem;

CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_user` (`username`, `password`, `role`) VALUES
('admin', 'admin', 'admin'),
('user', 'user', 'user');

CREATE TABLE IF NOT EXISTS `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'available',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_book` (`name`, `author`, `publisher`, `category`, `status`) VALUES
('Java编程思想', 'Bruce Eckel', '机械工业出版社', '计算机', 'available'),
('C++程序设计', 'Stanley B. Lippman', '清华大学出版社', '计算机', 'available'),
('深入理解计算机系统', 'Randal E. Bryant', '机械工业出版社', '计算机', 'available'); 