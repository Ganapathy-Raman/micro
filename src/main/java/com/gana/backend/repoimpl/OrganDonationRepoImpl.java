package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.OrganDonation;
import com.gana.backend.repo.OrganDonationRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrganDonationRepoImpl implements OrganDonationRepo {

	EntityManager entityManager;

	public OrganDonationRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(OrganDonation organDonation) {
		if (organDonation != null) {
			entityManager.merge(organDonation);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public OrganDonation findById(int donationId) {
		return entityManager.find(OrganDonation.class, donationId);
	}

	@Override
	public List<OrganDonation> findAll() {
		return entityManager.createQuery("from OrganDonation", OrganDonation.class).getResultList();
	}

	@Override
	public String update(OrganDonation organDonation) {
		if (organDonation != null) {
			entityManager.merge(organDonation);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int donationId) {
		OrganDonation organDonation = entityManager.find(OrganDonation.class, donationId);
		if (organDonation != null) {
			entityManager.remove(organDonation);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}