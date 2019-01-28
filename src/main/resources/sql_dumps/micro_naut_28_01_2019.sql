-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.18-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for micro-naut
CREATE DATABASE IF NOT EXISTS `micro-naut` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `micro-naut`;

-- Dumping structure for table micro-naut.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` tinyint(4) NOT NULL,
  `editable` tinyint(4) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `expired` tinyint(4) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `editable_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4tcq3sp8l7ujj0a6xgnkreffp` (`editable_by`),
  KEY `FKa5cffmyctb0862coj304faenx` (`updated_by`),
  CONSTRAINT `FK4tcq3sp8l7ujj0a6xgnkreffp` FOREIGN KEY (`editable_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa5cffmyctb0862coj304faenx` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table micro-naut.role: ~6 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`id`, `created_on`, `updated_on`, `deleted`, `editable`, `enabled`, `expired`, `role_name`, `editable_by`, `updated_by`) VALUES
	(1, '2019-01-25 08:40:57', '2019-01-27 19:51:04', 0, 0, 0, 0, 'SYSTEM', NULL, 1),
	(2, '2019-01-25 08:40:57', '2019-01-27 19:51:30', 0, 0, 0, 0, 'SUPER_ADMIN', NULL, 1),
	(3, '2019-01-25 08:40:57', '2019-01-27 19:51:30', 0, 0, 0, 0, 'ADMIN', NULL, 1),
	(4, '2019-01-25 08:40:57', '2019-01-27 19:51:30', 0, 0, 0, 0, 'AUDITOR', NULL, 1),
	(5, '2019-01-25 08:40:57', '2019-01-27 19:51:30', 0, 0, 0, 0, 'GUEST', NULL, 1),
	(6, '2019-01-25 08:40:57', '2019-01-27 19:51:30', 0, 0, 0, 0, 'USER', NULL, 1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table micro-naut.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `check_password_history` tinyint(4) NOT NULL,
  `deleted` tinyint(4) NOT NULL,
  `editable` tinyint(4) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `expired` tinyint(4) NOT NULL,
  `locked` tinyint(4) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `verified` tinyint(4) NOT NULL,
  `editable_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `role` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FKcgd2aulpttna6xd7stkct6kga` (`editable_by`),
  KEY `FK2a54xhceitopkkw1hlo3tkv3i` (`updated_by`),
  KEY `FKl5alypubd40lwejc45vl35wjb` (`role`),
  CONSTRAINT `FK2a54xhceitopkkw1hlo3tkv3i` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FKcgd2aulpttna6xd7stkct6kga` FOREIGN KEY (`editable_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FKl5alypubd40lwejc45vl35wjb` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table micro-naut.user: ~5 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `username`, `created_on`, `updated_on`, `check_password_history`, `deleted`, `editable`, `enabled`, `expired`, `locked`, `password`, `verified`, `editable_by`, `updated_by`, `role`) VALUES
	(1, 'system', '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 1, 0, 0, '$2a$10$4AywUVWKTuxbiT.vV3.vSOel4rEOWQZ5Opv0MUL7y0MbX48DkeL5q', 1, NULL, NULL, 1),
	(2, 'super-admin', '2019-01-25 21:39:24', '2019-01-26 01:40:48', 0, 0, 0, 1, 0, 0, '$2a$10$2foDdcygEaI4d7XvX2P.quZ1DjUVovdDFYu1NcZWDL1vxkcIaFiDa', 1, NULL, 1, 2),
	(3, 'admin', '2019-01-25 21:39:24', '2019-01-26 01:40:48', 0, 0, 0, 1, 0, 0, '$2a$10$YI9x2VDsz8DpcY20dbJXC.QbpudxDqAKJyCmUO4Hctug0QANbckZa', 1, NULL, 1, 3),
	(4, 'test', '2019-01-27 20:42:32', '2019-01-27 20:42:32', 0, 0, 0, 0, 0, 0, '$2a$10$0BRysuUbKyO8xZDl6SgqG.FiUQvRs92R0ftLoTPdO0CXceAlxmvnu', 0, NULL, NULL, 6);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
