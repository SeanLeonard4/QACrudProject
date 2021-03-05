package com.qa;

import java.util.List;

public class PatientServiceDB implements PatientService {

	private PatientRepo repo;

	public PatientServiceDB(PatientRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Patient> showPatients() {
		return repo.findAll();
	}

	@Override
	public Patient addPatient(Patient patient) {
		return repo.save(patient);
	}

	@Override
	public Patient showPatientByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient showPatientByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatient(Long id, Patient newPatient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deletePatient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
