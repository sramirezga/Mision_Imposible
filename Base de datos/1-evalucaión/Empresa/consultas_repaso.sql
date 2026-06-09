

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

use mydb;

select * 
from nominas
where numNomina in (
select nomina_numNomina
from gestionada
where director_numemp = (
select numemp
from empleados
where nombre = 'Luis Antonio'
));

select idfab, idproducto, descripcion
from productos
where (idfab, idproducto) not in (
select idfab, id_producto
from pedidos
where importe > 2500
);

select *
from clientes c inner join pedidos p 
on c.numclie = p.numclie
where p.importe < 3000 and
 representante_numemp in (
select numemp
from empleados
where nombre = 'Juan Rovira'
);

select *
from oficinas
where cod_oficina in (
select em.cod_oficina
from empleados em inner join oficinas o
on em.cod_oficina = o.cod_oficina
where o.ventas > o.objetivo * 0.55
);




