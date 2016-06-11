/*
Navicat MySQL Data Transfer

Source Server         : mysqll
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2014-09-04 11:52:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(4) NOT NULL,
  `ename` varchar(25) DEFAULT NULL,
  `job` varchar(25) DEFAULT NULL,
  `sal` double(8,0) DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'www', 'wwwwww', '111');
INSERT INTO `emp` VALUES ('2', 'zzz', 'zzzzzz', '222');
INSERT INTO `emp` VALUES ('3', 'fff', 'ffffff', '333');
INSERT INTO `emp` VALUES ('4', 'rrr', 'rrrrrr', '444');
INSERT INTO `emp` VALUES ('5', 'ttt', 'tttttt', '555');
INSERT INTO `emp` VALUES ('6', 'yyy', 'yyyyyy', '666');
INSERT INTO `emp` VALUES ('7', 'uuu', 'uuuuuu', '777');
INSERT INTO `emp` VALUES ('8', 'iii', 'iiiiii', '888');
INSERT INTO `emp` VALUES ('9', 'ooo', 'oooooo', '999');
INSERT INTO `emp` VALUES ('10', 'ppp', 'pppppp', '1000');
INSERT INTO `emp` VALUES ('11', 'sss', 'ssssss', '1111');
INSERT INTO `emp` VALUES ('12', 'ddd', 'dddddd', '2222');
INSERT INTO `emp` VALUES ('13', 'ggg', 'gggggg', '3333');
INSERT INTO `emp` VALUES ('14', 'hhh', 'hhhhhh', '4444');
INSERT INTO `emp` VALUES ('15', 'jjj', 'jjjjjj', '5555');
