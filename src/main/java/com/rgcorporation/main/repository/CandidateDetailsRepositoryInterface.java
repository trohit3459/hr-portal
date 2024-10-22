package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.CandidateDetails;

public interface CandidateDetailsRepositoryInterface {

	public boolean addNewCandidateDetails(CandidateDetails candidateDetails);

	public boolean updateCandidateDetailsDetailsByCandidateId(CandidateDetails candidateDetails);

	public boolean deleteCandidateDetailsDetailsByCandidateId(int candidateId);

	public CandidateDetails getCandidateDetailsByCandidateId(int candidateId);

	public List<CandidateDetails> getAllCandidateDetails();

	public boolean updateCandidateDetailsByStatus(CandidateDetails candidateDetails);

	public List<CandidateDetails> getAllInprocessCandidateDetails();

	public List<CandidateDetails> getAllNewCandidateDetails();

	public List<CandidateDetails> getAllSelectedCandidateDetails();

	public List<CandidateDetails> getAllRejectedCandidateDetails();

	public List<CandidateDetails> getAllPendingCandidateDetails();

	public boolean updateCandidateDetailsDetailsByCandidateId(String status, int candidateId);

}
