package com.rgcorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rgcorporation.main.model.InterviewDetails;

@Repository
public class InterviewDetailsRepository implements InterviewDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	InterviewDetailsRowMapper interviewDetailsRowMapper;

	private static final String SELECT_ALL_INTERVIEW_DETAILS = "SELECT * FROM INTERVIEW_DETAILS";
	private static final String SELECT_SINGLE_INTERVIEW_DETAILS = "SELECT * FROM INTERVIEW_DETAILS WHERE INTERVIEW_ID = ?";

	private static final String DELETE_INTERVIEW_DETAILS = "DELETE INTERVIEW_DETAILS WHERE INTERVIEW_ID = ?";
	private static final String UPDATE_INTERVIEW_DETAILS = "UPDATE INTERVIEW_DETAILS SET STATUS = ?, CANDIDATE_ID = ?, FEEDBACK = ?, INTERVIEWER_ID =? ,INTERVIEW_DATE = ?	WHERE INTERVIEW_ID = ?";
	private static final String UPDATE_INTERVIEW_DETAILS_AS_STATUS = "UPDATE INTERVIEW_DETAILS SET STATUS = ? WHERE CANDIDATE_ID = ?";
	private static final String INSERT_INTERVIEW_DETAILS = "INSERT INTO INTERVIEW_DETAILS(INTERVIEW_ID,STATUS,CANDIDATE_ID,FEEDBACK,INTERVIEWER_ID,INTERVIEW_DATE)VALUES(SEQ_INTERVIEW_DETAILS.NEXTVAL,?,?,?,?,?)";
	int resultCount;

	@Override
	public boolean addNewInterviewDetails(InterviewDetails interviewDetails) {
//		System.out.println("inserting new INTERVIEW details into database");
//		System.out.println(interviewDetails);

		Object[] args = { interviewDetails.getStatus(), interviewDetails.getCandidateDetails().getCandidateId(),
				interviewDetails.getFeedback(), interviewDetails.getEmployeeDetails().getEmployeeId(),
				interviewDetails.getInterviewDate() };

		resultCount = jdbcTemplate.update(INSERT_INTERVIEW_DETAILS, args);

		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateInterviewDetailsByInterviewId(InterviewDetails interviewDetails) {
		Object[] args = { interviewDetails.getStatus(), interviewDetails.getCandidateDetails().getCandidateId(),
				interviewDetails.getFeedback(), interviewDetails.getEmployeeDetails().getEmployeeId(),
				interviewDetails.getInterviewDate(), interviewDetails.getInterviewId() };
		resultCount = jdbcTemplate.update(UPDATE_INTERVIEW_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteInterviewDetailsByInterviewId(int interviewId) {
		Object[] args = { interviewId };
		resultCount = jdbcTemplate.update(DELETE_INTERVIEW_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public InterviewDetails getInterviewDetailsById(int interviewId) {

		Object[] args = { interviewId };
		InterviewDetails employee = jdbcTemplate.queryForObject(SELECT_SINGLE_INTERVIEW_DETAILS,
				interviewDetailsRowMapper, args);
		// System.out.println("get single " + employee);
		return employee;
	}

	@Override
	public List<InterviewDetails> getAllInterviewDetails() {

		List<InterviewDetails> allEmployees = jdbcTemplate.query(SELECT_ALL_INTERVIEW_DETAILS,
				interviewDetailsRowMapper);
		return allEmployees;
	}

	private static final String SELECT_ALL_INPROCESS_INTERVIEW_DETAILS = "SELECT * FROM INTERVIEW_DETAILS WHERE STATUS = 'PENDING' ";

	@Override
	public List<InterviewDetails> getAllInterviewDetailsAsPending() {
		List<InterviewDetails> inprocessEmployees = jdbcTemplate.query(SELECT_ALL_INPROCESS_INTERVIEW_DETAILS,
				interviewDetailsRowMapper);
		return inprocessEmployees;
	}

	@Override
	public boolean updateInterviewDetailsAsStatus(InterviewDetails interviewDetails) {
		Object[] args = { interviewDetails.getStatus(), interviewDetails.getCandidateDetails().getCandidateId() };
		resultCount = jdbcTemplate.update(UPDATE_INTERVIEW_DETAILS_AS_STATUS, args);
		if (resultCount > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateInterviewDetails(InterviewDetails interviewDetails) {

		Object[] args = { interviewDetails.getStatus(), interviewDetails.getCandidateDetails().getCandidateId(),
				interviewDetails.getFeedback(), interviewDetails.getEmployeeDetails().getEmployeeId(),
				interviewDetails.getInterviewDate(), interviewDetails.getInterviewId() };

		resultCount = jdbcTemplate.update(UPDATE_INTERVIEW_DETAILS, args);
		if (resultCount > 0)
			return true;
		return false;
	}

}
