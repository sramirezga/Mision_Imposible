-- =========================
-- INSERTS AJUSTADOS A banco2
-- =========================

-- CLIENTES
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('98587898', 'Miguel', 'Garcia');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('12389512', 'Antonio', 'Lasa');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('74859610', 'Ana', 'Perez');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('45467899', 'Juan', 'Rovira');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('56789969', 'Isabel', 'Sanchez');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('78794566', 'Juan', 'Victor');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('15998632', 'Juan', 'Canales');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('18742562', 'Aritz', 'Aramendi');
INSERT INTO Clientes (dni, nombre, apellido) VALUES ('78125264', 'Julia', 'Albizu');


-- SUCURSALES
INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (179, 'TRANABARREN, S/N', 'Abadiño', 'Bizkaia');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (15, 'EL CARMEN,5', 'Amorebieta', 'Bizkaia');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (503, 'Avda,Libertad 10', 'Donostia', 'Gipuzkoa');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (141, 'Euskal Herria, 20', 'Ibarra', 'Gipuzkoa');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (435, 'Avda. Langraiz', 'Iruña', 'Navarra');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (173, 'Heraclio Fournier,2', 'Gazteiz', 'Araba');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (309, 'Donostia, 37', 'Gazteiz', 'Araba');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (32, 'Trobika, 11', 'Munguia', 'Bizkaia');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (34, 'Santamañe, 2', 'Bermeo', 'Bizkaia');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (41, 'Lertzundi, 17', 'Deba', 'Gipuzkoa');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (248, 'Araba, 26', 'Zarautz', 'Gipuzkoa');

INSERT INTO Sucursales (numSucursal, direccion, poblado, provincia)
VALUES (217, 'Txofre,11 bajo', 'Donostia', 'Gipuzkoa');


-- CUENTAS
INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (125298, 1500, 98587898, 15);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (568945, 20453, 78125264, 173);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (254789, 12560, 18742562, 503);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (125478, 350000, 56789969, 503);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (129997, 200000, 18742562, 217);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (125879, 85000, 12389512, 32);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (458796, 45000, 74859610, 248);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (632011, 1200, 45467899, 141);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (987452, 6255, 78794566, 309);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (128796, 3000, 15998632, 179);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (336655, 6250, 18742562, 217);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (258745, 22500, 78125264, 34);

INSERT INTO Cuentas (numCuenta, saldo, Clientes_dni, Sucursales_numSucursal)
VALUES (528799, 120000, 15998632, 141);


-- MOVIMIENTOS
INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (1, -200, '2018-02-10', 125298);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (2, 600, '2018-03-25', 568945);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (3, -60, '2017-06-23', 254789);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (4, 120, '2015-05-12', 125478);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (5, -200, '2015-04-09', 129997);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (6, 2500, '2016-03-25', 125879);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (7, 1200, '2016-08-09', 458796);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (8, -300, '2017-02-02', 632011);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (9, 500, '2018-03-06', 987452);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (10, 200, '2018-09-04', 128796);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (11, -50, '2018-06-05', 258745);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (12, 600, '2019-01-15', 125879);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (13, 200, '2019-03-18', 568945);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (14, -450, '2019-01-25', 632011);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (15, 800, '2019-06-24', 987452);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (16, -50, '2019-05-26', 254789);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (17, 1200, '2019-07-25', 129997);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (18, 2400, '2019-08-13', 632011);

INSERT INTO Movimientos (numMovimiento, cantidad, fecha, Cuentas_numCuenta)
VALUES (19, -120, '2019-09-09', 987452);