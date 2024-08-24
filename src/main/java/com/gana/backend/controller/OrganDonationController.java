package com.gana.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gana.backend.model.OrganDonation;
import com.gana.backend.serviceimpl.OrganDonationServiceImpl;

@RestController
@RequestMapping("/organDonation")
@CrossOrigin("http://localhost:3000")
public class OrganDonationController {
	OrganDonationServiceImpl service;

	public OrganDonationController(OrganDonationServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertOrganDonation(@RequestBody OrganDonation organDonation) {

		String msg = "";
		try {
			service.addOrganDonation(organDonation);
			msg = "Success";
		} catch (Exception e) {

			msg = "Failure";

		}
		return msg;
	}

	@GetMapping("{donationId}")
	public OrganDonation getOrganDonationById(@PathVariable("donationId") int donationId) {
		return service.getOrganDonation(donationId);
	}

	@GetMapping("/all")
	public List<OrganDonation> getOrganDonations() {
		return service.getAllOrganDonations();
	}

	@PutMapping
	public String updateOrganDonation(@RequestBody OrganDonation organDonation) {

		String msg = "";
		try {
			service.updateOrganDonation(organDonation);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{donationId}")
	public String deleteOrganDonationById(@PathVariable("donationId") int donationId) {
		String msg = "";
		try {
			service.deleteOrganDonation(donationId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}