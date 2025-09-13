drop database if exists DBStoreMech;
create database DBStoreMech;
use DBStoreMech;

create table Cliente(
	codigo_Cliente int auto_increment,
    nombre_Cliente varchar(100),
    apellido_Cliente varchar(100),
    correo_Cliente varchar(100) unique,
    telefono_Cliente varchar(8) unique,
    primary key PK_codigo_Cliente(codigo_Cliente)
);

create table Repuesto(
	codigo_Repuesto int auto_increment,
    nombre_Repuesto varchar(100),
    descripcion_Repuesto varchar(255),
    primary key PK_codigoRepuesto(codigo_Repuesto)
);

create table Factura(
	codigo_Factura int auto_increment, 
    codigo_Cliente int,
    total_Factura double,
    primary key PK_codigoFactura(codigo_Factura),
    constraint FK_codigoCliente foreign key (codigo_Cliente)
		references Cliente (codigo_Cliente)
    
);
/*
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

insert into Cliente(nombre_Cliente, apellido_Cliente, correo_Cliente, telefono_Cliente)
	value("Oscar","Cumatz","ocumatzz@gmail.com","55895952");
        -- select * from Cliente;
insert into Repuesto(nombre_Repuesto, descripcion_Repuesto)
	value("Artefacto1","es pal carro bro");
    
insert into Factura(codigo_Cliente, total_Factura)
	value(1,23.90);