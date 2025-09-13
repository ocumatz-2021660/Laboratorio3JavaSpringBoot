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

create table Detalle_Factura(
	codigo_Detalle int auto_increment,
    codigo_Factura int,
    codigo_Repuesto int,
    cantidad int,
    precio_Unitario double,
    subtotal double,
    primary key PK_codigoDetalle (codigo_Detalle),
	constraint FK_codigoFacturaDetalle foreign key(codigo_Factura)
		references Factura (codigo_Factura),
	constraint FK_codigoRepuestoDetalle foreign key(codigo_Repuesto)
		references Repuesto(codigo_Repuesto)		
);

DELIMITER //
create procedure sp_AgregarCL(
	nombreCL varchar(100),
    apellidoCL varchar(100),
    correoCL varchar(100),
    telefonoCL varchar(8) 
)
	begin 
		insert into Cliente(nombre_Cliente, apellido_Cliente, correo_Cliente, telefono_Cliente)
		value(nombreCL,apellidoCL,correoCL,telefonoCL);
	end //
DELIMITER ;
call sp_AgregarCL("Oscar","Cumatz","ocumatz@gmail.com","55895932");
call sp_AgregarCL("Oscar","Cumatz","ocumatz1@gmail.com","55895931");
call sp_AgregarCL("Ana","Lopez","alopez@gmail.com","55495932");
call sp_AgregarCL("Juan","Perez","jperez@gmail.com","55895933");
call sp_AgregarCL("Maria","Gomez","mgomez@gmail.com","55895934");
call sp_AgregarCL("Luis","Ramirez","lramirez@gmail.com","55895935");
call sp_AgregarCL("Carla","Torres","ctorres@gmail.com","55895936");
call sp_AgregarCL("Pedro","Diaz","pdiaz@gmail.com","55895937");
call sp_AgregarCL("Sofia","Vega","svega@gmail.com","55895938");
call sp_AgregarCL("Jorge","Martinez","jmartinez@gmail.com","55895939");
call sp_AgregarCL("Laura","Flores","lflores@gmail.com","55895940");


delimiter //
create procedure sp_AgregarRep(
    nombrerep varchar(100),
    descripcionrep varchar(255)
)
begin
    insert into Repuesto(nombre_Repuesto, descripcion_Repuesto)
    value(nombrerep, descripcionrep);
end //
delimiter ;

call sp_AgregarRep("Freno","Freno de disco delantero");
call sp_AgregarRep("Freno","Freno de disco delantero");
call sp_AgregarRep("Aceite","Aceite de motor 5W30");
call sp_AgregarRep("Bujia","Bujía de encendido");
call sp_AgregarRep("Filtro Aire","Filtro de aire motor");
call sp_AgregarRep("Amortiguador","Amortiguador delantero");
call sp_AgregarRep("Correa","Correa de distribución");
call sp_AgregarRep("Pastilla Freno","Pastilla de freno trasera");
call sp_AgregarRep("Radiador","Radiador de agua");
call sp_AgregarRep("Batería","Batería 12V");
call sp_AgregarRep("Filtro Aceite","Filtro de aceite motor");

delimiter //
create procedure sp_AgregarFact(
    codigocl int,
    totalfact double
)
begin
    insert into Factura(codigo_Cliente, total_Factura)
    value(codigocl, totalfact);
end //
delimiter ;
call sp_AgregarFact(1, 1200.50);
call sp_AgregarFact(2, 850.75);
call sp_AgregarFact(3, 430.00);
call sp_AgregarFact(4, 1570.90);
call sp_AgregarFact(5, 760.20);
call sp_AgregarFact(6, 1340.60);
call sp_AgregarFact(7, 980.40);
call sp_AgregarFact(8, 1120.00);
call sp_AgregarFact(9, 670.30);
call sp_AgregarFact(10, 1450.80);
call sp_AgregarFact(1, 1200.50);

delimiter //
create procedure sp_AgregarDetFact(
    codigofact int,
    codigorep int,
    cantidaddet int,
    preciounit double,
    subtotaldet double
)
begin
    insert into Detalle_Factura(codigo_Factura, codigo_Repuesto, cantidad, precio_Unitario, subtotal)
    value(codigofact, codigorep, cantidaddet, preciounit, subtotaldet);
end //
delimiter ;

call sp_AgregarDetFact(1, 1, 2, 600.25, 1200.50);
call sp_AgregarDetFact(2, 2, 3, 283.58, 850.75);
call sp_AgregarDetFact(3, 3, 5, 86.00, 430.00);
call sp_AgregarDetFact(4, 4, 4, 392.73, 1570.90);
call sp_AgregarDetFact(5, 5, 2, 380.10, 760.20);
call sp_AgregarDetFact(6, 6, 2, 670.30, 1340.60);
call sp_AgregarDetFact(7, 7, 4, 245.10, 980.40);
call sp_AgregarDetFact(8, 8, 2, 560.00, 1120.00);
call sp_AgregarDetFact(9, 9, 1, 670.30, 670.30);
call sp_AgregarDetFact(10, 10, 4, 362.70, 1450.80);

