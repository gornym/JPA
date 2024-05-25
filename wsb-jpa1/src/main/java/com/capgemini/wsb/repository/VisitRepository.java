package com.capgemini.wsb.repository;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    Object findAllByPatient(PatientEntity patient);
}