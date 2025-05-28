CREATE DATABASE IF NOT EXISTS universidad;
USE universidad;

CREATE TABLE estudiante (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  correo VARCHAR(100) NOT NULL
);

CREATE TABLE curso (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  creditos INT NOT NULL
);

CREATE TABLE matricula (
  id INT AUTO_INCREMENT PRIMARY KEY,
  estudiante_id INT,
  curso_id INT,
  fecha DATE,
  FOREIGN KEY (estudiante_id) REFERENCES estudiante(id),
  FOREIGN KEY (curso_id) REFERENCES curso(id)
);

