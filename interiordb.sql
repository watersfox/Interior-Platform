CREATE DATABASE interiordb DEFAULT CHARACTER SET utf-8;
USE interiordb;

/*
 Navicat Premium Data Transfer

 Source Server         : ezendb
 Source Server Type    : MariaDB
 Source Server Version : 100614
 Source Host           : ezendb.chg7hygdd77i.ap-northeast-2.rds.amazonaws.com:3306
 Source Schema         : interiordb

 Target Server Type    : MariaDB
 Target Server Version : 100614
 File Encoding         : 65001

 Date: 06/02/2024 10:34:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for COM_LOC
-- ----------------------------
DROP TABLE IF EXISTS `COM_LOC`;
CREATE TABLE `COM_LOC`  (
  `companyId` int(11) NOT NULL,
  `locationCode` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`companyId`, `locationCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of COM_LOC
-- ----------------------------

-- ----------------------------
-- Table structure for Comment
-- ----------------------------
DROP TABLE IF EXISTS `Comment`;
CREATE TABLE `Comment`  (
  `commentNumber` int(11) NOT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `postNumber` int(11) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `level` int(1) NULL DEFAULT 0,
  `bundleId` int(11) NULL DEFAULT NULL,
  `bundleOrder` int(11) NULL DEFAULT NULL,
  `isDeleted` tinyint(1) NULL DEFAULT 0,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `deletedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `likesCnt` int(11) NOT NULL DEFAULT 0,
  `User` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`commentNumber`) USING BTREE,
  INDEX `FK_User_TO_Comment_1`(`userId`) USING BTREE,
  INDEX `FKtahdc6r763a952os5wctq6jf7`(`postNumber`) USING BTREE,
  INDEX `FKtj3y77kc14n1au4xwb2hy32cs`(`User`) USING BTREE,
  CONSTRAINT `FK_User_TO_Comment_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtahdc6r763a952os5wctq6jf7` FOREIGN KEY (`postNumber`) REFERENCES `CommunityPost` (`postNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtj3y77kc14n1au4xwb2hy32cs` FOREIGN KEY (`User`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Comment
-- ----------------------------

-- ----------------------------
-- Table structure for CommentLikes
-- ----------------------------
DROP TABLE IF EXISTS `CommentLikes`;
CREATE TABLE `CommentLikes`  (
  `commentLikesNo` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `commentNumber` int(11) NULL DEFAULT NULL,
  `User` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`commentLikesNo`) USING BTREE,
  INDEX `FK_User_TO_CommentLikes_1`(`userId`) USING BTREE,
  INDEX `FK_Comment_TO_CommentLikes_1`(`commentNumber`) USING BTREE,
  INDEX `FK8smnatnl0obakh26q52d4c9f5`(`User`) USING BTREE,
  CONSTRAINT `FK8smnatnl0obakh26q52d4c9f5` FOREIGN KEY (`User`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Comment_TO_CommentLikes_1` FOREIGN KEY (`commentNumber`) REFERENCES `Comment` (`commentNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_User_TO_CommentLikes_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of CommentLikes
-- ----------------------------

-- ----------------------------
-- Table structure for CommunityPost
-- ----------------------------
DROP TABLE IF EXISTS `CommunityPost`;
CREATE TABLE `CommunityPost`  (
  `postNumber` int(11) NOT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `views` int(11) NOT NULL,
  `commentCnt` int(11) NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `likesCnt` int(11) NOT NULL,
  `deletedDate` timestamp NULL DEFAULT NULL,
  `fileName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `filePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`postNumber`) USING BTREE,
  INDEX `FK_User_TO_CommunityPost_1`(`userId`) USING BTREE,
  CONSTRAINT `FK_User_TO_CommunityPost_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of CommunityPost
-- ----------------------------

-- ----------------------------
-- Table structure for Company
-- ----------------------------
DROP TABLE IF EXISTS `Company`;
CREATE TABLE `Company`  (
  `companyId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ceoName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `careerYears` int(3) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ceoPhone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `companyNumber` int(11) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `rating` float NULL DEFAULT NULL,
  `isCertified` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`companyId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Company
-- ----------------------------
INSERT INTO `Company` VALUES ('001-1', 'ezen', '02-123-4567', '백인욱', NULL, 12, '서울', '2024-01-25 06:31:22', '1q2w3e!!', '01012345678', 212345678, 'ezen@naver.copm', NULL, NULL);
INSERT INTO `Company` VALUES ('002-1', 'interior', '12345648', '이민주', '', 1, '서울', '2024-01-25 06:43:30', '1q2w3e!!', '01049749785', 45646879, 'eaes@asdad.com', NULL, NULL);

-- ----------------------------
-- Table structure for Estimate
-- ----------------------------
DROP TABLE IF EXISTS `Estimate`;
CREATE TABLE `Estimate`  (
  `buildingType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `buildDate` date NULL DEFAULT NULL,
  `budget` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `constructionType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `estimateNo` int(255) NOT NULL,
  PRIMARY KEY (`estimateNo`) USING BTREE,
  INDEX `FKduj2wdhul8b1lmje1ceoyfr3j`(`userId`) USING BTREE,
  CONSTRAINT `FKduj2wdhul8b1lmje1ceoyfr3j` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Estimate
-- ----------------------------
INSERT INTO `Estimate` VALUES ('아파트', '2024-02-20', '10000000', '도배', '서울', 'admin', 1);

-- ----------------------------
-- Table structure for Inquiry
-- ----------------------------
DROP TABLE IF EXISTS `Inquiry`;
CREATE TABLE `Inquiry`  (
  `inquiryNo` int(11) NOT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `category` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`inquiryNo`) USING BTREE,
  INDEX `FK_User_TO_Inquiry_1`(`userId`) USING BTREE,
  CONSTRAINT `FK_User_TO_Inquiry_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Inquiry
-- ----------------------------
INSERT INTO `Inquiry` VALUES (2, 'admin', 'admin제목', 'admin컨텐츠', '2024-02-02 09:02:08', '0000-00-00 00:00:00', 'admin카테고리');

-- ----------------------------
-- Table structure for InteriorWork
-- ----------------------------
DROP TABLE IF EXISTS `InteriorWork`;
CREATE TABLE `InteriorWork`  (
  `workNumber` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `workDate` datetime(6) NULL DEFAULT NULL,
  `workType` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `workWeeks` int(3) NOT NULL,
  `pyeong` int(3) NOT NULL,
  `workPrice` int(11) NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`workNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of InteriorWork
-- ----------------------------

-- ----------------------------
-- Table structure for LocationCode
-- ----------------------------
DROP TABLE IF EXISTS `LocationCode`;
CREATE TABLE `LocationCode`  (
  `locationCode` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`locationCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of LocationCode
-- ----------------------------

-- ----------------------------
-- Table structure for Notification
-- ----------------------------
DROP TABLE IF EXISTS `Notification`;
CREATE TABLE `Notification`  (
  `notNo` int(11) NOT NULL AUTO_INCREMENT,
  `Count` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createdDate` datetime(6) NULL DEFAULT NULL,
  `notMessage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `notType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `notUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `notificationCount` int(11) NOT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`notNo`) USING BTREE,
  INDEX `FKt8hpigkuwgy2j1m5ja9nihs3q`(`userId`) USING BTREE,
  CONSTRAINT `FKt8hpigkuwgy2j1m5ja9nihs3q` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Notification
-- ----------------------------
INSERT INTO `Notification` VALUES (1, 9, '서울', '2024-02-19 17:09:22.000000', '작성글이 있습니다', '일반', 'www.naver.com', 0, '1');

-- ----------------------------
-- Table structure for PostLikes
-- ----------------------------
DROP TABLE IF EXISTS `PostLikes`;
CREATE TABLE `PostLikes`  (
  `postLikesNo` int(11) NOT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `postNumber` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`postLikesNo`) USING BTREE,
  INDEX `FK_User_TO_PostLikes_1`(`userId`) USING BTREE,
  INDEX `FK_Community_TO_PostLikes_1`(`postNumber`) USING BTREE,
  CONSTRAINT `FK_Community_TO_PostLikes_1` FOREIGN KEY (`postNumber`) REFERENCES `CommunityPost` (`postNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_User_TO_PostLikes_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PostLikes
-- ----------------------------

-- ----------------------------
-- Table structure for ProfileImage
-- ----------------------------
DROP TABLE IF EXISTS `ProfileImage`;
CREATE TABLE `ProfileImage`  (
  `imageNumber` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`imageNumber`) USING BTREE,
  UNIQUE INDEX `UK_a63vkilgxlagmul3uq2u09yeq`(`userId`) USING BTREE,
  CONSTRAINT `FK7lj1i6pcokmma4iskpsmqg6ac` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ProfileImage
-- ----------------------------
INSERT INTO `ProfileImage` VALUES (1, '/profileImages/s_3b358891-2a3a-4f05-9e18-e4337a48f085_image-20.png', 'admin');
INSERT INTO `ProfileImage` VALUES (9, '/profileImages/s_3587b555-aa6c-4866-8554-59168d260b8c_image-20.png', '1');
INSERT INTO `ProfileImage` VALUES (10, '/profileImages/s_3e91cf80-8a3e-4750-a412-0f3c4dfba3d6_image-20.png', '2');
INSERT INTO `ProfileImage` VALUES (11, '/profileImages/s_1e7143a4-c4ca-4ba8-bf11-d5b2fc8749c6_image-20.png', '3');

-- ----------------------------
-- Table structure for Review
-- ----------------------------
DROP TABLE IF EXISTS `Review`;
CREATE TABLE `Review`  (
  `reviewNumber` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `companyId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `rating` float NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deletedDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`reviewNumber`) USING BTREE,
  INDEX `FK_User_TO_Review_1`(`userId`) USING BTREE,
  INDEX `FK48p04l92dfdnl5yya0wmkbnqo`(`companyId`) USING BTREE,
  CONSTRAINT `FK48p04l92dfdnl5yya0wmkbnqo` FOREIGN KEY (`companyId`) REFERENCES `Company` (`companyId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_User_TO_Review_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Review
-- ----------------------------

-- ----------------------------
-- Table structure for Scrap
-- ----------------------------
DROP TABLE IF EXISTS `Scrap`;
CREATE TABLE `Scrap`  (
  `scrapNumber` int(11) NOT NULL,
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `linkUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `thumbnailUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`scrapNumber`) USING BTREE,
  INDEX `FK_User_TO_Scrap_1`(`userId`) USING BTREE,
  CONSTRAINT `FK_User_TO_Scrap_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Scrap
-- ----------------------------

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `userId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'unique',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `imageUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '회원',
  `point` bigint(20) NULL DEFAULT NULL,
  `alert` tinyint(1) NULL DEFAULT NULL,
  `stopDay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `whystop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `isStop` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES ('1', '1', '1q2w3e!!', NULL, '01011111111', '1@naver.com', '2024-02-05 02:03:18', NULL, NULL, '회원', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `User` VALUES ('2', '2', '1q2w3e!!', NULL, '01022222222', '2@navre.com', '2024-02-05 10:20:17', '1q', NULL, '회원', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `User` VALUES ('3', '3', '1q2w3e!!', NULL, '01033333333', '3@naver.com', '2024-02-05 02:08:24', NULL, NULL, '회원', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `User` VALUES ('admin', '관리자', '1q2w3e!!', NULL, '01012345678', 'admin@naver.com', '2024-02-04 14:56:15', 'dzs', NULL, '관리자', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for WorkExample
-- ----------------------------
DROP TABLE IF EXISTS `WorkExample`;
CREATE TABLE `WorkExample`  (
  `workExNO` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pyeong` int(3) NOT NULL,
  `workType` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `workPrice` int(11) NOT NULL,
  `workWeeks` int(3) NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deletedDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`workExNO`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of WorkExample
-- ----------------------------

-- ----------------------------
-- Table structure for WorkType
-- ----------------------------
DROP TABLE IF EXISTS `WorkType`;
CREATE TABLE `WorkType`  (
  `companyId` int(11) NOT NULL,
  `workType` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`companyId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of WorkType
-- ----------------------------

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `followId` int(11) NOT NULL,
  `followingId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `followerId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`followId`) USING BTREE,
  INDEX `FK_User_TO_follow_1`(`followingId`) USING BTREE,
  INDEX `FK_User_TO_follow_2`(`followerId`) USING BTREE,
  CONSTRAINT `FK_User_TO_follow_1` FOREIGN KEY (`followingId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_User_TO_follow_2` FOREIGN KEY (`followerId`) REFERENCES `User` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow
-- ----------------------------

-- ----------------------------
-- Table structure for material_price
-- ----------------------------
DROP TABLE IF EXISTS `material_price`;
CREATE TABLE `material_price`  (
  `MAT_CODE` int(11) NOT NULL AUTO_INCREMENT,
  `MAT_CAT` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `MAT_NAME` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `MAT_PRICE` float NOT NULL DEFAULT 0,
  PRIMARY KEY (`MAT_CODE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 235 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material_price
-- ----------------------------
INSERT INTO `material_price` VALUES (1, '철거', '20평', 150);
INSERT INTO `material_price` VALUES (2, '철거', '30평', 350);
INSERT INTO `material_price` VALUES (3, '철거', '40평', 550);
INSERT INTO `material_price` VALUES (4, '철거', '50평', 600);
INSERT INTO `material_price` VALUES (5, '인건비', '전기', 25);
INSERT INTO `material_price` VALUES (6, '인건비', '철거', 25);
INSERT INTO `material_price` VALUES (7, '인건비', '타일', 28);
INSERT INTO `material_price` VALUES (8, '폐기물', '0.5톤', 20);
INSERT INTO `material_price` VALUES (9, '폐기물', '1톤', 40);
INSERT INTO `material_price` VALUES (10, '폐기물', '2톤', 50);
INSERT INTO `material_price` VALUES (11, '샷시', 'KCC_21평', 570);
INSERT INTO `material_price` VALUES (12, '샷시', 'KCC_24평', 650);
INSERT INTO `material_price` VALUES (13, '샷시', 'KCC_28평', 700);
INSERT INTO `material_price` VALUES (14, '샷시', 'KCC_32평', 780);
INSERT INTO `material_price` VALUES (15, '샷시', 'KCC_37평', 950);
INSERT INTO `material_price` VALUES (16, '샷시', 'KCC_45평', 1000);
INSERT INTO `material_price` VALUES (17, '샷시', 'KCC_48평', 1100);
INSERT INTO `material_price` VALUES (18, '샷시', 'LG_21평', 700);
INSERT INTO `material_price` VALUES (19, '샷시', 'LG_24평', 810);
INSERT INTO `material_price` VALUES (20, '샷시', 'LG_28평', 860);
INSERT INTO `material_price` VALUES (21, '샷시', 'LG_32평', 1000);
INSERT INTO `material_price` VALUES (22, '샷시', 'LG_37평', 1220);
INSERT INTO `material_price` VALUES (23, '샷시', 'LG_45평', 1300);
INSERT INTO `material_price` VALUES (24, '샷시', 'LG_48평', 1400);
INSERT INTO `material_price` VALUES (25, '샷시', '휴그린_21평', 510);
INSERT INTO `material_price` VALUES (26, '샷시', '휴그린_24평', 600);
INSERT INTO `material_price` VALUES (27, '샷시', '휴그린_28평', 630);
INSERT INTO `material_price` VALUES (28, '샷시', '휴그린_32평', 720);
INSERT INTO `material_price` VALUES (29, '샷시', '휴그린_37평', 870);
INSERT INTO `material_price` VALUES (30, '샷시', '휴그린_45평', 940);
INSERT INTO `material_price` VALUES (31, '샷시', '휴그린_48평', 1000);
INSERT INTO `material_price` VALUES (32, '인건비', '조공(전기)', 20);
INSERT INTO `material_price` VALUES (33, '인건비', '기공(전기)', 30);
INSERT INTO `material_price` VALUES (34, '스위치', '진흥전기_1구', 0.2);
INSERT INTO `material_price` VALUES (35, '스위치', '진흥전기_2구', 0.3);
INSERT INTO `material_price` VALUES (36, '스위치', '진흥전기_3구', 0.35);
INSERT INTO `material_price` VALUES (37, '스위치', '진흥전기_4구', 0.5);
INSERT INTO `material_price` VALUES (38, '스위치', '진흥전기_5구', 0.6);
INSERT INTO `material_price` VALUES (39, '스위치', '진흥전기_6구', 0.7);
INSERT INTO `material_price` VALUES (40, '스위치', '나노전기_1구', 0.25);
INSERT INTO `material_price` VALUES (41, '스위치', '나노전기_2구', 0.3);
INSERT INTO `material_price` VALUES (42, '스위치', '나노전기_3구', 0.4);
INSERT INTO `material_price` VALUES (43, '스위치', '나노전기_4구', 0.63);
INSERT INTO `material_price` VALUES (44, '스위치', '나노전기_5구', 0.7);
INSERT INTO `material_price` VALUES (45, '스위치', '나노전기_6구', 0.8);
INSERT INTO `material_price` VALUES (46, '스위치', '르그랑아펠라_1구', 0.35);
INSERT INTO `material_price` VALUES (47, '스위치', '르그랑아펠라_2구', 0.55);
INSERT INTO `material_price` VALUES (48, '스위치', '르그랑아펠라_3구', 0.65);
INSERT INTO `material_price` VALUES (49, '스위치', '르그랑아펠라_4구', 1);
INSERT INTO `material_price` VALUES (50, '스위치', '르그랑아펠라_5구', 1.15);
INSERT INTO `material_price` VALUES (51, '스위치', '르그랑아펠라_6구', 1.27);
INSERT INTO `material_price` VALUES (52, '스위치', '르그랑아테오_1구', 2.3);
INSERT INTO `material_price` VALUES (53, '스위치', '르그랑아테오_2구', 2.8);
INSERT INTO `material_price` VALUES (54, '스위치', '르그랑아테오_3구', 3.6);
INSERT INTO `material_price` VALUES (55, '스위치', '르그랑아테오_4구', 5.4);
INSERT INTO `material_price` VALUES (56, '스위치', '르그랑아테오_5구', 5.9);
INSERT INTO `material_price` VALUES (57, '스위치', '르그랑아테오_6구', 6.5);
INSERT INTO `material_price` VALUES (58, '스위치', '융_1구', 5.5);
INSERT INTO `material_price` VALUES (59, '스위치', '융_2구', 7.25);
INSERT INTO `material_price` VALUES (60, '스위치', '융_3구', 10.25);
INSERT INTO `material_price` VALUES (61, '스위치', '융_4구', 12.75);
INSERT INTO `material_price` VALUES (62, '스위치', '융_5구', 15.25);
INSERT INTO `material_price` VALUES (63, '스위치', '융_6구', 18);
INSERT INTO `material_price` VALUES (64, '콘센트', '진흥전기_1구', 0.2);
INSERT INTO `material_price` VALUES (65, '콘센트', '진흥전기_2구', 0.25);
INSERT INTO `material_price` VALUES (66, '콘센트', '진흥전기_4구', 0.46);
INSERT INTO `material_price` VALUES (67, '콘센트', '나노전기_1구', 0.25);
INSERT INTO `material_price` VALUES (68, '콘센트', '나노전기_2구', 0.37);
INSERT INTO `material_price` VALUES (69, '콘센트', '나노전기_4구', 0.5);
INSERT INTO `material_price` VALUES (70, '콘센트', '르그랑아펠라_1구', 0.35);
INSERT INTO `material_price` VALUES (71, '콘센트', '르그랑아펠라_2구', 0.45);
INSERT INTO `material_price` VALUES (72, '콘센트', '르그랑아펠라_4구', 0.75);
INSERT INTO `material_price` VALUES (73, '콘센트', '르그랑아테오_1구', 2);
INSERT INTO `material_price` VALUES (74, '콘센트', '르그랑아테오_2구', 2.2);
INSERT INTO `material_price` VALUES (75, '콘센트', '르그랑아테오_4구', 4);
INSERT INTO `material_price` VALUES (76, '콘센트', '융_1구', 5.3);
INSERT INTO `material_price` VALUES (77, '콘센트', '융_2구', 10.75);
INSERT INTO `material_price` VALUES (78, '콘센트', '융_3구', 15.75);
INSERT INTO `material_price` VALUES (79, '콘센트', '융_4구', 21.7);
INSERT INTO `material_price` VALUES (80, '콘센트', '융_5구', 27.75);
INSERT INTO `material_price` VALUES (81, '콘센트', '진흥전기_1구(방우)', 0.3);
INSERT INTO `material_price` VALUES (82, '콘센트', '진흥전기_2구(방우)', 0.35);
INSERT INTO `material_price` VALUES (83, '콘센트', '나노전기_1구(방우)', 0.3);
INSERT INTO `material_price` VALUES (84, '콘센트', '나노전기_2구(방우)', 0.35);
INSERT INTO `material_price` VALUES (85, '콘센트', '나노전기_4구(방우)', 0.8);
INSERT INTO `material_price` VALUES (86, '콘센트', '르그랑아펠라_1구(방우)', 0.5);
INSERT INTO `material_price` VALUES (87, '콘센트', '르그랑아펠라_2구(방우)', 0.6);
INSERT INTO `material_price` VALUES (88, '콘센트', '르그랑아테오_1구(방우)', 0.5);
INSERT INTO `material_price` VALUES (89, '콘센트', '르그랑아테오_2구(방우)', 0.6);
INSERT INTO `material_price` VALUES (96, '에어컨', '실내기_2대', 350);
INSERT INTO `material_price` VALUES (97, '에어컨', '실내기_3대', 450);
INSERT INTO `material_price` VALUES (98, '에어컨', '실내기_4대', 550);
INSERT INTO `material_price` VALUES (99, '조명', '벽등_직부등', 4);
INSERT INTO `material_price` VALUES (100, '조명', '라인조명', 30);
INSERT INTO `material_price` VALUES (101, '조명', '간접조명_m당', 0.2);
INSERT INTO `material_price` VALUES (102, '조명', '마그네틱트랙_m당', 7);
INSERT INTO `material_price` VALUES (103, '조명', '마그네틱조명_개당', 8);
INSERT INTO `material_price` VALUES (104, '조명', '매립등_개당', 1.2);
INSERT INTO `material_price` VALUES (105, '목공', '히든도어', 300);
INSERT INTO `material_price` VALUES (106, '목공', '히든도어_벽체공사', 400);
INSERT INTO `material_price` VALUES (109, '목공', '9mm도어', 200);
INSERT INTO `material_price` VALUES (110, '목공', '9mm도어_벽체공사', 150);
INSERT INTO `material_price` VALUES (114, '목공', '우물천장', 230);
INSERT INTO `material_price` VALUES (115, '목공 ', '커튼박스', 20);
INSERT INTO `material_price` VALUES (116, '목공', '몰딩공사', 130);
INSERT INTO `material_price` VALUES (117, '목공', '천정공사', 150);
INSERT INTO `material_price` VALUES (118, '목공', '벽체공사', 100);
INSERT INTO `material_price` VALUES (119, '목공', '단열공사', 170);
INSERT INTO `material_price` VALUES (120, '인건비', '타일', 25);
INSERT INTO `material_price` VALUES (121, '인건비', '타일', 35);
INSERT INTO `material_price` VALUES (122, '타일', '300 x 300각_포세린타일', 1.7);
INSERT INTO `material_price` VALUES (123, '타일', '300 x 600각_포세린타일', 3.7);
INSERT INTO `material_price` VALUES (124, '타일', '600 x 600각_포세린타일', 6);
INSERT INTO `material_price` VALUES (125, '타일', '600 x 1200각_포세린타일', 12);
INSERT INTO `material_price` VALUES (126, '타일', '1200 x 1200각_포세린타일', 20);
INSERT INTO `material_price` VALUES (127, '타일', '300 x 300각_폴리싱타일', 1.7);
INSERT INTO `material_price` VALUES (128, '타일', '300 x 600각_폴리싱타일', 3.7);
INSERT INTO `material_price` VALUES (129, '타일', '600 x 600각_폴리싱타일', 6);
INSERT INTO `material_price` VALUES (130, '타일', '600 x 1200각_폴리싱타일', 12);
INSERT INTO `material_price` VALUES (131, '타일', '1200 x 1200각_폴리싱타일', 20);
INSERT INTO `material_price` VALUES (132, '타일부자재', '세라픽스(타일본드)_20kg ', 2.7);
INSERT INTO `material_price` VALUES (133, '타일부자재', '레미탈_25kg', 0.75);
INSERT INTO `material_price` VALUES (134, '타일부자재', '에폭시_20kg', 5.7);
INSERT INTO `material_price` VALUES (135, '타일부자재', '드라이픽스(난방용)_ 20kg', 1.5);
INSERT INTO `material_price` VALUES (136, '타일부자재', '드라이픽스_20kg', 1.3);
INSERT INTO `material_price` VALUES (137, '타일부자재 ', '압착시멘트_20kg', 0.9);
INSERT INTO `material_price` VALUES (138, '타일부자재', '메지(줄눈)_2kg', 0.2);
INSERT INTO `material_price` VALUES (139, '타일부자재', '아덱스 메지(줄눈)_2kg', 0.8);
INSERT INTO `material_price` VALUES (140, '타일부자재', '케라폭시(줄눈)_5kg', 9.5);
INSERT INTO `material_price` VALUES (141, '인건비 ', '도기(화장실)_욕실(한칸당)', 22);
INSERT INTO `material_price` VALUES (143, '화장실 공사', '대림바스_세면대', 13);
INSERT INTO `material_price` VALUES (144, '화장실 공사', '대림바스_양변기', 20);
INSERT INTO `material_price` VALUES (145, '화장실 공사', '대림바스_세면수전', 5);
INSERT INTO `material_price` VALUES (146, '화장실 공사', '대림바스_샤워수전', 9);
INSERT INTO `material_price` VALUES (147, '화장실 공사 ', '대림바스_욕조수전', 15);
INSERT INTO `material_price` VALUES (148, '화장실 공사', '대림바스_수건걸이', 2.3);
INSERT INTO `material_price` VALUES (149, '화장실 공사 ', '대림바스_휴지걸이', 6);
INSERT INTO `material_price` VALUES (151, '화장실 공사', '대림바스_슬라이딩장/욕실장', 15);
INSERT INTO `material_price` VALUES (152, '화장실 공사', '대림바스_욕조', 25);
INSERT INTO `material_price` VALUES (153, '화장실 공사', '대림바스_샤워기거치대', 6);
INSERT INTO `material_price` VALUES (154, '화장실 공사 ', '대림바스_비데', 55);
INSERT INTO `material_price` VALUES (155, '화장실 공사', '대림바스_일체형비데 ', 90);
INSERT INTO `material_price` VALUES (156, '화장실 공사 ', '크린스_세면대', 10);
INSERT INTO `material_price` VALUES (157, '화장실 공사', '크린스_양변기', 15);
INSERT INTO `material_price` VALUES (158, '화장실 공사', '크린스_수전', 6);
INSERT INTO `material_price` VALUES (159, '화장실 공사 ', '아메리칸 스탠다드_세면대', 16);
INSERT INTO `material_price` VALUES (160, '화장실 공사 ', '아메리칸 스탠다드_양변기', 30);
INSERT INTO `material_price` VALUES (161, '화장실 공사 ', '아메리칸 스탠다드_세면기 수전', 14);
INSERT INTO `material_price` VALUES (162, '화장실 공사 ', '아메리칸 스탠다드_샤워기 수전', 25);
INSERT INTO `material_price` VALUES (163, '화장실 공사 ', '아메리칸 스탠다드_욕조 수전', 50);
INSERT INTO `material_price` VALUES (164, '화장실 공사', '아메리칸 스탠다드_레인샤워 (해바라기 샤워)', 42);
INSERT INTO `material_price` VALUES (165, '화장실 공사 ', '아메리칸 스탠다드_매립수전', 32);
INSERT INTO `material_price` VALUES (166, '화장실 공사', '아메리칸 스탠다드_수건걸이', 6.5);
INSERT INTO `material_price` VALUES (167, '화장실 공사 ', '아메리칸 스탠다드_휴지걸이', 11);
INSERT INTO `material_price` VALUES (168, '화장실 공사', '아메리칸 스탠다드_일체형비데', 100);
INSERT INTO `material_price` VALUES (169, '화장실 공사', '아메리칸 스탠다드_비데 ', 25);
INSERT INTO `material_price` VALUES (170, '화장실 공사 ', '아메리칸 스탠다드_욕조', 30);
INSERT INTO `material_price` VALUES (171, '화장실 공사 ', '아메리칸 스탠다드_악세사리', 7);
INSERT INTO `material_price` VALUES (172, '화장실 공사 ', '그로헤_세면기', 28);
INSERT INTO `material_price` VALUES (173, '화장실 공사 ', '그로헤_양변기', 50);
INSERT INTO `material_price` VALUES (174, '화장실 공사 ', '그로헤_샤워욕조수전', 70);
INSERT INTO `material_price` VALUES (175, '화장실 공사', '그로헤_세면기수전', 85);
INSERT INTO `material_price` VALUES (176, '화장실 공사 ', '그로헤_싱크수전', 75);
INSERT INTO `material_price` VALUES (177, '화장실 공사', '그로헤_매립수전', 45);
INSERT INTO `material_price` VALUES (178, '화장실 공사 ', '그로헤_매립욕조수전', 76);
INSERT INTO `material_price` VALUES (179, '화장실 공사', '그로헤_수건걸이', 12);
INSERT INTO `material_price` VALUES (180, '화장실 공사 ', '그로헤_휴지걸이', 7.5);
INSERT INTO `material_price` VALUES (181, '화장실 공사 ', '슬라이드장_욕실장', 25);
INSERT INTO `material_price` VALUES (182, '화장실 공사', '이노솔(욕실 천장재)_욕실 한칸', 27);
INSERT INTO `material_price` VALUES (183, '화장실 공사', 'SMC(욕실 천장재)_욕실 한칸', 12);
INSERT INTO `material_price` VALUES (184, '화장실 공사', '힘펠_환풍기', 7.5);
INSERT INTO `material_price` VALUES (185, '화장실 공사 ', '힘펠 휴젠트_환풍기', 40);
INSERT INTO `material_price` VALUES (186, '화장실 공사', '하츠_환풍기', 4);
INSERT INTO `material_price` VALUES (187, '화장실 공사', '하츠 티오람_환풍기', 30);
INSERT INTO `material_price` VALUES (188, '화장실 공사', '욕조', 13);
INSERT INTO `material_price` VALUES (189, '화장실 공사', '파티션', 25);
INSERT INTO `material_price` VALUES (190, '인건비', '필름 ', 25);
INSERT INTO `material_price` VALUES (191, '필름지', 'LG하우시스_1롤', 15);
INSERT INTO `material_price` VALUES (192, '필름지 ', '영림_1롤', 15);
INSERT INTO `material_price` VALUES (193, '필름지', '예림_1롤', 15);
INSERT INTO `material_price` VALUES (194, '필름지', '선우드_1롤', 15);
INSERT INTO `material_price` VALUES (195, '필름지', '우딘 _1롤', 15);
INSERT INTO `material_price` VALUES (196, '필름지', '레놀릿 _1롤', 35);
INSERT INTO `material_price` VALUES (197, '인건비', '도배', 25);
INSERT INTO `material_price` VALUES (198, '도배지', '합지벽지_평당', 3);
INSERT INTO `material_price` VALUES (199, '도배지', '합지벽지_평당', 5);
INSERT INTO `material_price` VALUES (200, '인건비 ', '도장(페인트)', 30);
INSERT INTO `material_price` VALUES (201, '도장 ', '삼화페인트', 10);
INSERT INTO `material_price` VALUES (202, '도장', '노루페인트', 10);
INSERT INTO `material_price` VALUES (203, '도장', '벤자민무어_1말 = 18L', 50);
INSERT INTO `material_price` VALUES (204, '도장', '던에드워드_1말 = 18L', 70);
INSERT INTO `material_price` VALUES (205, '도장', '발페인트_10L', 160);
INSERT INTO `material_price` VALUES (206, '인건비', '마루_평당', 2.2);
INSERT INTO `material_price` VALUES (207, '마루', '구정마루_강마루_평당', 8);
INSERT INTO `material_price` VALUES (208, '마루', '구정마루_천연마루_평당', 11);
INSERT INTO `material_price` VALUES (209, '마루', '구정마루_원목마루_평당', 13);
INSERT INTO `material_price` VALUES (210, '마루', '구정마루_대리석마루_평당', 14);
INSERT INTO `material_price` VALUES (211, '마루', '이건마루_강마루_평당', 10);
INSERT INTO `material_price` VALUES (212, '마루', '이건마루_천연마루_평당', 13);
INSERT INTO `material_price` VALUES (213, '마루', '이건마루_원목마루', 17);
INSERT INTO `material_price` VALUES (214, '마루', '동화자연마루_강화마루_평당', 7);
INSERT INTO `material_price` VALUES (215, '마루', '동화자연마루_강마루_평당', 9);
INSERT INTO `material_price` VALUES (216, '마루', '동화자연마루_원목마루_평당', 16);
INSERT INTO `material_price` VALUES (217, '마루', '동화자연마루_천연대리석_평당', 40);
INSERT INTO `material_price` VALUES (218, '가구', '붙박이장', 120);
INSERT INTO `material_price` VALUES (219, '가구', '상부장', 100);
INSERT INTO `material_price` VALUES (220, '가구', '신발장', 90);
INSERT INTO `material_price` VALUES (221, '가구', '냉장고장', 120);
INSERT INTO `material_price` VALUES (222, '가구', '싱크대', 250);
INSERT INTO `material_price` VALUES (223, '인건비', '실리콘', 25);
INSERT INTO `material_price` VALUES (224, '인건비', '입주청소_평당', 1.4);
INSERT INTO `material_price` VALUES (225, '인건비', '설비', 35);
INSERT INTO `material_price` VALUES (226, '설비', '확장공사', 150);
INSERT INTO `material_price` VALUES (227, '설비', '화장실방수', 75);
INSERT INTO `material_price` VALUES (228, '도장', '탄성코트_발코니시공', 65);
INSERT INTO `material_price` VALUES (229, '행위허가', '확장신고', 55);
INSERT INTO `material_price` VALUES (230, '보양', '엘레베이터보양', 20);
INSERT INTO `material_price` VALUES (231, '동의서', '공사동의서', 30);
INSERT INTO `material_price` VALUES (232, '인터폰', '인터폰', 20);
INSERT INTO `material_price` VALUES (233, '도어락', '도어락', 40);
INSERT INTO `material_price` VALUES (234, '실링펜', '루씨에어', 50);

SET FOREIGN_KEY_CHECKS = 1;
