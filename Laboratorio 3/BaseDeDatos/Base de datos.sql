-- drop database if exists DB_RepuestosAutomotriz;
-- create database DB_RepuestosAutomotriz;
use DB_RepuestosAutomotriz;
/*
create table Repuesto(
	codigoRepuesto int auto_increment,
    nombreRepuesto varchar(100),
    descripcion varchar(255),
    primary key PK_codigoRepuesto(codigoRepuesto)
);
*/
create table Cliente(
	codigoCliente int auto_increment,
    nombreCliente varchar(100),
    apellidoCliente varchar(100),
    correoCliente varchar(100) unique,
    telefonoCliente varchar(8) unique,
    primary key PK_codigoCliente(codigoCliente)
);
/*
create table Factura(
	codigoFactura int auto_increment, 
    codigoCliente int,
    total double default 0.0,
    primary key PK_codigoFactura(codigoFactura),
    constraint FK_codigoCliente foreign key (codigoCliente)
		references Cliente (codigoCliente)
    
);
create table DetalleFactura(
	codigoDetalle int auto_increment,
    codigoFactura int,
    codigoRepuesto int,
    cantidad int,
    precioUnitario double,
    subtotal double default 0.0,
    primary key PK_codigoDetalle (codigoDetalle),
	constraint FK_codigoFacturaDetalle foreign key(codigoFactura)
		references Factura (codigoFactura),
	constraint FK_codigoRepuestoDetalle foreign key(codigoRepuesto)
		references Repuesto(codigoRepuesto)		
);
*/
insert into Cliente(nombreCliente, apellidoCliente, correoCliente, telefonoCliente)
	value("Oscar","Cumatz","ocumatzz@gmail.com","55895952");
        -- select * from Cliente;