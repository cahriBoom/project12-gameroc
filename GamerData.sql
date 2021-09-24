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
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Raid','Destiny 2','PC','Vault of Glass raid in Master. 1330 light level min',6,5,3,'2021-08-12 09:55:17.683000','2021-09-30 09:55:17.683000',1,1),(2,'Ranked','Overwatch','PC','Ranked around 2500 SR',6,5,3,'2021-08-12 09:55:17.683000','2021-09-30 09:55:17.683000',2,2),(3,'PVP','Halo','Xbox','Doing some PVP. Come hang out',6,5,4,'2021-08-12 09:55:17.683000','2021-09-30 09:55:17.683000',5,1),(4,'Raid','Borderlands 3','PC','Farming Vermivorous',4,3,2,'2021-08-12 09:55:17.683000','2021-09-30 09:55:17.683000',3,4),(5,'GM Nightfall','Destiny 2','Playstation','Grand-Master Nightfalls, Need at least Anarchy and a good launcher',3,2,0,'2021-08-12 09:55:17.683000','2021-09-30 09:55:17.683000',6,6),(6,'PvP high ELO','Destiny 2','Playstation','2 players for Elimination with 1800 ELO minimum',3,2,2,'2021-08-09 14:38:09.548000','2021-09-30 09:55:17.683000',6,12),(7,'Pvp','Call of Duty','PC','pvp is good',6,5,3,'2021-08-18 09:55:17.683000','2021-09-30 09:55:17.683000',12,12);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_participants`
--

LOCK TABLES `event_participants` WRITE;
/*!40000 ALTER TABLE `event_participants` DISABLE KEYS */;
INSERT INTO `event_participants` VALUES (3,1),(3,5),(6,12),(7,12),(7,7),(7,7),(4,4),(4,13),(2,2),(2,12),(2,13),(1,1),(1,3),(1,12),(5,6),(5,7),(5,9);
/*!40000 ALTER TABLE `event_participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gamer`
--

LOCK TABLES `gamer` WRITE;
/*!40000 ALTER TABLE `gamer` DISABLE KEYS */;
INSERT INTO `gamer` VALUES (1,'magma21@gmail.com','Magmablood','GOOD',NULL,'PC','Europe',1,0),(2,'hunterflak@gmail.com','Flak','GOOD',NULL,'PC','Europe',1,0),(3,'Geronimo44@gmail.com','Geronimo','TOXIC',NULL,'PC','Europe',0,1),(4,'AlisterAll@gmail.com','Alister','NEW',NULL,'Playstation','Europe',0,0),(5,'GurlySis@gmail.com','Gurl','NEW',NULL,'Xbox','America',0,0),(6,'lilbeach@gmail.com','Lil-Beach','NEW',NULL,'Playstation','America',0,0),(7,'Seekerlol@gmail.com','Seeker','GOOD',NULL,'Playstation','America',1,0),(8,'Kilo31@gmail.com','Kilo','NEW',NULL,'Xbox','America',0,0),(9,'cahriboom@gmail.com','Cahri-Boom','NEW',NULL,'Playstation','Europe',0,0),(10,'freshman99@gmail.com','Freshman99','NEW','$2a$10$rEL7BhWafLqwLePO/k0/OehP/MbmEU3ScUFwARVPUSBskQDVK9DNW','Xbox','Europe',0,0),(12,'weiss@gmail.com','Weiss','GOOD','$2a$10$pC0XWdnC8b2G8dclhqUi/e1qxiwuRJvqnhxTmr4mAa8xMW64aCtUi','Xbox','Asia',3,1),(13,'tc@gg.fr','Tchuro','GOOD','$2a$10$ek0aL6de4YNsPe5nORiC0Ona65E/uZu4DMw0VxEqy9TDpUb0qfXju','Playstation','America',1,1);
/*!40000 ALTER TABLE `gamer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gamer_voted_for`
--

LOCK TABLES `gamer_voted_for` WRITE;
/*!40000 ALTER TABLE `gamer_voted_for` DISABLE KEYS */;
INSERT INTO `gamer_voted_for` VALUES (12,7),(12,2),(12,1),(12,3);
/*!40000 ALTER TABLE `gamer_voted_for` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `videogame`
--

LOCK TABLES `videogame` WRITE;
/*!40000 ALTER TABLE `videogame` DISABLE KEYS */;
INSERT INTO `videogame` VALUES (1,'Destiny 2','PC','none'),(2,'Overwatch','PC','none'),(3,'Borderlands 3','PC','none'),(4,'Call of Duty','Playstation','none'),(5,'Halo','Xbox','Xbox'),(6,'Destiny 2','Playstation','none'),(7,'Destiny 2','Xbox','none'),(8,'Overwatch','Playstation','none'),(9,'Overwatch','Xbox','none'),(10,'Borderlands 3','Playstation','none'),(11,'Borderlands 3','Xbox','none'),(12,'Call of Duty','PC','none'),(13,'Call of Duty','Xbox','none'),(14,'Minecraft','PC','PC');
/*!40000 ALTER TABLE `videogame` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2021-09-09 15:04:29
