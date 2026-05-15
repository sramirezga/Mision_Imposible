use mydb;

USE mydb;

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

UPDATE oficinas SET director = 106 WHERE cod_oficina = 11;
UPDATE oficinas SET director = 104 WHERE cod_oficina = 12;
UPDATE oficinas SET director = 105 WHERE cod_oficina = 13;
UPDATE oficinas SET director = 108 WHERE cod_oficina = 21;
UPDATE oficinas SET director = 108 WHERE cod_oficina = 22;
UPDATE oficinas SET director = 108 WHERE cod_oficina = 23;
UPDATE oficinas SET director = 108 WHERE cod_oficina = 24;








INSERT INTO clientes 
(numclie, nombre, representante_numemp, limite_credito) 
VALUES 
(2101, 'Luis Garcia', 102, 65000),
(2102, 'Alvaro Rodriguez', 101, 605000),
(2103, 'Jaime Llorens', 105, 50000),
(2105, 'Antonio Canales', 101, 45000),
(2106, 'Juan Suarez', 102, 65000),
(2107, 'Julian Lopez', 110, 35000),
(2108, 'Julia Antequera', 109, 55000),
(2109, 'Alberto Juanes', 103, 25000),
(2111, 'Cridtobal Garcia', 103, 50000),
(2112, 'Maria Silva', 109, 50000),
(2113, 'Luisa Maron', 103, 20000),
(2114, 'Cristina Marini', 102, 20000),
(2115, 'Vicente Martinez', 101, 20000),
(2117, 'Carlos Tena', 101, 35000),
(2118, 'June Alvarez', 105, 60000),
(2119, 'Salomon Bueno', 109, 25000),
(2120, 'Juan Malo', 102, 50000),
(2121, 'Vicente Rios', 103, 45000),
(2122, 'Jose Machante', 105, 30000),
(2123, 'Jose Libros', 102, 40000),
(2124, 'Juan Bolto', 107, 40000);

INSERT INTO fabricantes 
(idfab, nombre) 
VALUES
('aci', 'Acicat'),
('bic', 'Bic_Iberia'),
('imm', 'Ferreteria Imm'),
('qsa', 'Paqsacro'),
('rei', 'Ferreteria Rei'),
('fea', 'Fesmesa');

INSERT INTO productos 
(idfab, idproducto, descripcion, precio, existencias) 
VALUES 
('aci', '41001', 'arandela', 58.00, 4),
('aci', '41002', 'bisagra', 80.00, 167),
('aci', '41003', 'art t3', 112.00, 207),
('aci', '41004', 'art t4', 123.00, 139),
('aci', '4100x', 'junta', 26.00, 37),
('aci', '4100y', 'extractor', 2888.00, 25),
('aci', '4100z', 'mont', 2625.00, 28),
('bic', '41003', 'manivela', 652.00, 3),
('bic', '41089', 'rodamiento', 225.00, 78),
('bic', '41672', 'plato', 180.00, 0),
('fea', '112', 'cubo', 148.00, 115),
('fea', '114', 'cubo', 243.00, 15),
('fea', '887p', 'tornillo', 5.00, 32), 
('imm', '773c', 'reostato', 975.00, 28),
('imm', '775c', 'reostato 2', 1425.00, 5),
('imm', '779c', 'reostato 3', 1875.00, 0),
('imm', '887h', 'caja clavos', 54.00, 223),
('imm', '887p', 'perno', 25.00, 24),
('imm', '887x', 'manivela', 475.00, 32),
('qsa', 'xk47', 'red', 355.00, 38),
('qsa', 'xk48', 'red', 134.00, 203),
('qsa', 'xk48a', 'red', 117.00, 37),
('rei', '2a44g', 'pas', 350.00, 14),
('rei', '2a44l', 'bomba l', 4500.00, 12),
('rei', '2a44r', 'bomba r', 4500.00, 12),
('rei', '2a45c', 'junta', 79.00, 210),
('rei', 'xk48a', 'cubo', 100.00, 125);

