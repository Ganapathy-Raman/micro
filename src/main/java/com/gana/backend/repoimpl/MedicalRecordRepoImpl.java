package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.MedicalRecord;
import com.gana.backend.repo.MedicalRecordRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MedicalRecordRepoImpl implements MedicalRecordRepo {

	EntityManager entityManager;

	public MedicalRecordRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(MedicalRecord medicalRecord) {
		if (medicalRecord != null) {
			entityManager.merge(medicalRecord);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public MedicalRecord findById(int recordId) {
		return entityManager.find(MedicalRecord.class, recordId);
	}

	@Override
	public List<MedicalRecord> findAll() {
		return entityManager.createQuery("from MedicalRecord", MedicalRecord.class).getResultList();
	}

	@Override
	public String update(MedicalRecord medicalRecord) {
		if (medicalRecord != null) {
			entityManager.merge(medicalRecord);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int recordId) {
		MedicalRecord medicalRecord = entityManager.find(MedicalRecord.class, recordId);
		if (medicalRecord != null) {
			entityManager.remove(medicalRecord);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}