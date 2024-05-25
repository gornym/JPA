package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {

        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctor_id(visitEntity.getDoctor().getId());
        visitTO.setPatient_id(visitEntity.getPatient().getId());

        return visitTO;
    }
}