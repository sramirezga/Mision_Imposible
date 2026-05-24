ALTER SESSION SET nls_date_format='yyyy-mm-dd';
set define on;
drop table participante cascade constraints;
drop table organizador cascade constraints;
drop table conductor cascade constraints;
drop table parte_equipo cascade constraints;
drop table equipo cascade constraints;
drop table sponsor cascade constraints;
drop table coche cascade constraints;
drop table competir cascade constraints;
drop table carrera cascade constraints;
drop table circuito cascade constraints;

create table participante(
id_participante varchar2(5),
DNI varchar2(9),
nombre varchar2(10),
direccion varchar2(50),
telefono varchar2(9),
tipo varchar2(20),
Primary key (id_participante));

create table organizador(
id_organizador varchar2(5),
publico INT,
id_director varchar2(5),
Primary key (id_organizador));

create table conductor(
id_conductor varchar2(5),
nivel VARCHAR2(20),
Primary key (id_conductor));

create table parte_equipo(
id_conductor varchar2(5),
id_equipo varchar2(5),
temporada varchar2(5),
Primary key (id_conductor, id_equipo));

create table equipo(
id_equipo varchar2 (5),
nombre varchar2(10),
Primary key (id_equipo));

create table sponsor(
id_equipo varchar2(5),
sponsor varchar2(30),
primary key(id_equipo, sponsor));

create table coche(
id_coche varchar2(5),
tipo varchar2(15),
modelo varchar2(10),
id_equipo varchar2(5),
Primary key (id_coche));

Create table competir(
id_circuito varchar2(5),
id_carrera varchar2(5),
id_coche varchar2(5),
Primary key (id_circuito, id_carrera, id_coche));

create table carrera(
id_circuito varchar2(5),
id_carrera varchar2(5),
carrera_fecha date,
costo integer,
id_organizador varchar2(5),
Primary key (id_circuito, id_carrera));

create table circuito(
id_circuito varchar2(5),
nombre varchar2 (10), 
descripcion varchar2(15), 
Primary key (id_circuito));

/*Taulen arteko Erlazioak */

Alter table organizador add FOREIGN KEY(id_organizador) REFERENCES participante(id_participante);
Alter table organizador add FOREIGN KEY(id_director) REFERENCES organizador(id_organizador);
Alter table conductor add FOREIGN KEY(id_conductor) REFERENCES participante(id_participante);
Alter table parte_equipo add FOREIGN KEY(id_conductor) REFERENCES conductor(id_conductor);
Alter table parte_equipo add FOREIGN KEY(id_equipo) REFERENCES equipo(id_equipo);
Alter table sponsor add FOREIGN KEY(id_equipo) REFERENCES equipo(id_equipo) ;
Alter table coche add FOREIGN KEY(id_equipo) REFERENCES equipo(id_equipo);
Alter table competir add FOREIGN KEY(id_circuito, id_carrera) REFERENCES carrera(id_circuito, id_carrera);
Alter table competir add FOREIGN KEY(id_coche) REFERENCES coche(id_coche);
Alter table carrera add FOREIGN KEY(id_circuito) REFERENCES circuito(id_circuito);
Alter table carrera add FOREIGN KEY(id_organizador) REFERENCES organizador(id_organizador);

/* Datuak */
Insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (1,'19890724X','Iker', 'Santiago 12, 4.A Eibar', '688646567', 'organizador');
insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (2,'16890724A','Mikel', 'Zubitxo 12, 2.A Errenteria', '667411518', 'organizador');
insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo)  values (3,'19898724V','Pepe', 'Estrada_kalea 3, 2.Esk Irun', '688457585', 'conductor'); 
insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (4,'19890728T','Jon', 'Zuazola 43, z/g Azpeitia', '665686968', 'conductor'); 
Insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (5,'19890723Y','Ione','Floreaga_kalea 2, 3.Ezk Azpeitia','667421215','organizador'); 
Insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (6,'29890723W','Unai','San Martin 12, 6.A Azkoitia','667847445', 'conductor'); 
Insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (7,'39890723W','Julen','Altzibal 23, 1.B Errezil','668454142','conductor'); 
Insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (8,'49890723Q','Aitor','Etxetxiki z/g Azpeitia','655646768','organizador'); 
Insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (9,'59890723D', 'Leire', 'Jaizkibel 28, 3.Esk Pasai Donibane','668412475','organizador'); 
Insert into participante(id_participante, DNI, nombre, direccion, telefono, tipo) values (10,'69890723T','Lierni','Olazar 1, 2.D Zumaia', '337858472','conductor');

Insert into organizador (id_organizador, publico, id_director) values (1, 1, NULL);
Insert into organizador (id_organizador, publico, id_director) values (2, 0, 1);
Insert into organizador (id_organizador, publico, id_director) values (5, 1, NULL);
Insert into organizador (id_organizador, publico, id_director) values (8, 1, 1);
Insert into organizador (id_organizador, publico, id_director) values (9, 1, NULL);

