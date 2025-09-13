package com.oscarcumatz.RepuestosAutomotriz.repository;

import com.oscarcumatz.RepuestosAutomotriz.models.DetalleFactura;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
}
