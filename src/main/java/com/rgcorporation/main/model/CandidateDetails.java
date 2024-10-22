package com.rgcorporation.main.model;

import java.util.Arrays;

public class CandidateDetails {
	private int candidateId;
	private String candidateName;
	private String email;
	private String skill1;
	private String skill2;
	private String skill3;
	private String qualification;
	private int experience;
	private String status;
	private String location;
	private byte[] document;
	private RequirementRequestDetails requirementrequestetails;

	public CandidateDetails() {
	}

	public CandidateDetails(int candidateId, String candidateName, String email, String skill1, String skill2,
			String skill3, String qualification, int experience, String status, String location,
			RequirementRequestDetails requirementrequestetails, byte[] document) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.email = email;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.qualification = qualification;
		this.experience = experience;
		this.status = status;
		this.location = location;
		this.requirementrequestetails = requirementrequestetails;
		this.document = document;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}

	public String getSkill3() {
		return skill3;
	}

	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public RequirementRequestDetails getRequirementrequestetails() {
		return requirementrequestetails;
	}

	public void setRequirementrequestetails(RequirementRequestDetails requirementrequestetails) {
		this.requirementrequestetails = requirementrequestetails;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "CandidateDetails [candidateId=" + candidateId + ", candidateName=" + candidateName + ", email=" + email
				+ ", skill1=" + skill1 + ", skill2=" + skill2 + ", skill3=" + skill3 + ", qualification="
				+ qualification + ", experience=" + experience + ", status=" + status + ", location=" + location
				+ ", requirementrequestetails=" + requirementrequestetails + ", document=" + Arrays.toString(document)
				+ "]";
	}

}
