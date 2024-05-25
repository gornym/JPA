package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

public class VisitTO implements Serializable {

    private Long id;
    private String description;
    private LocalDateTime time;
    private Long doctor_id;
    private Long medical_treatment_id;
    private Long patient_id;

    private Collection<MedicalTreatmentTO> medicalTreatments;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public Long getDoctor_id() { return doctor_id; }
    public void setDoctor_id(Long doctor_id) { this.doctor_id = doctor_id; }

    public Long getMedical_treatment_id() { return medical_treatment_id; }

    public Long getPatient_id() { return patient_id; }
    public void setPatient_id(Long patient_id) { this.patient_id = patient_id; }


    public Collection<MedicalTreatmentTO> getMedicalTreatments() {
        return medicalTreatments;
    }

    private DoctorTO doctor;

    private PatientTO patient;


    public DoctorTO getDoctor() {
        return doctor;
    }

    public PatientTO getPatient() {
        return patient;
    }


    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }


}