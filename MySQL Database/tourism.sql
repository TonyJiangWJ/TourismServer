/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : tourism

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-03-29 13:07:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
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

-- ----------------------------
-- Records of t_activity
-- ----------------------------

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_created_time` datetime NOT NULL,
  `_last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`_username`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'Faker', 'AAC0A9DAA4185875786C9ED154F0DECE', '2016-03-23 14:46:10', '2016-03-26 10:21:46');

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_company_id` varchar(32) NOT NULL,
  `_company_name` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  PRIMARY KEY (`_company_id`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company
-- ----------------------------

-- ----------------------------
-- Table structure for t_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `t_knowledge`;
CREATE TABLE `t_knowledge` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_nlg_name` varchar(20) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_content` text NOT NULL,
  PRIMARY KEY (`_nlg_name`),
  UNIQUE KEY `_id` (`_id`),
  UNIQUE KEY `_id_2` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_knowledge
-- ----------------------------
INSERT INTO `t_knowledge` VALUES ('2', '日本狗', '2016-03-25 14:01:29', '今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把 hahahah');

-- ----------------------------
-- Table structure for t_nlg_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_nlg_comment`;
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

-- ----------------------------
-- Records of t_nlg_comment
-- ----------------------------
INSERT INTO `t_nlg_comment` VALUES ('2', '17866476644@tourism', '我日你血妈', '2016-03-24 16:29:20', '日本狗', '17866476633@tourism');

-- ----------------------------
-- Table structure for t_package
-- ----------------------------
DROP TABLE IF EXISTS `t_package`;
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

-- ----------------------------
-- Records of t_package
-- ----------------------------

-- ----------------------------
-- Table structure for t_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_plan`;
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

-- ----------------------------
-- Records of t_plan
-- ----------------------------
INSERT INTO `t_plan` VALUES ('1', 'xixi啊', '杭州', '123', '12', 'xixihaha才此次', '2016-03-24 18:26:16', '2016-11-01 00:00:00', '2016-12-10 00:00:00', '2016-12-11 00:00:00', '');

-- ----------------------------
-- Table structure for t_purchase
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase`;
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

-- ----------------------------
-- Records of t_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for t_tel
-- ----------------------------
DROP TABLE IF EXISTS `t_tel`;
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

-- ----------------------------
-- Records of t_tel
-- ----------------------------
INSERT INTO `t_tel` VALUES ('1', 'asdf', '66476@tourism');
INSERT INTO `t_tel` VALUES ('2', 'asdf', '17866476633@tourism');
INSERT INTO `t_tel` VALUES ('3', 'asdf', '17866476644@tourism');
INSERT INTO `t_tel` VALUES ('4', '17866476644@tourism', '18957137655@tourism');
INSERT INTO `t_tel` VALUES ('5', 'asdf', '18957137655@tourism');
INSERT INTO `t_tel` VALUES ('6', '17866476644@tourism', '17866476633@tourism');

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_tpc_name` varchar(20) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_content` text NOT NULL,
  `_people_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`_tpc_name`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topic
-- ----------------------------
INSERT INTO `t_topic` VALUES ('1', '阿道夫', '2016-03-24 09:06:19', '啊当时发生的发生的发生', '7');

-- ----------------------------
-- Table structure for t_topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_topic_comment`;
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

-- ----------------------------
-- Records of t_topic_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
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

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('5', '17866476633@tourism', 'E10ADC3949BA59ABBE56E057F20F883E', 'Tony', 'Jery', '2016-03-23 13:31:12', '2016-03-26 20:43:18', 'default', '男', '17866476633');
INSERT INTO `t_user` VALUES ('4', '17866476644@tourism', 'E10ADC3949BA59ABBE56E057F20F883E', 'bob', 'Jery', '2016-03-23 13:29:46', null, 'default', '男', '17866476644');
INSERT INTO `t_user` VALUES ('8', '17899238844@tourism', 'password', 'null', 'null', '2016-03-26 10:40:51', null, 'default', '男', '17899238844');
INSERT INTO `t_user` VALUES ('9', '18957137624@tourism', 'E10ADC3949BA59ABBE56E057F20F883E', 'null', 'null', '2016-03-26 23:01:42', '2016-03-26 23:04:26', 'default', '男', '18957137624');
INSERT INTO `t_user` VALUES ('7', '18957137655@tourism', 'password', 'sam', 'null', '2016-03-24 22:17:32', '2016-03-24 22:32:30', 'default', '男', '18957137655');
INSERT INTO `t_user` VALUES ('2', '66476@tourism', 'E10ADC3949BA59ABBE56E057F20F883E', 'dived', 'Jery', '2016-03-23 13:29:08', null, 'default', '男', '17866476622');
INSERT INTO `t_user` VALUES ('1', 'asdf', '123123', '王杰', 'tom', '2016-11-12 00:00:00', '2016-12-13 00:00:00', 'default', 'man', '18957467948');
INSERT INTO `t_user` VALUES ('6', 'null@tourism.com', 'password', 'silly', 'null', '2016-03-24 22:09:18', null, 'default', '男', '18574454858');
