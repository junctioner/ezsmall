/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : ezs_v3

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-03-28 12:24:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ezs_accessory`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_accessory`;
CREATE TABLE `ezs_accessory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `ext` varchar(255) DEFAULT NULL,
  `height` int(11) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` float NOT NULL,
  `width` int(11) NOT NULL,
  `album_id` bigint(20) DEFAULT NULL,
  `config_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKD046F671DFFE5DA7` (`config_id`),
  KEY `FKD046F6716758EBDA` (`user_id`),
  KEY `FKD046F671EDD6555A` (`album_id`),
  KEY `FKD046F67117AB1439` (`config_id`),
  KEY `FKD046F671F734E208` (`user_id`),
  KEY `FKD046F671597924EC` (`album_id`),
  CONSTRAINT `FKD046F67117AB1439` FOREIGN KEY (`config_id`) REFERENCES `ezs_sysconfig` (`id`),
  CONSTRAINT `FKD046F671597924EC` FOREIGN KEY (`album_id`) REFERENCES `ezs_album` (`id`),
  CONSTRAINT `FKD046F6716758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKD046F671DFFE5DA7` FOREIGN KEY (`config_id`) REFERENCES `ezs_sysconfig` (`id`),
  CONSTRAINT `FKD046F671EDD6555A` FOREIGN KEY (`album_id`) REFERENCES `ezs_album` (`id`),
  CONSTRAINT `FKD046F671F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_accessory
-- ----------------------------
INSERT INTO `ezs_accessory` VALUES ('1', '2018-03-26 15:23:26', '', 'jpg', '0', null, 'good.jpg', 'resources/style/common/images', '0', '0', null, null, null);
INSERT INTO `ezs_accessory` VALUES ('2', '2018-03-27 18:33:08', '', 'jpg', '140', null, '0314c749-c7ea-48bc-a95b-c9b949ecb81b.jpg_small.jpg', 'upload/store/1/2016/03/09', '0', '140', '1', null, '1');

-- ----------------------------
-- Table structure for `ezs_address`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_address`;
CREATE TABLE `ezs_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `area_info` varchar(255) DEFAULT NULL,
  `bestow` bit(1) DEFAULT b'0',
  `mobile` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `trueName` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKC1F8F1343969C9A` (`area_id`),
  KEY `FKC1F8F136758EBDA` (`user_id`),
  KEY `FKC1F8F13D37292C8` (`area_id`),
  KEY `FKC1F8F13F734E208` (`user_id`),
  CONSTRAINT `FKC1F8F1343969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`),
  CONSTRAINT `FKC1F8F136758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKC1F8F13D37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`),
  CONSTRAINT `FKC1F8F13F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_address
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_album`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_album`;
CREATE TABLE `ezs_album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `alblum_info` longtext,
  `album_default` bit(1) NOT NULL,
  `album_name` varchar(255) DEFAULT NULL,
  `album_sequence` int(11) NOT NULL,
  `album_cover_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6B61AD4E6758EBDA` (`user_id`),
  KEY `FK6B61AD4EC82D6B85` (`album_cover_id`),
  KEY `FK6B61AD4EF734E208` (`user_id`),
  KEY `FK6B61AD4EFFDA2217` (`album_cover_id`),
  CONSTRAINT `FK6B61AD4E6758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK6B61AD4EC82D6B85` FOREIGN KEY (`album_cover_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6B61AD4EF734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK6B61AD4EFFDA2217` FOREIGN KEY (`album_cover_id`) REFERENCES `ezs_accessory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_album
-- ----------------------------
INSERT INTO `ezs_album` VALUES ('1', '2018-03-27 18:34:48', '', null, '', '默认相册', '-10000', null, '1');

-- ----------------------------
-- Table structure for `ezs_area`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_area`;
CREATE TABLE `ezs_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `areaName` varchar(255) DEFAULT NULL,
  `level` int(11) NOT NULL,
  `sequence` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `common` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `FK7D6B3B1ED79E13D4` (`parent_id`),
  KEY `FK2392E8CA7B57898B` (`parent_id`),
  KEY `FKFB34C9CE7B57898B` (`parent_id`),
  CONSTRAINT `FKFB34C9CE7B57898B` FOREIGN KEY (`parent_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK2392E8CA7B57898B` FOREIGN KEY (`parent_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK7D6B3B1ED79E13D4` FOREIGN KEY (`parent_id`) REFERENCES `ezs_area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4525504 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_area
-- ----------------------------
INSERT INTO `ezs_area` VALUES ('4521984', '2013-07-30 15:37:33', '', '北京市', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4521985', '2013-07-30 15:37:33', '', '北京市', '1', '0', '4521984', '');
INSERT INTO `ezs_area` VALUES ('4521986', '2013-07-30 15:37:33', '', '东城区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521987', '2013-07-30 15:37:33', '', '西城区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521988', '2013-07-30 15:37:33', '', '朝阳区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521989', '2013-07-30 15:37:33', '', '丰台区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521990', '2013-07-30 15:37:33', '', '石景山区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521991', '2013-07-30 15:37:33', '', '海淀区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521992', '2013-07-30 15:37:33', '', '门头沟区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521993', '2013-07-30 15:37:33', '', '房山区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521994', '2013-07-30 15:37:33', '', '通州区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521995', '2013-07-30 15:37:33', '', '顺义区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521996', '2013-07-30 15:37:33', '', '昌平区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521997', '2013-07-30 15:37:33', '', '大兴区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521998', '2013-07-30 15:37:33', '', '怀柔区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4521999', '2013-07-30 15:37:33', '', '平谷区', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4522001', '2013-07-30 15:37:33', '', '密云县', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4522002', '2013-07-30 15:37:33', '', '延庆县', '2', '0', '4521985', '');
INSERT INTO `ezs_area` VALUES ('4522003', '2013-07-30 15:37:33', '', '天津市', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522004', '2013-07-30 15:37:33', '', '天津市', '1', '0', '4522003', '');
INSERT INTO `ezs_area` VALUES ('4522005', '2013-07-30 15:37:33', '', '和平区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522006', '2013-07-30 15:37:33', '', '河东区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522007', '2013-07-30 15:37:33', '', '河西区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522008', '2013-07-30 15:37:34', '', '南开区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522009', '2013-07-30 15:37:34', '', '河北区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522010', '2013-07-30 15:37:34', '', '红桥区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522011', '2013-07-30 15:37:34', '', '东丽区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522012', '2013-07-30 15:37:34', '', '西青区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522013', '2013-07-30 15:37:34', '', '津南区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522014', '2013-07-30 15:37:34', '', '北辰区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522015', '2013-07-30 15:37:34', '', '武清区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522016', '2013-07-30 15:37:34', '', '宝坻区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522017', '2013-07-30 15:37:34', '', '滨海新区', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522019', '2013-07-30 15:37:34', '', '宁河县', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522020', '2013-07-30 15:37:34', '', '静海县', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522021', '2013-07-30 15:37:34', '', '蓟县', '2', '0', '4522004', '');
INSERT INTO `ezs_area` VALUES ('4522022', '2013-07-30 15:37:34', '', '河北省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522023', '2013-07-30 15:37:34', '', '石家庄市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522024', '2013-07-30 15:37:34', '', '市辖区', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522025', '2013-07-30 15:37:34', '', '长安区', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522026', '2013-07-30 15:37:34', '', '桥东区', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522027', '2013-07-30 15:37:34', '', '桥西区', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522028', '2013-07-30 15:37:34', '', '新华区', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522029', '2013-07-30 15:37:34', '', '井陉矿区', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522030', '2013-07-30 15:37:34', '', '裕华区', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522031', '2013-07-30 15:37:34', '', '井陉县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522032', '2013-07-30 15:37:34', '', '正定县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522033', '2013-07-30 15:37:34', '', '栾城县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522034', '2013-07-30 15:37:34', '', '行唐县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522035', '2013-07-30 15:37:34', '', '灵寿县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522036', '2013-07-30 15:37:34', '', '高邑县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522037', '2013-07-30 15:37:34', '', '深泽县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522038', '2013-07-30 15:37:34', '', '赞皇县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522039', '2013-07-30 15:37:34', '', '无极县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522040', '2013-07-30 15:37:34', '', '平山县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522041', '2013-07-30 15:37:34', '', '元氏县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522042', '2013-07-30 15:37:34', '', '赵县', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522043', '2013-07-30 15:37:34', '', '辛集市', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522044', '2013-07-30 15:37:34', '', '藁城市', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522045', '2013-07-30 15:37:34', '', '晋州市', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522046', '2013-07-30 15:37:35', '', '新乐市', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522047', '2013-07-30 15:37:35', '', '鹿泉市', '2', '0', '4522023', '');
INSERT INTO `ezs_area` VALUES ('4522048', '2013-07-30 15:37:35', '', '唐山市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522049', '2013-07-30 15:37:35', '', '市辖区', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522050', '2013-07-30 15:37:35', '', '路南区', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522051', '2013-07-30 15:37:35', '', '路北区', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522052', '2013-07-30 15:37:35', '', '古冶区', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522053', '2013-07-30 15:37:35', '', '开平区', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522054', '2013-07-30 15:37:35', '', '丰南区', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522055', '2013-07-30 15:37:35', '', '丰润区', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522056', '2013-07-30 15:37:35', '', '滦县', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522057', '2013-07-30 15:37:35', '', '滦南县', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522058', '2013-07-30 15:37:35', '', '乐亭县', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522059', '2013-07-30 15:37:35', '', '迁西县', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522060', '2013-07-30 15:37:35', '', '玉田县', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522061', '2013-07-30 15:37:35', '', '唐海县', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522062', '2013-07-30 15:37:35', '', '遵化市', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522063', '2013-07-30 15:37:35', '', '迁安市', '2', '0', '4522048', '');
INSERT INTO `ezs_area` VALUES ('4522064', '2013-07-30 15:37:35', '', '秦皇岛市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522065', '2013-07-30 15:37:35', '', '市辖区', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522066', '2013-07-30 15:37:35', '', '海港区', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522067', '2013-07-30 15:37:35', '', '山海关区', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522068', '2013-07-30 15:37:35', '', '北戴河区', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522069', '2013-07-30 15:37:35', '', '青龙满族自治县', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522070', '2013-07-30 15:37:35', '', '昌黎县', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522071', '2013-07-30 15:37:35', '', '抚宁县', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522072', '2013-07-30 15:37:35', '', '卢龙县', '2', '0', '4522064', '');
INSERT INTO `ezs_area` VALUES ('4522073', '2013-07-30 15:37:35', '', '邯郸市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522074', '2013-07-30 15:37:35', '', '市辖区', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522075', '2013-07-30 15:37:35', '', '邯山区', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522076', '2013-07-30 15:37:35', '', '丛台区', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522077', '2013-07-30 15:37:35', '', '复兴区', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522078', '2013-07-30 15:37:35', '', '峰峰矿区', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522079', '2013-07-30 15:37:35', '', '邯郸县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522080', '2013-07-30 15:37:35', '', '临漳县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522081', '2013-07-30 15:37:35', '', '成安县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522082', '2013-07-30 15:37:35', '', '大名县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522083', '2013-07-30 15:37:35', '', '涉县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522084', '2013-07-30 15:37:35', '', '磁县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522085', '2013-07-30 15:37:36', '', '肥乡县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522086', '2013-07-30 15:37:36', '', '永年县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522087', '2013-07-30 15:37:36', '', '邱县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522088', '2013-07-30 15:37:36', '', '鸡泽县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522089', '2013-07-30 15:37:36', '', '广平县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522090', '2013-07-30 15:37:36', '', '馆陶县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522091', '2013-07-30 15:37:36', '', '魏县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522092', '2013-07-30 15:37:36', '', '曲周县', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522093', '2013-07-30 15:37:36', '', '武安市', '2', '0', '4522073', '');
INSERT INTO `ezs_area` VALUES ('4522094', '2013-07-30 15:37:36', '', '邢台市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522095', '2013-07-30 15:37:36', '', '市辖区', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522096', '2013-07-30 15:37:36', '', '桥东区', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522097', '2013-07-30 15:37:36', '', '桥西区', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522098', '2013-07-30 15:37:36', '', '邢台县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522099', '2013-07-30 15:37:36', '', '临城县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522100', '2013-07-30 15:37:36', '', '内丘县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522101', '2013-07-30 15:37:36', '', '柏乡县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522102', '2013-07-30 15:37:36', '', '隆尧县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522103', '2013-07-30 15:37:36', '', '任县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522104', '2013-07-30 15:37:36', '', '南和县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522105', '2013-07-30 15:37:36', '', '宁晋县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522106', '2013-07-30 15:37:36', '', '巨鹿县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522107', '2013-07-30 15:37:36', '', '新河县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522108', '2013-07-30 15:37:36', '', '广宗县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522109', '2013-07-30 15:37:36', '', '平乡县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522110', '2013-07-30 15:37:36', '', '威县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522111', '2013-07-30 15:37:36', '', '清河县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522112', '2013-07-30 15:37:36', '', '临西县', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522113', '2013-07-30 15:37:36', '', '南宫市', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522114', '2013-07-30 15:37:36', '', '沙河市', '2', '0', '4522094', '');
INSERT INTO `ezs_area` VALUES ('4522115', '2013-07-30 15:37:36', '', '保定市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522116', '2013-07-30 15:37:36', '', '市辖区', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522117', '2013-07-30 15:37:36', '', '新市区', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522118', '2013-07-30 15:37:36', '', '北市区', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522119', '2013-07-30 15:37:36', '', '南市区', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522120', '2013-07-30 15:37:36', '', '满城县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522121', '2013-07-30 15:37:36', '', '清苑县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522122', '2013-07-30 15:37:36', '', '涞水县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522123', '2013-07-30 15:37:36', '', '阜平县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522124', '2013-07-30 15:37:37', '', '徐水县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522125', '2013-07-30 15:37:37', '', '定兴县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522126', '2013-07-30 15:37:37', '', '唐县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522127', '2013-07-30 15:37:37', '', '高阳县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522128', '2013-07-30 15:37:37', '', '容城县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522129', '2013-07-30 15:37:37', '', '涞源县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522130', '2013-07-30 15:37:37', '', '望都县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522131', '2013-07-30 15:37:37', '', '安新县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522132', '2013-07-30 15:37:37', '', '易县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522133', '2013-07-30 15:37:37', '', '曲阳县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522134', '2013-07-30 15:37:37', '', '蠡县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522135', '2013-07-30 15:37:37', '', '顺平县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522136', '2013-07-30 15:37:37', '', '博野县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522137', '2013-07-30 15:37:37', '', '雄县', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522138', '2013-07-30 15:37:37', '', '涿州市', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522139', '2013-07-30 15:37:37', '', '定州市', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522140', '2013-07-30 15:37:37', '', '安国市', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522141', '2013-07-30 15:37:37', '', '高碑店市', '2', '0', '4522115', '');
INSERT INTO `ezs_area` VALUES ('4522142', '2013-07-30 15:37:37', '', '张家口市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522143', '2013-07-30 15:37:37', '', '市辖区', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522144', '2013-07-30 15:37:37', '', '桥东区', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522145', '2013-07-30 15:37:37', '', '桥西区', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522146', '2013-07-30 15:37:37', '', '宣化区', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522147', '2013-07-30 15:37:37', '', '下花园区', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522148', '2013-07-30 15:37:37', '', '宣化县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522149', '2013-07-30 15:37:37', '', '张北县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522150', '2013-07-30 15:37:37', '', '康保县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522151', '2013-07-30 15:37:37', '', '沽源县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522152', '2013-07-30 15:37:37', '', '尚义县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522153', '2013-07-30 15:37:37', '', '蔚县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522154', '2013-07-30 15:37:37', '', '阳原县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522155', '2013-07-30 15:37:37', '', '怀安县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522156', '2013-07-30 15:37:37', '', '万全县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522157', '2013-07-30 15:37:37', '', '怀来县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522158', '2013-07-30 15:37:37', '', '涿鹿县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522159', '2013-07-30 15:37:37', '', '赤城县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522160', '2013-07-30 15:37:37', '', '崇礼县', '2', '0', '4522142', '');
INSERT INTO `ezs_area` VALUES ('4522161', '2013-07-30 15:37:37', '', '承德市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522162', '2013-07-30 15:37:37', '', '市辖区', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522163', '2013-07-30 15:37:38', '', '双桥区', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522164', '2013-07-30 15:37:38', '', '双滦区', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522165', '2013-07-30 15:37:38', '', '鹰手营子矿区', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522166', '2013-07-30 15:37:38', '', '承德县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522167', '2013-07-30 15:37:38', '', '兴隆县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522168', '2013-07-30 15:37:38', '', '平泉县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522169', '2013-07-30 15:37:38', '', '滦平县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522170', '2013-07-30 15:37:38', '', '隆化县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522171', '2013-07-30 15:37:38', '', '丰宁满族自治县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522172', '2013-07-30 15:37:38', '', '宽城满族自治县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522173', '2013-07-30 15:37:38', '', '围场满族蒙古族自治县', '2', '0', '4522161', '');
INSERT INTO `ezs_area` VALUES ('4522174', '2013-07-30 15:37:38', '', '沧州市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522175', '2013-07-30 15:37:38', '', '市辖区', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522176', '2013-07-30 15:37:38', '', '新华区', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522177', '2013-07-30 15:37:38', '', '运河区', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522178', '2013-07-30 15:37:38', '', '沧县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522179', '2013-07-30 15:37:38', '', '青县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522180', '2013-07-30 15:37:38', '', '东光县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522181', '2013-07-30 15:37:38', '', '海兴县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522182', '2013-07-30 15:37:38', '', '盐山县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522183', '2013-07-30 15:37:38', '', '肃宁县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522184', '2013-07-30 15:37:38', '', '南皮县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522185', '2013-07-30 15:37:38', '', '吴桥县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522186', '2013-07-30 15:37:38', '', '献县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522187', '2013-07-30 15:37:38', '', '孟村回族自治县', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522188', '2013-07-30 15:37:38', '', '泊头市', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522189', '2013-07-30 15:37:38', '', '任丘市', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522190', '2013-07-30 15:37:38', '', '黄骅市', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522191', '2013-07-30 15:37:38', '', '河间市', '2', '0', '4522174', '');
INSERT INTO `ezs_area` VALUES ('4522192', '2013-07-30 15:37:38', '', '廊坊市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522193', '2013-07-30 15:37:38', '', '市辖区', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522194', '2013-07-30 15:37:38', '', '安次区', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522195', '2013-07-30 15:37:38', '', '广阳区', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522196', '2013-07-30 15:37:38', '', '固安县', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522197', '2013-07-30 15:37:38', '', '永清县', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522198', '2013-07-30 15:37:38', '', '香河县', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522199', '2013-07-30 15:37:38', '', '大城县', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522200', '2013-07-30 15:37:38', '', '文安县', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522201', '2013-07-30 15:37:39', '', '大厂回族自治县', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522202', '2013-07-30 15:37:39', '', '霸州市', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522203', '2013-07-30 15:37:39', '', '三河市', '2', '0', '4522192', '');
INSERT INTO `ezs_area` VALUES ('4522204', '2013-07-30 15:37:39', '', '衡水市', '1', '0', '4522022', '');
INSERT INTO `ezs_area` VALUES ('4522205', '2013-07-30 15:37:39', '', '市辖区', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522206', '2013-07-30 15:37:39', '', '桃城区', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522207', '2013-07-30 15:37:39', '', '枣强县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522208', '2013-07-30 15:37:39', '', '武邑县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522209', '2013-07-30 15:37:39', '', '武强县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522210', '2013-07-30 15:37:39', '', '饶阳县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522211', '2013-07-30 15:37:39', '', '安平县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522212', '2013-07-30 15:37:39', '', '故城县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522213', '2013-07-30 15:37:39', '', '景县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522214', '2013-07-30 15:37:39', '', '阜城县', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522215', '2013-07-30 15:37:39', '', '冀州市', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522216', '2013-07-30 15:37:39', '', '深州市', '2', '0', '4522204', '');
INSERT INTO `ezs_area` VALUES ('4522217', '2013-07-30 15:37:39', '', '山西省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522218', '2013-07-30 15:37:39', '', '太原市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522219', '2013-07-30 15:37:39', '', '市辖区', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522220', '2013-07-30 15:37:39', '', '小店区', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522221', '2013-07-30 15:37:39', '', '迎泽区', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522222', '2013-07-30 15:37:39', '', '杏花岭区', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522223', '2013-07-30 15:37:39', '', '尖草坪区', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522224', '2013-07-30 15:37:39', '', '万柏林区', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522225', '2013-07-30 15:37:39', '', '晋源区', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522226', '2013-07-30 15:37:39', '', '清徐县', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522227', '2013-07-30 15:37:39', '', '阳曲县', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522228', '2013-07-30 15:37:39', '', '娄烦县', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522229', '2013-07-30 15:37:39', '', '古交市', '2', '0', '4522218', '');
INSERT INTO `ezs_area` VALUES ('4522230', '2013-07-30 15:37:39', '', '大同市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522231', '2013-07-30 15:37:39', '', '市辖区', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522232', '2013-07-30 15:37:39', '', '城区', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522233', '2013-07-30 15:37:39', '', '矿区', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522234', '2013-07-30 15:37:39', '', '南郊区', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522235', '2013-07-30 15:37:39', '', '新荣区', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522236', '2013-07-30 15:37:39', '', '阳高县', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522237', '2013-07-30 15:37:39', '', '天镇县', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522238', '2013-07-30 15:37:40', '', '广灵县', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522239', '2013-07-30 15:37:40', '', '灵丘县', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522240', '2013-07-30 15:37:40', '', '浑源县', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522241', '2013-07-30 15:37:40', '', '左云县', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522242', '2013-07-30 15:37:40', '', '大同县', '2', '0', '4522230', '');
INSERT INTO `ezs_area` VALUES ('4522243', '2013-07-30 15:37:40', '', '阳泉市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522244', '2013-07-30 15:37:40', '', '市辖区', '2', '0', '4522243', '');
INSERT INTO `ezs_area` VALUES ('4522245', '2013-07-30 15:37:40', '', '城区', '2', '0', '4522243', '');
INSERT INTO `ezs_area` VALUES ('4522246', '2013-07-30 15:37:40', '', '矿区', '2', '0', '4522243', '');
INSERT INTO `ezs_area` VALUES ('4522247', '2013-07-30 15:37:40', '', '郊区', '2', '0', '4522243', '');
INSERT INTO `ezs_area` VALUES ('4522248', '2013-07-30 15:37:40', '', '平定县', '2', '0', '4522243', '');
INSERT INTO `ezs_area` VALUES ('4522249', '2013-07-30 15:37:40', '', '盂县', '2', '0', '4522243', '');
INSERT INTO `ezs_area` VALUES ('4522250', '2013-07-30 15:37:40', '', '长治市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522251', '2013-07-30 15:37:40', '', '市辖区', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522252', '2013-07-30 15:37:40', '', '城区', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522253', '2013-07-30 15:37:40', '', '郊区', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522254', '2013-07-30 15:37:40', '', '长治县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522255', '2013-07-30 15:37:40', '', '襄垣县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522256', '2013-07-30 15:37:40', '', '屯留县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522257', '2013-07-30 15:37:40', '', '平顺县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522258', '2013-07-30 15:37:40', '', '黎城县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522259', '2013-07-30 15:37:40', '', '壶关县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522260', '2013-07-30 15:37:40', '', '长子县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522261', '2013-07-30 15:37:40', '', '武乡县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522262', '2013-07-30 15:37:40', '', '沁县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522263', '2013-07-30 15:37:40', '', '沁源县', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522264', '2013-07-30 15:37:40', '', '潞城市', '2', '0', '4522250', '');
INSERT INTO `ezs_area` VALUES ('4522265', '2013-07-30 15:37:40', '', '晋城市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522266', '2013-07-30 15:37:40', '', '市辖区', '2', '0', '4522265', '');
INSERT INTO `ezs_area` VALUES ('4522267', '2013-07-30 15:37:40', '', '城区', '2', '0', '4522265', '');
INSERT INTO `ezs_area` VALUES ('4522268', '2013-07-30 15:37:40', '', '沁水县', '2', '0', '4522265', '');
INSERT INTO `ezs_area` VALUES ('4522269', '2013-07-30 15:37:40', '', '阳城县', '2', '0', '4522265', '');
INSERT INTO `ezs_area` VALUES ('4522270', '2013-07-30 15:37:40', '', '陵川县', '2', '0', '4522265', '');
INSERT INTO `ezs_area` VALUES ('4522271', '2013-07-30 15:37:40', '', '泽州县', '2', '0', '4522265', '');
INSERT INTO `ezs_area` VALUES ('4522272', '2013-07-30 15:37:40', '', '高平市', '2', '0', '4522265', '');
INSERT INTO `ezs_area` VALUES ('4522273', '2013-07-30 15:37:40', '', '朔州市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522274', '2013-07-30 15:37:40', '', '市辖区', '2', '0', '4522273', '');
INSERT INTO `ezs_area` VALUES ('4522275', '2013-07-30 15:37:41', '', '朔城区', '2', '0', '4522273', '');
INSERT INTO `ezs_area` VALUES ('4522276', '2013-07-30 15:37:41', '', '平鲁区', '2', '0', '4522273', '');
INSERT INTO `ezs_area` VALUES ('4522277', '2013-07-30 15:37:41', '', '山阴县', '2', '0', '4522273', '');
INSERT INTO `ezs_area` VALUES ('4522278', '2013-07-30 15:37:41', '', '应县', '2', '0', '4522273', '');
INSERT INTO `ezs_area` VALUES ('4522279', '2013-07-30 15:37:41', '', '右玉县', '2', '0', '4522273', '');
INSERT INTO `ezs_area` VALUES ('4522280', '2013-07-30 15:37:41', '', '怀仁县', '2', '0', '4522273', '');
INSERT INTO `ezs_area` VALUES ('4522281', '2013-07-30 15:37:41', '', '晋中市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522282', '2013-07-30 15:37:41', '', '市辖区', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522283', '2013-07-30 15:37:41', '', '榆次区', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522284', '2013-07-30 15:37:41', '', '榆社县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522285', '2013-07-30 15:37:41', '', '左权县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522286', '2013-07-30 15:37:41', '', '和顺县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522287', '2013-07-30 15:37:41', '', '昔阳县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522288', '2013-07-30 15:37:41', '', '寿阳县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522289', '2013-07-30 15:37:41', '', '太谷县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522290', '2013-07-30 15:37:41', '', '祁县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522291', '2013-07-30 15:37:41', '', '平遥县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522292', '2013-07-30 15:37:41', '', '灵石县', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522293', '2013-07-30 15:37:41', '', '介休市', '2', '0', '4522281', '');
INSERT INTO `ezs_area` VALUES ('4522294', '2013-07-30 15:37:41', '', '运城市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522295', '2013-07-30 15:37:41', '', '市辖区', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522296', '2013-07-30 15:37:41', '', '盐湖区', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522297', '2013-07-30 15:37:41', '', '临猗县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522298', '2013-07-30 15:37:41', '', '万荣县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522299', '2013-07-30 15:37:41', '', '闻喜县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522300', '2013-07-30 15:37:41', '', '稷山县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522301', '2013-07-30 15:37:41', '', '新绛县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522302', '2013-07-30 15:37:41', '', '绛县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522303', '2013-07-30 15:37:41', '', '垣曲县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522304', '2013-07-30 15:37:41', '', '夏县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522305', '2013-07-30 15:37:41', '', '平陆县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522306', '2013-07-30 15:37:41', '', '芮城县', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522307', '2013-07-30 15:37:41', '', '永济市', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522308', '2013-07-30 15:37:42', '', '河津市', '2', '0', '4522294', '');
INSERT INTO `ezs_area` VALUES ('4522309', '2013-07-30 15:37:42', '', '忻州市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522310', '2013-07-30 15:37:42', '', '市辖区', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522311', '2013-07-30 15:37:42', '', '忻府区', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522312', '2013-07-30 15:37:42', '', '定襄县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522313', '2013-07-30 15:37:42', '', '五台县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522314', '2013-07-30 15:37:42', '', '代县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522315', '2013-07-30 15:37:42', '', '繁峙县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522316', '2013-07-30 15:37:42', '', '宁武县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522317', '2013-07-30 15:37:42', '', '静乐县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522318', '2013-07-30 15:37:42', '', '神池县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522319', '2013-07-30 15:37:42', '', '五寨县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522320', '2013-07-30 15:37:42', '', '岢岚县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522321', '2013-07-30 15:37:42', '', '河曲县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522322', '2013-07-30 15:37:42', '', '保德县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522323', '2013-07-30 15:37:42', '', '偏关县', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522324', '2013-07-30 15:37:42', '', '原平市', '2', '0', '4522309', '');
INSERT INTO `ezs_area` VALUES ('4522325', '2013-07-30 15:37:42', '', '临汾市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522326', '2013-07-30 15:37:42', '', '市辖区', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522327', '2013-07-30 15:37:42', '', '尧都区', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522328', '2013-07-30 15:37:42', '', '曲沃县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522329', '2013-07-30 15:37:42', '', '翼城县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522330', '2013-07-30 15:37:42', '', '襄汾县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522331', '2013-07-30 15:37:42', '', '洪洞县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522332', '2013-07-30 15:37:42', '', '古县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522333', '2013-07-30 15:37:42', '', '安泽县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522334', '2013-07-30 15:37:42', '', '浮山县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522335', '2013-07-30 15:37:42', '', '吉县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522336', '2013-07-30 15:37:42', '', '乡宁县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522337', '2013-07-30 15:37:42', '', '大宁县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522338', '2013-07-30 15:37:42', '', '隰县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522339', '2013-07-30 15:37:42', '', '永和县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522340', '2013-07-30 15:37:42', '', '蒲县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522341', '2013-07-30 15:37:42', '', '汾西县', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522342', '2013-07-30 15:37:42', '', '侯马市', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522343', '2013-07-30 15:37:42', '', '霍州市', '2', '0', '4522325', '');
INSERT INTO `ezs_area` VALUES ('4522344', '2013-07-30 15:37:42', '', '吕梁市', '1', '0', '4522217', '');
INSERT INTO `ezs_area` VALUES ('4522345', '2013-07-30 15:37:43', '', '市辖区', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522346', '2013-07-30 15:37:43', '', '离石区', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522347', '2013-07-30 15:37:43', '', '文水县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522348', '2013-07-30 15:37:43', '', '交城县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522349', '2013-07-30 15:37:43', '', '兴县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522350', '2013-07-30 15:37:43', '', '临县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522351', '2013-07-30 15:37:43', '', '柳林县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522352', '2013-07-30 15:37:43', '', '石楼县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522353', '2013-07-30 15:37:43', '', '岚县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522354', '2013-07-30 15:37:43', '', '方山县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522355', '2013-07-30 15:37:43', '', '中阳县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522356', '2013-07-30 15:37:43', '', '交口县', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522357', '2013-07-30 15:37:43', '', '孝义市', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522358', '2013-07-30 15:37:43', '', '汾阳市', '2', '0', '4522344', '');
INSERT INTO `ezs_area` VALUES ('4522359', '2013-07-30 15:37:43', '', '内蒙古自治区', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522360', '2013-07-30 15:37:43', '', '呼和浩特市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522361', '2013-07-30 15:37:43', '', '市辖区', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522362', '2013-07-30 15:37:43', '', '新城区', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522363', '2013-07-30 15:37:43', '', '回民区', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522364', '2013-07-30 15:37:43', '', '玉泉区', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522365', '2013-07-30 15:37:43', '', '赛罕区', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522366', '2013-07-30 15:37:43', '', '土默特左旗', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522367', '2013-07-30 15:37:43', '', '托克托县', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522368', '2013-07-30 15:37:43', '', '和林格尔县', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522369', '2013-07-30 15:37:43', '', '清水河县', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522370', '2013-07-30 15:37:43', '', '武川县', '2', '0', '4522360', '');
INSERT INTO `ezs_area` VALUES ('4522371', '2013-07-30 15:37:43', '', '包头市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522372', '2013-07-30 15:37:43', '', '市辖区', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522373', '2013-07-30 15:37:43', '', '东河区', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522374', '2013-07-30 15:37:43', '', '昆都仑区', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522375', '2013-07-30 15:37:43', '', '青山区', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522376', '2013-07-30 15:37:43', '', '石拐区', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522377', '2013-07-30 15:37:43', '', '白云鄂博矿区', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522378', '2013-07-30 15:37:43', '', '九原区', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522379', '2013-07-30 15:37:44', '', '土默特右旗', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522380', '2013-07-30 15:37:44', '', '固阳县', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522381', '2013-07-30 15:37:44', '', '达尔罕茂明安联合旗', '2', '0', '4522371', '');
INSERT INTO `ezs_area` VALUES ('4522382', '2013-07-30 15:37:44', '', '乌海市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522383', '2013-07-30 15:37:44', '', '市辖区', '2', '0', '4522382', '');
INSERT INTO `ezs_area` VALUES ('4522384', '2013-07-30 15:37:44', '', '海勃湾区', '2', '0', '4522382', '');
INSERT INTO `ezs_area` VALUES ('4522385', '2013-07-30 15:37:44', '', '海南区', '2', '0', '4522382', '');
INSERT INTO `ezs_area` VALUES ('4522386', '2013-07-30 15:37:44', '', '乌达区', '2', '0', '4522382', '');
INSERT INTO `ezs_area` VALUES ('4522387', '2013-07-30 15:37:44', '', '赤峰市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522388', '2013-07-30 15:37:44', '', '市辖区', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522389', '2013-07-30 15:37:44', '', '红山区', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522390', '2013-07-30 15:37:44', '', '元宝山区', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522391', '2013-07-30 15:37:44', '', '松山区', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522392', '2013-07-30 15:37:44', '', '阿鲁科尔沁旗', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522393', '2013-07-30 15:37:44', '', '巴林左旗', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522394', '2013-07-30 15:37:44', '', '巴林右旗', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522395', '2013-07-30 15:37:44', '', '林西县', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522396', '2013-07-30 15:37:44', '', '克什克腾旗', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522397', '2013-07-30 15:37:44', '', '翁牛特旗', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522398', '2013-07-30 15:37:44', '', '喀喇沁旗', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522399', '2013-07-30 15:37:44', '', '宁城县', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522400', '2013-07-30 15:37:44', '', '敖汉旗', '2', '0', '4522387', '');
INSERT INTO `ezs_area` VALUES ('4522401', '2013-07-30 15:37:44', '', '通辽市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522402', '2013-07-30 15:37:44', '', '市辖区', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522403', '2013-07-30 15:37:44', '', '科尔沁区', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522404', '2013-07-30 15:37:44', '', '科尔沁左翼中旗', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522405', '2013-07-30 15:37:44', '', '科尔沁左翼后旗', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522406', '2013-07-30 15:37:44', '', '开鲁县', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522407', '2013-07-30 15:37:44', '', '库伦旗', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522408', '2013-07-30 15:37:44', '', '奈曼旗', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522409', '2013-07-30 15:37:44', '', '扎鲁特旗', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522410', '2013-07-30 15:37:44', '', '霍林郭勒市', '2', '0', '4522401', '');
INSERT INTO `ezs_area` VALUES ('4522411', '2013-07-30 15:37:44', '', '鄂尔多斯市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522412', '2013-07-30 15:37:44', '', '市辖区', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522413', '2013-07-30 15:37:44', '', '东胜区', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522414', '2013-07-30 15:37:44', '', '达拉特旗', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522415', '2013-07-30 15:37:45', '', '准格尔旗', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522416', '2013-07-30 15:37:45', '', '鄂托克前旗', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522417', '2013-07-30 15:37:45', '', '鄂托克旗', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522418', '2013-07-30 15:37:45', '', '杭锦旗', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522419', '2013-07-30 15:37:45', '', '乌审旗', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522420', '2013-07-30 15:37:45', '', '伊金霍洛旗', '2', '0', '4522411', '');
INSERT INTO `ezs_area` VALUES ('4522421', '2013-07-30 15:37:45', '', '呼伦贝尔市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522422', '2013-07-30 15:37:45', '', '市辖区', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522423', '2013-07-30 15:37:45', '', '海拉尔区', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522424', '2013-07-30 15:37:45', '', '阿荣旗', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522425', '2013-07-30 15:37:45', '', '莫力达瓦达斡尔族自治旗', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522426', '2013-07-30 15:37:45', '', '鄂伦春自治旗', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522427', '2013-07-30 15:37:45', '', '鄂温克族自治旗', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522428', '2013-07-30 15:37:45', '', '陈巴尔虎旗', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522429', '2013-07-30 15:37:45', '', '新巴尔虎左旗', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522430', '2013-07-30 15:37:45', '', '新巴尔虎右旗', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522431', '2013-07-30 15:37:45', '', '满洲里市', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522432', '2013-07-30 15:37:45', '', '牙克石市', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522433', '2013-07-30 15:37:45', '', '扎兰屯市', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522434', '2013-07-30 15:37:45', '', '额尔古纳市', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522435', '2013-07-30 15:37:45', '', '根河市', '2', '0', '4522421', '');
INSERT INTO `ezs_area` VALUES ('4522436', '2013-07-30 15:37:45', '', '巴彦淖尔市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522437', '2013-07-30 15:37:45', '', '市辖区', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522438', '2013-07-30 15:37:45', '', '临河区', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522439', '2013-07-30 15:37:45', '', '五原县', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522440', '2013-07-30 15:37:45', '', '磴口县', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522441', '2013-07-30 15:37:45', '', '乌拉特前旗', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522442', '2013-07-30 15:37:45', '', '乌拉特中旗', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522443', '2013-07-30 15:37:45', '', '乌拉特后旗', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522444', '2013-07-30 15:37:45', '', '杭锦后旗', '2', '0', '4522436', '');
INSERT INTO `ezs_area` VALUES ('4522445', '2013-07-30 15:37:45', '', '乌兰察布市', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522446', '2013-07-30 15:37:45', '', '市辖区', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522447', '2013-07-30 15:37:45', '', '集宁区', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522448', '2013-07-30 15:37:45', '', '卓资县', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522449', '2013-07-30 15:37:46', '', '化德县', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522450', '2013-07-30 15:37:46', '', '商都县', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522451', '2013-07-30 15:37:46', '', '兴和县', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522452', '2013-07-30 15:37:46', '', '凉城县', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522453', '2013-07-30 15:37:46', '', '察哈尔右翼前旗', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522454', '2013-07-30 15:37:46', '', '察哈尔右翼中旗', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522455', '2013-07-30 15:37:46', '', '察哈尔右翼后旗', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522456', '2013-07-30 15:37:46', '', '四子王旗', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522457', '2013-07-30 15:37:46', '', '丰镇市', '2', '0', '4522445', '');
INSERT INTO `ezs_area` VALUES ('4522458', '2013-07-30 15:37:46', '', '兴安盟', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522459', '2013-07-30 15:37:46', '', '乌兰浩特市', '2', '0', '4522458', '');
INSERT INTO `ezs_area` VALUES ('4522460', '2013-07-30 15:37:46', '', '阿尔山市', '2', '0', '4522458', '');
INSERT INTO `ezs_area` VALUES ('4522461', '2013-07-30 15:37:46', '', '科尔沁右翼前旗', '2', '0', '4522458', '');
INSERT INTO `ezs_area` VALUES ('4522462', '2013-07-30 15:37:46', '', '科尔沁右翼中旗', '2', '0', '4522458', '');
INSERT INTO `ezs_area` VALUES ('4522463', '2013-07-30 15:37:46', '', '扎赉特旗', '2', '0', '4522458', '');
INSERT INTO `ezs_area` VALUES ('4522464', '2013-07-30 15:37:46', '', '突泉县', '2', '0', '4522458', '');
INSERT INTO `ezs_area` VALUES ('4522465', '2013-07-30 15:37:46', '', '锡林郭勒盟', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522466', '2013-07-30 15:37:46', '', '二连浩特市', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522467', '2013-07-30 15:37:46', '', '锡林浩特市', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522468', '2013-07-30 15:37:46', '', '阿巴嘎旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522469', '2013-07-30 15:37:46', '', '苏尼特左旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522470', '2013-07-30 15:37:46', '', '苏尼特右旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522471', '2013-07-30 15:37:46', '', '东乌珠穆沁旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522472', '2013-07-30 15:37:46', '', '西乌珠穆沁旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522473', '2013-07-30 15:37:46', '', '太仆寺旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522474', '2013-07-30 15:37:46', '', '镶黄旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522475', '2013-07-30 15:37:46', '', '正镶白旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522476', '2013-07-30 15:37:46', '', '正蓝旗', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522477', '2013-07-30 15:37:46', '', '多伦县', '2', '0', '4522465', '');
INSERT INTO `ezs_area` VALUES ('4522478', '2013-07-30 15:37:46', '', '阿拉善盟', '1', '0', '4522359', '');
INSERT INTO `ezs_area` VALUES ('4522479', '2013-07-30 15:37:46', '', '阿拉善左旗', '2', '0', '4522478', '');
INSERT INTO `ezs_area` VALUES ('4522480', '2013-07-30 15:37:46', '', '阿拉善右旗', '2', '0', '4522478', '');
INSERT INTO `ezs_area` VALUES ('4522481', '2013-07-30 15:37:47', '', '额济纳旗', '2', '0', '4522478', '');
INSERT INTO `ezs_area` VALUES ('4522482', '2013-07-30 15:37:47', '', '辽宁省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522483', '2013-07-30 15:37:47', '', '沈阳市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522484', '2013-07-30 15:37:47', '', '浑南新区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522485', '2013-07-30 15:37:47', '', '和平区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522486', '2013-07-30 15:37:47', '', '沈河区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522487', '2013-07-30 15:37:47', '', '大东区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522488', '2013-07-30 15:37:47', '', '皇姑区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522489', '2013-07-30 15:37:47', '', '铁西区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522490', '2013-07-30 15:37:47', '', '苏家屯区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522491', '2013-07-30 15:37:47', '', '东陵区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522492', '2013-07-30 15:37:47', '', '沈北新区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522493', '2013-07-30 15:37:47', '', '于洪区', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522494', '2013-07-30 15:37:47', '', '辽中县', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522495', '2013-07-30 15:37:47', '', '康平县', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522496', '2013-07-30 15:37:47', '', '法库县', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522497', '2013-07-30 15:37:47', '', '新民市', '2', '0', '4522483', '');
INSERT INTO `ezs_area` VALUES ('4522498', '2013-07-30 15:37:47', '', '大连市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522499', '2013-07-30 15:37:47', '', '市辖区', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522500', '2013-07-30 15:37:47', '', '中山区', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522501', '2013-07-30 15:37:47', '', '西岗区', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522502', '2013-07-30 15:37:47', '', '沙河口区', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522503', '2013-07-30 15:37:47', '', '甘井子区', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522504', '2013-07-30 15:37:47', '', '旅顺口区', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522505', '2013-07-30 15:37:47', '', '金州区', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522506', '2013-07-30 15:37:47', '', '长海县', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522507', '2013-07-30 15:37:47', '', '瓦房店市', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522508', '2013-07-30 15:37:47', '', '普兰店市', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522509', '2013-07-30 15:37:47', '', '庄河市', '2', '0', '4522498', '');
INSERT INTO `ezs_area` VALUES ('4522510', '2013-07-30 15:37:47', '', '鞍山市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522511', '2013-07-30 15:37:47', '', '市辖区', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522512', '2013-07-30 15:37:48', '', '铁东区', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522513', '2013-07-30 15:37:48', '', '铁西区', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522514', '2013-07-30 15:37:48', '', '立山区', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522515', '2013-07-30 15:37:48', '', '千山区', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522516', '2013-07-30 15:37:48', '', '台安县', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522517', '2013-07-30 15:37:48', '', '岫岩满族自治县', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522518', '2013-07-30 15:37:48', '', '海城市', '2', '0', '4522510', '');
INSERT INTO `ezs_area` VALUES ('4522519', '2013-07-30 15:37:48', '', '抚顺市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522520', '2013-07-30 15:37:48', '', '市辖区', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522521', '2013-07-30 15:37:48', '', '新抚区', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522522', '2013-07-30 15:37:48', '', '东洲区', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522523', '2013-07-30 15:37:48', '', '望花区', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522524', '2013-07-30 15:37:48', '', '顺城区', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522525', '2013-07-30 15:37:48', '', '抚顺县', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522526', '2013-07-30 15:37:48', '', '新宾满族自治县', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522527', '2013-07-30 15:37:48', '', '清原满族自治县', '2', '0', '4522519', '');
INSERT INTO `ezs_area` VALUES ('4522528', '2013-07-30 15:37:48', '', '本溪市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522529', '2013-07-30 15:37:48', '', '市辖区', '2', '0', '4522528', '');
INSERT INTO `ezs_area` VALUES ('4522530', '2013-07-30 15:37:48', '', '平山区', '2', '0', '4522528', '');
INSERT INTO `ezs_area` VALUES ('4522531', '2013-07-30 15:37:48', '', '溪湖区', '2', '0', '4522528', '');
INSERT INTO `ezs_area` VALUES ('4522532', '2013-07-30 15:37:48', '', '明山区', '2', '0', '4522528', '');
INSERT INTO `ezs_area` VALUES ('4522533', '2013-07-30 15:37:48', '', '南芬区', '2', '0', '4522528', '');
INSERT INTO `ezs_area` VALUES ('4522534', '2013-07-30 15:37:48', '', '本溪满族自治县', '2', '0', '4522528', '');
INSERT INTO `ezs_area` VALUES ('4522535', '2013-07-30 15:37:48', '', '桓仁满族自治县', '2', '0', '4522528', '');
INSERT INTO `ezs_area` VALUES ('4522536', '2013-07-30 15:37:48', '', '丹东市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522537', '2013-07-30 15:37:48', '', '市辖区', '2', '0', '4522536', '');
INSERT INTO `ezs_area` VALUES ('4522538', '2013-07-30 15:37:48', '', '元宝区', '2', '0', '4522536', '');
INSERT INTO `ezs_area` VALUES ('4522539', '2013-07-30 15:37:48', '', '振兴区', '2', '0', '4522536', '');
INSERT INTO `ezs_area` VALUES ('4522540', '2013-07-30 15:37:48', '', '振安区', '2', '0', '4522536', '');
INSERT INTO `ezs_area` VALUES ('4522541', '2013-07-30 15:37:48', '', '宽甸满族自治县', '2', '0', '4522536', '');
INSERT INTO `ezs_area` VALUES ('4522542', '2013-07-30 15:37:48', '', '东港市', '2', '0', '4522536', '');
INSERT INTO `ezs_area` VALUES ('4522543', '2013-07-30 15:37:49', '', '凤城市', '2', '0', '4522536', '');
INSERT INTO `ezs_area` VALUES ('4522544', '2013-07-30 15:37:49', '', '锦州市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522545', '2013-07-30 15:37:49', '', '市辖区', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522546', '2013-07-30 15:37:49', '', '古塔区', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522547', '2013-07-30 15:37:49', '', '凌河区', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522548', '2013-07-30 15:37:49', '', '太和区', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522549', '2013-07-30 15:37:49', '', '黑山县', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522550', '2013-07-30 15:37:49', '', '义县', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522551', '2013-07-30 15:37:49', '', '凌海市', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522552', '2013-07-30 15:37:49', '', '北镇市', '2', '0', '4522544', '');
INSERT INTO `ezs_area` VALUES ('4522553', '2013-07-30 15:37:49', '', '营口市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522554', '2013-07-30 15:37:49', '', '市辖区', '2', '0', '4522553', '');
INSERT INTO `ezs_area` VALUES ('4522555', '2013-07-30 15:37:49', '', '站前区', '2', '0', '4522553', '');
INSERT INTO `ezs_area` VALUES ('4522556', '2013-07-30 15:37:49', '', '西市区', '2', '0', '4522553', '');
INSERT INTO `ezs_area` VALUES ('4522557', '2013-07-30 15:37:49', '', '鲅鱼圈区', '2', '0', '4522553', '');
INSERT INTO `ezs_area` VALUES ('4522558', '2013-07-30 15:37:49', '', '老边区', '2', '0', '4522553', '');
INSERT INTO `ezs_area` VALUES ('4522559', '2013-07-30 15:37:49', '', '盖州市', '2', '0', '4522553', '');
INSERT INTO `ezs_area` VALUES ('4522560', '2013-07-30 15:37:49', '', '大石桥市', '2', '0', '4522553', '');
INSERT INTO `ezs_area` VALUES ('4522561', '2013-07-30 15:37:49', '', '阜新市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522562', '2013-07-30 15:37:49', '', '市辖区', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522563', '2013-07-30 15:37:49', '', '海州区', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522564', '2013-07-30 15:37:49', '', '新邱区', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522565', '2013-07-30 15:37:49', '', '太平区', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522566', '2013-07-30 15:37:49', '', '清河门区', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522567', '2013-07-30 15:37:49', '', '细河区', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522568', '2013-07-30 15:37:49', '', '阜新蒙古族自治县', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522569', '2013-07-30 15:37:49', '', '彰武县', '2', '0', '4522561', '');
INSERT INTO `ezs_area` VALUES ('4522570', '2013-07-30 15:37:49', '', '辽阳市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522571', '2013-07-30 15:37:50', '', '市辖区', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522572', '2013-07-30 15:37:50', '', '白塔区', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522573', '2013-07-30 15:37:50', '', '文圣区', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522574', '2013-07-30 15:37:50', '', '宏伟区', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522575', '2013-07-30 15:37:50', '', '弓长岭区', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522576', '2013-07-30 15:37:50', '', '太子河区', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522577', '2013-07-30 15:37:50', '', '辽阳县', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522578', '2013-07-30 15:37:50', '', '灯塔市', '2', '0', '4522570', '');
INSERT INTO `ezs_area` VALUES ('4522579', '2013-07-30 15:37:50', '', '盘锦市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522580', '2013-07-30 15:37:50', '', '市辖区', '2', '0', '4522579', '');
INSERT INTO `ezs_area` VALUES ('4522581', '2013-07-30 15:37:50', '', '双台子区', '2', '0', '4522579', '');
INSERT INTO `ezs_area` VALUES ('4522582', '2013-07-30 15:37:50', '', '兴隆台区', '2', '0', '4522579', '');
INSERT INTO `ezs_area` VALUES ('4522583', '2013-07-30 15:37:50', '', '大洼县', '2', '0', '4522579', '');
INSERT INTO `ezs_area` VALUES ('4522584', '2013-07-30 15:37:50', '', '盘山县', '2', '0', '4522579', '');
INSERT INTO `ezs_area` VALUES ('4522585', '2013-07-30 15:37:50', '', '铁岭市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522586', '2013-07-30 15:37:50', '', '市辖区', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522587', '2013-07-30 15:37:50', '', '银州区', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522588', '2013-07-30 15:37:50', '', '清河区', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522589', '2013-07-30 15:37:50', '', '铁岭县', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522590', '2013-07-30 15:37:50', '', '西丰县', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522591', '2013-07-30 15:37:50', '', '昌图县', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522592', '2013-07-30 15:37:50', '', '调兵山市', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522593', '2013-07-30 15:37:50', '', '开原市', '2', '0', '4522585', '');
INSERT INTO `ezs_area` VALUES ('4522594', '2013-07-30 15:37:50', '', '朝阳市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522595', '2013-07-30 15:37:50', '', '市辖区', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522596', '2013-07-30 15:37:50', '', '双塔区', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522597', '2013-07-30 15:37:50', '', '龙城区', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522598', '2013-07-30 15:37:50', '', '朝阳县', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522599', '2013-07-30 15:37:51', '', '建平县', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522600', '2013-07-30 15:37:51', '', '喀喇沁左翼蒙古族自治县', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522601', '2013-07-30 15:37:51', '', '北票市', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522602', '2013-07-30 15:37:51', '', '凌源市', '2', '0', '4522594', '');
INSERT INTO `ezs_area` VALUES ('4522603', '2013-07-30 15:37:51', '', '葫芦岛市', '1', '0', '4522482', '');
INSERT INTO `ezs_area` VALUES ('4522604', '2013-07-30 15:37:51', '', '市辖区', '2', '0', '4522603', '');
INSERT INTO `ezs_area` VALUES ('4522605', '2013-07-30 15:37:51', '', '连山区', '2', '0', '4522603', '');
INSERT INTO `ezs_area` VALUES ('4522606', '2013-07-30 15:37:51', '', '龙港区', '2', '0', '4522603', '');
INSERT INTO `ezs_area` VALUES ('4522607', '2013-07-30 15:37:51', '', '南票区', '2', '0', '4522603', '');
INSERT INTO `ezs_area` VALUES ('4522608', '2013-07-30 15:37:51', '', '绥中县', '2', '0', '4522603', '');
INSERT INTO `ezs_area` VALUES ('4522609', '2013-07-30 15:37:51', '', '建昌县', '2', '0', '4522603', '');
INSERT INTO `ezs_area` VALUES ('4522610', '2013-07-30 15:37:51', '', '兴城市', '2', '0', '4522603', '');
INSERT INTO `ezs_area` VALUES ('4522611', '2013-07-30 15:37:51', '', '吉林省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522612', '2013-07-30 15:37:51', '', '长春市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522613', '2013-07-30 15:37:51', '', '市辖区', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522614', '2013-07-30 15:37:51', '', '南关区', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522615', '2013-07-30 15:37:51', '', '宽城区', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522616', '2013-07-30 15:37:51', '', '朝阳区', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522617', '2013-07-30 15:37:51', '', '二道区', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522618', '2013-07-30 15:37:51', '', '绿园区', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522619', '2013-07-30 15:37:51', '', '双阳区', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522620', '2013-07-30 15:37:51', '', '农安县', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522621', '2013-07-30 15:37:51', '', '九台市', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522622', '2013-07-30 15:37:51', '', '榆树市', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522623', '2013-07-30 15:37:51', '', '德惠市', '2', '0', '4522612', '');
INSERT INTO `ezs_area` VALUES ('4522624', '2013-07-30 15:37:51', '', '吉林市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522625', '2013-07-30 15:37:51', '', '市辖区', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522626', '2013-07-30 15:37:52', '', '昌邑区', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522627', '2013-07-30 15:37:52', '', '龙潭区', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522628', '2013-07-30 15:37:52', '', '船营区', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522629', '2013-07-30 15:37:52', '', '丰满区', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522630', '2013-07-30 15:37:52', '', '永吉县', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522631', '2013-07-30 15:37:52', '', '蛟河市', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522632', '2013-07-30 15:37:52', '', '桦甸市', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522633', '2013-07-30 15:37:52', '', '舒兰市', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522634', '2013-07-30 15:37:52', '', '磐石市', '2', '0', '4522624', '');
INSERT INTO `ezs_area` VALUES ('4522635', '2013-07-30 15:37:52', '', '四平市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522636', '2013-07-30 15:37:52', '', '市辖区', '2', '0', '4522635', '');
INSERT INTO `ezs_area` VALUES ('4522637', '2013-07-30 15:37:52', '', '铁西区', '2', '0', '4522635', '');
INSERT INTO `ezs_area` VALUES ('4522638', '2013-07-30 15:37:52', '', '铁东区', '2', '0', '4522635', '');
INSERT INTO `ezs_area` VALUES ('4522639', '2013-07-30 15:37:52', '', '梨树县', '2', '0', '4522635', '');
INSERT INTO `ezs_area` VALUES ('4522640', '2013-07-30 15:37:52', '', '伊通满族自治县', '2', '0', '4522635', '');
INSERT INTO `ezs_area` VALUES ('4522641', '2013-07-30 15:37:52', '', '公主岭市', '2', '0', '4522635', '');
INSERT INTO `ezs_area` VALUES ('4522642', '2013-07-30 15:37:52', '', '双辽市', '2', '0', '4522635', '');
INSERT INTO `ezs_area` VALUES ('4522643', '2013-07-30 15:37:52', '', '辽源市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522644', '2013-07-30 15:37:52', '', '市辖区', '2', '0', '4522643', '');
INSERT INTO `ezs_area` VALUES ('4522645', '2013-07-30 15:37:52', '', '龙山区', '2', '0', '4522643', '');
INSERT INTO `ezs_area` VALUES ('4522646', '2013-07-30 15:37:52', '', '西安区', '2', '0', '4522643', '');
INSERT INTO `ezs_area` VALUES ('4522647', '2013-07-30 15:37:52', '', '东丰县', '2', '0', '4522643', '');
INSERT INTO `ezs_area` VALUES ('4522648', '2013-07-30 15:37:52', '', '东辽县', '2', '0', '4522643', '');
INSERT INTO `ezs_area` VALUES ('4522649', '2013-07-30 15:37:52', '', '通化市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522650', '2013-07-30 15:37:52', '', '市辖区', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522651', '2013-07-30 15:37:52', '', '东昌区', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522652', '2013-07-30 15:37:52', '', '二道江区', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522653', '2013-07-30 15:37:52', '', '通化县', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522654', '2013-07-30 15:37:53', '', '辉南县', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522655', '2013-07-30 15:37:53', '', '柳河县', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522656', '2013-07-30 15:37:53', '', '梅河口市', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522657', '2013-07-30 15:37:53', '', '集安市', '2', '0', '4522649', '');
INSERT INTO `ezs_area` VALUES ('4522658', '2013-07-30 15:37:53', '', '白山市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522659', '2013-07-30 15:37:53', '', '市辖区', '2', '0', '4522658', '');
INSERT INTO `ezs_area` VALUES ('4522660', '2013-07-30 15:37:53', '', '八道江区', '2', '0', '4522658', '');
INSERT INTO `ezs_area` VALUES ('4522661', '2013-07-30 15:37:53', '', '江源区', '2', '0', '4522658', '');
INSERT INTO `ezs_area` VALUES ('4522662', '2013-07-30 15:37:53', '', '抚松县', '2', '0', '4522658', '');
INSERT INTO `ezs_area` VALUES ('4522663', '2013-07-30 15:37:53', '', '靖宇县', '2', '0', '4522658', '');
INSERT INTO `ezs_area` VALUES ('4522664', '2013-07-30 15:37:53', '', '长白朝鲜族自治县', '2', '0', '4522658', '');
INSERT INTO `ezs_area` VALUES ('4522665', '2013-07-30 15:37:53', '', '临江市', '2', '0', '4522658', '');
INSERT INTO `ezs_area` VALUES ('4522666', '2013-07-30 15:37:53', '', '松原市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522667', '2013-07-30 15:37:53', '', '市辖区', '2', '0', '4522666', '');
INSERT INTO `ezs_area` VALUES ('4522668', '2013-07-30 15:37:53', '', '宁江区', '2', '0', '4522666', '');
INSERT INTO `ezs_area` VALUES ('4522669', '2013-07-30 15:37:53', '', '前郭尔罗斯蒙古族自治县', '2', '0', '4522666', '');
INSERT INTO `ezs_area` VALUES ('4522670', '2013-07-30 15:37:53', '', '长岭县', '2', '0', '4522666', '');
INSERT INTO `ezs_area` VALUES ('4522671', '2013-07-30 15:37:53', '', '乾安县', '2', '0', '4522666', '');
INSERT INTO `ezs_area` VALUES ('4522672', '2013-07-30 15:37:53', '', '扶余县', '2', '0', '4522666', '');
INSERT INTO `ezs_area` VALUES ('4522673', '2013-07-30 15:37:53', '', '白城市', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522674', '2013-07-30 15:37:53', '', '市辖区', '2', '0', '4522673', '');
INSERT INTO `ezs_area` VALUES ('4522675', '2013-07-30 15:37:53', '', '洮北区', '2', '0', '4522673', '');
INSERT INTO `ezs_area` VALUES ('4522676', '2013-07-30 15:37:53', '', '镇赉县', '2', '0', '4522673', '');
INSERT INTO `ezs_area` VALUES ('4522677', '2013-07-30 15:37:53', '', '通榆县', '2', '0', '4522673', '');
INSERT INTO `ezs_area` VALUES ('4522678', '2013-07-30 15:37:53', '', '洮南市', '2', '0', '4522673', '');
INSERT INTO `ezs_area` VALUES ('4522679', '2013-07-30 15:37:53', '', '大安市', '2', '0', '4522673', '');
INSERT INTO `ezs_area` VALUES ('4522680', '2013-07-30 15:37:53', '', '延边朝鲜族自治州', '1', '0', '4522611', '');
INSERT INTO `ezs_area` VALUES ('4522681', '2013-07-30 15:37:53', '', '延吉市', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522682', '2013-07-30 15:37:54', '', '图们市', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522683', '2013-07-30 15:37:54', '', '敦化市', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522684', '2013-07-30 15:37:54', '', '珲春市', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522685', '2013-07-30 15:37:54', '', '龙井市', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522686', '2013-07-30 15:37:54', '', '和龙市', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522687', '2013-07-30 15:37:54', '', '汪清县', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522688', '2013-07-30 15:37:54', '', '安图县', '2', '0', '4522680', '');
INSERT INTO `ezs_area` VALUES ('4522689', '2013-07-30 15:37:54', '', '黑龙江省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522690', '2013-07-30 15:37:54', '', '哈尔滨市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522691', '2013-07-30 15:37:54', '', '市辖区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522692', '2013-07-30 15:37:54', '', '道里区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522693', '2013-07-30 15:37:54', '', '南岗区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522694', '2013-07-30 15:37:54', '', '道外区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522695', '2013-07-30 15:37:54', '', '平房区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522696', '2013-07-30 15:37:54', '', '松北区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522697', '2013-07-30 15:37:54', '', '香坊区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522698', '2013-07-30 15:37:54', '', '呼兰区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522699', '2013-07-30 15:37:54', '', '阿城区', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522700', '2013-07-30 15:37:54', '', '依兰县', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522701', '2013-07-30 15:37:54', '', '方正县', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522702', '2013-07-30 15:37:54', '', '宾县', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522703', '2013-07-30 15:37:54', '', '巴彦县', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522704', '2013-07-30 15:37:54', '', '木兰县', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522705', '2013-07-30 15:37:54', '', '通河县', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522706', '2013-07-30 15:37:54', '', '延寿县', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522707', '2013-07-30 15:37:54', '', '双城市', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522708', '2013-07-30 15:37:54', '', '尚志市', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522709', '2013-07-30 15:37:55', '', '五常市', '2', '0', '4522690', '');
INSERT INTO `ezs_area` VALUES ('4522710', '2013-07-30 15:37:55', '', '齐齐哈尔市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522711', '2013-07-30 15:37:55', '', '市辖区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522712', '2013-07-30 15:37:55', '', '龙沙区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522713', '2013-07-30 15:37:55', '', '建华区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522714', '2013-07-30 15:37:55', '', '铁锋区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522715', '2013-07-30 15:37:55', '', '昂昂溪区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522716', '2013-07-30 15:37:55', '', '富拉尔基区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522717', '2013-07-30 15:37:55', '', '碾子山区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522718', '2013-07-30 15:37:55', '', '梅里斯达斡尔族区', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522719', '2013-07-30 15:37:55', '', '龙江县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522720', '2013-07-30 15:37:55', '', '依安县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522721', '2013-07-30 15:37:55', '', '泰来县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522722', '2013-07-30 15:37:55', '', '甘南县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522723', '2013-07-30 15:37:55', '', '富裕县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522724', '2013-07-30 15:37:55', '', '克山县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522725', '2013-07-30 15:37:55', '', '克东县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522726', '2013-07-30 15:37:55', '', '拜泉县', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522727', '2013-07-30 15:37:55', '', '讷河市', '2', '0', '4522710', '');
INSERT INTO `ezs_area` VALUES ('4522728', '2013-07-30 15:37:55', '', '鸡西市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522729', '2013-07-30 15:37:55', '', '市辖区', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522730', '2013-07-30 15:37:55', '', '鸡冠区', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522731', '2013-07-30 15:37:55', '', '恒山区', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522732', '2013-07-30 15:37:56', '', '滴道区', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522733', '2013-07-30 15:37:56', '', '梨树区', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522734', '2013-07-30 15:37:56', '', '城子河区', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522735', '2013-07-30 15:37:56', '', '麻山区', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522736', '2013-07-30 15:37:56', '', '鸡东县', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522737', '2013-07-30 15:37:56', '', '虎林市', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522738', '2013-07-30 15:37:56', '', '密山市', '2', '0', '4522728', '');
INSERT INTO `ezs_area` VALUES ('4522739', '2013-07-30 15:37:56', '', '鹤岗市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522740', '2013-07-30 15:37:56', '', '市辖区', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522741', '2013-07-30 15:37:56', '', '向阳区', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522742', '2013-07-30 15:37:56', '', '工农区', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522743', '2013-07-30 15:37:56', '', '南山区', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522744', '2013-07-30 15:37:56', '', '兴安区', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522745', '2013-07-30 15:37:56', '', '东山区', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522746', '2013-07-30 15:37:56', '', '兴山区', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522747', '2013-07-30 15:37:56', '', '萝北县', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522748', '2013-07-30 15:37:56', '', '绥滨县', '2', '0', '4522739', '');
INSERT INTO `ezs_area` VALUES ('4522749', '2013-07-30 15:37:56', '', '双鸭山市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522750', '2013-07-30 15:37:56', '', '市辖区', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522751', '2013-07-30 15:37:56', '', '尖山区', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522752', '2013-07-30 15:37:56', '', '岭东区', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522753', '2013-07-30 15:37:56', '', '四方台区', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522754', '2013-07-30 15:37:56', '', '宝山区', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522755', '2013-07-30 15:37:56', '', '集贤县', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522756', '2013-07-30 15:37:57', '', '友谊县', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522757', '2013-07-30 15:37:57', '', '宝清县', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522758', '2013-07-30 15:37:57', '', '饶河县', '2', '0', '4522749', '');
INSERT INTO `ezs_area` VALUES ('4522759', '2013-07-30 15:37:57', '', '大庆市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522760', '2013-07-30 15:37:57', '', '市辖区', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522761', '2013-07-30 15:37:57', '', '萨尔图区', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522762', '2013-07-30 15:37:57', '', '龙凤区', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522763', '2013-07-30 15:37:57', '', '让胡路区', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522764', '2013-07-30 15:37:57', '', '红岗区', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522765', '2013-07-30 15:37:57', '', '大同区', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522766', '2013-07-30 15:37:57', '', '肇州县', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522767', '2013-07-30 15:37:57', '', '肇源县', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522768', '2013-07-30 15:37:57', '', '林甸县', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522769', '2013-07-30 15:37:57', '', '杜尔伯特蒙古族自治县', '2', '0', '4522759', '');
INSERT INTO `ezs_area` VALUES ('4522770', '2013-07-30 15:37:57', '', '伊春市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522771', '2013-07-30 15:37:57', '', '市辖区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522772', '2013-07-30 15:37:57', '', '伊春区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522773', '2013-07-30 15:37:57', '', '南岔区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522774', '2013-07-30 15:37:57', '', '友好区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522775', '2013-07-30 15:37:57', '', '西林区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522776', '2013-07-30 15:37:57', '', '翠峦区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522777', '2013-07-30 15:37:57', '', '新青区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522778', '2013-07-30 15:37:57', '', '美溪区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522779', '2013-07-30 15:37:58', '', '金山屯区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522780', '2013-07-30 15:37:58', '', '五营区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522781', '2013-07-30 15:37:58', '', '乌马河区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522782', '2013-07-30 15:37:58', '', '汤旺河区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522783', '2013-07-30 15:37:58', '', '带岭区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522784', '2013-07-30 15:37:58', '', '乌伊岭区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522785', '2013-07-30 15:37:58', '', '红星区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522786', '2013-07-30 15:37:58', '', '上甘岭区', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522787', '2013-07-30 15:37:58', '', '嘉荫县', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522788', '2013-07-30 15:37:58', '', '铁力市', '2', '0', '4522770', '');
INSERT INTO `ezs_area` VALUES ('4522789', '2013-07-30 15:37:58', '', '佳木斯市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522790', '2013-07-30 15:37:58', '', '市辖区', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522791', '2013-07-30 15:37:58', '', '向阳区', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522792', '2013-07-30 15:37:58', '', '前进区', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522793', '2013-07-30 15:37:58', '', '东风区', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522794', '2013-07-30 15:37:58', '', '郊区', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522795', '2013-07-30 15:37:58', '', '桦南县', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522796', '2013-07-30 15:37:58', '', '桦川县', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522797', '2013-07-30 15:37:58', '', '汤原县', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522798', '2013-07-30 15:37:58', '', '抚远县', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522799', '2013-07-30 15:37:58', '', '同江市', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522800', '2013-07-30 15:37:58', '', '富锦市', '2', '0', '4522789', '');
INSERT INTO `ezs_area` VALUES ('4522801', '2013-07-30 15:37:58', '', '七台河市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522802', '2013-07-30 15:37:58', '', '市辖区', '2', '0', '4522801', '');
INSERT INTO `ezs_area` VALUES ('4522803', '2013-07-30 15:37:59', '', '新兴区', '2', '0', '4522801', '');
INSERT INTO `ezs_area` VALUES ('4522804', '2013-07-30 15:37:59', '', '桃山区', '2', '0', '4522801', '');
INSERT INTO `ezs_area` VALUES ('4522805', '2013-07-30 15:37:59', '', '茄子河区', '2', '0', '4522801', '');
INSERT INTO `ezs_area` VALUES ('4522806', '2013-07-30 15:37:59', '', '勃利县', '2', '0', '4522801', '');
INSERT INTO `ezs_area` VALUES ('4522807', '2013-07-30 15:37:59', '', '牡丹江市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522808', '2013-07-30 15:37:59', '', '市辖区', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522809', '2013-07-30 15:37:59', '', '东安区', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522810', '2013-07-30 15:37:59', '', '阳明区', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522811', '2013-07-30 15:37:59', '', '爱民区', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522812', '2013-07-30 15:37:59', '', '西安区', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522813', '2013-07-30 15:37:59', '', '东宁县', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522814', '2013-07-30 15:37:59', '', '林口县', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522815', '2013-07-30 15:37:59', '', '绥芬河市', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522816', '2013-07-30 15:37:59', '', '海林市', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522817', '2013-07-30 15:37:59', '', '宁安市', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522818', '2013-07-30 15:37:59', '', '穆棱市', '2', '0', '4522807', '');
INSERT INTO `ezs_area` VALUES ('4522819', '2013-07-30 15:37:59', '', '黑河市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522820', '2013-07-30 15:37:59', '', '市辖区', '2', '0', '4522819', '');
INSERT INTO `ezs_area` VALUES ('4522821', '2013-07-30 15:37:59', '', '爱辉区', '2', '0', '4522819', '');
INSERT INTO `ezs_area` VALUES ('4522822', '2013-07-30 15:37:59', '', '嫩江县', '2', '0', '4522819', '');
INSERT INTO `ezs_area` VALUES ('4522823', '2013-07-30 15:37:59', '', '逊克县', '2', '0', '4522819', '');
INSERT INTO `ezs_area` VALUES ('4522824', '2013-07-30 15:37:59', '', '孙吴县', '2', '0', '4522819', '');
INSERT INTO `ezs_area` VALUES ('4522825', '2013-07-30 15:38:00', '', '北安市', '2', '0', '4522819', '');
INSERT INTO `ezs_area` VALUES ('4522826', '2013-07-30 15:38:00', '', '五大连池市', '2', '0', '4522819', '');
INSERT INTO `ezs_area` VALUES ('4522827', '2013-07-30 15:38:00', '', '绥化市', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522828', '2013-07-30 15:38:00', '', '市辖区', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522829', '2013-07-30 15:38:00', '', '北林区', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522830', '2013-07-30 15:38:00', '', '望奎县', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522831', '2013-07-30 15:38:00', '', '兰西县', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522832', '2013-07-30 15:38:00', '', '青冈县', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522833', '2013-07-30 15:38:00', '', '庆安县', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522834', '2013-07-30 15:38:00', '', '明水县', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522835', '2013-07-30 15:38:00', '', '绥棱县', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522836', '2013-07-30 15:38:00', '', '安达市', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522837', '2013-07-30 15:38:00', '', '肇东市', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522838', '2013-07-30 15:38:00', '', '海伦市', '2', '0', '4522827', '');
INSERT INTO `ezs_area` VALUES ('4522839', '2013-07-30 15:38:00', '', '大兴安岭地区', '1', '0', '4522689', '');
INSERT INTO `ezs_area` VALUES ('4522840', '2013-07-30 15:38:00', '', '加格达奇区', '2', '0', '4522839', '');
INSERT INTO `ezs_area` VALUES ('4522841', '2013-07-30 15:38:00', '', '松岭区', '2', '0', '4522839', '');
INSERT INTO `ezs_area` VALUES ('4522842', '2013-07-30 15:38:00', '', '新林区', '2', '0', '4522839', '');
INSERT INTO `ezs_area` VALUES ('4522843', '2013-07-30 15:38:00', '', '呼中区', '2', '0', '4522839', '');
INSERT INTO `ezs_area` VALUES ('4522844', '2013-07-30 15:38:00', '', '呼玛县', '2', '0', '4522839', '');
INSERT INTO `ezs_area` VALUES ('4522845', '2013-07-30 15:38:00', '', '塔河县', '2', '0', '4522839', '');
INSERT INTO `ezs_area` VALUES ('4522846', '2013-07-30 15:38:00', '', '漠河县', '2', '0', '4522839', '');
INSERT INTO `ezs_area` VALUES ('4522847', '2013-07-30 15:38:00', '', '上海市', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522848', '2013-07-30 15:38:01', '', '上海市', '1', '0', '4522847', '');
INSERT INTO `ezs_area` VALUES ('4522849', '2013-07-30 15:38:01', '', '黄浦区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522850', '2013-07-30 15:38:01', '', '卢湾区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522851', '2013-07-30 15:38:01', '', '徐汇区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522852', '2013-07-30 15:38:01', '', '长宁区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522853', '2013-07-30 15:38:01', '', '静安区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522854', '2013-07-30 15:38:01', '', '普陀区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522855', '2013-07-30 15:38:01', '', '闸北区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522856', '2013-07-30 15:38:01', '', '虹口区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522857', '2013-07-30 15:38:01', '', '杨浦区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522858', '2013-07-30 15:38:01', '', '闵行区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522859', '2013-07-30 15:38:01', '', '宝山区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522860', '2013-07-30 15:38:01', '', '嘉定区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522861', '2013-07-30 15:38:01', '', '浦东新区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522862', '2013-07-30 15:38:01', '', '金山区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522863', '2013-07-30 15:38:01', '', '松江区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522864', '2013-07-30 15:38:01', '', '青浦区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522865', '2013-07-30 15:38:01', '', '奉贤区', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522867', '2013-07-30 15:38:01', '', '崇明县', '2', '0', '4522848', '');
INSERT INTO `ezs_area` VALUES ('4522868', '2013-07-30 15:38:01', '', '江苏省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4522869', '2013-07-30 15:38:02', '', '南京市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522870', '2013-07-30 15:38:02', '', '市辖区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522871', '2013-07-30 15:38:02', '', '玄武区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522872', '2013-07-30 15:38:02', '', '白下区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522873', '2013-07-30 15:38:02', '', '秦淮区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522874', '2013-07-30 15:38:02', '', '建邺区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522875', '2013-07-30 15:38:02', '', '鼓楼区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522876', '2013-07-30 15:38:02', '', '下关区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522877', '2013-07-30 15:38:02', '', '浦口区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522878', '2013-07-30 15:38:02', '', '栖霞区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522879', '2013-07-30 15:38:02', '', '雨花台区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522880', '2013-07-30 15:38:02', '', '江宁区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522881', '2013-07-30 15:38:02', '', '六合区', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522882', '2013-07-30 15:38:02', '', '溧水县', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522883', '2013-07-30 15:38:02', '', '高淳县', '2', '0', '4522869', '');
INSERT INTO `ezs_area` VALUES ('4522884', '2013-07-30 15:38:02', '', '无锡市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522885', '2013-07-30 15:38:02', '', '市辖区', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522886', '2013-07-30 15:38:02', '', '崇安区', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522887', '2013-07-30 15:38:02', '', '南长区', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522888', '2013-07-30 15:38:02', '', '北塘区', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522889', '2013-07-30 15:38:02', '', '锡山区', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522890', '2013-07-30 15:38:02', '', '惠山区', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522891', '2013-07-30 15:38:03', '', '滨湖区', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522892', '2013-07-30 15:38:03', '', '江阴市', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522893', '2013-07-30 15:38:03', '', '宜兴市', '2', '0', '4522884', '');
INSERT INTO `ezs_area` VALUES ('4522894', '2013-07-30 15:38:03', '', '徐州市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522895', '2013-07-30 15:38:03', '', '市辖区', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522896', '2013-07-30 15:38:03', '', '鼓楼区', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522897', '2013-07-30 15:38:03', '', '云龙区', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522898', '2013-07-30 15:38:03', '', '贾汪区', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522899', '2013-07-30 15:38:03', '', '泉山区', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522900', '2013-07-30 15:38:03', '', '铜山区', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522901', '2013-07-30 15:38:03', '', '丰县', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522902', '2013-07-30 15:38:03', '', '沛县', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522903', '2013-07-30 15:38:03', '', '睢宁县', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522904', '2013-07-30 15:38:03', '', '新沂市', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522905', '2013-07-30 15:38:03', '', '邳州市', '2', '0', '4522894', '');
INSERT INTO `ezs_area` VALUES ('4522906', '2013-07-30 15:38:03', '', '常州市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522907', '2013-07-30 15:38:03', '', '市辖区', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522908', '2013-07-30 15:38:03', '', '天宁区', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522909', '2013-07-30 15:38:03', '', '钟楼区', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522910', '2013-07-30 15:38:03', '', '戚墅堰区', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522911', '2013-07-30 15:38:03', '', '新北区', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522912', '2013-07-30 15:38:03', '', '武进区', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522913', '2013-07-30 15:38:04', '', '溧阳市', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522914', '2013-07-30 15:38:04', '', '金坛市', '2', '0', '4522906', '');
INSERT INTO `ezs_area` VALUES ('4522915', '2013-07-30 15:38:04', '', '苏州市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522916', '2013-07-30 15:38:04', '', '市辖区', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522917', '2013-07-30 15:38:04', '', '沧浪区', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522918', '2013-07-30 15:38:04', '', '平江区', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522919', '2013-07-30 15:38:04', '', '金阊区', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522920', '2013-07-30 15:38:04', '', '虎丘区', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522921', '2013-07-30 15:38:04', '', '吴中区', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522922', '2013-07-30 15:38:04', '', '相城区', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522923', '2013-07-30 15:38:04', '', '常熟市', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522924', '2013-07-30 15:38:04', '', '张家港市', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522925', '2013-07-30 15:38:04', '', '昆山市', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522926', '2013-07-30 15:38:04', '', '吴江市', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522927', '2013-07-30 15:38:04', '', '太仓市', '2', '0', '4522915', '');
INSERT INTO `ezs_area` VALUES ('4522928', '2013-07-30 15:38:04', '', '南通市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522929', '2013-07-30 15:38:04', '', '市辖区', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522930', '2013-07-30 15:38:04', '', '崇川区', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522931', '2013-07-30 15:38:04', '', '港闸区', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522932', '2013-07-30 15:38:04', '', '通州区', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522933', '2013-07-30 15:38:04', '', '海安县', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522934', '2013-07-30 15:38:04', '', '如东县', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522935', '2013-07-30 15:38:05', '', '启东市', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522936', '2013-07-30 15:38:05', '', '如皋市', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522937', '2013-07-30 15:38:05', '', '海门市', '2', '0', '4522928', '');
INSERT INTO `ezs_area` VALUES ('4522938', '2013-07-30 15:38:05', '', '连云港市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522939', '2013-07-30 15:38:05', '', '市辖区', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522940', '2013-07-30 15:38:05', '', '连云区', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522941', '2013-07-30 15:38:05', '', '新浦区', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522942', '2013-07-30 15:38:05', '', '海州区', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522943', '2013-07-30 15:38:05', '', '赣榆县', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522944', '2013-07-30 15:38:05', '', '东海县', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522945', '2013-07-30 15:38:05', '', '灌云县', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522946', '2013-07-30 15:38:05', '', '灌南县', '2', '0', '4522938', '');
INSERT INTO `ezs_area` VALUES ('4522947', '2013-07-30 15:38:05', '', '淮安市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522948', '2013-07-30 15:38:05', '', '市辖区', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522949', '2013-07-30 15:38:05', '', '清河区', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522950', '2013-07-30 15:38:05', '', '楚州区', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522951', '2013-07-30 15:38:05', '', '淮阴区', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522952', '2013-07-30 15:38:05', '', '清浦区', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522953', '2013-07-30 15:38:05', '', '涟水县', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522954', '2013-07-30 15:38:05', '', '洪泽县', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522955', '2013-07-30 15:38:05', '', '盱眙县', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522956', '2013-07-30 15:38:05', '', '金湖县', '2', '0', '4522947', '');
INSERT INTO `ezs_area` VALUES ('4522957', '2013-07-30 15:38:06', '', '盐城市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522958', '2013-07-30 15:38:06', '', '市辖区', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522959', '2013-07-30 15:38:06', '', '亭湖区', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522960', '2013-07-30 15:38:06', '', '盐都区', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522961', '2013-07-30 15:38:06', '', '响水县', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522962', '2013-07-30 15:38:06', '', '滨海县', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522963', '2013-07-30 15:38:06', '', '阜宁县', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522964', '2013-07-30 15:38:06', '', '射阳县', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522965', '2013-07-30 15:38:06', '', '建湖县', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522966', '2013-07-30 15:38:06', '', '东台市', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522967', '2013-07-30 15:38:06', '', '大丰市', '2', '0', '4522957', '');
INSERT INTO `ezs_area` VALUES ('4522968', '2013-07-30 15:38:06', '', '扬州市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522969', '2013-07-30 15:38:06', '', '市辖区', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522970', '2013-07-30 15:38:06', '', '广陵区', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522971', '2013-07-30 15:38:06', '', '邗江区', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522972', '2013-07-30 15:38:06', '', '维扬区', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522973', '2013-07-30 15:38:06', '', '宝应县', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522974', '2013-07-30 15:38:06', '', '仪征市', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522975', '2013-07-30 15:38:06', '', '高邮市', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522976', '2013-07-30 15:38:06', '', '江都市', '2', '0', '4522968', '');
INSERT INTO `ezs_area` VALUES ('4522977', '2013-07-30 15:38:06', '', '镇江市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522978', '2013-07-30 15:38:07', '', '市辖区', '2', '0', '4522977', '');
INSERT INTO `ezs_area` VALUES ('4522979', '2013-07-30 15:38:07', '', '京口区', '2', '0', '4522977', '');
INSERT INTO `ezs_area` VALUES ('4522980', '2013-07-30 15:38:07', '', '润州区', '2', '0', '4522977', '');
INSERT INTO `ezs_area` VALUES ('4522981', '2013-07-30 15:38:07', '', '丹徒区', '2', '0', '4522977', '');
INSERT INTO `ezs_area` VALUES ('4522982', '2013-07-30 15:38:07', '', '丹阳市', '2', '0', '4522977', '');
INSERT INTO `ezs_area` VALUES ('4522983', '2013-07-30 15:38:07', '', '扬中市', '2', '0', '4522977', '');
INSERT INTO `ezs_area` VALUES ('4522984', '2013-07-30 15:38:07', '', '句容市', '2', '0', '4522977', '');
INSERT INTO `ezs_area` VALUES ('4522985', '2013-07-30 15:38:07', '', '泰州市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522986', '2013-07-30 15:38:07', '', '市辖区', '2', '0', '4522985', '');
INSERT INTO `ezs_area` VALUES ('4522987', '2013-07-30 15:38:07', '', '海陵区', '2', '0', '4522985', '');
INSERT INTO `ezs_area` VALUES ('4522988', '2013-07-30 15:38:07', '', '高港区', '2', '0', '4522985', '');
INSERT INTO `ezs_area` VALUES ('4522989', '2013-07-30 15:38:07', '', '兴化市', '2', '0', '4522985', '');
INSERT INTO `ezs_area` VALUES ('4522990', '2013-07-30 15:38:07', '', '靖江市', '2', '0', '4522985', '');
INSERT INTO `ezs_area` VALUES ('4522991', '2013-07-30 15:38:07', '', '泰兴市', '2', '0', '4522985', '');
INSERT INTO `ezs_area` VALUES ('4522992', '2013-07-30 15:38:07', '', '姜堰市', '2', '0', '4522985', '');
INSERT INTO `ezs_area` VALUES ('4522993', '2013-07-30 15:38:07', '', '宿迁市', '1', '0', '4522868', '');
INSERT INTO `ezs_area` VALUES ('4522994', '2013-07-30 15:38:07', '', '市辖区', '2', '0', '4522993', '');
INSERT INTO `ezs_area` VALUES ('4522995', '2013-07-30 15:38:07', '', '宿城区', '2', '0', '4522993', '');
INSERT INTO `ezs_area` VALUES ('4522996', '2013-07-30 15:38:07', '', '宿豫区', '2', '0', '4522993', '');
INSERT INTO `ezs_area` VALUES ('4522997', '2013-07-30 15:38:07', '', '沭阳县', '2', '0', '4522993', '');
INSERT INTO `ezs_area` VALUES ('4522998', '2013-07-30 15:38:07', '', '泗阳县', '2', '0', '4522993', '');
INSERT INTO `ezs_area` VALUES ('4522999', '2013-07-30 15:38:08', '', '泗洪县', '2', '0', '4522993', '');
INSERT INTO `ezs_area` VALUES ('4523000', '2013-07-30 15:38:08', '', '浙江省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523001', '2013-07-30 15:38:08', '', '杭州市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523002', '2013-07-30 15:38:08', '', '市辖区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523003', '2013-07-30 15:38:08', '', '上城区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523004', '2013-07-30 15:38:08', '', '下城区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523005', '2013-07-30 15:38:08', '', '江干区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523006', '2013-07-30 15:38:08', '', '拱墅区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523007', '2013-07-30 15:38:08', '', '西湖区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523008', '2013-07-30 15:38:08', '', '滨江区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523009', '2013-07-30 15:38:08', '', '萧山区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523010', '2013-07-30 15:38:08', '', '余杭区', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523011', '2013-07-30 15:38:08', '', '桐庐县', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523012', '2013-07-30 15:38:08', '', '淳安县', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523013', '2013-07-30 15:38:08', '', '建德市', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523014', '2013-07-30 15:38:08', '', '富阳市', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523015', '2013-07-30 15:38:08', '', '临安市', '2', '0', '4523001', '');
INSERT INTO `ezs_area` VALUES ('4523016', '2013-07-30 15:38:08', '', '宁波市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523017', '2013-07-30 15:38:08', '', '市辖区', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523018', '2013-07-30 15:38:08', '', '海曙区', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523019', '2013-07-30 15:38:08', '', '江东区', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523020', '2013-07-30 15:38:09', '', '江北区', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523021', '2013-07-30 15:38:09', '', '北仑区', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523022', '2013-07-30 15:38:09', '', '镇海区', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523023', '2013-07-30 15:38:09', '', '鄞州区', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523024', '2013-07-30 15:38:09', '', '象山县', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523025', '2013-07-30 15:38:09', '', '宁海县', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523026', '2013-07-30 15:38:09', '', '余姚市', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523027', '2013-07-30 15:38:09', '', '慈溪市', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523028', '2013-07-30 15:38:09', '', '奉化市', '2', '0', '4523016', '');
INSERT INTO `ezs_area` VALUES ('4523029', '2013-07-30 15:38:09', '', '温州市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523030', '2013-07-30 15:38:09', '', '市辖区', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523031', '2013-07-30 15:38:09', '', '鹿城区', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523032', '2013-07-30 15:38:09', '', '龙湾区', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523033', '2013-07-30 15:38:09', '', '瓯海区', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523034', '2013-07-30 15:38:09', '', '洞头县', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523035', '2013-07-30 15:38:09', '', '永嘉县', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523036', '2013-07-30 15:38:09', '', '平阳县', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523037', '2013-07-30 15:38:09', '', '苍南县', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523038', '2013-07-30 15:38:09', '', '文成县', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523039', '2013-07-30 15:38:10', '', '泰顺县', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523040', '2013-07-30 15:38:10', '', '瑞安市', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523041', '2013-07-30 15:38:10', '', '乐清市', '2', '0', '4523029', '');
INSERT INTO `ezs_area` VALUES ('4523042', '2013-07-30 15:38:10', '', '嘉兴市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523043', '2013-07-30 15:38:10', '', '市辖区', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523044', '2013-07-30 15:38:10', '', '南湖区', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523045', '2013-07-30 15:38:10', '', '秀洲区', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523046', '2013-07-30 15:38:10', '', '嘉善县', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523047', '2013-07-30 15:38:10', '', '海盐县', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523048', '2013-07-30 15:38:10', '', '海宁市', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523049', '2013-07-30 15:38:10', '', '平湖市', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523050', '2013-07-30 15:38:10', '', '桐乡市', '2', '0', '4523042', '');
INSERT INTO `ezs_area` VALUES ('4523051', '2013-07-30 15:38:10', '', '湖州市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523052', '2013-07-30 15:38:10', '', '市辖区', '2', '0', '4523051', '');
INSERT INTO `ezs_area` VALUES ('4523053', '2013-07-30 15:38:10', '', '吴兴区', '2', '0', '4523051', '');
INSERT INTO `ezs_area` VALUES ('4523054', '2013-07-30 15:38:10', '', '南浔区', '2', '0', '4523051', '');
INSERT INTO `ezs_area` VALUES ('4523055', '2013-07-30 15:38:10', '', '德清县', '2', '0', '4523051', '');
INSERT INTO `ezs_area` VALUES ('4523056', '2013-07-30 15:38:10', '', '长兴县', '2', '0', '4523051', '');
INSERT INTO `ezs_area` VALUES ('4523057', '2013-07-30 15:38:10', '', '安吉县', '2', '0', '4523051', '');
INSERT INTO `ezs_area` VALUES ('4523058', '2013-07-30 15:38:10', '', '绍兴市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523059', '2013-07-30 15:38:11', '', '市辖区', '2', '0', '4523058', '');
INSERT INTO `ezs_area` VALUES ('4523060', '2013-07-30 15:38:11', '', '越城区', '2', '0', '4523058', '');
INSERT INTO `ezs_area` VALUES ('4523061', '2013-07-30 15:38:11', '', '绍兴县', '2', '0', '4523058', '');
INSERT INTO `ezs_area` VALUES ('4523062', '2013-07-30 15:38:11', '', '新昌县', '2', '0', '4523058', '');
INSERT INTO `ezs_area` VALUES ('4523063', '2013-07-30 15:38:11', '', '诸暨市', '2', '0', '4523058', '');
INSERT INTO `ezs_area` VALUES ('4523064', '2013-07-30 15:38:11', '', '上虞市', '2', '0', '4523058', '');
INSERT INTO `ezs_area` VALUES ('4523065', '2013-07-30 15:38:11', '', '嵊州市', '2', '0', '4523058', '');
INSERT INTO `ezs_area` VALUES ('4523066', '2013-07-30 15:38:11', '', '金华市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523067', '2013-07-30 15:38:11', '', '市辖区', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523068', '2013-07-30 15:38:11', '', '婺城区', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523069', '2013-07-30 15:38:11', '', '金东区', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523070', '2013-07-30 15:38:11', '', '武义县', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523071', '2013-07-30 15:38:11', '', '浦江县', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523072', '2013-07-30 15:38:11', '', '磐安县', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523073', '2013-07-30 15:38:11', '', '兰溪市', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523074', '2013-07-30 15:38:11', '', '义乌市', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523075', '2013-07-30 15:38:11', '', '东阳市', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523076', '2013-07-30 15:38:11', '', '永康市', '2', '0', '4523066', '');
INSERT INTO `ezs_area` VALUES ('4523077', '2013-07-30 15:38:11', '', '衢州市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523078', '2013-07-30 15:38:12', '', '市辖区', '2', '0', '4523077', '');
INSERT INTO `ezs_area` VALUES ('4523079', '2013-07-30 15:38:12', '', '柯城区', '2', '0', '4523077', '');
INSERT INTO `ezs_area` VALUES ('4523080', '2013-07-30 15:38:12', '', '衢江区', '2', '0', '4523077', '');
INSERT INTO `ezs_area` VALUES ('4523081', '2013-07-30 15:38:12', '', '常山县', '2', '0', '4523077', '');
INSERT INTO `ezs_area` VALUES ('4523082', '2013-07-30 15:38:12', '', '开化县', '2', '0', '4523077', '');
INSERT INTO `ezs_area` VALUES ('4523083', '2013-07-30 15:38:12', '', '龙游县', '2', '0', '4523077', '');
INSERT INTO `ezs_area` VALUES ('4523084', '2013-07-30 15:38:12', '', '江山市', '2', '0', '4523077', '');
INSERT INTO `ezs_area` VALUES ('4523085', '2013-07-30 15:38:12', '', '舟山市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523086', '2013-07-30 15:38:12', '', '市辖区', '2', '0', '4523085', '');
INSERT INTO `ezs_area` VALUES ('4523087', '2013-07-30 15:38:12', '', '定海区', '2', '0', '4523085', '');
INSERT INTO `ezs_area` VALUES ('4523088', '2013-07-30 15:38:12', '', '普陀区', '2', '0', '4523085', '');
INSERT INTO `ezs_area` VALUES ('4523089', '2013-07-30 15:38:12', '', '岱山县', '2', '0', '4523085', '');
INSERT INTO `ezs_area` VALUES ('4523090', '2013-07-30 15:38:12', '', '嵊泗县', '2', '0', '4523085', '');
INSERT INTO `ezs_area` VALUES ('4523091', '2013-07-30 15:38:12', '', '台州市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523092', '2013-07-30 15:38:12', '', '市辖区', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523093', '2013-07-30 15:38:12', '', '椒江区', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523094', '2013-07-30 15:38:12', '', '黄岩区', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523095', '2013-07-30 15:38:12', '', '路桥区', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523096', '2013-07-30 15:38:12', '', '玉环县', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523097', '2013-07-30 15:38:13', '', '三门县', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523098', '2013-07-30 15:38:13', '', '天台县', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523099', '2013-07-30 15:38:13', '', '仙居县', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523100', '2013-07-30 15:38:13', '', '温岭市', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523101', '2013-07-30 15:38:13', '', '临海市', '2', '0', '4523091', '');
INSERT INTO `ezs_area` VALUES ('4523102', '2013-07-30 15:38:13', '', '丽水市', '1', '0', '4523000', '');
INSERT INTO `ezs_area` VALUES ('4523103', '2013-07-30 15:38:13', '', '市辖区', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523104', '2013-07-30 15:38:13', '', '莲都区', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523105', '2013-07-30 15:38:13', '', '青田县', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523106', '2013-07-30 15:38:13', '', '缙云县', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523107', '2013-07-30 15:38:13', '', '遂昌县', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523108', '2013-07-30 15:38:13', '', '松阳县', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523109', '2013-07-30 15:38:13', '', '云和县', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523110', '2013-07-30 15:38:13', '', '庆元县', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523111', '2013-07-30 15:38:13', '', '景宁畲族自治县', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523112', '2013-07-30 15:38:13', '', '龙泉市', '2', '0', '4523102', '');
INSERT INTO `ezs_area` VALUES ('4523113', '2013-07-30 15:38:13', '', '安徽省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523114', '2013-07-30 15:38:13', '', '合肥市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523115', '2013-07-30 15:38:13', '', '市辖区', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523116', '2013-07-30 15:38:14', '', '瑶海区', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523117', '2013-07-30 15:38:14', '', '庐阳区', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523118', '2013-07-30 15:38:14', '', '蜀山区', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523119', '2013-07-30 15:38:14', '', '包河区', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523120', '2013-07-30 15:38:14', '', '长丰县', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523121', '2013-07-30 15:38:14', '', '肥东县', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523122', '2013-07-30 15:38:14', '', '肥西县', '2', '0', '4523114', '');
INSERT INTO `ezs_area` VALUES ('4523123', '2013-07-30 15:38:14', '', '芜湖市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523124', '2013-07-30 15:38:14', '', '市辖区', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523125', '2013-07-30 15:38:14', '', '镜湖区', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523126', '2013-07-30 15:38:14', '', '弋江区', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523127', '2013-07-30 15:38:14', '', '鸠江区', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523128', '2013-07-30 15:38:14', '', '三山区', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523129', '2013-07-30 15:38:14', '', '芜湖县', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523130', '2013-07-30 15:38:14', '', '繁昌县', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523131', '2013-07-30 15:38:14', '', '南陵县', '2', '0', '4523123', '');
INSERT INTO `ezs_area` VALUES ('4523132', '2013-07-30 15:38:14', '', '蚌埠市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523133', '2013-07-30 15:38:14', '', '市辖区', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523134', '2013-07-30 15:38:15', '', '龙子湖区', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523135', '2013-07-30 15:38:15', '', '蚌山区', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523136', '2013-07-30 15:38:15', '', '禹会区', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523137', '2013-07-30 15:38:15', '', '淮上区', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523138', '2013-07-30 15:38:15', '', '怀远县', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523139', '2013-07-30 15:38:15', '', '五河县', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523140', '2013-07-30 15:38:15', '', '固镇县', '2', '0', '4523132', '');
INSERT INTO `ezs_area` VALUES ('4523141', '2013-07-30 15:38:15', '', '淮南市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523142', '2013-07-30 15:38:15', '', '市辖区', '2', '0', '4523141', '');
INSERT INTO `ezs_area` VALUES ('4523143', '2013-07-30 15:38:15', '', '大通区', '2', '0', '4523141', '');
INSERT INTO `ezs_area` VALUES ('4523144', '2013-07-30 15:38:15', '', '田家庵区', '2', '0', '4523141', '');
INSERT INTO `ezs_area` VALUES ('4523145', '2013-07-30 15:38:15', '', '谢家集区', '2', '0', '4523141', '');
INSERT INTO `ezs_area` VALUES ('4523146', '2013-07-30 15:38:15', '', '八公山区', '2', '0', '4523141', '');
INSERT INTO `ezs_area` VALUES ('4523147', '2013-07-30 15:38:15', '', '潘集区', '2', '0', '4523141', '');
INSERT INTO `ezs_area` VALUES ('4523148', '2013-07-30 15:38:15', '', '凤台县', '2', '0', '4523141', '');
INSERT INTO `ezs_area` VALUES ('4523149', '2013-07-30 15:38:15', '', '马鞍山市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523150', '2013-07-30 15:38:16', '', '市辖区', '2', '0', '4523149', '');
INSERT INTO `ezs_area` VALUES ('4523151', '2013-07-30 15:38:16', '', '金家庄区', '2', '0', '4523149', '');
INSERT INTO `ezs_area` VALUES ('4523152', '2013-07-30 15:38:16', '', '花山区', '2', '0', '4523149', '');
INSERT INTO `ezs_area` VALUES ('4523153', '2013-07-30 15:38:16', '', '雨山区', '2', '0', '4523149', '');
INSERT INTO `ezs_area` VALUES ('4523154', '2013-07-30 15:38:16', '', '当涂县', '2', '0', '4523149', '');
INSERT INTO `ezs_area` VALUES ('4523155', '2013-07-30 15:38:16', '', '淮北市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523156', '2013-07-30 15:38:16', '', '市辖区', '2', '0', '4523155', '');
INSERT INTO `ezs_area` VALUES ('4523157', '2013-07-30 15:38:16', '', '杜集区', '2', '0', '4523155', '');
INSERT INTO `ezs_area` VALUES ('4523158', '2013-07-30 15:38:16', '', '相山区', '2', '0', '4523155', '');
INSERT INTO `ezs_area` VALUES ('4523159', '2013-07-30 15:38:16', '', '烈山区', '2', '0', '4523155', '');
INSERT INTO `ezs_area` VALUES ('4523160', '2013-07-30 15:38:16', '', '濉溪县', '2', '0', '4523155', '');
INSERT INTO `ezs_area` VALUES ('4523161', '2013-07-30 15:38:16', '', '铜陵市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523162', '2013-07-30 15:38:16', '', '市辖区', '2', '0', '4523161', '');
INSERT INTO `ezs_area` VALUES ('4523163', '2013-07-30 15:38:16', '', '铜官山区', '2', '0', '4523161', '');
INSERT INTO `ezs_area` VALUES ('4523164', '2013-07-30 15:38:16', '', '狮子山区', '2', '0', '4523161', '');
INSERT INTO `ezs_area` VALUES ('4523165', '2013-07-30 15:38:16', '', '郊区', '2', '0', '4523161', '');
INSERT INTO `ezs_area` VALUES ('4523166', '2013-07-30 15:38:16', '', '铜陵县', '2', '0', '4523161', '');
INSERT INTO `ezs_area` VALUES ('4523167', '2013-07-30 15:38:16', '', '安庆市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523168', '2013-07-30 15:38:17', '', '市辖区', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523169', '2013-07-30 15:38:17', '', '迎江区', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523170', '2013-07-30 15:38:17', '', '大观区', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523171', '2013-07-30 15:38:17', '', '宜秀区', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523172', '2013-07-30 15:38:17', '', '怀宁县', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523173', '2013-07-30 15:38:17', '', '枞阳县', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523174', '2013-07-30 15:38:17', '', '潜山县', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523175', '2013-07-30 15:38:17', '', '太湖县', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523176', '2013-07-30 15:38:17', '', '宿松县', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523177', '2013-07-30 15:38:17', '', '望江县', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523178', '2013-07-30 15:38:17', '', '岳西县', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523179', '2013-07-30 15:38:17', '', '桐城市', '2', '0', '4523167', '');
INSERT INTO `ezs_area` VALUES ('4523180', '2013-07-30 15:38:17', '', '黄山市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523181', '2013-07-30 15:38:17', '', '市辖区', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523182', '2013-07-30 15:38:17', '', '屯溪区', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523183', '2013-07-30 15:38:17', '', '黄山区', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523184', '2013-07-30 15:38:17', '', '徽州区', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523185', '2013-07-30 15:38:17', '', '歙县', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523186', '2013-07-30 15:38:17', '', '休宁县', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523187', '2013-07-30 15:38:18', '', '黟县', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523188', '2013-07-30 15:38:18', '', '祁门县', '2', '0', '4523180', '');
INSERT INTO `ezs_area` VALUES ('4523189', '2013-07-30 15:38:18', '', '滁州市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523190', '2013-07-30 15:38:18', '', '市辖区', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523191', '2013-07-30 15:38:18', '', '琅琊区', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523192', '2013-07-30 15:38:18', '', '南谯区', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523193', '2013-07-30 15:38:18', '', '来安县', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523194', '2013-07-30 15:38:18', '', '全椒县', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523195', '2013-07-30 15:38:18', '', '定远县', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523196', '2013-07-30 15:38:18', '', '凤阳县', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523197', '2013-07-30 15:38:18', '', '天长市', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523198', '2013-07-30 15:38:18', '', '明光市', '2', '0', '4523189', '');
INSERT INTO `ezs_area` VALUES ('4523199', '2013-07-30 15:38:18', '', '阜阳市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523200', '2013-07-30 15:38:18', '', '市辖区', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523201', '2013-07-30 15:38:18', '', '颍州区', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523202', '2013-07-30 15:38:18', '', '颍东区', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523203', '2013-07-30 15:38:18', '', '颍泉区', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523204', '2013-07-30 15:38:18', '', '临泉县', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523205', '2013-07-30 15:38:19', '', '太和县', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523206', '2013-07-30 15:38:19', '', '阜南县', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523207', '2013-07-30 15:38:19', '', '颍上县', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523208', '2013-07-30 15:38:19', '', '界首市', '2', '0', '4523199', '');
INSERT INTO `ezs_area` VALUES ('4523209', '2013-07-30 15:38:19', '', '宿州市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523210', '2013-07-30 15:38:19', '', '市辖区', '2', '0', '4523209', '');
INSERT INTO `ezs_area` VALUES ('4523211', '2013-07-30 15:38:19', '', '埇桥区', '2', '0', '4523209', '');
INSERT INTO `ezs_area` VALUES ('4523212', '2013-07-30 15:38:19', '', '砀山县', '2', '0', '4523209', '');
INSERT INTO `ezs_area` VALUES ('4523213', '2013-07-30 15:38:19', '', '萧县', '2', '0', '4523209', '');
INSERT INTO `ezs_area` VALUES ('4523214', '2013-07-30 15:38:19', '', '灵璧县', '2', '0', '4523209', '');
INSERT INTO `ezs_area` VALUES ('4523215', '2013-07-30 15:38:19', '', '泗县', '2', '0', '4523209', '');
INSERT INTO `ezs_area` VALUES ('4523216', '2013-07-30 15:38:19', '', '巢湖市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523217', '2013-07-30 15:38:19', '', '市辖区', '2', '0', '4523216', '');
INSERT INTO `ezs_area` VALUES ('4523218', '2013-07-30 15:38:19', '', '居巢区', '2', '0', '4523216', '');
INSERT INTO `ezs_area` VALUES ('4523219', '2013-07-30 15:38:19', '', '庐江县', '2', '0', '4523216', '');
INSERT INTO `ezs_area` VALUES ('4523220', '2013-07-30 15:38:19', '', '无为县', '2', '0', '4523216', '');
INSERT INTO `ezs_area` VALUES ('4523221', '2013-07-30 15:38:19', '', '含山县', '2', '0', '4523216', '');
INSERT INTO `ezs_area` VALUES ('4523222', '2013-07-30 15:38:19', '', '和县', '2', '0', '4523216', '');
INSERT INTO `ezs_area` VALUES ('4523223', '2013-07-30 15:38:20', '', '六安市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523224', '2013-07-30 15:38:20', '', '市辖区', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523225', '2013-07-30 15:38:20', '', '金安区', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523226', '2013-07-30 15:38:20', '', '裕安区', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523227', '2013-07-30 15:38:20', '', '寿县', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523228', '2013-07-30 15:38:20', '', '霍邱县', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523229', '2013-07-30 15:38:20', '', '舒城县', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523230', '2013-07-30 15:38:20', '', '金寨县', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523231', '2013-07-30 15:38:20', '', '霍山县', '2', '0', '4523223', '');
INSERT INTO `ezs_area` VALUES ('4523232', '2013-07-30 15:38:20', '', '亳州市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523233', '2013-07-30 15:38:20', '', '市辖区', '2', '0', '4523232', '');
INSERT INTO `ezs_area` VALUES ('4523234', '2013-07-30 15:38:20', '', '谯城区', '2', '0', '4523232', '');
INSERT INTO `ezs_area` VALUES ('4523235', '2013-07-30 15:38:20', '', '涡阳县', '2', '0', '4523232', '');
INSERT INTO `ezs_area` VALUES ('4523236', '2013-07-30 15:38:20', '', '蒙城县', '2', '0', '4523232', '');
INSERT INTO `ezs_area` VALUES ('4523237', '2013-07-30 15:38:20', '', '利辛县', '2', '0', '4523232', '');
INSERT INTO `ezs_area` VALUES ('4523238', '2013-07-30 15:38:20', '', '池州市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523239', '2013-07-30 15:38:20', '', '市辖区', '2', '0', '4523238', '');
INSERT INTO `ezs_area` VALUES ('4523240', '2013-07-30 15:38:20', '', '贵池区', '2', '0', '4523238', '');
INSERT INTO `ezs_area` VALUES ('4523241', '2013-07-30 15:38:21', '', '东至县', '2', '0', '4523238', '');
INSERT INTO `ezs_area` VALUES ('4523242', '2013-07-30 15:38:21', '', '石台县', '2', '0', '4523238', '');
INSERT INTO `ezs_area` VALUES ('4523243', '2013-07-30 15:38:21', '', '青阳县', '2', '0', '4523238', '');
INSERT INTO `ezs_area` VALUES ('4523244', '2013-07-30 15:38:21', '', '宣城市', '1', '0', '4523113', '');
INSERT INTO `ezs_area` VALUES ('4523245', '2013-07-30 15:38:21', '', '市辖区', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523246', '2013-07-30 15:38:21', '', '宣州区', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523247', '2013-07-30 15:38:21', '', '郎溪县', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523248', '2013-07-30 15:38:21', '', '广德县', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523249', '2013-07-30 15:38:21', '', '泾县', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523250', '2013-07-30 15:38:21', '', '绩溪县', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523251', '2013-07-30 15:38:21', '', '旌德县', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523252', '2013-07-30 15:38:21', '', '宁国市', '2', '0', '4523244', '');
INSERT INTO `ezs_area` VALUES ('4523253', '2013-07-30 15:38:21', '', '福建省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523254', '2013-07-30 15:38:21', '', '福州市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523255', '2013-07-30 15:38:21', '', '市辖区', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523256', '2013-07-30 15:38:21', '', '鼓楼区', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523257', '2013-07-30 15:38:22', '', '台江区', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523258', '2013-07-30 15:38:22', '', '仓山区', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523259', '2013-07-30 15:38:22', '', '马尾区', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523260', '2013-07-30 15:38:22', '', '晋安区', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523261', '2013-07-30 15:38:22', '', '闽侯县', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523262', '2013-07-30 15:38:22', '', '连江县', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523263', '2013-07-30 15:38:22', '', '罗源县', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523264', '2013-07-30 15:38:22', '', '闽清县', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523265', '2013-07-30 15:38:22', '', '永泰县', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523266', '2013-07-30 15:38:22', '', '平潭县', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523267', '2013-07-30 15:38:22', '', '福清市', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523268', '2013-07-30 15:38:22', '', '长乐市', '2', '0', '4523254', '');
INSERT INTO `ezs_area` VALUES ('4523269', '2013-07-30 15:38:22', '', '厦门市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523270', '2013-07-30 15:38:22', '', '市辖区', '2', '0', '4523269', '');
INSERT INTO `ezs_area` VALUES ('4523271', '2013-07-30 15:38:22', '', '思明区', '2', '0', '4523269', '');
INSERT INTO `ezs_area` VALUES ('4523272', '2013-07-30 15:38:22', '', '海沧区', '2', '0', '4523269', '');
INSERT INTO `ezs_area` VALUES ('4523273', '2013-07-30 15:38:22', '', '湖里区', '2', '0', '4523269', '');
INSERT INTO `ezs_area` VALUES ('4523274', '2013-07-30 15:38:22', '', '集美区', '2', '0', '4523269', '');
INSERT INTO `ezs_area` VALUES ('4523275', '2013-07-30 15:38:22', '', '同安区', '2', '0', '4523269', '');
INSERT INTO `ezs_area` VALUES ('4523276', '2013-07-30 15:38:23', '', '翔安区', '2', '0', '4523269', '');
INSERT INTO `ezs_area` VALUES ('4523277', '2013-07-30 15:38:23', '', '莆田市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523278', '2013-07-30 15:38:23', '', '市辖区', '2', '0', '4523277', '');
INSERT INTO `ezs_area` VALUES ('4523279', '2013-07-30 15:38:23', '', '城厢区', '2', '0', '4523277', '');
INSERT INTO `ezs_area` VALUES ('4523280', '2013-07-30 15:38:23', '', '涵江区', '2', '0', '4523277', '');
INSERT INTO `ezs_area` VALUES ('4523281', '2013-07-30 15:38:23', '', '荔城区', '2', '0', '4523277', '');
INSERT INTO `ezs_area` VALUES ('4523282', '2013-07-30 15:38:23', '', '秀屿区', '2', '0', '4523277', '');
INSERT INTO `ezs_area` VALUES ('4523283', '2013-07-30 15:38:23', '', '仙游县', '2', '0', '4523277', '');
INSERT INTO `ezs_area` VALUES ('4523284', '2013-07-30 15:38:23', '', '三明市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523285', '2013-07-30 15:38:23', '', '市辖区', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523286', '2013-07-30 15:38:23', '', '梅列区', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523287', '2013-07-30 15:38:23', '', '三元区', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523288', '2013-07-30 15:38:23', '', '明溪县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523289', '2013-07-30 15:38:23', '', '清流县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523290', '2013-07-30 15:38:23', '', '宁化县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523291', '2013-07-30 15:38:23', '', '大田县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523292', '2013-07-30 15:38:23', '', '尤溪县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523293', '2013-07-30 15:38:23', '', '沙县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523294', '2013-07-30 15:38:24', '', '将乐县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523295', '2013-07-30 15:38:24', '', '泰宁县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523296', '2013-07-30 15:38:24', '', '建宁县', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523297', '2013-07-30 15:38:24', '', '永安市', '2', '0', '4523284', '');
INSERT INTO `ezs_area` VALUES ('4523298', '2013-07-30 15:38:24', '', '泉州市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523299', '2013-07-30 15:38:24', '', '市辖区', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523300', '2013-07-30 15:38:24', '', '鲤城区', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523301', '2013-07-30 15:38:24', '', '丰泽区', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523302', '2013-07-30 15:38:24', '', '洛江区', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523303', '2013-07-30 15:38:24', '', '泉港区', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523304', '2013-07-30 15:38:24', '', '惠安县', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523305', '2013-07-30 15:38:24', '', '安溪县', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523306', '2013-07-30 15:38:24', '', '永春县', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523307', '2013-07-30 15:38:24', '', '德化县', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523308', '2013-07-30 15:38:24', '', '金门县', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523309', '2013-07-30 15:38:24', '', '石狮市', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523310', '2013-07-30 15:38:24', '', '晋江市', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523311', '2013-07-30 15:38:24', '', '南安市', '2', '0', '4523298', '');
INSERT INTO `ezs_area` VALUES ('4523312', '2013-07-30 15:38:24', '', '漳州市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523313', '2013-07-30 15:38:25', '', '市辖区', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523314', '2013-07-30 15:38:25', '', '芗城区', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523315', '2013-07-30 15:38:25', '', '龙文区', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523316', '2013-07-30 15:38:25', '', '云霄县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523317', '2013-07-30 15:38:25', '', '漳浦县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523318', '2013-07-30 15:38:25', '', '诏安县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523319', '2013-07-30 15:38:25', '', '长泰县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523320', '2013-07-30 15:38:25', '', '东山县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523321', '2013-07-30 15:38:25', '', '南靖县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523322', '2013-07-30 15:38:25', '', '平和县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523323', '2013-07-30 15:38:25', '', '华安县', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523324', '2013-07-30 15:38:25', '', '龙海市', '2', '0', '4523312', '');
INSERT INTO `ezs_area` VALUES ('4523325', '2013-07-30 15:38:25', '', '南平市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523326', '2013-07-30 15:38:25', '', '市辖区', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523327', '2013-07-30 15:38:25', '', '延平区', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523328', '2013-07-30 15:38:25', '', '顺昌县', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523329', '2013-07-30 15:38:25', '', '浦城县', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523330', '2013-07-30 15:38:25', '', '光泽县', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523331', '2013-07-30 15:38:25', '', '松溪县', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523332', '2013-07-30 15:38:26', '', '政和县', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523333', '2013-07-30 15:38:26', '', '邵武市', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523334', '2013-07-30 15:38:26', '', '武夷山市', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523335', '2013-07-30 15:38:26', '', '建瓯市', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523336', '2013-07-30 15:38:26', '', '建阳市', '2', '0', '4523325', '');
INSERT INTO `ezs_area` VALUES ('4523337', '2013-07-30 15:38:26', '', '龙岩市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523338', '2013-07-30 15:38:26', '', '市辖区', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523339', '2013-07-30 15:38:26', '', '新罗区', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523340', '2013-07-30 15:38:26', '', '长汀县', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523341', '2013-07-30 15:38:26', '', '永定县', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523342', '2013-07-30 15:38:26', '', '上杭县', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523343', '2013-07-30 15:38:26', '', '武平县', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523344', '2013-07-30 15:38:26', '', '连城县', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523345', '2013-07-30 15:38:26', '', '漳平市', '2', '0', '4523337', '');
INSERT INTO `ezs_area` VALUES ('4523346', '2013-07-30 15:38:26', '', '宁德市', '1', '0', '4523253', '');
INSERT INTO `ezs_area` VALUES ('4523347', '2013-07-30 15:38:26', '', '市辖区', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523348', '2013-07-30 15:38:26', '', '蕉城区', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523349', '2013-07-30 15:38:26', '', '霞浦县', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523350', '2013-07-30 15:38:26', '', '古田县', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523351', '2013-07-30 15:38:27', '', '屏南县', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523352', '2013-07-30 15:38:27', '', '寿宁县', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523353', '2013-07-30 15:38:27', '', '周宁县', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523354', '2013-07-30 15:38:27', '', '柘荣县', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523355', '2013-07-30 15:38:27', '', '福安市', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523356', '2013-07-30 15:38:27', '', '福鼎市', '2', '0', '4523346', '');
INSERT INTO `ezs_area` VALUES ('4523357', '2013-07-30 15:38:27', '', '江西省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523358', '2013-07-30 15:38:27', '', '南昌市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523359', '2013-07-30 15:38:27', '', '市辖区', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523360', '2013-07-30 15:38:27', '', '东湖区', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523361', '2013-07-30 15:38:27', '', '西湖区', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523362', '2013-07-30 15:38:27', '', '青云谱区', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523363', '2013-07-30 15:38:27', '', '湾里区', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523364', '2013-07-30 15:38:27', '', '青山湖区', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523365', '2013-07-30 15:38:27', '', '南昌县', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523366', '2013-07-30 15:38:27', '', '新建县', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523367', '2013-07-30 15:38:27', '', '安义县', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523368', '2013-07-30 15:38:27', '', '进贤县', '2', '0', '4523358', '');
INSERT INTO `ezs_area` VALUES ('4523369', '2013-07-30 15:38:28', '', '景德镇市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523370', '2013-07-30 15:38:28', '', '市辖区', '2', '0', '4523369', '');
INSERT INTO `ezs_area` VALUES ('4523371', '2013-07-30 15:38:28', '', '昌江区', '2', '0', '4523369', '');
INSERT INTO `ezs_area` VALUES ('4523372', '2013-07-30 15:38:28', '', '珠山区', '2', '0', '4523369', '');
INSERT INTO `ezs_area` VALUES ('4523373', '2013-07-30 15:38:28', '', '浮梁县', '2', '0', '4523369', '');
INSERT INTO `ezs_area` VALUES ('4523374', '2013-07-30 15:38:28', '', '乐平市', '2', '0', '4523369', '');
INSERT INTO `ezs_area` VALUES ('4523375', '2013-07-30 15:38:28', '', '萍乡市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523376', '2013-07-30 15:38:28', '', '市辖区', '2', '0', '4523375', '');
INSERT INTO `ezs_area` VALUES ('4523377', '2013-07-30 15:38:28', '', '安源区', '2', '0', '4523375', '');
INSERT INTO `ezs_area` VALUES ('4523378', '2013-07-30 15:38:28', '', '湘东区', '2', '0', '4523375', '');
INSERT INTO `ezs_area` VALUES ('4523379', '2013-07-30 15:38:28', '', '莲花县', '2', '0', '4523375', '');
INSERT INTO `ezs_area` VALUES ('4523380', '2013-07-30 15:38:28', '', '上栗县', '2', '0', '4523375', '');
INSERT INTO `ezs_area` VALUES ('4523381', '2013-07-30 15:38:28', '', '芦溪县', '2', '0', '4523375', '');
INSERT INTO `ezs_area` VALUES ('4523382', '2013-07-30 15:38:28', '', '九江市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523383', '2013-07-30 15:38:28', '', '市辖区', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523384', '2013-07-30 15:38:28', '', '庐山区', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523385', '2013-07-30 15:38:28', '', '浔阳区', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523386', '2013-07-30 15:38:28', '', '九江县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523387', '2013-07-30 15:38:29', '', '武宁县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523388', '2013-07-30 15:38:29', '', '修水县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523389', '2013-07-30 15:38:29', '', '永修县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523390', '2013-07-30 15:38:29', '', '德安县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523391', '2013-07-30 15:38:29', '', '星子县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523392', '2013-07-30 15:38:29', '', '都昌县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523393', '2013-07-30 15:38:29', '', '湖口县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523394', '2013-07-30 15:38:29', '', '彭泽县', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523395', '2013-07-30 15:38:29', '', '瑞昌市', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523396', '2013-07-30 15:38:29', '', '共青城市', '2', '0', '4523382', '');
INSERT INTO `ezs_area` VALUES ('4523397', '2013-07-30 15:38:29', '', '新余市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523398', '2013-07-30 15:38:29', '', '市辖区', '2', '0', '4523397', '');
INSERT INTO `ezs_area` VALUES ('4523399', '2013-07-30 15:38:29', '', '渝水区', '2', '0', '4523397', '');
INSERT INTO `ezs_area` VALUES ('4523400', '2013-07-30 15:38:29', '', '分宜县', '2', '0', '4523397', '');
INSERT INTO `ezs_area` VALUES ('4523401', '2013-07-30 15:38:29', '', '鹰潭市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523402', '2013-07-30 15:38:29', '', '市辖区', '2', '0', '4523401', '');
INSERT INTO `ezs_area` VALUES ('4523403', '2013-07-30 15:38:29', '', '月湖区', '2', '0', '4523401', '');
INSERT INTO `ezs_area` VALUES ('4523404', '2013-07-30 15:38:30', '', '余江县', '2', '0', '4523401', '');
INSERT INTO `ezs_area` VALUES ('4523405', '2013-07-30 15:38:30', '', '贵溪市', '2', '0', '4523401', '');
INSERT INTO `ezs_area` VALUES ('4523406', '2013-07-30 15:38:30', '', '赣州市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523407', '2013-07-30 15:38:30', '', '市辖区', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523408', '2013-07-30 15:38:30', '', '章贡区', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523409', '2013-07-30 15:38:30', '', '赣县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523410', '2013-07-30 15:38:30', '', '信丰县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523411', '2013-07-30 15:38:30', '', '大余县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523412', '2013-07-30 15:38:30', '', '上犹县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523413', '2013-07-30 15:38:30', '', '崇义县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523414', '2013-07-30 15:38:30', '', '安远县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523415', '2013-07-30 15:38:30', '', '龙南县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523416', '2013-07-30 15:38:30', '', '定南县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523417', '2013-07-30 15:38:30', '', '全南县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523418', '2013-07-30 15:38:30', '', '宁都县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523419', '2013-07-30 15:38:30', '', '于都县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523420', '2013-07-30 15:38:30', '', '兴国县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523421', '2013-07-30 15:38:31', '', '会昌县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523422', '2013-07-30 15:38:31', '', '寻乌县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523423', '2013-07-30 15:38:31', '', '石城县', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523424', '2013-07-30 15:38:31', '', '瑞金市', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523425', '2013-07-30 15:38:31', '', '南康市', '2', '0', '4523406', '');
INSERT INTO `ezs_area` VALUES ('4523426', '2013-07-30 15:38:31', '', '吉安市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523427', '2013-07-30 15:38:31', '', '市辖区', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523428', '2013-07-30 15:38:31', '', '吉州区', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523429', '2013-07-30 15:38:31', '', '青原区', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523430', '2013-07-30 15:38:31', '', '吉安县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523431', '2013-07-30 15:38:31', '', '吉水县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523432', '2013-07-30 15:38:31', '', '峡江县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523433', '2013-07-30 15:38:31', '', '新干县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523434', '2013-07-30 15:38:31', '', '永丰县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523435', '2013-07-30 15:38:31', '', '泰和县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523436', '2013-07-30 15:38:31', '', '遂川县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523437', '2013-07-30 15:38:31', '', '万安县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523438', '2013-07-30 15:38:31', '', '安福县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523439', '2013-07-30 15:38:32', '', '永新县', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523440', '2013-07-30 15:38:32', '', '井冈山市', '2', '0', '4523426', '');
INSERT INTO `ezs_area` VALUES ('4523441', '2013-07-30 15:38:32', '', '宜春市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523442', '2013-07-30 15:38:32', '', '市辖区', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523443', '2013-07-30 15:38:32', '', '袁州区', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523444', '2013-07-30 15:38:32', '', '奉新县', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523445', '2013-07-30 15:38:32', '', '万载县', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523446', '2013-07-30 15:38:32', '', '上高县', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523447', '2013-07-30 15:38:32', '', '宜丰县', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523448', '2013-07-30 15:38:32', '', '靖安县', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523449', '2013-07-30 15:38:32', '', '铜鼓县', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523450', '2013-07-30 15:38:32', '', '丰城市', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523451', '2013-07-30 15:38:32', '', '樟树市', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523452', '2013-07-30 15:38:32', '', '高安市', '2', '0', '4523441', '');
INSERT INTO `ezs_area` VALUES ('4523453', '2013-07-30 15:38:32', '', '抚州市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523454', '2013-07-30 15:38:32', '', '市辖区', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523455', '2013-07-30 15:38:32', '', '临川区', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523456', '2013-07-30 15:38:33', '', '南城县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523457', '2013-07-30 15:38:33', '', '黎川县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523458', '2013-07-30 15:38:33', '', '南丰县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523459', '2013-07-30 15:38:33', '', '崇仁县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523460', '2013-07-30 15:38:33', '', '乐安县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523461', '2013-07-30 15:38:33', '', '宜黄县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523462', '2013-07-30 15:38:33', '', '金溪县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523463', '2013-07-30 15:38:33', '', '资溪县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523464', '2013-07-30 15:38:33', '', '东乡县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523465', '2013-07-30 15:38:33', '', '广昌县', '2', '0', '4523453', '');
INSERT INTO `ezs_area` VALUES ('4523466', '2013-07-30 15:38:33', '', '上饶市', '1', '0', '4523357', '');
INSERT INTO `ezs_area` VALUES ('4523467', '2013-07-30 15:38:33', '', '市辖区', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523468', '2013-07-30 15:38:33', '', '信州区', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523469', '2013-07-30 15:38:33', '', '上饶县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523470', '2013-07-30 15:38:33', '', '广丰县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523471', '2013-07-30 15:38:33', '', '玉山县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523472', '2013-07-30 15:38:33', '', '铅山县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523473', '2013-07-30 15:38:34', '', '横峰县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523474', '2013-07-30 15:38:34', '', '弋阳县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523475', '2013-07-30 15:38:34', '', '余干县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523476', '2013-07-30 15:38:34', '', '鄱阳县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523477', '2013-07-30 15:38:34', '', '万年县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523478', '2013-07-30 15:38:34', '', '婺源县', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523479', '2013-07-30 15:38:34', '', '德兴市', '2', '0', '4523466', '');
INSERT INTO `ezs_area` VALUES ('4523480', '2013-07-30 15:38:34', '', '山东省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523481', '2013-07-30 15:38:34', '', '济南市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523482', '2013-07-30 15:38:34', '', '市辖区', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523483', '2013-07-30 15:38:34', '', '历下区', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523484', '2013-07-30 15:38:34', '', '市中区', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523485', '2013-07-30 15:38:34', '', '槐荫区', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523486', '2013-07-30 15:38:34', '', '天桥区', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523487', '2013-07-30 15:38:34', '', '历城区', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523488', '2013-07-30 15:38:34', '', '长清区', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523489', '2013-07-30 15:38:34', '', '平阴县', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523490', '2013-07-30 15:38:35', '', '济阳县', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523491', '2013-07-30 15:38:35', '', '商河县', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523492', '2013-07-30 15:38:35', '', '章丘市', '2', '0', '4523481', '');
INSERT INTO `ezs_area` VALUES ('4523493', '2013-07-30 15:38:35', '', '青岛市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523494', '2013-07-30 15:38:35', '', '市辖区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523495', '2013-07-30 15:38:35', '', '市南区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523496', '2013-07-30 15:38:35', '', '市北区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523497', '2013-07-30 15:38:35', '', '四方区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523498', '2013-07-30 15:38:35', '', '黄岛区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523499', '2013-07-30 15:38:35', '', '崂山区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523500', '2013-07-30 15:38:35', '', '李沧区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523501', '2013-07-30 15:38:35', '', '城阳区', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523502', '2013-07-30 15:38:35', '', '胶州市', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523503', '2013-07-30 15:38:35', '', '即墨市', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523504', '2013-07-30 15:38:35', '', '平度市', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523505', '2013-07-30 15:38:35', '', '胶南市', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523506', '2013-07-30 15:38:35', '', '莱西市', '2', '0', '4523493', '');
INSERT INTO `ezs_area` VALUES ('4523507', '2013-07-30 15:38:36', '', '淄博市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523508', '2013-07-30 15:38:36', '', '市辖区', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523509', '2013-07-30 15:38:36', '', '淄川区', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523510', '2013-07-30 15:38:36', '', '张店区', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523511', '2013-07-30 15:38:36', '', '博山区', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523512', '2013-07-30 15:38:36', '', '临淄区', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523513', '2013-07-30 15:38:36', '', '周村区', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523514', '2013-07-30 15:38:36', '', '桓台县', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523515', '2013-07-30 15:38:36', '', '高青县', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523516', '2013-07-30 15:38:36', '', '沂源县', '2', '0', '4523507', '');
INSERT INTO `ezs_area` VALUES ('4523517', '2013-07-30 15:38:36', '', '枣庄市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523518', '2013-07-30 15:38:36', '', '市辖区', '2', '0', '4523517', '');
INSERT INTO `ezs_area` VALUES ('4523519', '2013-07-30 15:38:36', '', '市中区', '2', '0', '4523517', '');
INSERT INTO `ezs_area` VALUES ('4523520', '2013-07-30 15:38:36', '', '薛城区', '2', '0', '4523517', '');
INSERT INTO `ezs_area` VALUES ('4523521', '2013-07-30 15:38:36', '', '峄城区', '2', '0', '4523517', '');
INSERT INTO `ezs_area` VALUES ('4523522', '2013-07-30 15:38:36', '', '台儿庄区', '2', '0', '4523517', '');
INSERT INTO `ezs_area` VALUES ('4523523', '2013-07-30 15:38:36', '', '山亭区', '2', '0', '4523517', '');
INSERT INTO `ezs_area` VALUES ('4523524', '2013-07-30 15:38:36', '', '滕州市', '2', '0', '4523517', '');
INSERT INTO `ezs_area` VALUES ('4523525', '2013-07-30 15:38:37', '', '东营市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523526', '2013-07-30 15:38:37', '', '市辖区', '2', '0', '4523525', '');
INSERT INTO `ezs_area` VALUES ('4523527', '2013-07-30 15:38:37', '', '东营区', '2', '0', '4523525', '');
INSERT INTO `ezs_area` VALUES ('4523528', '2013-07-30 15:38:37', '', '河口区', '2', '0', '4523525', '');
INSERT INTO `ezs_area` VALUES ('4523529', '2013-07-30 15:38:37', '', '垦利县', '2', '0', '4523525', '');
INSERT INTO `ezs_area` VALUES ('4523530', '2013-07-30 15:38:37', '', '利津县', '2', '0', '4523525', '');
INSERT INTO `ezs_area` VALUES ('4523531', '2013-07-30 15:38:37', '', '广饶县', '2', '0', '4523525', '');
INSERT INTO `ezs_area` VALUES ('4523532', '2013-07-30 15:38:37', '', '烟台市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523533', '2013-07-30 15:38:37', '', '市辖区', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523534', '2013-07-30 15:38:37', '', '芝罘区', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523535', '2013-07-30 15:38:37', '', '福山区', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523536', '2013-07-30 15:38:37', '', '牟平区', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523537', '2013-07-30 15:38:37', '', '莱山区', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523538', '2013-07-30 15:38:37', '', '长岛县', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523539', '2013-07-30 15:38:37', '', '龙口市', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523540', '2013-07-30 15:38:37', '', '莱阳市', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523541', '2013-07-30 15:38:37', '', '莱州市', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523542', '2013-07-30 15:38:38', '', '蓬莱市', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523543', '2013-07-30 15:38:38', '', '招远市', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523544', '2013-07-30 15:38:38', '', '栖霞市', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523545', '2013-07-30 15:38:38', '', '海阳市', '2', '0', '4523532', '');
INSERT INTO `ezs_area` VALUES ('4523546', '2013-07-30 15:38:38', '', '潍坊市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523547', '2013-07-30 15:38:38', '', '市辖区', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523548', '2013-07-30 15:38:38', '', '潍城区', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523549', '2013-07-30 15:38:38', '', '寒亭区', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523550', '2013-07-30 15:38:38', '', '坊子区', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523551', '2013-07-30 15:38:38', '', '奎文区', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523552', '2013-07-30 15:38:38', '', '临朐县', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523553', '2013-07-30 15:38:38', '', '昌乐县', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523554', '2013-07-30 15:38:38', '', '青州市', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523555', '2013-07-30 15:38:38', '', '诸城市', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523556', '2013-07-30 15:38:38', '', '寿光市', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523557', '2013-07-30 15:38:38', '', '安丘市', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523558', '2013-07-30 15:38:38', '', '高密市', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523559', '2013-07-30 15:38:39', '', '昌邑市', '2', '0', '4523546', '');
INSERT INTO `ezs_area` VALUES ('4523560', '2013-07-30 15:38:39', '', '济宁市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523561', '2013-07-30 15:38:39', '', '市辖区', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523562', '2013-07-30 15:38:39', '', '市中区', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523563', '2013-07-30 15:38:39', '', '任城区', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523564', '2013-07-30 15:38:39', '', '微山县', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523565', '2013-07-30 15:38:39', '', '鱼台县', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523566', '2013-07-30 15:38:39', '', '金乡县', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523567', '2013-07-30 15:38:39', '', '嘉祥县', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523568', '2013-07-30 15:38:39', '', '汶上县', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523569', '2013-07-30 15:38:39', '', '泗水县', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523570', '2013-07-30 15:38:39', '', '梁山县', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523571', '2013-07-30 15:38:39', '', '曲阜市', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523572', '2013-07-30 15:38:39', '', '兖州市', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523573', '2013-07-30 15:38:39', '', '邹城市', '2', '0', '4523560', '');
INSERT INTO `ezs_area` VALUES ('4523574', '2013-07-30 15:38:39', '', '泰安市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523575', '2013-07-30 15:38:40', '', '市辖区', '2', '0', '4523574', '');
INSERT INTO `ezs_area` VALUES ('4523576', '2013-07-30 15:38:40', '', '泰山区', '2', '0', '4523574', '');
INSERT INTO `ezs_area` VALUES ('4523577', '2013-07-30 15:38:40', '', '岱岳区', '2', '0', '4523574', '');
INSERT INTO `ezs_area` VALUES ('4523578', '2013-07-30 15:38:40', '', '宁阳县', '2', '0', '4523574', '');
INSERT INTO `ezs_area` VALUES ('4523579', '2013-07-30 15:38:40', '', '东平县', '2', '0', '4523574', '');
INSERT INTO `ezs_area` VALUES ('4523580', '2013-07-30 15:38:40', '', '新泰市', '2', '0', '4523574', '');
INSERT INTO `ezs_area` VALUES ('4523581', '2013-07-30 15:38:40', '', '肥城市', '2', '0', '4523574', '');
INSERT INTO `ezs_area` VALUES ('4523582', '2013-07-30 15:38:40', '', '威海市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523583', '2013-07-30 15:38:40', '', '市辖区', '2', '0', '4523582', '');
INSERT INTO `ezs_area` VALUES ('4523584', '2013-07-30 15:38:40', '', '环翠区', '2', '0', '4523582', '');
INSERT INTO `ezs_area` VALUES ('4523585', '2013-07-30 15:38:40', '', '文登市', '2', '0', '4523582', '');
INSERT INTO `ezs_area` VALUES ('4523586', '2013-07-30 15:38:40', '', '荣成市', '2', '0', '4523582', '');
INSERT INTO `ezs_area` VALUES ('4523587', '2013-07-30 15:38:40', '', '乳山市', '2', '0', '4523582', '');
INSERT INTO `ezs_area` VALUES ('4523588', '2013-07-30 15:38:40', '', '日照市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523589', '2013-07-30 15:38:40', '', '市辖区', '2', '0', '4523588', '');
INSERT INTO `ezs_area` VALUES ('4523590', '2013-07-30 15:38:40', '', '东港区', '2', '0', '4523588', '');
INSERT INTO `ezs_area` VALUES ('4523591', '2013-07-30 15:38:40', '', '岚山区', '2', '0', '4523588', '');
INSERT INTO `ezs_area` VALUES ('4523592', '2013-07-30 15:38:40', '', '五莲县', '2', '0', '4523588', '');
INSERT INTO `ezs_area` VALUES ('4523593', '2013-07-30 15:38:41', '', '莒县', '2', '0', '4523588', '');
INSERT INTO `ezs_area` VALUES ('4523594', '2013-07-30 15:38:41', '', '莱芜市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523595', '2013-07-30 15:38:41', '', '市辖区', '2', '0', '4523594', '');
INSERT INTO `ezs_area` VALUES ('4523596', '2013-07-30 15:38:41', '', '莱城区', '2', '0', '4523594', '');
INSERT INTO `ezs_area` VALUES ('4523597', '2013-07-30 15:38:41', '', '钢城区', '2', '0', '4523594', '');
INSERT INTO `ezs_area` VALUES ('4523598', '2013-07-30 15:38:41', '', '临沂市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523599', '2013-07-30 15:38:41', '', '市辖区', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523600', '2013-07-30 15:38:41', '', '兰山区', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523601', '2013-07-30 15:38:41', '', '罗庄区', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523602', '2013-07-30 15:38:41', '', '河东区', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523603', '2013-07-30 15:38:41', '', '沂南县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523604', '2013-07-30 15:38:41', '', '郯城县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523605', '2013-07-30 15:38:41', '', '沂水县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523606', '2013-07-30 15:38:41', '', '苍山县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523607', '2013-07-30 15:38:41', '', '费县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523608', '2013-07-30 15:38:41', '', '平邑县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523609', '2013-07-30 15:38:42', '', '莒南县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523610', '2013-07-30 15:38:42', '', '蒙阴县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523611', '2013-07-30 15:38:42', '', '临沭县', '2', '0', '4523598', '');
INSERT INTO `ezs_area` VALUES ('4523612', '2013-07-30 15:38:42', '', '德州市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523613', '2013-07-30 15:38:42', '', '市辖区', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523614', '2013-07-30 15:38:42', '', '德城区', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523615', '2013-07-30 15:38:42', '', '陵县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523616', '2013-07-30 15:38:42', '', '宁津县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523617', '2013-07-30 15:38:42', '', '庆云县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523618', '2013-07-30 15:38:42', '', '临邑县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523619', '2013-07-30 15:38:42', '', '齐河县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523620', '2013-07-30 15:38:42', '', '平原县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523621', '2013-07-30 15:38:42', '', '夏津县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523622', '2013-07-30 15:38:42', '', '武城县', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523623', '2013-07-30 15:38:42', '', '乐陵市', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523624', '2013-07-30 15:38:42', '', '禹城市', '2', '0', '4523612', '');
INSERT INTO `ezs_area` VALUES ('4523625', '2013-07-30 15:38:43', '', '聊城市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523626', '2013-07-30 15:38:43', '', '市辖区', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523627', '2013-07-30 15:38:43', '', '东昌府区', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523628', '2013-07-30 15:38:43', '', '阳谷县', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523629', '2013-07-30 15:38:43', '', '莘县', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523630', '2013-07-30 15:38:43', '', '茌平县', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523631', '2013-07-30 15:38:43', '', '东阿县', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523632', '2013-07-30 15:38:43', '', '冠县', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523633', '2013-07-30 15:38:43', '', '高唐县', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523634', '2013-07-30 15:38:43', '', '临清市', '2', '0', '4523625', '');
INSERT INTO `ezs_area` VALUES ('4523635', '2013-07-30 15:38:43', '', '滨州市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523636', '2013-07-30 15:38:43', '', '市辖区', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523637', '2013-07-30 15:38:43', '', '滨城区', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523638', '2013-07-30 15:38:43', '', '惠民县', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523639', '2013-07-30 15:38:43', '', '阳信县', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523640', '2013-07-30 15:38:43', '', '无棣县', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523641', '2013-07-30 15:38:44', '', '沾化县', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523642', '2013-07-30 15:38:44', '', '博兴县', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523643', '2013-07-30 15:38:44', '', '邹平县', '2', '0', '4523635', '');
INSERT INTO `ezs_area` VALUES ('4523644', '2013-07-30 15:38:44', '', '菏泽市', '1', '0', '4523480', '');
INSERT INTO `ezs_area` VALUES ('4523645', '2013-07-30 15:38:44', '', '市辖区', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523646', '2013-07-30 15:38:44', '', '牡丹区', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523647', '2013-07-30 15:38:44', '', '曹县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523648', '2013-07-30 15:38:44', '', '单县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523649', '2013-07-30 15:38:44', '', '成武县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523650', '2013-07-30 15:38:44', '', '巨野县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523651', '2013-07-30 15:38:44', '', '郓城县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523652', '2013-07-30 15:38:44', '', '鄄城县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523653', '2013-07-30 15:38:44', '', '定陶县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523654', '2013-07-30 15:38:44', '', '东明县', '2', '0', '4523644', '');
INSERT INTO `ezs_area` VALUES ('4523655', '2013-07-30 15:38:44', '', '河南省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523656', '2013-07-30 15:38:44', '', '郑州市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523657', '2013-07-30 15:38:44', '', '市辖区', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523658', '2013-07-30 15:38:45', '', '中原区', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523659', '2013-07-30 15:38:45', '', '二七区', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523660', '2013-07-30 15:38:45', '', '管城回族区', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523661', '2013-07-30 15:38:45', '', '金水区', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523662', '2013-07-30 15:38:45', '', '上街区', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523663', '2013-07-30 15:38:45', '', '惠济区', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523664', '2013-07-30 15:38:45', '', '中牟县', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523665', '2013-07-30 15:38:45', '', '巩义市', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523666', '2013-07-30 15:38:45', '', '荥阳市', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523667', '2013-07-30 15:38:45', '', '新密市', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523668', '2013-07-30 15:38:45', '', '新郑市', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523669', '2013-07-30 15:38:45', '', '登封市', '2', '0', '4523656', '');
INSERT INTO `ezs_area` VALUES ('4523670', '2013-07-30 15:38:45', '', '开封市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523671', '2013-07-30 15:38:45', '', '市辖区', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523672', '2013-07-30 15:38:45', '', '龙亭区', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523673', '2013-07-30 15:38:45', '', '顺河回族区', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523674', '2013-07-30 15:38:46', '', '鼓楼区', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523675', '2013-07-30 15:38:46', '', '禹王台区', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523676', '2013-07-30 15:38:46', '', '金明区', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523677', '2013-07-30 15:38:46', '', '杞县', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523678', '2013-07-30 15:38:46', '', '通许县', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523679', '2013-07-30 15:38:46', '', '尉氏县', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523680', '2013-07-30 15:38:46', '', '开封县', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523681', '2013-07-30 15:38:46', '', '兰考县', '2', '0', '4523670', '');
INSERT INTO `ezs_area` VALUES ('4523682', '2013-07-30 15:38:46', '', '洛阳市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523683', '2013-07-30 15:38:46', '', '市辖区', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523684', '2013-07-30 15:38:46', '', '老城区', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523685', '2013-07-30 15:38:46', '', '西工区', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523686', '2013-07-30 15:38:46', '', '瀍河回族区', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523687', '2013-07-30 15:38:46', '', '涧西区', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523688', '2013-07-30 15:38:46', '', '吉利区', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523689', '2013-07-30 15:38:46', '', '洛龙区', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523690', '2013-07-30 15:38:47', '', '孟津县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523691', '2013-07-30 15:38:47', '', '新安县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523692', '2013-07-30 15:38:47', '', '栾川县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523693', '2013-07-30 15:38:47', '', '嵩县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523694', '2013-07-30 15:38:47', '', '汝阳县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523695', '2013-07-30 15:38:47', '', '宜阳县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523696', '2013-07-30 15:38:47', '', '洛宁县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523697', '2013-07-30 15:38:47', '', '伊川县', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523698', '2013-07-30 15:38:47', '', '偃师市', '2', '0', '4523682', '');
INSERT INTO `ezs_area` VALUES ('4523699', '2013-07-30 15:38:47', '', '平顶山市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523700', '2013-07-30 15:38:47', '', '市辖区', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523701', '2013-07-30 15:38:47', '', '新华区', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523702', '2013-07-30 15:38:47', '', '卫东区', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523703', '2013-07-30 15:38:47', '', '石龙区', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523704', '2013-07-30 15:38:47', '', '湛河区', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523705', '2013-07-30 15:38:47', '', '宝丰县', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523706', '2013-07-30 15:38:47', '', '叶县', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523707', '2013-07-30 15:38:48', '', '鲁山县', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523708', '2013-07-30 15:38:48', '', '郏县', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523709', '2013-07-30 15:38:48', '', '舞钢市', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523710', '2013-07-30 15:38:48', '', '汝州市', '2', '0', '4523699', '');
INSERT INTO `ezs_area` VALUES ('4523711', '2013-07-30 15:38:48', '', '安阳市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523712', '2013-07-30 15:38:48', '', '市辖区', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523713', '2013-07-30 15:38:48', '', '文峰区', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523714', '2013-07-30 15:38:48', '', '北关区', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523715', '2013-07-30 15:38:48', '', '殷都区', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523716', '2013-07-30 15:38:48', '', '龙安区', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523717', '2013-07-30 15:38:48', '', '安阳县', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523718', '2013-07-30 15:38:48', '', '汤阴县', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523719', '2013-07-30 15:38:48', '', '滑县', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523720', '2013-07-30 15:38:48', '', '内黄县', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523721', '2013-07-30 15:38:48', '', '林州市', '2', '0', '4523711', '');
INSERT INTO `ezs_area` VALUES ('4523722', '2013-07-30 15:38:48', '', '鹤壁市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523723', '2013-07-30 15:38:49', '', '市辖区', '2', '0', '4523722', '');
INSERT INTO `ezs_area` VALUES ('4523724', '2013-07-30 15:38:49', '', '鹤山区', '2', '0', '4523722', '');
INSERT INTO `ezs_area` VALUES ('4523725', '2013-07-30 15:38:49', '', '山城区', '2', '0', '4523722', '');
INSERT INTO `ezs_area` VALUES ('4523726', '2013-07-30 15:38:49', '', '淇滨区', '2', '0', '4523722', '');
INSERT INTO `ezs_area` VALUES ('4523727', '2013-07-30 15:38:49', '', '浚县', '2', '0', '4523722', '');
INSERT INTO `ezs_area` VALUES ('4523728', '2013-07-30 15:38:49', '', '淇县', '2', '0', '4523722', '');
INSERT INTO `ezs_area` VALUES ('4523729', '2013-07-30 15:38:49', '', '新乡市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523730', '2013-07-30 15:38:49', '', '市辖区', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523731', '2013-07-30 15:38:49', '', '红旗区', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523732', '2013-07-30 15:38:49', '', '卫滨区', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523733', '2013-07-30 15:38:49', '', '凤泉区', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523734', '2013-07-30 15:38:49', '', '牧野区', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523735', '2013-07-30 15:38:49', '', '新乡县', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523736', '2013-07-30 15:38:49', '', '获嘉县', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523737', '2013-07-30 15:38:49', '', '原阳县', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523738', '2013-07-30 15:38:49', '', '延津县', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523739', '2013-07-30 15:38:50', '', '封丘县', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523740', '2013-07-30 15:38:50', '', '长垣县', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523741', '2013-07-30 15:38:50', '', '卫辉市', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523742', '2013-07-30 15:38:50', '', '辉县市', '2', '0', '4523729', '');
INSERT INTO `ezs_area` VALUES ('4523743', '2013-07-30 15:38:50', '', '焦作市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523744', '2013-07-30 15:38:50', '', '市辖区', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523745', '2013-07-30 15:38:50', '', '解放区', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523746', '2013-07-30 15:38:50', '', '中站区', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523747', '2013-07-30 15:38:50', '', '马村区', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523748', '2013-07-30 15:38:50', '', '山阳区', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523749', '2013-07-30 15:38:50', '', '修武县', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523750', '2013-07-30 15:38:50', '', '博爱县', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523751', '2013-07-30 15:38:50', '', '武陟县', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523752', '2013-07-30 15:38:50', '', '温县', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523753', '2013-07-30 15:38:50', '', '沁阳市', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523754', '2013-07-30 15:38:51', '', '孟州市', '2', '0', '4523743', '');
INSERT INTO `ezs_area` VALUES ('4523755', '2013-07-30 15:38:51', '', '濮阳市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523756', '2013-07-30 15:38:51', '', '市辖区', '2', '0', '4523755', '');
INSERT INTO `ezs_area` VALUES ('4523757', '2013-07-30 15:38:51', '', '华龙区', '2', '0', '4523755', '');
INSERT INTO `ezs_area` VALUES ('4523758', '2013-07-30 15:38:51', '', '清丰县', '2', '0', '4523755', '');
INSERT INTO `ezs_area` VALUES ('4523759', '2013-07-30 15:38:51', '', '南乐县', '2', '0', '4523755', '');
INSERT INTO `ezs_area` VALUES ('4523760', '2013-07-30 15:38:51', '', '范县', '2', '0', '4523755', '');
INSERT INTO `ezs_area` VALUES ('4523761', '2013-07-30 15:38:51', '', '台前县', '2', '0', '4523755', '');
INSERT INTO `ezs_area` VALUES ('4523762', '2013-07-30 15:38:51', '', '濮阳县', '2', '0', '4523755', '');
INSERT INTO `ezs_area` VALUES ('4523763', '2013-07-30 15:38:51', '', '许昌市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523764', '2013-07-30 15:38:51', '', '市辖区', '2', '0', '4523763', '');
INSERT INTO `ezs_area` VALUES ('4523765', '2013-07-30 15:38:51', '', '魏都区', '2', '0', '4523763', '');
INSERT INTO `ezs_area` VALUES ('4523766', '2013-07-30 15:38:51', '', '许昌县', '2', '0', '4523763', '');
INSERT INTO `ezs_area` VALUES ('4523767', '2013-07-30 15:38:51', '', '鄢陵县', '2', '0', '4523763', '');
INSERT INTO `ezs_area` VALUES ('4523768', '2013-07-30 15:38:51', '', '襄城县', '2', '0', '4523763', '');
INSERT INTO `ezs_area` VALUES ('4523769', '2013-07-30 15:38:51', '', '禹州市', '2', '0', '4523763', '');
INSERT INTO `ezs_area` VALUES ('4523770', '2013-07-30 15:38:52', '', '长葛市', '2', '0', '4523763', '');
INSERT INTO `ezs_area` VALUES ('4523771', '2013-07-30 15:38:52', '', '漯河市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523772', '2013-07-30 15:38:52', '', '市辖区', '2', '0', '4523771', '');
INSERT INTO `ezs_area` VALUES ('4523773', '2013-07-30 15:38:52', '', '源汇区', '2', '0', '4523771', '');
INSERT INTO `ezs_area` VALUES ('4523774', '2013-07-30 15:38:52', '', '郾城区', '2', '0', '4523771', '');
INSERT INTO `ezs_area` VALUES ('4523775', '2013-07-30 15:38:52', '', '召陵区', '2', '0', '4523771', '');
INSERT INTO `ezs_area` VALUES ('4523776', '2013-07-30 15:38:52', '', '舞阳县', '2', '0', '4523771', '');
INSERT INTO `ezs_area` VALUES ('4523777', '2013-07-30 15:38:52', '', '临颍县', '2', '0', '4523771', '');
INSERT INTO `ezs_area` VALUES ('4523778', '2013-07-30 15:38:52', '', '三门峡市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523779', '2013-07-30 15:38:52', '', '市辖区', '2', '0', '4523778', '');
INSERT INTO `ezs_area` VALUES ('4523780', '2013-07-30 15:38:52', '', '湖滨区', '2', '0', '4523778', '');
INSERT INTO `ezs_area` VALUES ('4523781', '2013-07-30 15:38:52', '', '渑池县', '2', '0', '4523778', '');
INSERT INTO `ezs_area` VALUES ('4523782', '2013-07-30 15:38:52', '', '陕县', '2', '0', '4523778', '');
INSERT INTO `ezs_area` VALUES ('4523783', '2013-07-30 15:38:52', '', '卢氏县', '2', '0', '4523778', '');
INSERT INTO `ezs_area` VALUES ('4523784', '2013-07-30 15:38:53', '', '义马市', '2', '0', '4523778', '');
INSERT INTO `ezs_area` VALUES ('4523785', '2013-07-30 15:38:53', '', '灵宝市', '2', '0', '4523778', '');
INSERT INTO `ezs_area` VALUES ('4523786', '2013-07-30 15:38:53', '', '南阳市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523787', '2013-07-30 15:38:53', '', '市辖区', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523788', '2013-07-30 15:38:53', '', '宛城区', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523789', '2013-07-30 15:38:53', '', '卧龙区', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523790', '2013-07-30 15:38:53', '', '南召县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523791', '2013-07-30 15:38:53', '', '方城县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523792', '2013-07-30 15:38:53', '', '西峡县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523793', '2013-07-30 15:38:53', '', '镇平县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523794', '2013-07-30 15:38:53', '', '内乡县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523795', '2013-07-30 15:38:53', '', '淅川县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523796', '2013-07-30 15:38:53', '', '社旗县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523797', '2013-07-30 15:38:53', '', '唐河县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523798', '2013-07-30 15:38:53', '', '新野县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523799', '2013-07-30 15:38:53', '', '桐柏县', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523800', '2013-07-30 15:38:53', '', '邓州市', '2', '0', '4523786', '');
INSERT INTO `ezs_area` VALUES ('4523801', '2013-07-30 15:38:54', '', '商丘市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523802', '2013-07-30 15:38:54', '', '市辖区', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523803', '2013-07-30 15:38:54', '', '梁园区', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523804', '2013-07-30 15:38:54', '', '睢阳区', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523805', '2013-07-30 15:38:54', '', '民权县', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523806', '2013-07-30 15:38:54', '', '睢县', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523807', '2013-07-30 15:38:54', '', '宁陵县', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523808', '2013-07-30 15:38:54', '', '柘城县', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523809', '2013-07-30 15:38:54', '', '虞城县', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523810', '2013-07-30 15:38:54', '', '夏邑县', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523811', '2013-07-30 15:38:54', '', '永城市', '2', '0', '4523801', '');
INSERT INTO `ezs_area` VALUES ('4523812', '2013-07-30 15:38:54', '', '信阳市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523813', '2013-07-30 15:38:54', '', '市辖区', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523814', '2013-07-30 15:38:54', '', '浉河区', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523815', '2013-07-30 15:38:54', '', '平桥区', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523816', '2013-07-30 15:38:54', '', '罗山县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523817', '2013-07-30 15:38:55', '', '光山县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523818', '2013-07-30 15:38:55', '', '新县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523819', '2013-07-30 15:38:55', '', '商城县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523820', '2013-07-30 15:38:55', '', '固始县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523821', '2013-07-30 15:38:55', '', '潢川县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523822', '2013-07-30 15:38:55', '', '淮滨县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523823', '2013-07-30 15:38:55', '', '息县', '2', '0', '4523812', '');
INSERT INTO `ezs_area` VALUES ('4523824', '2013-07-30 15:38:55', '', '周口市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523825', '2013-07-30 15:38:55', '', '市辖区', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523826', '2013-07-30 15:38:55', '', '川汇区', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523827', '2013-07-30 15:38:55', '', '扶沟县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523828', '2013-07-30 15:38:55', '', '西华县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523829', '2013-07-30 15:38:55', '', '商水县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523830', '2013-07-30 15:38:55', '', '沈丘县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523831', '2013-07-30 15:38:55', '', '郸城县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523832', '2013-07-30 15:38:55', '', '淮阳县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523833', '2013-07-30 15:38:56', '', '太康县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523834', '2013-07-30 15:38:56', '', '鹿邑县', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523835', '2013-07-30 15:38:56', '', '项城市', '2', '0', '4523824', '');
INSERT INTO `ezs_area` VALUES ('4523836', '2013-07-30 15:38:56', '', '驻马店市', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523837', '2013-07-30 15:38:56', '', '市辖区', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523838', '2013-07-30 15:38:56', '', '驿城区', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523839', '2013-07-30 15:38:56', '', '西平县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523840', '2013-07-30 15:38:56', '', '上蔡县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523841', '2013-07-30 15:38:56', '', '平舆县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523842', '2013-07-30 15:38:56', '', '正阳县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523843', '2013-07-30 15:38:56', '', '确山县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523844', '2013-07-30 15:38:56', '', '泌阳县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523845', '2013-07-30 15:38:56', '', '汝南县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523846', '2013-07-30 15:38:56', '', '遂平县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523847', '2013-07-30 15:38:56', '', '新蔡县', '2', '0', '4523836', '');
INSERT INTO `ezs_area` VALUES ('4523848', '2013-07-30 15:38:56', '', '省直辖县级行政区划', '1', '0', '4523655', '');
INSERT INTO `ezs_area` VALUES ('4523849', '2013-07-30 15:38:57', '', '济源市', '2', '0', '4523848', '');
INSERT INTO `ezs_area` VALUES ('4523850', '2013-07-30 15:38:57', '', '湖北省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523851', '2013-07-30 15:38:57', '', '武汉市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523852', '2013-07-30 15:38:57', '', '市辖区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523853', '2013-07-30 15:38:57', '', '江岸区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523854', '2013-07-30 15:38:57', '', '江汉区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523855', '2013-07-30 15:38:57', '', '硚口区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523856', '2013-07-30 15:38:57', '', '汉阳区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523857', '2013-07-30 15:38:57', '', '武昌区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523858', '2013-07-30 15:38:57', '', '青山区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523859', '2013-07-30 15:38:57', '', '洪山区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523860', '2013-07-30 15:38:57', '', '东西湖区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523861', '2013-07-30 15:38:57', '', '汉南区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523862', '2013-07-30 15:38:57', '', '蔡甸区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523863', '2013-07-30 15:38:57', '', '江夏区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523864', '2013-07-30 15:38:57', '', '黄陂区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523865', '2013-07-30 15:38:58', '', '新洲区', '2', '0', '4523851', '');
INSERT INTO `ezs_area` VALUES ('4523866', '2013-07-30 15:38:58', '', '黄石市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523867', '2013-07-30 15:38:58', '', '市辖区', '2', '0', '4523866', '');
INSERT INTO `ezs_area` VALUES ('4523868', '2013-07-30 15:38:58', '', '黄石港区', '2', '0', '4523866', '');
INSERT INTO `ezs_area` VALUES ('4523869', '2013-07-30 15:38:58', '', '西塞山区', '2', '0', '4523866', '');
INSERT INTO `ezs_area` VALUES ('4523870', '2013-07-30 15:38:58', '', '下陆区', '2', '0', '4523866', '');
INSERT INTO `ezs_area` VALUES ('4523871', '2013-07-30 15:38:58', '', '铁山区', '2', '0', '4523866', '');
INSERT INTO `ezs_area` VALUES ('4523872', '2013-07-30 15:38:58', '', '阳新县', '2', '0', '4523866', '');
INSERT INTO `ezs_area` VALUES ('4523873', '2013-07-30 15:38:58', '', '大冶市', '2', '0', '4523866', '');
INSERT INTO `ezs_area` VALUES ('4523874', '2013-07-30 15:38:58', '', '十堰市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523875', '2013-07-30 15:38:58', '', '市辖区', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523876', '2013-07-30 15:38:58', '', '茅箭区', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523877', '2013-07-30 15:38:58', '', '张湾区', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523878', '2013-07-30 15:38:58', '', '郧县', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523879', '2013-07-30 15:38:58', '', '郧西县', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523880', '2013-07-30 15:38:59', '', '竹山县', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523881', '2013-07-30 15:38:59', '', '竹溪县', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523882', '2013-07-30 15:38:59', '', '房县', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523883', '2013-07-30 15:38:59', '', '丹江口市', '2', '0', '4523874', '');
INSERT INTO `ezs_area` VALUES ('4523884', '2013-07-30 15:38:59', '', '宜昌市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523885', '2013-07-30 15:38:59', '', '市辖区', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523886', '2013-07-30 15:38:59', '', '西陵区', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523887', '2013-07-30 15:38:59', '', '伍家岗区', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523888', '2013-07-30 15:38:59', '', '点军区', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523889', '2013-07-30 15:38:59', '', '猇亭区', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523890', '2013-07-30 15:38:59', '', '夷陵区', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523891', '2013-07-30 15:38:59', '', '远安县', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523892', '2013-07-30 15:38:59', '', '兴山县', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523893', '2013-07-30 15:38:59', '', '秭归县', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523894', '2013-07-30 15:38:59', '', '长阳土家族自治县', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523895', '2013-07-30 15:39:00', '', '五峰土家族自治县', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523896', '2013-07-30 15:39:00', '', '宜都市', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523897', '2013-07-30 15:39:00', '', '当阳市', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523898', '2013-07-30 15:39:00', '', '枝江市', '2', '0', '4523884', '');
INSERT INTO `ezs_area` VALUES ('4523899', '2013-07-30 15:39:00', '', '襄樊市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523900', '2013-07-30 15:39:00', '', '市辖区', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523901', '2013-07-30 15:39:00', '', '襄城区', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523902', '2013-07-30 15:39:00', '', '樊城区', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523903', '2013-07-30 15:39:00', '', '襄阳区', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523904', '2013-07-30 15:39:00', '', '南漳县', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523905', '2013-07-30 15:39:00', '', '谷城县', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523906', '2013-07-30 15:39:00', '', '保康县', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523907', '2013-07-30 15:39:00', '', '老河口市', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523908', '2013-07-30 15:39:00', '', '枣阳市', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523909', '2013-07-30 15:39:00', '', '宜城市', '2', '0', '4523899', '');
INSERT INTO `ezs_area` VALUES ('4523910', '2013-07-30 15:39:01', '', '鄂州市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523911', '2013-07-30 15:39:01', '', '市辖区', '2', '0', '4523910', '');
INSERT INTO `ezs_area` VALUES ('4523912', '2013-07-30 15:39:01', '', '梁子湖区', '2', '0', '4523910', '');
INSERT INTO `ezs_area` VALUES ('4523913', '2013-07-30 15:39:01', '', '华容区', '2', '0', '4523910', '');
INSERT INTO `ezs_area` VALUES ('4523914', '2013-07-30 15:39:01', '', '鄂城区', '2', '0', '4523910', '');
INSERT INTO `ezs_area` VALUES ('4523915', '2013-07-30 15:39:01', '', '荆门市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523916', '2013-07-30 15:39:01', '', '市辖区', '2', '0', '4523915', '');
INSERT INTO `ezs_area` VALUES ('4523917', '2013-07-30 15:39:01', '', '东宝区', '2', '0', '4523915', '');
INSERT INTO `ezs_area` VALUES ('4523918', '2013-07-30 15:39:01', '', '掇刀区', '2', '0', '4523915', '');
INSERT INTO `ezs_area` VALUES ('4523919', '2013-07-30 15:39:01', '', '京山县', '2', '0', '4523915', '');
INSERT INTO `ezs_area` VALUES ('4523920', '2013-07-30 15:39:01', '', '沙洋县', '2', '0', '4523915', '');
INSERT INTO `ezs_area` VALUES ('4523921', '2013-07-30 15:39:01', '', '钟祥市', '2', '0', '4523915', '');
INSERT INTO `ezs_area` VALUES ('4523922', '2013-07-30 15:39:01', '', '孝感市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523923', '2013-07-30 15:39:01', '', '市辖区', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523924', '2013-07-30 15:39:01', '', '孝南区', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523925', '2013-07-30 15:39:02', '', '孝昌县', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523926', '2013-07-30 15:39:02', '', '大悟县', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523927', '2013-07-30 15:39:02', '', '云梦县', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523928', '2013-07-30 15:39:02', '', '应城市', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523929', '2013-07-30 15:39:02', '', '安陆市', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523930', '2013-07-30 15:39:02', '', '汉川市', '2', '0', '4523922', '');
INSERT INTO `ezs_area` VALUES ('4523931', '2013-07-30 15:39:02', '', '荆州市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523932', '2013-07-30 15:39:02', '', '市辖区', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523933', '2013-07-30 15:39:02', '', '沙市区', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523934', '2013-07-30 15:39:02', '', '荆州区', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523935', '2013-07-30 15:39:02', '', '公安县', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523936', '2013-07-30 15:39:02', '', '监利县', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523937', '2013-07-30 15:39:02', '', '江陵县', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523938', '2013-07-30 15:39:03', '', '石首市', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523939', '2013-07-30 15:39:03', '', '洪湖市', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523940', '2013-07-30 15:39:03', '', '松滋市', '2', '0', '4523931', '');
INSERT INTO `ezs_area` VALUES ('4523941', '2013-07-30 15:39:03', '', '黄冈市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523942', '2013-07-30 15:39:03', '', '市辖区', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523943', '2013-07-30 15:39:03', '', '黄州区', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523944', '2013-07-30 15:39:03', '', '团风县', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523945', '2013-07-30 15:39:03', '', '红安县', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523946', '2013-07-30 15:39:03', '', '罗田县', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523947', '2013-07-30 15:39:03', '', '英山县', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523948', '2013-07-30 15:39:03', '', '浠水县', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523949', '2013-07-30 15:39:03', '', '蕲春县', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523950', '2013-07-30 15:39:03', '', '黄梅县', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523951', '2013-07-30 15:39:03', '', '麻城市', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523952', '2013-07-30 15:39:04', '', '武穴市', '2', '0', '4523941', '');
INSERT INTO `ezs_area` VALUES ('4523953', '2013-07-30 15:39:04', '', '咸宁市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523954', '2013-07-30 15:39:04', '', '市辖区', '2', '0', '4523953', '');
INSERT INTO `ezs_area` VALUES ('4523955', '2013-07-30 15:39:04', '', '咸安区', '2', '0', '4523953', '');
INSERT INTO `ezs_area` VALUES ('4523956', '2013-07-30 15:39:04', '', '嘉鱼县', '2', '0', '4523953', '');
INSERT INTO `ezs_area` VALUES ('4523957', '2013-07-30 15:39:04', '', '通城县', '2', '0', '4523953', '');
INSERT INTO `ezs_area` VALUES ('4523958', '2013-07-30 15:39:04', '', '崇阳县', '2', '0', '4523953', '');
INSERT INTO `ezs_area` VALUES ('4523959', '2013-07-30 15:39:04', '', '通山县', '2', '0', '4523953', '');
INSERT INTO `ezs_area` VALUES ('4523960', '2013-07-30 15:39:04', '', '赤壁市', '2', '0', '4523953', '');
INSERT INTO `ezs_area` VALUES ('4523961', '2013-07-30 15:39:04', '', '随州市', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523962', '2013-07-30 15:39:04', '', '市辖区', '2', '0', '4523961', '');
INSERT INTO `ezs_area` VALUES ('4523963', '2013-07-30 15:39:04', '', '曾都区', '2', '0', '4523961', '');
INSERT INTO `ezs_area` VALUES ('4523964', '2013-07-30 15:39:04', '', '随县', '2', '0', '4523961', '');
INSERT INTO `ezs_area` VALUES ('4523965', '2013-07-30 15:39:04', '', '广水市', '2', '0', '4523961', '');
INSERT INTO `ezs_area` VALUES ('4523966', '2013-07-30 15:39:05', '', '恩施土家族苗族自治州', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523967', '2013-07-30 15:39:05', '', '恩施市', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523968', '2013-07-30 15:39:05', '', '利川市', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523969', '2013-07-30 15:39:05', '', '建始县', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523970', '2013-07-30 15:39:05', '', '巴东县', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523971', '2013-07-30 15:39:05', '', '宣恩县', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523972', '2013-07-30 15:39:05', '', '咸丰县', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523973', '2013-07-30 15:39:05', '', '来凤县', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523974', '2013-07-30 15:39:05', '', '鹤峰县', '2', '0', '4523966', '');
INSERT INTO `ezs_area` VALUES ('4523975', '2013-07-30 15:39:05', '', '省直辖县级行政区划', '1', '0', '4523850', '');
INSERT INTO `ezs_area` VALUES ('4523976', '2013-07-30 15:39:05', '', '仙桃市', '2', '0', '4523975', '');
INSERT INTO `ezs_area` VALUES ('4523977', '2013-07-30 15:39:05', '', '潜江市', '2', '0', '4523975', '');
INSERT INTO `ezs_area` VALUES ('4523978', '2013-07-30 15:39:05', '', '天门市', '2', '0', '4523975', '');
INSERT INTO `ezs_area` VALUES ('4523979', '2013-07-30 15:39:05', '', '神农架林区', '2', '0', '4523975', '');
INSERT INTO `ezs_area` VALUES ('4523980', '2013-07-30 15:39:05', '', '湖南省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4523981', '2013-07-30 15:39:06', '', '长沙市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4523982', '2013-07-30 15:39:06', '', '市辖区', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523983', '2013-07-30 15:39:06', '', '芙蓉区', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523984', '2013-07-30 15:39:06', '', '天心区', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523985', '2013-07-30 15:39:06', '', '岳麓区', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523986', '2013-07-30 15:39:06', '', '开福区', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523987', '2013-07-30 15:39:06', '', '雨花区', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523988', '2013-07-30 15:39:06', '', '长沙县', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523989', '2013-07-30 15:39:06', '', '望城县', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523990', '2013-07-30 15:39:06', '', '宁乡县', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523991', '2013-07-30 15:39:06', '', '浏阳市', '2', '0', '4523981', '');
INSERT INTO `ezs_area` VALUES ('4523992', '2013-07-30 15:39:06', '', '株洲市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4523993', '2013-07-30 15:39:06', '', '市辖区', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4523994', '2013-07-30 15:39:06', '', '荷塘区', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4523995', '2013-07-30 15:39:06', '', '芦淞区', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4523996', '2013-07-30 15:39:07', '', '石峰区', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4523997', '2013-07-30 15:39:07', '', '天元区', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4523998', '2013-07-30 15:39:07', '', '株洲县', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4523999', '2013-07-30 15:39:07', '', '攸县', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4524000', '2013-07-30 15:39:07', '', '茶陵县', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4524001', '2013-07-30 15:39:07', '', '炎陵县', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4524002', '2013-07-30 15:39:07', '', '醴陵市', '2', '0', '4523992', '');
INSERT INTO `ezs_area` VALUES ('4524003', '2013-07-30 15:39:07', '', '湘潭市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524004', '2013-07-30 15:39:07', '', '市辖区', '2', '0', '4524003', '');
INSERT INTO `ezs_area` VALUES ('4524005', '2013-07-30 15:39:07', '', '雨湖区', '2', '0', '4524003', '');
INSERT INTO `ezs_area` VALUES ('4524006', '2013-07-30 15:39:07', '', '岳塘区', '2', '0', '4524003', '');
INSERT INTO `ezs_area` VALUES ('4524007', '2013-07-30 15:39:07', '', '湘潭县', '2', '0', '4524003', '');
INSERT INTO `ezs_area` VALUES ('4524008', '2013-07-30 15:39:07', '', '湘乡市', '2', '0', '4524003', '');
INSERT INTO `ezs_area` VALUES ('4524009', '2013-07-30 15:39:07', '', '韶山市', '2', '0', '4524003', '');
INSERT INTO `ezs_area` VALUES ('4524010', '2013-07-30 15:39:08', '', '衡阳市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524011', '2013-07-30 15:39:08', '', '市辖区', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524012', '2013-07-30 15:39:08', '', '珠晖区', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524013', '2013-07-30 15:39:08', '', '雁峰区', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524014', '2013-07-30 15:39:08', '', '石鼓区', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524015', '2013-07-30 15:39:08', '', '蒸湘区', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524016', '2013-07-30 15:39:08', '', '南岳区', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524017', '2013-07-30 15:39:08', '', '衡阳县', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524018', '2013-07-30 15:39:08', '', '衡南县', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524019', '2013-07-30 15:39:08', '', '衡山县', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524020', '2013-07-30 15:39:08', '', '衡东县', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524021', '2013-07-30 15:39:08', '', '祁东县', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524022', '2013-07-30 15:39:08', '', '耒阳市', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524023', '2013-07-30 15:39:08', '', '常宁市', '2', '0', '4524010', '');
INSERT INTO `ezs_area` VALUES ('4524024', '2013-07-30 15:39:08', '', '邵阳市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524025', '2013-07-30 15:39:09', '', '市辖区', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524026', '2013-07-30 15:39:09', '', '双清区', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524027', '2013-07-30 15:39:09', '', '大祥区', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524028', '2013-07-30 15:39:09', '', '北塔区', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524029', '2013-07-30 15:39:09', '', '邵东县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524030', '2013-07-30 15:39:09', '', '新邵县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524031', '2013-07-30 15:39:09', '', '邵阳县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524032', '2013-07-30 15:39:09', '', '隆回县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524033', '2013-07-30 15:39:09', '', '洞口县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524034', '2013-07-30 15:39:09', '', '绥宁县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524035', '2013-07-30 15:39:09', '', '新宁县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524036', '2013-07-30 15:39:09', '', '城步苗族自治县', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524037', '2013-07-30 15:39:09', '', '武冈市', '2', '0', '4524024', '');
INSERT INTO `ezs_area` VALUES ('4524038', '2013-07-30 15:39:09', '', '岳阳市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524039', '2013-07-30 15:39:10', '', '市辖区', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524040', '2013-07-30 15:39:10', '', '岳阳楼区', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524041', '2013-07-30 15:39:10', '', '云溪区', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524042', '2013-07-30 15:39:10', '', '君山区', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524043', '2013-07-30 15:39:10', '', '岳阳县', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524044', '2013-07-30 15:39:10', '', '华容县', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524045', '2013-07-30 15:39:10', '', '湘阴县', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524046', '2013-07-30 15:39:10', '', '平江县', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524047', '2013-07-30 15:39:10', '', '汨罗市', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524048', '2013-07-30 15:39:10', '', '临湘市', '2', '0', '4524038', '');
INSERT INTO `ezs_area` VALUES ('4524049', '2013-07-30 15:39:10', '', '常德市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524050', '2013-07-30 15:39:10', '', '市辖区', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524051', '2013-07-30 15:39:10', '', '武陵区', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524052', '2013-07-30 15:39:10', '', '鼎城区', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524053', '2013-07-30 15:39:10', '', '安乡县', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524054', '2013-07-30 15:39:11', '', '汉寿县', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524055', '2013-07-30 15:39:11', '', '澧县', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524056', '2013-07-30 15:39:11', '', '临澧县', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524057', '2013-07-30 15:39:11', '', '桃源县', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524058', '2013-07-30 15:39:11', '', '石门县', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524059', '2013-07-30 15:39:11', '', '津市市', '2', '0', '4524049', '');
INSERT INTO `ezs_area` VALUES ('4524060', '2013-07-30 15:39:11', '', '张家界市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524061', '2013-07-30 15:39:11', '', '市辖区', '2', '0', '4524060', '');
INSERT INTO `ezs_area` VALUES ('4524062', '2013-07-30 15:39:11', '', '永定区', '2', '0', '4524060', '');
INSERT INTO `ezs_area` VALUES ('4524063', '2013-07-30 15:39:11', '', '武陵源区', '2', '0', '4524060', '');
INSERT INTO `ezs_area` VALUES ('4524064', '2013-07-30 15:39:11', '', '慈利县', '2', '0', '4524060', '');
INSERT INTO `ezs_area` VALUES ('4524065', '2013-07-30 15:39:11', '', '桑植县', '2', '0', '4524060', '');
INSERT INTO `ezs_area` VALUES ('4524066', '2013-07-30 15:39:11', '', '益阳市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524067', '2013-07-30 15:39:11', '', '市辖区', '2', '0', '4524066', '');
INSERT INTO `ezs_area` VALUES ('4524068', '2013-07-30 15:39:11', '', '资阳区', '2', '0', '4524066', '');
INSERT INTO `ezs_area` VALUES ('4524069', '2013-07-30 15:39:12', '', '赫山区', '2', '0', '4524066', '');
INSERT INTO `ezs_area` VALUES ('4524070', '2013-07-30 15:39:12', '', '南县', '2', '0', '4524066', '');
INSERT INTO `ezs_area` VALUES ('4524071', '2013-07-30 15:39:12', '', '桃江县', '2', '0', '4524066', '');
INSERT INTO `ezs_area` VALUES ('4524072', '2013-07-30 15:39:12', '', '安化县', '2', '0', '4524066', '');
INSERT INTO `ezs_area` VALUES ('4524073', '2013-07-30 15:39:12', '', '沅江市', '2', '0', '4524066', '');
INSERT INTO `ezs_area` VALUES ('4524074', '2013-07-30 15:39:12', '', '郴州市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524075', '2013-07-30 15:39:12', '', '市辖区', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524076', '2013-07-30 15:39:12', '', '北湖区', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524077', '2013-07-30 15:39:12', '', '苏仙区', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524078', '2013-07-30 15:39:12', '', '桂阳县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524079', '2013-07-30 15:39:12', '', '宜章县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524080', '2013-07-30 15:39:12', '', '永兴县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524081', '2013-07-30 15:39:12', '', '嘉禾县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524082', '2013-07-30 15:39:12', '', '临武县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524083', '2013-07-30 15:39:13', '', '汝城县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524084', '2013-07-30 15:39:13', '', '桂东县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524085', '2013-07-30 15:39:13', '', '安仁县', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524086', '2013-07-30 15:39:13', '', '资兴市', '2', '0', '4524074', '');
INSERT INTO `ezs_area` VALUES ('4524087', '2013-07-30 15:39:13', '', '永州市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524088', '2013-07-30 15:39:13', '', '市辖区', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524089', '2013-07-30 15:39:13', '', '零陵区', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524090', '2013-07-30 15:39:13', '', '冷水滩区', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524091', '2013-07-30 15:39:13', '', '祁阳县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524092', '2013-07-30 15:39:13', '', '东安县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524093', '2013-07-30 15:39:13', '', '双牌县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524094', '2013-07-30 15:39:13', '', '道县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524095', '2013-07-30 15:39:13', '', '江永县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524096', '2013-07-30 15:39:14', '', '宁远县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524097', '2013-07-30 15:39:14', '', '蓝山县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524098', '2013-07-30 15:39:14', '', '新田县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524099', '2013-07-30 15:39:14', '', '江华瑶族自治县', '2', '0', '4524087', '');
INSERT INTO `ezs_area` VALUES ('4524100', '2013-07-30 15:39:14', '', '怀化市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524101', '2013-07-30 15:39:14', '', '市辖区', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524102', '2013-07-30 15:39:14', '', '鹤城区', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524103', '2013-07-30 15:39:14', '', '中方县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524104', '2013-07-30 15:39:14', '', '沅陵县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524105', '2013-07-30 15:39:14', '', '辰溪县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524106', '2013-07-30 15:39:14', '', '溆浦县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524107', '2013-07-30 15:39:14', '', '会同县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524108', '2013-07-30 15:39:14', '', '麻阳苗族自治县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524109', '2013-07-30 15:39:14', '', '新晃侗族自治县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524110', '2013-07-30 15:39:14', '', '芷江侗族自治县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524111', '2013-07-30 15:39:15', '', '靖州苗族侗族自治县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524112', '2013-07-30 15:39:15', '', '通道侗族自治县', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524113', '2013-07-30 15:39:15', '', '洪江市', '2', '0', '4524100', '');
INSERT INTO `ezs_area` VALUES ('4524114', '2013-07-30 15:39:15', '', '娄底市', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524115', '2013-07-30 15:39:15', '', '市辖区', '2', '0', '4524114', '');
INSERT INTO `ezs_area` VALUES ('4524116', '2013-07-30 15:39:15', '', '娄星区', '2', '0', '4524114', '');
INSERT INTO `ezs_area` VALUES ('4524117', '2013-07-30 15:39:15', '', '双峰县', '2', '0', '4524114', '');
INSERT INTO `ezs_area` VALUES ('4524118', '2013-07-30 15:39:15', '', '新化县', '2', '0', '4524114', '');
INSERT INTO `ezs_area` VALUES ('4524119', '2013-07-30 15:39:15', '', '冷水江市', '2', '0', '4524114', '');
INSERT INTO `ezs_area` VALUES ('4524120', '2013-07-30 15:39:15', '', '涟源市', '2', '0', '4524114', '');
INSERT INTO `ezs_area` VALUES ('4524121', '2013-07-30 15:39:15', '', '湘西土家族苗族自治州', '1', '0', '4523980', '');
INSERT INTO `ezs_area` VALUES ('4524122', '2013-07-30 15:39:15', '', '吉首市', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524123', '2013-07-30 15:39:15', '', '泸溪县', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524124', '2013-07-30 15:39:16', '', '凤凰县', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524125', '2013-07-30 15:39:16', '', '花垣县', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524126', '2013-07-30 15:39:16', '', '保靖县', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524127', '2013-07-30 15:39:16', '', '古丈县', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524128', '2013-07-30 15:39:16', '', '永顺县', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524129', '2013-07-30 15:39:16', '', '龙山县', '2', '0', '4524121', '');
INSERT INTO `ezs_area` VALUES ('4524130', '2013-07-30 15:39:16', '', '广东省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524131', '2013-07-30 15:39:16', '', '广州市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524132', '2013-07-30 15:39:16', '', '市辖区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524133', '2013-07-30 15:39:16', '', '荔湾区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524134', '2013-07-30 15:39:16', '', '越秀区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524135', '2013-07-30 15:39:16', '', '海珠区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524136', '2013-07-30 15:39:16', '', '天河区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524137', '2013-07-30 15:39:17', '', '白云区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524138', '2013-07-30 15:39:17', '', '黄埔区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524139', '2013-07-30 15:39:17', '', '番禺区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524140', '2013-07-30 15:39:17', '', '花都区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524141', '2013-07-30 15:39:17', '', '南沙区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524142', '2013-07-30 15:39:17', '', '萝岗区', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524143', '2013-07-30 15:39:17', '', '增城市', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524144', '2013-07-30 15:39:17', '', '从化市', '2', '0', '4524131', '');
INSERT INTO `ezs_area` VALUES ('4524145', '2013-07-30 15:39:17', '', '韶关市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524146', '2013-07-30 15:39:17', '', '市辖区', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524147', '2013-07-30 15:39:17', '', '武江区', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524148', '2013-07-30 15:39:17', '', '浈江区', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524149', '2013-07-30 15:39:17', '', '曲江区', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524150', '2013-07-30 15:39:17', '', '始兴县', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524151', '2013-07-30 15:39:18', '', '仁化县', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524152', '2013-07-30 15:39:18', '', '翁源县', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524153', '2013-07-30 15:39:18', '', '乳源瑶族自治县', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524154', '2013-07-30 15:39:18', '', '新丰县', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524155', '2013-07-30 15:39:18', '', '乐昌市', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524156', '2013-07-30 15:39:18', '', '南雄市', '2', '0', '4524145', '');
INSERT INTO `ezs_area` VALUES ('4524157', '2013-07-30 15:39:18', '', '深圳市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524158', '2013-07-30 15:39:18', '', '市辖区', '2', '0', '4524157', '');
INSERT INTO `ezs_area` VALUES ('4524159', '2013-07-30 15:39:18', '', '罗湖区', '2', '0', '4524157', '');
INSERT INTO `ezs_area` VALUES ('4524160', '2013-07-30 15:39:18', '', '福田区', '2', '0', '4524157', '');
INSERT INTO `ezs_area` VALUES ('4524161', '2013-07-30 15:39:18', '', '南山区', '2', '0', '4524157', '');
INSERT INTO `ezs_area` VALUES ('4524162', '2013-07-30 15:39:18', '', '宝安区', '2', '0', '4524157', '');
INSERT INTO `ezs_area` VALUES ('4524163', '2013-07-30 15:39:18', '', '龙岗区', '2', '0', '4524157', '');
INSERT INTO `ezs_area` VALUES ('4524164', '2013-07-30 15:39:19', '', '盐田区', '2', '0', '4524157', '');
INSERT INTO `ezs_area` VALUES ('4524165', '2013-07-30 15:39:19', '', '珠海市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524166', '2013-07-30 15:39:19', '', '市辖区', '2', '0', '4524165', '');
INSERT INTO `ezs_area` VALUES ('4524167', '2013-07-30 15:39:19', '', '香洲区', '2', '0', '4524165', '');
INSERT INTO `ezs_area` VALUES ('4524168', '2013-07-30 15:39:19', '', '斗门区', '2', '0', '4524165', '');
INSERT INTO `ezs_area` VALUES ('4524169', '2013-07-30 15:39:19', '', '金湾区', '2', '0', '4524165', '');
INSERT INTO `ezs_area` VALUES ('4524170', '2013-07-30 15:39:19', '', '汕头市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524171', '2013-07-30 15:39:19', '', '市辖区', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524172', '2013-07-30 15:39:19', '', '龙湖区', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524173', '2013-07-30 15:39:19', '', '金平区', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524174', '2013-07-30 15:39:19', '', '濠江区', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524175', '2013-07-30 15:39:20', '', '潮阳区', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524176', '2013-07-30 15:39:20', '', '潮南区', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524177', '2013-07-30 15:39:20', '', '澄海区', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524178', '2013-07-30 15:39:20', '', '南澳县', '2', '0', '4524170', '');
INSERT INTO `ezs_area` VALUES ('4524179', '2013-07-30 15:39:20', '', '佛山市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524180', '2013-07-30 15:39:20', '', '市辖区', '2', '0', '4524179', '');
INSERT INTO `ezs_area` VALUES ('4524181', '2013-07-30 15:39:20', '', '禅城区', '2', '0', '4524179', '');
INSERT INTO `ezs_area` VALUES ('4524182', '2013-07-30 15:39:20', '', '南海区', '2', '0', '4524179', '');
INSERT INTO `ezs_area` VALUES ('4524183', '2013-07-30 15:39:20', '', '顺德区', '2', '0', '4524179', '');
INSERT INTO `ezs_area` VALUES ('4524184', '2013-07-30 15:39:20', '', '三水区', '2', '0', '4524179', '');
INSERT INTO `ezs_area` VALUES ('4524185', '2013-07-30 15:39:20', '', '高明区', '2', '0', '4524179', '');
INSERT INTO `ezs_area` VALUES ('4524186', '2013-07-30 15:39:20', '', '江门市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524187', '2013-07-30 15:39:20', '', '市辖区', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524188', '2013-07-30 15:39:21', '', '蓬江区', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524189', '2013-07-30 15:39:21', '', '江海区', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524190', '2013-07-30 15:39:21', '', '新会区', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524191', '2013-07-30 15:39:21', '', '台山市', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524192', '2013-07-30 15:39:21', '', '开平市', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524193', '2013-07-30 15:39:21', '', '鹤山市', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524194', '2013-07-30 15:39:21', '', '恩平市', '2', '0', '4524186', '');
INSERT INTO `ezs_area` VALUES ('4524195', '2013-07-30 15:39:21', '', '湛江市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524196', '2013-07-30 15:39:21', '', '市辖区', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524197', '2013-07-30 15:39:21', '', '赤坎区', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524198', '2013-07-30 15:39:21', '', '霞山区', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524199', '2013-07-30 15:39:21', '', '坡头区', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524200', '2013-07-30 15:39:21', '', '麻章区', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524201', '2013-07-30 15:39:21', '', '遂溪县', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524202', '2013-07-30 15:39:22', '', '徐闻县', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524203', '2013-07-30 15:39:22', '', '廉江市', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524204', '2013-07-30 15:39:22', '', '雷州市', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524205', '2013-07-30 15:39:22', '', '吴川市', '2', '0', '4524195', '');
INSERT INTO `ezs_area` VALUES ('4524206', '2013-07-30 15:39:22', '', '茂名市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524207', '2013-07-30 15:39:22', '', '市辖区', '2', '0', '4524206', '');
INSERT INTO `ezs_area` VALUES ('4524208', '2013-07-30 15:39:22', '', '茂南区', '2', '0', '4524206', '');
INSERT INTO `ezs_area` VALUES ('4524209', '2013-07-30 15:39:22', '', '茂港区', '2', '0', '4524206', '');
INSERT INTO `ezs_area` VALUES ('4524210', '2013-07-30 15:39:22', '', '电白县', '2', '0', '4524206', '');
INSERT INTO `ezs_area` VALUES ('4524211', '2013-07-30 15:39:22', '', '高州市', '2', '0', '4524206', '');
INSERT INTO `ezs_area` VALUES ('4524212', '2013-07-30 15:39:22', '', '化州市', '2', '0', '4524206', '');
INSERT INTO `ezs_area` VALUES ('4524213', '2013-07-30 15:39:22', '', '信宜市', '2', '0', '4524206', '');
INSERT INTO `ezs_area` VALUES ('4524214', '2013-07-30 15:39:22', '', '肇庆市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524215', '2013-07-30 15:39:22', '', '市辖区', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524216', '2013-07-30 15:39:22', '', '端州区', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524217', '2013-07-30 15:39:23', '', '鼎湖区', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524218', '2013-07-30 15:39:23', '', '广宁县', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524219', '2013-07-30 15:39:23', '', '怀集县', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524220', '2013-07-30 15:39:23', '', '封开县', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524221', '2013-07-30 15:39:23', '', '德庆县', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524222', '2013-07-30 15:39:23', '', '高要市', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524223', '2013-07-30 15:39:23', '', '四会市', '2', '0', '4524214', '');
INSERT INTO `ezs_area` VALUES ('4524224', '2013-07-30 15:39:23', '', '惠州市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524225', '2013-07-30 15:39:23', '', '市辖区', '2', '0', '4524224', '');
INSERT INTO `ezs_area` VALUES ('4524226', '2013-07-30 15:39:23', '', '惠城区', '2', '0', '4524224', '');
INSERT INTO `ezs_area` VALUES ('4524227', '2013-07-30 15:39:23', '', '惠阳区', '2', '0', '4524224', '');
INSERT INTO `ezs_area` VALUES ('4524228', '2013-07-30 15:39:23', '', '博罗县', '2', '0', '4524224', '');
INSERT INTO `ezs_area` VALUES ('4524229', '2013-07-30 15:39:24', '', '惠东县', '2', '0', '4524224', '');
INSERT INTO `ezs_area` VALUES ('4524230', '2013-07-30 15:39:24', '', '龙门县', '2', '0', '4524224', '');
INSERT INTO `ezs_area` VALUES ('4524231', '2013-07-30 15:39:24', '', '梅州市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524232', '2013-07-30 15:39:24', '', '市辖区', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524233', '2013-07-30 15:39:24', '', '梅江区', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524234', '2013-07-30 15:39:24', '', '梅县', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524235', '2013-07-30 15:39:24', '', '大埔县', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524236', '2013-07-30 15:39:24', '', '丰顺县', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524237', '2013-07-30 15:39:24', '', '五华县', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524238', '2013-07-30 15:39:24', '', '平远县', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524239', '2013-07-30 15:39:24', '', '蕉岭县', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524240', '2013-07-30 15:39:24', '', '兴宁市', '2', '0', '4524231', '');
INSERT INTO `ezs_area` VALUES ('4524241', '2013-07-30 15:39:24', '', '汕尾市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524242', '2013-07-30 15:39:24', '', '市辖区', '2', '0', '4524241', '');
INSERT INTO `ezs_area` VALUES ('4524243', '2013-07-30 15:39:25', '', '城区', '2', '0', '4524241', '');
INSERT INTO `ezs_area` VALUES ('4524244', '2013-07-30 15:39:25', '', '海丰县', '2', '0', '4524241', '');
INSERT INTO `ezs_area` VALUES ('4524245', '2013-07-30 15:39:25', '', '陆河县', '2', '0', '4524241', '');
INSERT INTO `ezs_area` VALUES ('4524246', '2013-07-30 15:39:25', '', '陆丰市', '2', '0', '4524241', '');
INSERT INTO `ezs_area` VALUES ('4524247', '2013-07-30 15:39:25', '', '河源市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524248', '2013-07-30 15:39:25', '', '市辖区', '2', '0', '4524247', '');
INSERT INTO `ezs_area` VALUES ('4524249', '2013-07-30 15:39:25', '', '源城区', '2', '0', '4524247', '');
INSERT INTO `ezs_area` VALUES ('4524250', '2013-07-30 15:39:25', '', '紫金县', '2', '0', '4524247', '');
INSERT INTO `ezs_area` VALUES ('4524251', '2013-07-30 15:39:25', '', '龙川县', '2', '0', '4524247', '');
INSERT INTO `ezs_area` VALUES ('4524252', '2013-07-30 15:39:25', '', '连平县', '2', '0', '4524247', '');
INSERT INTO `ezs_area` VALUES ('4524253', '2013-07-30 15:39:25', '', '和平县', '2', '0', '4524247', '');
INSERT INTO `ezs_area` VALUES ('4524254', '2013-07-30 15:39:25', '', '东源县', '2', '0', '4524247', '');
INSERT INTO `ezs_area` VALUES ('4524255', '2013-07-30 15:39:26', '', '阳江市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524256', '2013-07-30 15:39:26', '', '市辖区', '2', '0', '4524255', '');
INSERT INTO `ezs_area` VALUES ('4524257', '2013-07-30 15:39:26', '', '江城区', '2', '0', '4524255', '');
INSERT INTO `ezs_area` VALUES ('4524258', '2013-07-30 15:39:26', '', '阳西县', '2', '0', '4524255', '');
INSERT INTO `ezs_area` VALUES ('4524259', '2013-07-30 15:39:26', '', '阳东县', '2', '0', '4524255', '');
INSERT INTO `ezs_area` VALUES ('4524260', '2013-07-30 15:39:26', '', '阳春市', '2', '0', '4524255', '');
INSERT INTO `ezs_area` VALUES ('4524261', '2013-07-30 15:39:26', '', '清远市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524262', '2013-07-30 15:39:26', '', '市辖区', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524263', '2013-07-30 15:39:26', '', '清城区', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524264', '2013-07-30 15:39:26', '', '佛冈县', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524265', '2013-07-30 15:39:26', '', '阳山县', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524266', '2013-07-30 15:39:26', '', '连山壮族瑶族自治县', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524267', '2013-07-30 15:39:27', '', '连南瑶族自治县', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524268', '2013-07-30 15:39:27', '', '清新县', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524269', '2013-07-30 15:39:27', '', '英德市', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524270', '2013-07-30 15:39:27', '', '连州市', '2', '0', '4524261', '');
INSERT INTO `ezs_area` VALUES ('4524271', '2013-07-30 15:39:27', '', '东莞市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524272', '2013-07-30 15:39:27', '', '中山市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524273', '2013-07-30 15:39:27', '', '潮州市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524274', '2013-07-30 15:39:27', '', '市辖区', '2', '0', '4524273', '');
INSERT INTO `ezs_area` VALUES ('4524275', '2013-07-30 15:39:27', '', '湘桥区', '2', '0', '4524273', '');
INSERT INTO `ezs_area` VALUES ('4524276', '2013-07-30 15:39:27', '', '潮安县', '2', '0', '4524273', '');
INSERT INTO `ezs_area` VALUES ('4524277', '2013-07-30 15:39:27', '', '饶平县', '2', '0', '4524273', '');
INSERT INTO `ezs_area` VALUES ('4524278', '2013-07-30 15:39:27', '', '揭阳市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524279', '2013-07-30 15:39:28', '', '市辖区', '2', '0', '4524278', '');
INSERT INTO `ezs_area` VALUES ('4524280', '2013-07-30 15:39:28', '', '榕城区', '2', '0', '4524278', '');
INSERT INTO `ezs_area` VALUES ('4524281', '2013-07-30 15:39:28', '', '揭东县', '2', '0', '4524278', '');
INSERT INTO `ezs_area` VALUES ('4524282', '2013-07-30 15:39:28', '', '揭西县', '2', '0', '4524278', '');
INSERT INTO `ezs_area` VALUES ('4524283', '2013-07-30 15:39:28', '', '惠来县', '2', '0', '4524278', '');
INSERT INTO `ezs_area` VALUES ('4524284', '2013-07-30 15:39:28', '', '普宁市', '2', '0', '4524278', '');
INSERT INTO `ezs_area` VALUES ('4524285', '2013-07-30 15:39:28', '', '云浮市', '1', '0', '4524130', '');
INSERT INTO `ezs_area` VALUES ('4524286', '2013-07-30 15:39:28', '', '市辖区', '2', '0', '4524285', '');
INSERT INTO `ezs_area` VALUES ('4524287', '2013-07-30 15:39:28', '', '云城区', '2', '0', '4524285', '');
INSERT INTO `ezs_area` VALUES ('4524288', '2013-07-30 15:39:28', '', '新兴县', '2', '0', '4524285', '');
INSERT INTO `ezs_area` VALUES ('4524289', '2013-07-30 15:39:28', '', '郁南县', '2', '0', '4524285', '');
INSERT INTO `ezs_area` VALUES ('4524290', '2013-07-30 15:39:28', '', '云安县', '2', '0', '4524285', '');
INSERT INTO `ezs_area` VALUES ('4524291', '2013-07-30 15:39:28', '', '罗定市', '2', '0', '4524285', '');
INSERT INTO `ezs_area` VALUES ('4524292', '2013-07-30 15:39:29', '', '广西壮族自治区', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524293', '2013-07-30 15:39:29', '', '南宁市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524294', '2013-07-30 15:39:29', '', '市辖区', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524295', '2013-07-30 15:39:29', '', '兴宁区', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524296', '2013-07-30 15:39:29', '', '青秀区', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524297', '2013-07-30 15:39:29', '', '江南区', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524298', '2013-07-30 15:39:29', '', '西乡塘区', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524299', '2013-07-30 15:39:29', '', '良庆区', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524300', '2013-07-30 15:39:29', '', '邕宁区', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524301', '2013-07-30 15:39:29', '', '武鸣县', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524302', '2013-07-30 15:39:29', '', '隆安县', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524303', '2013-07-30 15:39:29', '', '马山县', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524304', '2013-07-30 15:39:30', '', '上林县', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524305', '2013-07-30 15:39:30', '', '宾阳县', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524306', '2013-07-30 15:39:30', '', '横县', '2', '0', '4524293', '');
INSERT INTO `ezs_area` VALUES ('4524307', '2013-07-30 15:39:30', '', '柳州市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524308', '2013-07-30 15:39:30', '', '市辖区', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524309', '2013-07-30 15:39:30', '', '城中区', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524310', '2013-07-30 15:39:30', '', '鱼峰区', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524311', '2013-07-30 15:39:30', '', '柳南区', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524312', '2013-07-30 15:39:30', '', '柳北区', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524313', '2013-07-30 15:39:30', '', '柳江县', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524314', '2013-07-30 15:39:30', '', '柳城县', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524315', '2013-07-30 15:39:30', '', '鹿寨县', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524316', '2013-07-30 15:39:30', '', '融安县', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524317', '2013-07-30 15:39:30', '', '融水苗族自治县', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524318', '2013-07-30 15:39:31', '', '三江侗族自治县', '2', '0', '4524307', '');
INSERT INTO `ezs_area` VALUES ('4524319', '2013-07-30 15:39:31', '', '桂林市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524320', '2013-07-30 15:39:31', '', '市辖区', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524321', '2013-07-30 15:39:31', '', '秀峰区', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524322', '2013-07-30 15:39:31', '', '叠彩区', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524323', '2013-07-30 15:39:31', '', '象山区', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524324', '2013-07-30 15:39:31', '', '七星区', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524325', '2013-07-30 15:39:31', '', '雁山区', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524326', '2013-07-30 15:39:31', '', '阳朔县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524327', '2013-07-30 15:39:31', '', '临桂县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524328', '2013-07-30 15:39:31', '', '灵川县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524329', '2013-07-30 15:39:31', '', '全州县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524330', '2013-07-30 15:39:31', '', '兴安县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524331', '2013-07-30 15:39:32', '', '永福县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524332', '2013-07-30 15:39:32', '', '灌阳县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524333', '2013-07-30 15:39:32', '', '龙胜各族自治县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524334', '2013-07-30 15:39:32', '', '资源县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524335', '2013-07-30 15:39:32', '', '平乐县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524336', '2013-07-30 15:39:32', '', '荔蒲县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524337', '2013-07-30 15:39:32', '', '恭城瑶族自治县', '2', '0', '4524319', '');
INSERT INTO `ezs_area` VALUES ('4524338', '2013-07-30 15:39:32', '', '梧州市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524339', '2013-07-30 15:39:32', '', '市辖区', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524340', '2013-07-30 15:39:32', '', '万秀区', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524341', '2013-07-30 15:39:32', '', '蝶山区', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524342', '2013-07-30 15:39:32', '', '长洲区', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524343', '2013-07-30 15:39:33', '', '苍梧县', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524344', '2013-07-30 15:39:33', '', '藤县', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524345', '2013-07-30 15:39:33', '', '蒙山县', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524346', '2013-07-30 15:39:33', '', '岑溪市', '2', '0', '4524338', '');
INSERT INTO `ezs_area` VALUES ('4524347', '2013-07-30 15:39:33', '', '北海市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524348', '2013-07-30 15:39:33', '', '市辖区', '2', '0', '4524347', '');
INSERT INTO `ezs_area` VALUES ('4524349', '2013-07-30 15:39:33', '', '海城区', '2', '0', '4524347', '');
INSERT INTO `ezs_area` VALUES ('4524350', '2013-07-30 15:39:33', '', '银海区', '2', '0', '4524347', '');
INSERT INTO `ezs_area` VALUES ('4524351', '2013-07-30 15:39:33', '', '铁山港区', '2', '0', '4524347', '');
INSERT INTO `ezs_area` VALUES ('4524352', '2013-07-30 15:39:33', '', '合浦县', '2', '0', '4524347', '');
INSERT INTO `ezs_area` VALUES ('4524353', '2013-07-30 15:39:33', '', '防城港市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524354', '2013-07-30 15:39:34', '', '市辖区', '2', '0', '4524353', '');
INSERT INTO `ezs_area` VALUES ('4524355', '2013-07-30 15:39:34', '', '港口区', '2', '0', '4524353', '');
INSERT INTO `ezs_area` VALUES ('4524356', '2013-07-30 15:39:34', '', '防城区', '2', '0', '4524353', '');
INSERT INTO `ezs_area` VALUES ('4524357', '2013-07-30 15:39:34', '', '上思县', '2', '0', '4524353', '');
INSERT INTO `ezs_area` VALUES ('4524358', '2013-07-30 15:39:34', '', '东兴市', '2', '0', '4524353', '');
INSERT INTO `ezs_area` VALUES ('4524359', '2013-07-30 15:39:34', '', '钦州市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524360', '2013-07-30 15:39:34', '', '市辖区', '2', '0', '4524359', '');
INSERT INTO `ezs_area` VALUES ('4524361', '2013-07-30 15:39:34', '', '钦南区', '2', '0', '4524359', '');
INSERT INTO `ezs_area` VALUES ('4524362', '2013-07-30 15:39:34', '', '钦北区', '2', '0', '4524359', '');
INSERT INTO `ezs_area` VALUES ('4524363', '2013-07-30 15:39:34', '', '灵山县', '2', '0', '4524359', '');
INSERT INTO `ezs_area` VALUES ('4524364', '2013-07-30 15:39:34', '', '浦北县', '2', '0', '4524359', '');
INSERT INTO `ezs_area` VALUES ('4524365', '2013-07-30 15:39:34', '', '贵港市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524366', '2013-07-30 15:39:34', '', '市辖区', '2', '0', '4524365', '');
INSERT INTO `ezs_area` VALUES ('4524367', '2013-07-30 15:39:35', '', '港北区', '2', '0', '4524365', '');
INSERT INTO `ezs_area` VALUES ('4524368', '2013-07-30 15:39:35', '', '港南区', '2', '0', '4524365', '');
INSERT INTO `ezs_area` VALUES ('4524369', '2013-07-30 15:39:35', '', '覃塘区', '2', '0', '4524365', '');
INSERT INTO `ezs_area` VALUES ('4524370', '2013-07-30 15:39:35', '', '平南县', '2', '0', '4524365', '');
INSERT INTO `ezs_area` VALUES ('4524371', '2013-07-30 15:39:35', '', '桂平市', '2', '0', '4524365', '');
INSERT INTO `ezs_area` VALUES ('4524372', '2013-07-30 15:39:35', '', '玉林市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524373', '2013-07-30 15:39:35', '', '市辖区', '2', '0', '4524372', '');
INSERT INTO `ezs_area` VALUES ('4524374', '2013-07-30 15:39:35', '', '玉州区', '2', '0', '4524372', '');
INSERT INTO `ezs_area` VALUES ('4524375', '2013-07-30 15:39:35', '', '容县', '2', '0', '4524372', '');
INSERT INTO `ezs_area` VALUES ('4524376', '2013-07-30 15:39:35', '', '陆川县', '2', '0', '4524372', '');
INSERT INTO `ezs_area` VALUES ('4524377', '2013-07-30 15:39:35', '', '博白县', '2', '0', '4524372', '');
INSERT INTO `ezs_area` VALUES ('4524378', '2013-07-30 15:39:35', '', '兴业县', '2', '0', '4524372', '');
INSERT INTO `ezs_area` VALUES ('4524379', '2013-07-30 15:39:35', '', '北流市', '2', '0', '4524372', '');
INSERT INTO `ezs_area` VALUES ('4524380', '2013-07-30 15:39:35', '', '百色市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524381', '2013-07-30 15:39:36', '', '市辖区', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524382', '2013-07-30 15:39:36', '', '右江区', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524383', '2013-07-30 15:39:36', '', '田阳县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524384', '2013-07-30 15:39:36', '', '田东县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524385', '2013-07-30 15:39:36', '', '平果县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524386', '2013-07-30 15:39:36', '', '德保县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524387', '2013-07-30 15:39:36', '', '靖西县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524388', '2013-07-30 15:39:36', '', '那坡县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524389', '2013-07-30 15:39:36', '', '凌云县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524390', '2013-07-30 15:39:36', '', '乐业县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524391', '2013-07-30 15:39:36', '', '田林县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524392', '2013-07-30 15:39:36', '', '西林县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524393', '2013-07-30 15:39:36', '', '隆林各族自治县', '2', '0', '4524380', '');
INSERT INTO `ezs_area` VALUES ('4524394', '2013-07-30 15:39:37', '', '贺州市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524395', '2013-07-30 15:39:37', '', '市辖区', '2', '0', '4524394', '');
INSERT INTO `ezs_area` VALUES ('4524396', '2013-07-30 15:39:37', '', '八步区', '2', '0', '4524394', '');
INSERT INTO `ezs_area` VALUES ('4524397', '2013-07-30 15:39:37', '', '平桂管理区', '2', '0', '4524394', '');
INSERT INTO `ezs_area` VALUES ('4524398', '2013-07-30 15:39:37', '', '昭平县', '2', '0', '4524394', '');
INSERT INTO `ezs_area` VALUES ('4524399', '2013-07-30 15:39:37', '', '钟山县', '2', '0', '4524394', '');
INSERT INTO `ezs_area` VALUES ('4524400', '2013-07-30 15:39:37', '', '富川瑶族自治县', '2', '0', '4524394', '');
INSERT INTO `ezs_area` VALUES ('4524401', '2013-07-30 15:39:37', '', '河池市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524402', '2013-07-30 15:39:37', '', '市辖区', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524403', '2013-07-30 15:39:37', '', '金城江区', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524404', '2013-07-30 15:39:37', '', '南丹县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524405', '2013-07-30 15:39:37', '', '天峨县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524406', '2013-07-30 15:39:37', '', '凤山县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524407', '2013-07-30 15:39:38', '', '东兰县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524408', '2013-07-30 15:39:38', '', '罗城仫佬族自治县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524409', '2013-07-30 15:39:38', '', '环江毛南族自治县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524410', '2013-07-30 15:39:38', '', '巴马瑶族自治县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524411', '2013-07-30 15:39:38', '', '都安瑶族自治县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524412', '2013-07-30 15:39:38', '', '大化瑶族自治县', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524413', '2013-07-30 15:39:38', '', '宜州市', '2', '0', '4524401', '');
INSERT INTO `ezs_area` VALUES ('4524414', '2013-07-30 15:39:38', '', '来宾市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524415', '2013-07-30 15:39:38', '', '市辖区', '2', '0', '4524414', '');
INSERT INTO `ezs_area` VALUES ('4524416', '2013-07-30 15:39:38', '', '兴宾区', '2', '0', '4524414', '');
INSERT INTO `ezs_area` VALUES ('4524417', '2013-07-30 15:39:38', '', '忻城县', '2', '0', '4524414', '');
INSERT INTO `ezs_area` VALUES ('4524418', '2013-07-30 15:39:38', '', '象州县', '2', '0', '4524414', '');
INSERT INTO `ezs_area` VALUES ('4524419', '2013-07-30 15:39:38', '', '武宣县', '2', '0', '4524414', '');
INSERT INTO `ezs_area` VALUES ('4524420', '2013-07-30 15:39:39', '', '金秀瑶族自治县', '2', '0', '4524414', '');
INSERT INTO `ezs_area` VALUES ('4524421', '2013-07-30 15:39:39', '', '合山市', '2', '0', '4524414', '');
INSERT INTO `ezs_area` VALUES ('4524422', '2013-07-30 15:39:39', '', '崇左市', '1', '0', '4524292', '');
INSERT INTO `ezs_area` VALUES ('4524423', '2013-07-30 15:39:39', '', '市辖区', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524424', '2013-07-30 15:39:39', '', '江洲区', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524425', '2013-07-30 15:39:39', '', '扶绥县', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524426', '2013-07-30 15:39:39', '', '宁明县', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524427', '2013-07-30 15:39:39', '', '龙州县', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524428', '2013-07-30 15:39:39', '', '大新县', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524429', '2013-07-30 15:39:39', '', '天等县', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524430', '2013-07-30 15:39:39', '', '凭祥市', '2', '0', '4524422', '');
INSERT INTO `ezs_area` VALUES ('4524431', '2013-07-30 15:39:39', '', '海南省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524432', '2013-07-30 15:39:39', '', '海口市', '1', '0', '4524431', '');
INSERT INTO `ezs_area` VALUES ('4524433', '2013-07-30 15:39:40', '', '市辖区', '2', '0', '4524432', '');
INSERT INTO `ezs_area` VALUES ('4524434', '2013-07-30 15:39:40', '', '秀英区', '2', '0', '4524432', '');
INSERT INTO `ezs_area` VALUES ('4524435', '2013-07-30 15:39:40', '', '龙华区', '2', '0', '4524432', '');
INSERT INTO `ezs_area` VALUES ('4524436', '2013-07-30 15:39:40', '', '琼山区', '2', '0', '4524432', '');
INSERT INTO `ezs_area` VALUES ('4524437', '2013-07-30 15:39:40', '', '美兰区', '2', '0', '4524432', '');
INSERT INTO `ezs_area` VALUES ('4524438', '2013-07-30 15:39:40', '', '三亚市', '1', '0', '4524431', '');
INSERT INTO `ezs_area` VALUES ('4524439', '2013-07-30 15:39:40', '', '市辖区', '2', '0', '4524438', '');
INSERT INTO `ezs_area` VALUES ('4524440', '2013-07-30 15:39:40', '', '省直辖县级行政区划', '1', '0', '4524431', '');
INSERT INTO `ezs_area` VALUES ('4524441', '2013-07-30 15:39:40', '', '五指山市', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524442', '2013-07-30 15:39:40', '', '琼海市', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524443', '2013-07-30 15:39:40', '', '儋州市', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524444', '2013-07-30 15:39:40', '', '文昌市', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524445', '2013-07-30 15:39:40', '', '万宁市', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524446', '2013-07-30 15:39:41', '', '东方市', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524447', '2013-07-30 15:39:41', '', '定安县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524448', '2013-07-30 15:39:41', '', '屯昌县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524449', '2013-07-30 15:39:41', '', '澄迈县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524450', '2013-07-30 15:39:41', '', '临高县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524451', '2013-07-30 15:39:41', '', '白沙黎族自治县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524452', '2013-07-30 15:39:41', '', '昌江黎族自治县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524453', '2013-07-30 15:39:41', '', '乐东黎族自治县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524454', '2013-07-30 15:39:41', '', '陵水黎族自治县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524455', '2013-07-30 15:39:41', '', '保亭黎族苗族自治县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524456', '2013-07-30 15:39:41', '', '琼中黎族苗族自治县', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524457', '2013-07-30 15:39:41', '', '西沙群岛', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524458', '2013-07-30 15:39:41', '', '南沙群岛', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524459', '2013-07-30 15:39:42', '', '中沙群岛的岛礁及其海域', '2', '0', '4524440', '');
INSERT INTO `ezs_area` VALUES ('4524460', '2013-07-30 15:39:42', '', '重庆市', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524461', '2013-07-30 15:39:42', '', '重庆市', '1', '0', '4524460', '');
INSERT INTO `ezs_area` VALUES ('4524462', '2013-07-30 15:39:42', '', '万州区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524463', '2013-07-30 15:39:42', '', '涪陵区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524464', '2013-07-30 15:39:42', '', '渝中区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524465', '2013-07-30 15:39:42', '', '大渡口区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524466', '2013-07-30 15:39:42', '', '江北区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524467', '2013-07-30 15:39:42', '', '沙坪坝区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524468', '2013-07-30 15:39:42', '', '九龙坡区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524469', '2013-07-30 15:39:42', '', '南岸区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524470', '2013-07-30 15:39:42', '', '北碚区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524471', '2013-07-30 15:39:43', '', '万盛区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524472', '2013-07-30 15:39:43', '', '双桥区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524473', '2013-07-30 15:39:43', '', '渝北区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524474', '2013-07-30 15:39:43', '', '巴南区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524475', '2013-07-30 15:39:43', '', '黔江区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524476', '2013-07-30 15:39:43', '', '长寿区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524477', '2013-07-30 15:39:43', '', '江津区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524478', '2013-07-30 15:39:43', '', '合川区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524479', '2013-07-30 15:39:43', '', '永川区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524480', '2013-07-30 15:39:43', '', '南川区', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524482', '2013-07-30 15:39:43', '', '綦江县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524483', '2013-07-30 15:39:44', '', '潼南县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524484', '2013-07-30 15:39:44', '', '铜梁县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524485', '2013-07-30 15:39:44', '', '大足县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524486', '2013-07-30 15:39:44', '', '荣昌县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524487', '2013-07-30 15:39:44', '', '璧山县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524488', '2013-07-30 15:39:44', '', '梁平县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524489', '2013-07-30 15:39:44', '', '城口县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524490', '2013-07-30 15:39:44', '', '丰都县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524491', '2013-07-30 15:39:44', '', '垫江县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524492', '2013-07-30 15:39:44', '', '武隆县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524493', '2013-07-30 15:39:44', '', '忠县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524494', '2013-07-30 15:39:44', '', '开县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524495', '2013-07-30 15:39:44', '', '云阳县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524496', '2013-07-30 15:39:45', '', '奉节县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524497', '2013-07-30 15:39:45', '', '巫山县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524498', '2013-07-30 15:39:45', '', '巫溪县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524499', '2013-07-30 15:39:45', '', '石柱土家族自治县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524500', '2013-07-30 15:39:45', '', '秀山土家族苗族自治县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524501', '2013-07-30 15:39:45', '', '酉阳土家族苗族自治县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524502', '2013-07-30 15:39:45', '', '彭水苗族土家族自治县', '2', '0', '4524461', '');
INSERT INTO `ezs_area` VALUES ('4524503', '2013-07-30 15:39:45', '', '四川省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524504', '2013-07-30 15:39:45', '', '成都市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524505', '2013-07-30 15:39:45', '', '市辖区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524506', '2013-07-30 15:39:45', '', '锦江区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524507', '2013-07-30 15:39:45', '', '青羊区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524508', '2013-07-30 15:39:45', '', '金牛区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524509', '2013-07-30 15:39:46', '', '武侯区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524510', '2013-07-30 15:39:46', '', '成华区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524511', '2013-07-30 15:39:46', '', '龙泉驿区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524512', '2013-07-30 15:39:46', '', '青白江区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524513', '2013-07-30 15:39:46', '', '新都区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524514', '2013-07-30 15:39:46', '', '温江区', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524515', '2013-07-30 15:39:46', '', '金堂县', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524516', '2013-07-30 15:39:46', '', '双流县', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524517', '2013-07-30 15:39:46', '', '郫县', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524518', '2013-07-30 15:39:46', '', '大邑县', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524519', '2013-07-30 15:39:46', '', '蒲江县', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524520', '2013-07-30 15:39:46', '', '新津县', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524521', '2013-07-30 15:39:47', '', '都江堰市', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524522', '2013-07-30 15:39:47', '', '彭州市', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524523', '2013-07-30 15:39:47', '', '邛崃市', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524524', '2013-07-30 15:39:47', '', '崇州市', '2', '0', '4524504', '');
INSERT INTO `ezs_area` VALUES ('4524525', '2013-07-30 15:39:47', '', '自贡市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524526', '2013-07-30 15:39:47', '', '市辖区', '2', '0', '4524525', '');
INSERT INTO `ezs_area` VALUES ('4524527', '2013-07-30 15:39:47', '', '自流井区', '2', '0', '4524525', '');
INSERT INTO `ezs_area` VALUES ('4524528', '2013-07-30 15:39:47', '', '贡井区', '2', '0', '4524525', '');
INSERT INTO `ezs_area` VALUES ('4524529', '2013-07-30 15:39:47', '', '大安区', '2', '0', '4524525', '');
INSERT INTO `ezs_area` VALUES ('4524530', '2013-07-30 15:39:47', '', '沿滩区', '2', '0', '4524525', '');
INSERT INTO `ezs_area` VALUES ('4524531', '2013-07-30 15:39:47', '', '荣县', '2', '0', '4524525', '');
INSERT INTO `ezs_area` VALUES ('4524532', '2013-07-30 15:39:47', '', '富顺县', '2', '0', '4524525', '');
INSERT INTO `ezs_area` VALUES ('4524533', '2013-07-30 15:39:48', '', '攀枝花市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524534', '2013-07-30 15:39:48', '', '市辖区', '2', '0', '4524533', '');
INSERT INTO `ezs_area` VALUES ('4524535', '2013-07-30 15:39:48', '', '东区', '2', '0', '4524533', '');
INSERT INTO `ezs_area` VALUES ('4524536', '2013-07-30 15:39:48', '', '西区', '2', '0', '4524533', '');
INSERT INTO `ezs_area` VALUES ('4524537', '2013-07-30 15:39:48', '', '仁和区', '2', '0', '4524533', '');
INSERT INTO `ezs_area` VALUES ('4524538', '2013-07-30 15:39:48', '', '米易县', '2', '0', '4524533', '');
INSERT INTO `ezs_area` VALUES ('4524539', '2013-07-30 15:39:48', '', '盐边县', '2', '0', '4524533', '');
INSERT INTO `ezs_area` VALUES ('4524540', '2013-07-30 15:39:48', '', '泸州市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524541', '2013-07-30 15:39:48', '', '市辖区', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524542', '2013-07-30 15:39:48', '', '江阳区', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524543', '2013-07-30 15:39:48', '', '纳溪区', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524544', '2013-07-30 15:39:48', '', '龙马潭区', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524545', '2013-07-30 15:39:48', '', '泸县', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524546', '2013-07-30 15:39:49', '', '合江县', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524547', '2013-07-30 15:39:49', '', '叙永县', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524548', '2013-07-30 15:39:49', '', '古蔺县', '2', '0', '4524540', '');
INSERT INTO `ezs_area` VALUES ('4524549', '2013-07-30 15:39:49', '', '德阳市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524550', '2013-07-30 15:39:49', '', '市辖区', '2', '0', '4524549', '');
INSERT INTO `ezs_area` VALUES ('4524551', '2013-07-30 15:39:49', '', '旌阳区', '2', '0', '4524549', '');
INSERT INTO `ezs_area` VALUES ('4524552', '2013-07-30 15:39:49', '', '中江县', '2', '0', '4524549', '');
INSERT INTO `ezs_area` VALUES ('4524553', '2013-07-30 15:39:49', '', '罗江县', '2', '0', '4524549', '');
INSERT INTO `ezs_area` VALUES ('4524554', '2013-07-30 15:39:49', '', '广汉市', '2', '0', '4524549', '');
INSERT INTO `ezs_area` VALUES ('4524555', '2013-07-30 15:39:49', '', '什邡市', '2', '0', '4524549', '');
INSERT INTO `ezs_area` VALUES ('4524556', '2013-07-30 15:39:49', '', '绵竹市', '2', '0', '4524549', '');
INSERT INTO `ezs_area` VALUES ('4524557', '2013-07-30 15:39:49', '', '绵阳市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524558', '2013-07-30 15:39:50', '', '市辖区', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524559', '2013-07-30 15:39:50', '', '涪城区', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524560', '2013-07-30 15:39:50', '', '游仙区', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524561', '2013-07-30 15:39:50', '', '三台县', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524562', '2013-07-30 15:39:50', '', '盐亭县', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524563', '2013-07-30 15:39:50', '', '安县', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524564', '2013-07-30 15:39:50', '', '梓潼县', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524565', '2013-07-30 15:39:50', '', '北川羌族自治县', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524566', '2013-07-30 15:39:50', '', '平武县', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524567', '2013-07-30 15:39:50', '', '江油市', '2', '0', '4524557', '');
INSERT INTO `ezs_area` VALUES ('4524568', '2013-07-30 15:39:50', '', '广元市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524569', '2013-07-30 15:39:50', '', '市辖区', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524570', '2013-07-30 15:39:50', '', '利州区', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524571', '2013-07-30 15:39:51', '', '元坝区', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524572', '2013-07-30 15:39:51', '', '朝天区', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524573', '2013-07-30 15:39:51', '', '旺苍县', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524574', '2013-07-30 15:39:51', '', '青川县', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524575', '2013-07-30 15:39:51', '', '剑阁县', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524576', '2013-07-30 15:39:51', '', '苍溪县', '2', '0', '4524568', '');
INSERT INTO `ezs_area` VALUES ('4524577', '2013-07-30 15:39:51', '', '遂宁市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524578', '2013-07-30 15:39:51', '', '市辖区', '2', '0', '4524577', '');
INSERT INTO `ezs_area` VALUES ('4524579', '2013-07-30 15:39:51', '', '船山区', '2', '0', '4524577', '');
INSERT INTO `ezs_area` VALUES ('4524580', '2013-07-30 15:39:51', '', '安居区', '2', '0', '4524577', '');
INSERT INTO `ezs_area` VALUES ('4524581', '2013-07-30 15:39:51', '', '蓬溪县', '2', '0', '4524577', '');
INSERT INTO `ezs_area` VALUES ('4524582', '2013-07-30 15:39:51', '', '射洪县', '2', '0', '4524577', '');
INSERT INTO `ezs_area` VALUES ('4524583', '2013-07-30 15:39:52', '', '大英县', '2', '0', '4524577', '');
INSERT INTO `ezs_area` VALUES ('4524584', '2013-07-30 15:39:52', '', '内江市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524585', '2013-07-30 15:39:52', '', '市辖区', '2', '0', '4524584', '');
INSERT INTO `ezs_area` VALUES ('4524586', '2013-07-30 15:39:52', '', '市中区', '2', '0', '4524584', '');
INSERT INTO `ezs_area` VALUES ('4524587', '2013-07-30 15:39:52', '', '东兴区', '2', '0', '4524584', '');
INSERT INTO `ezs_area` VALUES ('4524588', '2013-07-30 15:39:52', '', '威远县', '2', '0', '4524584', '');
INSERT INTO `ezs_area` VALUES ('4524589', '2013-07-30 15:39:52', '', '资中县', '2', '0', '4524584', '');
INSERT INTO `ezs_area` VALUES ('4524590', '2013-07-30 15:39:52', '', '隆昌县', '2', '0', '4524584', '');
INSERT INTO `ezs_area` VALUES ('4524591', '2013-07-30 15:39:52', '', '乐山市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524592', '2013-07-30 15:39:52', '', '市辖区', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524593', '2013-07-30 15:39:52', '', '市中区', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524594', '2013-07-30 15:39:52', '', '沙湾区', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524595', '2013-07-30 15:39:52', '', '五通桥区', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524596', '2013-07-30 15:39:53', '', '金口河区', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524597', '2013-07-30 15:39:53', '', '犍为县', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524598', '2013-07-30 15:39:53', '', '井研县', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524599', '2013-07-30 15:39:53', '', '夹江县', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524600', '2013-07-30 15:39:53', '', '沐川县', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524601', '2013-07-30 15:39:53', '', '峨边彝族自治县', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524602', '2013-07-30 15:39:53', '', '马边彝族自治县', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524603', '2013-07-30 15:39:53', '', '峨眉山市', '2', '0', '4524591', '');
INSERT INTO `ezs_area` VALUES ('4524604', '2013-07-30 15:39:53', '', '南充市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524605', '2013-07-30 15:39:54', '', '市辖区', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524606', '2013-07-30 15:39:54', '', '顺庆区', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524607', '2013-07-30 15:39:54', '', '高坪区', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524608', '2013-07-30 15:39:54', '', '嘉陵区', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524609', '2013-07-30 15:39:54', '', '南部县', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524610', '2013-07-30 15:39:54', '', '营山县', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524611', '2013-07-30 15:39:54', '', '蓬安县', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524612', '2013-07-30 15:39:54', '', '仪陇县', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524613', '2013-07-30 15:39:54', '', '西充县', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524614', '2013-07-30 15:39:54', '', '阆中市', '2', '0', '4524604', '');
INSERT INTO `ezs_area` VALUES ('4524615', '2013-07-30 15:39:54', '', '眉山市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524616', '2013-07-30 15:39:54', '', '市辖区', '2', '0', '4524615', '');
INSERT INTO `ezs_area` VALUES ('4524617', '2013-07-30 15:39:55', '', '东坡区', '2', '0', '4524615', '');
INSERT INTO `ezs_area` VALUES ('4524618', '2013-07-30 15:39:55', '', '仁寿县', '2', '0', '4524615', '');
INSERT INTO `ezs_area` VALUES ('4524619', '2013-07-30 15:39:55', '', '彭山县', '2', '0', '4524615', '');
INSERT INTO `ezs_area` VALUES ('4524620', '2013-07-30 15:39:55', '', '洪雅县', '2', '0', '4524615', '');
INSERT INTO `ezs_area` VALUES ('4524621', '2013-07-30 15:39:55', '', '丹棱县', '2', '0', '4524615', '');
INSERT INTO `ezs_area` VALUES ('4524622', '2013-07-30 15:39:55', '', '青神县', '2', '0', '4524615', '');
INSERT INTO `ezs_area` VALUES ('4524623', '2013-07-30 15:39:55', '', '宜宾市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524624', '2013-07-30 15:39:55', '', '市辖区', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524625', '2013-07-30 15:39:55', '', '翠屏区', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524626', '2013-07-30 15:39:55', '', '宜宾县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524627', '2013-07-30 15:39:55', '', '南溪县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524628', '2013-07-30 15:39:55', '', '江安县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524629', '2013-07-30 15:39:55', '', '长宁县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524630', '2013-07-30 15:39:56', '', '高县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524631', '2013-07-30 15:39:56', '', '珙县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524632', '2013-07-30 15:39:56', '', '筠连县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524633', '2013-07-30 15:39:56', '', '兴文县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524634', '2013-07-30 15:39:56', '', '屏山县', '2', '0', '4524623', '');
INSERT INTO `ezs_area` VALUES ('4524635', '2013-07-30 15:39:56', '', '广安市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524636', '2013-07-30 15:39:56', '', '市辖区', '2', '0', '4524635', '');
INSERT INTO `ezs_area` VALUES ('4524637', '2013-07-30 15:39:56', '', '广安区', '2', '0', '4524635', '');
INSERT INTO `ezs_area` VALUES ('4524638', '2013-07-30 15:39:56', '', '岳池县', '2', '0', '4524635', '');
INSERT INTO `ezs_area` VALUES ('4524639', '2013-07-30 15:39:56', '', '武胜县', '2', '0', '4524635', '');
INSERT INTO `ezs_area` VALUES ('4524640', '2013-07-30 15:39:56', '', '邻水县', '2', '0', '4524635', '');
INSERT INTO `ezs_area` VALUES ('4524641', '2013-07-30 15:39:56', '', '华蓥市', '2', '0', '4524635', '');
INSERT INTO `ezs_area` VALUES ('4524642', '2013-07-30 15:39:56', '', '达州市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524643', '2013-07-30 15:39:57', '', '市辖区', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524644', '2013-07-30 15:39:57', '', '通川区', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524645', '2013-07-30 15:39:57', '', '达县', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524646', '2013-07-30 15:39:57', '', '宣汉县', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524647', '2013-07-30 15:39:57', '', '开江县', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524648', '2013-07-30 15:39:57', '', '大竹县', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524649', '2013-07-30 15:39:57', '', '渠县', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524650', '2013-07-30 15:39:57', '', '万源市', '2', '0', '4524642', '');
INSERT INTO `ezs_area` VALUES ('4524651', '2013-07-30 15:39:57', '', '雅安市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524652', '2013-07-30 15:39:57', '', '市辖区', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524653', '2013-07-30 15:39:57', '', '雨城区', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524654', '2013-07-30 15:39:57', '', '名山县', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524655', '2013-07-30 15:39:58', '', '荥经县', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524656', '2013-07-30 15:39:58', '', '汉源县', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524657', '2013-07-30 15:39:58', '', '石棉县', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524658', '2013-07-30 15:39:58', '', '天全县', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524659', '2013-07-30 15:39:58', '', '芦山县', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524660', '2013-07-30 15:39:58', '', '宝兴县', '2', '0', '4524651', '');
INSERT INTO `ezs_area` VALUES ('4524661', '2013-07-30 15:39:58', '', '巴中市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524662', '2013-07-30 15:39:58', '', '市辖区', '2', '0', '4524661', '');
INSERT INTO `ezs_area` VALUES ('4524663', '2013-07-30 15:39:58', '', '巴州区', '2', '0', '4524661', '');
INSERT INTO `ezs_area` VALUES ('4524664', '2013-07-30 15:39:58', '', '通江县', '2', '0', '4524661', '');
INSERT INTO `ezs_area` VALUES ('4524665', '2013-07-30 15:39:58', '', '南江县', '2', '0', '4524661', '');
INSERT INTO `ezs_area` VALUES ('4524666', '2013-07-30 15:39:58', '', '平昌县', '2', '0', '4524661', '');
INSERT INTO `ezs_area` VALUES ('4524667', '2013-07-30 15:39:59', '', '资阳市', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524668', '2013-07-30 15:39:59', '', '市辖区', '2', '0', '4524667', '');
INSERT INTO `ezs_area` VALUES ('4524669', '2013-07-30 15:39:59', '', '雁江区', '2', '0', '4524667', '');
INSERT INTO `ezs_area` VALUES ('4524670', '2013-07-30 15:39:59', '', '安岳县', '2', '0', '4524667', '');
INSERT INTO `ezs_area` VALUES ('4524671', '2013-07-30 15:39:59', '', '乐至县', '2', '0', '4524667', '');
INSERT INTO `ezs_area` VALUES ('4524672', '2013-07-30 15:39:59', '', '简阳市', '2', '0', '4524667', '');
INSERT INTO `ezs_area` VALUES ('4524673', '2013-07-30 15:39:59', '', '阿坝藏族羌族自治州', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524674', '2013-07-30 15:39:59', '', '汶川县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524675', '2013-07-30 15:39:59', '', '理县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524676', '2013-07-30 15:39:59', '', '茂县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524677', '2013-07-30 15:39:59', '', '松潘县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524678', '2013-07-30 15:39:59', '', '九寨沟县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524679', '2013-07-30 15:40:00', '', '金川县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524680', '2013-07-30 15:40:00', '', '小金县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524681', '2013-07-30 15:40:00', '', '黑水县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524682', '2013-07-30 15:40:00', '', '马尔康县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524683', '2013-07-30 15:40:00', '', '壤塘县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524684', '2013-07-30 15:40:00', '', '阿坝县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524685', '2013-07-30 15:40:00', '', '若尔盖县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524686', '2013-07-30 15:40:00', '', '红原县', '2', '0', '4524673', '');
INSERT INTO `ezs_area` VALUES ('4524687', '2013-07-30 15:40:00', '', '甘孜藏族自治州', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524688', '2013-07-30 15:40:00', '', '康定县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524689', '2013-07-30 15:40:00', '', '泸定县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524690', '2013-07-30 15:40:00', '', '丹巴县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524691', '2013-07-30 15:40:01', '', '九龙县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524692', '2013-07-30 15:40:01', '', '雅江县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524693', '2013-07-30 15:40:01', '', '道孚县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524694', '2013-07-30 15:40:01', '', '炉霍县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524695', '2013-07-30 15:40:01', '', '甘孜县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524696', '2013-07-30 15:40:01', '', '新龙县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524697', '2013-07-30 15:40:01', '', '德格县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524698', '2013-07-30 15:40:01', '', '白玉县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524699', '2013-07-30 15:40:01', '', '石渠县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524700', '2013-07-30 15:40:01', '', '色达县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524701', '2013-07-30 15:40:01', '', '理塘县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524702', '2013-07-30 15:40:01', '', '巴塘县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524703', '2013-07-30 15:40:02', '', '乡城县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524704', '2013-07-30 15:40:02', '', '稻城县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524705', '2013-07-30 15:40:02', '', '得荣县', '2', '0', '4524687', '');
INSERT INTO `ezs_area` VALUES ('4524706', '2013-07-30 15:40:02', '', '凉山彝族自治州', '1', '0', '4524503', '');
INSERT INTO `ezs_area` VALUES ('4524707', '2013-07-30 15:40:02', '', '西昌市', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524708', '2013-07-30 15:40:02', '', '木里藏族自治县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524709', '2013-07-30 15:40:02', '', '盐源县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524710', '2013-07-30 15:40:02', '', '德昌县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524711', '2013-07-30 15:40:02', '', '会理县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524712', '2013-07-30 15:40:02', '', '会东县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524713', '2013-07-30 15:40:02', '', '宁南县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524714', '2013-07-30 15:40:02', '', '普格县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524715', '2013-07-30 15:40:03', '', '布拖县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524716', '2013-07-30 15:40:03', '', '金阳县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524717', '2013-07-30 15:40:03', '', '昭觉县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524718', '2013-07-30 15:40:03', '', '喜德县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524719', '2013-07-30 15:40:03', '', '冕宁县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524720', '2013-07-30 15:40:03', '', '越西县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524721', '2013-07-30 15:40:03', '', '甘洛县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524722', '2013-07-30 15:40:03', '', '美姑县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524723', '2013-07-30 15:40:03', '', '雷波县', '2', '0', '4524706', '');
INSERT INTO `ezs_area` VALUES ('4524724', '2013-07-30 15:40:03', '', '贵州省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524725', '2013-07-30 15:40:03', '', '贵阳市', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524726', '2013-07-30 15:40:03', '', '市辖区', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524727', '2013-07-30 15:40:04', '', '南明区', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524728', '2013-07-30 15:40:04', '', '云岩区', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524729', '2013-07-30 15:40:04', '', '花溪区', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524730', '2013-07-30 15:40:04', '', '乌当区', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524731', '2013-07-30 15:40:04', '', '白云区', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524732', '2013-07-30 15:40:04', '', '小河区', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524733', '2013-07-30 15:40:04', '', '开阳县', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524734', '2013-07-30 15:40:04', '', '息烽县', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524735', '2013-07-30 15:40:04', '', '修文县', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524736', '2013-07-30 15:40:04', '', '清镇市', '2', '0', '4524725', '');
INSERT INTO `ezs_area` VALUES ('4524737', '2013-07-30 15:40:05', '', '六盘水市', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524738', '2013-07-30 15:40:05', '', '钟山区', '2', '0', '4524737', '');
INSERT INTO `ezs_area` VALUES ('4524739', '2013-07-30 15:40:05', '', '六枝特区', '2', '0', '4524737', '');
INSERT INTO `ezs_area` VALUES ('4524740', '2013-07-30 15:40:05', '', '水城县', '2', '0', '4524737', '');
INSERT INTO `ezs_area` VALUES ('4524741', '2013-07-30 15:40:05', '', '盘县', '2', '0', '4524737', '');
INSERT INTO `ezs_area` VALUES ('4524742', '2013-07-30 15:40:05', '', '遵义市', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524743', '2013-07-30 15:40:05', '', '市辖区', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524744', '2013-07-30 15:40:05', '', '红花岗区', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524745', '2013-07-30 15:40:05', '', '汇川区', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524746', '2013-07-30 15:40:05', '', '遵义县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524747', '2013-07-30 15:40:05', '', '桐梓县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524748', '2013-07-30 15:40:05', '', '绥阳县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524749', '2013-07-30 15:40:06', '', '正安县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524750', '2013-07-30 15:40:06', '', '道真仡佬族苗族自治县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524751', '2013-07-30 15:40:06', '', '务川仡佬族苗族自治县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524752', '2013-07-30 15:40:06', '', '凤冈县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524753', '2013-07-30 15:40:06', '', '湄潭县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524754', '2013-07-30 15:40:06', '', '余庆县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524755', '2013-07-30 15:40:06', '', '习水县', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524756', '2013-07-30 15:40:06', '', '赤水市', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524757', '2013-07-30 15:40:06', '', '仁怀市', '2', '0', '4524742', '');
INSERT INTO `ezs_area` VALUES ('4524758', '2013-07-30 15:40:06', '', '安顺市', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524759', '2013-07-30 15:40:06', '', '市辖区', '2', '0', '4524758', '');
INSERT INTO `ezs_area` VALUES ('4524760', '2013-07-30 15:40:07', '', '西秀区', '2', '0', '4524758', '');
INSERT INTO `ezs_area` VALUES ('4524761', '2013-07-30 15:40:07', '', '平坝县', '2', '0', '4524758', '');
INSERT INTO `ezs_area` VALUES ('4524762', '2013-07-30 15:40:07', '', '普定县', '2', '0', '4524758', '');
INSERT INTO `ezs_area` VALUES ('4524763', '2013-07-30 15:40:07', '', '镇宁布依族苗族自治县', '2', '0', '4524758', '');
INSERT INTO `ezs_area` VALUES ('4524764', '2013-07-30 15:40:07', '', '关岭布依族苗族自治县', '2', '0', '4524758', '');
INSERT INTO `ezs_area` VALUES ('4524765', '2013-07-30 15:40:07', '', '紫云苗族布依族自治县', '2', '0', '4524758', '');
INSERT INTO `ezs_area` VALUES ('4524766', '2013-07-30 15:40:07', '', '铜仁地区', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524767', '2013-07-30 15:40:07', '', '铜仁市', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524768', '2013-07-30 15:40:07', '', '江口县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524769', '2013-07-30 15:40:07', '', '玉屏侗族自治县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524770', '2013-07-30 15:40:07', '', '石阡县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524771', '2013-07-30 15:40:07', '', '思南县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524772', '2013-07-30 15:40:08', '', '印江土家族苗族自治县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524773', '2013-07-30 15:40:08', '', '德江县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524774', '2013-07-30 15:40:08', '', '沿河土家族自治县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524775', '2013-07-30 15:40:08', '', '松桃苗族自治县', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524776', '2013-07-30 15:40:08', '', '万山特区', '2', '0', '4524766', '');
INSERT INTO `ezs_area` VALUES ('4524777', '2013-07-30 15:40:08', '', '黔西南布依族苗族自治州', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524778', '2013-07-30 15:40:08', '', '兴义市', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524779', '2013-07-30 15:40:08', '', '兴仁县', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524780', '2013-07-30 15:40:08', '', '普安县', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524781', '2013-07-30 15:40:08', '', '晴隆县', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524782', '2013-07-30 15:40:08', '', '贞丰县', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524783', '2013-07-30 15:40:08', '', '望谟县', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524784', '2013-07-30 15:40:09', '', '册亨县', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524785', '2013-07-30 15:40:09', '', '安龙县', '2', '0', '4524777', '');
INSERT INTO `ezs_area` VALUES ('4524786', '2013-07-30 15:40:09', '', '毕节地区', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524787', '2013-07-30 15:40:09', '', '毕节市', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524788', '2013-07-30 15:40:09', '', '大方县', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524789', '2013-07-30 15:40:09', '', '黔西县', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524790', '2013-07-30 15:40:09', '', '金沙县', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524791', '2013-07-30 15:40:09', '', '织金县', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524792', '2013-07-30 15:40:09', '', '纳雍县', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524793', '2013-07-30 15:40:09', '', '威宁彝族回族苗族自治县', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524794', '2013-07-30 15:40:09', '', '赫章县', '2', '0', '4524786', '');
INSERT INTO `ezs_area` VALUES ('4524795', '2013-07-30 15:40:10', '', '黔东南苗族侗族自治州', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524796', '2013-07-30 15:40:10', '', '凯里市', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524797', '2013-07-30 15:40:10', '', '黄平县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524798', '2013-07-30 15:40:10', '', '施秉县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524799', '2013-07-30 15:40:10', '', '三穗县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524800', '2013-07-30 15:40:10', '', '镇远县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524801', '2013-07-30 15:40:10', '', '岑巩县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524802', '2013-07-30 15:40:10', '', '天柱县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524803', '2013-07-30 15:40:10', '', '锦屏县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524804', '2013-07-30 15:40:10', '', '剑河县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524805', '2013-07-30 15:40:10', '', '台江县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524806', '2013-07-30 15:40:10', '', '黎平县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524807', '2013-07-30 15:40:11', '', '榕江县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524808', '2013-07-30 15:40:11', '', '从江县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524809', '2013-07-30 15:40:11', '', '雷山县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524810', '2013-07-30 15:40:11', '', '麻江县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524811', '2013-07-30 15:40:11', '', '丹寨县', '2', '0', '4524795', '');
INSERT INTO `ezs_area` VALUES ('4524812', '2013-07-30 15:40:11', '', '黔南布依族苗族自治州', '1', '0', '4524724', '');
INSERT INTO `ezs_area` VALUES ('4524813', '2013-07-30 15:40:11', '', '都匀市', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524814', '2013-07-30 15:40:11', '', '福泉市', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524815', '2013-07-30 15:40:11', '', '荔波县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524816', '2013-07-30 15:40:11', '', '贵定县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524817', '2013-07-30 15:40:11', '', '瓮安县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524818', '2013-07-30 15:40:12', '', '独山县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524819', '2013-07-30 15:40:12', '', '平塘县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524820', '2013-07-30 15:40:12', '', '罗甸县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524821', '2013-07-30 15:40:12', '', '长顺县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524822', '2013-07-30 15:40:12', '', '龙里县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524823', '2013-07-30 15:40:12', '', '惠水县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524824', '2013-07-30 15:40:12', '', '三都水族自治县', '2', '0', '4524812', '');
INSERT INTO `ezs_area` VALUES ('4524825', '2013-07-30 15:40:12', '', '云南省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524826', '2013-07-30 15:40:12', '', '昆明市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524827', '2013-07-30 15:40:12', '', '市辖区', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524828', '2013-07-30 15:40:12', '', '五华区', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524829', '2013-07-30 15:40:13', '', '盘龙区', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524830', '2013-07-30 15:40:13', '', '官渡区', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524831', '2013-07-30 15:40:13', '', '西山区', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524832', '2013-07-30 15:40:13', '', '东川区', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524833', '2013-07-30 15:40:13', '', '呈贡县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524834', '2013-07-30 15:40:13', '', '晋宁县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524835', '2013-07-30 15:40:13', '', '富民县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524836', '2013-07-30 15:40:13', '', '宜良县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524837', '2013-07-30 15:40:13', '', '石林彝族自治县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524838', '2013-07-30 15:40:13', '', '嵩明县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524839', '2013-07-30 15:40:13', '', '禄劝彝族苗族自治县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524840', '2013-07-30 15:40:13', '', '寻甸回族彝族自治县', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524841', '2013-07-30 15:40:14', '', '安宁市', '2', '0', '4524826', '');
INSERT INTO `ezs_area` VALUES ('4524842', '2013-07-30 15:40:14', '', '曲靖市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524843', '2013-07-30 15:40:14', '', '市辖区', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524844', '2013-07-30 15:40:14', '', '麒麟区', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524845', '2013-07-30 15:40:14', '', '马龙县', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524846', '2013-07-30 15:40:14', '', '陆良县', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524847', '2013-07-30 15:40:14', '', '师宗县', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524848', '2013-07-30 15:40:14', '', '罗平县', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524849', '2013-07-30 15:40:14', '', '富源县', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524850', '2013-07-30 15:40:14', '', '会泽县', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524851', '2013-07-30 15:40:14', '', '沾益县', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524852', '2013-07-30 15:40:15', '', '宣威市', '2', '0', '4524842', '');
INSERT INTO `ezs_area` VALUES ('4524853', '2013-07-30 15:40:15', '', '玉溪市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524854', '2013-07-30 15:40:15', '', '市辖区', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524855', '2013-07-30 15:40:15', '', '红塔区', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524856', '2013-07-30 15:40:15', '', '江川县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524857', '2013-07-30 15:40:15', '', '澄江县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524858', '2013-07-30 15:40:15', '', '通海县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524859', '2013-07-30 15:40:15', '', '华宁县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524860', '2013-07-30 15:40:15', '', '易门县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524861', '2013-07-30 15:40:15', '', '峨山彝族自治县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524862', '2013-07-30 15:40:15', '', '新平彝族傣族自治县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524863', '2013-07-30 15:40:16', '', '元江哈尼族彝族傣族自治县', '2', '0', '4524853', '');
INSERT INTO `ezs_area` VALUES ('4524864', '2013-07-30 15:40:16', '', '保山市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524865', '2013-07-30 15:40:16', '', '市辖区', '2', '0', '4524864', '');
INSERT INTO `ezs_area` VALUES ('4524866', '2013-07-30 15:40:16', '', '隆阳区', '2', '0', '4524864', '');
INSERT INTO `ezs_area` VALUES ('4524867', '2013-07-30 15:40:16', '', '施甸县', '2', '0', '4524864', '');
INSERT INTO `ezs_area` VALUES ('4524868', '2013-07-30 15:40:16', '', '腾冲县', '2', '0', '4524864', '');
INSERT INTO `ezs_area` VALUES ('4524869', '2013-07-30 15:40:16', '', '龙陵县', '2', '0', '4524864', '');
INSERT INTO `ezs_area` VALUES ('4524870', '2013-07-30 15:40:16', '', '昌宁县', '2', '0', '4524864', '');
INSERT INTO `ezs_area` VALUES ('4524871', '2013-07-30 15:40:16', '', '昭通市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524872', '2013-07-30 15:40:16', '', '市辖区', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524873', '2013-07-30 15:40:16', '', '昭阳区', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524874', '2013-07-30 15:40:17', '', '鲁甸县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524875', '2013-07-30 15:40:17', '', '巧家县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524876', '2013-07-30 15:40:17', '', '盐津县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524877', '2013-07-30 15:40:17', '', '大关县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524878', '2013-07-30 15:40:17', '', '永善县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524879', '2013-07-30 15:40:17', '', '绥江县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524880', '2013-07-30 15:40:17', '', '镇雄县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524881', '2013-07-30 15:40:17', '', '彝良县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524882', '2013-07-30 15:40:17', '', '威信县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524883', '2013-07-30 15:40:17', '', '水富县', '2', '0', '4524871', '');
INSERT INTO `ezs_area` VALUES ('4524884', '2013-07-30 15:40:17', '', '丽江市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524885', '2013-07-30 15:40:18', '', '市辖区', '2', '0', '4524884', '');
INSERT INTO `ezs_area` VALUES ('4524886', '2013-07-30 15:40:18', '', '古城区', '2', '0', '4524884', '');
INSERT INTO `ezs_area` VALUES ('4524887', '2013-07-30 15:40:18', '', '玉龙纳西族自治县', '2', '0', '4524884', '');
INSERT INTO `ezs_area` VALUES ('4524888', '2013-07-30 15:40:18', '', '永胜县', '2', '0', '4524884', '');
INSERT INTO `ezs_area` VALUES ('4524889', '2013-07-30 15:40:18', '', '华坪县', '2', '0', '4524884', '');
INSERT INTO `ezs_area` VALUES ('4524890', '2013-07-30 15:40:18', '', '宁蒗彝族自治县', '2', '0', '4524884', '');
INSERT INTO `ezs_area` VALUES ('4524891', '2013-07-30 15:40:18', '', '普洱市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524892', '2013-07-30 15:40:18', '', '市辖区', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524893', '2013-07-30 15:40:18', '', '思茅区', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524894', '2013-07-30 15:40:18', '', '宁洱哈尼族彝族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524895', '2013-07-30 15:40:19', '', '墨江哈尼族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524896', '2013-07-30 15:40:19', '', '景东彝族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524897', '2013-07-30 15:40:19', '', '景谷傣族彝族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524898', '2013-07-30 15:40:19', '', '镇沅彝族哈尼族拉祜族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524899', '2013-07-30 15:40:19', '', '江城哈尼族彝族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524900', '2013-07-30 15:40:19', '', '孟连傣族拉祜族佤族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524901', '2013-07-30 15:40:19', '', '澜沧拉祜族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524902', '2013-07-30 15:40:19', '', '西盟佤族自治县', '2', '0', '4524891', '');
INSERT INTO `ezs_area` VALUES ('4524903', '2013-07-30 15:40:19', '', '临沧市', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524904', '2013-07-30 15:40:19', '', '市辖区', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524905', '2013-07-30 15:40:19', '', '临翔区', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524906', '2013-07-30 15:40:20', '', '凤庆县', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524907', '2013-07-30 15:40:20', '', '云县', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524908', '2013-07-30 15:40:20', '', '永德县', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524909', '2013-07-30 15:40:20', '', '镇康县', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524910', '2013-07-30 15:40:20', '', '双江拉祜族佤族布朗族傣族自治县', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524911', '2013-07-30 15:40:20', '', '耿马傣族佤族自治县', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524912', '2013-07-30 15:40:20', '', '沧源佤族自治县', '2', '0', '4524903', '');
INSERT INTO `ezs_area` VALUES ('4524913', '2013-07-30 15:40:20', '', '楚雄彝族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524914', '2013-07-30 15:40:20', '', '楚雄市', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524915', '2013-07-30 15:40:20', '', '双柏县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524916', '2013-07-30 15:40:20', '', '牟定县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524917', '2013-07-30 15:40:21', '', '南华县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524918', '2013-07-30 15:40:21', '', '姚安县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524919', '2013-07-30 15:40:21', '', '大姚县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524920', '2013-07-30 15:40:21', '', '永仁县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524921', '2013-07-30 15:40:21', '', '元谋县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524922', '2013-07-30 15:40:21', '', '武定县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524923', '2013-07-30 15:40:21', '', '禄丰县', '2', '0', '4524913', '');
INSERT INTO `ezs_area` VALUES ('4524924', '2013-07-30 15:40:21', '', '红河哈尼族彝族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524925', '2013-07-30 15:40:21', '', '个旧市', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524926', '2013-07-30 15:40:21', '', '开远市', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524927', '2013-07-30 15:40:21', '', '蒙自市', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524928', '2013-07-30 15:40:22', '', '屏边苗族自治县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524929', '2013-07-30 15:40:22', '', '建水县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524930', '2013-07-30 15:40:22', '', '石屏县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524931', '2013-07-30 15:40:22', '', '弥勒县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524932', '2013-07-30 15:40:22', '', '泸西县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524933', '2013-07-30 15:40:22', '', '元阳县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524934', '2013-07-30 15:40:22', '', '红河县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524935', '2013-07-30 15:40:22', '', '金平苗族瑶族傣族自治县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524936', '2013-07-30 15:40:22', '', '绿春县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524937', '2013-07-30 15:40:22', '', '河口瑶族自治县', '2', '0', '4524924', '');
INSERT INTO `ezs_area` VALUES ('4524938', '2013-07-30 15:40:22', '', '文山壮族苗族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524939', '2013-07-30 15:40:23', '', '文山县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524940', '2013-07-30 15:40:23', '', '砚山县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524941', '2013-07-30 15:40:23', '', '西畴县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524942', '2013-07-30 15:40:23', '', '麻栗坡县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524943', '2013-07-30 15:40:23', '', '马关县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524944', '2013-07-30 15:40:23', '', '丘北县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524945', '2013-07-30 15:40:23', '', '广南县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524946', '2013-07-30 15:40:23', '', '富宁县', '2', '0', '4524938', '');
INSERT INTO `ezs_area` VALUES ('4524947', '2013-07-30 15:40:23', '', '西双版纳傣族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524948', '2013-07-30 15:40:23', '', '景洪市', '2', '0', '4524947', '');
INSERT INTO `ezs_area` VALUES ('4524949', '2013-07-30 15:40:23', '', '勐海县', '2', '0', '4524947', '');
INSERT INTO `ezs_area` VALUES ('4524950', '2013-07-30 15:40:24', '', '勐腊县', '2', '0', '4524947', '');
INSERT INTO `ezs_area` VALUES ('4524951', '2013-07-30 15:40:24', '', '大理白族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524952', '2013-07-30 15:40:24', '', '大理市', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524953', '2013-07-30 15:40:24', '', '漾濞彝族自治县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524954', '2013-07-30 15:40:24', '', '祥云县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524955', '2013-07-30 15:40:24', '', '宾川县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524956', '2013-07-30 15:40:24', '', '弥渡县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524957', '2013-07-30 15:40:24', '', '南涧彝族自治县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524958', '2013-07-30 15:40:24', '', '巍山彝族回族自治县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524959', '2013-07-30 15:40:24', '', '永平县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524960', '2013-07-30 15:40:25', '', '云龙县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524961', '2013-07-30 15:40:25', '', '洱源县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524962', '2013-07-30 15:40:25', '', '剑川县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524963', '2013-07-30 15:40:25', '', '鹤庆县', '2', '0', '4524951', '');
INSERT INTO `ezs_area` VALUES ('4524964', '2013-07-30 15:40:25', '', '德宏傣族景颇族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524965', '2013-07-30 15:40:25', '', '瑞丽市', '2', '0', '4524964', '');
INSERT INTO `ezs_area` VALUES ('4524966', '2013-07-30 15:40:25', '', '芒市', '2', '0', '4524964', '');
INSERT INTO `ezs_area` VALUES ('4524967', '2013-07-30 15:40:25', '', '梁河县', '2', '0', '4524964', '');
INSERT INTO `ezs_area` VALUES ('4524968', '2013-07-30 15:40:25', '', '盈江县', '2', '0', '4524964', '');
INSERT INTO `ezs_area` VALUES ('4524969', '2013-07-30 15:40:25', '', '陇川县', '2', '0', '4524964', '');
INSERT INTO `ezs_area` VALUES ('4524970', '2013-07-30 15:40:25', '', '怒江傈僳族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524971', '2013-07-30 15:40:26', '', '泸水县', '2', '0', '4524970', '');
INSERT INTO `ezs_area` VALUES ('4524972', '2013-07-30 15:40:26', '', '福贡县', '2', '0', '4524970', '');
INSERT INTO `ezs_area` VALUES ('4524973', '2013-07-30 15:40:26', '', '贡山独龙族怒族自治县', '2', '0', '4524970', '');
INSERT INTO `ezs_area` VALUES ('4524974', '2013-07-30 15:40:26', '', '兰坪白族普米族自治县', '2', '0', '4524970', '');
INSERT INTO `ezs_area` VALUES ('4524975', '2013-07-30 15:40:26', '', '迪庆藏族自治州', '1', '0', '4524825', '');
INSERT INTO `ezs_area` VALUES ('4524976', '2013-07-30 15:40:26', '', '香格里拉县', '2', '0', '4524975', '');
INSERT INTO `ezs_area` VALUES ('4524977', '2013-07-30 15:40:26', '', '德钦县', '2', '0', '4524975', '');
INSERT INTO `ezs_area` VALUES ('4524978', '2013-07-30 15:40:26', '', '维西傈僳族自治县', '2', '0', '4524975', '');
INSERT INTO `ezs_area` VALUES ('4524979', '2013-07-30 15:40:26', '', '西藏自治区', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4524980', '2013-07-30 15:40:26', '', '拉萨市', '1', '0', '4524979', '');
INSERT INTO `ezs_area` VALUES ('4524981', '2013-07-30 15:40:26', '', '市辖区', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524982', '2013-07-30 15:40:27', '', '城关区', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524983', '2013-07-30 15:40:27', '', '林周县', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524984', '2013-07-30 15:40:27', '', '当雄县', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524985', '2013-07-30 15:40:27', '', '尼木县', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524986', '2013-07-30 15:40:27', '', '曲水县', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524987', '2013-07-30 15:40:27', '', '堆龙德庆县', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524988', '2013-07-30 15:40:27', '', '达孜县', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524989', '2013-07-30 15:40:27', '', '墨竹工卡县', '2', '0', '4524980', '');
INSERT INTO `ezs_area` VALUES ('4524990', '2013-07-30 15:40:27', '', '昌都地区', '1', '0', '4524979', '');
INSERT INTO `ezs_area` VALUES ('4524991', '2013-07-30 15:40:27', '', '昌都县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524992', '2013-07-30 15:40:27', '', '江达县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524993', '2013-07-30 15:40:28', '', '贡觉县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524994', '2013-07-30 15:40:28', '', '类乌齐县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524995', '2013-07-30 15:40:28', '', '丁青县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524996', '2013-07-30 15:40:28', '', '察雅县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524997', '2013-07-30 15:40:28', '', '八宿县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524998', '2013-07-30 15:40:28', '', '左贡县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4524999', '2013-07-30 15:40:28', '', '芒康县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4525000', '2013-07-30 15:40:28', '', '洛隆县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4525001', '2013-07-30 15:40:28', '', '边坝县', '2', '0', '4524990', '');
INSERT INTO `ezs_area` VALUES ('4525002', '2013-07-30 15:40:28', '', '山南地区', '1', '0', '4524979', '');
INSERT INTO `ezs_area` VALUES ('4525003', '2013-07-30 15:40:28', '', '乃东县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525004', '2013-07-30 15:40:29', '', '扎囊县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525005', '2013-07-30 15:40:29', '', '贡嘎县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525006', '2013-07-30 15:40:29', '', '桑日县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525007', '2013-07-30 15:40:29', '', '琼结县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525008', '2013-07-30 15:40:29', '', '曲松县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525009', '2013-07-30 15:40:29', '', '措美县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525010', '2013-07-30 15:40:29', '', '洛扎县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525011', '2013-07-30 15:40:29', '', '加查县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525012', '2013-07-30 15:40:29', '', '隆子县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525013', '2013-07-30 15:40:29', '', '错那县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525014', '2013-07-30 15:40:29', '', '浪卡子县', '2', '0', '4525002', '');
INSERT INTO `ezs_area` VALUES ('4525015', '2013-07-30 15:40:30', '', '日喀则地区', '1', '0', '4524979', '');
INSERT INTO `ezs_area` VALUES ('4525016', '2013-07-30 15:40:30', '', '日喀则市', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525017', '2013-07-30 15:40:30', '', '南木林县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525018', '2013-07-30 15:40:30', '', '江孜县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525019', '2013-07-30 15:40:30', '', '定日县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525020', '2013-07-30 15:40:30', '', '萨迦县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525021', '2013-07-30 15:40:30', '', '拉孜县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525022', '2013-07-30 15:40:30', '', '昂仁县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525023', '2013-07-30 15:40:30', '', '谢通门县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525024', '2013-07-30 15:40:30', '', '白朗县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525025', '2013-07-30 15:40:30', '', '仁布县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525026', '2013-07-30 15:40:31', '', '康马县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525027', '2013-07-30 15:40:31', '', '定结县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525028', '2013-07-30 15:40:31', '', '仲巴县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525029', '2013-07-30 15:40:31', '', '亚东县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525030', '2013-07-30 15:40:31', '', '吉隆县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525031', '2013-07-30 15:40:31', '', '聂拉木县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525032', '2013-07-30 15:40:31', '', '萨嘎县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525033', '2013-07-30 15:40:31', '', '岗巴县', '2', '0', '4525015', '');
INSERT INTO `ezs_area` VALUES ('4525034', '2013-07-30 15:40:31', '', '那曲地区', '1', '0', '4524979', '');
INSERT INTO `ezs_area` VALUES ('4525035', '2013-07-30 15:40:31', '', '那曲县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525036', '2013-07-30 15:40:32', '', '嘉黎县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525037', '2013-07-30 15:40:32', '', '比如县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525038', '2013-07-30 15:40:32', '', '聂荣县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525039', '2013-07-30 15:40:32', '', '安多县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525040', '2013-07-30 15:40:32', '', '申扎县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525041', '2013-07-30 15:40:32', '', '索县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525042', '2013-07-30 15:40:32', '', '班戈县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525043', '2013-07-30 15:40:32', '', '巴青县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525044', '2013-07-30 15:40:32', '', '尼玛县', '2', '0', '4525034', '');
INSERT INTO `ezs_area` VALUES ('4525045', '2013-07-30 15:40:32', '', '阿里地区', '1', '0', '4524979', '');
INSERT INTO `ezs_area` VALUES ('4525046', '2013-07-30 15:40:32', '', '普兰县', '2', '0', '4525045', '');
INSERT INTO `ezs_area` VALUES ('4525047', '2013-07-30 15:40:33', '', '札达县', '2', '0', '4525045', '');
INSERT INTO `ezs_area` VALUES ('4525048', '2013-07-30 15:40:33', '', '噶尔县', '2', '0', '4525045', '');
INSERT INTO `ezs_area` VALUES ('4525049', '2013-07-30 15:40:33', '', '日土县', '2', '0', '4525045', '');
INSERT INTO `ezs_area` VALUES ('4525050', '2013-07-30 15:40:33', '', '革吉县', '2', '0', '4525045', '');
INSERT INTO `ezs_area` VALUES ('4525051', '2013-07-30 15:40:33', '', '改则县', '2', '0', '4525045', '');
INSERT INTO `ezs_area` VALUES ('4525052', '2013-07-30 15:40:33', '', '措勤县', '2', '0', '4525045', '');
INSERT INTO `ezs_area` VALUES ('4525053', '2013-07-30 15:40:33', '', '林芝地区', '1', '0', '4524979', '');
INSERT INTO `ezs_area` VALUES ('4525054', '2013-07-30 15:40:33', '', '林芝县', '2', '0', '4525053', '');
INSERT INTO `ezs_area` VALUES ('4525055', '2013-07-30 15:40:33', '', '工布江达县', '2', '0', '4525053', '');
INSERT INTO `ezs_area` VALUES ('4525056', '2013-07-30 15:40:33', '', '米林县', '2', '0', '4525053', '');
INSERT INTO `ezs_area` VALUES ('4525057', '2013-07-30 15:40:34', '', '墨脱县', '2', '0', '4525053', '');
INSERT INTO `ezs_area` VALUES ('4525058', '2013-07-30 15:40:34', '', '波密县', '2', '0', '4525053', '');
INSERT INTO `ezs_area` VALUES ('4525059', '2013-07-30 15:40:34', '', '察隅县', '2', '0', '4525053', '');
INSERT INTO `ezs_area` VALUES ('4525060', '2013-07-30 15:40:34', '', '朗县', '2', '0', '4525053', '');
INSERT INTO `ezs_area` VALUES ('4525061', '2013-07-30 15:40:34', '', '陕西省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4525062', '2013-07-30 15:40:34', '', '西安市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525063', '2013-07-30 15:40:34', '', '市辖区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525064', '2013-07-30 15:40:34', '', '新城区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525065', '2013-07-30 15:40:34', '', '碑林区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525066', '2013-07-30 15:40:34', '', '莲湖区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525067', '2013-07-30 15:40:35', '', '灞桥区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525068', '2013-07-30 15:40:35', '', '未央区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525069', '2013-07-30 15:40:35', '', '雁塔区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525070', '2013-07-30 15:40:35', '', '阎良区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525071', '2013-07-30 15:40:35', '', '临潼区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525072', '2013-07-30 15:40:35', '', '长安区', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525073', '2013-07-30 15:40:35', '', '蓝田县', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525074', '2013-07-30 15:40:35', '', '周至县', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525075', '2013-07-30 15:40:35', '', '户县', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525076', '2013-07-30 15:40:35', '', '高陵县', '2', '0', '4525062', '');
INSERT INTO `ezs_area` VALUES ('4525077', '2013-07-30 15:40:35', '', '铜川市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525078', '2013-07-30 15:40:36', '', '市辖区', '2', '0', '4525077', '');
INSERT INTO `ezs_area` VALUES ('4525079', '2013-07-30 15:40:36', '', '王益区', '2', '0', '4525077', '');
INSERT INTO `ezs_area` VALUES ('4525080', '2013-07-30 15:40:36', '', '印台区', '2', '0', '4525077', '');
INSERT INTO `ezs_area` VALUES ('4525081', '2013-07-30 15:40:36', '', '耀州区', '2', '0', '4525077', '');
INSERT INTO `ezs_area` VALUES ('4525082', '2013-07-30 15:40:36', '', '宜君县', '2', '0', '4525077', '');
INSERT INTO `ezs_area` VALUES ('4525083', '2013-07-30 15:40:36', '', '宝鸡市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525084', '2013-07-30 15:40:36', '', '市辖区', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525085', '2013-07-30 15:40:36', '', '渭滨区', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525086', '2013-07-30 15:40:36', '', '金台区', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525087', '2013-07-30 15:40:36', '', '陈仓区', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525088', '2013-07-30 15:40:37', '', '凤翔县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525089', '2013-07-30 15:40:37', '', '岐山县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525090', '2013-07-30 15:40:37', '', '扶风县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525091', '2013-07-30 15:40:37', '', '眉县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525092', '2013-07-30 15:40:37', '', '陇县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525093', '2013-07-30 15:40:37', '', '千阳县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525094', '2013-07-30 15:40:37', '', '麟游县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525095', '2013-07-30 15:40:37', '', '凤县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525096', '2013-07-30 15:40:37', '', '太白县', '2', '0', '4525083', '');
INSERT INTO `ezs_area` VALUES ('4525097', '2013-07-30 15:40:37', '', '咸阳市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525098', '2013-07-30 15:40:38', '', '市辖区', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525099', '2013-07-30 15:40:38', '', '秦都区', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525100', '2013-07-30 15:40:38', '', '杨陵区', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525101', '2013-07-30 15:40:38', '', '渭城区', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525102', '2013-07-30 15:40:38', '', '三原县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525103', '2013-07-30 15:40:38', '', '泾阳县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525104', '2013-07-30 15:40:38', '', '乾县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525105', '2013-07-30 15:40:38', '', '礼泉县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525106', '2013-07-30 15:40:38', '', '永寿县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525107', '2013-07-30 15:40:38', '', '彬县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525108', '2013-07-30 15:40:38', '', '长武县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525109', '2013-07-30 15:40:39', '', '旬邑县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525110', '2013-07-30 15:40:39', '', '淳化县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525111', '2013-07-30 15:40:39', '', '武功县', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525112', '2013-07-30 15:40:39', '', '兴平市', '2', '0', '4525097', '');
INSERT INTO `ezs_area` VALUES ('4525113', '2013-07-30 15:40:39', '', '渭南市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525114', '2013-07-30 15:40:39', '', '市辖区', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525115', '2013-07-30 15:40:39', '', '临渭区', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525116', '2013-07-30 15:40:39', '', '华县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525117', '2013-07-30 15:40:39', '', '潼关县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525118', '2013-07-30 15:40:39', '', '大荔县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525119', '2013-07-30 15:40:40', '', '合阳县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525120', '2013-07-30 15:40:40', '', '澄城县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525121', '2013-07-30 15:40:40', '', '蒲城县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525122', '2013-07-30 15:40:40', '', '白水县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525123', '2013-07-30 15:40:40', '', '富平县', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525124', '2013-07-30 15:40:40', '', '韩城市', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525125', '2013-07-30 15:40:40', '', '华阴市', '2', '0', '4525113', '');
INSERT INTO `ezs_area` VALUES ('4525126', '2013-07-30 15:40:40', '', '延安市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525127', '2013-07-30 15:40:40', '', '市辖区', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525128', '2013-07-30 15:40:40', '', '宝塔区', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525129', '2013-07-30 15:40:40', '', '延长县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525130', '2013-07-30 15:40:41', '', '延川县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525131', '2013-07-30 15:40:41', '', '子长县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525132', '2013-07-30 15:40:41', '', '安塞县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525133', '2013-07-30 15:40:41', '', '志丹县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525134', '2013-07-30 15:40:41', '', '吴起县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525135', '2013-07-30 15:40:41', '', '甘泉县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525136', '2013-07-30 15:40:41', '', '富县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525137', '2013-07-30 15:40:41', '', '洛川县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525138', '2013-07-30 15:40:41', '', '宜川县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525139', '2013-07-30 15:40:41', '', '黄龙县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525140', '2013-07-30 15:40:42', '', '黄陵县', '2', '0', '4525126', '');
INSERT INTO `ezs_area` VALUES ('4525141', '2013-07-30 15:40:42', '', '汉中市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525142', '2013-07-30 15:40:42', '', '市辖区', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525143', '2013-07-30 15:40:42', '', '汉台区', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525144', '2013-07-30 15:40:42', '', '南郑县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525145', '2013-07-30 15:40:42', '', '城固县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525146', '2013-07-30 15:40:42', '', '洋县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525147', '2013-07-30 15:40:42', '', '西乡县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525148', '2013-07-30 15:40:42', '', '勉县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525149', '2013-07-30 15:40:42', '', '宁强县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525150', '2013-07-30 15:40:43', '', '略阳县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525151', '2013-07-30 15:40:43', '', '镇巴县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525152', '2013-07-30 15:40:43', '', '留坝县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525153', '2013-07-30 15:40:43', '', '佛坪县', '2', '0', '4525141', '');
INSERT INTO `ezs_area` VALUES ('4525154', '2013-07-30 15:40:43', '', '榆林市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525155', '2013-07-30 15:40:43', '', '市辖区', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525156', '2013-07-30 15:40:43', '', '榆阳区', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525157', '2013-07-30 15:40:43', '', '神木县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525158', '2013-07-30 15:40:43', '', '府谷县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525159', '2013-07-30 15:40:43', '', '横山县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525160', '2013-07-30 15:40:43', '', '靖边县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525161', '2013-07-30 15:40:44', '', '定边县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525162', '2013-07-30 15:40:44', '', '绥德县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525163', '2013-07-30 15:40:44', '', '米脂县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525164', '2013-07-30 15:40:44', '', '佳县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525165', '2013-07-30 15:40:44', '', '吴堡县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525166', '2013-07-30 15:40:44', '', '清涧县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525167', '2013-07-30 15:40:44', '', '子洲县', '2', '0', '4525154', '');
INSERT INTO `ezs_area` VALUES ('4525168', '2013-07-30 15:40:44', '', '安康市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525169', '2013-07-30 15:40:44', '', '市辖区', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525170', '2013-07-30 15:40:44', '', '汉滨区', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525171', '2013-07-30 15:40:45', '', '汉阴县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525172', '2013-07-30 15:40:45', '', '石泉县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525173', '2013-07-30 15:40:45', '', '宁陕县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525174', '2013-07-30 15:40:45', '', '紫阳县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525175', '2013-07-30 15:40:45', '', '岚皋县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525176', '2013-07-30 15:40:45', '', '平利县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525177', '2013-07-30 15:40:45', '', '镇坪县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525178', '2013-07-30 15:40:45', '', '旬阳县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525179', '2013-07-30 15:40:45', '', '白河县', '2', '0', '4525168', '');
INSERT INTO `ezs_area` VALUES ('4525180', '2013-07-30 15:40:45', '', '商洛市', '1', '0', '4525061', '');
INSERT INTO `ezs_area` VALUES ('4525181', '2013-07-30 15:40:46', '', '市辖区', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525182', '2013-07-30 15:40:46', '', '商州区', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525183', '2013-07-30 15:40:46', '', '洛南县', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525184', '2013-07-30 15:40:46', '', '丹凤县', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525185', '2013-07-30 15:40:46', '', '商南县', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525186', '2013-07-30 15:40:46', '', '山阳县', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525187', '2013-07-30 15:40:46', '', '镇安县', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525188', '2013-07-30 15:40:46', '', '柞水县', '2', '0', '4525180', '');
INSERT INTO `ezs_area` VALUES ('4525189', '2013-07-30 15:40:46', '', '甘肃省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4525190', '2013-07-30 15:40:46', '', '兰州市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525191', '2013-07-30 15:40:47', '', '市辖区', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525192', '2013-07-30 15:40:47', '', '城关区', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525193', '2013-07-30 15:40:47', '', '七里河区', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525194', '2013-07-30 15:40:47', '', '西固区', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525195', '2013-07-30 15:40:47', '', '安宁区', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525196', '2013-07-30 15:40:47', '', '红古区', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525197', '2013-07-30 15:40:47', '', '永登县', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525198', '2013-07-30 15:40:47', '', '皋兰县', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525199', '2013-07-30 15:40:47', '', '榆中县', '2', '0', '4525190', '');
INSERT INTO `ezs_area` VALUES ('4525200', '2013-07-30 15:40:47', '', '嘉峪关市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525201', '2013-07-30 15:40:47', '', '市辖区', '2', '0', '4525200', '');
INSERT INTO `ezs_area` VALUES ('4525202', '2013-07-30 15:40:48', '', '金昌市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525203', '2013-07-30 15:40:48', '', '市辖区', '2', '0', '4525202', '');
INSERT INTO `ezs_area` VALUES ('4525204', '2013-07-30 15:40:48', '', '金川区', '2', '0', '4525202', '');
INSERT INTO `ezs_area` VALUES ('4525205', '2013-07-30 15:40:48', '', '永昌县', '2', '0', '4525202', '');
INSERT INTO `ezs_area` VALUES ('4525206', '2013-07-30 15:40:48', '', '白银市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525207', '2013-07-30 15:40:48', '', '市辖区', '2', '0', '4525206', '');
INSERT INTO `ezs_area` VALUES ('4525208', '2013-07-30 15:40:48', '', '白银区', '2', '0', '4525206', '');
INSERT INTO `ezs_area` VALUES ('4525209', '2013-07-30 15:40:48', '', '平川区', '2', '0', '4525206', '');
INSERT INTO `ezs_area` VALUES ('4525210', '2013-07-30 15:40:48', '', '靖远县', '2', '0', '4525206', '');
INSERT INTO `ezs_area` VALUES ('4525211', '2013-07-30 15:40:48', '', '会宁县', '2', '0', '4525206', '');
INSERT INTO `ezs_area` VALUES ('4525212', '2013-07-30 15:40:49', '', '景泰县', '2', '0', '4525206', '');
INSERT INTO `ezs_area` VALUES ('4525213', '2013-07-30 15:40:49', '', '天水市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525214', '2013-07-30 15:40:49', '', '市辖区', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525215', '2013-07-30 15:40:49', '', '秦州区', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525216', '2013-07-30 15:40:49', '', '麦积区', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525217', '2013-07-30 15:40:49', '', '清水县', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525218', '2013-07-30 15:40:49', '', '秦安县', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525219', '2013-07-30 15:40:49', '', '甘谷县', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525220', '2013-07-30 15:40:49', '', '武山县', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525221', '2013-07-30 15:40:49', '', '张家川回族自治县', '2', '0', '4525213', '');
INSERT INTO `ezs_area` VALUES ('4525222', '2013-07-30 15:40:50', '', '武威市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525223', '2013-07-30 15:40:50', '', '市辖区', '2', '0', '4525222', '');
INSERT INTO `ezs_area` VALUES ('4525224', '2013-07-30 15:40:50', '', '凉州区', '2', '0', '4525222', '');
INSERT INTO `ezs_area` VALUES ('4525225', '2013-07-30 15:40:50', '', '民勤县', '2', '0', '4525222', '');
INSERT INTO `ezs_area` VALUES ('4525226', '2013-07-30 15:40:50', '', '古浪县', '2', '0', '4525222', '');
INSERT INTO `ezs_area` VALUES ('4525227', '2013-07-30 15:40:50', '', '天祝藏族自治县', '2', '0', '4525222', '');
INSERT INTO `ezs_area` VALUES ('4525228', '2013-07-30 15:40:50', '', '张掖市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525229', '2013-07-30 15:40:50', '', '市辖区', '2', '0', '4525228', '');
INSERT INTO `ezs_area` VALUES ('4525230', '2013-07-30 15:40:50', '', '甘州区', '2', '0', '4525228', '');
INSERT INTO `ezs_area` VALUES ('4525231', '2013-07-30 15:40:50', '', '肃南裕固族自治县', '2', '0', '4525228', '');
INSERT INTO `ezs_area` VALUES ('4525232', '2013-07-30 15:40:51', '', '民乐县', '2', '0', '4525228', '');
INSERT INTO `ezs_area` VALUES ('4525233', '2013-07-30 15:40:51', '', '临泽县', '2', '0', '4525228', '');
INSERT INTO `ezs_area` VALUES ('4525234', '2013-07-30 15:40:51', '', '高台县', '2', '0', '4525228', '');
INSERT INTO `ezs_area` VALUES ('4525235', '2013-07-30 15:40:51', '', '山丹县', '2', '0', '4525228', '');
INSERT INTO `ezs_area` VALUES ('4525236', '2013-07-30 15:40:51', '', '平凉市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525237', '2013-07-30 15:40:51', '', '市辖区', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525238', '2013-07-30 15:40:51', '', '崆峒区', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525239', '2013-07-30 15:40:51', '', '泾川县', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525240', '2013-07-30 15:40:51', '', '灵台县', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525241', '2013-07-30 15:40:51', '', '崇信县', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525242', '2013-07-30 15:40:52', '', '华亭县', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525243', '2013-07-30 15:40:52', '', '庄浪县', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525244', '2013-07-30 15:40:52', '', '静宁县', '2', '0', '4525236', '');
INSERT INTO `ezs_area` VALUES ('4525245', '2013-07-30 15:40:52', '', '酒泉市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525246', '2013-07-30 15:40:52', '', '市辖区', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525247', '2013-07-30 15:40:52', '', '肃州区', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525248', '2013-07-30 15:40:52', '', '金塔县', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525249', '2013-07-30 15:40:52', '', '瓜州县', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525250', '2013-07-30 15:40:52', '', '肃北蒙古族自治县', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525251', '2013-07-30 15:40:52', '', '阿克塞哈萨克族自治县', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525252', '2013-07-30 15:40:52', '', '玉门市', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525253', '2013-07-30 15:40:53', '', '敦煌市', '2', '0', '4525245', '');
INSERT INTO `ezs_area` VALUES ('4525254', '2013-07-30 15:40:53', '', '庆阳市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525255', '2013-07-30 15:40:53', '', '市辖区', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525256', '2013-07-30 15:40:53', '', '西峰区', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525257', '2013-07-30 15:40:53', '', '庆城县', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525258', '2013-07-30 15:40:53', '', '环县', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525259', '2013-07-30 15:40:53', '', '华池县', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525260', '2013-07-30 15:40:53', '', '合水县', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525261', '2013-07-30 15:40:53', '', '正宁县', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525262', '2013-07-30 15:40:53', '', '宁县', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525263', '2013-07-30 15:40:54', '', '镇原县', '2', '0', '4525254', '');
INSERT INTO `ezs_area` VALUES ('4525264', '2013-07-30 15:40:54', '', '定西市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525265', '2013-07-30 15:40:54', '', '市辖区', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525266', '2013-07-30 15:40:54', '', '安定区', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525267', '2013-07-30 15:40:54', '', '通渭县', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525268', '2013-07-30 15:40:54', '', '陇西县', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525269', '2013-07-30 15:40:54', '', '渭源县', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525270', '2013-07-30 15:40:54', '', '临洮县', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525271', '2013-07-30 15:40:54', '', '漳县', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525272', '2013-07-30 15:40:54', '', '岷县', '2', '0', '4525264', '');
INSERT INTO `ezs_area` VALUES ('4525273', '2013-07-30 15:40:55', '', '陇南市', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525274', '2013-07-30 15:40:55', '', '市辖区', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525275', '2013-07-30 15:40:55', '', '武都区', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525276', '2013-07-30 15:40:55', '', '成县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525277', '2013-07-30 15:40:55', '', '文县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525278', '2013-07-30 15:40:55', '', '宕昌县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525279', '2013-07-30 15:40:55', '', '康县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525280', '2013-07-30 15:40:55', '', '西和县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525281', '2013-07-30 15:40:55', '', '礼县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525282', '2013-07-30 15:40:55', '', '徽县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525283', '2013-07-30 15:40:56', '', '两当县', '2', '0', '4525273', '');
INSERT INTO `ezs_area` VALUES ('4525284', '2013-07-30 15:40:56', '', '临夏回族自治州', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525285', '2013-07-30 15:40:56', '', '临夏市', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525286', '2013-07-30 15:40:56', '', '临夏县', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525287', '2013-07-30 15:40:56', '', '康乐县', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525288', '2013-07-30 15:40:56', '', '永靖县', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525289', '2013-07-30 15:40:56', '', '广河县', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525290', '2013-07-30 15:40:56', '', '和政县', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525291', '2013-07-30 15:40:56', '', '东乡族自治县', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525292', '2013-07-30 15:40:56', '', '积石山保安族东乡族撒拉族自治县', '2', '0', '4525284', '');
INSERT INTO `ezs_area` VALUES ('4525293', '2013-07-30 15:40:57', '', '甘南藏族自治州', '1', '0', '4525189', '');
INSERT INTO `ezs_area` VALUES ('4525294', '2013-07-30 15:40:57', '', '合作市', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525295', '2013-07-30 15:40:57', '', '临潭县', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525296', '2013-07-30 15:40:57', '', '卓尼县', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525297', '2013-07-30 15:40:57', '', '舟曲县', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525298', '2013-07-30 15:40:57', '', '迭部县', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525299', '2013-07-30 15:40:57', '', '玛曲县', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525300', '2013-07-30 15:40:57', '', '碌曲县', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525301', '2013-07-30 15:40:57', '', '夏河县', '2', '0', '4525293', '');
INSERT INTO `ezs_area` VALUES ('4525302', '2013-07-30 15:40:57', '', '青海省', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4525303', '2013-07-30 15:40:58', '', '西宁市', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525304', '2013-07-30 15:40:58', '', '市辖区', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525305', '2013-07-30 15:40:58', '', '城东区', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525306', '2013-07-30 15:40:58', '', '城中区', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525307', '2013-07-30 15:40:58', '', '城西区', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525308', '2013-07-30 15:40:58', '', '城北区', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525309', '2013-07-30 15:40:58', '', '大通回族土族自治县', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525310', '2013-07-30 15:40:58', '', '湟中县', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525311', '2013-07-30 15:40:58', '', '湟源县', '2', '0', '4525303', '');
INSERT INTO `ezs_area` VALUES ('4525312', '2013-07-30 15:40:58', '', '海东地区', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525313', '2013-07-30 15:40:59', '', '平安县', '2', '0', '4525312', '');
INSERT INTO `ezs_area` VALUES ('4525314', '2013-07-30 15:40:59', '', '民和回族土族自治县', '2', '0', '4525312', '');
INSERT INTO `ezs_area` VALUES ('4525315', '2013-07-30 15:40:59', '', '乐都县', '2', '0', '4525312', '');
INSERT INTO `ezs_area` VALUES ('4525316', '2013-07-30 15:40:59', '', '互助土族自治县', '2', '0', '4525312', '');
INSERT INTO `ezs_area` VALUES ('4525317', '2013-07-30 15:40:59', '', '化隆回族自治县', '2', '0', '4525312', '');
INSERT INTO `ezs_area` VALUES ('4525318', '2013-07-30 15:40:59', '', '循化撒拉族自治县', '2', '0', '4525312', '');
INSERT INTO `ezs_area` VALUES ('4525319', '2013-07-30 15:40:59', '', '海北藏族自治州', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525320', '2013-07-30 15:40:59', '', '门源回族自治县', '2', '0', '4525319', '');
INSERT INTO `ezs_area` VALUES ('4525321', '2013-07-30 15:40:59', '', '祁连县', '2', '0', '4525319', '');
INSERT INTO `ezs_area` VALUES ('4525322', '2013-07-30 15:40:59', '', '海晏县', '2', '0', '4525319', '');
INSERT INTO `ezs_area` VALUES ('4525323', '2013-07-30 15:41:00', '', '刚察县', '2', '0', '4525319', '');
INSERT INTO `ezs_area` VALUES ('4525324', '2013-07-30 15:41:00', '', '黄南藏族自治州', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525325', '2013-07-30 15:41:00', '', '同仁县', '2', '0', '4525324', '');
INSERT INTO `ezs_area` VALUES ('4525326', '2013-07-30 15:41:00', '', '尖扎县', '2', '0', '4525324', '');
INSERT INTO `ezs_area` VALUES ('4525327', '2013-07-30 15:41:00', '', '泽库县', '2', '0', '4525324', '');
INSERT INTO `ezs_area` VALUES ('4525328', '2013-07-30 15:41:00', '', '河南蒙古族自治县', '2', '0', '4525324', '');
INSERT INTO `ezs_area` VALUES ('4525329', '2013-07-30 15:41:00', '', '海南藏族自治州', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525330', '2013-07-30 15:41:00', '', '共和县', '2', '0', '4525329', '');
INSERT INTO `ezs_area` VALUES ('4525331', '2013-07-30 15:41:00', '', '同德县', '2', '0', '4525329', '');
INSERT INTO `ezs_area` VALUES ('4525332', '2013-07-30 15:41:00', '', '贵德县', '2', '0', '4525329', '');
INSERT INTO `ezs_area` VALUES ('4525333', '2013-07-30 15:41:01', '', '兴海县', '2', '0', '4525329', '');
INSERT INTO `ezs_area` VALUES ('4525334', '2013-07-30 15:41:01', '', '贵南县', '2', '0', '4525329', '');
INSERT INTO `ezs_area` VALUES ('4525335', '2013-07-30 15:41:01', '', '果洛藏族自治州', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525336', '2013-07-30 15:41:01', '', '玛沁县', '2', '0', '4525335', '');
INSERT INTO `ezs_area` VALUES ('4525337', '2013-07-30 15:41:01', '', '班玛县', '2', '0', '4525335', '');
INSERT INTO `ezs_area` VALUES ('4525338', '2013-07-30 15:41:01', '', '甘德县', '2', '0', '4525335', '');
INSERT INTO `ezs_area` VALUES ('4525339', '2013-07-30 15:41:01', '', '达日县', '2', '0', '4525335', '');
INSERT INTO `ezs_area` VALUES ('4525340', '2013-07-30 15:41:01', '', '久治县', '2', '0', '4525335', '');
INSERT INTO `ezs_area` VALUES ('4525341', '2013-07-30 15:41:01', '', '玛多县', '2', '0', '4525335', '');
INSERT INTO `ezs_area` VALUES ('4525342', '2013-07-30 15:41:01', '', '玉树藏族自治州', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525343', '2013-07-30 15:41:01', '', '玉树县', '2', '0', '4525342', '');
INSERT INTO `ezs_area` VALUES ('4525344', '2013-07-30 15:41:02', '', '杂多县', '2', '0', '4525342', '');
INSERT INTO `ezs_area` VALUES ('4525345', '2013-07-30 15:41:02', '', '称多县', '2', '0', '4525342', '');
INSERT INTO `ezs_area` VALUES ('4525346', '2013-07-30 15:41:02', '', '治多县', '2', '0', '4525342', '');
INSERT INTO `ezs_area` VALUES ('4525347', '2013-07-30 15:41:02', '', '囊谦县', '2', '0', '4525342', '');
INSERT INTO `ezs_area` VALUES ('4525348', '2013-07-30 15:41:02', '', '曲麻莱县', '2', '0', '4525342', '');
INSERT INTO `ezs_area` VALUES ('4525349', '2013-07-30 15:41:02', '', '海西蒙古族藏族自治州', '1', '0', '4525302', '');
INSERT INTO `ezs_area` VALUES ('4525350', '2013-07-30 15:41:02', '', '格尔木市', '2', '0', '4525349', '');
INSERT INTO `ezs_area` VALUES ('4525351', '2013-07-30 15:41:02', '', '德令哈市', '2', '0', '4525349', '');
INSERT INTO `ezs_area` VALUES ('4525352', '2013-07-30 15:41:02', '', '乌兰县', '2', '0', '4525349', '');
INSERT INTO `ezs_area` VALUES ('4525353', '2013-07-30 15:41:02', '', '都兰县', '2', '0', '4525349', '');
INSERT INTO `ezs_area` VALUES ('4525354', '2013-07-30 15:41:03', '', '天峻县', '2', '0', '4525349', '');
INSERT INTO `ezs_area` VALUES ('4525355', '2013-07-30 15:41:03', '', '宁夏回族自治区', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4525356', '2013-07-30 15:41:03', '', '银川市', '1', '0', '4525355', '');
INSERT INTO `ezs_area` VALUES ('4525357', '2013-07-30 15:41:03', '', '市辖区', '2', '0', '4525356', '');
INSERT INTO `ezs_area` VALUES ('4525358', '2013-07-30 15:41:03', '', '兴庆区', '2', '0', '4525356', '');
INSERT INTO `ezs_area` VALUES ('4525359', '2013-07-30 15:41:03', '', '西夏区', '2', '0', '4525356', '');
INSERT INTO `ezs_area` VALUES ('4525360', '2013-07-30 15:41:03', '', '金凤区', '2', '0', '4525356', '');
INSERT INTO `ezs_area` VALUES ('4525361', '2013-07-30 15:41:03', '', '永宁县', '2', '0', '4525356', '');
INSERT INTO `ezs_area` VALUES ('4525362', '2013-07-30 15:41:03', '', '贺兰县', '2', '0', '4525356', '');
INSERT INTO `ezs_area` VALUES ('4525363', '2013-07-30 15:41:04', '', '灵武市', '2', '0', '4525356', '');
INSERT INTO `ezs_area` VALUES ('4525364', '2013-07-30 15:41:04', '', '石嘴山市', '1', '0', '4525355', '');
INSERT INTO `ezs_area` VALUES ('4525365', '2013-07-30 15:41:04', '', '市辖区', '2', '0', '4525364', '');
INSERT INTO `ezs_area` VALUES ('4525366', '2013-07-30 15:41:04', '', '大武口区', '2', '0', '4525364', '');
INSERT INTO `ezs_area` VALUES ('4525367', '2013-07-30 15:41:04', '', '惠农区', '2', '0', '4525364', '');
INSERT INTO `ezs_area` VALUES ('4525368', '2013-07-30 15:41:04', '', '平罗县', '2', '0', '4525364', '');
INSERT INTO `ezs_area` VALUES ('4525369', '2013-07-30 15:41:04', '', '吴忠市', '1', '0', '4525355', '');
INSERT INTO `ezs_area` VALUES ('4525370', '2013-07-30 15:41:04', '', '市辖区', '2', '0', '4525369', '');
INSERT INTO `ezs_area` VALUES ('4525371', '2013-07-30 15:41:04', '', '利通区', '2', '0', '4525369', '');
INSERT INTO `ezs_area` VALUES ('4525372', '2013-07-30 15:41:04', '', '红寺堡区', '2', '0', '4525369', '');
INSERT INTO `ezs_area` VALUES ('4525373', '2013-07-30 15:41:05', '', '盐池县', '2', '0', '4525369', '');
INSERT INTO `ezs_area` VALUES ('4525374', '2013-07-30 15:41:05', '', '同心县', '2', '0', '4525369', '');
INSERT INTO `ezs_area` VALUES ('4525375', '2013-07-30 15:41:05', '', '青铜峡市', '2', '0', '4525369', '');
INSERT INTO `ezs_area` VALUES ('4525376', '2013-07-30 15:41:05', '', '固原市', '1', '0', '4525355', '');
INSERT INTO `ezs_area` VALUES ('4525377', '2013-07-30 15:41:05', '', '市辖区', '2', '0', '4525376', '');
INSERT INTO `ezs_area` VALUES ('4525378', '2013-07-30 15:41:05', '', '原州区', '2', '0', '4525376', '');
INSERT INTO `ezs_area` VALUES ('4525379', '2013-07-30 15:41:05', '', '西吉县', '2', '0', '4525376', '');
INSERT INTO `ezs_area` VALUES ('4525380', '2013-07-30 15:41:05', '', '隆德县', '2', '0', '4525376', '');
INSERT INTO `ezs_area` VALUES ('4525381', '2013-07-30 15:41:05', '', '泾源县', '2', '0', '4525376', '');
INSERT INTO `ezs_area` VALUES ('4525382', '2013-07-30 15:41:06', '', '彭阳县', '2', '0', '4525376', '');
INSERT INTO `ezs_area` VALUES ('4525383', '2013-07-30 15:41:06', '', '中卫市', '1', '0', '4525355', '');
INSERT INTO `ezs_area` VALUES ('4525384', '2013-07-30 15:41:06', '', '市辖区', '2', '0', '4525383', '');
INSERT INTO `ezs_area` VALUES ('4525385', '2013-07-30 15:41:06', '', '沙坡头区', '2', '0', '4525383', '');
INSERT INTO `ezs_area` VALUES ('4525386', '2013-07-30 15:41:06', '', '中宁县', '2', '0', '4525383', '');
INSERT INTO `ezs_area` VALUES ('4525387', '2013-07-30 15:41:06', '', '海原县', '2', '0', '4525383', '');
INSERT INTO `ezs_area` VALUES ('4525388', '2013-07-30 15:41:06', '', '新疆维吾尔自治区', '0', '0', null, '');
INSERT INTO `ezs_area` VALUES ('4525389', '2013-07-30 15:41:06', '', '乌鲁木齐市', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525390', '2013-07-30 15:41:06', '', '市辖区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525391', '2013-07-30 15:41:06', '', '天山区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525392', '2013-07-30 15:41:07', '', '沙依巴克区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525393', '2013-07-30 15:41:07', '', '新市区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525394', '2013-07-30 15:41:07', '', '水磨沟区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525395', '2013-07-30 15:41:07', '', '头屯河区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525396', '2013-07-30 15:41:07', '', '达坂城区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525397', '2013-07-30 15:41:07', '', '米东区', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525398', '2013-07-30 15:41:07', '', '乌鲁木齐县', '2', '0', '4525389', '');
INSERT INTO `ezs_area` VALUES ('4525399', '2013-07-30 15:41:07', '', '克拉玛依市', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525400', '2013-07-30 15:41:07', '', '市辖区', '2', '0', '4525399', '');
INSERT INTO `ezs_area` VALUES ('4525401', '2013-07-30 15:41:07', '', '独山子区', '2', '0', '4525399', '');
INSERT INTO `ezs_area` VALUES ('4525402', '2013-07-30 15:41:08', '', '克拉玛依区', '2', '0', '4525399', '');
INSERT INTO `ezs_area` VALUES ('4525403', '2013-07-30 15:41:08', '', '白碱滩区', '2', '0', '4525399', '');
INSERT INTO `ezs_area` VALUES ('4525404', '2013-07-30 15:41:08', '', '乌尔禾区', '2', '0', '4525399', '');
INSERT INTO `ezs_area` VALUES ('4525405', '2013-07-30 15:41:08', '', '吐鲁番地区', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525406', '2013-07-30 15:41:08', '', '吐鲁番市', '2', '0', '4525405', '');
INSERT INTO `ezs_area` VALUES ('4525407', '2013-07-30 15:41:08', '', '鄯善县', '2', '0', '4525405', '');
INSERT INTO `ezs_area` VALUES ('4525408', '2013-07-30 15:41:08', '', '托克逊县', '2', '0', '4525405', '');
INSERT INTO `ezs_area` VALUES ('4525409', '2013-07-30 15:41:08', '', '哈密地区', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525410', '2013-07-30 15:41:08', '', '哈密市', '2', '0', '4525409', '');
INSERT INTO `ezs_area` VALUES ('4525411', '2013-07-30 15:41:08', '', '巴里坤哈萨克自治县', '2', '0', '4525409', '');
INSERT INTO `ezs_area` VALUES ('4525412', '2013-07-30 15:41:09', '', '伊吾县', '2', '0', '4525409', '');
INSERT INTO `ezs_area` VALUES ('4525413', '2013-07-30 15:41:09', '', '昌吉回族自治州', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525414', '2013-07-30 15:41:09', '', '昌吉市', '2', '0', '4525413', '');
INSERT INTO `ezs_area` VALUES ('4525415', '2013-07-30 15:41:09', '', '阜康市', '2', '0', '4525413', '');
INSERT INTO `ezs_area` VALUES ('4525416', '2013-07-30 15:41:09', '', '呼图壁县', '2', '0', '4525413', '');
INSERT INTO `ezs_area` VALUES ('4525417', '2013-07-30 15:41:09', '', '玛纳斯县', '2', '0', '4525413', '');
INSERT INTO `ezs_area` VALUES ('4525418', '2013-07-30 15:41:09', '', '奇台县', '2', '0', '4525413', '');
INSERT INTO `ezs_area` VALUES ('4525419', '2013-07-30 15:41:09', '', '吉木萨尔县', '2', '0', '4525413', '');
INSERT INTO `ezs_area` VALUES ('4525420', '2013-07-30 15:41:09', '', '木垒哈萨克自治县', '2', '0', '4525413', '');
INSERT INTO `ezs_area` VALUES ('4525421', '2013-07-30 15:41:09', '', '博尔塔拉蒙古自治州', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525422', '2013-07-30 15:41:10', '', '博乐市', '2', '0', '4525421', '');
INSERT INTO `ezs_area` VALUES ('4525423', '2013-07-30 15:41:10', '', '精河县', '2', '0', '4525421', '');
INSERT INTO `ezs_area` VALUES ('4525424', '2013-07-30 15:41:10', '', '温泉县', '2', '0', '4525421', '');
INSERT INTO `ezs_area` VALUES ('4525425', '2013-07-30 15:41:10', '', '巴音郭楞蒙古自治州', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525426', '2013-07-30 15:41:10', '', '库尔勒市', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525427', '2013-07-30 15:41:10', '', '轮台县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525428', '2013-07-30 15:41:10', '', '尉犁县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525429', '2013-07-30 15:41:10', '', '若羌县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525430', '2013-07-30 15:41:10', '', '且末县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525431', '2013-07-30 15:41:11', '', '焉耆回族自治县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525432', '2013-07-30 15:41:11', '', '和静县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525433', '2013-07-30 15:41:11', '', '和硕县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525434', '2013-07-30 15:41:11', '', '博湖县', '2', '0', '4525425', '');
INSERT INTO `ezs_area` VALUES ('4525435', '2013-07-30 15:41:11', '', '阿克苏地区', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525436', '2013-07-30 15:41:11', '', '阿克苏市', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525437', '2013-07-30 15:41:11', '', '温宿县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525438', '2013-07-30 15:41:11', '', '库车县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525439', '2013-07-30 15:41:11', '', '沙雅县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525440', '2013-07-30 15:41:11', '', '新和县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525441', '2013-07-30 15:41:12', '', '拜城县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525442', '2013-07-30 15:41:12', '', '乌什县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525443', '2013-07-30 15:41:12', '', '阿瓦提县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525444', '2013-07-30 15:41:12', '', '柯坪县', '2', '0', '4525435', '');
INSERT INTO `ezs_area` VALUES ('4525445', '2013-07-30 15:41:12', '', '克孜勒苏柯尔克孜自治州', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525446', '2013-07-30 15:41:12', '', '阿图什市', '2', '0', '4525445', '');
INSERT INTO `ezs_area` VALUES ('4525447', '2013-07-30 15:41:12', '', '阿克陶县', '2', '0', '4525445', '');
INSERT INTO `ezs_area` VALUES ('4525448', '2013-07-30 15:41:12', '', '阿合奇县', '2', '0', '4525445', '');
INSERT INTO `ezs_area` VALUES ('4525449', '2013-07-30 15:41:12', '', '乌恰县', '2', '0', '4525445', '');
INSERT INTO `ezs_area` VALUES ('4525450', '2013-07-30 15:41:13', '', '喀什地区', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525451', '2013-07-30 15:41:13', '', '喀什市', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525452', '2013-07-30 15:41:13', '', '疏附县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525453', '2013-07-30 15:41:13', '', '疏勒县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525454', '2013-07-30 15:41:13', '', '英吉沙县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525455', '2013-07-30 15:41:13', '', '泽普县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525456', '2013-07-30 15:41:13', '', '莎车县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525457', '2013-07-30 15:41:13', '', '叶城县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525458', '2013-07-30 15:41:13', '', '麦盖提县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525459', '2013-07-30 15:41:13', '', '岳普湖县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525460', '2013-07-30 15:41:14', '', '伽师县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525461', '2013-07-30 15:41:14', '', '巴楚县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525462', '2013-07-30 15:41:14', '', '塔什库尔干塔吉克自治县', '2', '0', '4525450', '');
INSERT INTO `ezs_area` VALUES ('4525463', '2013-07-30 15:41:14', '', '和田地区', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525464', '2013-07-30 15:41:14', '', '和田市', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525465', '2013-07-30 15:41:14', '', '和田县', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525466', '2013-07-30 15:41:14', '', '墨玉县', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525467', '2013-07-30 15:41:14', '', '皮山县', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525468', '2013-07-30 15:41:14', '', '洛浦县', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525469', '2013-07-30 15:41:14', '', '策勒县', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525470', '2013-07-30 15:41:15', '', '于田县', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525471', '2013-07-30 15:41:15', '', '民丰县', '2', '0', '4525463', '');
INSERT INTO `ezs_area` VALUES ('4525472', '2013-07-30 15:41:15', '', '伊犁哈萨克自治州', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525473', '2013-07-30 15:41:15', '', '伊宁市', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525474', '2013-07-30 15:41:15', '', '奎屯市', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525475', '2013-07-30 15:41:15', '', '伊宁县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525476', '2013-07-30 15:41:15', '', '察布查尔锡伯自治县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525477', '2013-07-30 15:41:15', '', '霍城县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525478', '2013-07-30 15:41:15', '', '巩留县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525479', '2013-07-30 15:41:16', '', '新源县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525480', '2013-07-30 15:41:16', '', '昭苏县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525481', '2013-07-30 15:41:16', '', '特克斯县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525482', '2013-07-30 15:41:16', '', '尼勒克县', '2', '0', '4525472', '');
INSERT INTO `ezs_area` VALUES ('4525483', '2013-07-30 15:41:16', '', '塔城地区', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525484', '2013-07-30 15:41:16', '', '塔城市', '2', '0', '4525483', '');
INSERT INTO `ezs_area` VALUES ('4525485', '2013-07-30 15:41:16', '', '乌苏市', '2', '0', '4525483', '');
INSERT INTO `ezs_area` VALUES ('4525486', '2013-07-30 15:41:16', '', '额敏县', '2', '0', '4525483', '');
INSERT INTO `ezs_area` VALUES ('4525487', '2013-07-30 15:41:16', '', '沙湾县', '2', '0', '4525483', '');
INSERT INTO `ezs_area` VALUES ('4525488', '2013-07-30 15:41:17', '', '托里县', '2', '0', '4525483', '');
INSERT INTO `ezs_area` VALUES ('4525489', '2013-07-30 15:41:17', '', '裕民县', '2', '0', '4525483', '');
INSERT INTO `ezs_area` VALUES ('4525490', '2013-07-30 15:41:17', '', '和布克赛尔蒙古自治县', '2', '0', '4525483', '');
INSERT INTO `ezs_area` VALUES ('4525491', '2013-07-30 15:41:17', '', '阿勒泰地区', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525492', '2013-07-30 15:41:17', '', '阿勒泰市', '2', '0', '4525491', '');
INSERT INTO `ezs_area` VALUES ('4525493', '2013-07-30 15:41:17', '', '布尔津县', '2', '0', '4525491', '');
INSERT INTO `ezs_area` VALUES ('4525494', '2013-07-30 15:41:17', '', '富蕴县', '2', '0', '4525491', '');
INSERT INTO `ezs_area` VALUES ('4525495', '2013-07-30 15:41:17', '', '福海县', '2', '0', '4525491', '');
INSERT INTO `ezs_area` VALUES ('4525496', '2013-07-30 15:41:17', '', '哈巴河县', '2', '0', '4525491', '');
INSERT INTO `ezs_area` VALUES ('4525497', '2013-07-30 15:41:17', '', '青河县', '2', '0', '4525491', '');
INSERT INTO `ezs_area` VALUES ('4525498', '2013-07-30 15:41:18', '', '吉木乃县', '2', '0', '4525491', '');
INSERT INTO `ezs_area` VALUES ('4525499', '2013-07-30 15:41:18', '', '自治区直辖县级行政区划', '1', '0', '4525388', '');
INSERT INTO `ezs_area` VALUES ('4525500', '2013-07-30 15:41:18', '', '石河子市', '2', '0', '4525499', '');
INSERT INTO `ezs_area` VALUES ('4525501', '2013-07-30 15:41:18', '', '阿拉尔市', '2', '0', '4525499', '');
INSERT INTO `ezs_area` VALUES ('4525502', '2013-07-30 15:41:18', '', '图木舒克市', '2', '0', '4525499', '');
INSERT INTO `ezs_area` VALUES ('4525503', '2013-07-30 15:41:18', '', '五家渠市', '2', '0', '4525499', '');

-- ----------------------------
-- Table structure for `ezs_card_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_card_dict`;
CREATE TABLE `ezs_card_dict` (
  `store_id` bigint(20) NOT NULL,
  `accessory_id` bigint(20) NOT NULL,
  KEY `FK3FB55AE449476E7A` (`accessory_id`),
  KEY `FK3FB55AE4F9DFE81A` (`store_id`),
  KEY `FK3FB55AE480F4250C` (`accessory_id`),
  KEY `FK3FB55AE46582B7AC` (`store_id`),
  CONSTRAINT `FK3FB55AE449476E7A` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3FB55AE46582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FK3FB55AE480F4250C` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3FB55AE4F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_card_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_classify`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_classify`;
CREATE TABLE `ezs_classify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarkValue` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `re_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKE9BC4B45E9E24AD5` (`re_id`),
  CONSTRAINT `FKE9BC4B45E9E24AD5` FOREIGN KEY (`re_id`) REFERENCES `ezs_remark` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_classify
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_column`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_column`;
CREATE TABLE `ezs_column` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `accessPath` varchar(255) DEFAULT NULL,
  `attribute` int(11) DEFAULT '0',
  `browsePower` int(11) DEFAULT '0',
  `colTemplate` varchar(255) DEFAULT NULL,
  `columnLevel` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `examine` int(11) DEFAULT '0',
  `finalSection` varchar(255) DEFAULT NULL,
  `keyWord` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderid` int(11) DEFAULT '0',
  `phoTemplate` varchar(255) DEFAULT NULL,
  `prepareColumn` varchar(255) DEFAULT NULL,
  `reveal` bit(1) NOT NULL,
  `review` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `window` bit(1) NOT NULL,
  `parentEzsColumn_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK46C80576647DF96` (`parentEzsColumn_id`),
  KEY `FK46C8057F734E208` (`user_id`),
  CONSTRAINT `FK46C8057F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK46C80576647DF96` FOREIGN KEY (`parentEzsColumn_id`) REFERENCES `ezs_column` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_column
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_comment`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_comment`;
CREATE TABLE `ezs_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `intention` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `priceTrend_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK892DE17E5FB0FAC8` (`priceTrend_id`),
  KEY `FK892DE17EF734E208` (`user_id`),
  CONSTRAINT `FK892DE17EF734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK892DE17E5FB0FAC8` FOREIGN KEY (`priceTrend_id`) REFERENCES `ezs_price_trend` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_contact`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_contact`;
CREATE TABLE `ezs_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `depart` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK893F173F43969C9A` (`area_id`),
  KEY `FK893F173FD37292C8` (`area_id`),
  CONSTRAINT `FK893F173F43969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`),
  CONSTRAINT `FK893F173FD37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_customer`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_customer`;
CREATE TABLE `ezs_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `admin_status` int(11) NOT NULL,
  `bill` bit(1) NOT NULL,
  `clean_ability` varchar(255) DEFAULT NULL,
  `clean_num` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `crusher_ability` varchar(255) DEFAULT NULL,
  `crusher_num` varchar(255) DEFAULT NULL,
  `cus_status` int(11) NOT NULL,
  `enable` bit(1) NOT NULL,
  `granulation_ability` varchar(255) DEFAULT NULL,
  `granulation_num` varchar(255) DEFAULT NULL,
  `haveDevice` varchar(255) DEFAULT NULL,
  `hz_truck_ability` varchar(255) DEFAULT NULL,
  `hz_truck_ability1` varchar(255) DEFAULT NULL,
  `hz_truck_lxr` varchar(255) DEFAULT NULL,
  `hz_truck_lxr1` varchar(255) DEFAULT NULL,
  `hz_truck_tel` varchar(255) DEFAULT NULL,
  `hz_truck_tel1` varchar(255) DEFAULT NULL,
  `importDate` datetime DEFAULT NULL,
  `mainDody` int(11) NOT NULL,
  `mianIndustry` varchar(255) DEFAULT NULL,
  `mold_ability` varchar(255) DEFAULT NULL,
  `mold_num` varchar(255) DEFAULT NULL,
  `point` double NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `sewage` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `testDevice` varchar(255) DEFAULT NULL,
  `truck_load` varchar(255) DEFAULT NULL,
  `truck_num` varchar(255) DEFAULT NULL,
  `truck_uninstall` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `level_id` bigint(20) DEFAULT NULL,
  `paper_id` bigint(20) DEFAULT NULL,
  `source_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKE497F09F77BF49DA` (`source_id`),
  KEY `FKE497F09F43969C9A` (`area_id`),
  KEY `FKE497F09FB2B98264` (`paper_id`),
  KEY `FKE497F09FB10A9B5A` (`group_id`),
  KEY `FKE497F09F140EC13A` (`level_id`),
  KEY `FKE497F09F80766C88` (`source_id`),
  KEY `FKE497F09FD37292C8` (`area_id`),
  KEY `FKE497F09F42957892` (`paper_id`),
  KEY `FKE497F09F1CAD6AEC` (`group_id`),
  KEY `FKE497F09F7FB190CC` (`level_id`),
  CONSTRAINT `FKE497F09F140EC13A` FOREIGN KEY (`level_id`) REFERENCES `ezs_level` (`id`),
  CONSTRAINT `FKE497F09F1CAD6AEC` FOREIGN KEY (`group_id`) REFERENCES `ezs_group` (`id`),
  CONSTRAINT `FKE497F09F42957892` FOREIGN KEY (`paper_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKE497F09F43969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`),
  CONSTRAINT `FKE497F09F77BF49DA` FOREIGN KEY (`source_id`) REFERENCES `ezs_source` (`id`),
  CONSTRAINT `FKE497F09F7FB190CC` FOREIGN KEY (`level_id`) REFERENCES `ezs_level` (`id`),
  CONSTRAINT `FKE497F09F80766C88` FOREIGN KEY (`source_id`) REFERENCES `ezs_source` (`id`),
  CONSTRAINT `FKE497F09FB10A9B5A` FOREIGN KEY (`group_id`) REFERENCES `ezs_group` (`id`),
  CONSTRAINT `FKE497F09FB2B98264` FOREIGN KEY (`paper_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKE497F09FD37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_customer_paper`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_customer_paper`;
CREATE TABLE `ezs_customer_paper` (
  `cus_id` bigint(20) NOT NULL,
  `paper_id` bigint(20) NOT NULL,
  KEY `FK325731ECF5C5CDB7` (`cus_id`),
  KEY `FK325731ECD5F6A43A` (`paper_id`),
  KEY `FK325731ECAD3EFCE5` (`cus_id`),
  KEY `FK325731EC419973CC` (`paper_id`),
  CONSTRAINT `FK325731EC419973CC` FOREIGN KEY (`paper_id`) REFERENCES `ezs_paper` (`id`),
  CONSTRAINT `FK325731ECAD3EFCE5` FOREIGN KEY (`cus_id`) REFERENCES `ezs_customer` (`id`),
  CONSTRAINT `FK325731ECD5F6A43A` FOREIGN KEY (`paper_id`) REFERENCES `ezs_paper` (`id`),
  CONSTRAINT `FK325731ECF5C5CDB7` FOREIGN KEY (`cus_id`) REFERENCES `ezs_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_customer_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_depart`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_depart`;
CREATE TABLE `ezs_depart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK595F4F53E398AC4` (`parent_id`),
  KEY `FK595F4F5F9DFE81A` (`store_id`),
  KEY `FK595F4F546F0AD72` (`parent_id`),
  KEY `FK595F4F56582B7AC` (`store_id`),
  CONSTRAINT `FK595F4F53E398AC4` FOREIGN KEY (`parent_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FK595F4F546F0AD72` FOREIGN KEY (`parent_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FK595F4F56582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FK595F4F5F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_depart
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_dict`;
CREATE TABLE `ezs_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFB3604F7EB7CCE86` (`parent_id`),
  KEY `FKFB3604F77B58C4B4` (`parent_id`),
  CONSTRAINT `FKFB3604F77B58C4B4` FOREIGN KEY (`parent_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKFB3604F7EB7CCE86` FOREIGN KEY (`parent_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_dict
-- ----------------------------
INSERT INTO `ezs_dict` VALUES ('1', '2018-03-26 13:09:44', '', 'EZS_COLOR', null, '颜色', '1', null);
INSERT INTO `ezs_dict` VALUES ('2', '2018-03-26 13:10:54', '', 'EZS_COLOR_COLOR', null, '本色', '1', '1');
INSERT INTO `ezs_dict` VALUES ('3', '2018-03-26 13:14:18', '', 'EZS_COLOR_WHITE', null, '白色', '2', '1');
INSERT INTO `ezs_dict` VALUES ('4', '2018-03-26 13:15:35', '', 'EZS_COLOR_BLACK', null, '黑色', '3', '1');
INSERT INTO `ezs_dict` VALUES ('5', '2018-03-26 13:16:50', '', 'EZS_COLOR_GRAY', null, '灰色', '4', '1');
INSERT INTO `ezs_dict` VALUES ('6', '2018-03-26 13:18:32', '', 'EZS_COLOR_RED', null, '红色', '5', '1');
INSERT INTO `ezs_dict` VALUES ('7', '2018-03-26 13:18:59', '', 'EZS_COLOR_YELLOW', null, '黄色', '6', '1');
INSERT INTO `ezs_dict` VALUES ('8', '2018-03-26 13:19:47', '', 'EZS_COLOR_VARIEGATED', null, '杂色', '7', '1');
INSERT INTO `ezs_dict` VALUES ('9', '2018-03-26 13:20:59', '', 'EZS_COLOR_TRANSPARENT', null, '透明', '8', '1');
INSERT INTO `ezs_dict` VALUES ('10', '2018-03-26 13:21:41', '', 'EZS_COLOR_SEM_TRANSPARENT', null, '半透', '9', '1');
INSERT INTO `ezs_dict` VALUES ('11', '2018-03-26 13:22:32', '', 'EZS_COLOR_GREEN', null, '绿色', '10', '1');
INSERT INTO `ezs_dict` VALUES ('12', '2018-03-26 13:23:20', '', 'EZS_COLOR_BLUE', null, '蓝色', '11', '1');
INSERT INTO `ezs_dict` VALUES ('13', '2018-03-26 13:24:06', '', 'EZS_COLOR_ORANGE', null, '橙色', '12', '1');
INSERT INTO `ezs_dict` VALUES ('14', '2018-03-26 13:24:57', '', 'EZS_COLOR_VIOLET', null, '紫色', '13', '1');
INSERT INTO `ezs_dict` VALUES ('15', '2018-03-26 13:25:44', '', 'EZS_COLOR_OTHER', null, '其他', '14', '1');
INSERT INTO `ezs_dict` VALUES ('16', '2018-03-26 13:51:47', '', 'EZS_FORM', null, '形态', '2', null);
INSERT INTO `ezs_dict` VALUES ('17', '2018-03-26 13:52:16', '', 'EZS_FORM_GRAIN', null, '颗粒', '1', '16');
INSERT INTO `ezs_dict` VALUES ('18', '2018-03-26 13:53:23', '', 'EZS_FORM_FLAKE', null, '片状', '2', '16');
INSERT INTO `ezs_dict` VALUES ('19', '2018-03-26 13:54:09', '', 'EZS_FORM_POWDERY', null, '薄膜状', '3', '16');
INSERT INTO `ezs_dict` VALUES ('20', '2018-03-26 13:54:58', '', 'EZS_FORM_OTHER', null, '其他', '4', '16');
INSERT INTO `ezs_dict` VALUES ('21', '2018-03-26 14:28:51', '', 'EZS_UTIL', null, '单位', '3', null);
INSERT INTO `ezs_dict` VALUES ('22', '2018-03-26 14:29:43', '', 'EZS_UTIL_QK', null, '千克', '1', '21');
INSERT INTO `ezs_dict` VALUES ('23', '2018-03-26 14:30:31', '', 'EZS_UTIL_TON', null, '吨', '2', '21');
INSERT INTO `ezs_dict` VALUES ('24', '2018-03-26 16:27:16', '', 'EZS_LOGISTICS', null, '物流方式', '4', null);
INSERT INTO `ezs_dict` VALUES ('25', '2018-03-26 16:28:03', '', 'EZS_LOGISTICS_DOOR', null, '送货上门', '0', '24');

-- ----------------------------
-- Table structure for `ezs_documentshare`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_documentshare`;
CREATE TABLE `ezs_documentshare` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `give` int(11) NOT NULL,
  `house` int(11) NOT NULL,
  `e_id` bigint(20) DEFAULT NULL,
  `u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKDF39E76330951E` (`u_id`),
  KEY `FKDF39E763A6D17A15` (`e_id`),
  CONSTRAINT `FKDF39E763A6D17A15` FOREIGN KEY (`e_id`) REFERENCES `ezs_ezssubstance` (`id`),
  CONSTRAINT `FKDF39E76330951E` FOREIGN KEY (`u_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_documentshare
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_ezssubstance`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_ezssubstance`;
CREATE TABLE `ezs_ezssubstance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `attribute` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `bold` bit(1) NOT NULL,
  `clickLike` int(11) NOT NULL,
  `clickRate` int(11) NOT NULL,
  `clickRrample` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `fixedTime` varchar(255) DEFAULT NULL,
  `keyWord` varchar(255) DEFAULT NULL,
  `linkPort` bit(1) NOT NULL,
  `linkUrl` varchar(255) DEFAULT NULL,
  `meta` varchar(255) DEFAULT NULL,
  `multimediaFiles` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `originUrl` varchar(255) DEFAULT NULL,
  `pcView` bit(1) NOT NULL,
  `photos` varchar(255) DEFAULT NULL,
  `publicTime` date DEFAULT NULL,
  `remarkValue` varchar(255) DEFAULT NULL,
  `staticStatus` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `subheading` varchar(255) DEFAULT NULL,
  `tagTitle` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `titleColor` varchar(255) DEFAULT NULL,
  `childEc_id` bigint(20) DEFAULT NULL,
  `ec_id` bigint(20) DEFAULT NULL,
  `ss_id` bigint(20) DEFAULT NULL,
  `u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK1C794CF3E9A6883B` (`ss_id`),
  KEY `FK1C794CF3997E2842` (`ec_id`),
  KEY `FK1C794CF3E4D304A6` (`childEc_id`),
  KEY `FK1C794CF330951E` (`u_id`),
  CONSTRAINT `FK1C794CF330951E` FOREIGN KEY (`u_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK1C794CF3997E2842` FOREIGN KEY (`ec_id`) REFERENCES `ezs_column` (`id`),
  CONSTRAINT `FK1C794CF3E4D304A6` FOREIGN KEY (`childEc_id`) REFERENCES `ezs_column` (`id`),
  CONSTRAINT `FK1C794CF3E9A6883B` FOREIGN KEY (`ss_id`) REFERENCES `ezs_specialsubject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_ezssubstance
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_financial_service_loans`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_financial_service_loans`;
CREATE TABLE `ezs_financial_service_loans` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `applyType` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `contacts` varchar(255) DEFAULT NULL,
  `loanAmount` decimal(19,2) DEFAULT NULL,
  `mainBusiness` varchar(255) DEFAULT NULL,
  `telNum` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK93CDC762F734E208` (`user_id`),
  CONSTRAINT `FK93CDC762F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_financial_service_loans
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_goods`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goods`;
CREATE TABLE `ezs_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `addess` varchar(255) DEFAULT NULL,
  `ash` varchar(255) DEFAULT NULL,
  `bending` varchar(255) DEFAULT NULL,
  `burning` varchar(255) DEFAULT NULL,
  `cantilever` varchar(255) DEFAULT NULL,
  `click` int(11) NOT NULL,
  `cncl_num` double NOT NULL,
  `collect` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `crack` varchar(255) DEFAULT NULL,
  `density` varchar(255) DEFAULT NULL,
  `flexural` varchar(255) DEFAULT NULL,
  `freely` varchar(255) DEFAULT NULL,
  `good_no` varchar(255) DEFAULT NULL,
  `goods_salenum` int(11) NOT NULL,
  `inventory` double NOT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `lipolysis` varchar(255) DEFAULT NULL,
  `memberLook` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `protection` bit(1) NOT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `recommend` bit(1) NOT NULL,
  `recommend_time` datetime DEFAULT NULL,
  `seo_description` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `tensile` varchar(255) DEFAULT NULL,
  `validity` int(11) NOT NULL,
  `water` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `color_id` bigint(20) DEFAULT NULL,
  `form_id` bigint(20) DEFAULT NULL,
  `goodClass_id` bigint(20) DEFAULT NULL,
  `goods_main_photo_id` bigint(20) DEFAULT NULL,
  `logistics_id` bigint(20) DEFAULT NULL,
  `quality_id` bigint(20) DEFAULT NULL,
  `region_id` bigint(20) DEFAULT NULL,
  `supply_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `util_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6BB7C63543969C9A` (`area_id`),
  KEY `FK6BB7C635B31F187D` (`logistics_id`),
  KEY `FK6BB7C6351CD911F7` (`goods_main_photo_id`),
  KEY `FK6BB7C63560A50B5A` (`quality_id`),
  KEY `FK6BB7C63547B51C2C` (`form_id`),
  KEY `FK6BB7C635693B882E` (`util_id`),
  KEY `FK6BB7C6356758EBDA` (`user_id`),
  KEY `FK6BB7C63517B67DBA` (`goodClass_id`),
  KEY `FK6BB7C635748358D3` (`region_id`),
  KEY `FK6BB7C6354A9B012D` (`color_id`),
  KEY `FK6BB7C6356EC08C21` (`supply_id`),
  KEY `FK6BB7C635D37292C8` (`area_id`),
  KEY `FK6BB7C63542FB0EAB` (`logistics_id`),
  KEY `FK6BB7C6355485C889` (`goods_main_photo_id`),
  KEY `FK6BB7C6356ED23E6C` (`quality_id`),
  KEY `FK6BB7C635D791125A` (`form_id`),
  KEY `FK6BB7C635F9177E5C` (`util_id`),
  KEY `FK6BB7C635F734E208` (`user_id`),
  KEY `FK6BB7C6354F63344C` (`goodClass_id`),
  KEY `FK6BB7C63545F4F01` (`region_id`),
  KEY `FK6BB7C635DA76F75B` (`color_id`),
  KEY `FK6BB7C635FE9C824F` (`supply_id`),
  KEY `FK6BB7C6354C221E6F` (`goodClass_id`),
  CONSTRAINT `FK6BB7C635D37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C63517B67DBA` FOREIGN KEY (`goodClass_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK6BB7C6351CD911F7` FOREIGN KEY (`goods_main_photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6BB7C63542FB0EAB` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C63543969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C63545F4F01` FOREIGN KEY (`region_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C63547B51C2C` FOREIGN KEY (`form_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6354A9B012D` FOREIGN KEY (`color_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6354C221E6F` FOREIGN KEY (`goodClass_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK6BB7C6354F63344C` FOREIGN KEY (`goodClass_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK6BB7C6355485C889` FOREIGN KEY (`goods_main_photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6BB7C63560A50B5A` FOREIGN KEY (`quality_id`) REFERENCES `ezs_quality` (`id`),
  CONSTRAINT `FK6BB7C6356758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK6BB7C635693B882E` FOREIGN KEY (`util_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6356EC08C21` FOREIGN KEY (`supply_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6356ED23E6C` FOREIGN KEY (`quality_id`) REFERENCES `ezs_quality` (`id`),
  CONSTRAINT `FK6BB7C635748358D3` FOREIGN KEY (`region_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C635B31F187D` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C635D791125A` FOREIGN KEY (`form_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C635DA76F75B` FOREIGN KEY (`color_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C635F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK6BB7C635F9177E5C` FOREIGN KEY (`util_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C635FE9C824F` FOREIGN KEY (`supply_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goods
-- ----------------------------
INSERT INTO `ezs_goods` VALUES ('1', '2018-03-26 14:22:34', '', '1号仓库', '1', '1', '1', '1', '92', '0', '0', '是大师傅大师傅似的胜多负少士大夫士大夫', '1', '1', '2', '12', 'ezs_2018032600001', '0', '100', 'PET', '1', '', 'PEEX复合料', '10000', '', '2', '', '2018-03-26 18:46:01', null, '2', '2', '1', '0', '2', '4521986', '4', '18', '4', null, '25', null, null, null, '1', '22');

-- ----------------------------
-- Table structure for `ezs_goodscart`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goodscart`;
CREATE TABLE `ezs_goodscart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cart_type` varchar(255) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `of_id` bigint(20) DEFAULT NULL,
  `sc_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKA17E1ED5116857FA` (`goods_id`),
  KEY `FKA17E1ED58B08BF0B` (`sc_id`),
  KEY `FKA17E1ED5EA2DFB5` (`of_id`),
  KEY `FKA17E1ED57D0B278C` (`goods_id`),
  KEY `FKA17E1ED5C2B5759D` (`sc_id`),
  KEY `FKA17E1ED5464F9647` (`of_id`),
  CONSTRAINT `FKA17E1ED5116857FA` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`),
  CONSTRAINT `FKA17E1ED5464F9647` FOREIGN KEY (`of_id`) REFERENCES `ezs_orderform` (`id`),
  CONSTRAINT `FKA17E1ED57D0B278C` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`),
  CONSTRAINT `FKA17E1ED58B08BF0B` FOREIGN KEY (`sc_id`) REFERENCES `ezs_storecart` (`id`),
  CONSTRAINT `FKA17E1ED5C2B5759D` FOREIGN KEY (`sc_id`) REFERENCES `ezs_storecart` (`id`),
  CONSTRAINT `FKA17E1ED5EA2DFB5` FOREIGN KEY (`of_id`) REFERENCES `ezs_orderform` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goodscart
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_goods_cartography`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goods_cartography`;
CREATE TABLE `ezs_goods_cartography` (
  `goods_id` bigint(20) NOT NULL,
  `cartography_id` bigint(20) NOT NULL,
  KEY `FK71D57F07D0B278C` (`goods_id`),
  KEY `FK71D57F01C6B3024` (`cartography_id`),
  CONSTRAINT `FK71D57F01C6B3024` FOREIGN KEY (`cartography_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK71D57F07D0B278C` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goods_cartography
-- ----------------------------
INSERT INTO `ezs_goods_cartography` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `ezs_goods_class`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goods_class`;
CREATE TABLE `ezs_goods_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK33B796EEEBA1058B` (`parent_id`),
  KEY `FK33B796EE55AFAB5A` (`photo_id`),
  KEY `FK33B796EE234DBC1D` (`parent_id`),
  KEY `FK33B796EE8D5C61EC` (`photo_id`),
  KEY `FK33B796EE200CA640` (`parent_id`),
  CONSTRAINT `FK33B796EE200CA640` FOREIGN KEY (`parent_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK33B796EE234DBC1D` FOREIGN KEY (`parent_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK33B796EE55AFAB5A` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK33B796EE8D5C61EC` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK33B796EEEBA1058B` FOREIGN KEY (`parent_id`) REFERENCES `ezs_goods_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goods_class
-- ----------------------------
INSERT INTO `ezs_goods_class` VALUES ('1', '2018-03-26 12:17:29', '', '再生工程塑料', null, null, '1');
INSERT INTO `ezs_goods_class` VALUES ('2', '2018-03-26 12:26:53', '', '再生特种塑料', null, null, '2');
INSERT INTO `ezs_goods_class` VALUES ('3', '2018-03-26 12:27:06', '', ' 再生通用塑料', null, null, '3');
INSERT INTO `ezs_goods_class` VALUES ('4', '2018-03-26 12:27:52', '', 'PA', '1', null, '1');
INSERT INTO `ezs_goods_class` VALUES ('5', '2018-03-26 12:28:18', '', 'PET', '1', null, '2');
INSERT INTO `ezs_goods_class` VALUES ('6', '2018-03-26 12:39:33', '', 'PBT', '1', null, '3');
INSERT INTO `ezs_goods_class` VALUES ('7', '2018-03-26 12:40:08', '', 'POM', '1', null, '4');
INSERT INTO `ezs_goods_class` VALUES ('8', '2018-03-26 12:40:18', '', 'PPO', '1', null, '5');
INSERT INTO `ezs_goods_class` VALUES ('9', '2018-03-26 12:40:48', '', 'PC', '1', null, '6');
INSERT INTO `ezs_goods_class` VALUES ('10', '2018-03-26 12:41:02', '', '其他', '1', null, '7');

-- ----------------------------
-- Table structure for `ezs_goods_photo`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goods_photo`;
CREATE TABLE `ezs_goods_photo` (
  `goods_id` bigint(20) NOT NULL,
  `photo_id` bigint(20) NOT NULL,
  KEY `FK346D2BA8116857FA` (`goods_id`),
  KEY `FK346D2BA855AFAB5A` (`photo_id`),
  KEY `FK346D2BA87D0B278C` (`goods_id`),
  KEY `FK346D2BA88D5C61EC` (`photo_id`),
  CONSTRAINT `FK346D2BA8116857FA` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`),
  CONSTRAINT `FK346D2BA855AFAB5A` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK346D2BA87D0B278C` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`),
  CONSTRAINT `FK346D2BA88D5C61EC` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goods_photo
-- ----------------------------
INSERT INTO `ezs_goods_photo` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `ezs_group`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_group`;
CREATE TABLE `ezs_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cus_status` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_group
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_idcard_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_idcard_dict`;
CREATE TABLE `ezs_idcard_dict` (
  `store_id` bigint(20) NOT NULL,
  `accessory_id` bigint(20) NOT NULL,
  KEY `FK86E6806949476E7A` (`accessory_id`),
  KEY `FK86E68069F9DFE81A` (`store_id`),
  KEY `FK86E6806980F4250C` (`accessory_id`),
  KEY `FK86E680696582B7AC` (`store_id`),
  CONSTRAINT `FK86E6806949476E7A` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK86E680696582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FK86E6806980F4250C` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK86E68069F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_idcard_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_invoice`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_invoice`;
CREATE TABLE `ezs_invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `express_name` varchar(255) DEFAULT NULL,
  `express_no` varchar(255) DEFAULT NULL,
  `express_time` datetime DEFAULT NULL,
  `invoice_status` int(11) NOT NULL,
  `receipt_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKC55E364CADCEB194` (`receipt_id`),
  KEY `FKC55E364C6758EBDA` (`user_id`),
  KEY `FKC55E364CE57B6826` (`receipt_id`),
  KEY `FKC55E364CF734E208` (`user_id`),
  CONSTRAINT `FKC55E364C6758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKC55E364CADCEB194` FOREIGN KEY (`receipt_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKC55E364CE57B6826` FOREIGN KEY (`receipt_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKC55E364CF734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_invoice
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_level`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_level`;
CREATE TABLE `ezs_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `enable` bit(1) NOT NULL,
  `initial` bit(1) NOT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `cus_status_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6A36DA433F8AC1C0` (`cus_status_id`),
  KEY `FK6A36DA43756C2C39` (`grade_id`),
  KEY `FK6A36DA43CF66B7EE` (`cus_status_id`),
  KEY `FK6A36DA435482267` (`grade_id`),
  CONSTRAINT `FK6A36DA433F8AC1C0` FOREIGN KEY (`cus_status_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6A36DA435482267` FOREIGN KEY (`grade_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6A36DA43756C2C39` FOREIGN KEY (`grade_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6A36DA43CF66B7EE` FOREIGN KEY (`cus_status_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_level
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_logistics`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_logistics`;
CREATE TABLE `ezs_logistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `car_no` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `logistics_name` varchar(255) DEFAULT NULL,
  `logistics_no` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `proples` varchar(255) DEFAULT NULL,
  `service_time` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `total_price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_logistics
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_main_business`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_main_business`;
CREATE TABLE `ezs_main_business` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `main_business` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_main_business
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_orderform`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_orderform`;
CREATE TABLE `ezs_orderform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cart_session_id` varchar(255) DEFAULT NULL,
  `end_price` decimal(19,2) DEFAULT NULL,
  `finishtime` datetime DEFAULT NULL,
  `first_price` decimal(19,2) DEFAULT NULL,
  `goods_amount` decimal(12,2) DEFAULT NULL,
  `msg` longtext,
  `order_no` varchar(255) DEFAULT NULL,
  `order_status` int(11) NOT NULL,
  `order_type` varchar(255) DEFAULT NULL,
  `pact_no` varchar(255) DEFAULT NULL,
  `pact_status` int(11) NOT NULL,
  `pay_mode` int(11) NOT NULL,
  `sc_status` int(11) DEFAULT '0',
  `total_price` decimal(19,2) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `bill_id` bigint(20) DEFAULT NULL,
  `invoice_id` bigint(20) DEFAULT NULL,
  `logistics_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK3708E471FC9802DA` (`logistics_id`),
  KEY `FK3708E47121B2B49A` (`invoice_id`),
  KEY `FK3708E471466E2B3A` (`address_id`),
  KEY `FK3708E4716758EBDA` (`user_id`),
  KEY `FK3708E4719B177965` (`bill_id`),
  KEY `FK3708E4713444B96C` (`logistics_id`),
  KEY `FK3708E4712FDFE7AC` (`invoice_id`),
  KEY `FK3708E471549B5E4C` (`address_id`),
  KEY `FK3708E471F734E208` (`user_id`),
  KEY `FK3708E471D2C42FF7` (`bill_id`),
  CONSTRAINT `FK3708E47121B2B49A` FOREIGN KEY (`invoice_id`) REFERENCES `ezs_invoice` (`id`),
  CONSTRAINT `FK3708E4712FDFE7AC` FOREIGN KEY (`invoice_id`) REFERENCES `ezs_invoice` (`id`),
  CONSTRAINT `FK3708E4713444B96C` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_logistics` (`id`),
  CONSTRAINT `FK3708E471466E2B3A` FOREIGN KEY (`address_id`) REFERENCES `ezs_address` (`id`),
  CONSTRAINT `FK3708E471549B5E4C` FOREIGN KEY (`address_id`) REFERENCES `ezs_address` (`id`),
  CONSTRAINT `FK3708E4716758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK3708E4719B177965` FOREIGN KEY (`bill_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3708E471D2C42FF7` FOREIGN KEY (`bill_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3708E471F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK3708E471FC9802DA` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_logistics` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_orderform
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_order_pact`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_order_pact`;
CREATE TABLE `ezs_order_pact` (
  `order_id` bigint(20) NOT NULL,
  `pact_id` bigint(20) NOT NULL,
  KEY `FKA9B138F451E8DEDE` (`order_id`),
  KEY `FKA9B138F4718CC16A` (`pact_id`),
  KEY `FKA9B138F489959570` (`order_id`),
  KEY `FKA9B138F4A93977FC` (`pact_id`),
  CONSTRAINT `FKA9B138F451E8DEDE` FOREIGN KEY (`order_id`) REFERENCES `ezs_orderform` (`id`),
  CONSTRAINT `FKA9B138F4718CC16A` FOREIGN KEY (`pact_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKA9B138F489959570` FOREIGN KEY (`order_id`) REFERENCES `ezs_orderform` (`id`),
  CONSTRAINT `FKA9B138F4A93977FC` FOREIGN KEY (`pact_id`) REFERENCES `ezs_accessory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_order_pact
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_paper`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_paper`;
CREATE TABLE `ezs_paper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `validDate` datetime DEFAULT NULL,
  `certificate_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6C30406BFAB6B1D5` (`certificate_id`),
  KEY `FK6C30406B32636867` (`certificate_id`),
  CONSTRAINT `FK6C30406B32636867` FOREIGN KEY (`certificate_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6C30406BFAB6B1D5` FOREIGN KEY (`certificate_id`) REFERENCES `ezs_accessory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_position`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_position`;
CREATE TABLE `ezs_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKED0909EAF9DFE81A` (`store_id`),
  KEY `FKED0909EA6582B7AC` (`store_id`),
  CONSTRAINT `FKED0909EA6582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKED0909EAF9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_position
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_price_trend`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_price_trend`;
CREATE TABLE `ezs_price_trend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `ash` varchar(255) DEFAULT NULL,
  `bending` varchar(255) DEFAULT NULL,
  `burning` varchar(255) DEFAULT NULL,
  `cantilever` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `crack` varchar(255) DEFAULT NULL,
  `data_sources` int(11) NOT NULL,
  `date_from` varchar(255) DEFAULT NULL,
  `density` varchar(255) DEFAULT NULL,
  `flexural` varchar(255) DEFAULT NULL,
  `freely` varchar(255) DEFAULT NULL,
  `lipolysis` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `procurement_standard` varchar(255) DEFAULT NULL,
  `protection` bit(1) NOT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `source_tel` varchar(255) DEFAULT NULL,
  `specification` varchar(255) DEFAULT NULL,
  `tensile` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `water` varchar(255) DEFAULT NULL,
  `goodClass_id` bigint(20) DEFAULT NULL,
  `region_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK877D86C6F734E208` (`user_id`),
  KEY `FK877D86C64C221E6F` (`goodClass_id`),
  KEY `FK877D86C645F4F01` (`region_id`),
  CONSTRAINT `FK877D86C645F4F01` FOREIGN KEY (`region_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK877D86C64C221E6F` FOREIGN KEY (`goodClass_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK877D86C6F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_price_trend
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_quality`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_quality`;
CREATE TABLE `ezs_quality` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `quality_no` varchar(255) DEFAULT NULL,
  `report` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_quality
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_readjust`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_readjust`;
CREATE TABLE `ezs_readjust` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `cause_id` bigint(20) DEFAULT NULL,
  `orderForm_id` bigint(20) DEFAULT NULL,
  `proof_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK8CCB04437591D667` (`cause_id`),
  KEY `FK8CCB044366636F08` (`proof_id`),
  KEY `FK8CCB0443B1CA229A` (`orderForm_id`),
  KEY `FK8CCB044356DCC95` (`cause_id`),
  KEY `FK8CCB04439E10259A` (`proof_id`),
  KEY `FK8CCB0443E976D92C` (`orderForm_id`),
  CONSTRAINT `FK8CCB044356DCC95` FOREIGN KEY (`cause_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK8CCB044366636F08` FOREIGN KEY (`proof_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK8CCB04437591D667` FOREIGN KEY (`cause_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK8CCB04439E10259A` FOREIGN KEY (`proof_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK8CCB0443B1CA229A` FOREIGN KEY (`orderForm_id`) REFERENCES `ezs_orderform` (`id`),
  CONSTRAINT `FK8CCB0443E976D92C` FOREIGN KEY (`orderForm_id`) REFERENCES `ezs_orderform` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_readjust
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_remark`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_remark`;
CREATE TABLE `ezs_remark` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `substance_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK1D787081256C952A` (`substance_id`),
  CONSTRAINT `FK1D787081256C952A` FOREIGN KEY (`substance_id`) REFERENCES `ezs_ezssubstance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_remark
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_res`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_res`;
CREATE TABLE `ezs_res` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `resName` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_res
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_role`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_role`;
CREATE TABLE `ezs_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `display` bit(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `roleCode` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `roleGroup_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFB3C79B7DAD7AEFA` (`roleGroup_id`),
  KEY `FKFB3C79B71284658C` (`roleGroup_id`),
  CONSTRAINT `FKFB3C79B71284658C` FOREIGN KEY (`roleGroup_id`) REFERENCES `ezs_role_group` (`id`),
  CONSTRAINT `FKFB3C79B7DAD7AEFA` FOREIGN KEY (`roleGroup_id`) REFERENCES `ezs_role_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_role
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_role_group`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_role_group`;
CREATE TABLE `ezs_role_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_role_group
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_role_res`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_role_res`;
CREATE TABLE `ezs_role_res` (
  `role_id` bigint(20) NOT NULL,
  `res_id` bigint(20) NOT NULL,
  KEY `FKB097AE18163DDBBA` (`res_id`),
  KEY `FKB097AE18C22E27FA` (`role_id`),
  KEY `FKB097AE18E11367CC` (`res_id`),
  KEY `FKB097AE18520A1E28` (`role_id`),
  CONSTRAINT `FKB097AE18163DDBBA` FOREIGN KEY (`res_id`) REFERENCES `ezs_res` (`id`),
  CONSTRAINT `FKB097AE18520A1E28` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB097AE18C22E27FA` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB097AE18E11367CC` FOREIGN KEY (`res_id`) REFERENCES `ezs_res` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_role_res
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_source`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_source`;
CREATE TABLE `ezs_source` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `enable` bit(1) NOT NULL,
  `identifying` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_source
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_specialsubject`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_specialsubject`;
CREATE TABLE `ezs_specialsubject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `abbreviation` varchar(255) DEFAULT NULL,
  `colTemplate` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `keyWord` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderid` int(11) NOT NULL,
  `pcContentPhoto` varchar(255) DEFAULT NULL,
  `pcTitlePhoto` varchar(255) DEFAULT NULL,
  `phoTemplate` varchar(255) DEFAULT NULL,
  `phoneContentPhoto` varchar(255) DEFAULT NULL,
  `phoneTitlePhoto` varchar(255) DEFAULT NULL,
  `recommend` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_specialsubject
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_store`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_store`;
CREATE TABLE `ezs_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `assets` double NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `covered` double NOT NULL,
  `device_num` int(11) NOT NULL,
  `employee_num` int(11) NOT NULL,
  `fixed_assets` double NOT NULL,
  `location` tinyblob,
  `location_detail` varchar(255) DEFAULT NULL,
  `obtainYear` int(11) NOT NULL,
  `openBankNo` varchar(255) DEFAULT NULL,
  `open_bank_name` varchar(255) DEFAULT NULL,
  `open_branch_name` varchar(255) DEFAULT NULL,
  `open_branch_no` varchar(255) DEFAULT NULL,
  `registerDate` datetime DEFAULT NULL,
  `rent` bit(1) NOT NULL,
  `status` int(11) NOT NULL,
  `yTurnover` double NOT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `cardType_id` bigint(20) DEFAULT NULL,
  `mianIndustry_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6C6327C043969C9A` (`area_id`),
  KEY `FK6C6327C02530E69` (`mianIndustry_id`),
  KEY `FK6C6327C0FBF0F0E6` (`cardType_id`),
  KEY `FK6C6327C0D37292C8` (`area_id`),
  KEY `FK6C6327C0922F0497` (`mianIndustry_id`),
  KEY `FK6C6327C08BCCE714` (`cardType_id`),
  CONSTRAINT `FK6C6327C02530E69` FOREIGN KEY (`mianIndustry_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6C6327C043969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`),
  CONSTRAINT `FK6C6327C08BCCE714` FOREIGN KEY (`cardType_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6C6327C0922F0497` FOREIGN KEY (`mianIndustry_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6C6327C0D37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area111` (`id`),
  CONSTRAINT `FK6C6327C0FBF0F0E6` FOREIGN KEY (`cardType_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_store
-- ----------------------------
INSERT INTO `ezs_store` VALUES ('1', '2018-03-26 19:09:31', '', null, '0', null, '0', '0', '0', '0', null, null, '0', null, null, null, null, null, '', '2', '0', null, null, null);

-- ----------------------------
-- Table structure for `ezs_storecart`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_storecart`;
CREATE TABLE `ezs_storecart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cart_session_id` varchar(255) DEFAULT NULL,
  `sc_status` int(11) DEFAULT '0',
  `total_price` decimal(19,2) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKB32937006758EBDA` (`user_id`),
  KEY `FKB3293700F9DFE81A` (`store_id`),
  KEY `FKB3293700F734E208` (`user_id`),
  KEY `FKB32937006582B7AC` (`store_id`),
  CONSTRAINT `FKB32937006582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKB32937006758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKB3293700F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKB3293700F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_storecart
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_store_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_store_dict`;
CREATE TABLE `ezs_store_dict` (
  `store_id` bigint(20) NOT NULL,
  `dict_id` bigint(20) NOT NULL,
  KEY `FKB38974D5D2E1D4BA` (`dict_id`),
  KEY `FKB38974D5F9DFE81A` (`store_id`),
  KEY `FKB38974D562BDCAE8` (`dict_id`),
  KEY `FKB38974D56582B7AC` (`store_id`),
  CONSTRAINT `FKB38974D562BDCAE8` FOREIGN KEY (`dict_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB38974D56582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKB38974D5D2E1D4BA` FOREIGN KEY (`dict_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB38974D5F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_store_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_store_stat`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_store_stat`;
CREATE TABLE `ezs_store_stat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `all_goods` int(11) NOT NULL,
  `all_store` int(11) NOT NULL,
  `all_user` int(11) NOT NULL,
  `next_time` datetime DEFAULT NULL,
  `order_amount` decimal(12,2) DEFAULT NULL,
  `store_update` int(11) NOT NULL,
  `week_complaint` int(11) NOT NULL,
  `week_goods` int(11) NOT NULL,
  `week_order` int(11) NOT NULL,
  `week_report` int(11) NOT NULL,
  `week_store` int(11) NOT NULL,
  `week_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_store_stat
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_sysconfig`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_sysconfig`;
CREATE TABLE `ezs_sysconfig` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `alipay_fenrun` int(11) DEFAULT '0',
  `auto_order_confirm` int(11) DEFAULT '7',
  `auto_order_evaluate` int(11) DEFAULT '7',
  `auto_order_notice` int(11) DEFAULT '3',
  `auto_order_return` int(11) DEFAULT '7',
  `balance_fenrun` int(11) DEFAULT '0',
  `bargain_maximum` int(11) DEFAULT '0',
  `bargain_rebate` decimal(3,2) DEFAULT NULL,
  `bargain_state` longtext,
  `bargain_status` int(11) DEFAULT '0',
  `bargain_title` varchar(255) DEFAULT NULL,
  `bargain_validity` int(11) DEFAULT '3',
  `bigHeight` int(11) NOT NULL,
  `bigWidth` int(11) NOT NULL,
  `closeReason` longtext,
  `codeStat` longtext,
  `combin_amount` int(11) DEFAULT '50',
  `combin_count` int(11) DEFAULT '3',
  `complaint_time` int(11) NOT NULL,
  `config_payment_type` int(11) DEFAULT '0',
  `consumptionRatio` int(11) NOT NULL,
  `copyRight` varchar(255) DEFAULT NULL,
  `creditrule` longtext,
  `currency_code` varchar(255) DEFAULT '￥',
  `delivery_amount` int(11) DEFAULT '50',
  `delivery_status` int(11) DEFAULT '0',
  `delivery_title` varchar(255) DEFAULT NULL,
  `deposit` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `domain_allow_count` int(11) DEFAULT '0',
  `emailEnable` bit(1) NOT NULL,
  `emailHost` varchar(255) DEFAULT NULL,
  `emailPort` int(11) NOT NULL,
  `emailPws` varchar(255) DEFAULT NULL,
  `emailTest` varchar(255) DEFAULT NULL,
  `emailUser` varchar(255) DEFAULT NULL,
  `emailUserName` varchar(255) DEFAULT NULL,
  `everyIndentLimit` int(11) NOT NULL,
  `gold` bit(1) NOT NULL,
  `goldMarketValue` int(11) NOT NULL,
  `groupBuy` bit(1) NOT NULL,
  `hotSearch` varchar(255) DEFAULT NULL,
  `imageFilesize` int(11) NOT NULL,
  `imageSaveType` varchar(255) DEFAULT NULL,
  `imageSuffix` varchar(255) DEFAULT NULL,
  `imageWebServer` varchar(255) DEFAULT NULL,
  `indentComment` int(11) NOT NULL,
  `integral` bit(1) NOT NULL,
  `integralRate` int(11) NOT NULL,
  `integralStore` bit(1) NOT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `kuaidi_id` longtext,
  `lucene_update` datetime DEFAULT NULL,
  `memberDayLogin` int(11) NOT NULL,
  `memberRegister` int(11) NOT NULL,
  `middleHeight` int(11) NOT NULL,
  `middleWidth` int(11) NOT NULL,
  `qq_domain_code` longtext,
  `qq_login` bit(1) DEFAULT b'0',
  `qq_login_id` varchar(255) DEFAULT NULL,
  `qq_login_key` varchar(255) DEFAULT NULL,
  `second_domain_open` bit(1) DEFAULT b'0',
  `securityCodeConsult` bit(1) NOT NULL,
  `securityCodeLogin` bit(1) NOT NULL,
  `securityCodeRegister` bit(1) NOT NULL,
  `securityCodeType` varchar(255) DEFAULT NULL,
  `service_qq_list` longtext,
  `service_telphone_list` longtext,
  `share_code` longtext,
  `sina_domain_code` longtext,
  `sina_login` bit(1) DEFAULT b'0',
  `sina_login_id` varchar(255) DEFAULT NULL,
  `sina_login_key` varchar(255) DEFAULT NULL,
  `site_url` varchar(255) DEFAULT NULL,
  `smallHeight` int(11) NOT NULL,
  `smallWidth` int(11) NOT NULL,
  `smsEnbale` bit(1) NOT NULL,
  `smsPassword` varchar(255) DEFAULT NULL,
  `smsTest` varchar(255) DEFAULT NULL,
  `smsURL` varchar(255) DEFAULT NULL,
  `smsUserName` varchar(255) DEFAULT NULL,
  `store_allow` bit(1) NOT NULL,
  `store_payment` longtext,
  `sysLanguage` varchar(255) DEFAULT NULL,
  `sys_domain` longtext,
  `templates` longtext,
  `title` varchar(255) DEFAULT NULL,
  `uc_api` varchar(255) DEFAULT NULL,
  `uc_appid` varchar(255) DEFAULT NULL,
  `uc_bbs` bit(1) DEFAULT b'0',
  `uc_database` varchar(255) DEFAULT NULL,
  `uc_database_port` varchar(255) DEFAULT NULL,
  `uc_database_pws` varchar(255) DEFAULT NULL,
  `uc_database_url` varchar(255) DEFAULT NULL,
  `uc_database_username` varchar(255) DEFAULT NULL,
  `uc_ip` varchar(255) DEFAULT NULL,
  `uc_key` varchar(255) DEFAULT NULL,
  `uc_table_preffix` varchar(255) DEFAULT NULL,
  `uploadFilePath` varchar(255) DEFAULT NULL,
  `user_creditrule` longtext,
  `visitorConsult` bit(1) NOT NULL,
  `voucher` bit(1) NOT NULL,
  `websiteCss` varchar(255) DEFAULT 'blue',
  `websiteName` varchar(255) DEFAULT NULL,
  `websiteState` bit(1) NOT NULL,
  `weixin_account` varchar(255) DEFAULT NULL,
  `weixin_amount` int(11) DEFAULT '50',
  `weixin_appId` varchar(255) DEFAULT NULL,
  `weixin_appSecret` varchar(255) DEFAULT NULL,
  `weixin_store` bit(1) DEFAULT b'0',
  `weixin_token` varchar(255) DEFAULT NULL,
  `weixin_welecome_content` longtext,
  `ztc_goods_view` int(11) DEFAULT '0',
  `ztc_price` int(11) NOT NULL,
  `ztc_status` bit(1) NOT NULL,
  `goodsImage_id` bigint(20) DEFAULT NULL,
  `memberIcon_id` bigint(20) DEFAULT NULL,
  `storeImage_id` bigint(20) DEFAULT NULL,
  `store_weixin_logo_id` bigint(20) DEFAULT NULL,
  `websiteLogo_id` bigint(20) DEFAULT NULL,
  `weixin_qr_img_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKB6F9BA32373AC6D8` (`websiteLogo_id`),
  KEY `FKB6F9BA321E4C4204` (`storeImage_id`),
  KEY `FKB6F9BA3271BCB4FC` (`weixin_qr_img_id`),
  KEY `FKB6F9BA327CA11E6B` (`memberIcon_id`),
  KEY `FKB6F9BA3229729A14` (`store_weixin_logo_id`),
  KEY `FKB6F9BA3289699B79` (`goodsImage_id`),
  KEY `FK752FDBAEFF8E1046` (`websiteLogo_id`),
  KEY `FK752FDBAE3A0FFE6A` (`weixin_qr_img_id`),
  KEY `FK752FDBAEF1C5E382` (`store_weixin_logo_id`),
  KEY `FK752FDBAE373AC6D8` (`websiteLogo_id`),
  KEY `FK752FDBAE71BCB4FC` (`weixin_qr_img_id`),
  KEY `FK752FDBAE29729A14` (`store_weixin_logo_id`),
  KEY `FK752FDBAE89699B79` (`goodsImage_id`),
  KEY `FK752FDBAE7CA11E6B` (`memberIcon_id`),
  CONSTRAINT `FK752FDBAE7CA11E6B` FOREIGN KEY (`memberIcon_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE29729A14` FOREIGN KEY (`store_weixin_logo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE373AC6D8` FOREIGN KEY (`websiteLogo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE3A0FFE6A` FOREIGN KEY (`weixin_qr_img_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE71BCB4FC` FOREIGN KEY (`weixin_qr_img_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE89699B79` FOREIGN KEY (`goodsImage_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAEF1C5E382` FOREIGN KEY (`store_weixin_logo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAEFF8E1046` FOREIGN KEY (`websiteLogo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKB6F9BA321E4C4204` FOREIGN KEY (`storeImage_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA3229729A14` FOREIGN KEY (`store_weixin_logo_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA32373AC6D8` FOREIGN KEY (`websiteLogo_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA3271BCB4FC` FOREIGN KEY (`weixin_qr_img_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA327CA11E6B` FOREIGN KEY (`memberIcon_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA3289699B79` FOREIGN KEY (`goodsImage_id`) REFERENCES `wemall_accessory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_sysconfig
-- ----------------------------
INSERT INTO `ezs_sysconfig` VALUES ('1', '2018-02-28 17:23:44', '', ' ', '0', '7', '7', '3', '7', '0', '0', null, null, '0', null, '3', '1024', '1024', '系统维护中...', '', '50', '3', '30', '0', '0', null, '{\"creditrule29\":1500,\"creditrule28\":1401,\"creditrule27\":1400,\"creditrule26\":1301,\"creditrule25\":1300,\"creditrule24\":1201,\"creditrule23\":1200,\"creditrule22\":1101,\"creditrule21\":1100,\"creditrule20\":1001,\"creditrule2\":101,\"creditrule1\":100,\"creditrule4\":201,\"creditrule3\":200,\"creditrule0\":1,\"creditrule19\":1000,\"creditrule18\":901,\"creditrule9\":500,\"creditrule7\":400,\"creditrule15\":800,\"creditrule8\":401,\"creditrule14\":701,\"creditrule5\":300,\"creditrule17\":900,\"creditrule6\":301,\"creditrule16\":801,\"creditrule11\":600,\"creditrule10\":501,\"creditrule13\":700,\"creditrule12\":601}', '￥', '50', '0', null, '', '易再生商城', '0', '', null, '0', null, null, null, null, '0', '', '0', '', 'GPPS,ABS,PET,PEEK,PET', '1024', 'sidYearMonthDayImg', 'gif|jpg|jpeg|bmp|png', '', '0', '', '0', '', null, null, '2018-03-18 00:00:02', '0', '0', '300', '300', '', '', '', '', '', '', '', '', 'normal', '', '', '', '', '', '', '', null, '160', '160', '', null, null, null, null, '', '{\"payafter\":true,\"outline\":true}', 'zh_cn', null, null, '易再生多用户商城系统V2.0版', null, null, '', null, null, null, null, null, null, null, null, 'upload', '{\"creditrule29\":800,\"creditrule28\":751,\"creditrule27\":750,\"creditrule26\":701,\"creditrule25\":700,\"creditrule24\":651,\"creditrule23\":650,\"creditrule22\":601,\"creditrule21\":550,\"creditrule20\":501,\"creditrule2\":51,\"creditrule1\":50,\"creditrule4\":101,\"creditrule3\":100,\"creditrule0\":1,\"creditrule19\":500,\"creditrule18\":451,\"creditrule9\":250,\"creditrule7\":200,\"creditrule15\":400,\"creditrule8\":201,\"creditrule14\":351,\"creditrule5\":150,\"creditrule17\":450,\"creditrule6\":151,\"creditrule16\":401,\"creditrule11\":300,\"creditrule10\":251,\"creditrule13\":350,\"creditrule12\":301}', '', '', 'blue', '易再生资源交易平台', '', null, '50', null, null, '', null, null, '0', '0', '', '1', '2', '3', null, null, null);

-- ----------------------------
-- Table structure for `ezs_syslog`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_syslog`;
CREATE TABLE `ezs_syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `content` longtext,
  `ip` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK204A02586758EBDA` (`user_id`),
  KEY `FK204A0258F734E208` (`user_id`),
  CONSTRAINT `FK204A02586758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK204A0258F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_syslog
-- ----------------------------
INSERT INTO `ezs_syslog` VALUES ('1', '2018-03-27 14:16:03', '', 'null于2018-03-27 14:16:03退出系统', '0:0:0:0:0:0:0:1', '用户退出', '0', '1');

-- ----------------------------
-- Table structure for `ezs_user`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_user`;
CREATE TABLE `ezs_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `lastLoginIp` varchar(255) DEFAULT NULL,
  `loginCount` int(11) NOT NULL,
  `loginDate` datetime DEFAULT NULL,
  `loginIp` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `trueName` varchar(255) DEFAULT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `userInfo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFB3DE50C10E4E93A` (`userInfo_id`),
  KEY `FKFB3DE50CEB84AE9B` (`parent_id`),
  KEY `FKFB3DE50CF9DFE81A` (`store_id`),
  KEY `FKFB3DE50CC85E1868` (`userInfo_id`),
  KEY `FKFB3DE50C7B60A4C9` (`parent_id`),
  KEY `FKFB3DE50C6582B7AC` (`store_id`),
  CONSTRAINT `FKFB3DE50C10E4E93A` FOREIGN KEY (`userInfo_id`) REFERENCES `ezs_userinfo` (`id`),
  CONSTRAINT `FKFB3DE50C6582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKFB3DE50C7B60A4C9` FOREIGN KEY (`parent_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKFB3DE50CC85E1868` FOREIGN KEY (`userInfo_id`) REFERENCES `ezs_userinfo` (`id`),
  CONSTRAINT `FKFB3DE50CEB84AE9B` FOREIGN KEY (`parent_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKFB3DE50CF9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_user
-- ----------------------------
INSERT INTO `ezs_user` VALUES ('1', null, '', '2018-03-27 14:15:58', '0:0:0:0:0:0:0:1', '9', '2018-03-28 10:33:40', '0:0:0:0:0:0:0:1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, 'ADMIN', null, '1', '1');

-- ----------------------------
-- Table structure for `ezs_userconfig`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_userconfig`;
CREATE TABLE `ezs_userconfig` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKF6886F4E6758EBDA` (`user_id`),
  KEY `FKF6886F4EF734E208` (`user_id`),
  CONSTRAINT `FKF6886F4E6758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKF6886F4EF734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_userconfig
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_userinfo`;
CREATE TABLE `ezs_userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable` bit(1) DEFAULT b'0',
  `entryTime` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `depart_id` bigint(20) DEFAULT NULL,
  `position_id` bigint(20) DEFAULT NULL,
  `sex_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKB09DE3BA7A218F3A` (`depart_id`),
  KEY `FKB09DE3BA3A1AB14A` (`sex_id`),
  KEY `FKB09DE3BA466F871A` (`position_id`),
  KEY `FKB09DE3BA82D8B1E8` (`depart_id`),
  KEY `FKB09DE3BAC9F6A778` (`sex_id`),
  KEY `FKB09DE3BAFDE8B648` (`position_id`),
  CONSTRAINT `FKB09DE3BA3A1AB14A` FOREIGN KEY (`sex_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKB09DE3BA466F871A` FOREIGN KEY (`position_id`) REFERENCES `ezs_position` (`id`),
  CONSTRAINT `FKB09DE3BA7A218F3A` FOREIGN KEY (`depart_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FKB09DE3BA82D8B1E8` FOREIGN KEY (`depart_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FKB09DE3BAC9F6A778` FOREIGN KEY (`sex_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKB09DE3BAFDE8B648` FOREIGN KEY (`position_id`) REFERENCES `ezs_position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_userinfo
-- ----------------------------
INSERT INTO `ezs_userinfo` VALUES ('1', null, '', null, '', null, null, '0', null, null, null);

-- ----------------------------
-- Table structure for `ezs_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_user_role`;
CREATE TABLE `ezs_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK62939BC9C22E27FA` (`role_id`),
  KEY `FK62939BC96758EBDA` (`user_id`),
  KEY `FK62939BC9520A1E28` (`role_id`),
  KEY `FK62939BC9F734E208` (`user_id`),
  CONSTRAINT `FK62939BC9520A1E28` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FK62939BC96758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK62939BC9C22E27FA` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FK62939BC9F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_user_role
-- ----------------------------
