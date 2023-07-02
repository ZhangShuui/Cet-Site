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
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
/*!50503 SET character_set_client = utf8 */;
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
  `writingW` varchar(2000) DEFAULT NULL,
  `grading_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_answer`
--

LOCK TABLES `soft_answer` WRITE;
/*!40000 ALTER TABLE `soft_answer` DISABLE KEYS */;
INSERT INTO `soft_answer` VALUES (1,1,'A','B','C','D','A','B','C','D','A','B','SADDA','GFDS','已完成'),(2,3,'A','B','C','C','D','B','A','D','B','C','Spring Festival couplets are an important custom for Chinese to celebrate the Spring Festival. The spring coupling consists of a pair of verses and a four-character horizontal scroll, written in gold or black on red paper, red for luck and gold for wealth. Spring couplings are attached to the left and right sides of the gate and above the door frame. The verses of the Spring Union reflect the characteristics of traditional Chinese poetry, and the two poems have the same number of words and related content. The horizontal criticism highlights the theme of the Spring Coupling, which is the icing on the cake. Spring coupling depicts vivid images in concise words and expresses good wishes. When every household sticks the Spring Festival couplings, people will realize that the Spring Festival has officially begun.','Today, more and more people begin to realize the pleasures and joys of real-world social interaction. In a world that has become increasingly digital, with social media dominating our lives, the value of face-to-face human connection cannot be overstated.\nOne of the main pleasures of real-world social interaction is the ability to engage in meaningful conversations. When we interact with others in person, we can see their facial expressions, hear the tone of their voice, and feel their emotions. This creates a deeper level of understanding and empathy, which is often lacking in online interactions. Furthermore, real-world social interaction allows for spontaneous and dynamic exchanges, fostering creativity and innovation.\nAnother joy of real-world social interaction is the opportunity to engage in shared experiences. Whether it is going to a concert, attending a sporting event, or simply gathering with friends for a meal, being physically present with others enhances our enjoyment and creates lasting memories. The laughter, camaraderie, and sense of belonging that come from these shared experiences are unparalleled.\nReal-world social interaction also promotes mental and emotional well-being. Studies have shown that face-to-face interactions reduce stress, combat loneliness, and increase happiness. Engaging in real-world social activities allows us to disconnect from our screens, be fully present in the moment, and build authentic relationships.\nIn conclusion, amid the digital age, the pleasures and joys of real-world social interaction are being recognized and treasured. Meaningful conversations, shared experiences, and mental well-being are just a few of the benefits that come from engaging with others in person. As we navigate the future, let us not forget the invaluable role that genuine human connection plays in our lives.','未完成');
/*!40000 ALTER TABLE `soft_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_apply`
--

DROP TABLE IF EXISTS `soft_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `soft_apply` (
  `exam_id` int NOT NULL,
  `user_id` int NOT NULL,
  `payment_status` varchar(10) DEFAULT NULL,
  `application_time` varchar(100) NOT NULL,
  `score` int DEFAULT NULL,
  `test_id` int DEFAULT NULL,
  PRIMARY KEY (`exam_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_apply`
--

LOCK TABLES `soft_apply` WRITE;
/*!40000 ALTER TABLE `soft_apply` DISABLE KEYS */;
INSERT INTO `soft_apply` VALUES (1,1,'已支付','2023-07-02T10:50:33.305952100',132,1),(2,3,'已支付','2023-07-02T10:01:31.404860',140,2),(3,3,'已支付','2023-07-02T10:50:33.305952100',-1,1);
/*!40000 ALTER TABLE `soft_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_examinfo`
--

DROP TABLE IF EXISTS `soft_examinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
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
INSERT INTO `soft_examinfo` VALUES (1,'2023-07-01 21:19:07',1),(2,'2023-07-02 06:19:07',2),(3,'2023-07-10 02:13:40',1);
/*!40000 ALTER TABLE `soft_examinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_paper`
--

DROP TABLE IF EXISTS `soft_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_paper`
--

LOCK TABLES `soft_paper` WRITE;
/*!40000 ALTER TABLE `soft_paper` DISABLE KEYS */;
INSERT INTO `soft_paper` VALUES (1,'What does the author say is the issue all major economic powers have to address?$$How to ensure the sustainable growth of their tech giants.$$How to keep the competitiveness of their tech companies.$$How to break up the powerful giant tech companies.$$How to stop tech companies from gaining monopoly','D','What does the suspension of Ant Group Co.’s stock offering suggest?$$All attempts to evade regulation are doomed to failure.$$All attempts to monopolize sales must be cracked down.$$All companies must be regulated by the government.$$All companies, domestic or foreign, are created equal. ','C','How are smaller companies impacted by tech giants’ business expansion?$$They can no longer do business independent of tech giants.$$They are frequently denied access to tech giants’ platforms.$$They have to change marketing strategies to keep customers.$$They no longer have the power to price their own products. ','A','What have EU countries done to confront the power of digital giants?$$They have imposed strict regulation over digital giants’ advertising.$$They have considered regulatory action to promote fair competition.$$They have limited sales of digital giants’ products.$$They have sought to protect consumers’ privacy. ','B','What do Americans generally think of social media companies according to the author?$$They are invading people’s privacy.$$They are becoming untrustworthy.$$They are increasingly influential.$$They are growing out of control.','B','The U.S. and China don’t agree on much these days. Germany and France share a border and a currency \nbut are frequently at odds. The U.K. and India like to march to their own drum. But there’s one issue on which all these countries see eye to eye: Technology companies are too big, too powerful, and too profitable. And that power is only likely to intensify, leaving governments with no choice but to confront it head-on by taking the companies to court, passing new competition laws, and perhaps even breaking up the tech giants. \nChina is the latest to implement an anti-trust crackdown, unveiling anti-monopoly rules last month.','Born from the accessibility of mass air travel, modern international tourism has been popularized as \n“holiday-making” in regions that offer comparative advantages of sand, sun and sea. Travel is often portrayed as a tool for personal growth and tourism as an economic motor for destination countries and cities. There is a tendency to assume that tourism is good for everyone involved. \nToday the big bang of tourism drives over 1.2 billion tourists across international borders annually. Many \npopular places are literally being loved to death. Recent protests in ports of call like Venice and Barcelona against disturbances created by cruise ships show the unfortunate consequences of emphasizing quantity over quality in tourism.','What is the popular assumption about international tourism?$$Its benefits may compensate for the adverse environmental consequences.$$Its rapid development is attributed to people’s improved living standard.$$It appeals to people in places with favorable geographical conditions.$$It contributes to the economy of destination countries and regions.','D','What do we learn from some studies about uncontrolled tourism development?$$It gives rise to an increase in mass confrontations.$$It inhibits the steady growth of local economy.$$It incurs local residents’ antagonism to tourists.$$It brings in a large chunk of mobile population. ','C','Why does the author say local residents of popular destinations often feel frustrated?$$They fall victim to social conflicts and environmental disturbances.$$They have little opportunity to enjoy themselves on cruise ships.$$They cannot find employment in multinational hotel chains.$$They do not think they benefit as much as they deserve. ','D','How does the author say local residents in destination communities respond to tourism activity?$$They endeavor to adapt to it.$$They immerse tourists in their culture.$$They readily adopt new lifestyles.$$They try to upgrade their business models. ','B','贴春联 ( Spring Festival couplets)是中国人欢度春节的一个重要习俗。春联由一对诗句和四字横 \n批 ( horizontal scroll)组成，诗句和横批用金色或黑色写在红纸上，红色代表幸运，金色代表财富。 \n春联贴在大门左右两侧和门框上方。春联的诗句体现中国传统诗词的特点，两句诗的字数相同、内容 \n相关。横批凸显春联的主题，更是锦上添花。春联以简洁的文字描绘生动的形象，抒发美好的愿望。 \n当家家户户贴春联时，人们就会意识到春节已经正式拉开序幕。','Directions: For this part, you are allowed 3 0 minutes to write an essay that begins with the sentence “Today more and more people begin to realize the pleasures and joys of real- world social interaction. ” You can make comments, cite examples or use your personal experiences to develop your essay. You should write at least 150 words but no more than 200 words.','A','What can tourists do to exert more positive impacts on the tourist destinations?$$Show interest in local customs and lifestyles.$$Use the services provided by local businesses.$$Seek possibilities to invest in local companies.$$Give favorable comments about their services.'),(2,'What does the author intend to show by citing the findings from the report published \nlast year?$$People seldom appeal to rationality in their thinking.$$It is often the case that truth lies in the hands of a few.$$Common sense and science are the two sides of a coin.$$Few people know if climate change is really happening. ','A','What is the appeal to common sense according to the author?$$It is the basis for the internalisation of individuals9 ideologies.$$It is a series of conceptions formulated from complex reasoning.$$It is collective wisdom that helps people interact with new ideas.$$It is something subjective based on what one perceives to be right.','D','What does Daniel Kahneman think is the problem of testing new ideas with existing beliefs?$$It may lead to incorrect judgment.$$It makes no use of common sense.$$It fails to correct mistakes through serious reasoning.$$It can produce psychologically unacceptable outcomes.','A','What can we do to be less susceptible to cognitive biases?$$Give equal weight to evidence of both sides in a conflict.$$Provide convincing examples in developing an argument.$$Establish socially shared cognition via scientific methods.$$Avoid inconsistencies when addressing controversial issues.','C','What message does the author try to convey at the end of the passage?$$Multiple perspectives stimulate people\'s interest in exploring the unknown.$$Individuals can enhance their overall capabilities by interacting with others.$$Individuals should think freely to break from the restrictions of common sense.$$Collaborative efforts can overcome individuals limitations in scientific inquiry.','D','When a group of Australians was asked why they believed climate change was not \nhappening, about 36% said it was “common sense”, according to a report published last year by the Commonwealth Scientific and Industrial Research Organization. This was the most popular reason fbr their opinion, with only 11% saying their belief that climate change was not happening was based on scientific research. \nBut what do we mean by an appeal to common sense? Presumably it\'s an appeal to \nrationality of some sort that forms the basis of more complex reasoning. The appeal to \ncommon sense, however, is usually nothing more than an appeal to thinking that just feels right, but what feels right to one person may not feel right to another. Whether it feels right is usually a reflection of the world view and ideologies we have internalised, and that frames how we interact with new ideas. When new ideas are in accord with what we already believe, they are more readily accepted. When they are not, they, and the arguments that lead to them, are more readily rejected.','Selective colleges and universities in the U.S. are under fire for being too elite and too \nexpensive, and for not training graduates for the world of work. Such charges ignore the fact that these institutions continue to prepare students for success in their work, for thoughtful engagement in civic life, for lifelong learning, and for understanding the world and those with whom they live. \nThese colleges and universities must be doing something right. Applications are at \nrecord highs, and their financial aid programs make them more accessible than ever. This model of education has long played a central role in creating opportunity, driving economic growth, and spurring innovation. \nYet, there is growing skepticism about the value of this model. The recent tax reform \nbill is a wake-up call that our strongest colleges and universities are under assault by some in government. The initial proposals would have made education unaffordable for many by taxing tuition waivers for graduate students and ending deductions for student loan interest. \nThankfully, these provisions were ultimately stripped from the bill, but lawmakers let stand a new tax on the investment income of some colleges and universities. \nWhile these attacks are motivated by misguided ideas, we need to do a better job of \nexplaining why these claims are false and why what we do is valuable. We cannot take for granted that any of this is obvious.','What fact does the author emphasize concerning selective colleges and universities?$$They have been ignoring the training of graduates for the world of work.$$They have been doing well in ensuring their students a successful future.$$They have been constantly attacked for being too elite and too expensive.$$They have been actively engaged in civic life beyond the school campus.','B','What does the author say in arguing for the model of education in the U.S.?$$It has contributed substantially to the nation\'s overall development.$$It has succeeded in maintaining sustainable financial aid programs.$$It has given priority to innovative programs for graduate studies.$$It has played a central role in attracting international applicants.','A','What do we learn about the initial proposals concerning the recent tax reform bill?$$They would have stripped many students of life\'s chances.$$They would have deducted graduate student loan interest.$$They would have added to many students5 financial burden.$$They would have increased the number of tuition waivers.','C','What do the data show about elite colleges and universities?$$Their graduates lack the rigor required for doing statistical analysis.$$Their students prove to be inadequately prepared for their future careers.$$Their focus on research is conducive to developing students9 critical thinking.$$Their liberal arts education enables graduates to excel in whatever field they are in.','B','卢沟桥位于天安门广场西南15公里处，横跨永定河，是北京现存最古老的多拱石桥。 \n卢沟桥最初建成于1192年 ，1698年重建，由 281根柱子支撑。每根柱子上都有一头石狮。 \n这些石狮的头、背、腹部或爪子上都藏着更多的狮子。这些石狮生动逼真、千姿百态，是 \n卢沟桥石刻艺术的精品。桥上的石狮不计其数，因而北京地区流传着“卢沟桥上的石狮子—— \n数不清”的说法。 \n卢沟桥不仅以其美学特征闻名于世，还被公认为石桥建筑史上的一座丰碑。','Directions: For this part, you are allowed 30 minutes to write an essay that begins with the \nsentence “Nowadays more and more people choose to live an environmentally friendly \nlifestyle.99 You can make comments, cite examples, or use your personal experiences to develop \nyour essay. You should write at least 150 words but no more than 200 words. ','D','What is an advantage of providing financial aid for students?$$Every student can choose the institution they wish to attend.$$All students can benefit from a diversified student population.$$All students will be able to earn a place on university campus.$$Less privileged students will be more competitive at elite schools.'),(4,' How do some musicians perceive using AI in creating music?$$ It would help to produce more music idols.$$ It would be detrimental to music production$$It would hinder the understanding of authentic music$$ It would be the beginning of a new era in music creation','B',' What does Taryn Southern\'s story illustrate?$$AI technology is conducive to music composition$$Musicians will be unable to create music without high tech$$Musicians are often at their wits, end in their creative effor$$AI technology is indispensable to creating melodies and chords','A','Why are some musicians opposed to the use of AI in creating music?$$Music produced with AI technology lacks humanness$$Music created with AI technology is easily emulated$$ It will depreciate humans9 role in music composition.$$ It will deplete young musicians, creative inspiration.','A',' Why do many people think music is too precious to impart to AI technology$$ It cannot be created without pains$$ It cannot be produced at random.$$ It is part of human life$$ It is human specific','D',' What does the author think of the future of AI music?$$ It will continue to arouse the interest of music investors.$$ It has the prospect of becoming the norm in the future$$ It will be gradually accepted by old-school musicians$$ It may eventually lose its freshness and appeal.','B','Since American idol star Taryn Southern started composing music with AI in 2017,\nmusicians all over the world have begun wondering about the implications of AI and\nmodem technology where music production is concerned. Using AI in the creation of music\nis perceived by some as a helpful tool and by others as almost cc\nthe beginning of the end”.','A few weeks ago, a well-meaning professor tried to explain the physiological process\nbehind viruses and the human body in a tweet and was immediately criticized for a mistake\nin his information. He then issued an apology and deleted his erroneous tweet.\nCommunicating science beyond the academic bubble is necessary to augmenting\npublic understanding of health and environmental issues and helping individuals make\nwell-informed personal decisions.',' What does the author say about communicating science to the general public?$$ It will help them to keep abreast of the latest scientific developments.$$ It is a necessary means to improve their understanding of scientific issues.$$ It will get them more involved in academic debates on environmental problems.$$ It is an effective way to augment scientists9  influence beyond the academic circle','B',' What does the author advise scientists do to deal with topics outside of their specialty$$ Write or present on them from new angles$$ Utilize information from diverse sources.$$ Turn to a specialist for professional help$$ Fact-check with colleagues in their field.','C',' What does the author say we can learn from social media?$$A solid academic foundation is essential to understanding baffling scientific principles$$Modem technology has facilitated communication between scientists and the public$$ Scientific articles have gained increasing popularity among the general public.$$ The public\'s understanding of science is much better than some have claimed.','D',' What does the example of the biologist who shared an intricate analogy show$$ It is helpful to use illustrations in explaining scientific phenomena.$$ It is imperative to have appropriate titles to explain scientific issues$$ A learned scholar is not necessarily a qualified science communicator.$$A nonscientific audience cannot duly understand principles of science','D','南京长江大桥是长江上首座由中国设计、采用国产材料建造的铁路、公路两用桥，上层\n的 4 车道公路桥长4589米，下层的双轨道铁路桥长6772米。铁路桥连接原来的天津一浦口\n和上海一南京两条铁路线，使火车过江从过去一个半小时缩短为现在的2 分钟。大桥是南北\n交通的重要枢纽，也是南京的著名景点之一。\n南京长江大桥的建成标志着中国桥梁建设的一个飞跃，大大方便了长江两岸的物资交流\n和人员来往，对促进经济发展和改善人民生活起到了巨大作用。','Directions: For this part, you are allowed 30 minutes to write an essay that begins with the\nsentence “Nowadays more and more people keep learning new skills to adapt to a\nfast-changing world.\" You can make comments, cite examples, or use your personal experiences\nto develop your essay. You should write at least 150 words but no more than 200 words.','C',' What does the author suggest scientists do to close the gap between science and society?$$ Explain complex concepts scientifically.$$ Make appropriate use of scientific terms.$$ Take courses in public speaking$$ Develop communication skills.');
/*!40000 ALTER TABLE `soft_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_teacher`
--

DROP TABLE IF EXISTS `soft_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `soft_teacher` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  `teacher_id` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
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
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `soft_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `isStu` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_user`
--

LOCK TABLES `soft_user` WRITE;
/*!40000 ALTER TABLE `soft_user` DISABLE KEYS */;
INSERT INTO `soft_user` VALUES (1,'1262426565@qq.com','admin','$2a$10$7F6Xeb/NFJ.o4y8qYAYMTu0/fRTVRKKt1jRcP9CwIpSEsXyjKN75u',1),(2,'zhangshuui@gmail.com','杨飓风','$2a$10$Ks/E4dMUXST5w6QSW9MD/ekrw.0kDISYl3anq2owKVTAP4Gb8QuLK',0),(3,'moqiji1011@163.com','莫骐骥','$2a$10$K/8CuuxiwTREQzqbXsnvH.1nZQNzJj2yGhkw9Zju3xggMPUXT4uCu',1),(4,'moqiji@outlook.com','马宝国','$2a$10$29JfqpeA7W1HcWtGlsJClu9OmUCgKeDjQaEbhWy0WQJ7ZPWdKZqny',0);
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
