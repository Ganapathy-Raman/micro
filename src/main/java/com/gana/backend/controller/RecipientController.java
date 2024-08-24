package com.gana.backend.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gana.backend.model.Recipient;
import com.gana.backend.model.User;
import com.gana.backend.service.EmailService;
import com.gana.backend.service.RecipientService;
import com.gana.backend.service.UserService;
import com.gana.backend.serviceimpl.RecipientServiceImpl;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/recipient")
@CrossOrigin("http://localhost:3000")
public class RecipientController {

	RecipientServiceImpl service;

	public RecipientController(RecipientServiceImpl service) {
		super();
		this.service = service;
	}

	@Autowired
	private RecipientService recipientService;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping
	public String insertRecipient(@RequestParam("userId") int userId,
			@RequestParam("recipientName") String recipientName, @RequestParam("contactNo") String contactNo,
			@RequestParam("dateOfAvailabity") Date dateOfAvailabity, @RequestParam("organNeeded") String organNeeded,
			@RequestParam("address") String address,

			@RequestParam("medicalCondition") MultipartFile medicalCondition, @RequestParam("status") String status) {

		try {
			User user = userService.findById(userId);
			if (user == null) {
				return "User not found";
			}

			byte[] medicalConditionBytes = medicalCondition.getBytes();
			Recipient recipient = new Recipient(0, user, recipientName, contactNo, dateOfAvailabity, organNeeded,
					address, medicalConditionBytes, status);
			recipientService.addRecipient(recipient);

			return "Success";
		} catch (IOException e) {
			return "Failure: IOException";
		} catch (Exception e) {
			return "Failure: Exception";
		}
	}

	@GetMapping("{recipientId}")
	public Recipient getRecipientById(@PathVariable("recipientId") int recipientId) {
		return service.getRecipient(recipientId);
	}

	@GetMapping("/user/{userId}")
	public Recipient getRecipientByUserId(@PathVariable("userId") int userId) {
		return service.getRecipientByUser(userId);
	}
	
	@GetMapping("/all")
	public List<Recipient> getRecipients() {
		return service.getAllRecipients();
	}

	@PutMapping
	public String updateRecipient(@RequestBody Recipient recipient) {

		String msg = "";
		try {
			service.updateRecipient(recipient);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{recipientId}")
	public String deleteRecipientById(@PathVariable("recipientId") int recipientId) {
		String msg = "";
		try {
			service.deleteRecipient(recipientId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestParam String from, @RequestParam String to,
			@RequestParam String subject, @RequestParam String body,
			@RequestParam(required = false) MultipartFile attachment) {
		try {

			emailService.sendEmail(to, subject, body, attachment);
			return ResponseEntity.ok("Email sent successfully");
		} catch (MessagingException | IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}

}