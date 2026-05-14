-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`oficinas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`oficinas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`oficinas` (
  `cod_oficina` INT NOT NULL,
  `ciudad` VARCHAR(45) NULL,
  `region` VARCHAR(45) NULL,
  `objetivo` DECIMAL(10,2) NULL,
  `ventas` DECIMAL(10,2) NULL,
  `director` INT NULL,
  PRIMARY KEY (`cod_oficina`),
  CONSTRAINT `fk_director_oficina`
    FOREIGN KEY (`director`)
    REFERENCES `mydb`.`empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_director_oficina_idx` ON `mydb`.`oficinas` (`director` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`empleados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`empleados` ;

CREATE TABLE IF NOT EXISTS `mydb`.`empleados` (
  `numemp` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `edad` INT NULL,
  `contrato` DATE NULL,
  `cuota` DECIMAL(10,2) NULL,
  `ventas` DECIMAL(10,2) NULL,
  `cod_oficina` INT NULL,
  `jefe` INT NULL,
  PRIMARY KEY (`numemp`),
  CONSTRAINT `fk_oficina_en_empleados`
    FOREIGN KEY (`cod_oficina`)
    REFERENCES `mydb`.`oficinas` (`cod_oficina`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_jefe_empleados`
    FOREIGN KEY (`jefe`)
    REFERENCES `mydb`.`empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_oficina_en_empleados_idx` ON `mydb`.`empleados` (`cod_oficina` ASC) VISIBLE;

CREATE INDEX `fk_jefe_empleados_idx` ON `mydb`.`empleados` (`jefe` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
