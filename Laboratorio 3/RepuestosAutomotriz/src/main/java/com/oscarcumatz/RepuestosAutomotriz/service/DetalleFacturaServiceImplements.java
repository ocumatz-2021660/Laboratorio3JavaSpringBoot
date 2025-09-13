package com.oscarcumatz.RepuestosAutomotriz.service;

import com.oscarcumatz.RepuestosAutomotriz.models.DetalleFactura;
import com.oscarcumatz.RepuestosAutomotriz.models.Factura;
import com.oscarcumatz.RepuestosAutomotriz.repository.DetalleFacturaRepository;
import com.oscarcumatz.RepuestosAutomotriz.repository.FacturaRepository;
import com.oscarcumatz.RepuestosAutomotriz.repository.RepuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImplements implements  DetalleFacturaService{

    private final DetalleFacturaRepository detalleFacturaRepository;
    private final FacturaRepository facturaRepository;
    private final RepuestoRepository repuestoRepository;

    public DetalleFacturaServiceImplements(DetalleFacturaRepository detalleFacturaRepository, FacturaRepository facturaRepository, RepuestoRepository repuestoRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
        this.facturaRepository = facturaRepository;
        this.repuestoRepository = repuestoRepository;
    }


    @Override
    public List<DetalleFactura> getAllDetalles() {
        return detalleFacturaRepository.findAll();
    }

    @Override
    public DetalleFactura getAllById(int codigo_Detalle) {
        return detalleFacturaRepository.findById(codigo_Detalle).orElse(null);
    }

    @Override
    public DetalleFactura guardarDetalles(DetalleFactura detalleFactura) {
        String precio = String.valueOf(detalleFactura.getPrecio_Unitario());
        String subtotal = String.valueOf(detalleFactura.getSubtotal());
        if(precio.chars().filter(c -> c == '.').count() > 1){
            throw new IllegalArgumentException("Respete el formato decimal porfavor");
        }
        if(subtotal.chars().filter(c -> c == '.').count()>1){
            throw new IllegalArgumentException("Respete el formato decimal porfavor");
        }
        return detalleFacturaRepository.save(detalleFactura);
    }

    @Override
    public DetalleFactura actualizarDetalle(int codigo_Detalle, DetalleFactura detalleFactura) {
        DetalleFactura updateDetalle = detalleFacturaRepository.findById(codigo_Detalle).orElse(null);
        if (updateDetalle != null){
            String precio = String.valueOf(detalleFactura.getPrecio_Unitario());
            String subtotal = String.valueOf(detalleFactura.getSubtotal());
            if(precio.chars().filter(c -> c == '.').count() > 1){
                throw new IllegalArgumentException("Respete el formato decimal porfavor");
            }
            if(subtotal.chars().filter(c -> c == '.').count()>1){
                throw new IllegalArgumentException("Respete el formato decimal porfavor");
            }
            updateDetalle.setCodigo_Factura(detalleFactura.getCodigo_Factura());
            updateDetalle.setCodigo_Repuesto(detalleFactura.getCodigo_Repuesto());
            updateDetalle.setCantidad(detalleFactura.getCantidad());
            updateDetalle.setPrecio_Unitario(detalleFactura.getPrecio_Unitario());
            updateDetalle.setSubtotal(detalleFactura.getSubtotal());
            return  detalleFacturaRepository.save(updateDetalle);
        }
        return null;
    }

    @Override
    public boolean borrarDetalle(int codigo_Detalle) {
        if (detalleFacturaRepository.existsById(codigo_Detalle)){
            facturaRepository.deleteById(codigo_Detalle);
            return true;
        }
        return false;
    }
}
