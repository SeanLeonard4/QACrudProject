package com.qa.service;

import java.util.List;

import com.qa.domain.Patient;

public interface PatientService {

	List<Patient> showPatients();

	Patient addPatient(Patient patient);

	Patient showPatientByName(String name);

	Patient showPatientByID(Long id);

	Patient updatePatient(Long id, Patient newPatient);

	Boolean deletePatient(Long id);

}
