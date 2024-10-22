package com.rgcorporation.main.model;

import java.util.Arrays;

public class DocumentDetails {

	private int documentId;
	private String documentType;
	private int candidateId;
	private byte[] document;
	private CandidateDetails candidateDetails;

	public DocumentDetails() {
	}

	public DocumentDetails(int documentId, String documentType, int candidateId, byte[] document,
			CandidateDetails candidateDetails) {
		super();
		this.documentId = documentId;
		this.documentType = documentType;
		this.candidateId = candidateId;
		this.document = document;
		this.candidateDetails = candidateDetails;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public CandidateDetails getCandidateDetails() {
		return candidateDetails;
	}

	public void setCandidateDetails(CandidateDetails candidateDetails) {
		this.candidateDetails = candidateDetails;
	}

	@Override
	public String toString() {
		return "DocumentDetails [documentId=" + documentId + ", documentType=" + documentType + ", candidateId="
				+ candidateId + ", document=" + Arrays.toString(document) + ", candidateDetails=" + candidateDetails
				+ "]";
	}

}
