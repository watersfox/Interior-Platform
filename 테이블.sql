DROP TABLE IF EXISTS `Company`;

CREATE TABLE `Company` (
	`companyNumber`	bigint(20)	NOT NULL,
	`name`	varchar(255)	NOT NULL,
	`phone`	varchar(11)	NOT NULL,
	`ceoName`	varchar(255)	NOT NULL,
	`content`	varchar(255)	NULL,
	`careerYears`	int(3)	NOT NULL,
	`address`	varchar(255)	NOT NULL,
	`createdDate`	timestamp	NOT NULL
);

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
	`userId`	varchar(20)	NOT NULL,
	`nickname`	varchar(255)	NOT NULL	COMMENT 'unique',
	`password`	varchar(255)	NOT NULL,
	`name`	varchar(100)	NOT NULL,
	`phone`	varchar(11)	NOT NULL,
	`email`	varchar(255)	NOT NULL,
	`createdDate`	timestamp	NOT NULL,
	`introduce`	varchar(255)	NULL,
	`imageUrl`	text	NULL
);

DROP TABLE IF EXISTS `Review`;

CREATE TABLE `Review` (
	`reviewNumber`	bigint(20)	NOT NULL,
	`userId`	varchar(20)	NOT NULL,
	`companyNumber`	bigint(20)	NOT NULL,
	`title`	varchar(255)	NOT NULL,
	`content`	varchar(255)	NULL,
	`rating`	int(1)	NOT NULL,
	`createdDate`	timestamp	NOT NULL,
	`modifiedDate`	timestamp	NOT NULL
);

DROP TABLE IF EXISTS `LocationCode`;

CREATE TABLE `LocationCode` (
	`locationCode`	varchar(3)	NOT NULL,
	`name`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `COM_LOC`;

CREATE TABLE `COM_LOC` (
	`companyNumber`	bigint(20)	NOT NULL,
	`locationCode`	varchar(3)	NOT NULL
);

DROP TABLE IF EXISTS `WorkExample`;

CREATE TABLE `WorkExample` (
	`workExNO`	bigint(20)	NOT NULL,
	`companyNumber`	bigint(20)	NOT NULL,
	`title`	text	NOT NULL,
	`content`	varchar(255)	NULL,
	`address`	varchar(255)	NOT NULL,
	`pyeong`	int(3)	NOT NULL,
	`workType`	varchar(6)	NOT NULL,
	`workPrice`	bigint(20)	NOT NULL,
	`workWeeks`	int(3)	NOT NULL,
	`createdDate`	timestamp	NOT NULL,
	`modifiedDate`	timestamp	NOT NULL
);

DROP TABLE IF EXISTS `InteriorWork`;

CREATE TABLE `InteriorWork` (
	`workNumber`	bigint(20)	NOT NULL,
	`companyNumber`	bigint(20)	NOT NULL,
	`userId`	varchar(20)	NOT NULL,
	`address`	varchar(255)	NOT NULL,
	`workDate`	date	NOT NULL,
	`workType`	varchar(6)	NOT NULL,
	`workWeeks`	int(3)	NOT NULL,
	`pyeong`	int(3)	NOT NULL,
	`workPrice`	bigint(20)	NOT NULL,
	`createdDate`	timestamp	NOT NULL
);

DROP TABLE IF EXISTS `WorkType`;

CREATE TABLE `WorkType` (
	`companyNumber`	bigint(20)	NOT NULL,
	`workType`	varchar(6)	NOT NULL
);

DROP TABLE IF EXISTS `Comment`;

CREATE TABLE `Comment` (
	`commentNumber`	bigint(20)	NOT NULL,
	`userId`	varchar(20)	NOT NULL,
	`postNumber`	bigint(20)	NOT NULL,
	`content`	varchar(255)	NULL,
	`class`	int(1)	NOT NULL	DEFAULT 0,
	`bundleId`	bigint(20)	NOT NULL,
	`bundleOrder`	bigint(20)	NOT NULL,
	`isDeleted`	boolean	NOT NULL,
	`createdDate`	timestamp	NOT NULL,
	`modifiedDate`	timestamp	NOT NULL,
	`deletedDate`	timestamp	NOT NULL
);

DROP TABLE IF EXISTS `CommunityPost`;

CREATE TABLE `CommunityPost` (
	`postNumber`	bigint(20)	NOT NULL,
	`userId`	varchar(20)	NOT NULL,
	`title`	varchar(255)	NOT NULL,
	`content`	varchar(255)	NULL,
	`views`	bigint(20)	NOT NULL,
	`commentCnt`	bigint(20)	NULL,
	`createdDate`	timestamp	NOT NULL,
	`modifiedDate`	timestamp	NOT NULL
);

DROP TABLE IF EXISTS `PostLikes`;

CREATE TABLE `PostLikes` (
	`postLikesId`	bigint(20)	NOT NULL,
	`userId`	varchar(20)	NOT NULL,
	`postNumber`	bigint(20)	NOT NULL
);

DROP TABLE IF EXISTS `CommentLikes`;

CREATE TABLE `CommentLikes` (
	`commentLikesId`	bigint(20)	NOT NULL,
	`userId`	varchar(20)	NOT NULL,
	`commentNumber`	bigint(20)	NOT NULL
);

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
	`followId`	bigint(20)	NOT NULL,
	`followingId`	varchar(20)	NOT NULL,
	`followerId`	varchar(20)	NOT NULL
);

