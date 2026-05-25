-- MySQL Workbench Forward Engineering corregido

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `mydb`;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8;
USE `mydb`;

-- -----------------------------------------------------
-- Table `oficinas`
-- La FK director se añade después, porque apunta a empleados
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pedidos`;
DROP TABLE IF EXISTS `titulos`;
DROP TABLE IF EXISTS `clientes`;
DROP TABLE IF EXISTS `productos`;
DROP TABLE IF EXISTS `fabricantes`;
DROP TABLE IF EXISTS `empleados`;
DROP TABLE IF EXISTS `oficinas`;

CREATE TABLE IF NOT EXISTS `oficinas` (
  `cod_oficina` INT NOT NULL,
  `ciudad` VARCHAR(45) NULL,
  `region` VARCHAR(45) NULL,
  `objetivo` DECIMAL(10,2) NULL,
  `ventas` DECIMAL(10,2) NULL,
  `director` INT NULL,
  PRIMARY KEY (`cod_oficina`)
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empleados` (
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
    REFERENCES `oficinas` (`cod_oficina`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,

  CONSTRAINT `fk_jefe_empleados`
    FOREIGN KEY (`jefe`)
    REFERENCES `empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE INDEX `fk_oficina_en_empleados_idx` 
ON `empleados` (`cod_oficina` ASC) VISIBLE;

CREATE INDEX `fk_jefe_empleados_idx` 
ON `empleados` (`jefe` ASC) VISIBLE;

-- Ahora añadimos la relación director -> empleados
ALTER TABLE `oficinas`
ADD CONSTRAINT `fk_director_oficina`
FOREIGN KEY (`director`)
REFERENCES `empleados` (`numemp`)
ON DELETE NO ACTION
ON UPDATE CASCADE;

CREATE INDEX `fk_director_oficina_idx` 
ON `oficinas` (`director` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clientes` (
  `numclie` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `limite_credito` DECIMAL(10,2) NULL,
  `representante_numemp` INT NOT NULL,
  PRIMARY KEY (`numclie`),

  CONSTRAINT `fk_clientes_empleados1`
    FOREIGN KEY (`representante_numemp`)
    REFERENCES `empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE INDEX `fk_clientes_empleados1_idx` 
ON `clientes` (`representante_numemp` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `fabricantes`
-- idfab debe ser VARCHAR porque los datos son aci, bic, imm...
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fabricantes` (
  `idfab` VARCHAR(3) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idfab`)
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `productos`
-- idproducto debe ser VARCHAR porque hay códigos como 4100x, 887p, xk47...
-- La clave primaria es compuesta: idproducto + idfab
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productos` (
  `idproducto` VARCHAR(10) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `precio` DECIMAL(10,2) NULL,
  `existencias` INT NULL,
  `idfab` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idproducto`, `idfab`),

  CONSTRAINT `fk_idfab_producto`
    FOREIGN KEY (`idfab`)
    REFERENCES `fabricantes` (`idfab`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE INDEX `fk_idfab_producto_idx` 
ON `productos` (`idfab` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `pedidos`
-- Tiene id_producto + idfab para poder relacionar bien con productos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos` (
  `idpedido` INT NOT NULL,
  `num_pedido` INT NOT NULL,
  `fecha_pedido` DATE NULL,
  `importe` DECIMAL(10,2) NULL,
  `numclie` INT NULL,
  `numemp` INT NULL,
  `id_producto` VARCHAR(10) NULL,
  `idfab` VARCHAR(3) NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`idpedido`),

  CONSTRAINT `fk_cliente_pedidos`
    FOREIGN KEY (`numclie`)
    REFERENCES `clientes` (`numclie`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,

  CONSTRAINT `fk_empleado_pedidos`
    FOREIGN KEY (`numemp`)
    REFERENCES `empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,

  CONSTRAINT `fk_producto_pedido`
    FOREIGN KEY (`id_producto`, `idfab`)
    REFERENCES `productos` (`idproducto`, `idfab`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE INDEX `fk_cliente_pedidos_idx` 
ON `pedidos` (`numclie` ASC) VISIBLE;

CREATE INDEX `fk_empleado_pedidos_idx` 
ON `pedidos` (`numemp` ASC) VISIBLE;

CREATE INDEX `fk_producto_pedido_idx` 
ON `pedidos` (`id_producto` ASC, `idfab` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `titulos`
-- Un empleado puede tener varios títulos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `titulos` (
  `numemp` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numemp`, `titulo`),

  CONSTRAINT `fk_titulos_empleados`
    FOREIGN KEY (`numemp`)
    REFERENCES `empleados` (`numemp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


/*----------parte 3 empresa----------*/

select * from empleados;

describe empleados;
use mydb;

alter table empleados 
add tipo varchar(20);

create table representantes(
numemp int primary key,
cuota decimal(10,2),
ventas decimal(10,2)
);


create table directores (
numemp int primary key
);

update empleados
set tipo = 'director'
where numemp in (
select director
from oficinas
);

update empleados
set tipo = 'representante'
where tipo is null;

insert into representantes (numemp, cuota, ventas) 
select numemp, cuota, ventas
from empleados e 
where tipo = 'representante';

select * from directores;

insert into directores (numemp) 
select numemp
from empleados 
where tipo = 'director';

alter table empleados
drop column ventas,
drop column cuota;

select * from empleados;

alter table empleados
modify tipo varchar(30) not null;

/* Restrictiva   */
alter table empleados
add check (tipo in ('representante', 'director'));

select * from representantes;


alter table directores
add constraint fk_directores_numemp
foreign key (numemp) references empleados(numemp)
on update cascade on delete restrict;

alter table directores
drop foreign key fk_directores_numemp
;


alter table representantes 
add constraint fk_representante_numemp
foreign key (numemp) references empleados(numemp)
on update cascade on delete restrict;



create table nominas (
numNomina int primary key,
fechainicio date,
fechafin date,
importe decimal(10,2),
numemp int,

 foreign key (numemp) references empleados(numemp)
);

SHOW CREATE TABLE nominas;



create table gestionada (
director_numemp int ,
nomina_numNomina int ,

primary key (director_numemp, nomina_numNomina),

foreign key (director_numemp) references directores(numemp)
on update cascade on delete restrict,
foreign key (nomina_numNomina) references nominas(numNomina)
on update cascade on delete restrict
);













