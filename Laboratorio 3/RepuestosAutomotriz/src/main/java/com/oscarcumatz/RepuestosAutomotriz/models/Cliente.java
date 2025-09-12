package com.oscarcumatz.RepuestosAutomotriz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCliente;

    @Column(name = "nombre_Cliente")
    private String nombreCliente;

    @Column(name = "apellido_Cliente")
    private String apellidoCliente;

    @Column(name = "correo_Cliente")
    private String correoCliente;

    @Column(name = "telefono_Cliente")
    private String telefonoCliente;

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {this.codigoCliente = codigoCliente;}

    public String getNombreCliente() {return nombreCliente;}

    public void setNombreCliente(String nombreCliente) {this.nombreCliente = nombreCliente;}

    public String getApellidoCliente() {return apellidoCliente;}

    public void setApellidoCliente(String apellidoCliente) {this.apellidoCliente = apellidoCliente;}

    public String getCorreoCliente() {return correoCliente;}

    public void setCorreoCliente(String correoCliente) {this.correoCliente = correoCliente;}

    public String getTelefonoCliente() {return telefonoCliente;}

    public void setTelefonoCliente(String telefonoCliente) {this.telefonoCliente = telefonoCliente;}
}
