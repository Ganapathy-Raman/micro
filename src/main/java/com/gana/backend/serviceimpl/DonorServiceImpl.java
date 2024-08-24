package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Donor;
import com.gana.backend.model.Recipient;
import com.gana.backend.repo.DonorRepo;
import com.gana.backend.service.DonorService;

@Service
public class DonorServiceImpl implements DonorService {

	DonorRepo repo;

	public DonorServiceImpl(DonorRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addDonor(Donor donor) {

		return repo.save(donor);

	}

	@Override
	public Donor getDonor(int donorId) {

		return repo.findById(donorId);

	}

	@Override
	public List<Donor> getAllDonors() {
		return repo.findAll();

	}

	@Override
	public String updateDonor(Donor donor) {
		return repo.update(donor);

	}

	@Override
	public String deleteDonor(int donorId) {
		return repo.deleteById(donorId);
	}
	
	public Donor getDonorByUser(int userId) {
		return repo.findByUserId(userId);
	}

}
