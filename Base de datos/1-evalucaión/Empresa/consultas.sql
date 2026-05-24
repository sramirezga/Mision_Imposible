use mydb;

select * from empleados where nombre like "%Jose%";

select * from empleados where nombre like "J%";

select * from oficinas where region in ("Norte", "Este");

select * from oficinas ;

select * from oficinas 
order by region asc, ciudad asc, cod_oficina desc;

select cod_oficina, ciudad, region
from oficinas
where region in( "Norte", "Este")
order by 
case
when region = "Norte" then 1
when  region = "Este" then 2
end;


select e.numemp
from empleados e inner join oficinas o
on e.cod_oficina = o.cod_oficina;

select * from oficinas;
select cod_oficina
from oficinas 
where director is null;

select e.nombre, e.edad, o.region 
from empleados e inner join oficinas o
on e.cod_oficina = o.cod_oficina;

select o.cod_oficina, o.objetivo, e.nombre
from oficinas o inner join empleados e 
on o.director = e.numemp
where objetivo between 300000 and 600000;

select o.cod_oficina, o.ciudad, e.numemp, e.nombre
from oficinas o inner join empleados e
on o.cod_oficina = e.cod_oficina
where region in ("este", "oeste");

select o.cod_oficina, o.ciudad, e.numemp, e.nombre
from oficinas o left join empleados e
on o.cod_oficina = e.cod_oficina
where region in ("este", "oeste");

select o.cod_oficina, o.ciudad, e.numemp, e.nombre
from oficinas o inner join empleados e
on o.director = e.numemp 
where region in ("este", "oeste");

select o.cod_oficina, o.ciudad, e.numemp, e.nombre
from oficinas o left join empleados e
on o.director = e.numemp 
where region in ("este", "oeste");

select nombre, datediff(current_date,contrato) as dias_trabjados, year(current_date()) - edad as año_de_contrato
from empleados;

select nombre, contrato, edad
from empleados
where edad > 50;

select nombre, edad
from empleados
where cod_oficina = 12
order by edad asc;

select nombre, edad, cuota
from empleados
where cuota between 350000 and 500000;

select *
from empleados
where ventas >= cuota;

select ciudad
from oficinas
where region = 'este' and objetivo > 500000;

select cod_oficina, ciudad, ventas
from oficinas 
where region = "este" and ciudad not in ("madrid","valencia") ;

/*----------Parte 2*/


select * from productos where precio > 200;
select * from productos where precio > 99 and precio < 201;


select  idfab, idproducto, descripcion, precio, precio * 1.21 as precioIva
from productos;

select pe.idpedido, pe.idfab, pe.id_producto, pe.cantidad, pro.precio, pe.importe
from pedidos pe inner join productos pro on pe.idfab = pro.idfab;

select *
from clientes
order by representante_numemp asc;

select * from pedidos order by fecha_pedido asc;

select * from pedidos order by importe desc limit 4;

select pe.idpedido, pe.idfab, pe.id_producto, pe.cantidad, pro.precio, pe.importe
from pedidos pe inner join productos pro on pe.idfab = pro.idfab
order by pro.precio asc limit 5;

select *
from pedidos
where month(fecha_pedido) =3;

select p.idpedido, p.importe, c.nombre, c.limite_credito
from pedidos p inner join clientes c 
on p.numclie = c.numclie;

select pro.descripcion, pro.precio
from pedidos pe inner join productos pro
on pe.idfab = pro.idfab
where month(pe.fecha_pedido) = 2;

select pe.idpedido, pe.importe, pe.id_producto, 
e.nombre as Nombre_empleado, c.nombre as Nombre_cliente
from pedidos pe inner join empleados e
on pe.numemp =  e.numemp
inner join clientes c
on pe.numclie = c.numclie
where pe.importe > 25000;

select distinct e.numemp
from empleados e inner join pedidos p
on e.numemp = p.numemp
where p.importe > 10000 or e.cuota < 10000
order by e.numemp asc;

select pro.descripcion, c.nombre as Nombre_Cliente, e.nombre as Nombre_Empleado, o.region
from productos pro 
inner join pedidos p on pro.idproducto = p.id_producto
inner join clientes c on p.numclie = c.numclie
inner join empleados e on c.representante_numemp = e.numemp
inner join oficinas o on e.cod_oficina = o.cod_oficina 
where o.region in ("Norte","Oeste");

select e.numemp, min(p.fecha_pedido)
from empleados e inner join pedidos p 
on e.numemp = p.numemp
group by e.numemp, e.contrato
having  e.contrato = min(p.fecha_pedido)
or year(min(p.fecha_pedido)) - year(e.contrato) = 17;
/*si el contrato es igual a la fecha del pedido */
/*si el año del pedido - al año del contrato es 17 */


/*having filtrar los resultados de las funciones
year() devuelve el año
min() ejem primer pedido 
*/

/*
select numemp, nombre, datediff(current_date(),contrato), year(current_date()) -edad
from empleados */


