package com.qa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

	Patient findByName(String name);

}
