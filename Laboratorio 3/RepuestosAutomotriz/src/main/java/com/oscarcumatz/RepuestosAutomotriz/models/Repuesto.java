package com.oscarcumatz.RepuestosAutomotriz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Repuesto")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoRepuesto;

    @Column(name = "nombre_Repuesto")
    private String nombreRepuesto;

    @Column(name = "descripcion_Repuesto")
    private String descripcion;

    public int getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(int codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
