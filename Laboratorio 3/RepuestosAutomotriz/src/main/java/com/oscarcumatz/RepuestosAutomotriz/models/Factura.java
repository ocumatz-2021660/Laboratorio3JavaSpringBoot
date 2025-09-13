package com.oscarcumatz.RepuestosAutomotriz.models;

import jakarta.persistence.*;

@Entity
@Table (name = "Factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo_Factura;

    @ManyToOne
    @JoinColumn(name = "codigo_Cliente", referencedColumnName = "codigoCliente")
    private Cliente codigo_Cliente;

    @Column(name = "total_Factura")
    private double total_Factura;

    public int getCodigo_Factura() {
        return codigo_Factura;
    }

    public void setCodigo_Factura(int codigo_Factura) {
        this.codigo_Factura = codigo_Factura;
    }

    public Cliente getCodigo_Cliente() {
        return codigo_Cliente;
    }

    public void setCodigo_Cliente(Cliente codigo_Cliente) {
        this.codigo_Cliente = codigo_Cliente;
    }

    public double getTotal_Factura() {
        return total_Factura;
    }

    public void setTotal_Factura(double total_Factura) {
        this.total_Factura = total_Factura;
    }
}
