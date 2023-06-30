-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2023-06-30 09:06:47
-- 服务器版本： 10.4.22-MariaDB
-- PHP 版本： 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `soft`
--

-- --------------------------------------------------------

--
-- 表的结构 `persistent_logins`
--

CREATE TABLE `persistent_logins` (
                                     `username` varchar(64) NOT NULL,
                                     `series` varchar(64) NOT NULL,
                                     `token` varchar(64) NOT NULL,
                                     `last_used` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 表的结构 `soft_apply`
--

CREATE TABLE `soft_apply` (
                              `exam_id` int(11) NOT NULL,
                              `user_id` int(11) NOT NULL,
                              `payment_status` varchar(10) DEFAULT NULL,
                              `application_time` varchar(20) NOT NULL,
                              `score` int(11) DEFAULT NULL,
                              `test_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 表的结构 `soft_teacher`
--

CREATE TABLE `soft_teacher` (
                                `id` int(11) NOT NULL,
                                `name` varchar(20) NOT NULL,
                                `teacher_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `soft_teacher`
--

INSERT INTO `soft_teacher` (`id`, `name`, `teacher_id`) VALUES
                                                            (1, '杨飓风', 'ABCDEF'),
                                                            (2, '马宝国', 'BCDEFG');

-- --------------------------------------------------------

--
-- 表的结构 `soft_user`
--

CREATE TABLE `soft_user` (
                             `id` int(11) NOT NULL,
                             `email` varchar(20) NOT NULL,
                             `username` varchar(30) NOT NULL,
                             `password` varchar(100) NOT NULL,
                             `isStu` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `soft_user`
--

INSERT INTO `soft_user` (`id`, `email`, `username`, `password`, `isStu`) VALUES
                                                                             (1, '1262426565@qq.com', 'admin', '$2a$10$7F6Xeb/NFJ.o4y8qYAYMTu0/fRTVRKKt1jRcP9CwIpSEsXyjKN75u', 1),
                                                                             (2, 'zhangshuui@gmail.com', '杨飓风', '$2a$10$Ks/E4dMUXST5w6QSW9MD/ekrw.0kDISYl3anq2owKVTAP4Gb8QuLK', 0),
                                                                             (3, 'moqiji1011@163.com', 'mqj', '$2a$10$K/8CuuxiwTREQzqbXsnvH.1nZQNzJj2yGhkw9Zju3xggMPUXT4uCu', 1),
                                                                             (4, 'moqiji@outlook.com', '马宝国', '$2a$10$29JfqpeA7W1HcWtGlsJClu9OmUCgKeDjQaEbhWy0WQJ7ZPWdKZqny', 0);

--
-- 转储表的索引
--

--
-- 表的索引 `persistent_logins`
--
ALTER TABLE `persistent_logins`
    ADD PRIMARY KEY (`series`);

--
-- 表的索引 `soft_apply`
--
ALTER TABLE `soft_apply`
    ADD PRIMARY KEY (`exam_id`,`user_id`);

--
-- 表的索引 `soft_teacher`
--
ALTER TABLE `soft_teacher`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `name` (`name`),
    ADD UNIQUE KEY `teacher_id` (`teacher_id`);

--
-- 表的索引 `soft_user`
--
ALTER TABLE `soft_user`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `email` (`email`),
    ADD UNIQUE KEY `username` (`username`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `soft_teacher`
--
ALTER TABLE `soft_teacher`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `soft_user`
--
ALTER TABLE `soft_user`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
