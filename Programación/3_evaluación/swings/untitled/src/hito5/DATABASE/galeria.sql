
DROP DATABASE IF EXISTS galeria;
CREATE DATABASE galeria;
USE galeria;

-- DATOS
	CREATE TABLE pintores (
	idPintor INT ,
	nombre VARCHAR(50),
	premiado boolean,
	UNIQUE KEY (idPintor)
	);
    

	CREATE TABLE pinturas (
	idPintura INT,
	titulo VARCHAR(50),
	fecha DATE,
	archivo VARCHAR(100),
	visitas INT,
	idPintor INT,
	UNIQUE KEY(idPintura), FOREIGN KEY (idPintor) REFERENCES pintores(idPintor)
	);


-- DATOS
INSERT INTO pintores VALUES 
(1,'Vincent van Gogh', 0),
(2,'Ansel Adams', 0),
(3,'El Bosco', 0),
(4,'Salvador Dali', 0),
(5,'Edvard Munch', 0),
(6,'Rene Magritte', 0),
(7,'Mark Rothko', 0);

INSERT INTO pinturas VALUES
(1, 'La noche estrellada', '1889-01-01', 'vangogh1.jpg', 0, 1),
(2, 'Campo de trigo con cipreses', '1889-01-01', 'vangogh2.jpg', 0, 1),
(3, 'Clearing Winter Storm', '1944-01-01', 'anseladams1.jpg', 0, 2),
(4, 'The Face of Half Dome', '1927-01-01', 'anseladams2.jpg', 0, 2),
(5, 'El jardin de las delicias', '1500-01-01', 'bosco1.jpg', 0, 3),
(6, 'Adan y Eva', '1500-01-01', 'bosco2.jpg', 0, 3),
(7, 'El descenso de Cristo al infierno', '1550-01-01', 'bosco3.jpg', 0, 3),
(8, 'La angustia del infierno', '1540-01-01', 'bosco4.jpg', 0, 3),
(9, 'Elefante', '1948-01-01', 'dali1.jpg', 0, 4),
(10, 'Persistencia de la memoria', '1931-01-01', 'dali2.jpg', 0, 4),
(11, 'El grito', '1893-01-01', 'munch1.jpg', 0, 5),
(12, 'La noche en Karl Johan Street', '1892-01-01', 'munch2.jpg', 0, 5),
(13, 'La madre muerta y su hija', '1897-01-01', 'munch3.jpg', 0, 5),
(14, 'El hijo del hombre', '1964-01-01', 'magritte1.jpg', 0, 6),
(15, 'Los amantes', '1928-01-01', 'magritte2.jpg', 0, 6),
(16, 'Golconde', '1953-01-01', 'magritte3.jpg', 0, 6),
(17, 'No. 10', '1950-01-01', 'rothko1.jpg', 0, 7),
(18, 'Blanco sobre rojo', '1957-01-01', 'rothko2.jpg', 0, 7),
(19, 'Negro sobre gris', '1969-01-01', 'rothko3.jpg', 0, 7);


ALTER TABLE pintores
    ADD PRIMARY KEY (idPintor);
    
    ALTER TABLE pinturas
    ADD PRIMARY KEY (idPintura);
-- CONSULTAS

SELECT * FROM pintores;
SELECT * FROM pinturas;
