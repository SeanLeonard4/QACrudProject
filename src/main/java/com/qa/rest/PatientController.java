package com.qa.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.domain.Patient;
import com.qa.service.PatientService;

@CrossOrigin
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
	public ResponseEntity<Patient> showByID(@PathVariable Long id) {
		return new ResponseEntity<Patient>(service.showPatientByID(id), HttpStatus.OK);
	}

	@GetMapping("/showByName/{name}")
	public ResponseEntity<Patient> showByName(@PathVariable String name) {
		return new ResponseEntity<Patient>(service.showPatientByName(name), HttpStatus.OK);
	}

	@PutMapping("/updatePatient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient newPatient) {
		return new ResponseEntity<Patient>(service.updatePatient(id, newPatient), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("deletePatient/{id}")
	public ResponseEntity<Boolean> deletePatient(@PathVariable Long id) {
		service.deletePatient(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

}
