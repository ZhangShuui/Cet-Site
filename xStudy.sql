-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: soft
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
INSERT INTO `persistent_logins` VALUES ('mqj','6fHQaxtUpXmryMK63krvVg==','pBA9lFYF30mK/jIFFSCChA==','2023-06-30 19:14:11');
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_answer`
--

DROP TABLE IF EXISTS `soft_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_answer` (
  `exam_id` int NOT NULL,
  `user_id` int NOT NULL,
  `stu_choiceW1` char(1) DEFAULT NULL,
  `stu_choiceW2` char(1) DEFAULT NULL,
  `stu_choiceW3` char(1) DEFAULT NULL,
  `stu_choiceW4` char(1) DEFAULT NULL,
  `stu_choiceW5` char(1) DEFAULT NULL,
  `stu_choiceW6` char(1) DEFAULT NULL,
  `stu_choiceW7` char(1) DEFAULT NULL,
  `stu_choiceW8` char(1) DEFAULT NULL,
  `stu_choiceW9` char(1) DEFAULT NULL,
  `stu_choiceW10` char(1) DEFAULT NULL,
  `translationW` varchar(1000) DEFAULT NULL,
  `writingW` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_answer`
--

LOCK TABLES `soft_answer` WRITE;
/*!40000 ALTER TABLE `soft_answer` DISABLE KEYS */;
INSERT INTO `soft_answer` VALUES (1,1,'A','B','C','D','A','B','C','D','A','B','SADDA','GFDS'),(2,3,'','','','','','','','','','','','');
/*!40000 ALTER TABLE `soft_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_apply`
--

DROP TABLE IF EXISTS `soft_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_apply` (
  `exam_id` int NOT NULL,
  `user_id` int NOT NULL,
  `payment_status` varchar(10) DEFAULT NULL,
  `application_time` varchar(20) NOT NULL,
  `score` int DEFAULT NULL,
  `test_id` int DEFAULT NULL,
  PRIMARY KEY (`exam_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_apply`
--

LOCK TABLES `soft_apply` WRITE;
/*!40000 ALTER TABLE `soft_apply` DISABLE KEYS */;
INSERT INTO `soft_apply` VALUES (2,3,'已支付','上达到撒大',-1,1);
/*!40000 ALTER TABLE `soft_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_examinfo`
--

DROP TABLE IF EXISTS `soft_examinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_examinfo` (
  `exam_id` int NOT NULL COMMENT '考试编号',
  `start_time` timestamp NOT NULL COMMENT '考试开始时间',
  `test_id` int NOT NULL COMMENT '试卷编号',
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='考试信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_examinfo`
--

LOCK TABLES `soft_examinfo` WRITE;
/*!40000 ALTER TABLE `soft_examinfo` DISABLE KEYS */;
INSERT INTO `soft_examinfo` VALUES (1,'2023-06-30 08:51:59',1),(2,'2023-07-01 13:19:07',2);
/*!40000 ALTER TABLE `soft_examinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_paper`
--

DROP TABLE IF EXISTS `soft_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_paper` (
  `test_id` int NOT NULL AUTO_INCREMENT,
  `choiceQ1` varchar(700) NOT NULL,
  `choiceW1` char(1) DEFAULT NULL,
  `choiceQ2` varchar(700) DEFAULT NULL,
  `choiceW2` char(1) DEFAULT NULL,
  `choiceQ3` varchar(700) DEFAULT NULL,
  `choiceW3` char(1) DEFAULT NULL,
  `choiceQ4` varchar(700) DEFAULT NULL,
  `choiceW4` char(1) DEFAULT NULL,
  `choiceQ5` varchar(700) DEFAULT NULL,
  `choiceW5` char(1) DEFAULT NULL,
  `readingQ1` varchar(2000) DEFAULT NULL,
  `readingQ2` varchar(2000) DEFAULT NULL,
  `choiceQ6` varchar(700) DEFAULT NULL,
  `choiceW6` char(1) DEFAULT NULL,
  `choiceQ7` varchar(700) DEFAULT NULL,
  `choiceW7` char(1) DEFAULT NULL,
  `choiceQ8` varchar(700) DEFAULT NULL,
  `choiceW8` char(1) DEFAULT NULL,
  `choiceQ9` varchar(700) DEFAULT NULL,
  `choiceW10` char(1) DEFAULT NULL,
  `translationQ` varchar(1000) DEFAULT NULL,
  `writingQ` varchar(700) DEFAULT NULL,
  `choiceW9` char(1) DEFAULT NULL,
  `choiceQ10` varchar(700) DEFAULT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_paper`
--

LOCK TABLES `soft_paper` WRITE;
/*!40000 ALTER TABLE `soft_paper` DISABLE KEYS */;
INSERT INTO `soft_paper` VALUES (1,'What does the author say is the issue all major economic powers have to address?$$How to ensure the sustainable growth of their tech giants.$$How to keep the competitiveness of their tech companies.$$How to break up the powerful giant tech companies.$$How to stop tech companies from gaining monopoly','D','What does the suspension of Ant Group Co.’s stock offering suggest?$$All attempts to evade regulation are doomed to failure.$$All attempts to monopolize sales must be cracked down.$$All companies must be regulated by the government.$$All companies, domestic or foreign, are created equal. ','C','How are smaller companies impacted by tech giants’ business expansion?$$They can no longer do business independent of tech giants.$$They are frequently denied access to tech giants’ platforms.$$They have to change marketing strategies to keep customers.$$They no longer have the power to price their own products. ','A','What have EU countries done to confront the power of digital giants?$$They have imposed strict regulation over digital giants’ advertising.$$They have considered regulatory action to promote fair competition.$$They have limited sales of digital giants’ products.$$They have sought to protect consumers’ privacy. ','B','What do Americans generally think of social media companies according to the author?$$They are invading people’s privacy.$$They are becoming untrustworthy.$$They are increasingly influential.$$They are growing out of control.','B','The U.S. and China don’t agree on much these days. Germany and France share a border and a currency \nbut are frequently at odds. The U.K. and India like to march to their own drum. But there’s one issue on which all these countries see eye to eye: Technology companies are too big, too powerful, and too profitable. And that power is only likely to intensify, leaving governments with no choice but to confront it head-on by taking the companies to court, passing new competition laws, and perhaps even breaking up the tech giants. \nChina is the latest to implement an anti-trust crackdown, unveiling anti-monopoly rules last month.','Born from the accessibility of mass air travel, modern international tourism has been popularized as \n“holiday-making” in regions that offer comparative advantages of sand, sun and sea. Travel is often portrayed as a tool for personal growth and tourism as an economic motor for destination countries and cities. There is a tendency to assume that tourism is good for everyone involved. \nToday the big bang of tourism drives over 1.2 billion tourists across international borders annually. Many \npopular places are literally being loved to death. Recent protests in ports of call like Venice and Barcelona against disturbances created by cruise ships show the unfortunate consequences of emphasizing quantity over quality in tourism.','What is the popular assumption about international tourism?$$Its benefits may compensate for the adverse environmental consequences.$$Its rapid development is attributed to people’s improved living standard.$$It appeals to people in places with favorable geographical conditions.$$It contributes to the economy of destination countries and regions.','D','What do we learn from some studies about uncontrolled tourism development?$$It gives rise to an increase in mass confrontations.$$It inhibits the steady growth of local economy.$$It incurs local residents’ antagonism to tourists.$$It brings in a large chunk of mobile population. ','C','Why does the author say local residents of popular destinations often feel frustrated?$$They fall victim to social conflicts and environmental disturbances.$$They have little opportunity to enjoy themselves on cruise ships.$$They cannot find employment in multinational hotel chains.$$They do not think they benefit as much as they deserve. ','D','How does the author say local residents in destination communities respond to tourism activity?$$They endeavor to adapt to it.$$They immerse tourists in their culture.$$They readily adopt new lifestyles.$$They try to upgrade their business models. ','B','贴春联 ( Spring Festival couplets)是中国人欢度春节的一个重要习俗。春联由一对诗句和四字横 \n批 ( horizontal scroll)组成，诗句和横批用金色或黑色写在红纸上，红色代表幸运，金色代表财富。 \n春联贴在大门左右两侧和门框上方。春联的诗句体现中国传统诗词的特点，两句诗的字数相同、内容 \n相关。横批凸显春联的主题，更是锦上添花。春联以简洁的文字描绘生动的形象，抒发美好的愿望。 \n当家家户户贴春联时，人们就会意识到春节已经正式拉开序幕。','Directions: For this part, you are allowed 3 0 minutes to write an essay that begins with the sentence “Today more and more people begin to realize the pleasures and joys of real- world social interaction. ” You can make comments, cite examples or use your personal experiences to develop your essay. You should write at least 150 words but no more than 200 words.','A','What can tourists do to exert more positive impacts on the tourist destinations?$$Show interest in local customs and lifestyles.$$Use the services provided by local businesses.$$Seek possibilities to invest in local companies.$$Give favorable comments about their services.');
/*!40000 ALTER TABLE `soft_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_teacher`
--

DROP TABLE IF EXISTS `soft_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_teacher` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  `teacher_id` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_teacher`
--

LOCK TABLES `soft_teacher` WRITE;
/*!40000 ALTER TABLE `soft_teacher` DISABLE KEYS */;
INSERT INTO `soft_teacher` VALUES (1,'杨飓风','ABCDEF'),(2,'马宝国','BCDEFG'),(1,'杨飓风','ABCDEF'),(2,'马宝国','BCDEFG'),(1,'杨飓风','ABCDEF'),(2,'马宝国','BCDEFG');
/*!40000 ALTER TABLE `soft_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_user`
--

DROP TABLE IF EXISTS `soft_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `isStu` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_user`
--

LOCK TABLES `soft_user` WRITE;
/*!40000 ALTER TABLE `soft_user` DISABLE KEYS */;
INSERT INTO `soft_user` VALUES (1,'1262426565@qq.com','admin','$2a$10$7F6Xeb/NFJ.o4y8qYAYMTu0/fRTVRKKt1jRcP9CwIpSEsXyjKN75u',1),(2,'zhangshuui@gmail.com','杨飓风','$2a$10$Ks/E4dMUXST5w6QSW9MD/ekrw.0kDISYl3anq2owKVTAP4Gb8QuLK',0),(3,'moqiji1011@163.com','mqj','$2a$10$K/8CuuxiwTREQzqbXsnvH.1nZQNzJj2yGhkw9Zju3xggMPUXT4uCu',1),(4,'moqiji@outlook.com','马宝国','$2a$10$29JfqpeA7W1HcWtGlsJClu9OmUCgKeDjQaEbhWy0WQJ7ZPWdKZqny',0);
/*!40000 ALTER TABLE `soft_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-02  1:07:10
