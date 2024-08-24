package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.MedicalRecord;
import com.gana.backend.repo.MedicalRecordRepo;
import com.gana.backend.service.MedicalRecordService;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

	MedicalRecordRepo repo;

	public MedicalRecordServiceImpl(MedicalRecordRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addMedicalRecord(MedicalRecord medicalRecord) {

		return repo.save(medicalRecord);

	}

	@Override
	public MedicalRecord getMedicalRecord(int recordId) {

		return repo.findById(recordId);

	}

	@Override
	public List<MedicalRecord> getAllMedicalRecords() {
		return repo.findAll();

	}

	@Override
	public String updateMedicalRecord(MedicalRecord medicalRecord) {
		return repo.update(medicalRecord);

	}

	@Override
	public String deleteMedicalRecord(int recordId) {
		return repo.deleteById(recordId);
	}

}
