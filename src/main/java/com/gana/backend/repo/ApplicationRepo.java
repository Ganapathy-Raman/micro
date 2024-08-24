package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Application;

public interface ApplicationRepo {

	public String save(Application application);

	public Application findById(int applicationId);

	public List<Application> findAll();

	public String update(Application application);

	public String deleteById(int applicationId);

}
