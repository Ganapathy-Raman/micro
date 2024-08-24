package com.gana.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gana.backend.model.MedicalRecord;
import com.gana.backend.serviceimpl.MedicalRecordServiceImpl;

@RestController
@RequestMapping("/medicalRecord")
@CrossOrigin("http://localhost:3000")
public class MedicalRecordController {

	MedicalRecordServiceImpl service;

	public MedicalRecordController(MedicalRecordServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertMedicalRecord(@RequestBody MedicalRecord medicalRecord) {

		String msg = "";
		try {
			service.addMedicalRecord(medicalRecord);
			msg = "Success";
		} catch (Exception e) {

			msg = "Failure";

		}
		return msg;
	}

	@GetMapping("{recordId}")
	public MedicalRecord getMedicalRecordById(@PathVariable("recordId") int recordId) {
		return service.getMedicalRecord(recordId);
	}

	@GetMapping("/all")
	public List<MedicalRecord> getMedicalRecords() {
		return service.getAllMedicalRecords();
	}

	@PutMapping
	public String updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {

		String msg = "";
		try {
			service.updateMedicalRecord(medicalRecord);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{recordId}")
	public String deleteMedicalRecordById(@PathVariable("recordId") int recordId) {
		String msg = "";
		try {
			service.deleteMedicalRecord(recordId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
