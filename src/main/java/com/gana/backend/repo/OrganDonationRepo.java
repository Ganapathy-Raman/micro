package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.OrganDonation;

public interface OrganDonationRepo {

	public String save(OrganDonation organDonation);

	public OrganDonation findById(int donationId);

	public List<OrganDonation> findAll();

	public String update(OrganDonation organDonation);

	public String deleteById(int donationId);
}
