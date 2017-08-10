-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: taverna_email
-- ------------------------------------------------------
-- Server version	5.6.31-log

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
-- Table structure for table `campanha`
--

DROP TABLE IF EXISTS `campanha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campanha` (
  `ID_CAMPANHA` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` bigint(20) DEFAULT NULL,
  `DATA_CRIACAO` datetime DEFAULT NULL,
  `LINK_INICIAL` text,
  `DESC_NOME` text,
  `DESC_OBS` text,
  `flag_ativo` char(1) DEFAULT 'S',
  PRIMARY KEY (`ID_CAMPANHA`),
  KEY `FK_REFERENCE_13` (`ID_USUARIO`),
  CONSTRAINT `FK_REFERENCE_13` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanha`
--

LOCK TABLES `campanha` WRITE;
/*!40000 ALTER TABLE `campanha` DISABLE KEYS */;
INSERT INTO `campanha` VALUES (1,9,'2017-07-24 16:51:35','1','asdadasd','ss','S'),(2,9,'2017-07-24 16:51:41','2','asdadasdssssss','ss2222','S');
/*!40000 ALTER TABLE `campanha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campanha_email`
--

DROP TABLE IF EXISTS `campanha_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campanha_email` (
  `ID_EMAIL` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_CAMPANHA` bigint(20) DEFAULT NULL,
  `DESC_EMAIL` text,
  `DESC_TITULO` text,
  `QTD_REFERENCIA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_EMAIL`),
  KEY `FK_REFERENCE_6` (`ID_CAMPANHA`),
  CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`ID_CAMPANHA`) REFERENCES `campanha` (`ID_CAMPANHA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanha_email`
--

LOCK TABLES `campanha_email` WRITE;
/*!40000 ALTER TABLE `campanha_email` DISABLE KEYS */;
INSERT INTO `campanha_email` VALUES (1,2,'corpo do email 1','titulo email 1',0),(2,2,'corpo do email 2','titulo email 2',3),(3,2,'corpo do email 3','titulo email 3',5);
/*!40000 ALTER TABLE `campanha_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campanha_email_premio`
--

DROP TABLE IF EXISTS `campanha_email_premio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campanha_email_premio` (
  `ID_EMAIL` bigint(20) NOT NULL,
  `ID_PREMIO` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_EMAIL`,`ID_PREMIO`),
  KEY `FK_REFERENCE_7` (`ID_PREMIO`),
  CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`ID_PREMIO`) REFERENCES `user_premios` (`ID_PREMIO`),
  CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`ID_EMAIL`) REFERENCES `campanha_email` (`ID_EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanha_email_premio`
--

LOCK TABLES `campanha_email_premio` WRITE;
/*!40000 ALTER TABLE `campanha_email_premio` DISABLE KEYS */;
INSERT INTO `campanha_email_premio` VALUES (1,1),(2,2),(2,3),(3,4),(3,5);
/*!40000 ALTER TABLE `campanha_email_premio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campanha_landpage`
--

DROP TABLE IF EXISTS `campanha_landpage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campanha_landpage` (
  `ID_LANDPAGE` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_campanha` bigint(20) DEFAULT NULL,
  `DESC_TITULO_1` text,
  `DESC_SUB_TITULO_1` text,
  `URL_VIDEO` text,
  `DESC_CAMPANHA` text,
  `DESC_TITULO_2` text,
  `SUB_TITULO_2` text,
  PRIMARY KEY (`ID_LANDPAGE`),
  KEY `FK_REFERENCE_3` (`id_campanha`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`id_campanha`) REFERENCES `campanha` (`ID_CAMPANHA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanha_landpage`
--

LOCK TABLES `campanha_landpage` WRITE;
/*!40000 ALTER TABLE `campanha_landpage` DISABLE KEYS */;
INSERT INTO `campanha_landpage` VALUES (1,2,'Desc_titulo 1','Desc_sub_titulo 1','url_video','desc_campanha','DESC_TITULO_2','sub_titulo_2');
/*!40000 ALTER TABLE `campanha_landpage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campanha_landpage_features`
--

DROP TABLE IF EXISTS `campanha_landpage_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campanha_landpage_features` (
  `ID_LANDPAGE` bigint(20) NOT NULL,
  `ID_FEATURE` int(11) NOT NULL,
  `DESC_FEATURE` text,
  `DESC_CLASS_ICON` varchar(30) DEFAULT NULL,
  `DESC_NAME` text,
  PRIMARY KEY (`ID_FEATURE`,`ID_LANDPAGE`),
  KEY `FK_REFERENCE_12` (`ID_LANDPAGE`),
  CONSTRAINT `FK_REFERENCE_12` FOREIGN KEY (`ID_LANDPAGE`) REFERENCES `campanha_landpage` (`ID_LANDPAGE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanha_landpage_features`
--

LOCK TABLES `campanha_landpage_features` WRITE;
/*!40000 ALTER TABLE `campanha_landpage_features` DISABLE KEYS */;
INSERT INTO `campanha_landpage_features` VALUES (1,1,'desc feature 1','classe 1','feautre 1'),(1,2,'desc feature 2','classe 2','feautre 2'),(1,3,'desc feature 3','classe 3','feautre 3');
/*!40000 ALTER TABLE `campanha_landpage_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campanha_leads`
--

DROP TABLE IF EXISTS `campanha_leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campanha_leads` (
  `ID_LEAD` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_CAMPANHA` bigint(20) DEFAULT NULL,
  `ID_LEAD_REFERENCIA` bigint(20) DEFAULT NULL,
  `DESC_EMAIL` text,
  `DESC_LINK_REFERAL` text,
  PRIMARY KEY (`ID_LEAD`),
  KEY `FK_REFERENCE_2` (`ID_CAMPANHA`),
  KEY `FK_REFERENCE_9` (`ID_LEAD_REFERENCIA`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`ID_CAMPANHA`) REFERENCES `campanha` (`ID_CAMPANHA`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`ID_LEAD_REFERENCIA`) REFERENCES `campanha_leads` (`ID_LEAD`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanha_leads`
--

LOCK TABLES `campanha_leads` WRITE;
/*!40000 ALTER TABLE `campanha_leads` DISABLE KEYS */;
INSERT INTO `campanha_leads` VALUES (1,2,NULL,'g.kothe@hotmail.com','http://localhost:8080/taverna/campanha?ref=2&l=1'),(2,2,1,'k149171@mvrht.net','http://localhost:8080/taverna/campanha?ref=2&l=2'),(3,2,1,'a23sd@mvrht.net','http://localhost:8080/taverna/campanha?ref=2&l=3'),(4,2,1,'1232323@mvrht.net','http://localhost:8080/taverna/campanha?ref=2&l=4'),(5,2,1,'aaaaa@mvrht.net','http://localhost:8080/taverna/campanha?ref=2&l=5'),(6,2,1,'65656@mvrht.net','http://localhost:8080/taverna/campanha?ref=2&l=6');
/*!40000 ALTER TABLE `campanha_leads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campanha_thankspage`
--

DROP TABLE IF EXISTS `campanha_thankspage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campanha_thankspage` (
  `ID_THANKSPAGE` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_CAMPANHA` bigint(20) DEFAULT NULL,
  `MSG_THANKS` text,
  `SUB_TITULO` text,
  `URL_VIDEO` text,
  `DESC_FRASE` text,
  `DESC_FRASE2` text,
  `DESC_TEXTO` text,
  PRIMARY KEY (`ID_THANKSPAGE`),
  KEY `FK_REFERENCE_4` (`ID_CAMPANHA`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`ID_CAMPANHA`) REFERENCES `campanha` (`ID_CAMPANHA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanha_thankspage`
--

LOCK TABLES `campanha_thankspage` WRITE;
/*!40000 ALTER TABLE `campanha_thankspage` DISABLE KEYS */;
INSERT INTO `campanha_thankspage` VALUES (1,2,'t_msg_thanks','t_sub_titulo','t_url_video','t_desc_frase','t_desc_frase2','t_desc_texto');
/*!40000 ALTER TABLE `campanha_thankspage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `COD_CIDADE` int(11) NOT NULL AUTO_INCREMENT,
  `DESC_CIDADE` text NOT NULL,
  `ID_ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`COD_CIDADE`),
  KEY `FK_REFERENCE_14` (`ID_ESTADO`),
  CONSTRAINT `FK_REFERENCE_14` FOREIGN KEY (`ID_ESTADO`) REFERENCES `estado` (`ID_ESTADO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Santa Cruz do Sul',1),(2,'São Paulo',2);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `ID_ESTADO` int(11) NOT NULL AUTO_INCREMENT,
  `DESC_UF` varchar(4) DEFAULT NULL,
  `DESC_ESTADO` text,
  PRIMARY KEY (`ID_ESTADO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'RS','Rio Grande do Sul'),(2,'SP','São Paulo');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_parametros`
--

DROP TABLE IF EXISTS `sys_parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_parametros` (
  `id_param` int(11) NOT NULL DEFAULT '0',
  `ID_USUARIO_ADMIN` bigint(20) DEFAULT NULL,
  `FLAG_MANUTENCAO` char(1) DEFAULT NULL,
  `DESC_KEY` text,
  `SEGS_TESTE_AJAX` bigint(20) DEFAULT NULL,
  `FACE_APP_ID` bigint(20) DEFAULT NULL,
  `FACE_APP_SECRETKEY` text,
  `FACE_APP_TOKEN` text,
  `FACE_REDIRECT_URI` text,
  `url_system` text,
  `sys_host_name_smtp` text,
  `sys_smtp_port` int(11) DEFAULT NULL,
  `sys_email` text,
  `sys_senha` text,
  `sys_fromemail` text,
  `sys_fromdesc` text,
  `sys_tls` char(1) DEFAULT NULL,
  `id_visitante` bigint(20) DEFAULT NULL,
  `PED_HORASOKEY` int(11) DEFAULT NULL,
  `NUM_TEMPOMAXCANC_MINUTO` int(11) DEFAULT NULL,
  `COD_RECUSA` int(11) DEFAULT NULL,
  `ONESIGNAL_KEY` text,
  `ONESIGNAL_URL` text,
  `ONESIGNAL_APPID` text,
  `NUM_MINUTOS_NOT_FINAL` int(11) DEFAULT NULL,
  `NUM_SEGS_NOT_FINAL_EXEC` int(11) DEFAULT NULL,
  `cod_cancelamentosys` int(11) DEFAULT NULL,
  `desc_webappfolder` text,
  `IGNORAR_REGRAMAIOR18` char(1) DEFAULT NULL,
  `FACE_REDIRECT_URI_WEBAPP` text,
  `TRAGOAQUI_NUM_TELEFONE` text,
  `TRAGOAQUI_PAG_FACEBOOK` text,
  `app_versao` text,
  `applicacao` int(11) DEFAULT NULL,
  `SYS_MINUTES_AGEN_NOT_RESP` int(11) DEFAULT NULL,
  `url_websocket` text,
  PRIMARY KEY (`id_param`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_parametros`
--

LOCK TABLES `sys_parametros` WRITE;
/*!40000 ALTER TABLE `sys_parametros` DISABLE KEYS */;
INSERT INTO `sys_parametros` VALUES (1,NULL,'N',NULL,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/taverna/','mail.tragoaqui.com.br',587,'testevarzea@tragoaqui.com.br','123QwErTy!@#','testevarzea@tragoaqui.com.br','Taverna email','N',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'taverna_email',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_image`
--

DROP TABLE IF EXISTS `user_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_image` (
  `ID_IMAGE` bigint(20) NOT NULL,
  `ID_USUARIO` bigint(20) DEFAULT NULL,
  `DESC_IMAGE` text,
  `DESC_PATH_SYSTEM` text,
  PRIMARY KEY (`ID_IMAGE`),
  KEY `FK_REFERENCE_15` (`ID_USUARIO`),
  CONSTRAINT `FK_REFERENCE_15` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_image`
--

LOCK TABLES `user_image` WRITE;
/*!40000 ALTER TABLE `user_image` DISABLE KEYS */;
INSERT INTO `user_image` VALUES (1,9,'IMG_0132.JPG','D:\\Unisc\\apache-tomcat-9.0.0.M9/webapps/taverna_email/WEB-INF/9\\1_IMG_0132.JPG'),(2,9,'IMG_0133.JPG','D:\\Unisc\\apache-tomcat-9.0.0.M9/webapps/taverna_email/WEB-INF/9\\2_IMG_0133.JPG'),(3,9,'logo_7.jpg','D:\\Unisc\\apache-tomcat-9.0.0.M9/webapps/taverna_email/WEB-INF/9\\3_logo_7.jpg'),(4,9,'Untitled.png','D:\\Unisc\\apache-tomcat-9.0.0.M9/webapps/taverna_email/WEB-INF/9\\4_Untitled.png');
/*!40000 ALTER TABLE `user_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_image_page`
--

DROP TABLE IF EXISTS `user_image_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_image_page` (
  `ID_ASSOCIACAO` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_IMAGE` bigint(20) DEFAULT NULL,
  `FLAG_PAGETIPE` char(1) DEFAULT NULL,
  `id_campanha` bigint(20) DEFAULT NULL,
  `id_page` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ASSOCIACAO`),
  KEY `FK_REFERENCE_16` (`ID_IMAGE`),
  KEY `FK_REFERENCE_17` (`id_campanha`),
  CONSTRAINT `FK_REFERENCE_16` FOREIGN KEY (`ID_IMAGE`) REFERENCES `user_image` (`ID_IMAGE`),
  CONSTRAINT `FK_REFERENCE_17` FOREIGN KEY (`id_campanha`) REFERENCES `campanha` (`ID_CAMPANHA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_image_page`
--

LOCK TABLES `user_image_page` WRITE;
/*!40000 ALTER TABLE `user_image_page` DISABLE KEYS */;
INSERT INTO `user_image_page` VALUES (1,1,'L',2,NULL),(2,3,'L',2,NULL),(3,2,'T',2,NULL),(4,4,'T',2,NULL);
/*!40000 ALTER TABLE `user_image_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_premios`
--

DROP TABLE IF EXISTS `user_premios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_premios` (
  `ID_PREMIO` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` bigint(20) DEFAULT NULL,
  `DESC_NAME` text,
  `DESC_EXTENSAO` text,
  `DESC_PATH` text,
  PRIMARY KEY (`ID_PREMIO`),
  KEY `FK_REFERENCE_18` (`ID_USUARIO`),
  CONSTRAINT `FK_REFERENCE_18` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_premios`
--

LOCK TABLES `user_premios` WRITE;
/*!40000 ALTER TABLE `user_premios` DISABLE KEYS */;
INSERT INTO `user_premios` VALUES (1,9,'123123',NULL,'http://localhost:8080/taverna/home?ac=insertPremio'),(2,9,'premio 2',NULL,'https://www.google.com.br/search?q=file+host+free&safe=off&ei=zjx7WaaOLIar-QGe7JfgBQ&start=0&sa=N&biw=1920&bih=990'),(3,9,'premio 3',NULL,'https://www.facebook.com/'),(4,9,'premio 4',NULL,'tua mae '),(5,9,'premio 5 ',NULL,'_|_');
/*!40000 ALTER TABLE `user_premios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` bigint(20) NOT NULL AUTO_INCREMENT,
  `COD_CIDADE` int(11) DEFAULT NULL,
  `DESC_NOME` text,
  `DESC_TELEFONE` varchar(50) DEFAULT NULL,
  `DESC_ENDERECO` text NOT NULL,
  `NUM_ENDEREC` varchar(10) NOT NULL,
  `DESC_COMPLEMENTO` text,
  `DESC_LOGIN` varchar(45) DEFAULT NULL,
  `DESC_SENHA` varchar(45) DEFAULT NULL,
  `DESC_MAIL` text,
  `FLAG_ATIVO` char(1) DEFAULT NULL,
  `DATE_LASTAJAX` datetime DEFAULT NULL,
  `NUM_CPF` varchar(11) DEFAULT NULL,
  `DESC_CEP` varchar(8) DEFAULT NULL,
  `FLAG_ATIVADO` char(1) DEFAULT NULL,
  `CHAVE_ATIVACAO` varchar(100) DEFAULT NULL,
  `DESC_NOVOEMAILVALIDACAO` varchar(150) DEFAULT NULL,
  `CHAVE_ATIVACAO_NOVOEMAIL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  KEY `FK_REFERENCE_11` (`COD_CIDADE`),
  CONSTRAINT `FK_REFERENCE_11` FOREIGN KEY (`COD_CIDADE`) REFERENCES `cidade` (`COD_CIDADE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (9,1,'Gabriel Kothe','984970310','Rua borges de Medeiros','715','','gkothe','oi','g.kothe@hotmail.com','S',NULL,'81544412681','9999999','S','',NULL,NULL),(10,1,'aaaa','99 9 9999-99999','aaaaaa','754','545','b','b','1231@asda.com','N',NULL,'11111111111','11111111','N','8opnei5jjoalji7i0kam44lu4kpa9sj1f3i3pds9umsf6grr0hut532hu1svjprfdhsk4jr1qhu5ttbdnh75qt4psu511fl9cp1',NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-10 13:14:29
