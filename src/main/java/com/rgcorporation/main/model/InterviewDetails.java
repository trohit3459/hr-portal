package com.rgcorporation.main.model;

import java.time.LocalDate;

public class InterviewDetails {
	private int interviewId;
	private int candidateId;
	private int interviewerId;
	private String status;
	private String feedback;
	private LocalDate interviewDate;
	private CandidateDetails candidateDetails;
	private EmployeeDetails employeeDetails;

	public InterviewDetails() {
	}

	public InterviewDetails(int interviewId, int candidateId, int interviewerId, String status, String feedback,
			LocalDate interviewDate, CandidateDetails candidateDetails, EmployeeDetails employeeDetails) {
		super();
		this.interviewId = interviewId;
		this.candidateId = candidateId;
		this.interviewerId = interviewerId;
		this.status = status;
		this.feedback = feedback;
		this.interviewDate = interviewDate;
		this.candidateDetails = candidateDetails;
		this.employeeDetails = employeeDetails;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(int interviewerId) {
		this.interviewerId = interviewerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDate getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}

	public CandidateDetails getCandidateDetails() {
		return candidateDetails;
	}

	public void setCandidateDetails(CandidateDetails candidateDetails) {
		this.candidateDetails = candidateDetails;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	@Override
	public String toString() {
		return "InterviewDetails [interviewId=" + interviewId + ", candidateId=" + candidateId + ", interviewerId="
				+ interviewerId + ", status=" + status + ", feedback=" + feedback + ", interviewDate=" + interviewDate
				+ ", candidateDetails=" + candidateDetails + ", employeeDetails=" + employeeDetails + "]";
	}

}
