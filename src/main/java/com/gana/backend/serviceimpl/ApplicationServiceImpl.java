package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Application;
import com.gana.backend.repo.ApplicationRepo;
import com.gana.backend.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	ApplicationRepo repo;

	public ApplicationServiceImpl(ApplicationRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addApplication(Application application) {

		return repo.save(application);

	}

	@Override
	public Application getApplication(int applicationId) {

		return repo.findById(applicationId);

	}

	@Override
	public List<Application> getAllApplications() {
		return repo.findAll();

	}

	@Override
	public String updateApplication(Application application) {
		return repo.update(application);

	}

	@Override
	public String deleteApplication(int applicationId) {
		return repo.deleteById(applicationId);
	}

}