/*reflexiba*/
select e.numemp, e.nombre, e.cuota, j.nombre as nombre_jefe, j.cuota as cuota_jefe
from empleados e inner join empleados j on e.jefe = j.numemp
where e.cuota >= j.cuota;

select avg(cuota), avg(ventas) 
from empleados;

select avg(pe.importe) as importe_medio, sum(pe.importe) as importe_total_pedidos,
avg(pro.precio) as precio_media_venta
from pedidos pe inner join productos pro on pe.id_producto = pro.idproducto;

select avg(precio) as precio_medio
from productos
where idfab = 'aci';


select sum(p.importe) as importe_total
from pedidos p inner join empleados e on p.numemp = e.numemp
where e.nombre = 'Vicente Pantalla';

select min(fecha_pedido)
from pedidos;

select count(idpedido)
from pedidos
where importe > 1500;



/*-------Copias de todas las tablas -------------*/

create table nuevaempleados as
select * 
from empleados;

select * from nuevaempleados;

create table nuevaoficinas as
select *
from oficinas;

create table nuevaproductos as
select * 
from productos;

create table nuevapedidos as
select *
from pedidos;

create table nuevaclientes as
select * 
from clientes;

SET SQL_SAFE_UPDATES = 0;

update nuevaproductos
set precio = precio * 1.05
where idfab = 'aci';

insert into nuevaoficinas(cod_oficina,ciudad, region,objetivo)
values(30, 'Madrid', 'centro', 600);

select * from nuevaoficinas where cod_oficina = 30;

update nuevaempleados
set cod_oficina = 30
where cod_oficina = 21;


select * from nuevapedidos where numemp =  105;
delete from nuevapedidos where numemp = 105;

update nuevaempleados
set cod_oficina = 21
where cod_oficina = 30;

update nuevaclientes
set limite_credito = limite_credito + 100
where nombre like 'J%';



select * from nuevaproductos  where idfab = 'aci';
delete from nuevaproductos where idfab = 'aci';

select * from nuevaclientes where numclie = 2120;

update nuevaclientes
set nombre = 'Jon bueno', limite_credito = limite_credito * 1.01
where numclie = 2120;

describe nuevaclientes;

/*Añade una foren key wn la tabla clientes con empleados*/
alter table nuevaclientes
add constraint fk_nuevaclientes_nuevaempleados
foreign key (representante_numemp) references nuevaempleados(numemp)
on update cascade
on delete set null;

select * from nuevaclientes;
select * from nuevaempleados;

select *
from nuevaclientes
where numclie = 109;

delete from nuevaempleados where numemp = 109;

select * 
from nuevaclientes
where representante_numemp = 201;

update nuevaempleados
set numemp = 201
where numemp = 101;

select *
from nuevaclientes
where representante_numemp = 101;

/*38*/

update nuevaoficinas
set cod_oficina = 112
where cod_oficina = 12;

select * from nuevaoficinas where cod_oficina = 12;


/* ----------------------parte 3  empresa-----------------------------*/


/*Subsconsultas*/

use mydb;

select nombre
from clientes 
where representante_numemp = (
select numemp
from empleados
where nombre = 'Alvaro Jaumes'
);

select numemp, nombre, cod_oficina
from empleados
where cod_oficina in (
select cod_oficina
from oficinas
where ventas > objetivo
);


select *
from empleados
where cod_oficina not in (
select cod_oficina
from oficinas
where director = 108
 );
 
 select *
 from nominas
 where numNomina in  (
 select nomina_numNomina
 from gestionada
 where director_numemp = (
 select numemp
 from empleados
 where nombre = 'Luis Antonio'
 ));
 
 select idfab, idproducto, descripcion
 from productos
 where (idproducto, idfab)not in (
 select id_producto, idfab
 from pedidos
 where importe >= 25000
 );
 
 select *
 from clientes 
 where representante_numemp = (
 select numemp
 from empleados
 where nombre = 'Juan Rovira' 
 ) 
 and numclie not in (
 select numclie
 from pedidos
 where importe > 3000
 );
 
 select *
 from oficinas
 where cod_oficina in  (
 select e.cod_oficina
 from empleados e inner join oficinas o on o.cod_oficina = e.cod_oficina
 where o.ventas > o.objetivo * 0.55
 );
 
 select *
 from nominas
 where numemp in (
 select numemp
 from empleados
 where cod_oficina in (
 select cod_oficina
 from oficinas
 where region = 'Oeste'
 ));
 
 
 
 /*Subconsultas group by*/
 
 select cod_oficina, count(*) as asignados
 from empleados
 group by cod_oficina;
 
 select e.numemp, e.nombre, p.numclie, sum(p.importe) as importe_vendido
 from empleados e inner join pedidos p on e.numemp = p.numemp
 group by e.numemp, e.nombre, p.numclie;
 
 select idfab, count(*) as cantidad_productos, avg(precio) as media
 from productos
 group by idfab;
 
 
 
