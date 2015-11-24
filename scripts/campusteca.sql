-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema campusteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema campusteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `campusteca` DEFAULT CHARACTER SET utf8 ;
USE `campusteca` ;

-- -----------------------------------------------------
-- Table `campusteca`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `campusteca`.`review` (
  `idreview` INT NOT NULL AUTO_INCREMENT,
  `idbook` INT NOT NULL,
  `iduser` INT NOT NULL,
  `rating` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`idreview`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
