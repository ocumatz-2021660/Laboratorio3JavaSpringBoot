package com.oscarcumatz.RepuestosAutomotriz.service;

import com.oscarcumatz.RepuestosAutomotriz.models.Repuesto;
import com.oscarcumatz.RepuestosAutomotriz.repository.RepuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImplements implements RepuestoService {

    public final RepuestoRepository repuestoRepository;

    public RepuestoServiceImplements(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public List<Repuesto> getAllRepuestos() {
        return repuestoRepository.findAll();
    }

    @Override
    public Repuesto getRepuestoById(int codigoRepuesto) {
        return repuestoRepository.findById(codigoRepuesto).orElse(null);
    }

    @Override
    public Repuesto guardarRepuesto(Repuesto repuesto) {
        List<Repuesto> listaRepuestos = repuestoRepository.findAll();
        for (Repuesto newRepuesto : listaRepuestos){
            if(newRepuesto.getNombreRepuesto().equalsIgnoreCase(repuesto.getNombreRepuesto()) ||
                    newRepuesto.getNombreRepuesto()== null){
                repuesto.setNombreRepuesto("NombreEnUso");
                return repuesto;
            }
        }
        return repuestoRepository.save(repuesto);
    }

    @Override
    public Repuesto actualizarRepuesto(int codigoRepuesto, Repuesto repuesto) {
        Repuesto actuRepuesto = repuestoRepository.findById(codigoRepuesto).orElse(null);
        if (actuRepuesto != null) {
            List<Repuesto> listaRepuestos = repuestoRepository.findAll();
            for (Repuesto existe : listaRepuestos){
                if(existe.getNombreRepuesto().equalsIgnoreCase(repuesto.getNombreRepuesto())){
                    repuesto.setNombreRepuesto("NombreEnUso");
                    return repuesto;
                }
            }
            actuRepuesto.setNombreRepuesto(repuesto.getNombreRepuesto());
            actuRepuesto.setDescripcion(repuesto.getDescripcion());
            return repuestoRepository.save(actuRepuesto);
        }
        return null;
    }

    @Override
    public boolean borrarRepuesto(int codigoRepuesto) {
        if(repuestoRepository.existsById(codigoRepuesto)){
            repuestoRepository.deleteById(codigoRepuesto);
            return true;
        }
        return false;

    }
}
