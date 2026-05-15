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


-- -----------------------------------------------------
-- Table `mydb`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`clientes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`clientes` (
  `numclie` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `limite_credito` DECIMAL(10,2) NULL,
  `representante_numemp` INT NOT NULL,
  PRIMARY KEY (`numclie`),
  CONSTRAINT `fk_clientes_empleados1`
    FOREIGN KEY (`representante_numemp`)
    REFERENCES `mydb`.`empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_clientes_empleados1_idx` ON `mydb`.`clientes` (`representante_numemp` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`fabricantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`fabricantes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`fabricantes` (
  `idfab` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idfab`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`productos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`productos` (
  `idproducto` INT NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `precio` DECIMAL(10,2) NULL,
  `existencias` INT NULL,
  `idfab` INT NOT NULL,
  PRIMARY KEY (`idproducto`, `idfab`),
  CONSTRAINT `fk_idfab_producto`
    FOREIGN KEY (`idfab`)
    REFERENCES `mydb`.`fabricantes` (`idfab`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_idfab_producto_idx` ON `mydb`.`productos` (`idfab` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`pedidos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`pedidos` (
  `idpedido` INT NOT NULL,
  `num_pedido` INT NOT NULL,
  `fecha_pedido` DATE NULL,
  `importe` DECIMAL(10,2) NULL,
  `numclie` INT NULL,
  `numemp` INT NULL,
  `id_producto` INT NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`idpedido`),
  CONSTRAINT `fk_cliente_pedidos`
    FOREIGN KEY (`numclie`)
    REFERENCES `mydb`.`clientes` (`numclie`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_pedidos`
    FOREIGN KEY (`numemp`)
    REFERENCES `mydb`.`empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_porducto_pedido`
    FOREIGN KEY (`id_producto`)
    REFERENCES `mydb`.`productos` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_cliente_pedidos_idx` ON `mydb`.`pedidos` (`numclie` ASC) VISIBLE;

CREATE INDEX `fk_empleado_pedidos_idx` ON `mydb`.`pedidos` (`numemp` ASC) VISIBLE;

CREATE INDEX `fk_porducto_pedido_idx` ON `mydb`.`pedidos` (`id_producto` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`titulos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`titulos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`titulos` (
  `numemp` INT NOT NULL,
  `titulos` VARCHAR(45) NULL,
  PRIMARY KEY (`numemp`),
  CONSTRAINT `fk_ttulos_empleados`
    FOREIGN KEY (`numemp`)
    REFERENCES `mydb`.`empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
