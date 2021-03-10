package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

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

	@Test
	void testUpdate() {
		// GIVEN
		// ID
		Long id = 1L;
		// NEW Patient DATA
		Patient newPatient = new Patient("Sean", 23, "Sealeo123@gmail.com", "SK8 3QL", "Astrazeneca");
		// OPTIONAL Patient
		Optional<Patient> optPatient = Optional.of(new Patient(id, null, 0, null, null, null));
		// UPDATED PATIENT
		Patient updatedPatient = new Patient(id, newPatient.getName(), newPatient.getAge(), newPatient.getEmail(),
				newPatient.getPostCode(), newPatient.getVaccine());
		// WHEN
		Mockito.when(repo.findById(id)).thenReturn(optPatient);
		Mockito.when(repo.save(updatedPatient)).thenReturn(updatedPatient);
		// THEN
		assertThat(service.updatePatient(id, newPatient)).isEqualTo(updatedPatient);
	}

	@Test
	void testDelete() {
		// GIVEN
		Long id = 1L;
		// WHEN
		// THEN
		assertThat(service.deletePatient(id)).isEqualTo(true);
	}

	@Test
	void testGet() {
		// GIVEN
		Long id = 1L;
		Patient dbPatient = new Patient(id, "Sean", 23, "Sealeo123@gmail.com", "SK8 3QL", "Astrazeneca");
		List<Patient> allPatients = List.of(dbPatient);
		// WHEN
		Mockito.when(repo.findAll()).thenReturn(allPatients);
		// THEN
		assertThat(service.showPatients()).isEqualTo(allPatients);
	}
}
