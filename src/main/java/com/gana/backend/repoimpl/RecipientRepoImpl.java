package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Recipient;
import com.gana.backend.repo.RecipientRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RecipientRepoImpl implements RecipientRepo {

	EntityManager entityManager;

	public RecipientRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(Recipient recipient) {
		if (recipient != null) {
			entityManager.merge(recipient);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public Recipient findByUserId(int userId) {
		String jpql = "SELECT r FROM Recipient r WHERE r.userId.id = :userId";

		TypedQuery<Recipient> query = entityManager.createQuery(jpql, Recipient.class);

		query.setParameter("userId", userId);

		Recipient recipient = query.getResultStream().findFirst().orElse(null);

		return recipient;
	}
	
	@Override
	public Recipient findById(int recipientId) {
		return entityManager.find(Recipient.class, recipientId);
	}

	@Override
	public List<Recipient> findAll() {
		return entityManager.createQuery("from Recipient", Recipient.class).getResultList();
	}

	@Override
	public String update(Recipient recipient) {
		if (recipient != null) {
			entityManager.merge(recipient);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int recipientId) {
		Recipient recipient = entityManager.find(Recipient.class, recipientId);
		if (recipient != null) {
			entityManager.remove(recipient);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}