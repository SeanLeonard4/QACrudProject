package com.qa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
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
		patient.setVaccineDate();
		patient.setFutureVacDate();
		return repo.save(patient);
	}

	@Override
	public Patient showPatientByName(String name) {
		Optional<Patient> optPatientByName = Optional.ofNullable(repo.findByName(name));
		return optPatientByName.orElseThrow(IDNotFound::new);
	}

	@Override
	public Patient showPatientByID(Long id) {
		Optional<Patient> optPatientByID = repo.findById(id);
		return optPatientByID.orElseThrow(IDNotFound::new);
	}

	@Override
	public Patient updatePatient(Long id, Patient newPatient) {
		Patient existing = this.showPatientByID(id);

		existing.setEmail(newPatient.getEmail());
		existing.setAge(newPatient.getAge());
		existing.setName(newPatient.getName());
		existing.setPostCode(newPatient.getPostCode());
		existing.setVaccine(newPatient.getVaccine());

		return this.repo.save(existing);
	}

	@Override
	public Boolean deletePatient(Long id) {
		repo.deleteById(id);
		return true;
	}
}
