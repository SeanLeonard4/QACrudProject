package com.qa;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	private PatientService service;

	public PatientController(PatientService service) {
		this.service = service;
	}

	@GetMapping("/showAll")
	public ResponseEntity<List<Patient>> showAll() {
		return ResponseEntity.ok(service.showPatients());
	}

	@PostMapping("/createPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(service.addPatient(patient), HttpStatus.CREATED);
	}

	@GetMapping("/showByID/{id}")
	public ResponseEntity<Patient> showByID(@PathVariable Long ID) {
		return new ResponseEntity<Patient>(service.showPatientByID(ID), HttpStatus.OK);
	}

	@GetMapping("/showByName/{name}")
	public ResponseEntity<Patient> showByName(@PathVariable String name) {
		return new ResponseEntity<Patient>(service.showPatientByName(name), HttpStatus.OK);
	}

	@PutMapping("/updatePatient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long ID, @RequestBody Patient newPatient) {
		return new ResponseEntity<Patient>(service.updatePatient(ID, newPatient), HttpStatus.CREATED);
	}

	@DeleteMapping("deletePatient/{id}")
	public ResponseEntity<Boolean> deletePatient(@PathVariable Long ID) {
		service.deletePatient(ID);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

}
