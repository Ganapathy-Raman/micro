package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Donor;

public interface DonorRepo {

	public String save(Donor donor);

	public Donor findById(int donorId);
	
	public Donor findByUserId(int userId);

	public List<Donor> findAll();

	public String update(Donor donor);

	public String deleteById(int donorId);
	
}
