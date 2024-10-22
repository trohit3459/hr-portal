package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.InterviewDetails;

public interface InterviewDetailsRepositoryInterface {
	public boolean addNewInterviewDetails(InterviewDetails interviewDetails);

	public boolean updateInterviewDetailsByInterviewId(InterviewDetails interviewDetails);

	public boolean deleteInterviewDetailsByInterviewId(int interviewId);

	public InterviewDetails getInterviewDetailsById(int interviewId);

	public List<InterviewDetails> getAllInterviewDetails();

	public List<InterviewDetails> getAllInterviewDetailsAsPending();

	public boolean updateInterviewDetailsAsStatus(InterviewDetails interviewDetails);

	public boolean updateInterviewDetails(InterviewDetails interviewDetails);

}
