package com.qa;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

	Patient findByName(String name);

	Patient save(Patient patient, LocalDate vaccineDate, LocalDate futureVacDate);

}
