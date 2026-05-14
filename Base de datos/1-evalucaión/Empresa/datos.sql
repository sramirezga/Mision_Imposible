
use mydb;

INSERT INTO oficinas 
(cod_oficina, ciudad, region, objetivo, ventas, director) 
VALUES 
(11, 'Valencia', 'este', 575000, 693000, NULL),
(12, 'Alicante', 'este', 800000, 735000, NULL),
(13, 'Castellón', 'este', 350000, 368000, NULL),
(21, 'Badajoz', 'oeste', 725000, 836000, NULL),
(22, 'A Coruña', 'oeste', 300000, 186000, NULL),
(23, 'Madrid', 'centro', NULL, NULL, NULL),
(24, 'Madrid', 'centro', 250000, 150000, NULL),
(26, 'Pamplona', 'norte', NULL, NULL, NULL),
(28, 'Valencia', 'este', 900000, 0, NULL);

INSERT INTO empleados 
(numemp, nombre, edad, contrato, cuota, ventas, cod_oficina, jefe) 
VALUES 
(101, 'Antonio Viguer', 45, '1986-10-20', 300000, 305000, 12, NULL),
(102, 'Alvaro Jaumes', 48, '1986-12-10', 350000, 474000, 21, NULL),
(103, 'Juan Rovira', 29, '1987-03-01', 275000, 286000, 12, NULL),
(104, 'Jose Gonzalez', 33, '1987-05-19', 20000, 143000, 12, NULL),
(105, 'Vicente Pantalla', 37, '1988-02-12', 350000, 368000, 13, NULL),
(106, 'Luis Antonio', 52, '1988-06-14', 275000, 299000, 11, NULL),
(107, 'Jorge Gutierrez', 49, '1988-11-14', 300000, 186000, 22, NULL),
(108, 'Ana Bustamante', 62, '1989-10-12', 350000, 361000, 21, NULL),
(109, 'Maria Sunta', 31, '1999-10-12', 30000, 392000, 11, NULL),
(110, 'Juan Victor', 41, '1990-01-13', 0, 76000, NULL, NULL);




UPDATE empleados SET jefe = 104 WHERE numemp = 101;
UPDATE empleados SET jefe = 108 WHERE numemp = 102;
UPDATE empleados SET jefe = 104 WHERE numemp = 103;
UPDATE empleados SET jefe = 106 WHERE numemp = 104;
UPDATE empleados SET jefe = 104 WHERE numemp = 105;
UPDATE empleados SET jefe = 108 WHERE numemp = 107;
UPDATE empleados SET jefe = 106 WHERE numemp = 108;
UPDATE empleados SET jefe = 106 WHERE numemp = 109;
UPDATE empleados SET jefe = 104 WHERE numemp = 110;