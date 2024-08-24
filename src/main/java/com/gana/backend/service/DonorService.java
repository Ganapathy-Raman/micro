package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Donor;

public interface DonorService {

	public String addDonor(Donor donor);

	public Donor getDonor(int donorId);

	public List<Donor> getAllDonors();

	public String updateDonor(Donor donor);

	public String deleteDonor(int donorId);
	
	public Donor getDonorByUser(int userId);

}
