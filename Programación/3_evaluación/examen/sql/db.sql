DROP DATABASE IF EXISTS examen;
CREATE DATABASE examen;
USE examen;

DROP TABLE IF EXISTS respuestas;
DROP TABLE IF EXISTS preguntas;
DROP TABLE IF EXISTS categorias;

CREATE TABLE categorias (
    idcategoria VARCHAR(3) NOT NULL,
    categoria VARCHAR(200) NOT NULL,
    PRIMARY KEY (idcategoria)
) ENGINE = InnoDB DEFAULT CHARACTER SET = latin1;

CREATE TABLE preguntas (
    idpregunta INT NOT NULL AUTO_INCREMENT,
    pregunta VARCHAR(200) NOT NULL,
    aciertos INT NOT NULL,
    fallos INT NOT NULL,
    idcategoria VARCHAR(3) NOT NULL,
    PRIMARY KEY (idpregunta),
    FOREIGN KEY (idcategoria) REFERENCES categorias(idcategoria)
) ENGINE = InnoDB DEFAULT CHARACTER SET = latin1;

CREATE TABLE respuestas (
    idpregunta INT NOT NULL,
    respuesta VARCHAR(100) NOT NULL,
    correcta TINYINT(1) NOT NULL,
    PRIMARY KEY (idpregunta, respuesta),
    FOREIGN KEY (idpregunta) REFERENCES preguntas(idpregunta)
) ENGINE = InnoDB DEFAULT CHARACTER SET = latin1;

INSERT INTO categorias VALUES
('CIN', 'Cine'),
('ING', 'Ingles'),
('GEO', 'Geografia'),
('CAL', 'Calculo'),
('LIT', 'Literatura');

INSERT INTO preguntas (pregunta, aciertos, fallos, idcategoria) VALUES
('Quien dirigio Titanic?', 0, 0, 'CIN'),
('Que pelicula tiene como protagonista a un ogro verde?', 0, 0, 'CIN'),
('Como se dice perro en ingles?', 0, 0, 'ING'),
('Como se dice casa en ingles?', 0, 0, 'ING'),
('Cual es la capital de Francia?', 0, 0, 'GEO'),
('En que continente esta Brasil?', 0, 0, 'GEO'),
('Cuanto es 2 + 2?', 0, 0, 'CAL'),
('Cuanto es 5 * 3?', 0, 0, 'CAL'),
('Quien escribio Don Quijote?', 0, 0, 'LIT'),
('Quien escribio La casa de Bernarda Alba?', 0, 0, 'LIT');

INSERT INTO respuestas VALUES
(1, 'James Cameron', 1),
(1, 'Steven Spielberg', 0),
(1, 'Christopher Nolan', 0),
(1, 'Martin Scorsese', 0),

(2, 'Shrek', 1),
(2, 'Toy Story', 0),
(2, 'Frozen', 0),
(2, 'Avatar', 0),

(3, 'Dog', 1),
(3, 'Cat', 0),
(3, 'House', 0),
(3, 'Bird', 0),

(4, 'House', 1),
(4, 'Car', 0),
(4, 'Table', 0),
(4, 'Dog', 0),

(5, 'Paris', 1),
(5, 'Madrid', 0),
(5, 'Roma', 0),
(5, 'Lisboa', 0),

(6, 'America', 1),
(6, 'Europa', 0),
(6, 'Asia', 0),
(6, 'Africa', 0),

(7, '4', 1),
(7, '5', 0),
(7, '6', 0),
(7, '8', 0),

(8, '15', 1),
(8, '10', 0),
(8, '20', 0),
(8, '8', 0),

(9, 'Miguel de Cervantes', 1),
(9, 'Federico Garcia Lorca', 0),
(9, 'Gabriel Garcia Marquez', 0),
(9, 'Pablo Neruda', 0),

(10, 'Federico Garcia Lorca', 1),
(10, 'Miguel de Cervantes', 0),
(10, 'Lope de Vega', 0),
(10, 'Antonio Machado', 0);