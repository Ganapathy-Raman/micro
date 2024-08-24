package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Recipient;
import com.gana.backend.repo.RecipientRepo;
import com.gana.backend.service.RecipientService;

@Service
public class RecipientServiceImpl implements RecipientService {

	RecipientRepo repo;

	public RecipientServiceImpl(RecipientRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addRecipient(Recipient recipient) {

		return repo.save(recipient);

	}

	@Override
	public Recipient getRecipient(int recipientId) {

		return repo.findById(recipientId);

	}

	@Override
	public List<Recipient> getAllRecipients() {
		return repo.findAll();

	}

	@Override
	public String updateRecipient(Recipient recipient) {
		return repo.update(recipient);

	}

	@Override
	public String deleteRecipient(int recipientId) {
		return repo.deleteById(recipientId);
	}

	public Recipient getRecipientByUser(int userId) {
		return repo.findByUserId(userId);
	}

}
