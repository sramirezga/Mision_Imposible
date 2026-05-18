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

select numemp, nombre, datediff(current_date(),contrato), year(current_date()) -edad
from empleados

