-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ocgamer
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id_event` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `vgname` varchar(255) DEFAULT NULL,
  `plateform` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `maximum_players` int NOT NULL,
  `player_needed` int NOT NULL,
  `spots` int NOT NULL,
  `debut` datetime(6) DEFAULT NULL,
  `fin` datetime(6) DEFAULT NULL,
  `videogame_id_videogame` int DEFAULT NULL,
  `host_id_gamer` int DEFAULT NULL,
  PRIMARY KEY (`id_event`),
  KEY `FK4tuy9h4l91jtfj9734cs0lmcu` (`videogame_id_videogame`),
  KEY `FKlrwdpta5p5mofuq3vewaqqvab` (`host_id_gamer`),
  CONSTRAINT `FK4tuy9h4l91jtfj9734cs0lmcu` FOREIGN KEY (`videogame_id_videogame`) REFERENCES `videogame` (`id_videogame`),
  CONSTRAINT `FKlrwdpta5p5mofuq3vewaqqvab` FOREIGN KEY (`host_id_gamer`) REFERENCES `gamer` (`id_gamer`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `event_participants`
--

DROP TABLE IF EXISTS `event_participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_participants` (
  `event_id_event` int NOT NULL,
  `participants_id_gamer` int NOT NULL,
  KEY `FKy2kx86apb69ftpxb2d3pl8ca` (`participants_id_gamer`),
  KEY `FKadf74iluh48qk7gwkavahus7r` (`event_id_event`),
  CONSTRAINT `FKadf74iluh48qk7gwkavahus7r` FOREIGN KEY (`event_id_event`) REFERENCES `event` (`id_event`),
  CONSTRAINT `FKy2kx86apb69ftpxb2d3pl8ca` FOREIGN KEY (`participants_id_gamer`) REFERENCES `gamer` (`id_gamer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `gamer`
--

DROP TABLE IF EXISTS `gamer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gamer` (
  `id_gamer` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `gamertag` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `plateform` varchar(255) DEFAULT NULL,
  `server` varchar(255) DEFAULT NULL,
  `good_rating` int NOT NULL,
  `bad_rating` int NOT NULL,
  PRIMARY KEY (`id_gamer`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `gamer_voted_for`
--

DROP TABLE IF EXISTS `gamer_voted_for`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gamer_voted_for` (
  `gamer_id_gamer` int NOT NULL,
  `voted_for_id_gamer` int NOT NULL,
  KEY `FKn19tbuw8b1ltfsmctmwoev7l` (`voted_for_id_gamer`),
  KEY `FKhkyaa07j7tugyu654gkhisq2f` (`gamer_id_gamer`),
  CONSTRAINT `FKhkyaa07j7tugyu654gkhisq2f` FOREIGN KEY (`gamer_id_gamer`) REFERENCES `gamer` (`id_gamer`),
  CONSTRAINT `FKn19tbuw8b1ltfsmctmwoev7l` FOREIGN KEY (`voted_for_id_gamer`) REFERENCES `gamer` (`id_gamer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `videogame`
--

DROP TABLE IF EXISTS `videogame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videogame` (
  `id_videogame` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `plateform` varchar(255) DEFAULT NULL,
  `exclusive` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_videogame`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'ocgamer'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-09 15:03:58
