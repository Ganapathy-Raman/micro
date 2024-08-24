package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Donor;
import com.gana.backend.repo.DonorRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DonorRepoImpl implements DonorRepo {

	EntityManager entityManager;

	public DonorRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(Donor donor) {
		if (donor != null) {
			entityManager.merge(donor);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public Donor findByUserId(int userId) {
		String jpql = "SELECT d FROM Donor d WHERE d.userId.id = :userId";

		TypedQuery<Donor> query = entityManager.createQuery(jpql, Donor.class);

		query.setParameter("userId", userId);

		Donor donor = query.getResultStream().findFirst().orElse(null);

		return donor;
	}
	@Override
	public Donor findById(int donorId) {
		return entityManager.find(Donor.class, donorId);
	}

	
	@Override
	public List<Donor> findAll() {
		return entityManager.createQuery("from Donor", Donor.class).getResultList();
	}

	@Override
	public String update(Donor donor) {
		if (donor != null) {
			entityManager.merge(donor);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int donorId) {
		Donor donor = entityManager.find(Donor.class, donorId);
		if (donor != null) {
			entityManager.remove(donor);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}