Insert into conductor (id_conductor, nivel) values (3, 'Senior');
Insert into conductor (id_conductor, nivel) values (4, 'Senior');
Insert into conductor (id_conductor, nivel) values (6, 'Junior');
Insert into conductor (id_conductor, nivel) values (7, 'Teen');
Insert into conductor (id_conductor, nivel) values (10, 'Senior');

Insert into equipo (id_equipo,nombre) values ('t1','redbull');
Insert into equipo (id_equipo,nombre) values ('t2','ferrari');
Insert into equipo (id_equipo,nombre) values ('t3','mclaren');
Insert into equipo (id_equipo,nombre) values ('t4','lotus');
Insert into equipo (id_equipo,nombre) values ('t5','renault');

Insert into parte_equipo (id_conductor, id_equipo, temporada) values (3,'t3',2019);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (3,'t1',2018);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (3,'t2',2015);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (4,'t4',2017);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (4,'t1',2012);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (4,'t5',2015);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (7,'t4',2016);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (7,'t1',2019);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (10,'t5',2017);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (10,'t3',2013);
Insert into parte_equipo (id_conductor, id_equipo, temporada) values (10,'t2',2012);

insert into sponsor(id_equipo, sponsor) values('t1', 'Williams');
insert into sponsor(id_equipo, sponsor) values('t1', 'Pepsi');
insert into sponsor(id_equipo, sponsor) values('t1', 'Cola-Cola');
insert into sponsor(id_equipo, sponsor) values('t1', 'Ray Ban');
insert into sponsor(id_equipo, sponsor) values('t2', 'Guillette');
insert into sponsor(id_equipo, sponsor) values('t2', 'Red-Bull');
insert into sponsor(id_equipo, sponsor) values('t2', 'Oracle');
insert into sponsor(id_equipo, sponsor) values('t3', 'Google');
insert into sponsor(id_equipo, sponsor) values('t4', 'Microsoft');
insert into sponsor(id_equipo, sponsor) values('t4', 'Pepsi');
insert into sponsor(id_equipo, sponsor) values('t4', 'Zara');
insert into sponsor(id_equipo, sponsor) values('t5', 'Pepsi');
insert into sponsor(id_equipo, sponsor) values('t5', 'Zara');
insert into sponsor(id_equipo, sponsor) values('t5', 'Coca-Cola');
insert into sponsor(id_equipo, sponsor) values('t5', 'Facebook');

Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k1','1000Z','Nuevo','t1');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k2','1000Z','Nuevo','t1');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k3','1500Z','Antiguo','t2');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k4','1500Z','Antiguo','t2');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k5','1500Z','Nuevo','t3');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k6','1500Z','Antiguo','t4');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k7','1300Z','Nuevo','t4');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k8','1000Z','Antiguo','t3');
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k9','1300Z','Nuevo','t2'); 
Insert into coche(id_coche, tipo, modelo, id_equipo) values ('k10','1500Z','Antiguo','t5');

Insert into circuito (id_circuito, nombre, descripcion) values ('z1','Spa','belgica');
Insert into circuito (id_circuito, nombre, descripcion) values ('z2','Monza','italia');
Insert into circuito (id_circuito, nombre, descripcion) values ('z3','Suzuka','japon');
Insert into circuito (id_circuito, nombre, descripcion) values ('z4','Shakir','bahrein');
Insert into circuito (id_circuito, nombre, descripcion) values ('z5','Melbourne','australia');
Insert into circuito (id_circuito, nombre, descripcion) values ('z6','San Marino','San Marino');

Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z1','l1','2018-01-01', 4500000, 1);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z1','l2','2018-03-12', 3000000, 2);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z1','l3','2019-01-01', 3500000, 5);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z2','l1','2018-05-04', 2500000, 8);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z2','l2','2019-05-05', 4000000, 9);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z3','l1','2018-06-02', 4500000, 2);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z3','l2','2019-06-06', 6000000, 8);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z4','l1','2009-05-05', 5500000, 1);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z5','l1','2009-06-24', 5000000, 8);
Insert into carrera (id_circuito, id_carrera, carrera_fecha, costo, id_organizador) values('z6','l2','2019-04-22', 6500000, 5);

Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l1', 'k1');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l1', 'k2');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l1', 'k3');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l1', 'k10');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l2', 'k1');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l2', 'k3');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l2', 'k4');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l3', 'k2');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l3', 'k4');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l3', 'k6');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l3', 'k7');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z1','l3', 'k10');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l1', 'k6');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l1', 'k7');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l1', 'k8');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l1', 'k9');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l2', 'k4');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l2', 'k5');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l2', 'k8');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l2', 'k9');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z2','l2', 'k10');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l1', 'k1');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l1', 'k2');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l1', 'k4');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l1', 'k6');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l1', 'k7');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l2', 'k2');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l2', 'k3');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l2', 'k4');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z3','l2', 'k6');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z4','l1', 'k7');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z4','l1', 'k8');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z4','l1', 'k9');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z5','l1', 'k2');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z5','l1', 'k3');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z5','l1', 'k5');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z5','l1', 'k6');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z5','l1', 'k8');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z6','l2', 'k4');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z6','l2', 'k7');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z6','l2', 'k5');
Insert into competir (id_circuito, id_carrera, id_coche) values ('z6','l2', 'k9');
COMMIT;