INSERT INTO pedidos 
(idpedido, num_pedido, fecha_pedido, numclie, numemp, idfab, id_producto, cantidad, importe) 
VALUES 
(1, 110036, '2005-01-02', 2107, 110, 'aci', '4100z', 9, 22500.00),
(2, 110036, '2005-01-02', 2117, 102, 'rei', '2a44l', 7, 31500.00),
(3, 112963, '2005-05-10', 2103, 105, 'aci', '41004', 28, 3276.00),
(4, 112968, '1999-01-11', 2102, 101, 'aci', '41004', 34, 3978.00),
(5, 112975, '2005-02-11', 2111, 103, 'rei', '2a44g', 6, 2100.00),
(6, 112979, '2001-10-12', 2114, 103, 'aci', '4100z', 6, 15000.00),
(7, 112983, '2005-05-10', 2103, 105, 'aci', '41004', 6, 702.00),
(8, 112987, '2005-01-01', 2103, 105, 'aci', '4100y', 11, 27500.00),
(9, 112989, '2005-12-10', 2101, 101, 'fea', '114', 6, 1458.00),
(10, 112992, '1999-04-15', 2118, 110, 'aci', '41002', 10, 760.00),
(11, 112993, '2005-03-10', 2106, 102, 'rei', '2a45c', 24, 1896.00),
(12, 112997, '2005-04-04', 2124, 107, 'bic', '41003', 1, 652.00),
(13, 113003, '2005-02-05', 2108, 109, 'imm', '779c', 3, 5625.00),
(14, 113007, '2005-01-01', 2112, 102, 'imm', '773c', 3, 2925.00),
(15, 113012, '2005-05-05', 2111, 105, 'aci', '41003', 35, 3745.00),
(16, 113013, '2005-08-06', 2118, 101, 'bic', '41003', 1, 652.00),
(17, 113024, '2005-07-04', 2114, 109, 'qsa', 'xk47', 20, 7100.00),
(18, 113027, '2005-02-05', 2103, 105, 'aci', '41002', 54, 4104.00),
(19, 113034, '2005-11-05', 2107, 110, 'rei', '2a45c', 8, 632.00),
(20, 113042, '2005-01-01', 2113, 101, 'rei', '2a44r', 5, 22500.00),
(21, 113045, '2005-07-02', 2112, 109, 'rei', '2a44r', 10, 45000.00),
(22, 113048, '2005-02-02', 2120, 102, 'imm', '779c', 2, 3750.00),
(23, 113049, '2005-04-04', 2118, 107, 'qsa', 'xk47', 2, 776.00),
(24, 113051, '2005-07-06', 2118, 101, 'qsa', 'xk47', 4, 1420.00),
(25, 113055, '1999-04-01', 2108, 101, 'aci', '4100x', 6, 150.00),
(26, 113057, '2005-11-01', 2111, 103, 'aci', '4100x', 24, 600.00),
(27, 113058, '2000-07-04', 2108, 109, 'fea', '112', 10, 1480.00),
(28, 113058, '2005-07-04', 2108, 109, 'fea', '112', 10, 1480.00),
(29, 113062, '2005-07-04', 2111, 103, 'aci', '4100x', 24, 600.00),
(30, 113058, '1999-07-04', 2108, 109, 'fea', '112', 10, 1480.00),
(31, 113062, '2005-07-04', 2124, 107, 'bic', '41003', 10, 2430.00),
(32, 113065, '2005-06-03', 2106, 102, 'qsa', 'xk47', 6, 2130.00),
(33, 113069, '2005-08-01', 2109, 107, 'imm', '773c', 22, 31350.00);

INSERT INTO titulos 
(numemp, titulo) 
VALUES 
(101, 'administrativo'),
(102, 'representante'),
(103, 'administrativo'),
(104, 'empresariales'),
(105, 'comercio'),
(106, 'finanzas'),
(107, 'comercio'),
(108, 'empresariales'),
(109, 'administrativo'),
(110, 'comercio'),
(104, 'informatica'),
(101, 'finanzas'),
(106, 'comunicaciones'),
(102, 'comercio'),
(102, 'administrativo'),
(105, 'informatica');