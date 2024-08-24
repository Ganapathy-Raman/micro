package com.gana.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	@ManyToOne(targetEntity = Donor.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Donor")
	private Donor donorId;
	private String bloodGroup;
	private String age;
	private String details;
	private String status;

	public MedicalRecord() {
		super();

	}

	public MedicalRecord(int recordId, Donor donorId, String bloodGroup, String age, String details, String status) {
		super();
		this.recordId = recordId;
		this.donorId = donorId;
		this.bloodGroup = bloodGroup;
		this.age = age;
		this.details = details;
		this.status = status;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public Donor getDonorId() {
		return donorId;
	}

	public void setDonorId(Donor donorId) {
		this.donorId = donorId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MedicalRecord [recordId=" + recordId + ", donorId=" + donorId + ", bloodGroup=" + bloodGroup + ", age="
				+ age + ", details=" + details + ", status=" + status + "]";
	}

}
