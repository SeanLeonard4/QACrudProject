package com.qa;

import java.util.List;

public interface PatientService {

	List<Patient> showPatients();

	Patient addPatient(Patient patient);

	Patient showPatientByName(String name);

	Patient showPatientByID(Long id);

	Patient updatePatient(Long id, Patient newPatient);

	Boolean deletePatient(Long id);

}
