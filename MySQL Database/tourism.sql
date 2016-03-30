-- MySQL dump 10.13  Distrib 5.7.11, for Win64 (x86_64)
--
-- Host: localhost    Database: tourism
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_act_comment`
--

DROP TABLE IF EXISTS `t_act_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_act_comment` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_act_id` varchar(32) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_username` (`_username`),
  KEY `_act_id` (`_act_id`),
  CONSTRAINT `t_act_comment_ibfk_1` FOREIGN KEY (`_username`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_act_comment_ibfk_2` FOREIGN KEY (`_act_id`) REFERENCES `t_activity` (`_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_act_comment`
--

LOCK TABLES `t_act_comment` WRITE;
/*!40000 ALTER TABLE `t_act_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_act_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_activity`
--

DROP TABLE IF EXISTS `t_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_activity_id` varchar(32) NOT NULL,
  `_company_id` varchar(32) NOT NULL,
  `_activity_name` varchar(20) NOT NULL,
  `_age_range` varchar(10) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_destination` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`_activity_id`),
  UNIQUE KEY `_id` (`_id`),
  KEY `_company_id` (`_company_id`),
  CONSTRAINT `t_activity_ibfk_1` FOREIGN KEY (`_company_id`) REFERENCES `t_company` (`_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_created_time` datetime NOT NULL,
  `_last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`_username`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,'Faker','AAC0A9DAA4185875786C9ED154F0DECE','2016-03-23 14:46:10','2016-03-26 10:21:46');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_company`
--

DROP TABLE IF EXISTS `t_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_company` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_company_id` varchar(32) NOT NULL,
  `_company_name` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  PRIMARY KEY (`_company_id`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_company`
--

LOCK TABLES `t_company` WRITE;
/*!40000 ALTER TABLE `t_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_knowledge`
--

DROP TABLE IF EXISTS `t_knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_knowledge` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_nlg_name` varchar(20) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_content` text NOT NULL,
  PRIMARY KEY (`_nlg_name`),
  UNIQUE KEY `_id` (`_id`),
  UNIQUE KEY `_id_2` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_knowledge`
--

LOCK TABLES `t_knowledge` WRITE;
/*!40000 ALTER TABLE `t_knowledge` DISABLE KEYS */;
INSERT INTO `t_knowledge` VALUES (2,'日本狗','2016-03-25 14:01:29','今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把 hahahah');
/*!40000 ALTER TABLE `t_knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_nlg_comment`
--

DROP TABLE IF EXISTS `t_nlg_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_nlg_comment` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_nlg_name` varchar(20) NOT NULL,
  `_to_user` varchar(20) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_username` (`_username`),
  KEY `_nlg_name` (`_nlg_name`),
  CONSTRAINT `t_nlg_comment_ibfk_1` FOREIGN KEY (`_username`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_nlg_comment_ibfk_2` FOREIGN KEY (`_nlg_name`) REFERENCES `t_knowledge` (`_nlg_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_nlg_comment`
--

LOCK TABLES `t_nlg_comment` WRITE;
/*!40000 ALTER TABLE `t_nlg_comment` DISABLE KEYS */;
INSERT INTO `t_nlg_comment` VALUES (2,'17866476644@tourism','我日你血妈','2016-03-24 16:29:20','日本狗','17866476633@tourism');
/*!40000 ALTER TABLE `t_nlg_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_package`
--

DROP TABLE IF EXISTS `t_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_package` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_package_id` varchar(32) NOT NULL,
  `_pkg_name` varchar(20) NOT NULL,
  `_activity_id` varchar(32) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_active_time` datetime NOT NULL,
  `_price` decimal(10,0) NOT NULL DEFAULT '0',
  `_content` text NOT NULL,
  PRIMARY KEY (`_package_id`),
  UNIQUE KEY `_id` (`_id`),
  KEY `_activity_id` (`_activity_id`),
  CONSTRAINT `t_package_ibfk_1` FOREIGN KEY (`_activity_id`) REFERENCES `t_activity` (`_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_package`
--

LOCK TABLES `t_package` WRITE;
/*!40000 ALTER TABLE `t_package` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pkg_comment`
--

DROP TABLE IF EXISTS `t_pkg_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pkg_comment` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_pkg_id` varchar(32) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_username` (`_username`),
  KEY `_pkg_id` (`_pkg_id`),
  CONSTRAINT `t_pkg_comment_ibfk_1` FOREIGN KEY (`_username`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_pkg_comment_ibfk_2` FOREIGN KEY (`_pkg_id`) REFERENCES `t_package` (`_package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pkg_comment`
--

LOCK TABLES `t_pkg_comment` WRITE;
/*!40000 ALTER TABLE `t_pkg_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pkg_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_plan`
--

DROP TABLE IF EXISTS `t_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_plan` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_pl_name` varchar(20) NOT NULL,
  `_destination` varchar(20) NOT NULL,
  `_price` decimal(10,0) NOT NULL DEFAULT '0',
  `_people_num` int(11) NOT NULL DEFAULT '0',
  `_content` text NOT NULL,
  `_created_time` datetime NOT NULL,
  `_start_time` datetime DEFAULT NULL,
  `_end_time` datetime DEFAULT NULL,
  `_active_time` datetime NOT NULL,
  `_type` varchar(20) NOT NULL,
  PRIMARY KEY (`_pl_name`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_plan`
--

LOCK TABLES `t_plan` WRITE;
/*!40000 ALTER TABLE `t_plan` DISABLE KEYS */;
INSERT INTO `t_plan` VALUES (1,'xixi啊','杭州',123,12,'xixihaha才此次','2016-03-24 18:26:16','2016-11-01 00:00:00','2016-12-10 00:00:00','2016-12-11 00:00:00','');
/*!40000 ALTER TABLE `t_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_purchase`
--

DROP TABLE IF EXISTS `t_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_purchase` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_purchase_id` varchar(32) NOT NULL,
  `_username` varchar(20) NOT NULL,
  `_package_id` varchar(32) NOT NULL,
  `_count` int(11) NOT NULL DEFAULT '0',
  `_purchase_date` datetime NOT NULL,
  `_status` varchar(10) NOT NULL,
  `_if_rate` tinyint(1) NOT NULL,
  PRIMARY KEY (`_purchase_id`),
  UNIQUE KEY `_id` (`_id`),
  KEY `_username` (`_username`),
  KEY `_package_id` (`_package_id`),
  CONSTRAINT `t_purchase_ibfk_1` FOREIGN KEY (`_username`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_purchase_ibfk_2` FOREIGN KEY (`_package_id`) REFERENCES `t_package` (`_package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_purchase`
--

LOCK TABLES `t_purchase` WRITE;
/*!40000 ALTER TABLE `t_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tel`
--

DROP TABLE IF EXISTS `t_tel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tel` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_owner` varchar(20) NOT NULL,
  `_friend_name` varchar(20) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_owner` (`_owner`),
  KEY `_friend_name` (`_friend_name`),
  CONSTRAINT `t_tel_ibfk_1` FOREIGN KEY (`_owner`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_tel_ibfk_2` FOREIGN KEY (`_friend_name`) REFERENCES `t_user` (`_username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tel`
--

LOCK TABLES `t_tel` WRITE;
/*!40000 ALTER TABLE `t_tel` DISABLE KEYS */;
INSERT INTO `t_tel` VALUES (1,'asdf','66476@tourism'),(2,'asdf','17866476633@tourism'),(3,'asdf','17866476644@tourism'),(4,'17866476644@tourism','18957137655@tourism'),(5,'asdf','18957137655@tourism'),(6,'17866476644@tourism','17866476633@tourism');
/*!40000 ALTER TABLE `t_tel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_topic`
--

DROP TABLE IF EXISTS `t_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_topic` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_tpc_name` varchar(20) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_content` text NOT NULL,
  `_people_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`_tpc_name`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_topic`
--

LOCK TABLES `t_topic` WRITE;
/*!40000 ALTER TABLE `t_topic` DISABLE KEYS */;
INSERT INTO `t_topic` VALUES (2,'阿桑地方','2016-04-23 00:00:00','啊速度发就死定了发卡机上了飞机啊离开世界的反垃圾上的浪费空间撒老大开房间阿拉山口的风景',12),(1,'阿道夫','2016-03-24 09:06:19','啊当时发生的发生的发生',7);
/*!40000 ALTER TABLE `t_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_topic_comment`
--

DROP TABLE IF EXISTS `t_topic_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_topic_comment` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_tpc_name` varchar(20) NOT NULL,
  `_to_user` varchar(20) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_username` (`_username`),
  KEY `_tpc_name` (`_tpc_name`),
  CONSTRAINT `t_topic_comment_ibfk_1` FOREIGN KEY (`_username`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_topic_comment_ibfk_2` FOREIGN KEY (`_tpc_name`) REFERENCES `t_topic` (`_tpc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_topic_comment`
--

LOCK TABLES `t_topic_comment` WRITE;
/*!40000 ALTER TABLE `t_topic_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_topic_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_name` varchar(20) DEFAULT NULL,
  `_nickname` varchar(20) NOT NULL,
  `_created_time` datetime NOT NULL,
  `_last_login` datetime DEFAULT NULL,
  `_image` varchar(32) NOT NULL,
  `_sex` varchar(5) DEFAULT NULL,
  `_phone` varchar(11) NOT NULL,
  PRIMARY KEY (`_username`),
  UNIQUE KEY `_id` (`_id`),
  UNIQUE KEY `_phone` (`_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (5,'17866476633@tourism','e10adc3949ba59abbe56e057f20f883e','Tony','Jery','2016-03-23 13:31:12','2016-03-26 20:43:18','default','男','17866476633'),(4,'17866476644@tourism','E10ADC3949BA59ABBE56E057F20F883E','bob','Jery','2016-03-23 13:29:46',NULL,'default','男','17866476644'),(8,'17899238844@tourism','password','null','null','2016-03-26 10:40:51',NULL,'default','男','17899238844'),(9,'18957137624@tourism','E10ADC3949BA59ABBE56E057F20F883E','null','null','2016-03-26 23:01:42','2016-03-26 23:04:26','default','男','18957137624'),(7,'18957137655@tourism','password','sam','null','2016-03-24 22:17:32','2016-03-24 22:32:30','default','男','18957137655'),(2,'66476@tourism','E10ADC3949BA59ABBE56E057F20F883E','dived','Jery','2016-03-23 13:29:08',NULL,'default','男','17866476622'),(1,'asdf','123123','王杰','tom','2016-11-12 00:00:00','2016-12-13 00:00:00','default','man','18957467948'),(6,'null@tourism.com','password','silly','null','2016-03-24 22:09:18',NULL,'default','男','18574454858');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-30 11:55:14
