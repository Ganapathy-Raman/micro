package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.OrganDonation;

public interface OrganDonationService {

	public String addOrganDonation(OrganDonation organDonation);

	public OrganDonation getOrganDonation(int donationId);

	public List<OrganDonation> getAllOrganDonations();

	public String updateOrganDonation(OrganDonation organDonation);

	public String deleteOrganDonation(int donationId);
}
