package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Application;

public interface ApplicationService {

	public String addApplication(Application application);

	public Application getApplication(int applicationId);

	public List<Application> getAllApplications();

	public String updateApplication(Application application);

	public String deleteApplication(int applicationId);

}
