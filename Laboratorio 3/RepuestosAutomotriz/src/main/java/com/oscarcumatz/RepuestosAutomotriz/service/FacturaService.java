package com.oscarcumatz.RepuestosAutomotriz.service;

import com.oscarcumatz.RepuestosAutomotriz.models.Factura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaService {
    List<Factura> getAllFacturas();
    Factura getFacturaById(int codigo_Factura);
    Factura guardarFactura(Factura factura);
    Factura actualizarFactura(int codigo_Factura, Factura factura);
    boolean borrarFactura (int codigo_Factura);
}
