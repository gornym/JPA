package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @Transactional
    @Test
    public void testFindAllVisitsByPatientId() {

        final List<VisitTO> listOfVisits = patientService.findVisitsByPatientId(2L);
        assertThat(listOfVisits.size()).isEqualTo(2);

    }

    @Transactional
    @Test
    public void deletePatientWithVisitsWithoutDoctors() {

        patientService.deleteById(2L);
        assertThat(patientService.findAll().size()).isEqualTo(2);
        final DoctorTO doctorTO = doctorService.findById(2L);
        assertThat(doctorTO.getVisits().size()).isEqualTo(1);

    }

    @Transactional
    @Test
    public void checkIntegrityWithNewAddField() {

        final Integer pesel = patientService.findById(3L).getPesel();
        assertThat(pesel).isEqualTo(123123123);

    }

}