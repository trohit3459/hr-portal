package com.rgcorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rgcorporation.main.model.RequirementRequestDetails;

@Repository
public class RequirementRequestDetailsRepository implements RequirementRequestDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private RequirementRequestDetailsRowMapper requestDetailsRowMapper;

	private static final String INSERT_REQUIREMENT_REQUEST = "INSERT INTO REQUIREMENT_REQUEST_DETAILS(REQUIREMENT_REQUEST_DETAILS_ID,PROJECT_ID, SKILL1, SKILL2,SKILL3,EXPERIENCE, VACANCIES,TEAM_LEADER_ID,STATUS,ROLE) VALUES(SEQ_REQUIREMENT_REQUEST_DETAILS.nextval,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_REQUIREMENT_REQUEST = "SELECT * FROM REQUIREMENT_REQUEST_DETAILS";
	private static final String SELECT_SINGLE_REQUIREMENT_REQUEST = "SELECT * FROM REQUIREMENT_REQUEST_DETAILS WHERE REQUIREMENT_REQUEST_DETAILS_ID = ?";
	private static final String UPDATE_REQUIREMENT_REQUEST_DETAILS = "UPDATE REQUIREMENT_REQUEST_DETAILS SET PROJECT_ID = ?, SKILL1 = ?,"
			+ " " + "SKILL2= ? , SKILL3= ?, EXPERIENCE = ?, VACANCIES = ? , TEAM_LEADER_ID = ?,STATUS= ?, ROLE =?"
			+ "	WHERE REQUIREMENT_REQUEST_DETAILS_ID = ?";
	private static final String SELECT_NO_OF_VACANCIES = "SELECT VACANCIES FROM REQUIREMENT_REQUEST_DETAILS WHERE REQUIREMENT_REQUEST_DETAILS_ID=?";
	private static final String SELECT_ALL_REQUIREMENT_REQUEST_DETAILS_FOR_SELECTED = "SELECT * FROM REQUIREMENT_REQUEST_DETAILS WHERE STATUS ='SELECTED'";
	private static final String SELECT_ALL_REQUIREMENT_REQUEST_DETAILS_FOR_NEW = "SELECT * FROM REQUIREMENT_REQUEST_DETAILS WHERE STATUS ='NEW'";
	private static final String SELECT_ALL_REQUIREMENT_REQUEST_DETAILS_FOR_INPROCESS = "SELECT * FROM REQUIREMENT_REQUEST_DETAILS WHERE STATUS ='INPROCESS'";

	private static final String UPDATE_REQUIREMENT_REQUEST_DETAILS_STATUS = "UPDATE REQUIREMENT_REQUEST_DETAILS SET  STATUS=? WHERE REQUIREMENT_REQUEST_DETAILS_ID =?";
	private static final String GET_ALL_REQUIREMENTREQUST_USING_EMPLOYEE_ID = "SELECT * FROM REQUIREMENT_REQUEST_DETAILS WHERE STATUS='NEW' AND TEAM_LEADER_ID=? ";
	private static final String DELETE_REQUIREMENT_REQUEST = "DELETE REQUIREMENT_REQUEST_DETAILS WHERE REQUIREMENT_REQUEST_DETAILS_ID = ?";
	private static final String ALl_REQUEST_DETAILS_USING_PROJECT_ID = "select * from requirement_request_details where project_id= ? AND STATUS='NEW' ";
	private static final String UPDATE_REQUIREMENT_REQUEST_DETAILS_STATUS_AS_SELECTED = "UPDATE REQUIREMENT_REQUEST_DETAILS SET STATUS=? WHERE REQUIREMENT_REQUEST_DETAILS_ID =?";

	int resultCount;

	@Override
	public boolean addNewRequirementRequest(RequirementRequestDetails requirementRequestDetails) {

		Object[] args = { requirementRequestDetails.getProjectDetails().getProjectId(),
				requirementRequestDetails.getSkill1(), requirementRequestDetails.getSkill2(),
				requirementRequestDetails.getSkill3(), requirementRequestDetails.getExperience(),
				requirementRequestDetails.getVacancies(),
				requirementRequestDetails.getEmployeeDetails().getEmployeeId(), requirementRequestDetails.getStatus(),
				requirementRequestDetails.getRole() };

		resultCount = jdbcTemplate.update(INSERT_REQUIREMENT_REQUEST, args);

		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateRequirementRequestByRequirementRequestId(RequirementRequestDetails requirementRequestDetails) {
		System.out.println("In updateRequirementRequestByRequirementRequestId");
		Object[] args = { requirementRequestDetails.getProjectDetails().getProjectId(),
				requirementRequestDetails.getSkill1(), requirementRequestDetails.getSkill2(),
				requirementRequestDetails.getSkill3(), requirementRequestDetails.getExperience(),
				requirementRequestDetails.getVacancies(),
				requirementRequestDetails.getEmployeeDetails().getEmployeeId(), requirementRequestDetails.getStatus(),
				requirementRequestDetails.getRole(), requirementRequestDetails.getRequirementRequestId() };

		resultCount = jdbcTemplate.update(UPDATE_REQUIREMENT_REQUEST_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteRequirementRequestByRequirementRequestId(int requirementRequestId) {

		Object[] args = { requirementRequestId };
		resultCount = jdbcTemplate.update(DELETE_REQUIREMENT_REQUEST, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public RequirementRequestDetails getRequirementRequestByRequirementRequestId(int requirementRequestId) {

		Object[] args = { requirementRequestId };
		RequirementRequestDetails requirementRequestDetails = jdbcTemplate
				.queryForObject(SELECT_SINGLE_REQUIREMENT_REQUEST, requestDetailsRowMapper, args);
		return requirementRequestDetails;
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequest() {

		List<RequirementRequestDetails> allRequirementRequest = jdbcTemplate.query(SELECT_ALL_REQUIREMENT_REQUEST,
				requestDetailsRowMapper);
		return allRequirementRequest;
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestUsingProjectId(int projectId) {
		Object[] args = { projectId };
		List<RequirementRequestDetails> allRequirementRequest = jdbcTemplate.query(ALl_REQUEST_DETAILS_USING_PROJECT_ID,
				requestDetailsRowMapper, args);
		return allRequirementRequest;

	}

	@Override
	public int getRequiredNoOfVacanciesByRequestId(int requestId) {

		Object[] args = { requestId };
		// System.out.println("In Req Req Details repo");
		int requiredVacancies = jdbcTemplate.queryForObject(SELECT_NO_OF_VACANCIES, Integer.class, args);

		return requiredVacancies;
	}

	@Override
	public boolean updateRequirementRequestDetailStatus(RequirementRequestDetails requirementRequestDetails) {
		Object[] args = { requirementRequestDetails.getStatus(), requirementRequestDetails.getRequirementRequestId() };
		resultCount = jdbcTemplate.update(UPDATE_REQUIREMENT_REQUEST_DETAILS_STATUS, args);
		if (resultCount > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateRequirementRequestDetailStatusAsSelected(RequirementRequestDetails requirementRequestDetails) {

		Object[] args = { requirementRequestDetails.getStatus(), requirementRequestDetails.getRequirementRequestId() };
		// System.out.println("IN UPDATE RRD");
		resultCount = jdbcTemplate.update(UPDATE_REQUIREMENT_REQUEST_DETAILS_STATUS_AS_SELECTED, args);
		if (resultCount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<RequirementRequestDetails> getAllNewRequirementRequestUsingEmployeeId(int employeeId) {
		Object[] args = { employeeId };
		List<RequirementRequestDetails> allRequirementRequest = jdbcTemplate
				.query(GET_ALL_REQUIREMENTREQUST_USING_EMPLOYEE_ID, requestDetailsRowMapper, args);
		return allRequirementRequest;

	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestAsSelected() {
		// TODO Auto-generated method stub
		List<RequirementRequestDetails> requirementRequestDetails2 = jdbcTemplate
				.query(SELECT_ALL_REQUIREMENT_REQUEST_DETAILS_FOR_SELECTED, requestDetailsRowMapper);
		return requirementRequestDetails2;
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestAsNew() {
		List<RequirementRequestDetails> requirementRequestDetails = jdbcTemplate
				.query(SELECT_ALL_REQUIREMENT_REQUEST_DETAILS_FOR_NEW, requestDetailsRowMapper);
		return requirementRequestDetails;
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestAsInprocess() {
		List<RequirementRequestDetails> requirementRequestDetails = jdbcTemplate
				.query(SELECT_ALL_REQUIREMENT_REQUEST_DETAILS_FOR_INPROCESS, requestDetailsRowMapper);
		return requirementRequestDetails;
	}

}
