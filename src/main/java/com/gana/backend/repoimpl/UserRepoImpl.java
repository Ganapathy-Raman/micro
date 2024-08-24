package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.User;
import com.gana.backend.repo.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

	EntityManager entityManager;

	public UserRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override

	public User findByUserName(String userName) {
		String jpql = "SELECT u FROM User u WHERE u.userName = :userName";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("userName", userName);

		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}

	@Override
	public User save(User user) {
		entityManager.merge(user);
		return null;

	}

	@Override
	public User findById(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public List<User> findAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public String update(User user) {
		if (user != null) {
			entityManager.merge(user);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int userId) {
		User user = entityManager.find(User.class, userId);
		if (user != null) {
			entityManager.remove(user);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}
