package com.oscarcumatz.RepuestosAutomotriz.controller;
import com.oscarcumatz.RepuestosAutomotriz.models.Factura;
import com.oscarcumatz.RepuestosAutomotriz.service.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> getAllFacturas(){
        return facturaService.getAllFacturas();
    }
    @GetMapping ("/{codigo_Factura}")
    public Factura getFacturaById(@PathVariable int codigo_Factura){
        return facturaService.getFacturaById(codigo_Factura);
    }
    @PostMapping
    public String guardarFactura(@RequestBody Factura factura){
        try {
            Factura nuevaFactura = facturaService.guardarFactura(factura);
            return "Factura agregada " + nuevaFactura.getTotal_Factura();
        } catch (IllegalArgumentException e) {
            return "Resopetar el formato decimal porfavor ";
        }
    }
    @PutMapping("/{codigo_Factura}")
    public String actualizarFactura(@PathVariable int codigo_Factura, @RequestBody Factura factura) {
        try {
            Factura updateFactura = facturaService.actualizarFactura(codigo_Factura, factura);
            if (updateFactura == null) {
                return "La factura no existe en los registros.";
            }
            return "Factura actualizada con total: " + updateFactura.getTotal_Factura();
        } catch (IllegalArgumentException e) {
            return "Respetar el formato decimal por favor. ";
        }
    }
    @DeleteMapping ("/{codigo_Factura}")
    public String borrarFactura(@PathVariable int codigo_Factura){
        boolean facturaEliminada = facturaService.borrarFactura(codigo_Factura);
        if(facturaEliminada){
            return "Factura eliminada del registro";
        }else{
            return "la factura no existe en los registors";
        }
    }
}


