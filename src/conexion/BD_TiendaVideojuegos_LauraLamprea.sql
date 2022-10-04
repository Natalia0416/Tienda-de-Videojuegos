/*LauraLamprea*/

CREATE DATABASE BD_TallerVideoJuegos;
USE BD_TallerVideoJuegos;

CREATE TABLE Juegos(
  idJuego VARCHAR(50) NOT NULL PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Cantidad INT NOT NULL,
  Precio FLOAT NOT NULL,
  Capacidad VARCHAR(50),
  Categoria VARCHAR(50) NOT NULL,
  Modelos VARCHAR(50) NOT NULL
);

CREATE TABLE Clientes(
  idCliente VARCHAR(50) PRIMARY KEY NOT NULL,
  Nombre VARCHAR(50) NOT NULL,
  Apellido VARCHAR(50) NOT NULL,
  Edad INT NOT NULL,
  Correo VARCHAR(50) NOT NULL,
  Contra VARCHAR(50) NOT NULL,
  Rol VARCHAR(50) NOT NULL
);


CREATE TABLE Ventas(
  idVenta VARCHAR(50) PRIMARY KEY NOT NULL,
 idCliente VARCHAR(50) NOT NULL,
  Fecha DATE NOT NULL,
  Descuento FLOAT NOT NULL,
  Total FLOAT NOT NULL,
  FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
);

CREATE TABLE Detalle_Ventas(
  ID VARCHAR(50) PRIMARY KEY NOT NULL,
  Venta VARCHAR(50) NOT NULL,
  Juego VARCHAR(50) NOT NULL,
  Cantidad INT NOT NULL,
  Subtotal FLOAT NOT NULL,
  FOREIGN KEY (Venta) REFERENCES Ventas(idVenta),
  FOREIGN KEY (Juego) REFERENCES Juegos(idJuego)
);



INSERT INTO Juegos(idJuego, Nombre, Cantidad, Precio, Capacidad, Categoria, Modelos)
VALUES ("456", "Shadow Fight 2", 78, 54000, "149KB", "Accion", "Android 4.1 - 4.3.1"),
("985", "Mortal Kombat", 135, 80000, "1KB", "Accion", "Android 9.0"),
("156", "Kinja Run", 90, 66000, "449KB", "Accion", "Android 6.0"),
("724", "Rayman Adventures", 80, 30000, "41KB", "Aventura", "Android 8.0"),
("671", "Sky: Niños de la Luz", 55, 45000, "1KB", "Aventura", "Android 6.0"),
("167", "Crash Bandicoot: On the Run!", 60, 20000, "726KB", "Aventura", "Android 5.0"),
("486", "Volleyball Arena", 80, 88000, "129KB", "Deporte", "Android 6.0"),
("394", "Soccer Super Star - Futbol", 40, 70000, "97KB", "Deporte", "Android 5.0"),
("267", "BASEBALL 9", 50, 47000, "164KB", "Deporte", "Android 7.0"),
("344", "Top Speed: Drag & Fast Racing", 68, 36000, "107KB", "Velocidad", "Android 8.0"),
("146", "Trials Frontier", 56, 54000, "97KB", "Velocidad", "Android 7.0"),
("856", "Mario Kart Tour", 95, 96000, "587KB", "Velocidad", "Android 6.0");

INSERT INTO Clientes( idCliente, Nombre, Apellido, Edad, Correo, Contra, Rol)
VALUES("684", "Maria", "Rodriguez", 26, "maria58@gmail.com", "maris123", "cliente"),
("654", "Pedro", "Torres", 17, "pepito98@gmail.com", "elpepe98", "cliente"),
("1", "Melissa", "Gomez", 36, "admi56@gmail.com", "admi5678", "administrador");