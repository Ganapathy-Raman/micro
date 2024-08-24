package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Application;
import com.gana.backend.repo.ApplicationRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ApplicationRepoImpl implements ApplicationRepo {

	EntityManager entityManager;

	public ApplicationRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(Application application) {
		if (application != null) {
			entityManager.merge(application);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public Application findById(int applicationId) {
		return entityManager.find(Application.class, applicationId);
	}

	@Override
	public List<Application> findAll() {
		return entityManager.createQuery("from Application", Application.class).getResultList();
	}

	@Override
	public String update(Application application) {
		if (application != null) {
			entityManager.merge(application);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int applicationId) {
		Application application = entityManager.find(Application.class, applicationId);
		if (application != null) {
			entityManager.remove(application);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}
