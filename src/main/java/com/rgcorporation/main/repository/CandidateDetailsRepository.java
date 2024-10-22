package com.rgcorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rgcorporation.main.model.CandidateDetails;

@Repository
public class CandidateDetailsRepository implements CandidateDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	CandidateDetailsRowMapper candidateDetailsRowMapper;

	private static final String INSERT_CANDIDATE_DETAILS = "INSERT INTO CANDIDATES_DETAILS(CANDIDATE_ID,CANDIDATE_NAME,"
			+ "EMAIL,LOCATION,SKILL1,SKILL2,SKILL3,QUALIFICATION,EXPERIENCE,REQUIREMENT_REQUEST_DETAILS_ID)"
			+ " VALUES(SEQ_CANDIDATES_DETAILS.NEXTVAL,?,?,?,?,?,?,?,?,?)";

	

	private static final String SELECT_ALL_CANDIDATE_DETAILS = "SELECT * FROM CANDIDATES_DETAILS";
	private static final String SELECT_SINGLE_CANDIDATE_DETAIL = "SELECT * FROM CANDIDATES_DETAILS WHERE CANDIDATE_ID = ?";
	private static final String UPDATE_CANDIDATE_DETAILS = "UPDATE CANDIDATE_DETAILS SET CANDIDATE_NAME =?,EMAIL = ?, SKILL1= ?, SKILL2 = ?, SKILL3 = ? , QUALIFICATION = ? , EXPERIENCE = ? , STATUS =  ?,LOCATION=?, REQUIREMENT_REQUEST_DETAILS_ID = ?"
			+ "	WHERE CANDIDATE_ID = ?";
	private static final String DELETE_CANDIDATE_DETAILS = "DELETE CANDIDATE_DETAILS WHERE CANDIDATE_ID = ?";

	private static final String SELECT_ALL_INPROCESS_CANDIDATE_DETAILS = "SELECT * FROM CANDIDATES_DETAILS WHERE STATUS = 'INPROCESS'";

	private static final String SELECT_ALL_NEW_CANDIDATE_DETAILS = "SELECT * FROM CANDIDATES_DETAILS WHERE STATUS = 'NEW'";

	private static final String SELECT_ALL_SELECTED_CANDIDATE_DETAILS = "SELECT * FROM CANDIDATES_DETAILS WHERE STATUS = 'SELECTED'";

	private static final String SELECT_ALL_REJECTED_CANDIDATE_DETAILS = "SELECT * FROM CANDIDATES_DETAILS WHERE STATUS = 'REJECTED'";

	private static final String SELECT_ALL_PENDING_CANDIDATE_DETAILS = "SELECT * FROM CANDIDATES_DETAILS WHERE STATUS = 'PENDING'";

	int resultCount;

	@Override
	public boolean addNewCandidateDetails(CandidateDetails candidateDetails) {
//		System.out.println("inserting document details into database");
//		System.out.println(candidateDetails);

		Object[] args = { candidateDetails.getCandidateName(), candidateDetails.getEmail(),
				candidateDetails.getLocation(), candidateDetails.getSkill1(), candidateDetails.getSkill2(),
				candidateDetails.getSkill3(), candidateDetails.getQualification(), candidateDetails.getExperience(),
				candidateDetails.getRequirementrequestetails().getRequirementRequestId() };
		// System.out.println("Nitesh");
		resultCount = jdbcTemplate.update(INSERT_CANDIDATE_DETAILS, args);

		if (resultCount > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean updateCandidateDetailsDetailsByCandidateId(CandidateDetails candidateDetails) {
		Object[] args = { candidateDetails.getCandidateName(), candidateDetails.getEmail(),
				candidateDetails.getSkill1(), candidateDetails.getSkill2(), candidateDetails.getSkill3(),
				candidateDetails.getQualification(), candidateDetails.getExperience(), candidateDetails.getStatus(),
				candidateDetails.getLocation(), candidateDetails.getRequirementrequestetails(),
				candidateDetails.getCandidateId() };
		resultCount = jdbcTemplate.update(UPDATE_CANDIDATE_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteCandidateDetailsDetailsByCandidateId(int candidateId) {

		Object[] args = { candidateId };
		resultCount = jdbcTemplate.update(DELETE_CANDIDATE_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public CandidateDetails getCandidateDetailsByCandidateId(int candidateId) {
		Object[] args = { candidateId };
		CandidateDetails candidateDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_CANDIDATE_DETAIL,
				candidateDetailsRowMapper, args);
		return candidateDetails;
	}

	@Override
	public List<CandidateDetails> getAllCandidateDetails() {
		List<CandidateDetails> allCandidates = jdbcTemplate.query(SELECT_ALL_CANDIDATE_DETAILS,
				candidateDetailsRowMapper);
		return allCandidates;
	}

	private static final String UPDATE_CANDIDATE_DETAILS_AS_INPROCESS = "UPDATE CANDIDATES_DETAILS SET STATUS = 'INPROCESS' WHERE CANDIDATE_ID=?";

	@Override
	public boolean updateCandidateDetailsByStatus(CandidateDetails candidateDetails) {
		// TODO Auto-generated method stub
		Object[] args = { candidateDetails.getCandidateId() };
		resultCount = jdbcTemplate.update(UPDATE_CANDIDATE_DETAILS_AS_INPROCESS, args);

		if (resultCount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<CandidateDetails> getAllInprocessCandidateDetails() {
		List<CandidateDetails> allInprocessCandidates = jdbcTemplate.query(SELECT_ALL_INPROCESS_CANDIDATE_DETAILS,
				candidateDetailsRowMapper);
		return allInprocessCandidates;
	}

	@Override
	public List<CandidateDetails> getAllNewCandidateDetails() {
		List<CandidateDetails> allNewCandidates = jdbcTemplate.query(SELECT_ALL_NEW_CANDIDATE_DETAILS,
				candidateDetailsRowMapper);
		return allNewCandidates;
	}

	@Override
	public List<CandidateDetails> getAllSelectedCandidateDetails() {
		List<CandidateDetails> allSelectedCandidates = jdbcTemplate.query(SELECT_ALL_SELECTED_CANDIDATE_DETAILS,
				candidateDetailsRowMapper);
		return allSelectedCandidates;
	}

	@Override
	public List<CandidateDetails> getAllRejectedCandidateDetails() {
		List<CandidateDetails> allRejectedCandidates = jdbcTemplate.query(SELECT_ALL_REJECTED_CANDIDATE_DETAILS,
				candidateDetailsRowMapper);
		return allRejectedCandidates;
	}

	@Override
	public List<CandidateDetails> getAllPendingCandidateDetails() {
		List<CandidateDetails> allPendingCandidates = jdbcTemplate.query(SELECT_ALL_PENDING_CANDIDATE_DETAILS,
				candidateDetailsRowMapper);
		return allPendingCandidates;
	}

	private static final String UPDATE_CANDIDATE_DETAILS_BY_INTERVIEWER = "UPDATE CANDIDATES_DETAILS SET STATUS = ? WHERE CANDIDATE_ID = ?";

	@Override
	public boolean updateCandidateDetailsDetailsByCandidateId(String status, int candidateId) {
		Object[] args = { status, candidateId };
		resultCount = jdbcTemplate.update(UPDATE_CANDIDATE_DETAILS_BY_INTERVIEWER, args);
		if (resultCount > 0)
			return true;
		return false;
	}

}
