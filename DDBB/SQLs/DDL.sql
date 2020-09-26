DROP DATABASE IF EXISTS `bdPersonas`;

CREATE DATABASE `bdPersonas`;

-- Seteamos el time_zone, ya que al crear la ddbb por default tiene otro (Creo que el de USA) y pinchan los inserts
SET GLOBAL time_zone = '-3:00';

USE bdPersonas;

CREATE TABLE `Personas`(
    `Dni` varchar(20) NOT NULL,
    `Nombre` varchar(45) NOT NULL,
    `Apellido` varchar(45) NOT NULL,
    PRIMARY KEY (`Dni`));