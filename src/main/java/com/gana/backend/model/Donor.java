package com.gana.backend.model;

import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity

public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donorId;
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "User")
	private User userId;
	private String donorName;
	private Date dateOfAvailabity;
	private String donate;
	private String address;
	private String contactNo;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] medicalHistory;
	private String status;

	public Donor() {
		super();

	}

	public Donor(int donorId, User userId, String donorName, Date dateOfAvailabity, String donate, String address,
			String contactNo, byte[] medicalHistory, String status) {
		super();
		this.donorId = donorId;
		this.userId = userId;
		this.donorName = donorName;
		this.dateOfAvailabity = dateOfAvailabity;
		this.donate = donate;
		this.address = address;
		this.contactNo = contactNo;
		this.medicalHistory = medicalHistory;
		this.status = status;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public Date getDateOfAvailabity() {
		return dateOfAvailabity;
	}

	public void setDateOfAvailabity(Date dateOfAvailabity) {
		this.dateOfAvailabity = dateOfAvailabity;
	}

	public String getDonate() {
		return donate;
	}

	public void setDonate(String donate) {
		this.donate = donate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public byte[] getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(byte[] medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", userId=" + userId + ", donorName=" + donorName + ", dateOfAvailabity="
				+ dateOfAvailabity + ", donate=" + donate + ", address=" + address + ", contactNo=" + contactNo
				+ ", medicalHistory=" + Arrays.toString(medicalHistory) + ", status=" + status + "]";
	}

}
