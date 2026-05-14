use banco2;

SELECT * FROM clientes;
SELECT * FROM cuentas;
SELECT * FROM movimientos;
SELECT * FROM sucursales;


SELECT *
FROM sucursales
WHERE provincia = "Gipuzkoa";

SELECT * 
FROM movimientos
where cantidad < 0;

select numCuenta, saldo
from cuentas
where saldo > 100000 AND saldo < 300000;

select *
from clientes 
where nombre like '%l';

select numCuenta, s.provincia
from cuentas c 
inner join sucursales s on c.Sucursales_numSucursal = s.numSucursal
where provincia != 'Bizkaia';

select *
from movimientos
where fecha < '2020-01-01' and fecha > '2018-12-31';

select c. dni, c.nombre, c.apellido
from clientes c
inner join cuentas cu on c.dni = cu.Clientes_dni
inner join sucursales s on cu.Sucursales_numSucursal = s.numSucursal;



