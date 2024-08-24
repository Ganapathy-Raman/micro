package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.MedicalRecord;

public interface MedicalRecordRepo {

	public String save(MedicalRecord medicalRecord);

	public MedicalRecord findById(int recordId);

	public List<MedicalRecord> findAll();

	public String update(MedicalRecord medicalRecord);

	public String deleteById(int recordId);
}
