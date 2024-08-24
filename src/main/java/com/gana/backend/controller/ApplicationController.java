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

import com.gana.backend.model.Application;
import com.gana.backend.serviceimpl.ApplicationServiceImpl;

@RestController
@RequestMapping("/application")
@CrossOrigin("http://localhost:3000")
public class ApplicationController {

	ApplicationServiceImpl service;

	public ApplicationController(ApplicationServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertApplication(@RequestBody Application application) {

		String msg = "";
		try {
			service.addApplication(application);
			msg = "Success";
		} catch (Exception e) {

			msg = "Failure";

		}
		return msg;
	}

	@GetMapping("{applicationId}")
	public Application getApplicationById(@PathVariable("applicationId") int applicationId) {
		return service.getApplication(applicationId);
	}

	@GetMapping("/all")
	public List<Application> getApplications() {
		return service.getAllApplications();
	}

	@PutMapping
	public String updateApplication(@RequestBody Application application) {

		String msg = "";
		try {
			service.updateApplication(application);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{applicationId}")
	public String deleteApplicationById(@PathVariable("applicationId") int applicationId) {
		String msg = "";
		try {
			service.deleteApplication(applicationId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
