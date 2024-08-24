package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.MedicalRecord;

public interface MedicalRecordService {

	public String addMedicalRecord(MedicalRecord medicalRecord);

	public MedicalRecord getMedicalRecord(int recordId);

	public List<MedicalRecord> getAllMedicalRecords();

	public String updateMedicalRecord(MedicalRecord medicalRecord);

	public String deleteMedicalRecord(int recordId);
}
