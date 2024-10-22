package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.CandidateDetails;

public interface CandidateDetailsServiceInterface {

	public boolean addNewCandidateDetails(CandidateDetails candidateDetails);

	public boolean updateCandidateDetailsByCandidateId(CandidateDetails candidateDetails);

	public boolean deleteCandidateDetailsByCandidateId(int candidateId);

	public CandidateDetails getCandidateDetailsByCandidateId(int candidateId);

	public List<CandidateDetails> getAllCandidateDetails();

	public boolean updateCandidateDetailsByStatus(CandidateDetails candidateDetails);

	public List<CandidateDetails> getAllInprocessCandidateDetails();

	public List<CandidateDetails> getAllNewCandidateDetails();

	public List<CandidateDetails> getAllSelectedCandidateDetails();

	public List<CandidateDetails> getAllRejectedCandidateDetails();

	public List<CandidateDetails> getAllPendingCandidateDetails();

	public boolean updateCandidateDetailsDetailsByCandidateId(String status, int candidateId);

	public boolean sendmailByStatus(CandidateDetails candidateDetails);

}
