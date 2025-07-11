-- 清理后的智慧党建系统数据库SQL文件
-- 生成时间: 2025-06-07 11:44:13
-- 注意: 此文件仅包含必要的系统配置和示例数据，不包含任何业务数据或个人信息

-- 表结构: ad_partygroup
DROP TABLE IF EXISTS `ad_partygroup`;
CREATE TABLE `ad_partygroup` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `PARENTID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父级Id',
  `NAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
  `FULLIDS` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '树节点Id集合逗号分隔',
  `SORT` decimal(8,0) DEFAULT NULL COMMENT '排序',
  `CREATEUSERID` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFYUSERID` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '最后修改人',
  `MODIFYTIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 ad_partygroup 数据已清理，仅保留表结构

-- 表结构: ap_modular
DROP TABLE IF EXISTS `ap_modular`;
CREATE TABLE `ap_modular` (
  `MID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `MODULARGROUP` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MODULARNAME` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ORDERBY` int DEFAULT NULL,
  `PARENTID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ICON` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MODULARNO` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MODULARGROUPTYPE` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`MID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 ap_modular 数据已清理，仅保留表结构

-- 表结构: ap_rolemodular
DROP TABLE IF EXISTS `ap_rolemodular`;
CREATE TABLE `ap_rolemodular` (
  `RMID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `MODULARID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ROLEID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISCOMMONUSE` int DEFAULT NULL,
  `ORDERBY` int DEFAULT NULL,
  PRIMARY KEY (`RMID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 ap_rolemodular 数据已清理，仅保留表结构

-- 表结构: ap_userusemodular
DROP TABLE IF EXISTS `ap_userusemodular`;
CREATE TABLE `ap_userusemodular` (
  `UUMID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `MODULARID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERID` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ORDERBY` int DEFAULT NULL,
  `ISDISPLAY` int NOT NULL,
  `ROLEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`UUMID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 ap_userusemodular 数据已清理，仅保留表结构

-- 表结构: cf_applications
DROP TABLE IF EXISTS `cf_applications`;
CREATE TABLE `cf_applications` (
  `APPLICATIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLICATIONNAME` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`APPLICATIONID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='系统标识表';

-- 表数据: cf_applications (保留 1 条记录)
INSERT INTO `cf_applications` VALUES ('766e0491-2d0c-4e5d-90a0-8538186ef645','测试','数据库操作');

-- 表结构: cf_dictionary
DROP TABLE IF EXISTS `cf_dictionary`;
CREATE TABLE `cf_dictionary` (
  `DICTIONARYID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DICKEY` int DEFAULT NULL,
  `DICVALUE` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DICTYPEKEY` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DICTYPE` int DEFAULT NULL COMMENT '1.系统\r\n  2.普通',
  `APPLICATIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DICNOTE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `OPERATETIME` datetime DEFAULT NULL,
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`DICTIONARYID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: cf_dictionary (保留全部基础配置数据)
INSERT INTO `cf_dictionary` VALUES ('007233a7-8d6e-4c31-ac05-410323984d7e',2,'群众','PoliticsStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('0089b9ac-8243-4697-a6ba-c82edfde84a3',2,'不通过','trainingResult',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:04:14','A','N'),('01c0d0d5-40c1-4c3a-aa5a-fe5b23c1a0b4',1,'待审核','decisionStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('0253b8b4-c495-4dc2-a3d1-d401dd6e7e01',10,'会计硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('0274fa93-817f-4de1-8753-c1c6f44a2f12',1,'男','dic_sex',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-21 15:14:32','A','N'),('03141dfa-40d0-4f71-be6a-bc0aedd5e654',2,'岗位技能','cgjqProjectNameOfPost',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('04476bc1-8d55-4bb5-a881-8dfba830a5aa',4,'学习计划通知','messageType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 15:16:08','M','N'),('04c61a9f-f220-4ca0-b030-498f73c2b083',2,'党委副职','dwgzzType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('04c90757-e1a8-11ed-be89-7085c2a9999e',1,'年度学习计划','LearningPlanType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-23 13:51:41','A','N'),('04c907cc-e1a8-11ed-be89-7085c2a9999e',2,'月度学习计划','LearningPlanType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-23 13:51:48','A','N'),('04c907da-e1a8-11ed-be89-7085c2a9999e',3,'专题学习计划','LearningPlanType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-23 13:51:59','A','N'),('04c907e6-e1a8-11ed-be89-7085c2a9999e',4,'临时学习计划','LearningPlanType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-23 13:51:59','A','N'),('04c907f0-e1a8-11ed-be89-7085c2a9999e',1,'暂存','LearningPlanPublicStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-23 13:51:41','A','N'),('04c907fb-e1a8-11ed-be89-7085c2a9999e',2,'已发布','LearningPlanPublicStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-23 13:51:48','A','N'),('0534274E0F3F4935A8C8B376CE9C727B',6,'年份(2000),('058a7fc0-7417-49db-a0bc-bdb74a278a72',3,'辅导讲座','zxzxxxxfaxxxs',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习学习形式字典','2019-09-26 15:13:15','M','N'),('0790a15a-d1cd-11ec-ac8e-7085c2a9999e',1,'待审核','ApplyApproveStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-05-17 14:21:00','A','N'),('0790a184-d1cd-11ec-ac8e-7085c2a9999e',2,'通过','ApplyApproveStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-05-17 14:21:00','A','N'),('0790a186-d1cd-11ec-ac8e-7085c2a9999e',3,'不通过','ApplyApproveStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-05-17 14:21:00','A','N'),('07c7f966-4a79-445e-9014-e1165a5b8e75',6,'落实联系点制度','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:04:12','A','N'),('09a8ea89-1079-45a1-862d-d36b943c0a34',4,'已批阅','TestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-18 00:00:00','M','N'),('0b2c7485-6cc3-4034-b85e-c294d3297c91',1,'政治素质','cgjqProjectNameOfPost',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('0b63575a-3971-4c2f-a8a5-5309df468cd9',1,'典型个例','thoughtType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:06:10','A','N'),('0bf82a62-5bee-4ee6-12e1-66601d801214',1,'好','ReviewLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('0bf82a62-5bee-4ee6-a4e1-66601d801214',1,'运输站段','zzfb',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-30 10:26:59','A','N'),('0bf82a62-5bee-77e6-12e1-66601d801214',3,'待考评','ArrangeRecordStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('0bf82a62-5bee-88e6-12e1-66601d801214',1,'未提交','ArrangeRecordStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('0c21465e-8c28-4165-8a33-b41beb7bbad6',5,'落实请示报告制度','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:04:02','A','N'),('0c695f1a-f5b0-4485-9c74-24cbe41ef6c5',1,'提交','fqtgStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-08 16:20:07','A','N'),('0ca5aafc-76f6-4d8e-b023-e5815d98e8d2',1,'已上报','handleState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:08:50','A','N'),('0df6d587-c03c-4a8c-bc57-f5fb188a5c59',2,'院系跟进','handleLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:57:17','M','N'),('0e4f0a14-f663-4812-ba28-84481f847e12',2,'副处','LeaderTeamPositionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('0ea72fc2-9d6e-4635-9629-16465a040fe2',21,'\"七一\"表彰奖励','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-23 14:13:25','M','N'),('0f505052-f1c5-48b2-b92c-52a1da5da541',3,'其它','thoughtType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:06:28','A','N'),('10086794-b9c4-48b3-bb0f-729191dc8b71',17,'硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('103dd852-5873-4e42-a441-731714c287a8',2,'科级干部信息','LeaderteamType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('10fe8219-4e50-4598-8295-51cf11b49acb',1,'正常使用','AssetState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-12-10 14:16:31','M','N'),('1111601e-6f8d-4ee0-1234-59544457f1c5',1,'难','QuestionDifficulty',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-08-24 00:00:00','M','N'),('113de540-b16a-11ec-829d-7085c2a9999e',1,'组织生活会','PartyLifeMeetingType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('1194b3e733904b2582e6f65a3c2fef88',1,'回顾入党过程，重温入党初心。','ZzsrType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-06-24 14:47:34','M','N'),('11f4dba0-4fd9-41e0-af01-9c1a3f8abbba',1,'主观题','ObjectiveType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-13 00:00:00','A','N'),('12115f95-2375-49de-8b96-49142738f7d3',7,'工学学士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('12f82a62-5bee-4ee6-a4e1-66601d801214',1,'启用','EnableStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-02 00:00:00','A','N'),('13865046-8c11-499e-ab5d-98dec4afe3b6',2,'禁用','EnableStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-02 00:00:00','A','N'),('15cc7f11-b0b8-4837-97e7-207ea9901b33',1,'微信','djWxGroup_implatform',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-19 14:34:48','M','N'),('1617641d20364c0cbe5ed18bed0bd5cf',2,'评卷','JoinTestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-06-28 00:00:00','A','Y'),('1697f761-30fc-4b93-b3b9-d3e66a9dde42',3,'报备完成','shykStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','党委审核通过为报备完成','2019-08-26 10:46:37','M','Y'),('17455b74-6bff-475c-aacc-a173acf6009a',5,'积分奖励','cgjqProjectNameOfPost',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('181e2c08-d41e-4d0f-b238-9517f9fe8f35',3,'会议取消通知','messageType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('1873d1aa-ac1b-4b53-93f3-b9482fd9ab7b',3,'其它','djWxGroup_msgType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 15:59:28','A','N'),('1908681f-932c-4b36-9d1b-f3c3dd62aaf6',2,'广东','nativeplaceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:04:45','D','N'),('193a88e3-a102-4d86-b599-4a32863ef058',1,'院系级','positionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:58:23','M','N'),('1a69c162-2afc-484c-be56-d7739829170c',4,'D','psiLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-09 19:36:03','D','N'),('1a8ff0db-1ea5-4ae1-9857-a68f5f833998',1,'课程整体评价','shykEvaluateType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-18 16:44:40','A','N'),('1a94d52a-63e6-4a71-a150-db49811181b3',13,'经济学学士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('1b8be67b375f4026a010e48eea051f26',1,'根级别','mhflJbType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('1c05113c-b339-4145-94c7-75804d03803c',3,'车间跟进','handleLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:57:30','D','N'),('1cb0f6f4-b16a-11ec-829d-7085c2a9999e',2,'民主生活会','PartyLifeMeetingType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('1d0f1b94-f29e-4e22-b01c-4d8f667487ce',1,'未开考','TestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-15 00:00:00','A','N'),('1d25909f-4e47-4908-be86-539c8a4e6c4b',3,'正科','LeaderTeamPositionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('1f2a139ff6a64ae4bb600f62f69b00cc',5,'E刊展示','lmlxType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('206daa3f-b16a-11ec-829d-7085c2a9999e',3,'谈心谈话','PartyLifeMeetingType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('2084e69d-6bdb-4c3f-b979-2484de081118',1,'集中学习','zxzxxxxfaxxxs',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','jzxx','2019-09-12 14:56:39','M','N'),('20d7f0bf-71ed-4a7f-9671-d5ee65419279',20,'医学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('20e00609-79e2-4bb6-83af-3646405ef324',3,'大学','EducationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-02 16:27:10','M','N'),('20e74165-d2e9-4639-bdff-28c6c7cba465',2023,'2023','years',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2023','2022-10-13 16:27:02','A','N'),('2222ea89-1079-45a1-2345-d36b943c0a34',2,'中','QuestionDifficulty',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-08-24 00:00:00','M','N'),('228C359C99A746C0A80EAAABBEB44733',3,'日期(2000-01-01),('2294b3e733904b2582e6f65a3c2fef88',2,'传承红色基因，牢记党员使命。','ZzsrType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-06-24 14:48:33','M','N'),('231cf4f5-356d-44f2-b821-d037c1e3c450',5,'已完成决议','shykStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('233d623b-8135-2f49-995b-a29a6cb05911',1,'“七一”慰问','helpformType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-20 10:15:35','A','Y'),('233d626b-8135-2f49-995b-a29a6cb05912',2,'春节慰问','helpformType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-20 10:15:36','A','Y'),('233d626b-8135-2f49-995b-a29a6cb05913',3,'日常走访慰问','helpformType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-20 10:15:36','A','Y'),('233d626b-8135-2f49-995b-a29a6cb05914',4,'其他','helpformType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-20 12:36:57','M','N'),('23406f58-b6b1-4ad5-ace4-4e9953a6c133',6,'其它诉求','questionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-30 21:41:02','A','N'),('239f57b2-8409-431a-8b78-9baa04b44911',2,'请示','decisionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('23f5e615-b16a-11ec-0001-7085c2a00003',1,'重大事项决策','scydType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('23f5e615-b16a-11ec-0002-7085c2a00003',2,'重要干部任免','scydType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('23f5e615-b16a-11ec-0003-7085c2a00003',3,'重大项目投资决策','scydType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('23f5e615-b16a-11ec-0004-7085c2a00003',4,'大额资金使用','scydType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('23f5e615-b16a-11ec-829d-7085c2a00002',5,'民主集中制','PartyLifeMeetingType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('23f5e615-b16a-11ec-829d-7085c2a00003',6,'“三重一大”制度','PartyLifeMeetingType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('23f5e615-b16a-11ec-829d-7085c2a9999e',4,'党政联席会','PartyLifeMeetingType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('241b52ce-b0f2-40cf-8a07-9b64a7347e6f',3,'学习考勤','zxzxxfabz',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习方案步骤','2019-08-26 16:03:13','A','Y'),('24f4a713-9e1f-42b7-9a77-8f66a9732000',1,'报废','DisposalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-07-20 10:59:33','A','N'),('272a763a-9a94-4b57-87b9-3bd072aab9ea',2,'已处置','AssetState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-07-20 10:58:34','A','N'),('298243a4-5f4a-46af-9e22-39e500a1529b',3,'出党','djzt',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-21 20:28:22','A','N'),('2a28669b-6b30-41cd-b0eb-7d52d81cb82a',8,'馆员','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('2ab20485-faf5-4fd8-9f62-4f8181329987',5,'宣传工作','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-21 15:34:52','M','N'),('2bc6b0c4-2fb2-4cf5-8aa5-aa68fd66b602',20,'综合考评奖励','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-23 14:08:06','A','N'),('2bed9124-584c-4bbe-add6-b3115b58b982',2,'省级','positionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:58:32','M','N'),('2c10181f-797c-473e-ac3e-a8ac9ab65724',2,'测试2','test',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('2c6305ff-cf58-4685-a42d-91e80a128f45',5,'高级经济师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('2cb9c1b7-81bb-421c-9b77-0d4c179b52cb',5,'已公布成绩','TestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-18 00:00:00','A','N'),('2e4ec2f5-ce8b-4377-afe0-0f7c51e65b30',2,'省级','djBrand_creatType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:55:42','M','N'),('2ee79c72fa894630a6584f9dcb987aff',3,'测试5','test',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-29 16:57:43','A','Y'),('2f1935cd-5ed4-4edf-9427-781188ed74b2',3,'工作业绩','cgjqProjectNameOfPost',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('300cadb7-167f-4e22-8768-c7a58a8ec4c1',5,'死亡','djzt',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-21 20:28:41','A','N'),('307c4c59-fe74-4f09-9049-c132b6b280ee',2021,'2021','years',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-19 16:23:10','A','N'),('30ee4937-8e2f-4c0d-a4d3-83a0efd8fa98',7,'其他','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-21 15:34:59','M','N'),('31e77065-3946-412b-87ee-e22c03cc22f7',4,'党支部（总支）副书记','dwgzzType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('32c0d4f4-03d1-4e44-89b4-7714f1c15f53',4,'高级会计师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('3333c1b7-81bb-421c-3456-0d4c179b52cb',3,'易','QuestionDifficulty',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-08-24 00:00:00','A','N'),('3394b3e733904b2582e6f65a3c2fef88',3,'立足岗位奉献，展现党员担当。','ZzsrType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-06-24 14:48:45','M','N'),('358e07c8-9d9e-465f-9cd2-690b2a81f6f3',14,'理学博士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('36f48ca5-2a9a-4ed9-b0d6-60b8591897bc',2,'展板','positionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 16:12:30','M','N'),('37b5069c-6464-11ec-a22d-7085c2a9999e',1,'1','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:50:13','A',''),('3842052f-fc05-4876-a165-96998a5b9c2b',2,'技术业务','cgjqProjectNameOfArea',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('38a7c4ea-9998-4716-b2bd-a52f082845d9',2,'月度学习计划','zxzxxjhlx',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-12 14:53:13','M','N'),('3A51285A5839495693F2D96F8CC62D00',2,'数字(00.00),('3aae7bab63d045b6997c02b55d6f8e74',3,'宣传片','lmlxType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-03-04 11:10:04','M','N'),('3ab607d7-15fa-4f21-96ed-30e01c3b5b11',2,'二期','zgygNumber',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-10 09:19:43','A','N'),('3ac62b5c-d682-40c3-8258-89c8d16f60e5',3,'工程硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('3b7dc4a9-74e9-4b21-af23-900a8c13cb8a',2,'每月','panelCycle',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-19 11:06:54','M','N'),('3c08edd3-38ed-406d-b031-1049e028669e',2,'待回复','jsdwStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-29 16:58:07','M','N'),('3d3a882b-b40f-4525-bf62-0d01bb128964',2,'女','dic_sex',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-21 15:14:40','A','N'),('3E6CB95613C4492C94E50EF181175C1C',1,'文本','TaskColumnType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-07-26 11:42:24','A','Y'),('3e8addee-6b94-4c46-94d8-48a138164863',3,'基本合格','scoreLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-02 14:17:11','A','N'),('3edb0788-1f2b-482b-8bd3-920186357e9c',0,'未签到','checkinStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('3f80ff8c-4587-42a8-8e55-a5ebfeea544d',1,'团队协作','cgjqProjectNameOfArea',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('401ce989-37f1-41bb-acce-d92b6ec4e366',1,'工作','djWxGroup_msgType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 15:59:00','M','N'),('40e25477-6384-4531-8a0e-6ffbb845a7c5',1,'年度计划','ZgtgType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','年度计划','2019-09-26 17:34:39','M','N'),('425f45d5-7964-4973-9151-91aed0f01431',19,'学士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('43e8c561-1cf2-464f-9b03-17eae13abb29',2,'集团公司级','positionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:58:26','D','N'),('4450aa63d981471094da945ff370aebd',1,'http://localhost:8075','fineReport',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-02 11:21:08','A','Y'),('457f4a02-db23-4fe6-b0cf-d3b5a963f906',4,'队伍稳定','cgjqProjectNameOfArea',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('4648bdff-8385-4c02-9686-573a0d7a6a1f',1,'学习资料','LearningMaterialType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-13 09:14:58','A','N'),('46633c07-05ef-4684-9853-1b4faf9a2496',0,'不同意','approveStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('4683fe11-626a-48ed-1543-4f1301726df5',4,'差','ReviewLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('4683fe11-626a-48ed-9b43-4f1301726df5',4,'运营合资公司及办事处','zzfb',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-30 10:26:59','A','N'),('469cb8e2-02c6-40b5-a546-71c093b6641f',1,'外出就医','zxzxxxxfaqxyy',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习方案，缺席原因','2019-08-26 14:41:24','A','Y'),('46a62103-5602-4144-9a24-b0c9d9585ba8',3,'赠送','DisposalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-07-20 10:59:52','A','N'),('47a600df-1db6-4b97-8d2d-62f56368284c',3,'基本合格','DemocracyReviewResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 16:19:58','A','N'),('48900261-58b6-4f83-b433-7afc2a499a5f',5,'其他学习计划','临时学习计划',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','其他学习计划','2019-09-12 14:54:55','A','N'),('48a54c91-399e-4c9d-b568-fa5f6b2e43cd',11,'实验师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('499efb4b-afd3-4a9a-810f-37f0e54b6d1a',2002,'2002','years',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:29:51','A','N'),('49d8493a-d48e-498c-bd99-b9593a4bc561',4,'停止党籍','djzt',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-21 20:28:33','A','N'),('4a26c0dd-d28d-4bd0-b839-1bdc75f6f86b',0,'不同意','meetingApproveStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('4df01f8b-c653-4bdd-b3eb-c1181bf0f51f',2,'满意','shykEvaluateResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-18 16:47:19','A','N'),('4e209510-823f-4eab-bd11-fac633e28459',1,'本科','EducationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('4ed34c54-0e40-11ed-bb8e-7085c2a9999e',1,'待支付','wxPayState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-07-28 14:00:00','M','N'),('4f2bfe4e-ea0f-4b82-9ddd-ab215c20a13a',6,'未定义','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('4f4684ca-bdde-4602-8f28-38e028516bba',1,'非常满意','shykEvaluateResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-18 16:47:08','A','N'),('4fe13c0b-9be7-43e3-b666-1a057bfad061',1,'党员推荐','recommendtype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-01-09 16:54:36','A','N'),('500bd47d-a7b2-4e79-803e-17e7a0d0d8a8',6,'工学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('508d6d86-0eed-4c51-bf67-9f4c2ff31c51',0,'报备中','shykStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('50d909f3-a30b-4fe6-92c2-2aaea9d92220',1,'一级党委','PartyCommitteeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','党委级别','2021-04-23 09:58:33','A','N'),('51908510-2bda-4c86-9cb3-a275a91f489e',2,'每季度一次','SHYK_PartyPlan',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-01-02 09:51:17','A','N'),('5399602b-b542-46c9-95b3-8b9d2a122a71',1,'已处理','handleType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:07:43','A','N'),('53cbef3c-0e40-11ed-bb8e-7085c2a9999e',2,'支付成功','wxPayState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-07-28 14:00:00','M','N'),('53ed199a-f2fa-4df0-b3c9-ffa90adccfc0',2,'未上报','handleState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:08:56','A','N'),('53f63b29-b49c-4ffe-aadc-16fbed3fd1f1',4,'省（区、市）委党校研究生','EducationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('54ae5bc691834d1b8d79adada77b1535',3,'类型3','FileMgrType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('55171625-59f6-4fd4-b6ab-07faa71823e3',1,'每月一次','SHYK_PartyPlan',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-01-02 09:51:17','A','N'),('56145bf4-e7a1-4aae-96a3-ce70ac06645a',3,'每半年一次','SHYK_PartyPlan',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-01-02 09:51:18','A','N'),('56b2f9a7-4838-448e-a2ea-e90528b9f1ec',2,'授课内容如何','shykEvaluateType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-18 16:44:55','A','N'),('576b26e6353d41468d42d8f1fca9747b',3,'测试3','test',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-29 16:41:54','A','Y'),('57948098-0e40-11ed-bb8e-7085c2a9999e',3,'支付失败','wxPayState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-07-28 14:00:00','M','N'),('57df5a22-cc4b-43a4-b402-2c31377e82e7',4,'福利待遇','questionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-30 21:40:09','A','N'),('5812b0ba-08c0-46c8-904f-f7e0be99f450',12,'助理工程师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('5994b3e733904b2582e6f65a3c2fef88',1,'显示','ztType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('59fe6bc4-51ea-4931-91f8-39d03fb02cfd',12,'教育学学士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('5a3ac6dce92c4fb888130fba3488d826',1,'邀请中','shyk_tempUserEnable',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-25 17:40:00','A','N'),('5acbe5cc-f0a7-4edf-81f3-94c25080f869',4,'会议活动','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:06:15','A','N'),('5acffc69-abf0-4068-8a24-500a92deadcd',2,'公事外出','zxzxxxxfaqxyy',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习方案，缺席原因','2019-08-26 14:41:56','A','Y'),('5b0e1af0-d3b2-4f35-bb8b-4540651d7019',3,'未知','dic_sex',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-21 15:14:52','A','N'),('5b4cf7d0-a1ed-40b4-9397-49ed71b283de',2,'车间级','psiLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-09 19:35:29','M','N'),('5b91bc45-8db6-4437-b9e7-f7e368c77742',8,'二级总支','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-25 16:58:01','D','N'),('5c18ed5d-fbd9-421e-a64c-727cab582fc3',2,'待处理','handleType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:08:00','A','N'),('5cb79fde8e834e3f9a54237ec0f3ee64',3,'测试4','test',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-29 16:44:24','A','Y'),('5d82404a-7452-4fd6-b3ff-d198cddd4f2e',9,'讲师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('5ddca380-71b2-483c-1468-97eff9a7ddcd',3,'一般','ReviewLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('5ddca380-71b2-483c-a268-97eff9a7ddcd',3,'一级非运输企业党委','zzfb',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-30 10:26:59','A','N'),('5f514ba5-8981-4979-9681-d52b8ca59a51',3,'广西','nativeplaceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:04:47','D','N'),('5f5c7ab4-b580-4af1-91da-05e5bb91f467',2,'退回','fqtgStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-08 16:20:15','A','N'),('606af71a-1f3a-49f8-a542-1e84bd6bc183',5,'研究生','EducationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('611bd112-802c-42fd-9a37-03ad5aef16ed',6,'积分清零','cgjqProjectNameOfPost',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('621f7156-3b95-4295-89fc-e79e327d4861',4,'每半年','panelCycle',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-19 11:07:08','M','N'),('627DF6C0D5634617845214C926CE81C8',3,'新任组织助理员','PaperBasetype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-01-06 00:00:00','A','Y'),('6347a096-63a4-449c-8f2c-c5361ebbb4c3',3,'尊章守纪','cgjqProjectNameOfArea',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('63810906-fe69-4fe4-ad8b-1b121a9d2013',3,'国家级','djBrand_creatType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:55:50','M','N'),('63d3c618-841f-49e4-996c-a5e63df09f69',2,'党员管理','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-21 15:33:13','A','N'),('63fe0800659f4d389579e32ed27e641d',1,'缺考','JoinTestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-06-28 00:00:00','A','Y'),('6503c41f-8f18-45e0-b320-c0bb4d79bb9a',1,'组织助理员','zlyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-02 10:02:39','A','N'),('6584970ac17a4e899da6976ff255341e',2,'不同意','shyk_tempUserEnable',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-25 17:40:00','A','N'),('666a8cd3-38e5-11ef-8ed2-7085c2a9999e',1,'党员大会','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('666c16be-38e5-11ef-8ed2-7085c2a9999e',2,'支部委员会','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('666e097d-38e5-11ef-8ed2-7085c2a9999e',3,'党小组会','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('6670c50a-38e5-11ef-8ed2-7085c2a9999e',4,'党课','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('66722c3c-38e5-11ef-8ed2-7085c2a9999e',5,'第一议题','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('6673c67e-38e5-11ef-8ed2-7085c2a9999e',6,'组织生活会','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('66755b5d-38e5-11ef-8ed2-7085c2a9999e',7,'民主评议党员','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('6677662c-38e5-11ef-8ed2-7085c2a9999e',8,'主题党日','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('6679ac3b-38e5-11ef-8ed2-7085c2a9999e',9,'其他会议','shykType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 10:38:58','A','Y'),('67d3313b-e8c9-4309-b75a-2eb29bce42dd',1,'刚入党','djzt',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','党籍状态','2020-03-21 20:28:03','A','N'),('67d345ff-3ffc-4cf9-abaa-00ad8bf2db10',3,'不满意','shykEvaluateResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-18 16:47:31','A','N'),('6971a62d-0f56-4c4d-8487-ec07adf874a3',3,'可用','fqtgStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-08 16:20:24','A','N'),('69b56acc-ee93-4985-9168-5e4a85f251ff',1,'政策制度','questionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-30 21:38:56','M','N'),('6b4c094179cf46b7b41f71adf448b42f',2,'lc_user,1','fineReport',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-02 11:21:08','A','Y'),('6c070e56-3598-48a7-9915-fb865d6df4b6',3,'电子屏','positionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 16:12:43','M','N'),('6c1d082b-bfae-432f-add3-c9d9c322af3c',1,'正常','positionState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-17 14:49:35','A','N'),('6c8c70df-4005-4759-b48c-27a2e43ad224',1,'学习教育活动','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:05:32','A','N'),('6cae589b-fb44-4aac-a804-30eb4ea4d3d3',1,'联合使用','djPartyActivityRoom_useRange',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-19 14:16:56','M','N'),('6d198bdc-f2d6-4af4-8dea-ea7ca17ffbc6',4,'不合格','DemocracyReviewResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 16:20:05','A','N'),('6d39abf3-ae6f-4beb-b8df-0486569db3a2',3,'调研成果','LearningMaterialType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-13 09:15:19','A','N'),('6d55f859-c072-419b-9d2c-d2bd2f487361',4,'党内活动','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-21 15:33:41','A','N'),('71160C88F95F472E816568CDCD538A6A',5,'时间(2000-11-12 13:41),('7116dbf1-c6a3-4a53-a4d7-7a16693a779e',3,'三期','zgygNumber',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-10 09:19:55','A','N'),('71b10e83-0e7c-4cd1-b6e1-7e3c43111841',3,'专题学习计划','zxzxxjhlx',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-12 14:54:18','A','N'),('722e9356-2fe8-470c-ae9c-31207c31f81e',1,'学院级','djBrand_creatType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:55:34','M','N'),('72d3bb17-90b7-447b-9586-1a01ba8de64a',1,'长期','panelCycle',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-19 11:06:46','M','N'),('73204adc-e9d9-40ef-b210-6eec1b424b53',22,'主题竞赛活动奖励','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-23 14:13:54','A','N'),('73ad65f3-b95c-4cc9-9dc9-667683d19f34',1,'全集团','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('73cc2bb6-00f0-4570-9b16-771b99972390',4,'已回复','jsdwStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-29 16:58:18','M','N'),('745ef2e5-cc4f-4368-b388-410fb2a10c18',2,'博士','educationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:02:59','D','N'),('746533f8-9a63-4f42-9bf5-ae9ef85134e4',4,'宣传栏','positionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 16:13:09','A','N'),('76993d12-8256-4451-8497-691bc8055a4b',7,'指导联系点党支部组织生活会','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:04:21','A','N'),('77f2d1b5-4b4b-475d-b9f2-5f2661e378ac',1,'学院跟进','handleLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:56:59','M','N'),('782c47a5-7054-4554-b59c-b50388d85f47',2,'本党委','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('7a038aaf-1b8a-465a-a8b6-8171a7d89716',2,'职工收入','questionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-30 21:39:09','M','N'),('7a44c4ef-5920-42d3-bbc0-5bbdcf3c5d84',4,'工程硕士专业','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('7a737175-774f-4c6f-b2dd-77d1e5337da2',10,'教授','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('7b135dc4-5b85-4c77-9384-b6c030272d8a',2,'已审核','decisionstatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('7c1b5875-53ac-45bc-b081-7e75092cb97c',23,'党建工作成果奖励','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-23 14:14:21','A','N'),('7d3080f8-8122-4da5-b5bd-a17ab4e391b5',4,'授课方式是否有助于我对党课内容的理解','shykEvaluateType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-18 16:46:00','A','N'),('7da4c6d6-d195-47f4-959d-1e54a005ed46',1,'未提交','democracyReviewPlanStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-06 16:23:11','A','N'),('7db521a6-1ec7-4623-92b4-81d94fd3f350',2,'QQ','djWxGroup_implatform',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-19 14:34:55','M','N'),('7dca66af-f955-4f49-ae1e-46d1819d3dad',2,'副研究馆员','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('7e2457f8-ca19-421e-8c99-92ddd6c42612',2,'合格','DemocracyReviewResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 16:19:50','A','N'),('7e90219d-0dbf-4d0d-98d3-7768d8856f66',8,'其他','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:07:16','A','N'),('7f6fb90c-86d7-4e9d-8791-168a30a7c89a',24,'创岗建区表彰奖励','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-23 14:14:44','A','N'),('7f8524a3-a998-45b4-b2ed-6474f5b97705',2,'调查研究','topic',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-30 14:08:41','A','N'),('807b2d07-7496-4a71-9bc0-56d96a86c289',1,'横幅','positionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 16:12:13','M','N'),('8081cc5b-c29b-4ae0-bce7-88c9df146b79',3,'全国级','positionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-26 08:58:36','M','N'),('821bd444-cf0f-41d8-a43d-b61c52d6c337',9,'已取消','TestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-18 00:00:00','A','N'),('8390ef6d-8805-43ac-9308-4a507919aee0',18,'文学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('83bd850e-749b-4a54-9e73-bb9909319fbd',2,'已审核','decisionStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('843bfd90-519c-4d11-b40d-b9fde1a594eb',1,'中层干部信息','LeaderteamType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('85180073-a717-412c-a419-57774f9c369b',4,'副科','LeaderTeamPositionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('855867d0-93ba-4710-90fd-976e6bb77993',4,'不合格','scoreLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-02 14:17:20','A','N'),('85b90e3b-89dd-4b64-962d-9eddddbe5e40',2,'宣传助理员','zlyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-02 10:02:49','A','N'),('85bffce3-f6d8-46b8-80f4-6a3452c5b432',8,'管理学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('85c0f395-a832-4d96-92b2-a8fcb73a5e6d',3,'栏目3','ZgtgType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','栏目3','2019-09-26 17:33:58','D','N'),('85f2aa2daf5e42ab85214a6e55a66a27',5,'会议临时加入通知','messageType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-25 17:40:00','A','N'),('87887e0d-1ae3-4e82-b9aa-34b7d06802dc',5,'党建日常工作','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:06:34','A','N'),('884ccf96-3c18-40ec-893d-777bdfc90fb9',2,'会议-手抄照片','fileType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('88f24cc8-daaa-4aba-8042-d97377409774',21,'艺术学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('88f3b9ac-58bb-45c0-a193-669ed05aabc3',1,'站段级','psiLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-09 19:35:20','M','N'),('899283c7-833d-4bbe-85fc-e1fe0128072e',2,'二级党委','PartyCommitteeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-23 09:58:41','A','N'),('899ced7a-4f95-43c5-b999-e9183a8c398c',12,'1112','111',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1112','2025-06-05 17:31:12','D','N'),('8a40b880dc2f42c79198dda3428688ec',2,'二级菜单','mhflJbType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('8a454f09555f4a7ea13f2868664cc722',4,'支部风采','lmlxType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-03-04 11:11:09','M','N'),('8b922d05-efc3-4e62-90ff-c6f72b545bb2',3,'钉钉','djWxGroup_implatform',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-26 12:16:30','A','N'),('8c407aa2-6464-11ec-a22d-7085c2a9999e',2,'2','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c40e064-2f68-4432-af28-c767f632358a',2,'客观题','ObjectiveType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-13 00:00:00','A','N'),('8c41bbb9-6464-11ec-a22d-7085c2a9999e',3,'3','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c435050-6464-11ec-a22d-7085c2a9999e',4,'4','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c44c00a-6464-11ec-a22d-7085c2a9999e',5,'5','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c459248-6464-11ec-a22d-7085c2a9999e',6,'6','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c4659d6-6464-11ec-a22d-7085c2a9999e',7,'7','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c472362-6464-11ec-a22d-7085c2a9999e',8,'8','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c47e426-6464-11ec-a22d-7085c2a9999e',9,'9','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c489a8f-6464-11ec-a22d-7085c2a9999e',10,'10','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c496f88-6464-11ec-a22d-7085c2a9999e',11,'11','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c4a2228-6464-11ec-a22d-7085c2a9999e',12,'12','monthType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2021-12-24 10:52:35','A',''),('8c581c2b-4793-47f0-8e23-abb7e3d6c615',5,'工学博士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('8da905be5ab44dc1bc2da7061b523b03',2,'图片滚动','lmlxType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('8e03f48cd93448b09c9581d3cfb31231',1,'幻灯片滚动','lmlxType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('8e81c887-63ad-4553-9495-e8fe1d7d37d6',1,'优秀','scoreLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-25 11:39:32','A','N'),('8eba601e-6f8d-4ee0-b3e2-59544457f1c5',3,'待批阅','TestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-18 00:00:00','M','N'),('8f7e907e-4fc2-4544-a0eb-ac44d6aeaf76',3,'C','psiLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-09 19:36:06','D','N'),('90241402-af3e-4fb4-84b9-1cb1452a1941',5,'本党小组','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('90dd899b-091f-4e49-bf1d-186e3f9a438c',2,'研讨发言','LearningMaterialType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-10-13 09:15:10','A','N'),('90f8ad90-055f-4c40-af76-61abdb171545',1,'优秀','DemocracyReviewResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 16:19:43','A','N'),('916acbe5-5701-45d0-aada-7d3ebc70eea2',3,'宣传活动','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:06:03','A','N'),('9171448d-5056-41ed-a162-19062566b171',1,'毕业','trainingResult',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:03:33','A','N'),('93638c99-dc62-4a5e-b1c7-493edb326ca2',4,'栏目4','ZgtgType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','栏目4','2019-09-26 17:34:00','D','N'),('95161e65-0d1f-449d-a66f-8ba96e0641f8',4,'不可用','fqtgStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-08 16:20:32','A','N'),('96468a1de9da410195cb26384420427b',2,'隐藏','ztType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('967259b8-2db2-4f3a-bf08-e1dbc33903b8',2,'考试中','TestStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-15 00:00:00','A','N'),('9689ad52-0b7c-43f7-b8ff-221ed268f0c0',16,'农学博士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('97768f35-5c6e-4752-8b71-7063f602fda5',5,'完成','zxzxxfabz',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习方案步骤','2019-08-26 16:04:13','A','Y'),('978c1f4c-1f57-404e-9e9e-ed1cac5ca0c4',1,'未签收','signinStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('98264266-cf8b-4ff5-b2c9-1cb8e81d2fde',2019,'2019','years',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2019-09-19 16:22:53','A','N'),('9a669253-2fa1-4b68-a583-7ac3b04dd9b4',4,'每年一次','SHYK_PartyPlan',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-01-02 09:51:18','A','N'),('9ab18f03-a349-4137-be6a-351b085eca95',1,'党委正职','dwgzzType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('9c0114a9-cbd3-45df-b129-77cad1c33774',1,'年度学习计划','zxzxxjhlx',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','年度学习计划','2019-09-12 14:53:01','M','N'),('9c87c5ac-7640-4bd1-965c-ec47eeb29033',1,'待审核','partyHelpStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-20 13:51:41','A','N'),('9c9dc67e-fe34-4acb-8b96-53b08a04cf8f',2024,'2024','years',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2024','2024-03-28 10:02:02','A','N'),('9ed2fde4-8c6b-4997-a4ba-a6492b6f7429',2,'具体约稿','ZgtgType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','具体约稿','2019-09-26 17:34:51','M','N'),('A20C95A703B846E5B23563BDA9651229',4,'新任宣传助理员','PaperBasetype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-01-06 00:00:00','A','Y'),('a37f167c-e01d-48e6-ab47-6a85bac7c240',5,'工作相关','questionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-30 21:40:23','A','N'),('a5de62be-6cbc-4a5d-8c1d-c39fca3360d3',1,'待接收','jsdwStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-29 16:58:03','M','N'),('aad538b0-89e8-486c-a9e5-d5a96119ff47',11,'教育学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('aaddc4e9b080461ebd6f3a15cd38518f',3,'已加入','shyk_tempUserEnable',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-25 17:40:00','A','N'),('ab22c8c1-48ff-4dee-9ac1-8be7c12fed94',8,'指导所属单位党代会或党支部换届','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:04:30','A','N'),('aba6b99e-7ffc-4daf-b6cf-3548128b06fb',1,'方案制定','zxzxxfabz',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习方案步骤','2019-08-26 16:02:02','M','Y'),('ABCD29BF593A4CA79CA1DDD6463E948B',4,'月份(2000-11),('abec9b1d5c524b44977452d72fdfa721',1,'领导工作制度','FileMgrType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-29 16:28:30','M','Y'),('ad225412-d527-4f88-aa5c-fab860bfa0df',2,'民主生活会','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:03:33','A','N'),('ad4c637c-f6f9-4970-8186-58bd08943b25',21,'“七一”表彰奖励','综合考评奖励',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-23 14:09:28','D','N'),('ad8aabdc-f3ca-4b8d-8106-6b31964b26c0',1,'确认无误','cgjqScoreCheckType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-24 11:23:15','A','N'),('add80008-2c1a-4569-b0e6-51ffbbc607b4',2,'转正','djzt',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-21 20:28:13','A','N'),('b1be4ee6-14d4-456e-9bfb-485a715e6b2e',5,'积分奖励','cgjqProjectNameOfArea',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('b1f43adf-7d74-40d6-9f82-7766e548b575',1,'会议签收通知','messageType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('b2dd29dd-1546-490c-93ef-1ee3334c9211',5,'督学交流','zxzxxxxfaxxxs',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习学习形式字典','2019-09-26 15:13:17','M','N'),('b2dd29dd-1546-490c-93ef-1ee3334c92cf',4,'参观学习','zxzxxxxfaxxxs',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习学习形式字典','2019-09-26 15:13:17','M','N'),('b2f8e1a3-84f1-437a-aaea-3650b0b0f521',1,'组织管理','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','APP菜单分组','2021-04-21 15:33:01','A','N'),('b335879f-89c5-4a74-89ea-61db8378c2ed',2,'确认参加','signinStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('b50576eb-3506-4f4f-a506-ebff1fee4d65',1,'法学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('b6419e07-2d81-4b9c-ba78-21c51c7614bf',1,'http://localhost:8075','FineReport',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','地址','2020-04-01 15:20:21','A','N'),('b717833f-34ce-4bb0-a594-65bacce46cb0',2,'已取消','shykStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('b747497a-4b0f-40c1-911a-435cc78d5430',2,'补学补课通知','messageType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('b81f193c-46d6-4d02-ae1b-e11fca3b4169',1,'通过','panelState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 17:16:22','A','N'),('b8f8badb-9b9f-426c-b705-72b628cecc88',3,'不通过','partyHelpStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-20 13:51:59','A','N'),('b9ea813d-a5d3-459c-955b-09d5a98007f6',15,'理学硕士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('ba53f868-e618-4ba9-aa7b-ecf5b2891b9d',2,'特定专用','djPartyActivityRoom_useRange',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-19 14:17:11','M','N'),('ba641716-6a0c-4bbb-b4df-a3f6a51ce399',2,'通过','partyHelpStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-04-20 13:51:48','A','N'),('bb825eb8-00b8-4b45-b3f1-58d59ae36367',2,'报损','DisposalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-07-20 10:59:43','A','N'),('bbd25116-cf55-4648-892a-2f33ad9cda3f',1,'同意','approveStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('bcc71d26-f43d-47ef-886c-a27d1797706a',2020,'2020','years',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-19 16:23:01','A','N'),('bd16a500-7c2b-4a8f-89a9-316d62778850',3,'日常谈心谈话','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:03:41','A','N'),('be069c9d-a143-4614-8886-70ae00220d77',2,'合格','scoreLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-25 11:39:32','A','N'),('be6f5e9b-0948-47f4-89a3-a1a0d79bd77b',1,'探索与思考','topic',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-30 14:08:27','A','N'),('bf507949-e28a-4724-a561-ceb5db9ce7b5',1,'测试','test',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('c0558a79-ab74-4004-a2b9-523b07ca729b',5,'建设项目管理机构','zzfb',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-30 10:26:59','A','N'),('c0a883a7-e392-40da-ba9b-031f1391c4f4',4,'留党察看','punishType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-11 10:25:21','A','N'),('c0ff1f97e10846c281e3a704bfdb81e2',2,'宣传工作制度','FileMgrType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 16:11:49','M','N'),('c27ba3bb-b6e3-49f9-bb1a-f8cfe1b6c378',1,'副教授','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('c313f73e-1c97-4dc7-9e2f-20e52557682d',5,'开除党籍','punishType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-11 10:25:50','A','N'),('c47b4454-1cd6-44f3-9c78-6d0e5a443053',4,'下基层讲党课','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:03:51','A','N'),('c4c175bf-b889-4777-8d04-145cb0dbc2c7',6,'其他单位党组织','zzfb',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-30 10:26:59','A','N'),('c6320b46b0b24c5a91c46b6240e2fd28',3,'中心组学习文件','fileType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-22 11:58:36','A','Y'),('c63ef17c-dea7-4197-bf36-ba71a9780a9b',3,'纪检监察员','zlyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-02 10:02:58','A','N'),('cb10a3b3-7ba6-4097-af7b-05f4c8872144',3,'每季度','panelCycle',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:34:18','A','N'),('cdc1e067-9454-4ec9-b184-7ff100ad0386',1,'正处','LeaderTeamPositionLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('ceb0f4e8-6034-49b8-82fe-ed9bbe68b4c8',4,'引领带动','cgjqProjectNameOfPost',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('cfa26c86-7386-4fbc-9d3f-649881d3f850',2,'专题研讨','zxzxxxxfaxxxs',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习学习形式字典','2019-09-12 14:57:05','M','N'),('d01b822d-98bd-45a6-a42d-73ce0fe32a59',2,'职工诉求','thoughtType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:06:20','A','N'),('d0675d5e-5909-41df-bf21-71e7ebe46fb1',7,'工程师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('d07b8f73-4236-4c02-a2b3-274608fa768b',1,'待审核','decisionstatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('d13dd6e6-0e75-4747-b60f-ebfa0c42a714',1,'已销号','destroyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:08:27','A','N'),('d150fa1f-d011-4b5a-90f3-ca9de74d38d6',5,'综合部（党群工作部）部长','zlyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-02 10:03:17','A','N'),('d236d1c4-c1ea-43f3-8230-a78e3f3853b5',4,'已完成会议记录','shykStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('d379568f-5920-4789-964f-a88b5c7538b1',3,'生产生活','questionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-30 21:39:40','M','N'),('d40b548e-2092-4066-841f-5db0ea121dbf',1,'北京','nativeplaceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:04:43','D','N'),('d5b87e0b-e5a2-4c4e-a4a7-009f0e3f7952',1,'已发送','ZgygStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','已发送','2019-09-27 11:34:47','M','N'),('d5c5ae1d-6ce7-4a20-96b4-6ad4ea94f3ca',2,'秘书审定','zxzxxfabz',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习方案制定步骤','2019-08-26 16:02:42','A','Y'),('d6df1b01-2865-4a88-b03b-8680265c5b3c',5,'已用','fqtgStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-08 16:20:51','A','N'),('d992ba5a-ecc7-4cca-a81d-5fc266d2f47e',3,'党支部（总支）书记','dwgzzType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('d9a59246-201c-4407-8de9-1e6f39d12a43',1,'电脑端','loginType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','登陆类型','2021-07-05 14:55:40','A','N'),('d9ae564a-0782-4a9b-b744-11900cc2c035',2,'党内主题活动','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:05:51','A','N'),('da2e3478-7eca-4071-8b76-17785edd993f',5,'不定格次','DemocracyReviewResultType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2024-07-03 16:20:14','A','N'),('da359cd2-a83b-4d5d-ad61-4559f6c18f34',6,'高级政工师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('da4035b7-8eba-4667-a944-9e8edf38de06',3,'高级工程师','ProfessionalType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('db2c0cf5-4c6b-4806-823e-251064c2fc0f',1,'一期','zgygNumber',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-10 09:19:36','A','N'),('db5a4c48-ae90-4ea0-a9d3-78c2ce297cd5',2022,'2022','years',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2022','2022-03-15 12:24:00','A','N'),('db706813-afcb-11ec-829d-7085c2a9999e',1,'待审核','userPartyChangeStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:40:00','A','N'),('db70681e-afcb-11ec-829d-7085c2a9999e',2,'通过','userPartyChangeStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:40:00','A','N'),('db706822-afcb-11ec-829d-7085c2a9999e',3,'不通过','userPartyChangeStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:40:00','A','N'),('db8d2e21-7b7f-4cd6-ac49-33e0efc11a75',6,'走访慰问活动','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:06:54','A','N'),('dbc4354c052043468c71a9d5b418f4e7',4,'类型4','FileMgrType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('dd3d2e1f-4650-4e62-a864-46a880d7832c',2,'停用','positionState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-17 14:49:49','A','N'),('dd865046-8c11-499e-135d-98dec4afe3b6',2,'较好','ReviewLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('dd865046-8c11-499e-ab5d-98dec4afe3b6',2,'运输辅助单位','zzfb',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-30 10:26:59','A','N'),('dd865046-8c11-669e-135d-98dec4afe3b6',4,'已考评','ArrangeRecordStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('dd865046-8c11-999e-135d-98dec4afe3b6',2,'未开始','ArrangeRecordStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-14 00:00:00','A','N'),('ddd49b9f-b863-494a-99f8-da599635fdce',4,'留党察看','撤销党内职务',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-11 10:24:35','D','N'),('df353b12-e033-4cc4-9149-c61b3a5142f8',2,'待考评','democracyReviewPlanStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-06 16:23:20','A','N'),('e0c2749d-6dd7-11ec-bbc0-7085c2a9999e',1,'季度第一月','monthQuarterType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2022-01-05 11:30:49','A','N'),('e0c38e2d-6dd7-11ec-bbc0-7085c2a9999e',2,'季度第二月','monthQuarterType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2022-01-05 11:30:49','A','N'),('e0c63aae-6dd7-11ec-bbc0-7085c2a9999e',3,'季度第三月','monthQuarterType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2022-01-05 11:30:49','A','N'),('e0d3d907-9eb4-47db-b40d-6dbfad72d85c',5,'每年','panelCycle',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-19 11:07:13','M','N'),('e20f56ac-ccd4-4a7e-aef6-f61b07879f43',7,'设备设施','expendType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-23 14:07:09','A','N'),('e22d62ab-8735-4f49-995b-a29a6cb059e1',2,'不通过','panelState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 17:16:29','A','N'),('e22d62ab-8735-4f49-995b-a29a6cb059e2',1,'特困','povertyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-19 15:37:10','A','Y'),('e22d62ab-8735-4f49-995b-a29a6cb059e3',2,'困难','povertyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-19 15:38:03','A','Y'),('e22d62ab-8735-4f49-995b-a29a6cb059e4',3,'一般','povertyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-19 15:38:03','A','Y'),('e23d62ab-1735-4f41-195b-a29a6cb059e2',1,'培训党员','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-05-19 10:57:39','A','Y'),('e23d62ab-1735-4f49-995b-a29a6cb059e2',1,'先进党组织','honourType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-08 08:34:19','A','Y'),('e23d62ab-8735-4f49-995b-a29a6cb059e2',1,'集中学习','subjectType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 17:01:31','A','Y'),('e24d62ab-1735-4f42-295b-a29a6cb059e3',2,'召开党内会议','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-05-19 10:57:39','A','Y'),('e24d62ab-1735-4f46-695b-a29a6cb059e3',6,'补助生活困难党员','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-05-19 10:57:39','A','Y'),('e24d62ab-1735-4f49-995b-a29a6cb059e3',2,'其他','honourType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-08 08:34:19','A','Y'),('e24d62ab-8735-4f49-995b-a29a6cb059e3',2,'听党课','subjectType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 17:01:31','A','Y'),('e25d62ab-1735-4f43-395b-a29a6cb059e4',3,'开展党内活动','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-19 10:57:39','A','Y'),('e25d62ab-1735-4f47-795b-a29a6cb059e4',7,'补助遭受严重自然灾害的党员和修缮因灾受损的基层党员教育设施支出','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-19 10:57:39','A','Y'),('e25d62ab-1735-4f49-995b-a29a6cb059e4',3,'优秀共产党员','honourType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-08 08:34:19','A','Y'),('e25d62ab-8735-4f49-995b-a29a6cb059e4',3,'交纳党费','subjectType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 17:01:32','A','Y'),('e26d62ab-1735-4f44-495b-a29a6cb059e2',4,'党员教育阵地建设','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-19 10:57:39','A','Y'),('e26d62ab-1735-4f48-895b-a29a6cb059e2',8,'党员日常教育、管理费用','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-19 10:57:39','A','Y'),('e26d62ab-1735-4f49-995b-a29a6cb059e2',4,'优秀党务工作者','honourType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-08 08:34:19','A','Y'),('e26d62ab-8735-4f49-995b-a29a6cb059e2',4,'民主议事','subjectType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 17:01:32','A','Y'),('e27d62ab-1735-4f45-595b-a29a6cb059e3',5,'表彰先进','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-19 10:57:39','A','Y'),('e27d62ab-1735-4f49-095b-a29a6cb059e3',9,'财务管理费用','partyoutlayPaytype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-19 10:57:39','A','Y'),('e27d62ab-1735-4f49-995b-a29a6cb059e3',5,'其他','honourType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-08 08:34:19','A','Y'),('e27d62ab-8735-4f49-995b-a29a6cb059e3',5,'志愿服务','subjectType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 17:01:32','A','Y'),('e28d62ab-8735-4f49-995b-a29a6cb059e4',6,'其他','subjectType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 17:01:33','A','Y'),('e2f78d21-e89e-4afe-a9e0-955b40610067',1,'同意','meetingApproveStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('e31d624b-8735-1f49-995b-a29a6cb05912',1,'优秀','judgeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-08 14:06:23','A','Y'),('e31d624b-8735-4f49-995b-a29a6cb059e2',1,'违反政治纪律','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:25','A','Y'),('e31d624b-8736-4f49-995b-a29a6cb059e2',5,'违反群众纪律','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:26','A','Y'),('e320d2ec-5988-40a2-9ba2-862d7a2c3059',4,'上传成果','zxzxxfabz',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','中心组学习方案步骤','2019-08-26 16:03:44','A','Y'),('e32d625b-8735-1f49-995b-a29a6cb05913',2,'良好','judgeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-04-08 14:06:23','A','Y'),('e32d625b-8735-4f49-995b-a29a6cb059e3',2,'违反组织纪律','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:25','A','Y'),('e32d625b-8737-4f49-995b-a29a6cb059e3',6,'违反工作纪律','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:26','A','Y'),('e33d623b-8735-1f49-995b-a29a6cb05914',3,'达标','judgeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-27 10:29:43','M','N'),('e33d623b-8735-2f49-995b-a29a6cb05911',5,'先进','judgeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-08 14:06:23','A','Y'),('e33d623b-8735-4f49-995b-a29a6cb059e4',3,'违反干部选拔任用规定','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:25','A','Y'),('e33d623b-8738-4f49-995b-a29a6cb059e4',7,'违反生活纪律','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:26','A','Y'),('e33d626b-8735-1f49-995b-a29a6cb05915',4,'不达标','judgeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','1','2020-05-27 10:29:50','M','N'),('e33d626b-8735-2f49-995b-a29a6cb05912',6,'一般','judgeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-08 14:06:23','A','Y'),('e33d626b-8735-2f49-995b-a29a6cb05913',7,'薄弱','judgeLevel',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','2','2020-04-08 14:06:23','A','Y'),('e33d626b-8735-4f49-995b-a29a6cb059e4',4,'违反廉洁纪律','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:26','A','Y'),('e33d626b-8739-4f49-995b-a29a6cb059e4',8,'涉法行为','offenceType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-12 09:53:27','A','Y'),('e34d62ab-8735-4f49-995b-a29a6cb059e2',1,'警告','punishType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-11 10:24:51','M','N'),('e35d62ab-8735-4f49-995b-a29a6cb059e3',2,'严重警告','punishType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-11 10:24:56','M','N'),('e35e3449614c4aaf9304bad1ef877934',3,'测试6','test',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','111','2019-08-30 09:41:25','A','Y'),('e36d62ab-8735-4f49-995b-a29a6cb059e4',3,'撤销党内职务','punishType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-11 10:25:00','M','N'),('e48e9a35-e8b1-411b-bb4e-7166a424306c',3,'组织生活','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-04-21 15:33:27','A','N'),('E4D3430753A44E9EABBCAA9C984B14C7',2,'新任专职党支部书记','PaperBasetype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-01-06 00:00:00','A','Y'),('e6ab391c-9a34-486f-b187-9a91aca73455',6,'APP身边榜样','lmlxType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','APP身边榜样','2021-05-24 16:47:53','A','N'),('e73e8941-e2f1-4171-b6fe-5e4fccc098d1',3,'其它','djPartyActivityRoom_useRange',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-19 14:16:41','A','N'),('e80c1d03-e171-4f68-9b83-7df17aa603e5',7,'二级党委','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','二级党委','2021-10-25 16:58:12','D','N'),('e83c7e1b-6281-446e-b01a-c97c13812345',3,'一级总支','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-29 10:32:45','M','N'),('e83c7e1b-6281-446e-b01a-c97c13836954',4,'本支部','roleConfig',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('e89df63e-74b9-43d6-8b77-da9223a55ac3',1,'已发送通知','shykStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('e8c8a92a-2930-4cb2-b19a-1a6cfd2c8fa9',1,'报告','decisionType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('ea6a3ef9-03e8-49cd-9ed1-75d5ff4bd26f',2,'奖励支出','expendScope',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-23 14:04:48','A','N'),('ea776d05-3b91-4e31-a834-6d06f49d7a7b',1,'中共党员','PoliticsStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('eb2d9896-2508-443a-8634-2b897acf06cc',4,'学习强国','djWxGroup_implatform',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 15:54:03','M','N'),('ecef4d8d-fc3f-4a01-a3ab-c5718e682888',3,'已接收','jsdwStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-29 16:58:14','M','N'),('edd093b2-4cc7-4a4e-bec3-aa21cb0f5efd',2,'核对修改','cgjqScoreCheckType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-24 11:23:15','A','N'),('eed98c23-3238-4bda-9d0a-46454442c751',1,'双重组织生活','leaderType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-03-23 11:03:08','A','N'),('F06815C2C3AA4CE684E75621EE27C6AE',1,'常规考试 ','PaperBasetype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2023-01-06 00:00:00','A','Y'),('f0bfd88c-a6f4-4289-8b30-5402dd6a4c7e',0,'暂存','ZgygStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','暂存','2019-09-27 11:34:54','M','N'),('f253afd3-1d75-4aeb-82b5-c734784b78d0',4,'党群办主任','zlyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-02 10:03:08','A','N'),('f371964b-dce3-4894-a403-9cd45c4c94e7',3,'是否学到新知识','shykEvaluateType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-05-18 16:45:14','A','N'),('f3ff37eb-8784-4e2f-af7f-92cb07626eb3',0,'待审核','panelState',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 17:16:16','A','N'),('f423063d-394f-4aca-af72-b9533cdf54ca',6,'积分清零','cgjqProjectNameOfArea',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-09-23 09:19:12','A','N'),('f588ac6b-8b26-4238-bcad-ae2b5654d104',2,'未销号','destroyType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-20 09:08:34','A','N'),('f5c3a36a-659b-4e1d-bbb5-a9ccaeb79f6e',9,'管理学学士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('f61d7c57-7b56-44ee-97fa-0678d76e62d6',2,'生活','djWxGroup_msgType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-01 15:59:15','M','N'),('f6be675c-8d37-418f-a741-5dd82e1fa74d',3,'已考评','democracyReviewPlanStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-06-06 16:23:30','A','N'),('f70ca530-8a22-4de4-9e93-b6b8e6ec5d98',4,'临时学习计划','zxzxxjhlx',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','临时学习计划','2019-09-12 14:54:39','A','N'),('f825f0dc-906c-4b73-b607-98d19ce5cdf7',2,'法学学士','QualificationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('f8527c53-191c-4a79-90f9-4986fa902a90',8,'工作提醒','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-06-11 15:41:23','M','N'),('f8e4331b-ce53-4b5c-a916-659c5f5b8cbd',3,'未参加','signinStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('fa07b78e-6dd8-11ec-bbc0-7085c2a9999e',1,'第一季度','quarterType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2022-01-05 11:38:41','A','N'),('fa08e7ad-6dd8-11ec-bbc0-7085c2a9999e',2,'第二季度','quarterType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2022-01-05 11:38:41','A','N'),('fa09d3be-6dd8-11ec-bbc0-7085c2a9999e',3,'第三季度','quarterType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2022-01-05 11:38:41','A','N'),('fa0ad8ad-6dd8-11ec-bbc0-7085c2a9999e',4,'第四季度','quarterType',1,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','','2022-01-05 11:38:41','A','N'),('fa3d6ad7-61b4-46b9-88ae-666362f75637',2,'博士研究生','EducationType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2022-04-01 15:45:10','a','n'),('fac90dee-f967-42f4-b64d-43bab7bee21f',1,'会议-会场照片','fileType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('fb1794ba-f5a3-4f7f-9a14-617d23373ea3',4,'四期','zgygNumber',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-10-10 09:20:19','A','N'),('fc17598c-60ad-4b6b-add4-533fea692144',6,'统计分析','ModularGroupName',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2021-08-26 17:27:58','M','N'),('fcd5d16e-edbf-40cf-8846-4e317b74c948',2,'手机端','loginType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f','登陆类型','2021-07-05 14:55:40','A','N'),('fd0c63df-ea67-45dc-b129-513127cf264e',1,'活动支出','expendScope',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-04-23 14:04:35','A','N'),('fd48ee66-eee2-4f15-a704-2dbcc214843e',4,'宣传阵地展板图片','fileType',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-02-18 14:40:27','A','N'),('fef21d91-0c4c-4577-b818-9be9373d83a5',1,'已签到','checkinStatus',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2019-08-26 08:47:35','A','Y'),('ff750e9d-f148-4cc6-871f-beebc670ecb3',2,'群团推荐','recommendtype',2,'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,'2020-01-09 16:54:51','A','N');

-- 表结构: cf_file
DROP TABLE IF EXISTS `cf_file`;
CREATE TABLE `cf_file` (
  `FILEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FILENAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILESUFFIX` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILEURL` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILETYPE` decimal(8,0) DEFAULT NULL,
  `FILENOTE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `SFILEID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILEREFID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL,
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`FILEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_file 数据已清理，仅保留表结构

-- 表结构: cf_leader
DROP TABLE IF EXISTS `cf_leader`;
CREATE TABLE `cf_leader` (
  `LEADERGUID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DPID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `POS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SEQUENCE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`LEADERGUID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_leader 数据已清理，仅保留表结构

-- 表结构: cf_leaderadmin
DROP TABLE IF EXISTS `cf_leaderadmin`;
CREATE TABLE `cf_leaderadmin` (
  `USERID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `CREATETIME` datetime DEFAULT NULL COMMENT '添加日期',
  PRIMARY KEY (`USERID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_leaderadmin 数据已清理，仅保留表结构

-- 表结构: cf_log
DROP TABLE IF EXISTS `cf_log`;
CREATE TABLE `cf_log` (
  `LOGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `REQUESTIP` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LOGTIME` datetime DEFAULT NULL,
  `OPMODULE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LOGTEXT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `USERID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LOGTITLE` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '日志标题',
  `CLIENTINFO` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '客户端信息',
  `RESPONSETIME` decimal(8,0) DEFAULT NULL COMMENT '响应时间',
  `ISERROR` decimal(8,0) DEFAULT NULL COMMENT '异常',
  PRIMARY KEY (`LOGID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_log 数据已清理，仅保留表结构

-- 表结构: cf_menu
DROP TABLE IF EXISTS `cf_menu`;
CREATE TABLE `cf_menu` (
  `MENUID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLICATIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PARENTMENUID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MNUSYSTEM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MENUORDER` int DEFAULT NULL,
  `MENUNO` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MENUNAME` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MENUPROGRAM` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MENUPIC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MENUDESC` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISVISIBLE` int DEFAULT NULL,
  `ISLEAF` int DEFAULT NULL,
  `ISBLANK` int DEFAULT NULL,
  PRIMARY KEY (`MENUID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: cf_menu (保留 30 条记录)
INSERT INTO `cf_menu` VALUES ('0ad29499-3981-4ef0-91b9-30a79569bfc3','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','95487f2b-85a2-11e8-8646-001517ca1f2c',NULL,1,'roleList.btnSearch','查询',NULL,NULL,NULL,0,1,NULL),('12357d11-1234-1234-a2f5-111f4972ba05','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','12357d11-1234-4f11-a2f5-0d5f4972ba0f',NULL,6,'home.practicesetting','在线练习',NULL,NULL,'考试模块',0,0,NULL),('12af81e0-71fb-407e-a5fc-d7adbd4c93e3','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','b696d5d6-ab3e-4434-b51a-11683d5a267a',NULL,1,'partyUserList.btnSearch','查询',NULL,NULL,NULL,0,1,NULL),('1306de7a-3a13-449f-ab81-b64078c718b3','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','3b972c56-4fd3-437a-895d-476d5d019013',NULL,2,'userList.btnUpdatepwd','修改密码',NULL,NULL,NULL,0,1,NULL),('13d700d0-735f-462f-b547-523076cc97dd','f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,NULL,17,'home.myBaseInfo','我的基本信息',NULL,'perm_contact_calendar',NULL,1,1,NULL),('15c575c2-1c1a-44c7-9328-e1a4a9c8d227','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','b696d5d6-ab3e-4434-b51a-11683d5a267a',NULL,2,'partyUserList.btnExport','导出',NULL,NULL,NULL,0,1,NULL),('1eab9d10-a5d2-49f0-b31f-bddfcb41780e','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','5fa306725c0c4d8e84766145d3d28ddb',NULL,19,'login','登陆模块',NULL,NULL,NULL,0,1,NULL),('37367c97-9828-402c-88a0-7f58df86e7cf','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','bed737d6-e06f-4319-a48c-99eebd79d92e',NULL,4,'partyList.btnUpdate','修改',NULL,NULL,NULL,0,1,NULL),('38419a9d-004b-4c73-9d40-1b5b01376b26','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','3b972c56-4fd3-437a-895d-476d5d019013',NULL,5,'userList.btnAssignRole','分配角色',NULL,NULL,NULL,0,1,NULL),('395c9e6a-38dc-4ede-94d1-cfeab64a16b5','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','752f3d23-d450-4d31-b94f-3cec81a91369',NULL,1,'home.partyDetailTotalList','党组织情况统计',NULL,NULL,NULL,1,1,NULL),('3967d0c3-7854-4522-b886-d076ed91a5b4','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','95487f2b-85a2-11e8-8646-001517ca1f2c',NULL,3,'roleList.btnUpdate','修改',NULL,NULL,NULL,0,1,NULL),('3b972c56-4fd3-437a-895d-476d5d019013','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','d7632c72-8578-11e8-8646-001517ca1f2c',NULL,1,'home.userList','用户管理',NULL,NULL,NULL,1,0,NULL),('4416cb1a-dc0e-4baf-957b-fda967ab6cd0','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','7253a58d-7211-454f-9c9c-81a3af4ced1c',NULL,1,'home.pu_admitApply','入党申请人',NULL,NULL,NULL,1,1,NULL),('4506847f-b008-47c2-a936-ea034eeda3d0','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','bed737d6-e06f-4319-a48c-99eebd79d92e',NULL,11,'home.partyAdd','新增党组织信息',NULL,NULL,NULL,0,0,NULL),('484e5bbf-d816-4e91-b05e-5c302cd06cb1','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','7253a58d-7211-454f-9c9c-81a3af4ced1c',NULL,4,'home.pu_admitPrepare','预备党员',NULL,NULL,NULL,1,1,NULL),('4a480f60-dc32-4f02-8d63-7155aee3038e','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','b74aaa03-6941-47a3-91af-6156772ae892',NULL,1,'dyUserAdd.btnSave','保存',NULL,NULL,NULL,0,1,NULL),('4ac75dfa-b9f1-44e3-990d-0cbb591eb477','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','d7632c72-8578-11e8-8646-001517ca1f2c',NULL,8,'home.logList','日志管理',NULL,NULL,NULL,1,0,NULL),('4c5a8040-3a59-49b5-8852-45b66b18cdfd','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','7253a58d-7211-454f-9c9c-81a3af4ced1c',NULL,3,'home.pu_admitPass','发展对象',NULL,NULL,NULL,1,1,NULL),('4dd326f2-f2ca-4178-b0e0-20a211cf096e','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','7253a58d-7211-454f-9c9c-81a3af4ced1c',NULL,0,'home.pu_admitRegisterList','入党申请审核','','','',1,0,NULL),('53cecea4-5358-4d0f-b0bc-85a223494000','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','952b8214-85a2-11e8-8646-001517ca1f2c',NULL,1,'dictionarylist.btnadd','新增',NULL,NULL,NULL,0,1,NULL),('575f52ba-7665-4749-bf75-e5b8fdd159ee','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','b696d5d6-ab3e-4434-b51a-11683d5a267a',NULL,10,'partyUserList.btnDetails','查看',NULL,NULL,NULL,0,1,NULL),('5fa306725c0c4d8e84766145d3d28ddb','f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,NULL,0,'home.mainindex','首页',NULL,'home',NULL,1,0,NULL),('5fbbc852-f6c1-4486-b8ea-df816d9a0782','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','bed737d6-e06f-4319-a48c-99eebd79d92e',NULL,13,'home.partyShow','党委(党工委),('653b4a63-377f-415e-95db-94edd51e9b66','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','7253a58d-7211-454f-9c9c-81a3af4ced1c',NULL,5,'home.pu_admitList','正式党员',NULL,NULL,NULL,1,1,NULL),('65507a81-e87a-430c-8abe-06fee2a78546','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','3b972c56-4fd3-437a-895d-476d5d019013',NULL,1,'userList.btnSearch','查询',NULL,NULL,NULL,0,1,NULL),('6ed6fd91-af14-403d-8d15-c6ae9544cc62','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','952b8214-85a2-11e8-8646-001517ca1f2c',NULL,2,'dictionarylist.listedit','修改详情',NULL,NULL,NULL,0,1,NULL),('7253a58d-7211-454f-9c9c-81a3af4ced1c','f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,NULL,5,'发展党员2','党员发展',NULL,'person_add',NULL,1,0,NULL),('752f3d23-d450-4d31-b94f-3cec81a91369','f0c4fa7f9f3c4fb6bd56aac608b7ad3f',NULL,NULL,20,'partyTotalList','党内统计',NULL,'view_list',NULL,1,0,NULL),('753b4a63-377f-415e-95db-94edd51e9b66','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','7253a58d-7211-454f-9c9c-81a3af4ced1c',NULL,6,'home.pu_ArchiveList','历史归档',NULL,NULL,NULL,1,1,NULL),('75e4b567-e180-4ec8-a72f-3eb045a63059','f0c4fa7f9f3c4fb6bd56aac608b7ad3f','bed737d6-e06f-4319-a48c-99eebd79d92e',NULL,2,'partyList.btnExport','导出',NULL,NULL,NULL,0,1,NULL);

-- 表结构: cf_menu_role
DROP TABLE IF EXISTS `cf_menu_role`;
CREATE TABLE `cf_menu_role` (
  `MENUID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ROLEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`MENUID`,`ROLEID`) USING BTREE,
  KEY `FK_CF_MENU__REF_MR_RO_CF_ROLES` (`ROLEID`) USING BTREE,
  CONSTRAINT `FK_CF_MENU__REF_MR_ME_CF_MENU` FOREIGN KEY (`MENUID`) REFERENCES `cf_menu` (`MENUID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_CF_MENU__REF_MR_RO_CF_ROLES` FOREIGN KEY (`ROLEID`) REFERENCES `cf_roles` (`ROLEID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: cf_menu_role (保留 30 条记录)
INSERT INTO `cf_menu_role` VALUES ('5fa306725c0c4d8e84766145d3d28ddb','0b08a29e-a5e1-4f68-b5ab-c77231e85539'),('996c7331-1f94-48f0-b246-d6ddb178ae7f','0b08a29e-a5e1-4f68-b5ab-c77231e85539'),('13d700d0-735f-462f-b547-523076cc97dd','0b45886a-a8db-4f85-af76-61a8ea7c1dab'),('5fa306725c0c4d8e84766145d3d28ddb','0b45886a-a8db-4f85-af76-61a8ea7c1dab'),('5fa306725c0c4d8e84766145d3d28ddb','18e273e9-b3a5-49f5-be66-3dbdfc7acc10'),('996c7331-1f94-48f0-b246-d6ddb178ae7f','18e273e9-b3a5-49f5-be66-3dbdfc7acc10'),('12af81e0-71fb-407e-a5fc-d7adbd4c93e3','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('1306de7a-3a13-449f-ab81-b64078c718b3','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('15c575c2-1c1a-44c7-9328-e1a4a9c8d227','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('37367c97-9828-402c-88a0-7f58df86e7cf','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('3b972c56-4fd3-437a-895d-476d5d019013','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('4416cb1a-dc0e-4baf-957b-fda967ab6cd0','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('484e5bbf-d816-4e91-b05e-5c302cd06cb1','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('4c5a8040-3a59-49b5-8852-45b66b18cdfd','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('4dd326f2-f2ca-4178-b0e0-20a211cf096e','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('575f52ba-7665-4749-bf75-e5b8fdd159ee','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('5fa306725c0c4d8e84766145d3d28ddb','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('653b4a63-377f-415e-95db-94edd51e9b66','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('65507a81-e87a-430c-8abe-06fee2a78546','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('7253a58d-7211-454f-9c9c-81a3af4ced1c','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('753b4a63-377f-415e-95db-94edd51e9b66','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('75e4b567-e180-4ec8-a72f-3eb045a63059','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('76f09b9e-a8e5-434c-a9e2-63fdf8d028af','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('792b823d-cce5-494d-9aa4-d1c0cc7e3751','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('878a9c19-b0c1-4a9f-9543-76e46536826c','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('96bd79c5-ae49-47a6-9449-05a0258511c2','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('996c7331-1f94-48f0-b246-d6ddb178ae7f','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('a2640551-3b11-484b-9420-4376641a760c','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('b696d5d6-ab3e-4434-b51a-11683d5a267a','1a485105-307f-4b6b-a4f7-daac4dee52e3'),('ba230044-f88d-445c-a12a-36bd9ed186e5','1a485105-307f-4b6b-a4f7-daac4dee52e3');

-- 表结构: cf_message
DROP TABLE IF EXISTS `cf_message`;
CREATE TABLE `cf_message` (
  `MESSAGEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `MSGTITLE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '信息标题',
  `URL` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '信息地址',
  `FROMUSER` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发送人',
  `TOUSER` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '接收人',
  `SENDTIME` datetime DEFAULT NULL COMMENT '发送时间',
  `STATE` decimal(8,0) DEFAULT NULL COMMENT '状态',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识',
  `MSGCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '消息内容',
  `BUSINESSID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MESSAGETYPE` decimal(8,0) DEFAULT NULL,
  `SERVICEID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '服务发送id',
  `SERVICESTATE` decimal(8,0) DEFAULT NULL COMMENT '服务发送状态',
  `SERVICEUPDATATIME` datetime DEFAULT NULL COMMENT '服务更新时间',
  PRIMARY KEY (`MESSAGEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_message 数据已清理，仅保留表结构

-- 表结构: cf_oudetail
DROP TABLE IF EXISTS `cf_oudetail`;
CREATE TABLE `cf_oudetail` (
  `DPKEY` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DPID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DPNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PARENTDPID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DPFULLNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DPCODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISTMPDP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DEPTORDERNO` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISDEL` int DEFAULT NULL,
  PRIMARY KEY (`DPKEY`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: cf_oudetail (保留 1 条记录)
INSERT INTO `cf_oudetail` VALUES ('a6397be1daf54633bdef5d336cf829b0','1','广铁公司',NULL,'广铁公司','1','0','1',0);

-- 表结构: cf_partyusercount
DROP TABLE IF EXISTS `cf_partyusercount`;
CREATE TABLE `cf_partyusercount` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `DZZDM` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '党组织编码',
  `DZZMC` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '党组织名称',
  `YEAR` decimal(8,0) DEFAULT NULL COMMENT '年',
  `MONTH` decimal(8,0) DEFAULT NULL COMMENT '月',
  `COUNT` decimal(8,0) DEFAULT NULL COMMENT '当前组织成员',
  `ALLCOUNT` decimal(8,0) DEFAULT NULL COMMENT '当前组织以及子级所有成员',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='党组织每月成员数量';

-- 表 cf_partyusercount 数据已清理，仅保留表结构

-- 表结构: cf_payorder
DROP TABLE IF EXISTS `cf_payorder`;
CREATE TABLE `cf_payorder` (
  `payOrderId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '支付订单id（微信商品ID）',
  `payRelId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '关联业务id',
  `payNo` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商户订单号，系统生成唯一，规则P+年月日+11位随机数',
  `payTime` datetime DEFAULT NULL COMMENT '支付时间',
  `payAmount` decimal(18,2) DEFAULT NULL COMMENT '支付金额（单位：元）',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标题',
  `remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `payState` int DEFAULT NULL COMMENT '1：待支付，2：支付成功，3：支付失败',
  `queryTime` datetime DEFAULT NULL COMMENT '查询结果时间',
  `tradeState` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '交易状态，同步微信支付结果',
  `payFallMessage` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '失败信息',
  `createTime` datetime DEFAULT NULL,
  `createUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  `modifyUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tradeType` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信支付类型：NATIVE、MWEB、JSAPI',
  `openID` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`payOrderId`) USING BTREE,
  KEY `index_cf_payorder_union_column` (`payRelId`,`payState`,`payAmount`,`payTime`,`modifyTime`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_payorder 数据已清理，仅保留表结构

-- 表结构: cf_payorder_refund
DROP TABLE IF EXISTS `cf_payorder_refund`;
CREATE TABLE `cf_payorder_refund` (
  `refundId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `payOrderId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '支付订单id（微信商品ID）',
  `refundNo` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商户退款单号，系统生成唯一，规则：R+年月日+11位随机数',
  `refundTime` datetime DEFAULT NULL COMMENT '退款时间',
  `refundAmount` decimal(18,2) DEFAULT NULL COMMENT '退款金额（单位：元）',
  `refundState` int DEFAULT NULL COMMENT '退款状态',
  `queryTime` datetime DEFAULT NULL COMMENT '查询结果时间',
  `refundFallMessage` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '失败信息',
  `createTime` datetime DEFAULT NULL,
  `createUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  `modifyUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`refundId`) USING BTREE,
  KEY `FK_CF_PAYORDER_PAYORDER_REFUND` (`payOrderId`) USING BTREE,
  CONSTRAINT `FK_CF_PAYORDER_PAYORDER_REFUND` FOREIGN KEY (`payOrderId`) REFERENCES `cf_payorder` (`payOrderId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_payorder_refund 数据已清理，仅保留表结构

-- 表结构: cf_roles
DROP TABLE IF EXISTS `cf_roles`;
CREATE TABLE `cf_roles` (
  `ROLEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLICATIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ROLENAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GROUPBY` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ORDERBY` int DEFAULT NULL,
  `DICTIONARYID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ROLEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: cf_roles (创建3个默认角色)
INSERT INTO `cf_roles` VALUES ('admin-role-id','app-id','系统管理员','系统管理员','系统管理员',1,'73ad65f3-b95c-4cc9-9dc9-667683d19f34');
INSERT INTO `cf_roles` VALUES ('party-role-id','app-id','普通党员','普通党员','普通党员',2,'4f2bfe4e-ea0f-4b82-9ddd-ab215c20a13a');
INSERT INTO `cf_roles` VALUES ('org-role-id','app-id','组织员','组织员','组织员',3,'e83c7e1b-6281-446e-b01a-c97c13812345');

-- 表结构: cf_sn
DROP TABLE IF EXISTS `cf_sn`;
CREATE TABLE `cf_sn` (
  `SNID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SNNUM` int DEFAULT NULL,
  `SNKEY` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PREFIX` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RESETTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`SNID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_sn 数据已清理，仅保留表结构

-- 表结构: cf_userappinfo
DROP TABLE IF EXISTS `cf_userappinfo`;
CREATE TABLE `cf_userappinfo` (
  `USERAPPINFOID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编号',
  `USERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员名称',
  `REFUSERID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'APP人员ID',
  PRIMARY KEY (`USERAPPINFOID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_userappinfo 数据已清理，仅保留表结构

-- 表结构: cf_userroles
DROP TABLE IF EXISTS `cf_userroles`;
CREATE TABLE `cf_userroles` (
  `ROLEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ROLEID`,`USERID`) USING BTREE,
  KEY `FK_CF_USERR_REF_USER__CF_USERS` (`USERID`) USING BTREE,
  CONSTRAINT `FK_CF_USERR_REF_ROLE__CF_ROLES` FOREIGN KEY (`ROLEID`) REFERENCES `cf_roles` (`ROLEID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_CF_USERR_REF_USER__CF_USERS` FOREIGN KEY (`USERID`) REFERENCES `cf_users` (`USERID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: cf_userroles (创建3个默认用户角色关联)
INSERT INTO `cf_userroles` VALUES ('admin-role-id','admin-id');
INSERT INTO `cf_userroles` VALUES ('party-role-id','party-id');
INSERT INTO `cf_userroles` VALUES ('org-role-id','org-id');

-- 表结构: cf_users
DROP TABLE IF EXISTS `cf_users`;
CREATE TABLE `cf_users` (
  `USERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLICATIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISANONYMOUS` int DEFAULT NULL,
  `LASTACTIVITYDATE` datetime DEFAULT NULL,
  `USERPWD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FORCELOGINOUT` decimal(8,0) DEFAULT NULL,
  `OAUSERID` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公网用户id',
  `OAUSERSFZ` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公网用户验证身份证',
  `wxUserId` int DEFAULT NULL,
  PRIMARY KEY (`USERID`) USING BTREE,
  KEY `FK_CF_USERS_REF_APP_U_CF_APPLI` (`APPLICATIONID`) USING BTREE,
  CONSTRAINT `FK_CF_USERS_REF_APP_U_CF_APPLI` FOREIGN KEY (`APPLICATIONID`) REFERENCES `cf_applications` (`APPLICATIONID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: cf_users (创建3个默认用户)
INSERT INTO `cf_users` VALUES ('admin-id','app-id','admin',1,'2023-01-01 00:00:00','E10ADC3949BA59ABBE56E057F20F883E',0,NULL,NULL,NULL);
INSERT INTO `cf_users` VALUES ('party-id','app-id','party_member',1,'2023-01-01 00:00:00','E10ADC3949BA59ABBE56E057F20F883E',0,NULL,NULL,NULL);
INSERT INTO `cf_users` VALUES ('org-id','app-id','organizer',1,'2023-01-01 00:00:00','E10ADC3949BA59ABBE56E057F20F883E',0,NULL,NULL,NULL);

-- 表结构: cf_users_20220519
DROP TABLE IF EXISTS `cf_users_20220519`;
CREATE TABLE `cf_users_20220519` (
  `USERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLICATIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISANONYMOUS` int DEFAULT NULL,
  `LASTACTIVITYDATE` datetime DEFAULT NULL,
  `USERPWD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FORCELOGINOUT` decimal(8,0) DEFAULT NULL,
  `OAUSERID` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公网用户id',
  `OAUSERSFZ` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公网用户验证身份证'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_users_20220519 数据已清理，仅保留表结构

-- 表结构: cf_usersinfo
DROP TABLE IF EXISTS `cf_usersinfo`;
CREATE TABLE `cf_usersinfo` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DGUSERID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MOBILE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TELEPHONENUMBER` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BIRTHDAY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DPID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DPNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DPCODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PARENTDPID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DPFULLNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOBTYPEID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DESJOBTYPE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `EMPLOYEECLASSID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DESEMPLOYEECLASS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SEXID` int DEFAULT NULL,
  `ORDERNO` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERROLE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERLIGION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISTMPUSER` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERTYPE` int DEFAULT NULL,
  `POSITION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `WECHAT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ISENABLE` int DEFAULT NULL COMMENT '0禁用，1启用',
  PRIMARY KEY (`ID`) USING BTREE,
  CONSTRAINT `FK_CF_USERS_REF_USER__CF_USERS` FOREIGN KEY (`ID`) REFERENCES `cf_users` (`USERID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_usersinfo 数据已清理，仅保留表结构

-- 表结构: cf_usersort
DROP TABLE IF EXISTS `cf_usersort`;
CREATE TABLE `cf_usersort` (
  `USERCODE` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户编码',
  `SORTS` decimal(8,0) DEFAULT NULL COMMENT '排序',
  `POSITION` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '职务名称',
  PRIMARY KEY (`USERCODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 cf_usersort 数据已清理，仅保留表结构

-- 表结构: dj_brand
DROP TABLE IF EXISTS `dj_brand`;
CREATE TABLE `dj_brand` (
  `BRANDID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党支部',
  `PBRANDNAME` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党内品牌名称',
  `CREATTYPE` decimal(8,0) DEFAULT NULL,
  `BRANDTIME` datetime DEFAULT NULL COMMENT '挂牌时间',
  `BRANDCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '内容',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`BRANDID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: dj_brand (保留 1 条记录)
INSERT INTO `dj_brand` VALUES ('0f6e5045-e952-4326-9771-f85443a0ab96','学院党委','001091209017','测试',2,'2021-12-29 00:00:00','测试11','2021-12-29 10:23:11','2121408464','管理员','2021-12-29 10:24:21','2121408464','管理员','2021-12-29 10:24:23','D','N');

-- 表结构: dj_djkpxx
DROP TABLE IF EXISTS `dj_djkpxx`;
CREATE TABLE `dj_djkpxx` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YEAR` int DEFAULT NULL,
  `QUARTER1` double DEFAULT NULL,
  `QUARTER2` double DEFAULT NULL,
  `QUARTER3` double DEFAULT NULL,
  `QUARTER4` double DEFAULT NULL,
  `ANNUALSCORE` double DEFAULT NULL,
  `JUDGELEVEL` int DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: dj_djkpxx (保留 1 条记录)
INSERT INTO `dj_djkpxx` VALUES ('1d0d7b16-1ca4-4505-beb0-b053d0b8deee','物流电商教师党支部','001091209017001002',2022,98,96,98,100,NULL,5,NULL,NULL,NULL,NULL,NULL,'2022-03-15 12:54:12','A','N');

-- 表结构: dj_dnghbf
DROP TABLE IF EXISTS `dj_dnghbf`;
CREATE TABLE `dj_dnghbf` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织名称',
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `USERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员id',
  `USERNAME` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员姓名',
  `CARETYPE` int DEFAULT NULL COMMENT '类型',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人id',
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人姓名',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人id',
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人姓名',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_dnghbf 数据已清理，仅保留表结构

-- 表结构: dj_dnghbfmx
DROP TABLE IF EXISTS `dj_dnghbfmx`;
CREATE TABLE `dj_dnghbfmx` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DNGHBFID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '关联党内关怀帮扶',
  `CAREDATE` datetime DEFAULT NULL COMMENT '帮扶时间',
  `CARECONTENT` varchar(360) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '帮扶内容',
  `HELPFORMTYPE` decimal(8,0) DEFAULT NULL,
  `HELPFORM` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `AMOUNT` int DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_DJ_DNGHB_REFERENCE_DJ_DNGHB` (`DNGHBFID`) USING BTREE,
  CONSTRAINT `FK_DJ_DNGHB_REFERENCE_DJ_DNGHB` FOREIGN KEY (`DNGHBFID`) REFERENCES `dj_dnghbf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_dnghbfmx 数据已清理，仅保留表结构

-- 表结构: dj_dnpxry
DROP TABLE IF EXISTS `dj_dnpxry`;
CREATE TABLE `dj_dnpxry` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DNPXID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员',
  `USERNAME` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员姓名',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: dj_dnpxry (保留 1 条记录)
INSERT INTO `dj_dnpxry` VALUES ('f1d86e07-6363-4519-9a76-680bac1e5d7c','d6ef59dd-27a6-4860-b7e6-47c2009a0843','127687','管理员');

-- 表结构: dj_dnpxxx
DROP TABLE IF EXISTS `dj_dnpxxx`;
CREATE TABLE `dj_dnpxxx` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HONOURTIME` datetime DEFAULT NULL,
  `HONOURLEVEL` int DEFAULT NULL,
  `HONOURNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `ISCOMMEND` int DEFAULT NULL,
  `PXLX` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HONOURTYPE` int DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: dj_dnpxxx (保留 1 条记录)
INSERT INTO `dj_dnpxxx` VALUES ('d6ef59dd-27a6-4860-b7e6-47c2009a0843','河北化工医药职业技术学院党委','001091209017','2023-04-01 00:00:00',1,'优秀党务工作者',NULL,NULL,NULL,NULL,NULL,'2025-02-27 09:41:16','A','N',1,'1',4);

-- 表结构: dj_fundsbudget
DROP TABLE IF EXISTS `dj_fundsbudget`;
CREATE TABLE `dj_fundsbudget` (
  `FUNDSBUDGETID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党组织代码',
  `YEAR` decimal(8,0) DEFAULT NULL COMMENT '年份',
  `ACTIVITYFUNDS` int DEFAULT NULL COMMENT '活动经费（万元）',
  `REWARDFUNDS` int DEFAULT NULL COMMENT '奖励经费（万元）',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人编码',
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人姓名',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人编码',
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人姓名',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`FUNDSBUDGETID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: dj_fundsbudget (保留 1 条记录)
INSERT INTO `dj_fundsbudget` VALUES ('26b759dd-4027-4486-a7f1-4627f1142c0d','001091209017',2021,1,0,NULL,NULL,NULL,NULL,NULL,NULL,'2022-03-15 12:25:33','A','N');

-- 表结构: dj_fundsincome
DROP TABLE IF EXISTS `dj_fundsincome`;
CREATE TABLE `dj_fundsincome` (
  `FUNDSBUDGETID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '唯一标识',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党组织代码',
  `YEAR` decimal(8,0) DEFAULT NULL COMMENT '年份',
  `BUDGETREVENUE` int DEFAULT NULL COMMENT '预算收入(万元)',
  `BUDGETEXPEND` int DEFAULT NULL COMMENT '预算支出(万元)',
  `APPROPRIATION` int DEFAULT NULL COMMENT '上级党组织拨付(万元)',
  `INTEREST` int DEFAULT NULL COMMENT '党费利息(万元)',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人编码',
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人姓名',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人编码',
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人姓名',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`FUNDSBUDGETID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表数据: dj_fundsincome (保留 1 条记录)
INSERT INTO `dj_fundsincome` VALUES ('60c29371-ce1d-4f88-8a59-93f31bcd2319','001091209017',2021,1000000,100,100,100,'2021-12-28 15:05:02','2121408464','管理员','2021-12-29 09:41:02','2121408464','管理员','2021-12-29 09:41:02','M','N');

-- 表结构: dj_fundsuse
DROP TABLE IF EXISTS `dj_fundsuse`;
CREATE TABLE `dj_fundsuse` (
  `FUNDSUSEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党组织代码',
  `HANDLEUSERID` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '经办人',
  `HANDLEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '经办人姓名',
  `EXPENDTIME` datetime DEFAULT NULL COMMENT '支出时间',
  `EXPENDMONEY` int DEFAULT NULL COMMENT '支出总额（元）',
  `EXPENDSCOPE` decimal(8,0) DEFAULT NULL COMMENT '支出范围',
  `EXPENDTYPE` decimal(8,0) DEFAULT NULL COMMENT '支出类型',
  `EXPENDREASON` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '支出事由',
  `EXPENDDETAIL` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '支出预算',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人编码',
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人姓名',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人编码',
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人姓名',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`FUNDSUSEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_fundsuse 数据已清理，仅保留表结构

-- 表结构: dj_gdwydqk
DROP TABLE IF EXISTS `dj_gdwydqk`;
CREATE TABLE `dj_gdwydqk` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZMC` varchar(336) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NY` datetime DEFAULT NULL COMMENT '年月',
  `DWZRS` decimal(8,0) DEFAULT NULL COMMENT '单位总人数',
  `DWGZZRS` decimal(8,0) DEFAULT NULL COMMENT '单位关注总人数',
  `DZBSJYDL` decimal(8,0) DEFAULT NULL COMMENT '党支部书记阅读量',
  `DYYDL` decimal(8,0) DEFAULT NULL COMMENT '党员阅读量',
  `DZLV` int DEFAULT NULL COMMENT '点赞率',
  `DDLDF` int DEFAULT NULL COMMENT '到达率得分',
  `LDBZYDL` decimal(8,0) DEFAULT NULL COMMENT '领导班子阅读量',
  `PJDZL` int DEFAULT NULL COMMENT '篇均点赞量',
  `DDL` int DEFAULT NULL COMMENT '到达率',
  `YDLV` int DEFAULT NULL COMMENT '阅读率',
  `YDL` decimal(8,0) DEFAULT NULL COMMENT '阅读量\r\n  阅读量',
  `DZL` decimal(8,0) DEFAULT NULL COMMENT '点赞量',
  `PJYDL` int DEFAULT NULL COMMENT '篇均阅读量',
  `ORDERBY` decimal(8,0) DEFAULT NULL COMMENT '拍序列',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_gdwydqk 数据已清理，仅保留表结构

-- 表结构: dj_jlcfxx
DROP TABLE IF EXISTS `dj_jlcfxx`;
CREATE TABLE `dj_jlcfxx` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `APPROVALDATE` datetime DEFAULT NULL,
  `PUNISHTYPE` int DEFAULT NULL,
  `SYMBOL` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UNIT` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DESCRIBE` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `OFFENCETYPE` int DEFAULT NULL,
  `YXKSRQ` datetime DEFAULT NULL,
  `YXJSRQ` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_jlcfxx 数据已清理，仅保留表结构

-- 表结构: dj_partyactivityroom
DROP TABLE IF EXISTS `dj_partyactivityroom`;
CREATE TABLE `dj_partyactivityroom` (
  `PARTYACTIVITYROOMID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PARTYNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党支部',
  `ADDR` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址',
  `PCOUNT` decimal(8,0) DEFAULT NULL COMMENT '党员人数',
  `USERANGE` decimal(8,0) DEFAULT NULL COMMENT '使用范围',
  `USEAREA` int DEFAULT NULL COMMENT '面积',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`PARTYACTIVITYROOMID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_partyactivityroom 数据已清理，仅保留表结构

-- 表结构: dj_partyactivityroomgroup
DROP TABLE IF EXISTS `dj_partyactivityroomgroup`;
CREATE TABLE `dj_partyactivityroomgroup` (
  `GROUPID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PARTYACTIVITYROOMID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属活动室',
  `DZZDM` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `DZZMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织名称',
  PRIMARY KEY (`GROUPID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='党员活动室使用党支部';

-- 表 dj_partyactivityroomgroup 数据已清理，仅保留表结构

-- 表结构: dj_repository
DROP TABLE IF EXISTS `dj_repository`;
CREATE TABLE `dj_repository` (
  `FILEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `FILENAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件名',
  `FILEURL` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件路径',
  `EXTENDEDNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `FILETYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '模板类型id',
  `FILECODE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件编号',
  `FILECODE2` int DEFAULT NULL COMMENT '排序号',
  `ssfl` int DEFAULT NULL COMMENT '所属分类',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `UPDATEDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`FILEID`) USING BTREE,
  KEY `DJ_REPOSITORY_FOREIGN_FILETYPEID` (`FILETYPEID`) USING BTREE,
  CONSTRAINT `DJ_REPOSITORY_FOREIGN_FILETYPEID` FOREIGN KEY (`FILETYPEID`) REFERENCES `dj_repositorytype` (`FILETYPEID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_repository 数据已清理，仅保留表结构

-- 表结构: dj_repositorytype
DROP TABLE IF EXISTS `dj_repositorytype`;
CREATE TABLE `dj_repositorytype` (
  `FILETYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '模板类型id',
  `PARENTTYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父级模板类型id',
  `FILETYPENAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '模板类型名称',
  `TREELEVEL` int DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`FILETYPEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_repositorytype 数据已清理，仅保留表结构

-- 表结构: dj_resultmg
DROP TABLE IF EXISTS `dj_resultmg`;
CREATE TABLE `dj_resultmg` (
  `DJ_RESULTMGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主健',
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党支部',
  `RESULTNAME` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党建成果名称',
  `SCORETEXT` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '做法',
  `SCORETIME` datetime DEFAULT NULL COMMENT '评审时间',
  `NOTE` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`DJ_RESULTMGID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_resultmg 数据已清理，仅保留表结构

-- 表结构: dj_task
DROP TABLE IF EXISTS `dj_task`;
CREATE TABLE `dj_task` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TASKNAME` varchar(366) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务名称',
  `TASKTIME` datetime DEFAULT NULL COMMENT '下达时间',
  `ENDTIME` datetime DEFAULT NULL COMMENT '截至时间',
  `SENDDEPART` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发送部门',
  `TASKCONTENT` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任务内容',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发起人id',
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发起人姓名',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人id',
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人姓名',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `TASKTYPE` decimal(8,0) DEFAULT NULL COMMENT '任务类型 1、普通任务 2、收集任务',
  `ISTERMINATE` decimal(8,0) DEFAULT NULL COMMENT '是否终止收集任务1：是 0：否',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_task 数据已清理，仅保留表结构

-- 表结构: dj_taskusers
DROP TABLE IF EXISTS `dj_taskusers`;
CREATE TABLE `dj_taskusers` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TASKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '关联任务表',
  `USERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员',
  `USERNAME` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员姓名',
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `DZZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织名称',
  `ISRECEIVE` decimal(8,0) DEFAULT NULL,
  `RECEIVETIME` datetime DEFAULT NULL COMMENT '回复时间',
  `RECEIVENUM` decimal(8,0) DEFAULT NULL COMMENT '回复次数',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_taskusers 数据已清理，仅保留表结构

-- 表结构: dj_workresourcelibrary
DROP TABLE IF EXISTS `dj_workresourcelibrary`;
CREATE TABLE `dj_workresourcelibrary` (
  `FILEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `FILENAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件名',
  `FILEURL` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件路径',
  `EXTENDEDNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `FILETYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '模板类型id',
  `FILECODE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件编号',
  `FILECODE2` int DEFAULT NULL COMMENT '排序号',
  `ssfl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERID` int DEFAULT NULL,
  `updatedatetime` datetime DEFAULT NULL,
  `updateuserid` int DEFAULT NULL,
  PRIMARY KEY (`FILEID`) USING BTREE,
  KEY `FK_DSJ_FILE_REFERENCE_DSJ_FILE` (`FILETYPEID`) USING BTREE,
  CONSTRAINT `dj_workresourcelibrary_ibfk_1` FOREIGN KEY (`FILETYPEID`) REFERENCES `dsj_filetype` (`FILETYPEID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_workresourcelibrary 数据已清理，仅保留表结构

-- 表结构: dj_workresourcelibrarytype
DROP TABLE IF EXISTS `dj_workresourcelibrarytype`;
CREATE TABLE `dj_workresourcelibrarytype` (
  `FILETYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '模板类型id',
  `PARENTTYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父级模板类型id',
  `FILETYPENAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '模板类型名称',
  `TREELEVEL` int DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`FILETYPEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_workresourcelibrarytype 数据已清理，仅保留表结构

-- 表结构: dj_wxgroup
DROP TABLE IF EXISTS `dj_wxgroup`;
CREATE TABLE `dj_wxgroup` (
  `WXGROUPID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党支部',
  `GROUPNAME` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '群名',
  `BUILDTIME` datetime DEFAULT NULL COMMENT '成立时间',
  `IMPLATFORM` decimal(8,0) DEFAULT NULL COMMENT '所在平台',
  `MIRROR` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '监管人',
  `GROUPERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '群主姓名',
  `GROUPERDUTY` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '群主职务',
  `GROUPERTEL` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '群主电话',
  `MAINABLE` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '主要功能',
  `MIRRORWAY` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '监管措施',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `SCALENUMBER` decimal(8,0) DEFAULT NULL,
  `MSGTYPE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`WXGROUPID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_wxgroup 数据已清理，仅保留表结构

-- 表结构: dj_wxgroupuser
DROP TABLE IF EXISTS `dj_wxgroupuser`;
CREATE TABLE `dj_wxgroupuser` (
  `WXGROUPUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `WXGROUPID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `SEX` decimal(8,0) DEFAULT NULL COMMENT '性别',
  `MOBILE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`WXGROUPUSERID`) USING BTREE,
  KEY `IX_WXGROUPUSER_WXGROUPID` (`WXGROUPID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_wxgroupuser 数据已清理，仅保留表结构

-- 表结构: dj_ztdrxx
DROP TABLE IF EXISTS `dj_ztdrxx`;
CREATE TABLE `dj_ztdrxx` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TITLE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ACTIVITYTIME` datetime DEFAULT NULL,
  `LOCATION` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SUBJECTTYPE` int DEFAULT NULL,
  `SUBJECTCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_ztdrxx 数据已清理，仅保留表结构

-- 表结构: dj_zzsr
DROP TABLE IF EXISTS `dj_zzsr`;
CREATE TABLE `dj_zzsr` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键。',
  `DZZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织名称。',
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码。',
  `TITLE` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '主题。',
  `ACTIVITYTIME` datetime DEFAULT NULL COMMENT '活动时间。',
  `LOCATION` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地点。',
  `SUBJECTTYPE` int DEFAULT NULL COMMENT '类别。',
  `SUBJECTCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '内容。',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人ID。',
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人姓名。',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间。',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人ID。',
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人姓名。',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dj_zzsr 数据已清理，仅保留表结构

-- 表结构: djzzrs_fzjggl
DROP TABLE IF EXISTS `djzzrs_fzjggl`;
CREATE TABLE `djzzrs_fzjggl` (
  `GLID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分组机构关联id',
  `DZZBM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织标识码(单位标识码或机构标识码)',
  `JGFZID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '机构分组id',
  `FZZT` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分组状态(0无效1有效)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_PERSON` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_PERSON` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `COME_FROM` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '数据来源(1PC、2微信、3安卓、4iOS、5平板、6外部某系统)',
  `VERSION` int DEFAULT NULL COMMENT '版本',
  `ORG_ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属机构',
  `REMARKS` varchar(420) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`GLID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='分组机构关联表';

-- 表 djzzrs_fzjggl 数据已清理，仅保留表结构

-- 表结构: djzzrs_jgfz
DROP TABLE IF EXISTS `djzzrs_jgfz`;
CREATE TABLE `djzzrs_jgfz` (
  `JGFZID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '机构分组id',
  `FZMC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分组名称',
  `FJGFZID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父机构分组id',
  `FZZT` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分组状态(0无效1有效)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_PERSON` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_PERSON` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `COME_FROM` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '数据来源(1PC、2微信、3安卓、4iOS、5平板、6外部某系统)',
  `VERSION` int DEFAULT NULL COMMENT '版本',
  `ORG_ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属机构',
  `REMARKS` varchar(420) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `ORDERBY` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`JGFZID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='机构分组表';

-- 表 djzzrs_jgfz 数据已清理，仅保留表结构

-- 表结构: dsj_cgjq
DROP TABLE IF EXISTS `dsj_cgjq`;
CREATE TABLE `dsj_cgjq` (
  `CGJQBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LBMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SL` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`CGJQBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_cgjq 数据已清理，仅保留表结构

-- 表结构: dsj_czqk
DROP TABLE IF EXISTS `dsj_czqk`;
CREATE TABLE `dsj_czqk` (
  `CZQKBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ND` decimal(8,0) DEFAULT NULL,
  `CPDY` decimal(8,0) DEFAULT NULL,
  `BHGDY` decimal(8,0) DEFAULT NULL,
  `CLDBHGDY` decimal(8,0) DEFAULT NULL,
  `CDZRS` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`CZQKBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_czqk 数据已清理，仅保留表结构

-- 表结构: dsj_dnpp
DROP TABLE IF EXISTS `dsj_dnpp`;
CREATE TABLE `dsj_dnpp` (
  `DNPPBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LBMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SL` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`DNPPBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_dnpp 数据已清理，仅保留表结构

-- 表结构: dsj_dydt
DROP TABLE IF EXISTS `dsj_dydt`;
CREATE TABLE `dsj_dydt` (
  `DYDTBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ND` decimal(8,0) DEFAULT NULL,
  `ZR` decimal(8,0) DEFAULT NULL,
  `ZC` decimal(8,0) DEFAULT NULL,
  `NBJZ` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`DYDTBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_dydt 数据已清理，仅保留表结构

-- 表结构: dsj_dyfzqk
DROP TABLE IF EXISTS `dsj_dyfzqk`;
CREATE TABLE `dsj_dyfzqk` (
  `DYFZQKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ND` decimal(8,0) DEFAULT NULL,
  `JHFZDYSL` decimal(8,0) DEFAULT NULL,
  `NV` decimal(8,0) DEFAULT NULL,
  `SSMZ` decimal(8,0) DEFAULT NULL,
  `SWJYX` decimal(8,0) DEFAULT NULL,
  `DZJYSXL` decimal(8,0) DEFAULT NULL,
  `GR` decimal(8,0) DEFAULT NULL,
  `SCGZDYX` decimal(8,0) DEFAULT NULL,
  `QYSCDYX` decimal(8,0) DEFAULT NULL,
  `YSDYX` decimal(8,0) DEFAULT NULL,
  `BZZ` decimal(8,0) DEFAULT NULL,
  `GTLY` decimal(8,0) DEFAULT NULL,
  `GTCWLY` decimal(8,0) DEFAULT NULL,
  `LWPQG` decimal(8,0) DEFAULT NULL,
  `XJMFRW` decimal(8,0) DEFAULT NULL,
  `GZSQT` decimal(8,0) DEFAULT NULL,
  `GQTY` decimal(8,0) DEFAULT NULL,
  `MQWDYBZS` decimal(8,0) DEFAULT NULL,
  `JHFZS` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`DYFZQKID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_dyfzqk 数据已清理，仅保留表结构

-- 表结构: dsj_filemrg
DROP TABLE IF EXISTS `dsj_filemrg`;
CREATE TABLE `dsj_filemrg` (
  `FILEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FILENAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILEURL` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `EXTENDEDNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEDATETIME` datetime DEFAULT NULL,
  `FILETYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILECODE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILECODE2` int DEFAULT NULL,
  PRIMARY KEY (`FILEID`) USING BTREE,
  KEY `FK_DSJ_FILE_REFERENCE_DSJ_FILE` (`FILETYPEID`) USING BTREE,
  CONSTRAINT `FK_DSJ_FILE_REFERENCE_DSJ_FILE` FOREIGN KEY (`FILETYPEID`) REFERENCES `dsj_filetype` (`FILETYPEID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_filemrg 数据已清理，仅保留表结构

-- 表结构: dsj_filetype
DROP TABLE IF EXISTS `dsj_filetype`;
CREATE TABLE `dsj_filetype` (
  `FILETYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PARENTTYPEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FILETYPENAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TREELEVEL` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`FILETYPEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_filetype 数据已清理，仅保留表结构

-- 表结构: dsj_fzdyqk
DROP TABLE IF EXISTS `dsj_fzdyqk`;
CREATE TABLE `dsj_fzdyqk` (
  `FZDYQKBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LBMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SL` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`FZDYQKBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_fzdyqk 数据已清理，仅保留表结构

-- 表结构: dsj_ndkpjg
DROP TABLE IF EXISTS `dsj_ndkpjg`;
CREATE TABLE `dsj_ndkpjg` (
  `NDKPJGBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ND` decimal(8,0) DEFAULT NULL,
  `YX` decimal(8,0) DEFAULT NULL,
  `LH` decimal(8,0) DEFAULT NULL,
  `HG` decimal(8,0) DEFAULT NULL,
  `BHG` decimal(8,0) DEFAULT NULL,
  `WCL` decimal(8,0) DEFAULT NULL,
  `JZP` decimal(8,0) DEFAULT NULL,
  `DWCX` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`NDKPJGBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_ndkpjg 数据已清理，仅保留表结构

-- 表结构: dsj_pxpy
DROP TABLE IF EXISTS `dsj_pxpy`;
CREATE TABLE `dsj_pxpy` (
  `PXPYBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ND` decimal(8,0) DEFAULT NULL,
  `XJJCDZZ` decimal(8,0) DEFAULT NULL,
  `YXGCDY` decimal(8,0) DEFAULT NULL,
  `YXDWGZZ` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`PXPYBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 dsj_pxpy 数据已清理，仅保留表结构

-- 表结构: gg_zgjbxx
DROP TABLE IF EXISTS `gg_zgjbxx`;
CREATE TABLE `gg_zgjbxx` (
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XM` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XB` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWBSM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BMBM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GZZH` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SFZH` varchar(54) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JG` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CSD` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MZ` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CSRQ` datetime DEFAULT NULL,
  `HKSZD` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HKXZ` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZZMM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JRDPRQ` datetime DEFAULT NULL,
  `JKQK` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HYZK` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CJGZRQ` datetime DEFAULT NULL,
  `RLGZRQ` datetime DEFAULT NULL,
  `GLJZZ` int DEFAULT NULL,
  `QRZXL` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZWMC` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZWJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XJSZWMC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RYLB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GWSX` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GMJJHYFL` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZZGMJJHYFL` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZJGBLX` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JBFHBS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FYRYBS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `EXRYBS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GBGRBS` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DGBH` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TBFLAG` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL04` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL05` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL06` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL07` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL08` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL09` datetime DEFAULT NULL,
  `YL10` datetime DEFAULT NULL,
  `PROVINCE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XMPY` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PHONE` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MOBILE` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ADDRESS` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XRZWHZ` varchar(1500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GWMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GWPARA` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BCZWHZ` varchar(1500) CHARACTER SET utf16 COLLATE utf16_general_ci DEFAULT NULL,
  `MCZWHZ` varchar(1500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RYSD` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RYSDUSER` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SHZT` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SHR` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SHRQ` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RYSDBM` varchar(300) CHARACTER SET utf16 COLLATE utf16_general_ci DEFAULT NULL,
  KEY `index_gg_zgjbxx_rybm` (`RYBM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='职工基本信息表';

-- 表 gg_zgjbxx 数据已清理，仅保留表结构

-- 表结构: gg_zgzp
DROP TABLE IF EXISTS `gg_zgzp`;
CREATE TABLE `gg_zgzp` (
  `ZGZPBS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RYBM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GRZP` longblob,
  `YL04` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL07` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 gg_zgzp 数据已清理，仅保留表结构

-- 表结构: gxgh_20220519
DROP TABLE IF EXISTS `gxgh_20220519`;
CREATE TABLE `gxgh_20220519` (
  `xm` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `gh` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 表 gxgh_20220519 数据已清理，仅保留表结构

-- 表结构: lz_dwjbxx
DROP TABLE IF EXISTS `lz_dwjbxx`;
CREATE TABLE `lz_dwjbxx` (
  `DWBSM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DWBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FDWBSM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWMC` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWJC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWDZ` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWYB` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GMJJFL` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZZGMJJHYFL` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWLX` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWLB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DLJGBZ` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PZCLWH` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PZCLRQ` datetime DEFAULT NULL,
  `HDDYRQ` datetime DEFAULT NULL,
  `SCRY` decimal(65,30) DEFAULT NULL,
  `GCJSRY` decimal(65,30) DEFAULT NULL,
  `GLRY` decimal(65,30) DEFAULT NULL,
  `FWRY` decimal(65,30) DEFAULT NULL,
  `QTRY` decimal(65,30) DEFAULT NULL,
  `BZPZWJ` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZTZRQ` datetime DEFAULT NULL,
  `DWBZS` decimal(65,30) DEFAULT NULL,
  `NSJGS` decimal(65,30) DEFAULT NULL,
  `XZLDZS` decimal(65,30) DEFAULT NULL,
  `DQLDZS` decimal(65,30) DEFAULT NULL,
  `ZYLDJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GLGWSL` decimal(65,30) DEFAULT NULL,
  `JSGWSL` decimal(65,30) DEFAULT NULL,
  `JGTZWJ` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JGTZRQ` datetime DEFAULT NULL,
  `LDZSPZWJ` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LDZSPZRQ` datetime DEFAULT NULL,
  `PXJGLX` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SSXTLX` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TBFLAG` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` decimal(65,30) DEFAULT NULL,
  `YL02` decimal(65,30) DEFAULT NULL,
  `YL03` decimal(65,30) DEFAULT NULL,
  `YL04` decimal(65,30) DEFAULT NULL,
  `YL05` decimal(65,30) DEFAULT NULL,
  `YL06` decimal(65,30) DEFAULT NULL,
  `YL07` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL08` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL09` datetime DEFAULT NULL,
  `YL10` datetime DEFAULT NULL,
  `USERTYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PYCODE` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH01` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH02` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH03` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH04` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH05` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH06` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROVINCE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TJDM` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `VALIDFLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RSTJDM` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JJJG` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BSDW` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LDCXLX` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GJTLFL` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XZRYZS` decimal(10,0) DEFAULT NULL,
  `DQRYZS` decimal(10,0) DEFAULT NULL,
  `ZWDWMC` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_czech_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 lz_dwjbxx 数据已清理，仅保留表结构

-- 表结构: lz_dwxsbmxx
DROP TABLE IF EXISTS `lz_dwxsbmxx`;
CREATE TABLE `lz_dwxsbmxx` (
  `DWXXBMBS` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DWBSM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XSBMBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XSBMMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FBMBM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SFYJBM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BMJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NSJGXZ` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BDSJ` datetime DEFAULT NULL,
  `JGDY` decimal(65,30) DEFAULT NULL,
  `JGBZ` decimal(65,30) DEFAULT NULL,
  `JGLDZS` decimal(65,30) DEFAULT NULL,
  `JGZYLDJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JGGLGWSZ` decimal(65,30) DEFAULT NULL,
  `JGJSGWSZ` decimal(65,30) DEFAULT NULL,
  `ZJGLJGLX` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TBFLAG` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` decimal(65,30) DEFAULT NULL,
  `YL02` decimal(65,30) DEFAULT NULL,
  `YL03` decimal(65,30) DEFAULT NULL,
  `YL04` decimal(65,30) DEFAULT NULL,
  `YL05` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL06` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL07` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL08` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL09` datetime DEFAULT NULL,
  `YL10` datetime DEFAULT NULL,
  `USERTYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PYCODE` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH01` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH02` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH03` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH04` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH05` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YH06` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `VALIDFLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RSTJDM` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 lz_dwxsbmxx 数据已清理，仅保留表结构

-- 表结构: mh_link
DROP TABLE IF EXISTS `mh_link`;
CREATE TABLE `mh_link` (
  `LINKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TITLE` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `URL` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ORDERNO` decimal(8,0) DEFAULT NULL,
  `REMARK` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RECORDSTATUS` decimal(8,0) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MODIFYTIME` datetime DEFAULT NULL,
  `MODIFYUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`LINKID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 mh_link 数据已清理，仅保留表结构

-- 表结构: mh_mhfl
DROP TABLE IF EXISTS `mh_mhfl`;
CREATE TABLE `mh_mhfl` (
  `MHFLBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SJFL` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FLMC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LMURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SFXS` int DEFAULT NULL,
  `PX` decimal(8,0) DEFAULT NULL,
  `BZ` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CJSJ` datetime DEFAULT NULL,
  `JB` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`MHFLBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 mh_mhfl 数据已清理，仅保留表结构

-- 表结构: mh_sylm
DROP TABLE IF EXISTS `mh_sylm`;
CREATE TABLE `mh_sylm` (
  `SYLMBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LMLX` int DEFAULT NULL,
  `LMBT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LMTPDZ` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XQDZ` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZT` int DEFAULT NULL,
  `SX` decimal(8,0) DEFAULT NULL,
  `YL1` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL2` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CJSJ` datetime DEFAULT NULL,
  PRIMARY KEY (`SYLMBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 mh_sylm 数据已清理，仅保留表结构

-- 表结构: pe_againputrecord
DROP TABLE IF EXISTS `pe_againputrecord`;
CREATE TABLE `pe_againputrecord` (
  `AGAINPUTRECORDID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `MEETINGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '相关会议纪要（三会一课）',
  `OPINTION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '党委意见',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `PARTYOPINTIONSTATE` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`AGAINPUTRECORDID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_againputrecord 数据已清理，仅保留表结构

-- 表结构: pe_branchreview
DROP TABLE IF EXISTS `pe_branchreview`;
CREATE TABLE `pe_branchreview` (
  `BRANCHREVIEWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `MEETINGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '相关会议纪要（三会一课）',
  `OPINTION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '小组意见',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`BRANCHREVIEWID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_branchreview 数据已清理，仅保留表结构

-- 表结构: pe_branchtalk
DROP TABLE IF EXISTS `pe_branchtalk`;
CREATE TABLE `pe_branchtalk` (
  `BRANCHTALKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `MEETINGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '相关会议纪要（三会一课）',
  `MEETINGTIME` datetime DEFAULT NULL COMMENT '支部大会时间',
  `PUBLICTIME` datetime DEFAULT NULL COMMENT '公示时间',
  `GROUPOPINTION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '党小组意见',
  `DECISIONCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '预备党员支部大会决议',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`BRANCHTALKID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_branchtalk 数据已清理，仅保留表结构

-- 表结构: pe_brdzb
DROP TABLE IF EXISTS `pe_brdzb`;
CREATE TABLE `pe_brdzb` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COMPILETIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `DZZMC` varchar(136) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_brdzb 数据已清理，仅保留表结构

-- 表结构: pe_confirmsponsor
DROP TABLE IF EXISTS `pe_confirmsponsor`;
CREATE TABLE `pe_confirmsponsor` (
  `CONFIRMSPONSORID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`CONFIRMSPONSORID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_confirmsponsor 数据已清理，仅保留表结构

-- 表结构: pe_confirmsponsor_user
DROP TABLE IF EXISTS `pe_confirmsponsor_user`;
CREATE TABLE `pe_confirmsponsor_user` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CONFIRMSPONSORID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '确定入党介绍人id',
  `USERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '介绍人姓名',
  `USERCODE` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '介绍人编码',
  `POSITION` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务',
  `JOINTIME` datetime DEFAULT NULL COMMENT '入党时间',
  `ISLINECLAN` decimal(8,0) DEFAULT NULL COMMENT '是否直属亲属 1是，0否',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_confirmsponsor_user 数据已清理，仅保留表结构

-- 表结构: pe_confirmuser
DROP TABLE IF EXISTS `pe_confirmuser`;
CREATE TABLE `pe_confirmuser` (
  `CONFIRMUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `CONFIRMTIME` datetime DEFAULT NULL COMMENT '确定发展对象时间',
  `PUBLICTIME` datetime DEFAULT NULL COMMENT '公示时间',
  `MEETINGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '相关会议记录（三会一课）',
  `GRADE` decimal(8,2) DEFAULT NULL COMMENT '成绩',
  `COMPREHENSIVEGRADE` decimal(8,2) DEFAULT NULL COMMENT '综合成绩',
  `GRADETIME` datetime DEFAULT NULL COMMENT '时间',
  `TRAINOPINION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '培养联系人意见',
  `GROUPOPINION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '党小组意见',
  `PARTYUSEROPINION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '党员意见',
  `MASSESOPINION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '群众意见',
  `BRANCHOPINION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '党支部意见',
  `DECISIONCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '确定发展对象决议',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`CONFIRMUSERID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_confirmuser 数据已清理，仅保留表结构

-- 表结构: pe_flow
DROP TABLE IF EXISTS `pe_flow`;
CREATE TABLE `pe_flow` (
  `FLOWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FLOWNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PARENTID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SORT` decimal(8,0) DEFAULT NULL,
  `URL` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `WARNUPFLOWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `WARNDAYS` decimal(8,0) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `GUIDELINES` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `APPGUIDELINES` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`FLOWID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_flow 数据已清理，仅保留表结构

-- 表结构: pe_joinapply
DROP TABLE IF EXISTS `pe_joinapply`;
CREATE TABLE `pe_joinapply` (
  `APPLYID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOINTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `MEMO` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`APPLYID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_joinapply 数据已清理，仅保留表结构

-- 表结构: pe_joinapply_relation
DROP TABLE IF EXISTS `pe_joinapply_relation`;
CREATE TABLE `pe_joinapply_relation` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLYID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RELATION` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `WORKDESC` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `POLITICAL` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_joinapply_relation 数据已清理，仅保留表结构

-- 表结构: pe_joinapply_resume
DROP TABLE IF EXISTS `pe_joinapply_resume`;
CREATE TABLE `pe_joinapply_resume` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `APPLYID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BEGINTIME` datetime DEFAULT NULL,
  `ENDTIME` datetime DEFAULT NULL,
  `WORKDESC` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROVEUSER` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_joinapply_resume 数据已清理，仅保留表结构

-- 表结构: pe_joinbook
DROP TABLE IF EXISTS `pe_joinbook`;
CREATE TABLE `pe_joinbook` (
  `JOINBOOKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `SENDTIME` datetime DEFAULT NULL COMMENT '发放入党志愿书时间',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`JOINBOOKID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_joinbook 数据已清理，仅保留表结构

-- 表结构: pe_joinuser
DROP TABLE IF EXISTS `pe_joinuser`;
CREATE TABLE `pe_joinuser` (
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GENDER` decimal(8,0) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `NATIONALITY` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NATIVEPLACE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `EDUCATION` decimal(8,0) DEFAULT NULL,
  `POSITION` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `IDCARD` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOINGROUPTIME` datetime DEFAULT NULL,
  `MOBILE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOINSTATE` decimal(8,0) DEFAULT NULL COMMENT '0：未完成，1：已完成',
  `MEMO` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `USERCODE` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员编码',
  PRIMARY KEY (`JOINUSERID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_joinuser 数据已清理，仅保留表结构

-- 表结构: pe_joinuser_flow
DROP TABLE IF EXISTS `pe_joinuser_flow`;
CREATE TABLE `pe_joinuser_flow` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FLOWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ACCOMPLISHTIME` datetime DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_joinuser_flow 数据已清理，仅保留表结构

-- 表结构: pe_jxjykc
DROP TABLE IF EXISTS `pe_jxjykc`;
CREATE TABLE `pe_jxjykc` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `PERIODCONTENT` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `INSPECTCONTENT` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_jxjykc 数据已清理，仅保留表结构

-- 表结构: pe_jxjykcqk
DROP TABLE IF EXISTS `pe_jxjykcqk`;
CREATE TABLE `pe_jxjykcqk` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `KCID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YEARS` decimal(8,0) DEFAULT NULL,
  `QUARTER` decimal(8,0) DEFAULT NULL,
  `PRACTICECONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `TALKCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ACTIVITYCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `REPORTCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `APPRAISALCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_jxjykcqk 数据已清理，仅保留表结构

-- 表结构: pe_partyreview
DROP TABLE IF EXISTS `pe_partyreview`;
CREATE TABLE `pe_partyreview` (
  `PARTYREVIEWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `BEGINTIME` datetime DEFAULT NULL COMMENT '预审开始时间',
  `ENDTIME` datetime DEFAULT NULL COMMENT '预审结束时间',
  `REVIEWOPINTION` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '预审意见',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`PARTYREVIEWID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_partyreview 数据已清理，仅保留表结构

-- 表结构: pe_politicalreview
DROP TABLE IF EXISTS `pe_politicalreview`;
CREATE TABLE `pe_politicalreview` (
  `POLITICALREVIEWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`POLITICALREVIEWID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_politicalreview 数据已清理，仅保留表结构

-- 表结构: pe_putrecord
DROP TABLE IF EXISTS `pe_putrecord`;
CREATE TABLE `pe_putrecord` (
  `PUTRECORDID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HASPRECEDURE` decimal(8,0) DEFAULT NULL COMMENT '1是，0否',
  `BRANCHAUDITTIME` datetime DEFAULT NULL,
  `PARTYAUDITTIME` datetime DEFAULT NULL,
  `AUDITRESULT` decimal(8,0) DEFAULT NULL COMMENT '1是，0否',
  `PROGRESSTIME` datetime DEFAULT NULL,
  `MEMO` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`PUTRECORDID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_putrecord 数据已清理，仅保留表结构

-- 表结构: pe_rdxs
DROP TABLE IF EXISTS `pe_rdxs`;
CREATE TABLE `pe_rdxs` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SWEARTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `SWEARLOCATION` varchar(336) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_rdxs 数据已清理，仅保留表结构

-- 表结构: pe_recommend
DROP TABLE IF EXISTS `pe_recommend`;
CREATE TABLE `pe_recommend` (
  `RECOMMENDID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RECOMMENDTYPE` decimal(8,0) DEFAULT NULL COMMENT '1党员推荐，2群团推荐',
  `MEETINGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党员推荐关联党员大会，群团推荐关联支委会或党员大会',
  `JOINGROUPTIME` datetime DEFAULT NULL,
  `CONFIRMTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `SHOWCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `OPINIONCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DECISIONCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`RECOMMENDID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_recommend 数据已清理，仅保留表结构

-- 表结构: pe_sjdwsp
DROP TABLE IF EXISTS `pe_sjdwsp`;
CREATE TABLE `pe_sjdwsp` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `APPROVETIME` datetime DEFAULT NULL,
  `ISDECLARE` int DEFAULT NULL,
  `ISTALK` int DEFAULT NULL,
  `APPRESULT` int DEFAULT NULL,
  `MEETINGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_sjdwsp 数据已清理，仅保留表结构

-- 表结构: pe_sjprth
DROP TABLE IF EXISTS `pe_sjprth`;
CREATE TABLE `pe_sjprth` (
  `SJPRTHID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TALKTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`SJPRTHID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_sjprth 数据已清理，仅保留表结构

-- 表结构: pe_sjprthmx
DROP TABLE IF EXISTS `pe_sjprthmx`;
CREATE TABLE `pe_sjprthmx` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SJPRTHID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `POSITION` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JOINTIME` datetime DEFAULT NULL,
  `ISCLAN` int DEFAULT NULL,
  `MEMO` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_sjprthmx 数据已清理，仅保留表结构

-- 表结构: pe_superiorapp
DROP TABLE IF EXISTS `pe_superiorapp`;
CREATE TABLE `pe_superiorapp` (
  `TALKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `APPTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `APPRESULT` int DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`TALKID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_superiorapp 数据已清理，仅保留表结构

-- 表结构: pe_superiortalk
DROP TABLE IF EXISTS `pe_superiortalk`;
CREATE TABLE `pe_superiortalk` (
  `TALKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TALKTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `TALKCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `REPORTCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`TALKID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_superiortalk 数据已清理，仅保留表结构

-- 表结构: pe_superiortalk_user
DROP TABLE IF EXISTS `pe_superiortalk_user`;
CREATE TABLE `pe_superiortalk_user` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TALKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `POSITION` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_superiortalk_user 数据已清理，仅保留表结构

-- 表结构: pe_talk
DROP TABLE IF EXISTS `pe_talk`;
CREATE TABLE `pe_talk` (
  `TALKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TALKTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `TALKCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `REPORTCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`TALKID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_talk 数据已清理，仅保留表结构

-- 表结构: pe_talk_user
DROP TABLE IF EXISTS `pe_talk_user`;
CREATE TABLE `pe_talk_user` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TALKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERCODE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `POSITION` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_talk_user 数据已清理，仅保留表结构

-- 表结构: pe_tczzsq
DROP TABLE IF EXISTS `pe_tczzsq`;
CREATE TABLE `pe_tczzsq` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `BECOMETIME` datetime DEFAULT NULL,
  `PERIODCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_tczzsq 数据已清理，仅保留表结构

-- 表结构: pe_training
DROP TABLE IF EXISTS `pe_training`;
CREATE TABLE `pe_training` (
  `TRAININGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请人id',
  `PROGRESSTIME` datetime DEFAULT NULL COMMENT '进度完成时间',
  `TRAININGTIME` datetime DEFAULT NULL COMMENT '培训时间',
  `TRAININGRESULT` decimal(8,0) DEFAULT NULL COMMENT '培训结果，字典配置：trainingResult',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`TRAININGID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_training 数据已清理，仅保留表结构

-- 表结构: pe_traininspect
DROP TABLE IF EXISTS `pe_traininspect`;
CREATE TABLE `pe_traininspect` (
  `TRAININSPECTID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`TRAININSPECTID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_traininspect 数据已清理，仅保留表结构

-- 表结构: pe_traininspect_record
DROP TABLE IF EXISTS `pe_traininspect_record`;
CREATE TABLE `pe_traininspect_record` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TRAININSPECTID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YEARS` decimal(8,0) DEFAULT NULL,
  `QUARTER` decimal(8,0) DEFAULT NULL,
  `PRACTICECONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `TALKCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ACTIVITYCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `REPORTCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_traininspect_record 数据已清理，仅保留表结构

-- 表结构: pe_trainuser
DROP TABLE IF EXISTS `pe_trainuser`;
CREATE TABLE `pe_trainuser` (
  `TRAINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`TRAINUSERID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_trainuser 数据已清理，仅保留表结构

-- 表结构: pe_trainuser_detail
DROP TABLE IF EXISTS `pe_trainuser_detail`;
CREATE TABLE `pe_trainuser_detail` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TRAINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `USERCODE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `POSITION` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `JOINTIME` datetime DEFAULT NULL,
  `MEMO` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_trainuser_detail 数据已清理，仅保留表结构

-- 表结构: pe_wordtemplate
DROP TABLE IF EXISTS `pe_wordtemplate`;
CREATE TABLE `pe_wordtemplate` (
  `WORDTEMPLATEID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `FLOWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '环节配置ID',
  `TITLE` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标题',
  `TEMPLATE` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '内容',
  `SORT` decimal(8,0) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`WORDTEMPLATEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_wordtemplate 数据已清理，仅保留表结构

-- 表结构: pe_zbdhtl
DROP TABLE IF EXISTS `pe_zbdhtl`;
CREATE TABLE `pe_zbdhtl` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `DISCUSSTIME` datetime DEFAULT NULL,
  `MEETINGNAME` varchar(236) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MEETINGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_zbdhtl 数据已清理，仅保留表结构

-- 表结构: pe_zlgd
DROP TABLE IF EXISTS `pe_zlgd`;
CREATE TABLE `pe_zlgd` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `ARCHIVETIME` datetime DEFAULT NULL,
  `ARCHIVEUSER` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_zlgd 数据已清理，仅保留表结构

-- 表结构: pe_zzbmba
DROP TABLE IF EXISTS `pe_zzbmba`;
CREATE TABLE `pe_zzbmba` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JOINUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ICPTIME` datetime DEFAULT NULL,
  `PROGRESSTIME` datetime DEFAULT NULL,
  `ICPCONTENT` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pe_zzbmba 数据已清理，仅保留表结构

-- 表结构: pub_dzzfc
DROP TABLE IF EXISTS `pub_dzzfc`;
CREATE TABLE `pub_dzzfc` (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `dzzdm` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所在组织',
  `ztmc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主题名称',
  `fc_type` int DEFAULT NULL COMMENT '类型',
  `jj` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '简介',
  `nr` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `sj` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '时间',
  `lj` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '链接',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_userid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_userid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='党组织风采';

-- 表 pub_dzzfc 数据已清理，仅保留表结构

-- 表结构: pub_publicityposition
DROP TABLE IF EXISTS `pub_publicityposition`;
CREATE TABLE `pub_publicityposition` (
  `PUBLICITYPOSITIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `POSITIONNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '阵地名称',
  `PARTYNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部代码',
  `POSITIONTYPE` decimal(8,0) DEFAULT NULL COMMENT '阵地类别',
  `POSITIONLEVEL` decimal(8,0) DEFAULT NULL COMMENT '等级',
  `POSITIONCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '编号',
  `ADDRESS` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '位置',
  `SIZES` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '尺寸',
  `BUILDTIME` datetime DEFAULT NULL COMMENT '建设时间',
  `HEADUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '责任人',
  `POSITIONSTATE` decimal(8,0) DEFAULT NULL COMMENT '状态',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `PANELCYCLE` decimal(8,0) DEFAULT NULL COMMENT '更新周期',
  PRIMARY KEY (`PUBLICITYPOSITIONID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pub_publicityposition 数据已清理，仅保留表结构

-- 表结构: pub_publicityposition_panel
DROP TABLE IF EXISTS `pub_publicityposition_panel`;
CREATE TABLE `pub_publicityposition_panel` (
  `PANELID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `PUBLICITYPOSITIONID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '宣传阵地id',
  `TITLE` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '宣传标语',
  `REMARK` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '宣传备注',
  `PANELTIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PANELCYCLE` decimal(8,0) DEFAULT NULL COMMENT '更新周期',
  `PANELIMG` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '宣传图片',
  `PANELSTATE` decimal(8,0) DEFAULT NULL COMMENT '审核状态',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`PANELID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 pub_publicityposition_panel 数据已清理，仅保留表结构

-- 表结构: rs_ryjbxx
DROP TABLE IF EXISTS `rs_ryjbxx`;
CREATE TABLE `rs_ryjbxx` (
  `RYJBXXBS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RYBM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SZDZBDM` varchar(68) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWBM` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BMBM` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XM` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XB` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CSRQ` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JG` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MZ` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XWHCD` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZWMC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZWJB` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XJSZWMC` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CJGZRQ` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`RYJBXXBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 rs_ryjbxx 数据已清理，仅保留表结构

-- 表结构: rs_ryjbxxfb
DROP TABLE IF EXISTS `rs_ryjbxxfb`;
CREATE TABLE `rs_ryjbxxfb` (
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `SFZG` decimal(8,0) DEFAULT NULL COMMENT '是否在岗',
  `BZGYY` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '不在岗原因',
  `SFSLDRY` decimal(8,0) DEFAULT NULL COMMENT '是否属领导人员',
  `LDRYLXDBM` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '领导人员联系点组织编码',
  `LDRYLXDMC` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '领导人员联系点组织名称',
  `NL` decimal(8,0) DEFAULT NULL COMMENT '年龄',
  `LEADTYPE` decimal(8,0) DEFAULT NULL,
  `APPLYDATE` date DEFAULT NULL,
  `ACTIVEDATE` date DEFAULT NULL,
  `PASSDATE` date DEFAULT NULL,
  `ISARCHIVE` int DEFAULT NULL,
  `gradeName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '年级',
  `className` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '班级',
  `enrollmentDate` date DEFAULT NULL COMMENT '入学日期',
  `graduateDate` date DEFAULT NULL COMMENT '毕业日期',
  `workDate` date DEFAULT NULL COMMENT '工作时间',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系电话',
  `technologyPosition` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '技术职务',
  `trainUser1` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `trainUser2` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `isStudent` bit(1) DEFAULT NULL COMMENT '是否学生党员',
  `exportDate` date DEFAULT NULL COMMENT '转出日期',
  `exportPartyName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '转出单位',
  `applyApproveStatus` int DEFAULT NULL COMMENT '入党申请审核状态',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '入党申请填写密码',
  `applyFileReId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '入党申请附件关联id',
  `partyDuesStartMonth` int DEFAULT NULL COMMENT '党费起缴年月',
  `archiveDate` date DEFAULT NULL COMMENT '归档日期',
  PRIMARY KEY (`RYBM`) USING BTREE,
  KEY `index_rs_ryjbxxfb_rybm` (`RYBM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='党员信息表';

-- 表 rs_ryjbxxfb 数据已清理，仅保留表结构

-- 表结构: tg_fqtg
DROP TABLE IF EXISTS `tg_fqtg`;
CREATE TABLE `tg_fqtg` (
  `FQTGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YGQKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TITLE` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TOPICVALUE` int DEFAULT NULL,
  `AUTHOR` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `POST` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `NEWSID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PHOTOID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `STATUS` int DEFAULT NULL,
  `YEAR` int DEFAULT NULL,
  `NUM` int DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`FQTGID`) USING BTREE,
  KEY `FK_YG_FQTG_REFERENCE_TG_YGQK` (`YGQKID`) USING BTREE,
  CONSTRAINT `FK_YG_FQTG_REFERENCE_TG_YGQK` FOREIGN KEY (`YGQKID`) REFERENCES `tg_ygqk` (`YGQKID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 tg_fqtg 数据已清理，仅保留表结构

-- 表结构: tg_jsdw
DROP TABLE IF EXISTS `tg_jsdw`;
CREATE TABLE `tg_jsdw` (
  `JSDWID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LEADER` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZGTGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `STATUS` int DEFAULT NULL,
  `RECEIVETIME` datetime DEFAULT NULL,
  `ISSEND` int DEFAULT NULL,
  PRIMARY KEY (`JSDWID`) USING BTREE,
  KEY `FK_TG_JSDW_REFERENCE_TG_ZGTG` (`ZGTGID`) USING BTREE,
  CONSTRAINT `FK_TG_JSDW_REFERENCE_TG_ZGTG` FOREIGN KEY (`ZGTGID`) REFERENCES `tg_zgtg` (`ZGTGID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 tg_jsdw 数据已清理，仅保留表结构

-- 表结构: tg_ygqk
DROP TABLE IF EXISTS `tg_ygqk`;
CREATE TABLE `tg_ygqk` (
  `YGQKID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ZGTGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TITLE` varchar(366) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BEGINDATE` datetime DEFAULT NULL,
  `ENDDATE` datetime DEFAULT NULL,
  `STATUS` int DEFAULT NULL,
  PRIMARY KEY (`YGQKID`) USING BTREE,
  KEY `FK_TG_YGQK_REFERENCE_TG_ZGTG` (`ZGTGID`) USING BTREE,
  CONSTRAINT `FK_TG_YGQK_REFERENCE_TG_ZGTG` FOREIGN KEY (`ZGTGID`) REFERENCES `tg_zgtg` (`ZGTGID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 tg_ygqk 数据已清理，仅保留表结构

-- 表结构: tg_zgtg
DROP TABLE IF EXISTS `tg_zgtg`;
CREATE TABLE `tg_zgtg` (
  `ZGTGID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TITLE` varchar(366) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CLOSEDATE` datetime DEFAULT NULL,
  `TYPEVALUE` int DEFAULT NULL,
  `ASK` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `STATUS` decimal(8,0) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ZGTGID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 tg_zgtg 数据已清理，仅保留表结构

-- 表结构: us_party_month
DROP TABLE IF EXISTS `us_party_month`;
CREATE TABLE `us_party_month` (
  `yearMonth` int NOT NULL,
  `userCode` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `partyCode` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`yearMonth`,`userCode`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_party_month 数据已清理，仅保留表结构

-- 表结构: us_partydues
DROP TABLE IF EXISTS `us_partydues`;
CREATE TABLE `us_partydues` (
  `PARTYDUESID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `YEAR` decimal(8,0) DEFAULT NULL COMMENT '年度',
  `USERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '成员姓名',
  `USERCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '成员编号',
  `PARTYNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织编码',
  `BASENUMBER` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '缴纳基数',
  `MONEY` decimal(8,2) DEFAULT NULL COMMENT '缴纳金额',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`PARTYDUESID`) USING BTREE,
  KEY `INDEX_YEAR` (`YEAR`) USING BTREE,
  KEY `index_us_partydues_year` (`YEAR`) USING BTREE,
  KEY `index_us_partydues_usercode` (`USERCODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_partydues 数据已清理，仅保留表结构

-- 表结构: us_partydues_detail
DROP TABLE IF EXISTS `us_partydues_detail`;
CREATE TABLE `us_partydues_detail` (
  `DETAILID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `PARTYDUESID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党费收缴Id',
  `MONTH` decimal(8,0) DEFAULT NULL COMMENT '月份',
  `BASENUMBER` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '缴纳基数',
  `MONEY` decimal(8,2) DEFAULT NULL COMMENT '缴纳金额',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `REMARKS` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SPECIALEXPENSES` decimal(8,2) DEFAULT NULL,
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属党组织',
  `payState` int DEFAULT NULL COMMENT '????×???',
  PRIMARY KEY (`DETAILID`) USING BTREE,
  KEY `FK_US_PARTYDUES_DETAIL_PARTYDUES` (`PARTYDUESID`) USING BTREE,
  KEY `index_us_partydues_detail_month` (`MONTH`) USING BTREE,
  KEY `index_us_partydues_detail_union_column` (`PARTYDUESID`,`MONTH`,`payState`) USING BTREE,
  CONSTRAINT `FK_US_PARTYDUES_DETAIL_PARTYDUES` FOREIGN KEY (`PARTYDUESID`) REFERENCES `us_partydues` (`PARTYDUESID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_partydues_detail 数据已清理，仅保留表结构

-- 表结构: us_partyhelp
DROP TABLE IF EXISTS `us_partyhelp`;
CREATE TABLE `us_partyhelp` (
  `partyHelpID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userCode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `year` int DEFAULT NULL,
  `helpReason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `approveUserID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `approveTime` datetime DEFAULT NULL,
  `recordStatus` int DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `createUserName` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updateUserName` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`partyHelpID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_partyhelp 数据已清理，仅保留表结构

-- 表结构: us_partyoutlay
DROP TABLE IF EXISTS `us_partyoutlay`;
CREATE TABLE `us_partyoutlay` (
  `PARTYOUTLAYID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部代码',
  `USETIME` datetime DEFAULT NULL COMMENT '使用时间',
  `REASON` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '事由',
  `MONEY` int DEFAULT NULL COMMENT '金额',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `PAYTYPE` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`PARTYOUTLAYID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_partyoutlay 数据已清理，仅保留表结构

-- 表结构: us_usercontactpoint
DROP TABLE IF EXISTS `us_usercontactpoint`;
CREATE TABLE `us_usercontactpoint` (
  `ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员编码',
  `DZZDM` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系点党组织编码',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_usercontactpoint 数据已清理，仅保留表结构

-- 表结构: us_userleader
DROP TABLE IF EXISTS `us_userleader`;
CREATE TABLE `us_userleader` (
  `USERLEADERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `USERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `USERCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员编码',
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部代码',
  `LEADERTIME` datetime DEFAULT NULL COMMENT '时间',
  `ADDRESS` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地点',
  `LEADERTYPE` decimal(8,0) DEFAULT NULL COMMENT '类别',
  `POSITION` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务',
  `CONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '内容',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`USERLEADERID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_userleader 数据已清理，仅保留表结构

-- 表结构: us_userleader_detail
DROP TABLE IF EXISTS `us_userleader_detail`;
CREATE TABLE `us_userleader_detail` (
  `DETAILID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `USERLEADERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '外键ID',
  `USERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `USERCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员编码',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人姓名',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人姓名',
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`DETAILID`) USING BTREE,
  KEY `FK_US_USERL_REFERENCE_US_USERL` (`USERLEADERID`) USING BTREE,
  CONSTRAINT `FK_US_USERL_REFERENCE_US_USERL` FOREIGN KEY (`USERLEADERID`) REFERENCES `us_userleader` (`USERLEADERID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_userleader_detail 数据已清理，仅保留表结构

-- 表结构: us_userthought
DROP TABLE IF EXISTS `us_userthought`;
CREATE TABLE `us_userthought` (
  `USERTHOUGHTID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `USERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职工姓名',
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部代码',
  `THOUGHTTYPE` decimal(8,0) DEFAULT NULL COMMENT '类别',
  `QUESTIONTYPE` decimal(8,0) DEFAULT NULL COMMENT '问题类型',
  `FINDTIME` datetime DEFAULT NULL COMMENT '发现时间',
  `ACCEPTUSER` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '受理人',
  `QUESTION` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '反馈问题',
  `HANDLETYPE` decimal(8,0) DEFAULT NULL COMMENT '处理情况',
  `DESTROYTYPE` decimal(8,0) DEFAULT NULL COMMENT '销号情况',
  `DESTROYTIME` datetime DEFAULT NULL COMMENT '销号日期',
  `HANDLESTATE` decimal(8,0) DEFAULT NULL COMMENT '状态',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  `HANDLECONTENT` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '处理情况内容',
  PRIMARY KEY (`USERTHOUGHTID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_userthought 数据已清理，仅保留表结构

-- 表结构: us_userthoughttotal
DROP TABLE IF EXISTS `us_userthoughttotal`;
CREATE TABLE `us_userthoughttotal` (
  `USERTHOUGHTTOTALID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `MONTH` decimal(8,0) DEFAULT NULL COMMENT '月度',
  `PARTYNAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部名称',
  `PARTYCODE` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属支部代码',
  `WRITEUSER` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '填报人',
  `APPROVEUSER` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '审核人',
  `WRITETIME` datetime DEFAULT NULL COMMENT '填报时间',
  `TOTALCONTENT` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '统计表',
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CREATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATEUSERID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UPDATEUSERNAME` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `OPERATETIME` datetime DEFAULT NULL COMMENT '操作时间：同步数据使用，每次改动更新。',
  `OPERATESTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作标识：A：新增，M：修改，D：删除。',
  `SYNCSTATE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '同步标识：Y：已同步，N:未同步。（有修改数据需要同步，则设置为N。Y是作业同步后由作业修改回Y）',
  PRIMARY KEY (`USERTHOUGHTTOTALID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 us_userthoughttotal 数据已清理，仅保留表结构

-- 表结构: ys_hdbz
DROP TABLE IF EXISTS `ys_hdbz`;
CREATE TABLE `ys_hdbz` (
  `HDBZID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ND` decimal(8,0) DEFAULT NULL,
  `CJSJ` datetime DEFAULT NULL,
  `CJR` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HDBZ` decimal(8,0) DEFAULT NULL,
  `V1` decimal(8,0) DEFAULT NULL,
  `V2` decimal(8,0) DEFAULT NULL,
  `V3` decimal(8,0) DEFAULT NULL,
  `V4` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`HDBZID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 ys_hdbz 数据已清理，仅保留表结构

-- 表结构: ys_jfys
DROP TABLE IF EXISTS `ys_jfys`;
CREATE TABLE `ys_jfys` (
  `JFYSID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ND` decimal(8,0) DEFAULT NULL,
  `YSBMC` varchar(136) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CJSJ` datetime DEFAULT NULL,
  `CJR` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`JFYSID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 ys_jfys 数据已清理，仅保留表结构

-- 表结构: ys_jfysmx
DROP TABLE IF EXISTS `ys_jfysmx`;
CREATE TABLE `ys_jfysmx` (
  `YSMXID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `JFYSID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `V1SL` decimal(8,0) DEFAULT NULL,
  `V2SL` decimal(8,0) DEFAULT NULL,
  `V3SL` decimal(8,0) DEFAULT NULL,
  `V4SL` decimal(8,0) DEFAULT NULL,
  `DZBJFXJ` decimal(8,0) DEFAULT NULL,
  `V1HDBZ` int DEFAULT NULL,
  `V2HDBZ` int DEFAULT NULL,
  `V3HDBZ` int DEFAULT NULL,
  `V4HDBZ` int DEFAULT NULL,
  `ZGDYRS` decimal(8,0) DEFAULT NULL,
  `HDBZ` decimal(8,0) DEFAULT NULL,
  `XTYSZE` int DEFAULT NULL,
  `SJYSZE` int DEFAULT NULL,
  PRIMARY KEY (`YSMXID`) USING BTREE,
  KEY `FK_YS_JFYSM_REFERENCE_YS_JFYS` (`JFYSID`) USING BTREE,
  CONSTRAINT `FK_YS_JFYSM_REFERENCE_YS_JFYS` FOREIGN KEY (`JFYSID`) REFERENCES `ys_jfys` (`JFYSID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 ys_jfysmx 数据已清理，仅保留表结构

-- 表结构: zd_82bs
DROP TABLE IF EXISTS `zd_82bs`;
CREATE TABLE `zd_82bs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(3,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_82bs 数据已清理，仅保留表结构

-- 表结构: zd_azfs
DROP TABLE IF EXISTS `zd_azfs`;
CREATE TABLE `zd_azfs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_azfs 数据已清理，仅保留表结构

-- 表结构: zd_bbgwdm
DROP TABLE IF EXISTS `zd_bbgwdm`;
CREATE TABLE `zd_bbgwdm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bbgwdm 数据已清理，仅保留表结构

-- 表结构: zd_bdcfmc
DROP TABLE IF EXISTS `zd_bdcfmc`;
CREATE TABLE `zd_bdcfmc` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bdcfmc 数据已清理，仅保留表结构

-- 表结构: zd_bddwmc
DROP TABLE IF EXISTS `zd_bddwmc`;
CREATE TABLE `zd_bddwmc` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bddwmc 数据已清理，仅保留表结构

-- 表结构: zd_bdjkqk
DROP TABLE IF EXISTS `zd_bdjkqk`;
CREATE TABLE `zd_bdjkqk` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(3,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bdjkqk 数据已清理，仅保留表结构

-- 表结构: zd_bdjlmc
DROP TABLE IF EXISTS `zd_bdjlmc`;
CREATE TABLE `zd_bdjlmc` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bdjlmc 数据已清理，仅保留表结构

-- 表结构: zd_bdjxwzj
DROP TABLE IF EXISTS `zd_bdjxwzj`;
CREATE TABLE `zd_bdjxwzj` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bdjxwzj 数据已清理，仅保留表结构

-- 表结构: zd_bdzwdj
DROP TABLE IF EXISTS `zd_bdzwdj`;
CREATE TABLE `zd_bdzwdj` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bdzwdj 数据已清理，仅保留表结构

-- 表结构: zd_bysddw
DROP TABLE IF EXISTS `zd_bysddw`;
CREATE TABLE `zd_bysddw` (
  `DWMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LJM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWBM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWBSM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bysddw 数据已清理，仅保留表结构

-- 表结构: zd_byszy
DROP TABLE IF EXISTS `zd_byszy`;
CREATE TABLE `zd_byszy` (
  `BM` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_byszy 数据已清理，仅保留表结构

-- 表结构: zd_byszylb
DROP TABLE IF EXISTS `zd_byszylb`;
CREATE TABLE `zd_byszylb` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_byszylb 数据已清理，仅保留表结构

-- 表结构: zd_bzcfmc
DROP TABLE IF EXISTS `zd_bzcfmc`;
CREATE TABLE `zd_bzcfmc` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bzcfmc 数据已清理，仅保留表结构

-- 表结构: zd_bzcfyy
DROP TABLE IF EXISTS `zd_bzcfyy`;
CREATE TABLE `zd_bzcfyy` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bzcfyy 数据已清理，仅保留表结构

-- 表结构: zd_bzzjly
DROP TABLE IF EXISTS `zd_bzzjly`;
CREATE TABLE `zd_bzzjly` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bzzjly 数据已清理，仅保留表结构

-- 表结构: zd_bzzlx
DROP TABLE IF EXISTS `zd_bzzlx`;
CREATE TABLE `zd_bzzlx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_bzzlx 数据已清理，仅保留表结构

-- 表结构: zd_cbdw
DROP TABLE IF EXISTS `zd_cbdw`;
CREATE TABLE `zd_cbdw` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cbdw 数据已清理，仅保留表结构

-- 表结构: zd_cbqk
DROP TABLE IF EXISTS `zd_cbqk`;
CREATE TABLE `zd_cbqk` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cbqk 数据已清理，仅保留表结构

-- 表结构: zd_cflx
DROP TABLE IF EXISTS `zd_cflx`;
CREATE TABLE `zd_cflx` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cflx 数据已清理，仅保留表结构

-- 表结构: zd_cgjlb
DROP TABLE IF EXISTS `zd_cgjlb`;
CREATE TABLE `zd_cgjlb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cgjlb 数据已清理，仅保留表结构

-- 表结构: zd_cglbdm
DROP TABLE IF EXISTS `zd_cglbdm`;
CREATE TABLE `zd_cglbdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(2,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cglbdm 数据已清理，仅保留表结构

-- 表结构: zd_cgqdbm
DROP TABLE IF EXISTS `zd_cgqdbm`;
CREATE TABLE `zd_cgqdbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cgqdbm 数据已清理，仅保留表结构

-- 表结构: zd_cgsfdm
DROP TABLE IF EXISTS `zd_cgsfdm`;
CREATE TABLE `zd_cgsfdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cgsfdm 数据已清理，仅保留表结构

-- 表结构: zd_cjdzzhdqk
DROP TABLE IF EXISTS `zd_cjdzzhdqk`;
CREATE TABLE `zd_cjdzzhdqk` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cjdzzhdqk 数据已清理，仅保留表结构

-- 表结构: zd_classcontent
DROP TABLE IF EXISTS `zd_classcontent`;
CREATE TABLE `zd_classcontent` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_classcontent 数据已清理，仅保留表结构

-- 表结构: zd_classperson
DROP TABLE IF EXISTS `zd_classperson`;
CREATE TABLE `zd_classperson` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_classperson 数据已清理，仅保留表结构

-- 表结构: zd_classprop
DROP TABLE IF EXISTS `zd_classprop`;
CREATE TABLE `zd_classprop` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_classprop 数据已清理，仅保留表结构

-- 表结构: zd_classstudy
DROP TABLE IF EXISTS `zd_classstudy`;
CREATE TABLE `zd_classstudy` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_classstudy 数据已清理，仅保留表结构

-- 表结构: zd_classtype
DROP TABLE IF EXISTS `zd_classtype`;
CREATE TABLE `zd_classtype` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_classtype 数据已清理，仅保留表结构

-- 表结构: zd_cltzqx
DROP TABLE IF EXISTS `zd_cltzqx`;
CREATE TABLE `zd_cltzqx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_cltzqx 数据已清理，仅保留表结构

-- 表结构: zd_csxgwbdlx
DROP TABLE IF EXISTS `zd_csxgwbdlx`;
CREATE TABLE `zd_csxgwbdlx` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_csxgwbdlx 数据已清理，仅保留表结构

-- 表结构: zd_dalb
DROP TABLE IF EXISTS `zd_dalb`;
CREATE TABLE `zd_dalb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dalb 数据已清理，仅保留表结构

-- 表结构: zd_dalbm
DROP TABLE IF EXISTS `zd_dalbm`;
CREATE TABLE `zd_dalbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dalbm 数据已清理，仅保留表结构

-- 表结构: zd_dlh
DROP TABLE IF EXISTS `zd_dlh`;
CREATE TABLE `zd_dlh` (
  `XH` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DLH` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DLHZ` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DASLH` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`XH`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dlh 数据已清理，仅保留表结构

-- 表结构: zd_dlh4
DROP TABLE IF EXISTS `zd_dlh4`;
CREATE TABLE `zd_dlh4` (
  `XH` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dlh4 数据已清理，仅保留表结构

-- 表结构: zd_dlh9
DROP TABLE IF EXISTS `zd_dlh9`;
CREATE TABLE `zd_dlh9` (
  `XH` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dlh9 数据已清理，仅保留表结构

-- 表结构: zd_dljgbsm
DROP TABLE IF EXISTS `zd_dljgbsm`;
CREATE TABLE `zd_dljgbsm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dljgbsm 数据已清理，仅保留表结构

-- 表结构: zd_dpmcdm
DROP TABLE IF EXISTS `zd_dpmcdm`;
CREATE TABLE `zd_dpmcdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dpmcdm 数据已清理，仅保留表结构

-- 表结构: zd_dwbdlx
DROP TABLE IF EXISTS `zd_dwbdlx`;
CREATE TABLE `zd_dwbdlx` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dwbdlx 数据已清理，仅保留表结构

-- 表结构: zd_dwjbm
DROP TABLE IF EXISTS `zd_dwjbm`;
CREATE TABLE `zd_dwjbm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dwjbm 数据已清理，仅保留表结构

-- 表结构: zd_dwlbm
DROP TABLE IF EXISTS `zd_dwlbm`;
CREATE TABLE `zd_dwlbm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dwlbm 数据已清理，仅保留表结构

-- 表结构: zd_dwlx
DROP TABLE IF EXISTS `zd_dwlx`;
CREATE TABLE `zd_dwlx` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dwlx 数据已清理，仅保留表结构

-- 表结构: zd_dwxzbm
DROP TABLE IF EXISTS `zd_dwxzbm`;
CREATE TABLE `zd_dwxzbm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dwxzbm 数据已清理，仅保留表结构

-- 表结构: zd_dygwbm
DROP TABLE IF EXISTS `zd_dygwbm`;
CREATE TABLE `zd_dygwbm` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dygwbm 数据已清理，仅保留表结构

-- 表结构: zd_dzzwjbm
DROP TABLE IF EXISTS `zd_dzzwjbm`;
CREATE TABLE `zd_dzzwjbm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` int DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dzzwjbm 数据已清理，仅保留表结构

-- 表结构: zd_dzzwjbm2
DROP TABLE IF EXISTS `zd_dzzwjbm2`;
CREATE TABLE `zd_dzzwjbm2` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dzzwjbm2 数据已清理，仅保留表结构

-- 表结构: zd_dzzwmcm
DROP TABLE IF EXISTS `zd_dzzwmcm`;
CREATE TABLE `zd_dzzwmcm` (
  `BM` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(28) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_dzzwmcm 数据已清理，仅保留表结构

-- 表结构: zd_foreign_person
DROP TABLE IF EXISTS `zd_foreign_person`;
CREATE TABLE `zd_foreign_person` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_foreign_person 数据已清理，仅保留表结构

-- 表结构: zd_foreign_task
DROP TABLE IF EXISTS `zd_foreign_task`;
CREATE TABLE `zd_foreign_task` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_foreign_task 数据已清理，仅保留表结构

-- 表结构: zd_gajjqk
DROP TABLE IF EXISTS `zd_gajjqk`;
CREATE TABLE `zd_gajjqk` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gajjqk 数据已清理，仅保留表结构

-- 表结构: zd_gbpxbdl
DROP TABLE IF EXISTS `zd_gbpxbdl`;
CREATE TABLE `zd_gbpxbdl` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gbpxbdl 数据已清理，仅保留表结构

-- 表结构: zd_gbpxblb
DROP TABLE IF EXISTS `zd_gbpxblb`;
CREATE TABLE `zd_gbpxblb` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gbpxblb 数据已清理，仅保留表结构

-- 表结构: zd_gcjsgwdm
DROP TABLE IF EXISTS `zd_gcjsgwdm`;
CREATE TABLE `zd_gcjsgwdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gcjsgwdm 数据已清理，仅保留表结构

-- 表结构: zd_ggdqdm
DROP TABLE IF EXISTS `zd_ggdqdm`;
CREATE TABLE `zd_ggdqdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ggdqdm 数据已清理，仅保留表结构

-- 表结构: zd_gjtlfl
DROP TABLE IF EXISTS `zd_gjtlfl`;
CREATE TABLE `zd_gjtlfl` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gjtlfl 数据已清理，仅保留表结构

-- 表结构: zd_gldwlb
DROP TABLE IF EXISTS `zd_gldwlb`;
CREATE TABLE `zd_gldwlb` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gldwlb 数据已清理，仅保留表结构

-- 表结构: zd_gmjjhyfldm
DROP TABLE IF EXISTS `zd_gmjjhyfldm`;
CREATE TABLE `zd_gmjjhyfldm` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(2,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gmjjhyfldm 数据已清理，仅保留表结构

-- 表结构: zd_gmjjhyfldm1
DROP TABLE IF EXISTS `zd_gmjjhyfldm1`;
CREATE TABLE `zd_gmjjhyfldm1` (
  `BM` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(2,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gmjjhyfldm1 数据已清理，仅保留表结构

-- 表结构: zd_grgbbs
DROP TABLE IF EXISTS `zd_grgbbs`;
CREATE TABLE `zd_grgbbs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_grgbbs 数据已清理，仅保留表结构

-- 表结构: zd_grjsdj
DROP TABLE IF EXISTS `zd_grjsdj`;
CREATE TABLE `zd_grjsdj` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_grjsdj 数据已清理，仅保留表结构

-- 表结构: zd_grsrly
DROP TABLE IF EXISTS `zd_grsrly`;
CREATE TABLE `zd_grsrly` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_grsrly 数据已清理，仅保留表结构

-- 表结构: zd_gw
DROP TABLE IF EXISTS `zd_gw`;
CREATE TABLE `zd_gw` (
  `BM` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gw 数据已清理，仅保留表结构

-- 表结构: zd_gwfl
DROP TABLE IF EXISTS `zd_gwfl`;
CREATE TABLE `zd_gwfl` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gwfl 数据已清理，仅保留表结构

-- 表结构: zd_gwfzdm
DROP TABLE IF EXISTS `zd_gwfzdm`;
CREATE TABLE `zd_gwfzdm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gwfzdm 数据已清理，仅保留表结构

-- 表结构: zd_gwgzdjdm
DROP TABLE IF EXISTS `zd_gwgzdjdm`;
CREATE TABLE `zd_gwgzdjdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gwgzdjdm 数据已清理，仅保留表结构

-- 表结构: zd_gwqkdm
DROP TABLE IF EXISTS `zd_gwqkdm`;
CREATE TABLE `zd_gwqkdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gwqkdm 数据已清理，仅保留表结构

-- 表结构: zd_gwsxdm
DROP TABLE IF EXISTS `zd_gwsxdm`;
CREATE TABLE `zd_gwsxdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gwsxdm 数据已清理，仅保留表结构

-- 表结构: zd_gz
DROP TABLE IF EXISTS `zd_gz`;
CREATE TABLE `zd_gz` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gz 数据已清理，仅保留表结构

-- 表结构: zd_gzqdm
DROP TABLE IF EXISTS `zd_gzqdm`;
CREATE TABLE `zd_gzqdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gzqdm 数据已清理，仅保留表结构

-- 表结构: zd_gzwjgqydm
DROP TABLE IF EXISTS `zd_gzwjgqydm`;
CREATE TABLE `zd_gzwjgqydm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gzwjgqydm 数据已清理，仅保留表结构

-- 表结构: zd_gzzddm
DROP TABLE IF EXISTS `zd_gzzddm`;
CREATE TABLE `zd_gzzddm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gzzddm 数据已清理，仅保留表结构

-- 表结构: zd_gzzdylx
DROP TABLE IF EXISTS `zd_gzzdylx`;
CREATE TABLE `zd_gzzdylx` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(38,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_gzzdylx 数据已清理，仅保留表结构

-- 表结构: zd_hbgbpycsbm
DROP TABLE IF EXISTS `zd_hbgbpycsbm`;
CREATE TABLE `zd_hbgbpycsbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hbgbpycsbm 数据已清理，仅保留表结构

-- 表结构: zd_hbgbsyqkm
DROP TABLE IF EXISTS `zd_hbgbsyqkm`;
CREATE TABLE `zd_hbgbsyqkm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hbgbsyqkm 数据已清理，仅保留表结构

-- 表结构: zd_hbgbtzqkbm
DROP TABLE IF EXISTS `zd_hbgbtzqkbm`;
CREATE TABLE `zd_hbgbtzqkbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hbgbtzqkbm 数据已清理，仅保留表结构

-- 表结构: zd_hblxbsm
DROP TABLE IF EXISTS `zd_hblxbsm`;
CREATE TABLE `zd_hblxbsm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hblxbsm 数据已清理，仅保留表结构

-- 表结构: zd_hg
DROP TABLE IF EXISTS `zd_hg`;
CREATE TABLE `zd_hg` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hg 数据已清理，仅保留表结构

-- 表结构: zd_hk_zblb
DROP TABLE IF EXISTS `zd_hk_zblb`;
CREATE TABLE `zd_hk_zblb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hk_zblb 数据已清理，仅保留表结构

-- 表结构: zd_hkxz
DROP TABLE IF EXISTS `zd_hkxz`;
CREATE TABLE `zd_hkxz` (
  `BM` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hkxz 数据已清理，仅保留表结构

-- 表结构: zd_hlrylbm
DROP TABLE IF EXISTS `zd_hlrylbm`;
CREATE TABLE `zd_hlrylbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hlrylbm 数据已清理，仅保留表结构

-- 表结构: zd_hyqkbm
DROP TABLE IF EXISTS `zd_hyqkbm`;
CREATE TABLE `zd_hyqkbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(2,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_hyqkbm 数据已清理，仅保留表结构

-- 表结构: zd_int_bljl
DROP TABLE IF EXISTS `zd_int_bljl`;
CREATE TABLE `zd_int_bljl` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_bljl 数据已清理，仅保留表结构

-- 表结构: zd_int_cbzrdw
DROP TABLE IF EXISTS `zd_int_cbzrdw`;
CREATE TABLE `zd_int_cbzrdw` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_cbzrdw 数据已清理，仅保留表结构

-- 表结构: zd_int_cflx
DROP TABLE IF EXISTS `zd_int_cflx`;
CREATE TABLE `zd_int_cflx` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_cflx 数据已清理，仅保留表结构

-- 表结构: zd_int_chfs
DROP TABLE IF EXISTS `zd_int_chfs`;
CREATE TABLE `zd_int_chfs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_chfs 数据已清理，仅保留表结构

-- 表结构: zd_int_chjg
DROP TABLE IF EXISTS `zd_int_chjg`;
CREATE TABLE `zd_int_chjg` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_chjg 数据已清理，仅保留表结构

-- 表结构: zd_int_gbglqx
DROP TABLE IF EXISTS `zd_int_gbglqx`;
CREATE TABLE `zd_int_gbglqx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_gbglqx 数据已清理，仅保留表结构

-- 表结构: zd_int_gbjb
DROP TABLE IF EXISTS `zd_int_gbjb`;
CREATE TABLE `zd_int_gbjb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_gbjb 数据已清理，仅保留表结构

-- 表结构: zd_int_jblx
DROP TABLE IF EXISTS `zd_int_jblx`;
CREATE TABLE `zd_int_jblx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_jblx 数据已清理，仅保留表结构

-- 表结构: zd_int_ldps
DROP TABLE IF EXISTS `zd_int_ldps`;
CREATE TABLE `zd_int_ldps` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_ldps 数据已清理，仅保留表结构

-- 表结构: zd_int_sbchjg
DROP TABLE IF EXISTS `zd_int_sbchjg`;
CREATE TABLE `zd_int_sbchjg` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_sbchjg 数据已清理，仅保留表结构

-- 表结构: zd_int_sflrll
DROP TABLE IF EXISTS `zd_int_sflrll`;
CREATE TABLE `zd_int_sflrll` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_sflrll 数据已清理，仅保留表结构

-- 表结构: zd_int_sfysb
DROP TABLE IF EXISTS `zd_int_sfysb`;
CREATE TABLE `zd_int_sfysb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_sfysb 数据已清理，仅保留表结构

-- 表结构: zd_int_slfw
DROP TABLE IF EXISTS `zd_int_slfw`;
CREATE TABLE `zd_int_slfw` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `LOY1` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LOY2` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_slfw 数据已清理，仅保留表结构

-- 表结构: zd_int_slqd
DROP TABLE IF EXISTS `zd_int_slqd`;
CREATE TABLE `zd_int_slqd` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_slqd 数据已清理，仅保留表结构

-- 表结构: zd_int_wtxz
DROP TABLE IF EXISTS `zd_int_wtxz`;
CREATE TABLE `zd_int_wtxz` (
  `BM` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_int_wtxz 数据已清理，仅保留表结构

-- 表结构: zd_jcpzjgjb
DROP TABLE IF EXISTS `zd_jcpzjgjb`;
CREATE TABLE `zd_jcpzjgjb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jcpzjgjb 数据已清理，仅保留表结构

-- 表结构: zd_jczt
DROP TABLE IF EXISTS `zd_jczt`;
CREATE TABLE `zd_jczt` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(3,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jczt 数据已清理，仅保留表结构

-- 表结构: zd_jgbsdm
DROP TABLE IF EXISTS `zd_jgbsdm`;
CREATE TABLE `zd_jgbsdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jgbsdm 数据已清理，仅保留表结构

-- 表结构: zd_jgxz
DROP TABLE IF EXISTS `zd_jgxz`;
CREATE TABLE `zd_jgxz` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jgxz 数据已清理，仅保留表结构

-- 表结构: zd_jjxdm
DROP TABLE IF EXISTS `zd_jjxdm`;
CREATE TABLE `zd_jjxdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jjxdm 数据已清理，仅保留表结构

-- 表结构: zd_jkqkdm
DROP TABLE IF EXISTS `zd_jkqkdm`;
CREATE TABLE `zd_jkqkdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jkqkdm 数据已清理，仅保留表结构

-- 表结构: zd_jlcc
DROP TABLE IF EXISTS `zd_jlcc`;
CREATE TABLE `zd_jlcc` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jlcc 数据已清理，仅保留表结构

-- 表结构: zd_jldj
DROP TABLE IF EXISTS `zd_jldj`;
CREATE TABLE `zd_jldj` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jldj 数据已清理，仅保留表结构

-- 表结构: zd_jlmcdjm
DROP TABLE IF EXISTS `zd_jlmcdjm`;
CREATE TABLE `zd_jlmcdjm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jlmcdjm 数据已清理，仅保留表结构

-- 表结构: zd_jsdj
DROP TABLE IF EXISTS `zd_jsdj`;
CREATE TABLE `zd_jsdj` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jsdj 数据已清理，仅保留表结构

-- 表结构: zd_jsgbpybsm
DROP TABLE IF EXISTS `zd_jsgbpybsm`;
CREATE TABLE `zd_jsgbpybsm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jsgbpybsm 数据已清理，仅保留表结构

-- 表结构: zd_jsyydm
DROP TABLE IF EXISTS `zd_jsyydm`;
CREATE TABLE `zd_jsyydm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jsyydm 数据已清理，仅保留表结构

-- 表结构: zd_jszgqdfs
DROP TABLE IF EXISTS `zd_jszgqdfs`;
CREATE TABLE `zd_jszgqdfs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jszgqdfs 数据已清理，仅保留表结构

-- 表结构: zd_jtjjqk
DROP TABLE IF EXISTS `zd_jtjjqk`;
CREATE TABLE `zd_jtjjqk` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jtjjqk 数据已清理，仅保留表结构

-- 表结构: zd_judge_class
DROP TABLE IF EXISTS `zd_judge_class`;
CREATE TABLE `zd_judge_class` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL04` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL05` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_judge_class 数据已清理，仅保留表结构

-- 表结构: zd_judge_level
DROP TABLE IF EXISTS `zd_judge_level`;
CREATE TABLE `zd_judge_level` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_judge_level 数据已清理，仅保留表结构

-- 表结构: zd_judge_type
DROP TABLE IF EXISTS `zd_judge_type`;
CREATE TABLE `zd_judge_type` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_judge_type 数据已清理，仅保留表结构

-- 表结构: zd_jwpxbs
DROP TABLE IF EXISTS `zd_jwpxbs`;
CREATE TABLE `zd_jwpxbs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_jwpxbs 数据已清理，仅保留表结构

-- 表结构: zd_kckhjgdm
DROP TABLE IF EXISTS `zd_kckhjgdm`;
CREATE TABLE `zd_kckhjgdm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_kckhjgdm 数据已清理，仅保留表结构

-- 表结构: zd_kclbdm
DROP TABLE IF EXISTS `zd_kclbdm`;
CREATE TABLE `zd_kclbdm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_kclbdm 数据已清理，仅保留表结构

-- 表结构: zd_kcyj
DROP TABLE IF EXISTS `zd_kcyj`;
CREATE TABLE `zd_kcyj` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_kcyj 数据已清理，仅保留表结构

-- 表结构: zd_ldbz
DROP TABLE IF EXISTS `zd_ldbz`;
CREATE TABLE `zd_ldbz` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ldbz 数据已清理，仅保留表结构

-- 表结构: zd_ldbzsbm
DROP TABLE IF EXISTS `zd_ldbzsbm`;
CREATE TABLE `zd_ldbzsbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ldbzsbm 数据已清理，仅保留表结构

-- 表结构: zd_ldcxlx
DROP TABLE IF EXISTS `zd_ldcxlx`;
CREATE TABLE `zd_ldcxlx` (
  `BM` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  UNIQUE KEY `PK_ZD_LDCXLX` (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ldcxlx 数据已清理，仅保留表结构

-- 表结构: zd_ldlb
DROP TABLE IF EXISTS `zd_ldlb`;
CREATE TABLE `zd_ldlb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ldlb 数据已清理，仅保留表结构

-- 表结构: zd_ldyglb
DROP TABLE IF EXISTS `zd_ldyglb`;
CREATE TABLE `zd_ldyglb` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ldyglb 数据已清理，仅保留表结构

-- 表结构: zd_lkxgwbdlx
DROP TABLE IF EXISTS `zd_lkxgwbdlx`;
CREATE TABLE `zd_lkxgwbdlx` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_lkxgwbdlx 数据已清理，仅保留表结构

-- 表结构: zd_llry
DROP TABLE IF EXISTS `zd_llry`;
CREATE TABLE `zd_llry` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_llry 数据已清理，仅保留表结构

-- 表结构: zd_ls_shcz
DROP TABLE IF EXISTS `zd_ls_shcz`;
CREATE TABLE `zd_ls_shcz` (
  `DICTCN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DICTEN` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ls_shcz 数据已清理，仅保留表结构

-- 表结构: zd_lwzzbzm
DROP TABLE IF EXISTS `zd_lwzzbzm`;
CREATE TABLE `zd_lwzzbzm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_lwzzbzm 数据已清理，仅保留表结构

-- 表结构: zd_mzdm
DROP TABLE IF EXISTS `zd_mzdm`;
CREATE TABLE `zd_mzdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_mzdm 数据已清理，仅保留表结构

-- 表结构: zd_nsjgxz
DROP TABLE IF EXISTS `zd_nsjgxz`;
CREATE TABLE `zd_nsjgxz` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_nsjgxz 数据已清理，仅保留表结构

-- 表结构: zd_ppfsdm
DROP TABLE IF EXISTS `zd_ppfsdm`;
CREATE TABLE `zd_ppfsdm` (
  `XH` decimal(65,30) DEFAULT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ppfsdm 数据已清理，仅保留表结构

-- 表结构: zd_province
DROP TABLE IF EXISTS `zd_province`;
CREATE TABLE `zd_province` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_province 数据已清理，仅保留表结构

-- 表结构: zd_przyzwdj
DROP TABLE IF EXISTS `zd_przyzwdj`;
CREATE TABLE `zd_przyzwdj` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_przyzwdj 数据已清理，仅保留表结构

-- 表结构: zd_pxjglx
DROP TABLE IF EXISTS `zd_pxjglx`;
CREATE TABLE `zd_pxjglx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_pxjglx 数据已清理，仅保留表结构

-- 表结构: zd_pxjglx2
DROP TABLE IF EXISTS `zd_pxjglx2`;
CREATE TABLE `zd_pxjglx2` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_pxjglx2 数据已清理，仅保留表结构

-- 表结构: zd_pxjgxz
DROP TABLE IF EXISTS `zd_pxjgxz`;
CREATE TABLE `zd_pxjgxz` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_pxjgxz 数据已清理，仅保留表结构

-- 表结构: zd_pxjgxzm
DROP TABLE IF EXISTS `zd_pxjgxzm`;
CREATE TABLE `zd_pxjgxzm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_pxjgxzm 数据已清理，仅保留表结构

-- 表结构: zd_qyglrczw
DROP TABLE IF EXISTS `zd_qyglrczw`;
CREATE TABLE `zd_qyglrczw` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_qyglrczw 数据已清理，仅保留表结构

-- 表结构: zd_qygm
DROP TABLE IF EXISTS `zd_qygm`;
CREATE TABLE `zd_qygm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(3,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_qygm 数据已清理，仅保留表结构

-- 表结构: zd_qyjyzkdm
DROP TABLE IF EXISTS `zd_qyjyzkdm`;
CREATE TABLE `zd_qyjyzkdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_qyjyzkdm 数据已清理，仅保留表结构

-- 表结构: zd_qykgdm
DROP TABLE IF EXISTS `zd_qykgdm`;
CREATE TABLE `zd_qykgdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_qykgdm 数据已清理，仅保留表结构

-- 表结构: zd_qylx
DROP TABLE IF EXISTS `zd_qylx`;
CREATE TABLE `zd_qylx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(3,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_qylx 数据已清理，仅保留表结构

-- 表结构: zd_qytqqkdm
DROP TABLE IF EXISTS `zd_qytqqkdm`;
CREATE TABLE `zd_qytqqkdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_qytqqkdm 数据已清理，仅保留表结构

-- 表结构: zd_qyxzdm
DROP TABLE IF EXISTS `zd_qyxzdm`;
CREATE TABLE `zd_qyxzdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_qyxzdm 数据已清理，仅保留表结构

-- 表结构: zd_rdrzdm
DROP TABLE IF EXISTS `zd_rdrzdm`;
CREATE TABLE `zd_rdrzdm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_rdrzdm 数据已清理，仅保留表结构

-- 表结构: zd_rm_base
DROP TABLE IF EXISTS `zd_rm_base`;
CREATE TABLE `zd_rm_base` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GZBZ` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_rm_base 数据已清理，仅保留表结构

-- 表结构: zd_rm_temple
DROP TABLE IF EXISTS `zd_rm_temple`;
CREATE TABLE `zd_rm_temple` (
  `BM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_rm_temple 数据已清理，仅保留表结构

-- 表结构: zd_rsbzydm
DROP TABLE IF EXISTS `zd_rsbzydm`;
CREATE TABLE `zd_rsbzydm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_rsbzydm 数据已清理，仅保留表结构

-- 表结构: zd_rsjclb
DROP TABLE IF EXISTS `zd_rsjclb`;
CREATE TABLE `zd_rsjclb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_rsjclb 数据已清理，仅保留表结构

-- 表结构: zd_ryfl1
DROP TABLE IF EXISTS `zd_ryfl1`;
CREATE TABLE `zd_ryfl1` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ryfl1 数据已清理，仅保留表结构

-- 表结构: zd_ryfl2
DROP TABLE IF EXISTS `zd_ryfl2`;
CREATE TABLE `zd_ryfl2` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ryfl2 数据已清理，仅保留表结构

-- 表结构: zd_ryfl3
DROP TABLE IF EXISTS `zd_ryfl3`;
CREATE TABLE `zd_ryfl3` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ryfl3 数据已清理，仅保留表结构

-- 表结构: zd_ryfl4
DROP TABLE IF EXISTS `zd_ryfl4`;
CREATE TABLE `zd_ryfl4` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ryfl4 数据已清理，仅保留表结构

-- 表结构: zd_ryflm
DROP TABLE IF EXISTS `zd_ryflm`;
CREATE TABLE `zd_ryflm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ryflm 数据已清理，仅保留表结构

-- 表结构: zd_rylb
DROP TABLE IF EXISTS `zd_rylb`;
CREATE TABLE `zd_rylb` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_rylb 数据已清理，仅保留表结构

-- 表结构: zd_ryly
DROP TABLE IF EXISTS `zd_ryly`;
CREATE TABLE `zd_ryly` (
  `BM` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ryly 数据已清理，仅保留表结构

-- 表结构: zd_ryqx
DROP TABLE IF EXISTS `zd_ryqx`;
CREATE TABLE `zd_ryqx` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ryqx 数据已清理，仅保留表结构

-- 表结构: zd_sczbdm
DROP TABLE IF EXISTS `zd_sczbdm`;
CREATE TABLE `zd_sczbdm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_sczbdm 数据已清理，仅保留表结构

-- 表结构: zd_sczbm
DROP TABLE IF EXISTS `zd_sczbm`;
CREATE TABLE `zd_sczbm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_sczbm 数据已清理，仅保留表结构

-- 表结构: zd_shbxzl
DROP TABLE IF EXISTS `zd_shbxzl`;
CREATE TABLE `zd_shbxzl` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_shbxzl 数据已清理，仅保留表结构

-- 表结构: zd_shgxbm
DROP TABLE IF EXISTS `zd_shgxbm`;
CREATE TABLE `zd_shgxbm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_shgxbm 数据已清理，仅保留表结构

-- 表结构: zd_shzt
DROP TABLE IF EXISTS `zd_shzt`;
CREATE TABLE `zd_shzt` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_shzt 数据已清理，仅保留表结构

-- 表结构: zd_sjybm
DROP TABLE IF EXISTS `zd_sjybm`;
CREATE TABLE `zd_sjybm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_sjybm 数据已清理，仅保留表结构

-- 表结构: zd_sxzylb
DROP TABLE IF EXISTS `zd_sxzylb`;
CREATE TABLE `zd_sxzylb` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_sxzylb 数据已清理，仅保留表结构

-- 表结构: zd_syjhbsm
DROP TABLE IF EXISTS `zd_syjhbsm`;
CREATE TABLE `zd_syjhbsm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_syjhbsm 数据已清理，仅保留表结构

-- 表结构: zd_ta_ljly
DROP TABLE IF EXISTS `zd_ta_ljly`;
CREATE TABLE `zd_ta_ljly` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ta_ljly 数据已清理，仅保留表结构

-- 表结构: zd_ta_ljzy
DROP TABLE IF EXISTS `zd_ta_ljzy`;
CREATE TABLE `zd_ta_ljzy` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `QTDW` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `QTDWBSM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ta_ljzy 数据已清理，仅保留表结构

-- 表结构: zd_ta_ly
DROP TABLE IF EXISTS `zd_ta_ly`;
CREATE TABLE `zd_ta_ly` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ta_ly 数据已清理，仅保留表结构

-- 表结构: zd_ta_rclb
DROP TABLE IF EXISTS `zd_ta_rclb`;
CREATE TABLE `zd_ta_rclb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ta_rclb 数据已清理，仅保留表结构

-- 表结构: zd_ta_rclb2
DROP TABLE IF EXISTS `zd_ta_rclb2`;
CREATE TABLE `zd_ta_rclb2` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ta_rclb2 数据已清理，仅保留表结构

-- 表结构: zd_ta_shzt
DROP TABLE IF EXISTS `zd_ta_shzt`;
CREATE TABLE `zd_ta_shzt` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ta_shzt 数据已清理，仅保留表结构

-- 表结构: zd_ta_zy
DROP TABLE IF EXISTS `zd_ta_zy`;
CREATE TABLE `zd_ta_zy` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `QTDW` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `QTDWBSM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_ta_zy 数据已清理，仅保留表结构

-- 表结构: zd_tjzwsbm
DROP TABLE IF EXISTS `zd_tjzwsbm`;
CREATE TABLE `zd_tjzwsbm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_tjzwsbm 数据已清理，仅保留表结构

-- 表结构: zd_tkfsm
DROP TABLE IF EXISTS `zd_tkfsm`;
CREATE TABLE `zd_tkfsm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_tkfsm 数据已清理，仅保留表结构

-- 表结构: zd_tsgz
DROP TABLE IF EXISTS `zd_tsgz`;
CREATE TABLE `zd_tsgz` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_tsgz 数据已清理，仅保留表结构

-- 表结构: zd_tsgzxz
DROP TABLE IF EXISTS `zd_tsgzxz`;
CREATE TABLE `zd_tsgzxz` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_tsgzxz 数据已清理，仅保留表结构

-- 表结构: zd_tybs
DROP TABLE IF EXISTS `zd_tybs`;
CREATE TABLE `zd_tybs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(2,0) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_tybs 数据已清理，仅保留表结构

-- 表结构: zd_whcddm1
DROP TABLE IF EXISTS `zd_whcddm1`;
CREATE TABLE `zd_whcddm1` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_whcddm1 数据已清理，仅保留表结构

-- 表结构: zd_whcddm2
DROP TABLE IF EXISTS `zd_whcddm2`;
CREATE TABLE `zd_whcddm2` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_whcddm2 数据已清理，仅保留表结构

-- 表结构: zd_whngc
DROP TABLE IF EXISTS `zd_whngc`;
CREATE TABLE `zd_whngc` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_whngc 数据已清理，仅保留表结构

-- 表结构: zd_xbfsm
DROP TABLE IF EXISTS `zd_xbfsm`;
CREATE TABLE `zd_xbfsm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xbfsm 数据已清理，仅保留表结构

-- 表结构: zd_xbm
DROP TABLE IF EXISTS `zd_xbm`;
CREATE TABLE `zd_xbm` (
  `BM` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xbm 数据已清理，仅保留表结构

-- 表结构: zd_xjgzdjdm
DROP TABLE IF EXISTS `zd_xjgzdjdm`;
CREATE TABLE `zd_xjgzdjdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xjgzdjdm 数据已清理，仅保留表结构

-- 表结构: zd_xksyyydm
DROP TABLE IF EXISTS `zd_xksyyydm`;
CREATE TABLE `zd_xksyyydm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xksyyydm 数据已清理，仅保留表结构

-- 表结构: zd_xkzylm
DROP TABLE IF EXISTS `zd_xkzylm`;
CREATE TABLE `zd_xkzylm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xkzylm 数据已清理，仅保留表结构

-- 表结构: zd_xl
DROP TABLE IF EXISTS `zd_xl`;
CREATE TABLE `zd_xl` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xl 数据已清理，仅保留表结构

-- 表结构: zd_xmdrjsm
DROP TABLE IF EXISTS `zd_xmdrjsm`;
CREATE TABLE `zd_xmdrjsm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xmdrjsm 数据已清理，仅保留表结构

-- 表结构: zd_xmmcbsm
DROP TABLE IF EXISTS `zd_xmmcbsm`;
CREATE TABLE `zd_xmmcbsm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xmmcbsm 数据已清理，仅保留表结构

-- 表结构: zd_xmspm
DROP TABLE IF EXISTS `zd_xmspm`;
CREATE TABLE `zd_xmspm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xmspm 数据已清理，仅保留表结构

-- 表结构: zd_xwmcdm
DROP TABLE IF EXISTS `zd_xwmcdm`;
CREATE TABLE `zd_xwmcdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xwmcdm 数据已清理，仅保留表结构

-- 表结构: zd_xxfs
DROP TABLE IF EXISTS `zd_xxfs`;
CREATE TABLE `zd_xxfs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xxfs 数据已清理，仅保留表结构

-- 表结构: zd_xxfs1
DROP TABLE IF EXISTS `zd_xxfs1`;
CREATE TABLE `zd_xxfs1` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xxfs1 数据已清理，仅保留表结构

-- 表结构: zd_xxlbdm
DROP TABLE IF EXISTS `zd_xxlbdm`;
CREATE TABLE `zd_xxlbdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xxlbdm 数据已清理，仅保留表结构

-- 表结构: zd_xxpxfs
DROP TABLE IF EXISTS `zd_xxpxfs`;
CREATE TABLE `zd_xxpxfs` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xxpxfs 数据已清理，仅保留表结构

-- 表结构: zd_xzqkfm
DROP TABLE IF EXISTS `zd_xzqkfm`;
CREATE TABLE `zd_xzqkfm` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_xzqkfm 数据已清理，仅保留表结构

-- 表结构: zd_yn
DROP TABLE IF EXISTS `zd_yn`;
CREATE TABLE `zd_yn` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_yn 数据已清理，仅保留表结构

-- 表结构: zd_yxq
DROP TABLE IF EXISTS `zd_yxq`;
CREATE TABLE `zd_yxq` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_yxq 数据已清理，仅保留表结构

-- 表结构: zd_yzslcdm
DROP TABLE IF EXISTS `zd_yzslcdm`;
CREATE TABLE `zd_yzslcdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_yzslcdm 数据已清理，仅保留表结构

-- 表结构: zd_zbdw
DROP TABLE IF EXISTS `zd_zbdw`;
CREATE TABLE `zd_zbdw` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zbdw 数据已清理，仅保留表结构

-- 表结构: zd_zcdm
DROP TABLE IF EXISTS `zd_zcdm`;
CREATE TABLE `zd_zcdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zcdm 数据已清理，仅保留表结构

-- 表结构: zd_zgfsdm
DROP TABLE IF EXISTS `zd_zgfsdm`;
CREATE TABLE `zd_zgfsdm` (
  `XH` decimal(65,30) DEFAULT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zgfsdm 数据已清理，仅保留表结构

-- 表结构: zd_zgrygwdm
DROP TABLE IF EXISTS `zd_zgrygwdm`;
CREATE TABLE `zd_zgrygwdm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zgrygwdm 数据已清理，仅保留表结构

-- 表结构: zd_zjbgzt
DROP TABLE IF EXISTS `zd_zjbgzt`;
CREATE TABLE `zd_zjbgzt` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zjbgzt 数据已清理，仅保留表结构

-- 表结构: zd_zjbs
DROP TABLE IF EXISTS `zd_zjbs`;
CREATE TABLE `zd_zjbs` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zjbs 数据已清理，仅保留表结构

-- 表结构: zd_zjgblx
DROP TABLE IF EXISTS `zd_zjgblx`;
CREATE TABLE `zd_zjgblx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zjgblx 数据已清理，仅保留表结构

-- 表结构: zd_zjjglx
DROP TABLE IF EXISTS `zd_zjjglx`;
CREATE TABLE `zd_zjjglx` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(2,0) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zjjglx 数据已清理，仅保留表结构

-- 表结构: zd_zjlb
DROP TABLE IF EXISTS `zd_zjlb`;
CREATE TABLE `zd_zjlb` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zjlb 数据已清理，仅保留表结构

-- 表结构: zd_zjyqkdm
DROP TABLE IF EXISTS `zd_zjyqkdm`;
CREATE TABLE `zd_zjyqkdm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zjyqkdm 数据已清理，仅保留表结构

-- 表结构: zd_zjyydm
DROP TABLE IF EXISTS `zd_zjyydm`;
CREATE TABLE `zd_zjyydm` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zjyydm 数据已清理，仅保留表结构

-- 表结构: zd_zrzl
DROP TABLE IF EXISTS `zd_zrzl`;
CREATE TABLE `zd_zrzl` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zrzl 数据已清理，仅保留表结构

-- 表结构: zd_zslb
DROP TABLE IF EXISTS `zd_zslb`;
CREATE TABLE `zd_zslb` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zslb 数据已清理，仅保留表结构

-- 表结构: zd_zwfl
DROP TABLE IF EXISTS `zd_zwfl`;
CREATE TABLE `zd_zwfl` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zwfl 数据已清理，仅保留表结构

-- 表结构: zd_zwgzdjdm
DROP TABLE IF EXISTS `zd_zwgzdjdm`;
CREATE TABLE `zd_zwgzdjdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zwgzdjdm 数据已清理，仅保留表结构

-- 表结构: zd_zy2zgdm
DROP TABLE IF EXISTS `zd_zy2zgdm`;
CREATE TABLE `zd_zy2zgdm` (
  `BM` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zy2zgdm 数据已清理，仅保留表结构

-- 表结构: zd_zy2zgqdfsm
DROP TABLE IF EXISTS `zd_zy2zgqdfsm`;
CREATE TABLE `zd_zy2zgqdfsm` (
  `BM` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zy2zgqdfsm 数据已清理，仅保留表结构

-- 表结构: zd_zydm
DROP TABLE IF EXISTS `zd_zydm`;
CREATE TABLE `zd_zydm` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zydm 数据已清理，仅保留表结构

-- 表结构: zd_zyjszwdm
DROP TABLE IF EXISTS `zd_zyjszwdm`;
CREATE TABLE `zd_zyjszwdm` (
  `BM` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zyjszwdm 数据已清理，仅保留表结构

-- 表结构: zd_zylb
DROP TABLE IF EXISTS `zd_zylb`;
CREATE TABLE `zd_zylb` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zd_zylb 数据已清理，仅保留表结构

-- 表结构: zz_bzcyxx
DROP TABLE IF EXISTS `zz_bzcyxx`;
CREATE TABLE `zz_bzcyxx` (
  `BZCYXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班子成员信息标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员编码',
  `JC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '界次',
  `XM` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `DZZDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `ZWMC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务名称',
  `ZZJZQK` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专职或兼职情况',
  `ZWSM` varchar(450) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务说明',
  `GZWJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '该职务级别',
  `PZRZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '批准任职日期',
  `PZMZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '批准免职日期',
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RZFS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '任职方式',
  `DP_WY` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '得票情况??委员',
  `DP_CW` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '得票情况??常委',
  `DP_SJ` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '得票情况??书记'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_bzcyxx 数据已清理，仅保留表结构

-- 表结构: zz_bzjcxx
DROP TABLE IF EXISTS `zz_bzjcxx`;
CREATE TABLE `zz_bzjcxx` (
  `BZJCXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班子届次标识',
  `DZZDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `LDJTJC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '领导集体届次',
  `LDJTDXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '领导集体当选日期',
  `XJFS` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '选举方式',
  `GJJMRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '该届届满日期',
  `YDHRS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '应到会人数',
  `SDHRS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '实到会人数',
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `QWRS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '全委人数',
  `QWSDRS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '全委实到人数',
  `PZWYME` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '批准委员名额',
  `PZCWME` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '批准常委名额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_bzjcxx 数据已清理，仅保留表结构

-- 表结构: zz_bzjcxxfb
DROP TABLE IF EXISTS `zz_bzjcxxfb`;
CREATE TABLE `zz_bzjcxxfb` (
  `BZJCXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班子届次标识',
  `WYHDY` decimal(8,0) DEFAULT NULL COMMENT '委员会定员',
  PRIMARY KEY (`BZJCXXBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_bzjcxxfb 数据已清理，仅保留表结构

-- 表结构: zz_djxx
DROP TABLE IF EXISTS `zz_djxx`;
CREATE TABLE `zz_djxx` (
  `DJXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '党籍信息标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `JRZGZZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '加入中共组织日期',
  `JRZGZZLX` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '加入中共组织类型',
  `ZZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '转正日期',
  `ZZQK` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '转正情况',
  `SZDZB` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '转正时所在党支部',
  `LKZGZZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '离开中共组织日期',
  `CDYY` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出党原因',
  `LKZGZZLX` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '离开中共组织类型',
  `CJZZSH` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '参加组织生活',
  `HFDJRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '恢复党籍日期',
  `SZDZBMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在党支部名称',
  KEY `index_ZZ_DJXX_RYBM` (`RYBM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_djxx 数据已清理，仅保留表结构

-- 表结构: zz_djxxfb
DROP TABLE IF EXISTS `zz_djxxfb`;
CREATE TABLE `zz_djxxfb` (
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `JRZBRQ` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '进入支部日期',
  `DJZT` decimal(8,0) DEFAULT NULL COMMENT '党籍状态',
  `SFLDDY` decimal(8,0) DEFAULT NULL COMMENT '是否流动党员',
  `SFSLDY` decimal(8,0) DEFAULT NULL COMMENT '是否失联党员',
  PRIMARY KEY (`RYBM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_djxxfb 数据已清理，仅保留表结构

-- 表结构: zz_dwxx
DROP TABLE IF EXISTS `zz_dwxx`;
CREATE TABLE `zz_dwxx` (
  `DWXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位信息标识码',
  `DZZDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `DWBSM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位标识码',
  `BMBSM` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门标识码',
  `DWXZLB` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位分类',
  `DWJLZZQK` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '建立党的基层组织情况',
  `FBQK` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分布情况',
  `FRDWBS` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '法人单位标识',
  `SCBZBS` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '生产班主标识',
  `JJLX` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '经济类型',
  `QYGM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '企业规模',
  `QYLX` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '企业类型',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL04` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL05` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  KEY `ZZ_DWXX_INDEX1` (`DZZDM`) USING BTREE,
  KEY `ZZ_DWXX_INDEX2` (`DWBSM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_dwxx 数据已清理，仅保留表结构

-- 表结构: zz_dxzcy
DROP TABLE IF EXISTS `zz_dxzcy`;
CREATE TABLE `zz_dxzcy` (
  `DXZCYBS` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RYBM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DZZDM` varchar(68) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`DXZCYBS`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_dxzcy 数据已清理，仅保留表结构

-- 表结构: zz_dzzfbqk
DROP TABLE IF EXISTS `zz_dzzfbqk`;
CREATE TABLE `zz_dzzfbqk` (
  `DZZDM` varchar(68) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ZZFB` decimal(8,0) DEFAULT NULL,
  `SORT` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`DZZDM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_dzzfbqk 数据已清理，仅保留表结构

-- 表结构: zz_dzzgly
DROP TABLE IF EXISTS `zz_dzzgly`;
CREATE TABLE `zz_dzzgly` (
  `DZZDM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LEADER` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`DZZDM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_dzzgly 数据已清理，仅保留表结构

-- 表结构: zz_dzzzly
DROP TABLE IF EXISTS `zz_dzzzly`;
CREATE TABLE `zz_dzzzly` (
  `DZZZLYID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一标识',
  `DZZDM` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `DZZMC` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织名称',
  `RYBM` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员编码',
  `XM` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员姓名',
  `ZLYTYPE` decimal(8,0) DEFAULT NULL COMMENT '助理员类型：字典zlyType，1：组织助理员、2：宣传助理员、3纪检监察员',
  PRIMARY KEY (`DZZZLYID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_dzzzly 数据已清理，仅保留表结构

-- 表结构: zz_jcqkxx
DROP TABLE IF EXISTS `zz_jcqkxx`;
CREATE TABLE `zz_jcqkxx` (
  `JCQKXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '奖惩情况信息标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `SZDZBDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在党支部代码',
  `JCMC` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩名称',
  `JCSM` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩说明',
  `JCPZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩批准日期',
  `JCPZJG` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩批准机关',
  `PZJGJB` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '批准机关级别',
  `JCYY` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩原因',
  `JCCXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩撤销日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_jcqkxx 数据已清理，仅保留表结构

-- 表结构: zz_learningplan
DROP TABLE IF EXISTS `zz_learningplan`;
CREATE TABLE `zz_learningplan` (
  `learningPlanID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `partyCode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `learningPlanType` int DEFAULT NULL,
  `publicDate` date DEFAULT NULL,
  `request` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `recordStatus` int DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `createUserName` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUserId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `updateUserName` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`learningPlanID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_learningplan 数据已清理，仅保留表结构

-- 表结构: zz_mzpyxx
DROP TABLE IF EXISTS `zz_mzpyxx`;
CREATE TABLE `zz_mzpyxx` (
  `MZPYXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '民主评议信息标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `SZDZBDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在党支部',
  `KZPYRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '开展评议日期',
  `JSPYRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结束评议日期',
  `PYJG` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评议结果',
  `PYJCQK` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评议奖惩情况',
  `PYJCYY` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评议奖惩原因'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_mzpyxx 数据已清理，仅保留表结构

-- 表结构: zz_pxqk
DROP TABLE IF EXISTS `zz_pxqk`;
CREATE TABLE `zz_pxqk` (
  `PXQKBS` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '党组织代码',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `PXKSSJ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训开始时间',
  `PXJSSJ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训截至时间',
  `PXDD` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训地点',
  `PXQK` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训情况',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PXZBDW` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训主办单位',
  `PXXS` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训形式',
  `PXMC` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训名称',
  `PXJG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训结果'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_pxqk 数据已清理，仅保留表结构

-- 表结构: zz_ryjbxx
DROP TABLE IF EXISTS `zz_ryjbxx`;
CREATE TABLE `zz_ryjbxx` (
  `RYJBXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员基本信息标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `RYZT` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员状态',
  `SZDZBDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在党支部代码',
  `CGCJLB` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出国出境类别',
  `CGCJYY` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出国出境原因',
  `CGCJRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出国出境日期',
  `GZGW` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工作岗位',
  `PXQK` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训情况',
  `YXQK` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '一线情况',
  `BZ1` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ2` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ3` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL04` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL05` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SQRDRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请入党日期',
  `ZZPYPXBZ` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织培养培训备注',
  `PYR` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培养人',
  `ZJPXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '最近培训日期',
  `ZJPXJG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '最近培训结果',
  `LWJJFZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '列为入党积极分子日期',
  `LWFZDXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '列为发展对象日期',
  `ZBDHTGRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '支部大会通过日期',
  `SJZZPZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '上级组织批准日期',
  `BLDJJZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '保留党籍截止日期',
  `RDRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '入党日期',
  KEY `index_zz_ryjbxx_rybm` (`RYBM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_ryjbxx 数据已清理，仅保留表结构

-- 表结构: zz_ryjbxx_lw
DROP TABLE IF EXISTS `zz_ryjbxx_lw`;
CREATE TABLE `zz_ryjbxx_lw` (
  `LWRYJBXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '路外人员基本信息标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `RYZT` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '人员状态',
  `SZDZBDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在党支部代码',
  `DWBM` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在单位',
  `BMBM` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在部门',
  `XM` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `XB` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `CSRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出生日期',
  `JG` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '籍贯',
  `MZ` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '民族',
  `XWHCD` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学历',
  `ZWMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务名称',
  `ZWJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务级别',
  `XJSZWMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '技术职务',
  `CJGZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '参加工作日期',
  `CGCJLB` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出国出境类别',
  `CGCJYY` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出国出境原因',
  `CGCJRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出国出境日期',
  `GZGW` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工作岗位',
  `PXQK` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培训情况',
  `YXQK` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '一线情况',
  `BZ1` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ2` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ3` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL04` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL05` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SQRDRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请入党日期',
  `ZZPYPXBZ` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织培养培训备注',
  `PYR` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '培养人',
  `ZJPXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '最近培训日期',
  `ZJPXJG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '最近培训结果',
  `LWJJFZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '列为入党积极分子日期',
  `LWFZDXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '列为发展对象日期',
  `ZBDHTGRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '支部大会通过日期',
  `SJZZPZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '上级组织批准日期',
  `SFZH` varchar(54) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '身份证号',
  `BLDJJZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '保留党籍截止日期',
  `RDRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '入党日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_ryjbxx_lw 数据已清理，仅保留表结构

-- 表结构: zz_ryjbxx_lw_2
DROP TABLE IF EXISTS `zz_ryjbxx_lw_2`;
CREATE TABLE `zz_ryjbxx_lw_2` (
  `LWRYJBXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RYZT` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SZDZBDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DWBM` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BMBM` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XM` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XB` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CSRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `JG` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MZ` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XWHCD` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZWMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZWJB` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XJSZWMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CJGZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CGCJLB` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CGCJYY` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CGCJRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `GZGW` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PXQK` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YXQK` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ1` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ2` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BZ3` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL04` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL05` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SQRDRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZZPYPXBZ` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `PYR` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZJPXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZJPXJG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LWJJFZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LWFZDXRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ZBDHTGRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SJZZPZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SFZH` varchar(54) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `BLDJJZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RDRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_ryjbxx_lw_2 数据已清理，仅保留表结构

-- 表结构: zz_ty_zzms
DROP TABLE IF EXISTS `zz_ty_zzms`;
CREATE TABLE `zz_ty_zzms` (
  `ID` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DZZDM` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `RYDM` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '秘书人员代码',
  `MKDM` decimal(65,30) DEFAULT NULL COMMENT '模块编码',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `XGSJ` datetime DEFAULT NULL COMMENT '修改时间',
  `CJRYDM` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人员代码',
  `XGRYDM` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人员代码',
  `SCBZ` decimal(65,30) DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='组织秘书配置表[原用于中心组学习秘书配置，抽调为组织责任人配置表，以标记的方式区分各个模块]';

-- 表 zz_ty_zzms 数据已清理，仅保留表结构

-- 表结构: zz_zzgxxx
DROP TABLE IF EXISTS `zz_zzgxxx`;
CREATE TABLE `zz_zzgxxx` (
  `ZZGXXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '组织关系信息标识',
  `RYBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员编码',
  `SZDZB` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '调离前所在党组织',
  `JRZBRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '进入支部日期',
  `JRZBLX` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '进入支部类型',
  `ZLZBRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '转离支部日期',
  `ZLZBLX` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专利支部类型',
  `SZDZBMC` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在党支部名称',
  `newDzzdm` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '调离后所在党组织',
  `userPartyChangeStatus` int DEFAULT NULL COMMENT '审核状态，字典表：UserPartyChangeStatus',
  `remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `auditRemark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '审核说明',
  `auditTime` datetime DEFAULT NULL COMMENT '审核时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_zzgxxx 数据已清理，仅保留表结构

-- 表结构: zz_zzjcxx
DROP TABLE IF EXISTS `zz_zzjcxx`;
CREATE TABLE `zz_zzjcxx` (
  `ZZJCXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '组织奖惩标识',
  `DZZDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `JCMC` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩名称',
  `JCSM` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩说明',
  `JCRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '奖惩日期',
  `PZJCDDZZ` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '批准奖惩的党组织',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_zzjcxx 数据已清理，仅保留表结构

-- 表结构: zz_zzqkxx
DROP TABLE IF EXISTS `zz_zzqkxx`;
CREATE TABLE `zz_zzqkxx` (
  `ZZQKXXBS` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '组织情况信息标识',
  `DZZDM` varchar(204) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织代码',
  `DZZMC` varchar(210) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党组织名称',
  `ZZLB` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织类别',
  `JCZZFL` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '基层组织分类',
  `JLDZZRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '三乘一体-党支部标识',
  `SCYTDZB` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结束评议日期',
  `KZPYRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '建立党组织日期',
  `JSPYRQ` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '开展评议日期',
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL04` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL05` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  KEY `ZZ_ZZQKXX_INDEX1` (`ZZQKXXBS`) USING BTREE,
  KEY `dzzdm_index` (`DZZDM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_zzqkxx 数据已清理，仅保留表结构

-- 表结构: zz_zzqkxxfb
DROP TABLE IF EXISTS `zz_zzqkxxfb`;
CREATE TABLE `zz_zzqkxxfb` (
  `DZZDM` varchar(68) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '党组织代码',
  `ZZLB` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织类别',
  `JCZZFL` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '基层组织分类',
  `ZGRS` decimal(8,0) DEFAULT NULL COMMENT '职工人数',
  `DXZZZBM` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党小组组长编码',
  `DXZZZMC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '党小组组长名称',
  `LDJTJC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '班子成员最大届次',
  `DYZS` decimal(8,0) DEFAULT NULL COMMENT '党员总数',
  PRIMARY KEY (`DZZDM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zz_zzqkxxfb 数据已清理，仅保留表结构

-- 表结构: zzzd_dwgzzfl
DROP TABLE IF EXISTS `zzzd_dwgzzfl`;
CREATE TABLE `zzzd_dwgzzfl` (
  `ZWBM` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职务编码：',
  `DWGZZLB` decimal(65,30) DEFAULT NULL,
  PRIMARY KEY (`ZWBM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_dwgzzfl 数据已清理，仅保留表结构

-- 表结构: zzzd_dwjlzzqk
DROP TABLE IF EXISTS `zzzd_dwjlzzqk`;
CREATE TABLE `zzzd_dwjlzzqk` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_dwjlzzqk 数据已清理，仅保留表结构

-- 表结构: zzzd_dwxzlb
DROP TABLE IF EXISTS `zzzd_dwxzlb`;
CREATE TABLE `zzzd_dwxzlb` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_dwxzlb 数据已清理，仅保留表结构

-- 表结构: zzzd_fbqk
DROP TABLE IF EXISTS `zzzd_fbqk`;
CREATE TABLE `zzzd_fbqk` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_fbqk 数据已清理，仅保留表结构

-- 表结构: zzzd_frdwbs
DROP TABLE IF EXISTS `zzzd_frdwbs`;
CREATE TABLE `zzzd_frdwbs` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_frdwbs 数据已清理，仅保留表结构

-- 表结构: zzzd_gzgw
DROP TABLE IF EXISTS `zzzd_gzgw`;
CREATE TABLE `zzzd_gzgw` (
  `BM` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` int DEFAULT NULL,
  `Y101` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Y102` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Y103` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_gzgw 数据已清理，仅保留表结构

-- 表结构: zzzd_jcmcdm
DROP TABLE IF EXISTS `zzzd_jcmcdm`;
CREATE TABLE `zzzd_jcmcdm` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_jcmcdm 数据已清理，仅保留表结构

-- 表结构: zzzd_jczzfl
DROP TABLE IF EXISTS `zzzd_jczzfl`;
CREATE TABLE `zzzd_jczzfl` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` int DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_jczzfl 数据已清理，仅保留表结构

-- 表结构: zzzd_jczzflnew
DROP TABLE IF EXISTS `zzzd_jczzflnew`;
CREATE TABLE `zzzd_jczzflnew` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '汉字名称',
  `XH` decimal(8,0) DEFAULT NULL COMMENT '序号',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留1',
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留2',
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留3',
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_jczzflnew 数据已清理，仅保留表结构

-- 表结构: zzzd_jjlx
DROP TABLE IF EXISTS `zzzd_jjlx`;
CREATE TABLE `zzzd_jjlx` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_jjlx 数据已清理，仅保留表结构

-- 表结构: zzzd_jszw
DROP TABLE IF EXISTS `zzzd_jszw`;
CREATE TABLE `zzzd_jszw` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '汉字名称',
  `XH` decimal(8,0) DEFAULT NULL COMMENT '序号',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留1',
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留2',
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留3',
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_jszw 数据已清理，仅保留表结构

-- 表结构: zzzd_lclb
DROP TABLE IF EXISTS `zzzd_lclb`;
CREATE TABLE `zzzd_lclb` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_lclb 数据已清理，仅保留表结构

-- 表结构: zzzd_lrlb
DROP TABLE IF EXISTS `zzzd_lrlb`;
CREATE TABLE `zzzd_lrlb` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_lrlb 数据已清理，仅保留表结构

-- 表结构: zzzd_pxdddm
DROP TABLE IF EXISTS `zzzd_pxdddm`;
CREATE TABLE `zzzd_pxdddm` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_pxdddm 数据已清理，仅保留表结构

-- 表结构: zzzd_pxjg
DROP TABLE IF EXISTS `zzzd_pxjg`;
CREATE TABLE `zzzd_pxjg` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_pxjg 数据已清理，仅保留表结构

-- 表结构: zzzd_pxmc
DROP TABLE IF EXISTS `zzzd_pxmc`;
CREATE TABLE `zzzd_pxmc` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `XH` decimal(65,30) NOT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_pxmc 数据已清理，仅保留表结构

-- 表结构: zzzd_pxxsdm
DROP TABLE IF EXISTS `zzzd_pxxsdm`;
CREATE TABLE `zzzd_pxxsdm` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_pxxsdm 数据已清理，仅保留表结构

-- 表结构: zzzd_pyjg
DROP TABLE IF EXISTS `zzzd_pyjg`;
CREATE TABLE `zzzd_pyjg` (
  `BM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_pyjg 数据已清理，仅保留表结构

-- 表结构: zzzd_qygm
DROP TABLE IF EXISTS `zzzd_qygm`;
CREATE TABLE `zzzd_qygm` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_qygm 数据已清理，仅保留表结构

-- 表结构: zzzd_qylx
DROP TABLE IF EXISTS `zzzd_qylx`;
CREATE TABLE `zzzd_qylx` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_qylx 数据已清理，仅保留表结构

-- 表结构: zzzd_ryzt
DROP TABLE IF EXISTS `zzzd_ryzt`;
CREATE TABLE `zzzd_ryzt` (
  `BM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` int DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_ryzt 数据已清理，仅保留表结构

-- 表结构: zzzd_rzfs
DROP TABLE IF EXISTS `zzzd_rzfs`;
CREATE TABLE `zzzd_rzfs` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` int DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_rzfs 数据已清理，仅保留表结构

-- 表结构: zzzd_scbzbs
DROP TABLE IF EXISTS `zzzd_scbzbs`;
CREATE TABLE `zzzd_scbzbs` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_scbzbs 数据已清理，仅保留表结构

-- 表结构: zzzd_wclx
DROP TABLE IF EXISTS `zzzd_wclx`;
CREATE TABLE `zzzd_wclx` (
  `BM` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_wclx 数据已清理，仅保留表结构

-- 表结构: zzzd_xjfsdm
DROP TABLE IF EXISTS `zzzd_xjfsdm`;
CREATE TABLE `zzzd_xjfsdm` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` int DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_xjfsdm 数据已清理，仅保留表结构

-- 表结构: zzzd_xzzw
DROP TABLE IF EXISTS `zzzd_xzzw`;
CREATE TABLE `zzzd_xzzw` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '汉字名称',
  `XH` decimal(8,0) DEFAULT NULL COMMENT '序号',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留1',
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留2',
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留3',
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_xzzw 数据已清理，仅保留表结构

-- 表结构: zzzd_zwmc
DROP TABLE IF EXISTS `zzzd_zwmc`;
CREATE TABLE `zzzd_zwmc` (
  `BM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` int DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_zwmc 数据已清理，仅保留表结构

-- 表结构: zzzd_zzjzqk
DROP TABLE IF EXISTS `zzzd_zzjzqk`;
CREATE TABLE `zzzd_zzjzqk` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '汉字名称',
  `XH` decimal(8,0) DEFAULT NULL COMMENT '序号',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留1',
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留2',
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留3',
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_zzjzqk 数据已清理，仅保留表结构

-- 表结构: zzzd_zzlbdm
DROP TABLE IF EXISTS `zzzd_zzlbdm`;
CREATE TABLE `zzzd_zzlbdm` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` int DEFAULT NULL,
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_zzlbdm 数据已清理，仅保留表结构

-- 表结构: zzzd_zzlbdmnew
DROP TABLE IF EXISTS `zzzd_zzlbdmnew`;
CREATE TABLE `zzzd_zzlbdmnew` (
  `BM` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '汉字名称',
  `XH` decimal(8,0) DEFAULT NULL COMMENT '序号',
  `YL01` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留1',
  `YL02` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留2',
  `YL03` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预留3',
  PRIMARY KEY (`BM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_zzlbdmnew 数据已清理，仅保留表结构

-- 表结构: zzzd_zzqk
DROP TABLE IF EXISTS `zzzd_zzqk`;
CREATE TABLE `zzzd_zzqk` (
  `BM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `HZMC` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `XH` decimal(65,30) DEFAULT NULL,
  `YL01` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL02` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `YL03` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- 表 zzzd_zzqk 数据已清理，仅保留表结构

