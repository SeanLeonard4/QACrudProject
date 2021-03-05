package com.qa;

import java.util.List;

public class PatientController {
	private PatientService service;

	public PatientController(PatientService service) {
		this.service = service;
	}

	public List<Patient> showAll() {
		return service.showPatients();
	}

	public Patient addPatient(Patient patient) {
		return service.addPatient(patient);
	}

	public Patient showByID(Long ID) {
		return service.showPatientByID(ID);
	}

	public Patient showByName(String name) {
		return service.showPatientByName(name);
	}

	public Patient updatePatient(Long ID, Patient newPatient) {
		return service.updatePatient(ID, newPatient);
	}

	public Boolean deletePatient(Long ID) {
		service.deletePatient(ID);
		return true;
	}

}
