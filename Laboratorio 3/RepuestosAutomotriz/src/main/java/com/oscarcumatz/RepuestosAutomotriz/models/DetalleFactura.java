package com.oscarcumatz.RepuestosAutomotriz.models;

import jakarta.persistence.*;

@Entity
@Table (name= "Detalle_Factura")
public class DetalleFactura {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo_Detalle;

    @ManyToOne
    @JoinColumn(name = "codigo_Factura", referencedColumnName = "codigo_Factura")
    private Factura codigo_Factura;
    @ManyToOne
    @JoinColumn (name= "codigo_Repuesto", referencedColumnName= "codigoRepuesto")
    private Repuesto codigo_Repuesto;

    @Column (name = "cantidad")
    private int cantidad;
    @Column (name = "precio_Unitario")
    private double precio_Unitario;
    @Column (name = "subtotal")
    private double subtotal;

    public int getCodigo_Detalle() {
        return codigo_Detalle;
    }

    public void setCodigo_Detalle(int codigo_Detalle) {
        this.codigo_Detalle = codigo_Detalle;
    }

    public Factura getCodigo_Factura() {
        return codigo_Factura;
    }

    public void setCodigo_Factura(Factura codigo_Factura) {
        this.codigo_Factura = codigo_Factura;
    }

    public Repuesto getCodigo_Repuesto() {
        return codigo_Repuesto;
    }

    public void setCodigo_Repuesto(Repuesto codigo_Repuesto) {
        this.codigo_Repuesto = codigo_Repuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(double precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
