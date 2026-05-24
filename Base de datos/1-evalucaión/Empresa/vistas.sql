

use mydb;

show databases;

create view PEDIDOS_30000 as
select *
from pedidos
where importe > 30000;

select *
from PEDIDOS_30000;

insert into pedidos
(idpedido, num_pedido, fecha_pedido, numclie, numemp, idfab, id_producto, cantidad, importe)
values
(40, 110036, '2005-01-02 00:00:00', 2107, 110, 'aci', '4100z', 9, 22500.0000);

insert into pedidos
(idpedido, num_pedido, fecha_pedido, numclie, numemp, idfab, id_producto, cantidad, importe)
values
(41, 110036, '2005-01-02 00:00:00', 2117, 102, 'rei', '2a44l', 7, 31500.0000);

insert into PEDIDOS_30000
(idpedido, num_pedido, fecha_pedido, numclie, numemp, idfab, id_producto, cantidad, importe) values
(50, 110036, '2005-01-02 00:00:00', 2107, 110, 'aci', '4100z', 9, 22500.0000);

insert into PEDIDOS_30000
(idpedido, num_pedido, fecha_pedido, numclie, numemp, idfab, id_producto, cantidad, importe) values
(51, 110036, '2005-01-02 00:00:00', 2117, 102, 'rei', '2a44l', 7, 31500.0000);

create view CLIENTES_50000 as
select *
from clientes
where limite_credito > 50000
with check option;

select * 
from clientes_50000;

insert into clientes
(numclie, nombre, representante_numemp, limite_credito) values
(2130, 'Patxi Iturriotz', 102, 45000);

insert into clientes
(numclie, nombre, representante_numemp, limite_credito) values
(2131, 'Xorkun Irizar', 102, 65000);


