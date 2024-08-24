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

import com.gana.backend.model.Donor;
import com.gana.backend.model.Recipient;
import com.gana.backend.model.User;
import com.gana.backend.service.DonorService;
import com.gana.backend.service.EmailService;
import com.gana.backend.service.UserService;
import com.gana.backend.serviceimpl.DonorServiceImpl;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/donor")
@CrossOrigin("http://localhost:3000")
public class DonorController {

	DonorServiceImpl service;

	public DonorController(DonorServiceImpl service) {
		super();
		this.service = service;
	}

	@Autowired
	private DonorService donorService;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping
	public String insertDonor(@RequestParam("userId") int userId, @RequestParam("donorName") String donorName,
			@RequestParam("dateOfAvailabity") Date dateOfAvailabity, @RequestParam("donate") String donate,
			@RequestParam("address") String address, @RequestParam("contactNo") String contactNo,
			@RequestParam("medicalHistory") MultipartFile medicalHistory, @RequestParam("status") String status) {

		try {
			User user = userService.findById(userId);
			if (user == null) {
				return "User not found";
			}

			byte[] medicalHistoryBytes = medicalHistory.getBytes();
			Donor donor = new Donor(0, user, donorName, dateOfAvailabity, donate, address, contactNo,
					medicalHistoryBytes, status);
			donorService.addDonor(donor);

			return "Success";
		} catch (IOException e) {
			return "Failure: IOException";
		} catch (Exception e) {
			return "Failure: Exception";
		}
	}

	@GetMapping("{donorId}")
	public Donor getDonorById(@PathVariable("donorId") int donorId) {
		return service.getDonor(donorId);
	}
	
	@GetMapping("/user/{userId}")
	public Donor getDonorByUserId(@PathVariable("userId") int userId) {
		return service.getDonorByUser(userId);
	}

	@GetMapping("/all")
	public List<Donor> getDonors() {
		return service.getAllDonors();
	}

	@PutMapping
	public String updateDonor(@RequestBody Donor donor) {

		String msg = "";
		try {
			service.updateDonor(donor);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{donorId}")
	public String deleteDonorById(@PathVariable("donorId") int donorId) {
		String msg = "";
		try {
			service.deleteDonor(donorId);
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
