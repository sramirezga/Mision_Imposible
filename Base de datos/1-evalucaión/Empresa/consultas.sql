
use mydb;

select * from productos where precio > 200;
select * from productos where precio > 99 and precio < 201;


select  idfab, idproducto, descripcion, precio, precio * 1.21 as precioIva
from productos;

select pe.idpedido, pe.idfab, pe.id_producto, pe.cantidad, pro.precio, pe.importe
from pedidos pe inner join productos pro on pe.idfab = pro.idfab;