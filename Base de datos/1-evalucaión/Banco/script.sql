-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema banco2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `banco2` ;

-- -----------------------------------------------------
-- Schema banco2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banco2` DEFAULT CHARACTER SET utf8 ;
USE `banco2` ;

-- -----------------------------------------------------
-- Table `banco2`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banco2`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `banco2`.`Clientes` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco2`.`Sucursales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banco2`.`Sucursales` ;

CREATE TABLE IF NOT EXISTS `banco2`.`Sucursales` (
  `numSucursal` INT NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `poblado` VARCHAR(45) NULL,
  `provincia` VARCHAR(45) NULL,
  PRIMARY KEY (`numSucursal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco2`.`Cuentas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banco2`.`Cuentas` ;

CREATE TABLE IF NOT EXISTS `banco2`.`Cuentas` (
  `numCuenta` INT NOT NULL,
  `saldo` DOUBLE NULL,
  `Clientes_dni` INT NOT NULL,
  `Sucursales_numSucursal` INT NOT NULL,
  PRIMARY KEY (`numCuenta`),
  CONSTRAINT `fk_Cuentas_Clientes`
    FOREIGN KEY (`Clientes_dni`)
    REFERENCES `banco2`.`Clientes` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cuentas_Sucursales1`
    FOREIGN KEY (`Sucursales_numSucursal`)
    REFERENCES `banco2`.`Sucursales` (`numSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cuentas_Clientes_idx` ON `banco2`.`Cuentas` (`Clientes_dni` ASC) VISIBLE;

CREATE INDEX `fk_Cuentas_Sucursales1_idx` ON `banco2`.`Cuentas` (`Sucursales_numSucursal` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `banco2`.`Movimientos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banco2`.`Movimientos` ;

CREATE TABLE IF NOT EXISTS `banco2`.`Movimientos` (
  `numMovimiento` INT NOT NULL,
  `cantidad` DOUBLE NULL,
  `fecha` DATE NULL,
  `Cuentas_numCuenta` INT NOT NULL,
  PRIMARY KEY (`numMovimiento`),
  CONSTRAINT `fk_Movimientos_Cuentas1`
    FOREIGN KEY (`Cuentas_numCuenta`)
    REFERENCES `banco2`.`Cuentas` (`numCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Movimientos_Cuentas1_idx` ON `banco2`.`Movimientos` (`Cuentas_numCuenta` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
