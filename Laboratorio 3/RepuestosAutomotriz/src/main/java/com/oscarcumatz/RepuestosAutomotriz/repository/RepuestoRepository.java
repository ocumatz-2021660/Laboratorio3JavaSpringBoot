package com.oscarcumatz.RepuestosAutomotriz.repository;

import com.oscarcumatz.RepuestosAutomotriz.models.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto , Integer> {
}
