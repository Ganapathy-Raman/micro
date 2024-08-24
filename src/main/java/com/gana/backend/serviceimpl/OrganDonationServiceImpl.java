package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.OrganDonation;
import com.gana.backend.repo.OrganDonationRepo;
import com.gana.backend.service.OrganDonationService;

@Service
public class OrganDonationServiceImpl implements OrganDonationService {

	OrganDonationRepo repo;

	public OrganDonationServiceImpl(OrganDonationRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addOrganDonation(OrganDonation organDonation) {

		return repo.save(organDonation);

	}

	@Override
	public OrganDonation getOrganDonation(int donationId) {

		return repo.findById(donationId);

	}

	@Override
	public List<OrganDonation> getAllOrganDonations() {
		return repo.findAll();

	}

	@Override
	public String updateOrganDonation(OrganDonation organDonation) {
		return repo.update(organDonation);

	}

	@Override
	public String deleteOrganDonation(int donationId) {
		return repo.deleteById(donationId);
	}

}
