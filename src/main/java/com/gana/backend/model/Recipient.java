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
public class Recipient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipientId;
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "User")
	private User userId;
	private String recipientName;
	private String contactNo;
	private Date dateOfAvailabity;
	private String organNeeded;
	private String address;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] medicalCondition;
	private String status;

	public Recipient() {
		super();

	}

	public Recipient(int recipientId, User userId, String recipientName, String contactNo, Date dateOfAvailabity,
			String organNeeded, String address, byte[] medicalCondition, String status) {
		super();
		this.recipientId = recipientId;
		this.userId = userId;
		this.recipientName = recipientName;
		this.contactNo = contactNo;
		this.dateOfAvailabity = dateOfAvailabity;
		this.organNeeded = organNeeded;
		this.address = address;
		this.medicalCondition = medicalCondition;
		this.status = status;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDateOfAvailabity() {
		return dateOfAvailabity;
	}

	public void setDateOfAvailabity(Date dateOfAvailabity) {
		this.dateOfAvailabity = dateOfAvailabity;
	}

	public String getOrganNeeded() {
		return organNeeded;
	}

	public void setOrganNeeded(String organNeeded) {
		this.organNeeded = organNeeded;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(byte[] medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Recipient [recipientId=" + recipientId + ", userId=" + userId + ", recipientName=" + recipientName
				+ ", contactNo=" + contactNo + ", dateOfAvailabity=" + dateOfAvailabity + ", organNeeded=" + organNeeded
				+ ", address=" + address + ", medicalCondition=" + Arrays.toString(medicalCondition) + ", status="
				+ status + "]";
	}

}
