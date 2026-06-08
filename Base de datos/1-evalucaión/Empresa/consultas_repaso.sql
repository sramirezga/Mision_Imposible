

use mydb;


select * from clientes;
select * from representantes;

select nombre
from clientes
where representante_numemp in  ( 
select numemp
from empleados
where nombre = 'Alvaro Jaumes');

select numemp, nombre, cod_oficina
from empleados
where cod_oficina in (
select cod_oficina
from oficinas
where ventas > objetivo
);


select * from oficinas;

select *
from empleados
where numemp not in (
select director
from oficinas
where director != 108
);

select *
from oficinas
where director = 108;

select * from empleados where cod_oficina in (21, 22, 23, 24);

