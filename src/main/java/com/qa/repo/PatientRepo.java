package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.domain.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

	Patient findByName(String name);

}
