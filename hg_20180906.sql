-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ad_1f038b26493e3cf
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `datetime`
--

DROP TABLE IF EXISTS `datetime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `datetime` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datetime`
--

LOCK TABLES `datetime` WRITE;
/*!40000 ALTER TABLE `datetime` DISABLE KEYS */;
INSERT INTO `datetime` VALUES (1,'09/11/2018','00:10'),(2,'15/11/2018','00:09'),(3,'','00:10'),(4,'','00:10');
/*!40000 ALTER TABLE `datetime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guestinfo`
--

DROP TABLE IF EXISTS `guestinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `guestinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `noOfPax` varchar(45) DEFAULT NULL,
  `paxInfo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guestinfo`
--

LOCK TABLES `guestinfo` WRITE;
/*!40000 ALTER TABLE `guestinfo` DISABLE KEYS */;
INSERT INTO `guestinfo` VALUES (1,'2','1,2');
/*!40000 ALTER TABLE `guestinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hg`
--

DROP TABLE IF EXISTS `hg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hg` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `bookingId` varchar(45) DEFAULT NULL,
  `hotelDetails` varchar(45) DEFAULT NULL,
  `guestInfo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hg`
--

LOCK TABLES `hg` WRITE;
/*!40000 ALTER TABLE `hg` DISABLE KEYS */;
INSERT INTO `hg` VALUES (4,'AZRPM7646Q','1','1');
/*!40000 ALTER TABLE `hg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hotel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `starRate` varchar(45) DEFAULT NULL,
  `amenity` varchar(45) DEFAULT NULL,
  `hotelId` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `hotelCheckedIn` tinyint(1) DEFAULT NULL,
  `checkInRefId` varchar(45) DEFAULT NULL,
  `webCheckedIn` tinyint(1) DEFAULT NULL,
  `checkedOut` tinyint(1) DEFAULT NULL,
  `defaultCheckIn` varchar(45) DEFAULT NULL,
  `defaultCheckOut` varchar(45) DEFAULT NULL,
  `userCheckIn` varchar(45) DEFAULT NULL,
  `userCheckOut` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'5','WIFI,Pool,Spa,Parking,Restaurant','001','TAJ','Apollo Bunder Mumbai Maharashtra India 400 001','+91 22 6665 3366, +91 22 6665 0300','tmhbc.bom@tajhotels.com',0,'',0,0,'3','4','1','2');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `mainUser` tinyint(1) DEFAULT NULL,
  `initial` varchar(45) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `mname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `econtact` varchar(45) DEFAULT NULL,
  `others` varchar(45) DEFAULT NULL,
  `interest` varchar(45) DEFAULT NULL,
  `foodType` varchar(45) DEFAULT NULL,
  `maritalStatus` varchar(45) DEFAULT NULL,
  `religion` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'','Lionel','Andres','Messi','31','24/06/1987','Avinguda de Bellamar 08860 Castelldefels, Barcelona, Spain','+34 93 496 36 00','premsa@fcbarcelona.cat','','Football','Non-Veg','Married','Devout Catholic','leomessi@fcb.com','M','Cuccittini'),(2,1,'','Antonella','','Roccuzzo','30','26/02/1988','Avinguda de Bellamar 08860 Castelldefels, Barcelona, Spain','+34 93 496 36 00','premsa@fcbarcelona.cat','','Football','Non-Veg','Married','Devout Catholic','leomessi@fcb.com','F','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-06 10:34:19
