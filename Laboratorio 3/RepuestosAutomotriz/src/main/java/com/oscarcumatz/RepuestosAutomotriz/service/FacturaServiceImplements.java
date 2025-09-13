package com.oscarcumatz.RepuestosAutomotriz.service;

import com.oscarcumatz.RepuestosAutomotriz.models.Factura;
import com.oscarcumatz.RepuestosAutomotriz.repository.FacturaRepository;
import com.oscarcumatz.RepuestosAutomotriz.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImplements implements FacturaService {

    private final FacturaRepository facturaRepository;
    private final ClienteRepository clienteRepository;

    public FacturaServiceImplements(FacturaRepository facturaRepository, ClienteRepository clienteRepository) {
        this.facturaRepository = facturaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura getFacturaById(int codigo_Factura) {
        return facturaRepository.findById(codigo_Factura).orElse(null);
    }

    @Override
    public Factura guardarFactura(Factura factura) {
        String total = String.valueOf(factura.getTotal_Factura());
        if (total.chars().filter(c -> c == '.').count() > 1) {
            throw new IllegalArgumentException("Respetar el formato decimal por favor");
        }
        return facturaRepository.save(factura);
    }

    @Override
    public Factura actualizarFactura(int codigo_Factura, Factura factura) {
        Factura updateFactura = facturaRepository.findById(codigo_Factura).orElse(null);

        if (updateFactura != null) {
            String total = String.valueOf(factura.getTotal_Factura());
            if (total.chars().filter(c -> c == '.').count() > 1) {
                throw new IllegalArgumentException("Respetar el formato decimal por favor");
            }

            updateFactura.setCodigo_Cliente(factura.getCodigo_Cliente());
            updateFactura.setTotal_Factura(factura.getTotal_Factura());
            return facturaRepository.save(updateFactura);
        }
        return null;
    }

    @Override
    public boolean borrarFactura(int codigo_Factura) {
        if (facturaRepository.existsById(codigo_Factura)) {
            facturaRepository.deleteById(codigo_Factura);
            return true;
        }
        return false;
    }
}
