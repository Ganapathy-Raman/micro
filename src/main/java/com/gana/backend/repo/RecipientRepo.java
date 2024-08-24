package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Recipient;

public interface RecipientRepo {

	public String save(Recipient recipient);

	public Recipient findById(int recipientId);
	
	public Recipient findByUserId(int userId);

	public List<Recipient> findAll();

	public String update(Recipient recipient);

	public String deleteById(int recipientId);
}
