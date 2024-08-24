package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Recipient;

public interface RecipientService {

	public String addRecipient(Recipient recipient);

	public Recipient getRecipient(int recipientId);

	public List<Recipient> getAllRecipients();

	public String updateRecipient(Recipient recipient);

	public String deleteRecipient(int recipientId);
	
	public Recipient getRecipientByUser(int userId);
}
