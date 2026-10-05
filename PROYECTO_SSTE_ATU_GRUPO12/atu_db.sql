CREATE DATABASE IF NOT EXISTS atu_db;
USE atu_db;

CREATE TABLE IF NOT EXISTS Usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    codigoUsuario VARCHAR(50) NOT NULL UNIQUE,
    clave VARCHAR(50) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100),
    apellidoMaterno VARCHAR(100),
    estado VARCHAR(20) DEFAULT 'ACTIVO'
);

CREATE TABLE IF NOT EXISTS Empresa (
    ruc VARCHAR(11) PRIMARY KEY,
    razonSocial VARCHAR(150) NOT NULL,
    direccion VARCHAR(200),
    distrito VARCHAR(100),
    correo VARCHAR(100),
    telefono VARCHAR(20),
    estado VARCHAR(20) DEFAULT 'ACTIVO'
);

CREATE TABLE IF NOT EXISTS Vehiculo (
    placa VARCHAR(10) PRIMARY KEY,
    ruc_empresa VARCHAR(11) NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    categoria VARCHAR(20),
    anioModelo INT,
    estado VARCHAR(20) DEFAULT 'Habilitado',
    FOREIGN KEY (ruc_empresa) REFERENCES Empresa(ruc)
);

CREATE TABLE IF NOT EXISTS Conductor (
    dni VARCHAR(8) PRIMARY KEY,
    ruc_empresa VARCHAR(11) NOT NULL,
    nombres VARCHAR(100),
    apellidoPaterno VARCHAR(100),
    apellidoMaterno VARCHAR(100),
    edad INT,
    sexo VARCHAR(10),
    numeroLicencia VARCHAR(20),
    categoriaLicencia VARCHAR(20),
    fechaEmision DATE,
    fechaVigencia DATE,
    estado VARCHAR(20) DEFAULT 'Habilitado',
    FOREIGN KEY (ruc_empresa) REFERENCES Empresa(ruc)
);

CREATE TABLE IF NOT EXISTS Recibo (
    idRecibo INT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(50) NOT NULL UNIQUE,
    monto DOUBLE NOT NULL,
    fechaPago DATE,
    entidadBancaria VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Expediente (
    idExpediente INT PRIMARY KEY AUTO_INCREMENT,
    numeroExpediente VARCHAR(50) NOT NULL UNIQUE,
    fechaRegistro DATE NOT NULL,
    tipoTramite VARCHAR(100) DEFAULT 'Autorizacion',
    estado VARCHAR(20) DEFAULT 'Habilitado',
    ruc_empresa VARCHAR(11) NOT NULL,
    id_usuario INT NOT NULL,
    id_recibo INT NOT NULL,
    FOREIGN KEY (ruc_empresa) REFERENCES Empresa(ruc),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (id_recibo) REFERENCES Recibo(idRecibo)
);

INSERT INTO Usuario (idUsuario, codigoUsuario, clave, nombres, apellidoPaterno, apellidoMaterno) 
VALUES (1, 'EVAL-01', 'claveSegura', 'Administrador', 'SSTE', 'ATU')
ON DUPLICATE KEY UPDATE codigoUsuario=codigoUsuario;