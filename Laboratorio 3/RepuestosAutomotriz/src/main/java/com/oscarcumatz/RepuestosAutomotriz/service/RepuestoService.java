package com.oscarcumatz.RepuestosAutomotriz.service;

import com.oscarcumatz.RepuestosAutomotriz.models.Repuesto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepuestoService {
    List<Repuesto> getAllRepuestos();
    Repuesto getRepuestoById(int codigoRepuesto);
    Repuesto guardarRepuesto(Repuesto repuesto);
    Repuesto actualizarRepuesto(int codigoRepuesto, Repuesto repuesto);
    boolean borrarRepuesto (int codigoRepuesto);
}
