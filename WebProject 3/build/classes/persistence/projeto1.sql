CREATE DATABASE PROJETO1;
USE PROJETO1;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema locacao
-- -----------------------------------------------------
-- sistema de controle de locação
DROP SCHEMA IF EXISTS `projeto1` ;
CREATE SCHEMA IF NOT EXISTS `projeto1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `projeto1` ;

-- -----------------------------------------------------
-- Table `locacao`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto1`.`Cliente` ;

CREATE TABLE CLIENTE(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(20),
  `telefone` varchar(15) NOT NULL,
  `email` VARCHAR(45),
  `dataNascimento` VARCHAR(15) NOT NULL,
  `genero` VARCHAR(10),
  `estadoEmissorRG` varchar(2),
  `validadeCarteira` VARCHAR(15),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

DESCRIBE CLIENTE;

SELECT * FROM CLIENTE;

USE PROJETO1;

DROP TABLE IF EXISTS `projeto1`.`Veiculo`;

CREATE TABLE IF NOT EXISTS `projeto1`.`Veiculo` (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(10) NOT NULL,
  `marca` VARCHAR(20) NOT NULL,
  `modelo` VARCHAR(20) NOT NULL,
  `grupo` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) ,
  `estado` VARCHAR(45) ,
  `km` VARCHAR(10) NOT NULL,
  `chassi` VARCHAR(45) NOT NULL,
  `tarifaKmLivre` VARCHAR(10) ,
  `tarifaKmControlado` VARCHAR(10) ,
  `disponivel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


DESCRIBE VEICULO;
SELECT * FROM VEICULO;
CREATE TABLE IF NOT EXISTS Emprestimo (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idCLi`  INT UNSIGNED NOT NULL,
  `cpfCli` VARCHAR(20) NOT NULL,
  `idVei` INT UNSIGNED NOT NULL,
  `placaVei` VARCHAR(10) NOT NULL,
  `dataEmprestimo` VARCHAR(15) NOT NULL,
  `dataDevolucao` VARCHAR(15) NOT NULL,
  `localEmprestimo` VARCHAR(30) NOT NULL,
  `localDevolucao` VARCHAR(30) NOT NULL,
  `tipoDeTarifa` VARCHAR(25) NOT NULL,
  `acessorios` VARCHAR(25) NOT NULL,
  `valorEmprestimo` varchar(300) NOT NULL,
  `ativo` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Emprestimo_Cliente` FOREIGN KEY (`idCli`) REFERENCES `projeto1`.`Cliente` (`id`),
  CONSTRAINT `fk_Emprestimo_Veiculo` FOREIGN KEY (`idVei`) REFERENCES `projeto1`.`Veiculo` (`id`))
ENGINE = InnoDB;

describe emprestimo;

#INSERT INTO EMPRESTIMO (IDCLI, CPFCLI, IDVEI, PLACAVEI, DATAEMPRESTIMO, DATADEVOLUCAO, LOCALEMPRESTIMO, LOCALDEVOLUCAO, TIPODETARIFA, VALOREMPRESTIMO)
#VALUES(1,'123.456.789.10', 1, 'BOM-9784', '21/10/2014', '25/10/2014', 'sao paulo', 'sao paulo', 'l', '1155,10');

select * from emprestimo;