-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `user_inventory`
--

DROP TABLE IF EXISTS `user_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_inventory` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `address` text NOT NULL,
  `district` varchar(50) NOT NULL,
  `thana` varchar(50) NOT NULL,
  `note` text,
  `cod_amount` decimal(10,2) NOT NULL,
  `invoice_amount` decimal(10,2) DEFAULT NULL,
  `quintity` decimal(6,2) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `deliverdby` varchar(45) DEFAULT NULL,
  `due_date` varchar(45) DEFAULT NULL,
  `deliverymanId` int DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `fk_product_id` (`product_id`) /*!80000 INVISIBLE */,
  KEY `fx_deliveryman_id` (`deliverymanId`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `productinventory` (`id`),
  CONSTRAINT `fx_deliveryman_id` FOREIGN KEY (`deliverymanId`) REFERENCES `role_login` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_inventory`
--

LOCK TABLES `user_inventory` WRITE;
/*!40000 ALTER TABLE `user_inventory` DISABLE KEYS */;
INSERT INTO `user_inventory` VALUES (12,'nasim','123','125','dhaka','dhaka','dhaka',400.00,350.00,2.00,'delivered','2025-05-23',6,9,'sajin','5',12),(13,'akash','52','dsfs','d','d','d',800.00,600.00,2.00,'delivered','2025-05-23',7,9,'jisan','3',11),(14,'nasim','dfs','dsdf','d','d','d',500.00,400.00,3.00,'Pending','2025-05-23',8,10,'jisan','2',11);
/*!40000 ALTER TABLE `user_inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-25 15:43:13
