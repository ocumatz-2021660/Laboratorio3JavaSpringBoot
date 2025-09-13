package com.oscarcumatz.RepuestosAutomotriz.service;

import com.oscarcumatz.RepuestosAutomotriz.models.DetalleFactura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleFacturaService {
    List<DetalleFactura> getAllDetalles();
    DetalleFactura getAllById(int codigo_Detalle);
    DetalleFactura guardarDetalles(DetalleFactura detalleFactura);
    DetalleFactura actualizarDetalle(int codigo_Detalle, DetalleFactura detalleFactura);
    boolean borrarDetalle(int codigo_Detalle);
}
