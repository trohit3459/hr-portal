package com.rgcorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.CandidateDetails;
import com.rgcorporation.main.model.EmployeeDetails;
import com.rgcorporation.main.model.InterviewDetails;

@Component
public class InterviewDetailsRowMapper implements RowMapper<InterviewDetails> {
	@Autowired
	CandidateDetailsRepository candidateDetailsRepository;
	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public InterviewDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		int interviewId = rs.getInt("INTERVIEW_ID");
		int candidateId = rs.getInt("CANDIDATE_ID");
		int interviewerId = rs.getInt("INTERVIEWER_ID");
		String status = rs.getString("STATUS");
		String feedback = rs.getString("FEEDBACK");
		LocalDate interviewDate = rs.getDate("INTERVIEW_DATE").toLocalDate();
		CandidateDetails candidateDetails = candidateDetailsRepository
				.getCandidateDetailsByCandidateId(rs.getInt("CANDIDATE_ID"));
		EmployeeDetails employeeDetails = employeeDetailsRepository
				.getEmployeeByEmployeeId(rs.getInt("INTERVIEWER_ID"));

		InterviewDetails interviewDetails = new InterviewDetails(interviewId, candidateId, interviewerId, status,
				feedback, interviewDate, candidateDetails, employeeDetails);

		return interviewDetails;
	}

}
