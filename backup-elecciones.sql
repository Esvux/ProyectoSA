-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: elecciones
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `SEQUENCE`
--

DROP TABLE IF EXISTS `SEQUENCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEQUENCE`
--

LOCK TABLES `SEQUENCE` WRITE;
/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;
INSERT INTO `SEQUENCE` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centro_votacion`
--

DROP TABLE IF EXISTS `centro_votacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centro_votacion` (
  `id_centro` int(11) NOT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `extra_direccion` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `id_municipio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_centro`),
  KEY `FK_centro_votacion_id_municipio` (`id_municipio`),
  CONSTRAINT `FK_centro_votacion_id_municipio` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centro_votacion`
--

LOCK TABLES `centro_votacion` WRITE;
/*!40000 ALTER TABLE `centro_votacion` DISABLE KEYS */;
INSERT INTO `centro_votacion` VALUES (1,'Algún lugar de Chahal','más...','Centro de votación de Chahal',1),(2,'Algún lugar de Lanquín','más...','Centro de votación de Lanquín',2),(3,'Algún lugar de San Juan Chamelco','más...','Centro de votación de San Juan Chamelco',3),(4,'Algún lugar de Santa María Cahabón','más...','Centro de votación de Santa María Cahabón',4),(5,'Algún lugar de Tucurú','más...','Centro de votación de Tucurú',5),(6,'Algún lugar de Chisec','más...','Centro de votación de Chisec',6),(7,'Algún lugar de Panzós','más...','Centro de votación de Panzós',7),(8,'Algún lugar de San Pedro Carchá','más...','Centro de votación de San Pedro Carchá',8),(9,'Algún lugar de Senahú','más...','Centro de votación de Senahú',9),(10,'Algún lugar de Cobán','más...','Centro de votación de Cobán',10),(11,'Algún lugar de Raxruhá','más...','Centro de votación de Raxruhá',11),(12,'Algún lugar de Santa Catalina La Tinta','más...','Centro de votación de Santa Catalina La Tinta',12),(13,'Algún lugar de Tactic','más...','Centro de votación de Tactic',13),(14,'Algún lugar de Fray Bartolomé de las Casas','más...','Centro de votación de Fray Bartolomé de las Casas',14),(15,'Algún lugar de San Cristóbal Verapaz','más...','Centro de votación de San Cristóbal Verapaz',15),(16,'Algún lugar de Santa Cruz Verapaz','más...','Centro de votación de Santa Cruz Verapaz',16),(17,'Algún lugar de Tamahú','más...','Centro de votación de Tamahú',17),(18,'Algún lugar de Cubulco','más...','Centro de votación de Cubulco',18),(19,'Algún lugar de Salamá','más...','Centro de votación de Salamá',19),(20,'Algún lugar de Granados','más...','Centro de votación de Granados',20),(21,'Algún lugar de San Jerónimo','más...','Centro de votación de San Jerónimo',21),(22,'Algún lugar de Purulhá','más...','Centro de votación de Purulhá',22),(23,'Algún lugar de San Miguel Chicaj','más...','Centro de votación de San Miguel Chicaj',23),(24,'Algún lugar de Rabinal','más...','Centro de votación de Rabinal',24),(25,'Algún lugar de Santa Cruz el Chol','más...','Centro de votación de Santa Cruz el Chol',25),(26,'Algún lugar de Acatenango','más...','Centro de votación de Acatenango',26),(27,'Algún lugar de Patzicía','más...','Centro de votación de Patzicía',27),(28,'Algún lugar de San José Poaquil','más...','Centro de votación de San José Poaquil',28),(29,'Algún lugar de Santa Cruz Balanyá','más...','Centro de votación de Santa Cruz Balanyá',29),(30,'Algún lugar de Chimaltenango','más...','Centro de votación de Chimaltenango',30),(31,'Algún lugar de Patzún','más...','Centro de votación de Patzún',31),(32,'Algún lugar de San Juan Comalapa','más...','Centro de votación de San Juan Comalapa',32),(33,'Algún lugar de Tecpán','más...','Centro de votación de Tecpán',33),(34,'Algún lugar de El Tejar','más...','Centro de votación de El Tejar',34),(35,'Algún lugar de Pochuta','más...','Centro de votación de Pochuta',35),(36,'Algún lugar de San Martín Jilotepeque','más...','Centro de votación de San Martín Jilotepeque',36),(37,'Algún lugar de Yepocapa','más...','Centro de votación de Yepocapa',37),(38,'Algún lugar de Parramos','más...','Centro de votación de Parramos',38),(39,'Algún lugar de San Andrés Itzapa','más...','Centro de votación de San Andrés Itzapa',39),(40,'Algún lugar de Santa Apolonia','más...','Centro de votación de Santa Apolonia',40),(41,'Algún lugar de Zaragoza','más...','Centro de votación de Zaragoza',41),(42,'Algún lugar de Camotán','más...','Centro de votación de Camotán',42),(43,'Algún lugar de Ipala','más...','Centro de votación de Ipala',43),(44,'Algún lugar de San Jacinto','más...','Centro de votación de San Jacinto',44),(45,'Algún lugar de Chiquimula','más...','Centro de votación de Chiquimula',45),(46,'Algún lugar de Jocotán','más...','Centro de votación de Jocotán',46),(47,'Algún lugar de San José La Arada','más...','Centro de votación de San José La Arada',47),(48,'Algún lugar de Concepción Las Minas','más...','Centro de votación de Concepción Las Minas',48),(49,'Algún lugar de Olopa','más...','Centro de votación de Olopa',49),(50,'Algún lugar de San Juan Ermita','más...','Centro de votación de San Juan Ermita',50),(51,'Algún lugar de Esquipulas','más...','Centro de votación de Esquipulas',51),(52,'Algún lugar de Quezaltepeque','más...','Centro de votación de Quezaltepeque',52),(53,'Algún lugar de El Jícaro','más...','Centro de votación de El Jícaro',53),(54,'Algún lugar de San Antonio La Paz','más...','Centro de votación de San Antonio La Paz',54),(55,'Algún lugar de Guastatoya','más...','Centro de votación de Guastatoya',55),(56,'Algún lugar de San Cristóbal Acasaguastlán','más...','Centro de votación de San Cristóbal Acasaguastlán',56),(57,'Algún lugar de Morazán','más...','Centro de votación de Morazán',57),(58,'Algún lugar de Sanarate','más...','Centro de votación de Sanarate',58),(59,'Algún lugar de San Agustín Acasaguastlán','más...','Centro de votación de San Agustín Acasaguastlán',59),(60,'Algún lugar de Sansare','más...','Centro de votación de Sansare',60),(61,'Algún lugar de Escuintla','más...','Centro de votación de Escuintla',61),(62,'Algún lugar de La Gomera','más...','Centro de votación de La Gomera',62),(63,'Algún lugar de San José','más...','Centro de votación de San José',63),(64,'Algún lugar de Tiquisate','más...','Centro de votación de Tiquisate',64),(65,'Algún lugar de Guanagazapa','más...','Centro de votación de Guanagazapa',65),(66,'Algún lugar de Masagua','más...','Centro de votación de Masagua',66),(67,'Algún lugar de San Vicente Pacaya','más...','Centro de votación de San Vicente Pacaya',67),(68,'Algún lugar de Iztapa','más...','Centro de votación de Iztapa',68),(69,'Algún lugar de Nueva Concepción','más...','Centro de votación de Nueva Concepción',69),(70,'Algún lugar de Santa Lucía Cotzumalguapa','más...','Centro de votación de Santa Lucía Cotzumalguapa',70),(71,'Algún lugar de La Democracia','más...','Centro de votación de La Democracia',71),(72,'Algún lugar de Palín','más...','Centro de votación de Palín',72),(73,'Algún lugar de Siquinalá','más...','Centro de votación de Siquinalá',73),(74,'Algún lugar de Amatitlán','más...','Centro de votación de Amatitlán',74),(75,'Algún lugar de Guatemala','más...','Centro de votación de Guatemala',75),(76,'Algún lugar de San José Pinula','más...','Centro de votación de San José Pinula',76),(77,'Algún lugar de San Pedro Sacatepéquez','más...','Centro de votación de San Pedro Sacatepéquez',77),(78,'Algún lugar de Villa Nueva','más...','Centro de votación de Villa Nueva',78),(79,'Algún lugar de Chinautla','más...','Centro de votación de Chinautla',79),(80,'Algún lugar de Mixco','más...','Centro de votación de Mixco',80),(81,'Algún lugar de San Juan Sacatepéquez','más...','Centro de votación de San Juan Sacatepéquez',81),(82,'Algún lugar de San Raymundo','más...','Centro de votación de San Raymundo',82),(83,'Algún lugar de Chuarrancho','más...','Centro de votación de Chuarrancho',83),(84,'Algún lugar de Palencia','más...','Centro de votación de Palencia',84),(85,'Algún lugar de San Miguel Petapa','más...','Centro de votación de San Miguel Petapa',85),(86,'Algún lugar de Santa Catarina Pinula','más...','Centro de votación de Santa Catarina Pinula',86),(87,'Algún lugar de Fraijanes','más...','Centro de votación de Fraijanes',87),(88,'Algún lugar de San José del Golfo','más...','Centro de votación de San José del Golfo',88),(89,'Algún lugar de San Pedro Ayampuc','más...','Centro de votación de San Pedro Ayampuc',89),(90,'Algún lugar de Villa Canales','más...','Centro de votación de Villa Canales',90),(91,'Algún lugar de Aguacatán','más...','Centro de votación de Aguacatán',91),(92,'Algún lugar de Cuilco','más...','Centro de votación de Cuilco',92),(93,'Algún lugar de La Libertad','más...','Centro de votación de La Libertad',93),(94,'Algún lugar de San Gaspar Ixchil','más...','Centro de votación de San Gaspar Ixchil',94),(95,'Algún lugar de San Mateo Ixtatán','más...','Centro de votación de San Mateo Ixtatán',95),(96,'Algún lugar de San Rafael La Independencia','más...','Centro de votación de San Rafael La Independencia',96),(97,'Algún lugar de Santa Ana Huista','más...','Centro de votación de Santa Ana Huista',97),(98,'Algún lugar de Santiago Chimaltenango','más...','Centro de votación de Santiago Chimaltenango',98),(99,'Algún lugar de Chiantla','más...','Centro de votación de Chiantla',99),(100,'Algún lugar de Huehuetenango','más...','Centro de votación de Huehuetenango',100),(101,'Algún lugar de Malacatancito','más...','Centro de votación de Malacatancito',101),(102,'Algún lugar de San Ildefonso Ixtahuacán','más...','Centro de votación de San Ildefonso Ixtahuacán',102),(103,'Algún lugar de San Miguel Acatán','más...','Centro de votación de San Miguel Acatán',103),(104,'Algún lugar de San Rafael Petzal','más...','Centro de votación de San Rafael Petzal',104),(105,'Algún lugar de Santa Bárbara','más...','Centro de votación de Santa Bárbara',105),(106,'Algún lugar de Tectitán','más...','Centro de votación de Tectitán',106),(107,'Algún lugar de Colotenango','más...','Centro de votación de Colotenango',107),(108,'Algún lugar de Jacaltenango','más...','Centro de votación de Jacaltenango',108),(109,'Algún lugar de Nentón','más...','Centro de votación de Nentón',109),(110,'Algún lugar de San Juan Atitán','más...','Centro de votación de San Juan Atitán',110),(111,'Algún lugar de San Pedro Necta','más...','Centro de votación de San Pedro Necta',111),(112,'Algún lugar de San Sebastián Coatán','más...','Centro de votación de San Sebastián Coatán',112),(113,'Algún lugar de Santa Cruz Barillas','más...','Centro de votación de Santa Cruz Barillas',113),(114,'Algún lugar de Todos Santos Cuchumatánes','más...','Centro de votación de Todos Santos Cuchumatánes',114),(115,'Algún lugar de Concepción Huista','más...','Centro de votación de Concepción Huista',115),(116,'Algún lugar de La Democracia','más...','Centro de votación de La Democracia',116),(117,'Algún lugar de San Antonio Huista','más...','Centro de votación de San Antonio Huista',117),(118,'Algún lugar de San Juan Ixcoy','más...','Centro de votación de San Juan Ixcoy',118),(119,'Algún lugar de San Pedro Soloma','más...','Centro de votación de San Pedro Soloma',119),(120,'Algún lugar de San Sebastián','más...','Centro de votación de San Sebastián',120),(121,'Algún lugar de Santa Eulalia','más...','Centro de votación de Santa Eulalia',121),(122,'Algún lugar de Unión Cantinil','más...','Centro de votación de Unión Cantinil',122),(123,'Algún lugar de El Estor','más...','Centro de votación de El Estor',123),(124,'Algún lugar de Puerto Barrios','más...','Centro de votación de Puerto Barrios',124),(125,'Algún lugar de Livingston','más...','Centro de votación de Livingston',125),(126,'Algún lugar de Los Amates','más...','Centro de votación de Los Amates',126),(127,'Algún lugar de Morales','más...','Centro de votación de Morales',127),(128,'Algún lugar de Jalapa','más...','Centro de votación de Jalapa',128),(129,'Algún lugar de San Luis Jilotepeque','más...','Centro de votación de San Luis Jilotepeque',129),(130,'Algún lugar de Mataquescuintla','más...','Centro de votación de Mataquescuintla',130),(131,'Algún lugar de San Manuel Chaparrón','más...','Centro de votación de San Manuel Chaparrón',131),(132,'Algún lugar de Monjas','más...','Centro de votación de Monjas',132),(133,'Algún lugar de San Pedro Pinula','más...','Centro de votación de San Pedro Pinula',133),(134,'Algún lugar de San Carlos Alzatate','más...','Centro de votación de San Carlos Alzatate',134),(135,'Algún lugar de Agua Blanca','más...','Centro de votación de Agua Blanca',135),(136,'Algún lugar de Conguaco','más...','Centro de votación de Conguaco',136),(137,'Algún lugar de Jerez','más...','Centro de votación de Jerez',137),(138,'Algún lugar de Quesada','más...','Centro de votación de Quesada',138),(139,'Algún lugar de Zapotitlán','más...','Centro de votación de Zapotitlán',139),(140,'Algún lugar de Asunción Mita','más...','Centro de votación de Asunción Mita',140),(141,'Algún lugar de El Adelanto','más...','Centro de votación de El Adelanto',141),(142,'Algún lugar de Jutiapa','más...','Centro de votación de Jutiapa',142),(143,'Algún lugar de San José Acatempa','más...','Centro de votación de San José Acatempa',143),(144,'Algún lugar de Atescatempa','más...','Centro de votación de Atescatempa',144),(145,'Algún lugar de El Progreso','más...','Centro de votación de El Progreso',145),(146,'Algún lugar de Moyuta','más...','Centro de votación de Moyuta',146),(147,'Algún lugar de Santa Catarina Mita','más...','Centro de votación de Santa Catarina Mita',147),(148,'Algún lugar de Comapa','más...','Centro de votación de Comapa',148),(149,'Algún lugar de Jalpatagua','más...','Centro de votación de Jalpatagua',149),(150,'Algún lugar de Pasaco','más...','Centro de votación de Pasaco',150),(151,'Algún lugar de Yupiltepeque','más...','Centro de votación de Yupiltepeque',151),(152,'Algún lugar de Dolores','más...','Centro de votación de Dolores',152),(153,'Algún lugar de Melchor de Mencos','más...','Centro de votación de Melchor de Mencos',153),(154,'Algún lugar de San Francisco','más...','Centro de votación de San Francisco',154),(155,'Algún lugar de Sayaxché','más...','Centro de votación de Sayaxché',155),(156,'Algún lugar de Flores','más...','Centro de votación de Flores',156),(157,'Algún lugar de Poptún','más...','Centro de votación de Poptún',157),(158,'Algún lugar de San José','más...','Centro de votación de San José',158),(159,'Algún lugar de La Libertad','más...','Centro de votación de La Libertad',159),(160,'Algún lugar de San Andrés','más...','Centro de votación de San Andrés',160),(161,'Algún lugar de San Luis','más...','Centro de votación de San Luis',161),(162,'Algún lugar de Las Cruces','más...','Centro de votación de Las Cruces',162),(163,'Algún lugar de San Benito','más...','Centro de votación de San Benito',163),(164,'Algún lugar de Santa Ana','más...','Centro de votación de Santa Ana',164),(165,'Algún lugar de Almolonga','más...','Centro de votación de Almolonga',165),(166,'Algún lugar de Coatepeque','más...','Centro de votación de Coatepeque',166),(167,'Algún lugar de Flores Costa Cuca','más...','Centro de votación de Flores Costa Cuca',167),(168,'Algún lugar de Olintepeque','más...','Centro de votación de Olintepeque',168),(169,'Algún lugar de San Carlos Sija','más...','Centro de votación de San Carlos Sija',169),(170,'Algún lugar de San Mateo','más...','Centro de votación de San Mateo',170),(171,'Algún lugar de Cabricán','más...','Centro de votación de Cabricán',171),(172,'Algún lugar de Colomba','más...','Centro de votación de Colomba',172),(173,'Algún lugar de Génova','más...','Centro de votación de Génova',173),(174,'Algún lugar de Palestina de Los Altos','más...','Centro de votación de Palestina de Los Altos',174),(175,'Algún lugar de San Francisco La Unión','más...','Centro de votación de San Francisco La Unión',175),(176,'Algún lugar de San Miguel Sigüilá','más...','Centro de votación de San Miguel Sigüilá',176),(177,'Algún lugar de Cajolá','más...','Centro de votación de Cajolá',177),(178,'Algún lugar de Concepción Chiquirichapa','más...','Centro de votación de Concepción Chiquirichapa',178),(179,'Algún lugar de Huitán','más...','Centro de votación de Huitán',179),(180,'Algún lugar de Quetzaltenango','más...','Centro de votación de Quetzaltenango',180),(181,'Algún lugar de San Juan Ostuncalco','más...','Centro de votación de San Juan Ostuncalco',181),(182,'Algún lugar de Sibilia','más...','Centro de votación de Sibilia',182),(183,'Algún lugar de Cantel','más...','Centro de votación de Cantel',183),(184,'Algún lugar de El Palmar','más...','Centro de votación de El Palmar',184),(185,'Algún lugar de La Esperanza','más...','Centro de votación de La Esperanza',185),(186,'Algún lugar de Salcajá','más...','Centro de votación de Salcajá',186),(187,'Algún lugar de San Martín Sacatepéquez','más...','Centro de votación de San Martín Sacatepéquez',187),(188,'Algún lugar de Zunil','más...','Centro de votación de Zunil',188),(189,'Algún lugar de Canillá','más...','Centro de votación de Canillá',189),(190,'Algún lugar de Chichicastenango','más...','Centro de votación de Chichicastenango',190),(191,'Algún lugar de Joyabaj','más...','Centro de votación de Joyabaj',191),(192,'Algún lugar de Sacapulas','más...','Centro de votación de Sacapulas',192),(193,'Algún lugar de San Juan Cotzal','más...','Centro de votación de San Juan Cotzal',193),(194,'Algún lugar de Zacualpa','más...','Centro de votación de Zacualpa',194),(195,'Algún lugar de Chajul','más...','Centro de votación de Chajul',195),(196,'Algún lugar de Chinique','más...','Centro de votación de Chinique',196),(197,'Algún lugar de Nebaj','más...','Centro de votación de Nebaj',197),(198,'Algún lugar de San Andrés Sajcabajá','más...','Centro de votación de San Andrés Sajcabajá',198),(199,'Algún lugar de San Pedro Jocopilas','más...','Centro de votación de San Pedro Jocopilas',199),(200,'Algún lugar de Chicamán','más...','Centro de votación de Chicamán',200),(201,'Algún lugar de Cunén','más...','Centro de votación de Cunén',201),(202,'Algún lugar de Pachalum','más...','Centro de votación de Pachalum',202),(203,'Algún lugar de San Antonio Ilotenango','más...','Centro de votación de San Antonio Ilotenango',203),(204,'Algún lugar de Santa Cruz del Quiché','más...','Centro de votación de Santa Cruz del Quiché',204),(205,'Algún lugar de Chiché','más...','Centro de votación de Chiché',205),(206,'Algún lugar de Ixcán','más...','Centro de votación de Ixcán',206),(207,'Algún lugar de Patzité','más...','Centro de votación de Patzité',207),(208,'Algún lugar de San Bartolomé Jocotenango','más...','Centro de votación de San Bartolomé Jocotenango',208),(209,'Algún lugar de Uspantán','más...','Centro de votación de Uspantán',209),(210,'Algún lugar de Champerico','más...','Centro de votación de Champerico',210),(211,'Algún lugar de San Andrés Villa Seca','más...','Centro de votación de San Andrés Villa Seca',211),(212,'Algún lugar de Santa Cruz Muluá','más...','Centro de votación de Santa Cruz Muluá',212),(213,'Algún lugar de El Asintal','más...','Centro de votación de El Asintal',213),(214,'Algún lugar de San Felipe','más...','Centro de votación de San Felipe',214),(215,'Algún lugar de Nuevo San Carlos','más...','Centro de votación de Nuevo San Carlos',215),(216,'Algún lugar de San Martín Zapotitlán','más...','Centro de votación de San Martín Zapotitlán',216),(217,'Algún lugar de Retalhuleu','más...','Centro de votación de Retalhuleu',217),(218,'Algún lugar de San Sebastián','más...','Centro de votación de San Sebastián',218),(219,'Algún lugar de Alotenango','más...','Centro de votación de Alotenango',219),(220,'Algún lugar de Magdalena Milpas Altas','más...','Centro de votación de Magdalena Milpas Altas',220),(221,'Algún lugar de San Lucas Sacatepéquez','más...','Centro de votación de San Lucas Sacatepéquez',221),(222,'Algún lugar de Santa María de Jesús','más...','Centro de votación de Santa María de Jesús',222),(223,'Algún lugar de La Antigua Guatemala','más...','Centro de votación de La Antigua Guatemala',223),(224,'Algún lugar de Pastores','más...','Centro de votación de Pastores',224),(225,'Algún lugar de San Miguel Dueñas','más...','Centro de votación de San Miguel Dueñas',225),(226,'Algún lugar de Santiago Sacatepéquez','más...','Centro de votación de Santiago Sacatepéquez',226),(227,'Algún lugar de Ciudad Vieja','más...','Centro de votación de Ciudad Vieja',227),(228,'Algún lugar de San Antonio Aguas Calientes','más...','Centro de votación de San Antonio Aguas Calientes',228),(229,'Algún lugar de Santa Catarina Barahona','más...','Centro de votación de Santa Catarina Barahona',229),(230,'Algún lugar de Santo Domingo Xenacoj','más...','Centro de votación de Santo Domingo Xenacoj',230),(231,'Algún lugar de Jocotenango','más...','Centro de votación de Jocotenango',231),(232,'Algún lugar de San Bartolomé Milpas Altas','más...','Centro de votación de San Bartolomé Milpas Altas',232),(233,'Algún lugar de Santa Lucía Milpas Altas','más...','Centro de votación de Santa Lucía Milpas Altas',233),(234,'Algún lugar de Sumpango','más...','Centro de votación de Sumpango',234),(235,'Algún lugar de Ayutla','más...','Centro de votación de Ayutla',235),(236,'Algún lugar de El Quetzal','más...','Centro de votación de El Quetzal',236),(237,'Algún lugar de Ixchiguán','más...','Centro de votación de Ixchiguán',237),(238,'Algún lugar de Ocós','más...','Centro de votación de Ocós',238),(239,'Algún lugar de San Cristóbal Cucho','más...','Centro de votación de San Cristóbal Cucho',239),(240,'Algún lugar de San Miguel Ixtahuacán','más...','Centro de votación de San Miguel Ixtahuacán',240),(241,'Algún lugar de Sibinal','más...','Centro de votación de Sibinal',241),(242,'Algún lugar de Tejutla','más...','Centro de votación de Tejutla',242),(243,'Algún lugar de Catarina','más...','Centro de votación de Catarina',243),(244,'Algún lugar de El Rodeo','más...','Centro de votación de El Rodeo',244),(245,'Algún lugar de La Reforma','más...','Centro de votación de La Reforma',245),(246,'Algún lugar de Pajapita','más...','Centro de votación de Pajapita',246),(247,'Algún lugar de San José Ojetenam','más...','Centro de votación de San José Ojetenam',247),(248,'Algún lugar de San Pablo','más...','Centro de votación de San Pablo',248),(249,'Algún lugar de Sipacapa','más...','Centro de votación de Sipacapa',249),(250,'Algún lugar de Comitancillo','más...','Centro de votación de Comitancillo',250),(251,'Algún lugar de El Tumbador','más...','Centro de votación de El Tumbador',251),(252,'Algún lugar de Malacatán','más...','Centro de votación de Malacatán',252),(253,'Algún lugar de Río Blanco','más...','Centro de votación de Río Blanco',253),(254,'Algún lugar de San Lorenzo','más...','Centro de votación de San Lorenzo',254),(255,'Algún lugar de San Pedro Sacatepéquez','más...','Centro de votación de San Pedro Sacatepéquez',255),(256,'Algún lugar de Tacaná','más...','Centro de votación de Tacaná',256),(257,'Algún lugar de Concepción Tutuapa','más...','Centro de votación de Concepción Tutuapa',257),(258,'Algún lugar de Esquipulas Palo Gordo','más...','Centro de votación de Esquipulas Palo Gordo',258),(259,'Algún lugar de Nuevo Progreso','más...','Centro de votación de Nuevo Progreso',259),(260,'Algún lugar de San Antonio Sacatepéquez','más...','Centro de votación de San Antonio Sacatepéquez',260),(261,'Algún lugar de San Marcos','más...','Centro de votación de San Marcos',261),(262,'Algún lugar de San Rafael Pie de La Cuesta','más...','Centro de votación de San Rafael Pie de La Cuesta',262),(263,'Algún lugar de Tajumulco','más...','Centro de votación de Tajumulco',263),(264,'Algún lugar de Barberena','más...','Centro de votación de Barberena',264),(265,'Algún lugar de Guazacapán','más...','Centro de votación de Guazacapán',265),(266,'Algún lugar de San Juan Tecuaco','más...','Centro de votación de San Juan Tecuaco',266),(267,'Algún lugar de Santa Rosa de Lima','más...','Centro de votación de Santa Rosa de Lima',267),(268,'Algún lugar de Casillas','más...','Centro de votación de Casillas',268),(269,'Algún lugar de Nueva Santa Rosa','más...','Centro de votación de Nueva Santa Rosa',269),(270,'Algún lugar de San Rafaél Las Flores','más...','Centro de votación de San Rafaél Las Flores',270),(271,'Algún lugar de Taxisco','más...','Centro de votación de Taxisco',271),(272,'Algún lugar de Chiquimulilla','más...','Centro de votación de Chiquimulilla',272),(273,'Algún lugar de Oratorio','más...','Centro de votación de Oratorio',273),(274,'Algún lugar de Santa Cruz Naranjo','más...','Centro de votación de Santa Cruz Naranjo',274),(275,'Algún lugar de Cuilapa','más...','Centro de votación de Cuilapa',275),(276,'Algún lugar de Pueblo Nuevo Viñas','más...','Centro de votación de Pueblo Nuevo Viñas',276),(277,'Algún lugar de Santa María Ixhuatán','más...','Centro de votación de Santa María Ixhuatán',277),(278,'Algún lugar de Concepción','más...','Centro de votación de Concepción',278),(279,'Algún lugar de San Antonio Palopó','más...','Centro de votación de San Antonio Palopó',279),(280,'Algún lugar de San Marcos La Laguna','más...','Centro de votación de San Marcos La Laguna',280),(281,'Algún lugar de Santa Catarina Palopó','más...','Centro de votación de Santa Catarina Palopó',281),(282,'Algún lugar de Santa María Visitación','más...','Centro de votación de Santa María Visitación',282),(283,'Algún lugar de Nahualá','más...','Centro de votación de Nahualá',283),(284,'Algún lugar de San José Chacayá','más...','Centro de votación de San José Chacayá',284),(285,'Algún lugar de San Pablo La Laguna','más...','Centro de votación de San Pablo La Laguna',285),(286,'Algún lugar de Santa Clara La Laguna','más...','Centro de votación de Santa Clara La Laguna',286),(287,'Algún lugar de Santiago Atitlán','más...','Centro de votación de Santiago Atitlán',287),(288,'Algún lugar de Panajachel','más...','Centro de votación de Panajachel',288),(289,'Algún lugar de San Juan La Laguna','más...','Centro de votación de San Juan La Laguna',289),(290,'Algún lugar de San Pedro La Laguna','más...','Centro de votación de San Pedro La Laguna',290),(291,'Algún lugar de Santa Cruz La Laguna','más...','Centro de votación de Santa Cruz La Laguna',291),(292,'Algún lugar de Sololá','más...','Centro de votación de Sololá',292),(293,'Algún lugar de San Andrés Semetabaj','más...','Centro de votación de San Andrés Semetabaj',293),(294,'Algún lugar de San Lucas Tolimán','más...','Centro de votación de San Lucas Tolimán',294),(295,'Algún lugar de Santa Catarina Ixtahuacan','más...','Centro de votación de Santa Catarina Ixtahuacan',295),(296,'Algún lugar de Santa Lucía Utatlán','más...','Centro de votación de Santa Lucía Utatlán',296),(297,'Algún lugar de Chicacao','más...','Centro de votación de Chicacao',297),(298,'Algún lugar de Pueblo Nuevo','más...','Centro de votación de Pueblo Nuevo',298),(299,'Algún lugar de San Bernardino','más...','Centro de votación de San Bernardino',299),(300,'Algún lugar de San Juan Bautista','más...','Centro de votación de San Juan Bautista',300),(301,'Algún lugar de Santa Bárbara','más...','Centro de votación de Santa Bárbara',301),(302,'Algún lugar de Cuyotenango','más...','Centro de votación de Cuyotenango',302),(303,'Algún lugar de Río Bravo','más...','Centro de votación de Río Bravo',303),(304,'Algún lugar de San Francisco Zapotitlán','más...','Centro de votación de San Francisco Zapotitlán',304),(305,'Algún lugar de San Lorenzo','más...','Centro de votación de San Lorenzo',305),(306,'Algún lugar de Santo Domingo','más...','Centro de votación de Santo Domingo',306),(307,'Algún lugar de Mazatenango','más...','Centro de votación de Mazatenango',307),(308,'Algún lugar de Samayac','más...','Centro de votación de Samayac',308),(309,'Algún lugar de San Gabriel','más...','Centro de votación de San Gabriel',309),(310,'Algún lugar de San Miguel Panán','más...','Centro de votación de San Miguel Panán',310),(311,'Algún lugar de Santo Tomás La Unión','más...','Centro de votación de Santo Tomás La Unión',311),(312,'Algún lugar de Patulul','más...','Centro de votación de Patulul',312),(313,'Algún lugar de San Antonio','más...','Centro de votación de San Antonio',313),(314,'Algún lugar de San José El Ídolo','más...','Centro de votación de San José El Ídolo',314),(315,'Algún lugar de San Pablo Jocopilas','más...','Centro de votación de San Pablo Jocopilas',315),(316,'Algún lugar de Zunilito','más...','Centro de votación de Zunilito',316),(317,'Algún lugar de Momostenango','más...','Centro de votación de Momostenango',317),(318,'Algún lugar de San Francisco El Alto','más...','Centro de votación de San Francisco El Alto',318),(319,'Algún lugar de San Andrés Xecul','más...','Centro de votación de San Andrés Xecul',319),(320,'Algún lugar de Santa Lucía La Reforma','más...','Centro de votación de Santa Lucía La Reforma',320),(321,'Algún lugar de San Bartolo','más...','Centro de votación de San Bartolo',321),(322,'Algún lugar de Santa María Chiquimula','más...','Centro de votación de Santa María Chiquimula',322),(323,'Algún lugar de San Cristóbal Totonicapán','más...','Centro de votación de San Cristóbal Totonicapán',323),(324,'Algún lugar de Totonicapán','más...','Centro de votación de Totonicapán',324),(325,'Algún lugar de Cabañas','más...','Centro de votación de Cabañas',325),(326,'Algún lugar de La Unión','más...','Centro de votación de La Unión',326),(327,'Algún lugar de Usumatlán','más...','Centro de votación de Usumatlán',327),(328,'Algún lugar de Estanzuela','más...','Centro de votación de Estanzuela',328),(329,'Algún lugar de Río Hondo','más...','Centro de votación de Río Hondo',329),(330,'Algún lugar de Zacapa','más...','Centro de votación de Zacapa',330),(331,'Algún lugar de Gualán','más...','Centro de votación de Gualán',331),(332,'Algún lugar de San Diego','más...','Centro de votación de San Diego',332),(333,'Algún lugar de Huité','más...','Centro de votación de Huité',333),(334,'Algún lugar de Teculután','más...','Centro de votación de Teculután',334);
/*!40000 ALTER TABLE `centro_votacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Alta Verapaz'),(2,'Baja Verapaz'),(3,'Chimaltenango'),(4,'Chiquimula'),(5,'El Progreso'),(6,'Escuintla'),(7,'Guatemala'),(8,'Huehuetenango'),(9,'Izabal'),(10,'Jalapa'),(11,'Jutiapa'),(12,'Petén'),(13,'Quetzaltenango'),(14,'Quiché'),(15,'Retalhuleu'),(16,'Sacatepéquez'),(17,'San Marcos'),(18,'Santa Rosa'),(19,'Sololá'),(20,'Suchitepéquez'),(21,'Totonicapán'),(22,'Zacapa');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elector`
--

DROP TABLE IF EXISTS `elector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elector` (
  `id_elector` int(11) NOT NULL,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `DPI` varchar(255) DEFAULT NULL,
  `extra_direccion` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `GENERO` varchar(255) DEFAULT NULL,
  `NOMBRES` varchar(255) DEFAULT NULL,
  `num_padron` int(11) DEFAULT NULL,
  `voto_emitido` tinyint(1) DEFAULT '0',
  `id_mesa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_elector`),
  KEY `FK_elector_id_mesa` (`id_mesa`),
  CONSTRAINT `FK_elector_id_mesa` FOREIGN KEY (`id_mesa`) REFERENCES `mesa_votacion` (`id_mesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elector`
--

LOCK TABLES `elector` WRITE;
/*!40000 ALTER TABLE `elector` DISABLE KEYS */;
/*!40000 ALTER TABLE `elector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa_votacion`
--

DROP TABLE IF EXISTS `mesa_votacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesa_votacion` (
  `id_mesa` int(11) NOT NULL,
  `cant_blancos` int(11) DEFAULT NULL,
  `cant_nulos` int(11) DEFAULT NULL,
  `num_mesa` int(11) DEFAULT NULL,
  `rango_final` varchar(255) DEFAULT NULL,
  `rango_inicial` varchar(255) DEFAULT NULL,
  `id_centro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_mesa`),
  KEY `FK_mesa_votacion_id_centro` (`id_centro`),
  CONSTRAINT `FK_mesa_votacion_id_centro` FOREIGN KEY (`id_centro`) REFERENCES `centro_votacion` (`id_centro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa_votacion`
--

LOCK TABLES `mesa_votacion` WRITE;
/*!40000 ALTER TABLE `mesa_votacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesa_votacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `FK_municipio_id_departamento` (`id_departamento`),
  CONSTRAINT `FK_municipio_id_departamento` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,'Chahal',1),(2,'Lanquín',1),(3,'San Juan Chamelco',1),(4,'Santa María Cahabón',1),(5,'Tucurú',1),(6,'Chisec',1),(7,'Panzós',1),(8,'San Pedro Carchá',1),(9,'Senahú',1),(10,'Cobán',1),(11,'Raxruhá',1),(12,'Santa Catalina La Tinta',1),(13,'Tactic',1),(14,'Fray Bartolomé de las Casas',1),(15,'San Cristóbal Verapaz',1),(16,'Santa Cruz Verapaz',1),(17,'Tamahú',1),(18,'Cubulco',2),(19,'Salamá',2),(20,'Granados',2),(21,'San Jerónimo',2),(22,'Purulhá',2),(23,'San Miguel Chicaj',2),(24,'Rabinal',2),(25,'Santa Cruz el Chol',2),(26,'Acatenango',3),(27,'Patzicía',3),(28,'San José Poaquil',3),(29,'Santa Cruz Balanyá',3),(30,'Chimaltenango',3),(31,'Patzún',3),(32,'San Juan Comalapa',3),(33,'Tecpán',3),(34,'El Tejar',3),(35,'Pochuta',3),(36,'San Martín Jilotepeque',3),(37,'Yepocapa',3),(38,'Parramos',3),(39,'San Andrés Itzapa',3),(40,'Santa Apolonia',3),(41,'Zaragoza',3),(42,'Camotán',4),(43,'Ipala',4),(44,'San Jacinto',4),(45,'Chiquimula',4),(46,'Jocotán',4),(47,'San José La Arada',4),(48,'Concepción Las Minas',4),(49,'Olopa',4),(50,'San Juan Ermita',4),(51,'Esquipulas',4),(52,'Quezaltepeque',4),(53,'El Jícaro',5),(54,'San Antonio La Paz',5),(55,'Guastatoya',5),(56,'San Cristóbal Acasaguastlán',5),(57,'Morazán',5),(58,'Sanarate',5),(59,'San Agustín Acasaguastlán',5),(60,'Sansare',5),(61,'Escuintla',6),(62,'La Gomera',6),(63,'San José',6),(64,'Tiquisate',6),(65,'Guanagazapa',6),(66,'Masagua',6),(67,'San Vicente Pacaya',6),(68,'Iztapa',6),(69,'Nueva Concepción',6),(70,'Santa Lucía Cotzumalguapa',6),(71,'La Democracia',6),(72,'Palín',6),(73,'Siquinalá',6),(74,'Amatitlán',7),(75,'Guatemala',7),(76,'San José Pinula',7),(77,'San Pedro Sacatepéquez',7),(78,'Villa Nueva',7),(79,'Chinautla',7),(80,'Mixco',7),(81,'San Juan Sacatepéquez',7),(82,'San Raymundo',7),(83,'Chuarrancho',7),(84,'Palencia',7),(85,'San Miguel Petapa',7),(86,'Santa Catarina Pinula',7),(87,'Fraijanes',7),(88,'San José del Golfo',7),(89,'San Pedro Ayampuc',7),(90,'Villa Canales',7),(91,'Aguacatán',8),(92,'Cuilco',8),(93,'La Libertad',8),(94,'San Gaspar Ixchil',8),(95,'San Mateo Ixtatán',8),(96,'San Rafael La Independencia',8),(97,'Santa Ana Huista',8),(98,'Santiago Chimaltenango',8),(99,'Chiantla',8),(100,'Huehuetenango',8),(101,'Malacatancito',8),(102,'San Ildefonso Ixtahuacán',8),(103,'San Miguel Acatán',8),(104,'San Rafael Petzal',8),(105,'Santa Bárbara',8),(106,'Tectitán',8),(107,'Colotenango',8),(108,'Jacaltenango',8),(109,'Nentón',8),(110,'San Juan Atitán',8),(111,'San Pedro Necta',8),(112,'San Sebastián Coatán',8),(113,'Santa Cruz Barillas',8),(114,'Todos Santos Cuchumatánes',8),(115,'Concepción Huista',8),(116,'La Democracia',8),(117,'San Antonio Huista',8),(118,'San Juan Ixcoy',8),(119,'San Pedro Soloma',8),(120,'San Sebastián',8),(121,'Santa Eulalia',8),(122,'Unión Cantinil',8),(123,'El Estor',9),(124,'Puerto Barrios',9),(125,'Livingston',9),(126,'Los Amates',9),(127,'Morales',9),(128,'Jalapa',10),(129,'San Luis Jilotepeque',10),(130,'Mataquescuintla',10),(131,'San Manuel Chaparrón',10),(132,'Monjas',10),(133,'San Pedro Pinula',10),(134,'San Carlos Alzatate',10),(135,'Agua Blanca',11),(136,'Conguaco',11),(137,'Jerez',11),(138,'Quesada',11),(139,'Zapotitlán',11),(140,'Asunción Mita',11),(141,'El Adelanto',11),(142,'Jutiapa',11),(143,'San José Acatempa',11),(144,'Atescatempa',11),(145,'El Progreso',11),(146,'Moyuta',11),(147,'Santa Catarina Mita',11),(148,'Comapa',11),(149,'Jalpatagua',11),(150,'Pasaco',11),(151,'Yupiltepeque',11),(152,'Dolores',12),(153,'Melchor de Mencos',12),(154,'San Francisco',12),(155,'Sayaxché',12),(156,'Flores',12),(157,'Poptún',12),(158,'San José',12),(159,'La Libertad',12),(160,'San Andrés',12),(161,'San Luis',12),(162,'Las Cruces',12),(163,'San Benito',12),(164,'Santa Ana',12),(165,'Almolonga',13),(166,'Coatepeque',13),(167,'Flores Costa Cuca',13),(168,'Olintepeque',13),(169,'San Carlos Sija',13),(170,'San Mateo',13),(171,'Cabricán',13),(172,'Colomba',13),(173,'Génova',13),(174,'Palestina de Los Altos',13),(175,'San Francisco La Unión',13),(176,'San Miguel Sigüilá',13),(177,'Cajolá',13),(178,'Concepción Chiquirichapa',13),(179,'Huitán',13),(180,'Quetzaltenango',13),(181,'San Juan Ostuncalco',13),(182,'Sibilia',13),(183,'Cantel',13),(184,'El Palmar',13),(185,'La Esperanza',13),(186,'Salcajá',13),(187,'San Martín Sacatepéquez',13),(188,'Zunil',13),(189,'Canillá',14),(190,'Chichicastenango',14),(191,'Joyabaj',14),(192,'Sacapulas',14),(193,'San Juan Cotzal',14),(194,'Zacualpa',14),(195,'Chajul',14),(196,'Chinique',14),(197,'Nebaj',14),(198,'San Andrés Sajcabajá',14),(199,'San Pedro Jocopilas',14),(200,'Chicamán',14),(201,'Cunén',14),(202,'Pachalum',14),(203,'San Antonio Ilotenango',14),(204,'Santa Cruz del Quiché',14),(205,'Chiché',14),(206,'Ixcán',14),(207,'Patzité',14),(208,'San Bartolomé Jocotenango',14),(209,'Uspantán',14),(210,'Champerico',15),(211,'San Andrés Villa Seca',15),(212,'Santa Cruz Muluá',15),(213,'El Asintal',15),(214,'San Felipe',15),(215,'Nuevo San Carlos',15),(216,'San Martín Zapotitlán',15),(217,'Retalhuleu',15),(218,'San Sebastián',15),(219,'Alotenango',16),(220,'Magdalena Milpas Altas',16),(221,'San Lucas Sacatepéquez',16),(222,'Santa María de Jesús',16),(223,'La Antigua Guatemala',16),(224,'Pastores',16),(225,'San Miguel Dueñas',16),(226,'Santiago Sacatepéquez',16),(227,'Ciudad Vieja',16),(228,'San Antonio Aguas Calientes',16),(229,'Santa Catarina Barahona',16),(230,'Santo Domingo Xenacoj',16),(231,'Jocotenango',16),(232,'San Bartolomé Milpas Altas',16),(233,'Santa Lucía Milpas Altas',16),(234,'Sumpango',16),(235,'Ayutla',17),(236,'El Quetzal',17),(237,'Ixchiguán',17),(238,'Ocós',17),(239,'San Cristóbal Cucho',17),(240,'San Miguel Ixtahuacán',17),(241,'Sibinal',17),(242,'Tejutla',17),(243,'Catarina',17),(244,'El Rodeo',17),(245,'La Reforma',17),(246,'Pajapita',17),(247,'San José Ojetenam',17),(248,'San Pablo',17),(249,'Sipacapa',17),(250,'Comitancillo',17),(251,'El Tumbador',17),(252,'Malacatán',17),(253,'Río Blanco',17),(254,'San Lorenzo',17),(255,'San Pedro Sacatepéquez',17),(256,'Tacaná',17),(257,'Concepción Tutuapa',17),(258,'Esquipulas Palo Gordo',17),(259,'Nuevo Progreso',17),(260,'San Antonio Sacatepéquez',17),(261,'San Marcos',17),(262,'San Rafael Pie de La Cuesta',17),(263,'Tajumulco',17),(264,'Barberena',18),(265,'Guazacapán',18),(266,'San Juan Tecuaco',18),(267,'Santa Rosa de Lima',18),(268,'Casillas',18),(269,'Nueva Santa Rosa',18),(270,'San Rafaél Las Flores',18),(271,'Taxisco',18),(272,'Chiquimulilla',18),(273,'Oratorio',18),(274,'Santa Cruz Naranjo',18),(275,'Cuilapa',18),(276,'Pueblo Nuevo Viñas',18),(277,'Santa María Ixhuatán',18),(278,'Concepción',19),(279,'San Antonio Palopó',19),(280,'San Marcos La Laguna',19),(281,'Santa Catarina Palopó',19),(282,'Santa María Visitación',19),(283,'Nahualá',19),(284,'San José Chacayá',19),(285,'San Pablo La Laguna',19),(286,'Santa Clara La Laguna',19),(287,'Santiago Atitlán',19),(288,'Panajachel',19),(289,'San Juan La Laguna',19),(290,'San Pedro La Laguna',19),(291,'Santa Cruz La Laguna',19),(292,'Sololá',19),(293,'San Andrés Semetabaj',19),(294,'San Lucas Tolimán',19),(295,'Santa Catarina Ixtahuacan',19),(296,'Santa Lucía Utatlán',19),(297,'Chicacao',20),(298,'Pueblo Nuevo',20),(299,'San Bernardino',20),(300,'San Juan Bautista',20),(301,'Santa Bárbara',20),(302,'Cuyotenango',20),(303,'Río Bravo',20),(304,'San Francisco Zapotitlán',20),(305,'San Lorenzo',20),(306,'Santo Domingo',20),(307,'Mazatenango',20),(308,'Samayac',20),(309,'San Gabriel',20),(310,'San Miguel Panán',20),(311,'Santo Tomás La Unión',20),(312,'Patulul',20),(313,'San Antonio',20),(314,'San José El Ídolo',20),(315,'San Pablo Jocopilas',20),(316,'Zunilito',20),(317,'Momostenango',21),(318,'San Francisco El Alto',21),(319,'San Andrés Xecul',21),(320,'Santa Lucía La Reforma',21),(321,'San Bartolo',21),(322,'Santa María Chiquimula',21),(323,'San Cristóbal Totonicapán',21),(324,'Totonicapán',21),(325,'Cabañas',22),(326,'La Unión',22),(327,'Usumatlán',22),(328,'Estanzuela',22),(329,'Río Hondo',22),(330,'Zacapa',22),(331,'Gualán',22),(332,'San Diego',22),(333,'Huité',22),(334,'Teculután',22);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partido` (
  `id_partido` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `nombre_candidato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_partido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,'Partido 1','Mario'),(2,'Partido 2','Peach'),(3,'Partido 3','Bowser'),(4,'Partido 4','Waluigi');
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voto`
--

DROP TABLE IF EXISTS `voto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voto` (
  `id_voto` int(11) NOT NULL,
  `id_mesa` int(11) DEFAULT NULL,
  `id_partido` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_voto`),
  KEY `FK_voto_id_mesa` (`id_mesa`),
  KEY `FK_voto_id_partido` (`id_partido`),
  CONSTRAINT `FK_voto_id_mesa` FOREIGN KEY (`id_mesa`) REFERENCES `mesa_votacion` (`id_mesa`),
  CONSTRAINT `FK_voto_id_partido` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id_partido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voto`
--

LOCK TABLES `voto` WRITE;
/*!40000 ALTER TABLE `voto` DISABLE KEYS */;
/*!40000 ALTER TABLE `voto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-03 12:54:15
