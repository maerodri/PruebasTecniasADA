-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema company_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema company_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `company_db` DEFAULT CHARACTER SET utf8 ;
USE `company_db` ;

-- -----------------------------------------------------
-- Table `company_db`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`company` (
  `id_company` INT NOT NULL AUTO_INCREMENT,
  `codigo_company` VARCHAR(45) NOT NULL,
  `name_company` VARCHAR(45) NOT NULL,
  `description_company` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_company`),
  UNIQUE INDEX `codigo_company_UNIQUE` (`codigo_company` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company_db`.`application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`application` (
  `app_id` INT NOT NULL AUTO_INCREMENT,
  `app_code` VARCHAR(45) NOT NULL,
  `app_name` VARCHAR(45) NOT NULL,
  `app_description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`app_id`),
  UNIQUE INDEX `app_code_UNIQUE` (`app_code` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company_db`.`version`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`version` (
  `version_id` INT NOT NULL AUTO_INCREMENT,
  `version` VARCHAR(45) NOT NULL,
  `version_description` VARCHAR(45) NOT NULL,
  `application_id` INT NOT NULL,
  PRIMARY KEY (`version_id`),
  INDEX `fk_version_application1_idx` (`application_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company_db`.`version_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`version_company` (
  `version_company_id` INT NOT NULL AUTO_INCREMENT,
  `version_company_description` VARCHAR(45) NOT NULL,
  `company_id` INT NOT NULL,
  `version_id` INT NOT NULL,
  PRIMARY KEY (`version_company_id`),
  INDEX `fk_version_company_company1_idx` (`company_id` ASC) VISIBLE,
  INDEX `fk_version_company_version1_idx` (`version_id` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
