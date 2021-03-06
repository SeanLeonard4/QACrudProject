package com.qa;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String postCode;
	private String vaccine;
	private LocalDate vaccineDate;
	private LocalDate futureVacDate;

	public Patient() {
	}

	public Patient(String name, String email, String postCode, String Vaccine) {
		this.name = name;
		this.email = email;
		this.postCode = postCode;
		this.vaccine = Vaccine;
		this.vaccineDate = LocalDate.now();
		this.futureVacDate = vaccineDate.plusWeeks(12);
	}

	public Patient(Long id, String name, String email, String postCode, String Vaccine) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.postCode = postCode;
		this.vaccine = Vaccine;
		this.vaccineDate = LocalDate.now();
		this.futureVacDate = vaccineDate.plusWeeks(12);
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", postCode=" + postCode + ", vaccine="
				+ vaccine + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((vaccine == null) ? 0 : vaccine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (vaccine == null) {
			if (other.vaccine != null)
				return false;
		} else if (!vaccine.equals(other.vaccine))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public LocalDate getVaccineDate() {
		return vaccineDate;
	}

	public void setVaccineDate(LocalDate vaccineDate) {
		this.vaccineDate = vaccineDate;
	}

	public LocalDate getFutureVacDate() {
		return futureVacDate;
	}

	public void setFutureVacDate(LocalDate vaccineDate) {
		this.futureVacDate = vaccineDate.plusWeeks(12);
	}

}
