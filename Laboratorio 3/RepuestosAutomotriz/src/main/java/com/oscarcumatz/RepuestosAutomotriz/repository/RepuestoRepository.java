package com.oscarcumatz.RepuestosAutomotriz.repository;

import com.oscarcumatz.RepuestosAutomotriz.models.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepuestoRepository extends JpaRepository<Repuesto , Integer> {
}
