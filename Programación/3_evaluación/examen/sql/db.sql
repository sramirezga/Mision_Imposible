DROP DATABASE IF EXISTS examen;
CREATE DATABASE examen;
USE examen;

CREATE TABLE Categorias (
    idCategoria VARCHAR(5) PRIMARY KEY,
    categoria VARCHAR(100) NOT NULL
);

CREATE TABLE Respuestas (
    idRespuesta VARCHAR(5) PRIMARY KEY,
    respuesta VARCHAR(255) NOT NULL,
    correcta BIT NOT NULL
);

CREATE TABLE Preguntas (
    idPregunta INT NOT NULL,
    pregunta VARCHAR(255) NOT NULL,
    aciertos INT DEFAULT 0,
    fallos INT DEFAULT 0,
    idCategoria VARCHAR(5) NOT NULL,
    idRespuesta VARCHAR(5) NOT NULL,

    PRIMARY KEY (idPregunta, idRespuesta),

    FOREIGN KEY (idCategoria) REFERENCES Categorias(idCategoria),
    FOREIGN KEY (idRespuesta) REFERENCES Respuestas(idRespuesta)
);

INSERT INTO Categorias VALUES
('CIN', 'Cine'),
('ING', 'Ingles'),
('GEO', 'Geografia'),
('CAL', 'Calculo'),
('LIT', 'Literatura');

INSERT INTO Respuestas VALUES
('R01', 'James Cameron', 1),
('R02', 'Steven Spielberg', 0),
('R03', 'Christopher Nolan', 0),
('R04', 'Martin Scorsese', 0),

('R05', 'Dog', 1),
('R06', 'Cat', 0),
('R07', 'House', 0),
('R08', 'Bird', 0),

('R09', 'Paris', 1),
('R10', 'Madrid', 0),
('R11', 'Roma', 0),
('R12', 'Lisboa', 0),

('R13', '4', 1),
('R14', '5', 0),
('R15', '6', 0),
('R16', '8', 0),

('R17', 'Miguel de Cervantes', 1),
('R18', 'Federico Garcia Lorca', 0),
('R19', 'Gabriel Garcia Marquez', 0),
('R20', 'Pablo Neruda', 0);

INSERT INTO Preguntas VALUES
(1, 'Quien dirigio Titanic?', 0, 0, 'CIN', 'R01'),
(1, 'Quien dirigio Titanic?', 0, 0, 'CIN', 'R02'),
(1, 'Quien dirigio Titanic?', 0, 0, 'CIN', 'R03'),
(1, 'Quien dirigio Titanic?', 0, 0, 'CIN', 'R04'),

(2, 'Como se dice perro en ingles?', 0, 0, 'ING', 'R05'),
(2, 'Como se dice perro en ingles?', 0, 0, 'ING', 'R06'),
(2, 'Como se dice perro en ingles?', 0, 0, 'ING', 'R07'),
(2, 'Como se dice perro en ingles?', 0, 0, 'ING', 'R08'),

(3, 'Cual es la capital de Francia?', 0, 0, 'GEO', 'R09'),
(3, 'Cual es la capital de Francia?', 0, 0, 'GEO', 'R10'),
(3, 'Cual es la capital de Francia?', 0, 0, 'GEO', 'R11'),
(3, 'Cual es la capital de Francia?', 0, 0, 'GEO', 'R12'),

(4, 'Cuanto es 2 + 2?', 0, 0, 'CAL', 'R13'),
(4, 'Cuanto es 2 + 2?', 0, 0, 'CAL', 'R14'),
(4, 'Cuanto es 2 + 2?', 0, 0, 'CAL', 'R15'),
(4, 'Cuanto es 2 + 2?', 0, 0, 'CAL', 'R16'),

(5, 'Quien escribio Don Quijote?', 0, 0, 'LIT', 'R17'),
(5, 'Quien escribio Don Quijote?', 0, 0, 'LIT', 'R18'),
(5, 'Quien escribio Don Quijote?', 0, 0, 'LIT', 'R19'),
(5, 'Quien escribio Don Quijote?', 0, 0, 'LIT', 'R20');