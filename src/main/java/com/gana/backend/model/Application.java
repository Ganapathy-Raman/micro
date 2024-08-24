package com.gana.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationId;
	@ManyToOne(targetEntity = Recipient.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Recipient")
	private Recipient recipientId;
	private String bloodGroup;
	private String age;
	private String status;
	private String details;

	public Application() {
		super();

	}

	public Application(int applicationId, Recipient recipientId, String bloodGroup, String age, String status,
			String details) {
		super();
		this.applicationId = applicationId;
		this.recipientId = recipientId;
		this.bloodGroup = bloodGroup;
		this.age = age;
		this.status = status;
		this.details = details;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Recipient getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Recipient recipientId) {
		this.recipientId = recipientId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", recipientId=" + recipientId + ", bloodGroup="
				+ bloodGroup + ", age=" + age + ", status=" + status + ", details=" + details + "]";
	}

}
