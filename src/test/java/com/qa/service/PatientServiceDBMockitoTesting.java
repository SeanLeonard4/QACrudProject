package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.domain.Patient;
import com.qa.repo.PatientRepo;

@SpringBootTest
@ActiveProfiles("test")
public class PatientServiceDBMockitoTesting {

	@Autowired
	private PatientServiceDB service;

	@MockBean
	private PatientRepo repo;

	@Test
	void testCreate() {
		// GIVEN
		Patient newPatient = new Patient("Sean", 23, "Sealeo123@gmail.com", "SK8 3QL", "Astrazeneca");
		Patient savedPatient = new Patient(1L, "Sean", 23, "Sealeo123@gmail.com", "SK8 3QL", "Astrazeneca");
		// WHEN
		Mockito.when(repo.save(newPatient)).thenReturn(savedPatient);
		// THEN
		assertThat(service.addPatient(newPatient)).isEqualTo(savedPatient);
		Mockito.verify(repo, Mockito.times(1)).save(newPatient);
	}

}
