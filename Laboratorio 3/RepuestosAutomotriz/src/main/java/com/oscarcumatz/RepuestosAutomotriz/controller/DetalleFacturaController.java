package com.oscarcumatz.RepuestosAutomotriz.controller;

import com.oscarcumatz.RepuestosAutomotriz.models.DetalleFactura;
import com.oscarcumatz.RepuestosAutomotriz.service.DetalleFacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/detalles")
public class DetalleFacturaController {

    private final DetalleFacturaService detalleFacturaService;

    public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
        this.detalleFacturaService = detalleFacturaService;
    }

    @GetMapping
    public List<DetalleFactura> getAllDetalles(){
        return detalleFacturaService.getAllDetalles();
    }
    @GetMapping ("/{codigo_Detalle}")
    public DetalleFactura getAllById(@PathVariable int codigo_Detalle){
        return detalleFacturaService.getAllById(codigo_Detalle);
    }
    @PostMapping
    public String guardarDetalles(@RequestBody DetalleFactura detalleFactura){
        try{
            DetalleFactura nuevoDetalle = detalleFacturaService.guardarDetalles(detalleFactura);
            return "Detalle de Factura agregado" ;
        } catch (IllegalArgumentException e) {
            return "Respetar elf formato decimal porfavor";
        }
    }
    @PutMapping ("/{codigo_Detalle}")
    public String actualizarDetalle(@PathVariable int codigo_Detalle, @RequestBody DetalleFactura detalleFactura){
        try{
            DetalleFactura upadateDetalle = detalleFacturaService.actualizarDetalle(codigo_Detalle, detalleFactura);
            if(upadateDetalle == null){
                return  "El detalle factra no existe en los registros";
            }
            return "Detalle Factura actualizado";
        }catch (IllegalArgumentException e){
            return "Respetar el formato decimal porfavor";
        }
    }
    @DeleteMapping ("/{codigo_Detalle}")
        public String borrarDetalle(@PathVariable int codigo_Detalle){
            boolean detalleElimniado = detalleFacturaService.borrarDetalle(codigo_Detalle);
            if(detalleElimniado){
                return "Detalle factura eliminado del registro";
            }else{
            return "El detalle factura no existe en los registros";
        }
            }
    }

