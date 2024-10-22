package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.InterviewDetails;
import com.rgcorporation.main.repository.InterviewDetailsRepositoryInterface;

@Service
public class InterviewDetailsService implements InterviewDetailsServiceInterface {

	@Autowired
	private InterviewDetailsRepositoryInterface interviewDetailsRepository;

	@Autowired
	private CandidateDetailsServiceInterface detailsServiceInterface;
//	@Autowired
//	private CandidateDetailsRepositoryInterface candidateDetailsRepositoryInterface;

	@Autowired
	CandidateDetailsServiceInterface candidateDetailsServiceInterface;

	@Override
	public boolean addNewInterviewDetails(InterviewDetails interviewDetails) {
		System.out.println("in interviesdetails service ");
		System.out.println(interviewDetails);
		return interviewDetailsRepository.addNewInterviewDetails(interviewDetails);
	}

	@Override
	public boolean updateInterviewDetailsByInterviewId(InterviewDetails interviewDetails) {
		return interviewDetailsRepository.updateInterviewDetailsByInterviewId(interviewDetails);
	}

	@Override
	public boolean deleteInterviewDetailsByInterviewId(int interviewId) {
		return interviewDetailsRepository.deleteInterviewDetailsByInterviewId(interviewId);
	}

	@Override
	public InterviewDetails getInterviewDetailsById(int interviewId) {
		return interviewDetailsRepository.getInterviewDetailsById(interviewId);
	}

	@Override
	public List<InterviewDetails> getAllInterviewDetails() {
		return interviewDetailsRepository.getAllInterviewDetails();
	}

	@Override
	public List<InterviewDetails> getAllInterviewDetailsAsPending() {
		return interviewDetailsRepository.getAllInterviewDetailsAsPending();
	}

	@Override
	public boolean updateInterviewDetailsAsStatus(InterviewDetails interviewDetails) {
		return interviewDetailsRepository.updateInterviewDetailsAsStatus(interviewDetails);
	}

	@Override
	public boolean updateInterviewDetails(InterviewDetails interviewDetails) {
		boolean candidateDetails = candidateDetailsServiceInterface.updateCandidateDetailsDetailsByCandidateId(
				interviewDetails.getStatus(), interviewDetails.getCandidateDetails().getCandidateId());

		return interviewDetailsRepository.updateInterviewDetails(interviewDetails);
	}

}