ALTER TABLE `Company` ADD CONSTRAINT `PK_COMPANY` PRIMARY KEY (
	`companyNumber`
);

ALTER TABLE `Customer` ADD CONSTRAINT `PK_CUSTOMER` PRIMARY KEY (
	`userId`
);

ALTER TABLE `Review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`reviewNumber`
);

ALTER TABLE `LocationCode` ADD CONSTRAINT `PK_LOCATIONCODE` PRIMARY KEY (
	`locationCode`
);

ALTER TABLE `COM_LOC` ADD CONSTRAINT `PK_COM_LOC` PRIMARY KEY (
	`companyNumber`,
	`locationCode`
);

ALTER TABLE `WorkExample` ADD CONSTRAINT `PK_WORKEXAMPLE` PRIMARY KEY (
	`workExNO`
);

ALTER TABLE `InteriorWork` ADD CONSTRAINT `PK_INTERIORWORK` PRIMARY KEY (
	`workNumber`
);

ALTER TABLE `WorkType` ADD CONSTRAINT `PK_WORKTYPE` PRIMARY KEY (
	`companyNumber`
);

ALTER TABLE `Comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`commentNumber`
);

ALTER TABLE `CommunityPost` ADD CONSTRAINT `PK_COMMUNITYPOST` PRIMARY KEY (
	`postNumber`
);

ALTER TABLE `PostLikes` ADD CONSTRAINT `PK_POSTLIKES` PRIMARY KEY (
	`postLikesId`
);

ALTER TABLE `CommentLikes` ADD CONSTRAINT `PK_COMMENTLIKES` PRIMARY KEY (
	`commentLikesId`
);

ALTER TABLE `follow` ADD CONSTRAINT `PK_FOLLOW` PRIMARY KEY (
	`followId`
);

ALTER TABLE `Review` ADD CONSTRAINT `FK_Customer_TO_Review_1` FOREIGN KEY (
	`userId`
)
REFERENCES `Customer` (
	`userId`
);

ALTER TABLE `Review` ADD CONSTRAINT `FK_Company_TO_Review_1` FOREIGN KEY (
	`companyNumber`
)
REFERENCES `Company` (
	`companyNumber`
);

ALTER TABLE `COM_LOC` ADD CONSTRAINT `FK_Company_TO_COM_LOC_1` FOREIGN KEY (
	`companyNumber`
)
REFERENCES `Company` (
	`companyNumber`
);

ALTER TABLE `COM_LOC` ADD CONSTRAINT `FK_LocationCode_TO_COM_LOC_1` FOREIGN KEY (
	`locationCode`
)
REFERENCES `LocationCode` (
	`locationCode`
);

ALTER TABLE `WorkExample` ADD CONSTRAINT `FK_Company_TO_WorkExample_1` FOREIGN KEY (
	`companyNumber`
)
REFERENCES `Company` (
	`companyNumber`
);

ALTER TABLE `InteriorWork` ADD CONSTRAINT `FK_Company_TO_InteriorWork_1` FOREIGN KEY (
	`companyNumber`
)
REFERENCES `Company` (
	`companyNumber`
);

ALTER TABLE `InteriorWork` ADD CONSTRAINT `FK_Customer_TO_InteriorWork_1` FOREIGN KEY (
	`userId`
)
REFERENCES `Customer` (
	`userId`
);

ALTER TABLE `WorkType` ADD CONSTRAINT `FK_Company_TO_WorkType_1` FOREIGN KEY (
	`companyNumber`
)
REFERENCES `Company` (
	`companyNumber`
);

ALTER TABLE `Comment` ADD CONSTRAINT `FK_Customer_TO_Comment_1` FOREIGN KEY (
	`userId`
)
REFERENCES `Customer` (
	`userId`
);

ALTER TABLE `Comment` ADD CONSTRAINT `FK_CommunityPost_TO_Comment_1` FOREIGN KEY (
	`postNumber`
)
REFERENCES `CommunityPost` (
	`postNumber`
);

ALTER TABLE `CommunityPost` ADD CONSTRAINT `FK_Customer_TO_CommunityPost_1` FOREIGN KEY (
	`userId`
)
REFERENCES `Customer` (
	`userId`
);

ALTER TABLE `PostLikes` ADD CONSTRAINT `FK_Customer_TO_PostLikes_1` FOREIGN KEY (
	`userId`
)
REFERENCES `Customer` (
	`userId`
);

ALTER TABLE `PostLikes` ADD CONSTRAINT `FK_CommunityPost_TO_PostLikes_1` FOREIGN KEY (
	`postNumber`
)
REFERENCES `CommunityPost` (
	`postNumber`
);

ALTER TABLE `CommentLikes` ADD CONSTRAINT `FK_Customer_TO_CommentLikes_1` FOREIGN KEY (
	`userId`
)
REFERENCES `Customer` (
	`userId`
);

ALTER TABLE `CommentLikes` ADD CONSTRAINT `FK_Comment_TO_CommentLikes_1` FOREIGN KEY (
	`commentNumber`
)
REFERENCES `Comment` (
	`commentNumber`
);

ALTER TABLE `follow` ADD CONSTRAINT `FK_Customer_TO_follow_1` FOREIGN KEY (
	`followingId`
)
REFERENCES `Customer` (
	`userId`
);

ALTER TABLE `follow` ADD CONSTRAINT `FK_Customer_TO_follow_2` FOREIGN KEY (
	`followerId`
)
REFERENCES `Customer` (
	`userId`
);

