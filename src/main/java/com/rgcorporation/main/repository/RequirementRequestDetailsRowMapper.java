package com.rgcorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.EmployeeDetails;
import com.rgcorporation.main.model.ProjectDetails;
import com.rgcorporation.main.model.RequirementRequestDetails;

@Component
public class RequirementRequestDetailsRowMapper implements RowMapper<RequirementRequestDetails> {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	@Autowired
	ProjectDetailsRepository projectDetailsRepository;

	@Override
	public RequirementRequestDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		int requirementRequestId = rs.getInt("REQUIREMENT_REQUEST_DETAILS_ID");
		ProjectDetails projectDetails = projectDetailsRepository.getProjectByProjectId(rs.getInt("PROJECT_ID"));
		String skill1 = rs.getString("SKILL1");
		String skill2 = rs.getString("SKILL2");
		String skill3 = rs.getString("SKILL3");
		int experience = rs.getInt("EXPERIENCE");
		int vacancies = rs.getInt("VACANCIES");

		EmployeeDetails employeeDetails = employeeDetailsRepository
				.getEmployeeByEmployeeId(rs.getInt("TEAM_LEADER_ID"));
		String status = rs.getString("STATUS");
		String role = rs.getString("ROLE");

		RequirementRequestDetails requirementRequestDetails = new RequirementRequestDetails(requirementRequestId,
				projectDetails, skill1, skill2, skill3, experience, vacancies, employeeDetails, status, role);
		return requirementRequestDetails;
	}

}
