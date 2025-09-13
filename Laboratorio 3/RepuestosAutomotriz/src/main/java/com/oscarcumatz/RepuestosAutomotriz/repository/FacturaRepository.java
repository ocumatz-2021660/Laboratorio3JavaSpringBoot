package com.oscarcumatz.RepuestosAutomotriz.repository;

import com.oscarcumatz.RepuestosAutomotriz.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository  extends JpaRepository<Factura, Integer> {
}
