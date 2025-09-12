package com.oscarcumatz.RepuestosAutomotriz.controller;

import com.oscarcumatz.RepuestosAutomotriz.models.Repuesto;
import com.oscarcumatz.RepuestosAutomotriz.service.RepuestoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }
    @GetMapping
    public List<Repuesto> getAllRepuestos(){
        return repuestoService.getAllRepuestos();
    }
    @GetMapping ("/{codigoRepuesto}")
    public Repuesto getRepuestoById(@PathVariable int codigoRepuesto){
        return repuestoService.getRepuestoById(codigoRepuesto);
    }
    @PostMapping
    public String guardarRepuesto(@RequestBody Repuesto repuesto){
        Repuesto newRepuetso = repuestoService.guardarRepuesto(repuesto);
        if("NombreEnUso".equals(newRepuetso.getNombreRepuesto())){
            return "El repuesto ya existe en los registros";
        }
        return "Repuesto agregado";
    }
    @PutMapping ("/{codigoRepuesto}")
    public String actualizarRepuesto(@PathVariable int codigoRepuesto, @RequestBody Repuesto repuesto){
        Repuesto updateRepuesto = repuestoService.actualizarRepuesto(codigoRepuesto, repuesto);
        if(updateRepuesto == null){
            return "El repuesto no existe en los registros";
        }

        if("NombreEnUso".equals(updateRepuesto.getNombreRepuesto())){
            return "El nombre ya existe en los registros";
        }
        return "Repuesto Actualizado";
    }
    @DeleteMapping ("/{codigoRepuesto}")
    public String borrarRepuesto(@PathVariable int codigoRepuesto){
        boolean repuestoEliminado = repuestoService.borrarRepuesto(codigoRepuesto);
        if(repuestoEliminado){
            return "Repuesto eliminado de los registros";
        }
        return "El repueto no existe en los registros";
    }
}
