package com.rgcorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.CandidateDetails;
import com.rgcorporation.main.model.RequirementRequestDetails;

@Component
public class CandidateDetailsRowMapper implements RowMapper<CandidateDetails> {

	@Autowired
	RequirementRequestDetailsRepository requirementRequestDetailsRepository;

	@Override
	public CandidateDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		int candidateId = rs.getInt("CANDIDATE_ID");
		String candidateName = rs.getString("CANDIDATE_NAME");
		String emailId = rs.getString("EMAIL");
		String skill1 = rs.getString("SKILL1");
		String skill2 = rs.getString("SKILL2");
		String skill3 = rs.getString("SKILL3");
		String qualification = rs.getString("QUALIFICATION");
		int experience = rs.getInt("EXPERIENCE");
		String status = rs.getString("STATUS");
		String location = rs.getString("LOCATION");
		RequirementRequestDetails requirementrequestetails = requirementRequestDetailsRepository
				.getRequirementRequestByRequirementRequestId(rs.getInt("REQUIREMENT_REQUEST_DETAILS_ID"));
		byte[] document = rs.getBytes("DOCUMENT");
		CandidateDetails candidateDetails = new CandidateDetails(candidateId, candidateName, emailId, skill1, skill2,
				skill3, qualification, experience, status, location, requirementrequestetails, document);
		return candidateDetails;
	}

	@Override
	public String toString() {
		return "CandidateDetailsRowMapper [requirementRequestDetailsRepository=" + requirementRequestDetailsRepository
				+ "]";
	}

}
/*
 * 
 * 
 * QUALIFICATION VARCHAR(50), EXPERIENCE NUMBER(3), STATUS VARCHAR(50) CHECK
 * (STATUS IN('NEW','SELECTED','PENDING','INPROCESS','REJECTED')),
 * REQUIREMENT_REQUEST_DETAILS_ID NUMBER(8), CONSTRAINT pk_candidate_id PRIMARY
 * KEY ( CANDIDATE_ID ), CONSTRAINT fk_requirement_request_details_id_cd FOREIGN
 * KEY ( REQUIREMENT_REQUEST_DETAILS_ID ) REFERENCES REQUIREMENT_REQUEST_DETAILS
 * ( REQUIREMENT_REQUEST_DETAILS_ID ) );
 * 
 */