package com.qa.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Patient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:patient-schema.sql",
		"classpath:patient-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PatientControllerIntegrationTest {

	@Autowired
	private MockMvc mock;
	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		// Create patient
		Patient newPatient = new Patient("Sean", 23, "Seanleo1234@gmail.com", "sk8 3ql", "Astrazeneca");
		// convert patient to json string
		String newPatientAsJSON = mapper.writeValueAsString(newPatient);
		// Build mock request
		RequestBuilder mockRequest = post("/createPatient").contentType(MediaType.APPLICATION_JSON)
				.content(newPatientAsJSON);
		// Create saved patient
		Patient savedPatient = new Patient(2L, "Sean", 23, "Seanleo1234@gmail.com", "sk8 3ql", "Astrazeneca");
		// Convert saved patient to json
		String savedPatientAsJSON = mapper.writeValueAsString(savedPatient);
		// Check status as expected
		ResultMatcher matchStatus = status().isCreated();
		// Check response of body is correct
		ResultMatcher matchContent = content().json(savedPatientAsJSON);

		mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}
}
