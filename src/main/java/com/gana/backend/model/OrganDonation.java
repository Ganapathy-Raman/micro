package com.gana.backend.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrganDonation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donationId;
	@ManyToOne(targetEntity = Donor.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Donor")
	private Donor donorId;
	private String organType;
	private Date donationDate;
	@ManyToOne(targetEntity = Recipient.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Recipient")
	private Recipient recipientId;
	private String status;

	public OrganDonation() {
		super();

	}

	public OrganDonation(int donationId, Donor donorId, String organType, Date donationDate, Recipient recipientId,
			String status) {
		super();
		this.donationId = donationId;
		this.donorId = donorId;
		this.organType = organType;
		this.donationDate = donationDate;
		this.recipientId = recipientId;
		this.status = status;
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public Donor getDonorId() {
		return donorId;
	}

	public void setDonorId(Donor donorId) {
		this.donorId = donorId;
	}

	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public Recipient getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Recipient recipientId) {
		this.recipientId = recipientId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrganDonation [donationId=" + donationId + ", donorId=" + donorId + ", organType=" + organType
				+ ", donationDate=" + donationDate + ", recipientId=" + recipientId + ", status=" + status + "]";
	}

}
