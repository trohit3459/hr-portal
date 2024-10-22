package com.rgcorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.EmployeeDetails;
import com.rgcorporation.main.model.LoginDetails;
import com.rgcorporation.main.model.ProjectDetails;

@Component
public class EmployeeDetailsRowMapper implements RowMapper<EmployeeDetails> {

	@Autowired
	ProjectDetailsRepository projectDetailsRepository;

	@Autowired
	LoginDetailsRepository loginDetailsRepository;

	@Override
	public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		int employeeId = rs.getInt("EMPLOYEE_ID");
		String firstName = rs.getString("FIRST_NAME");
		String lastName = rs.getString("LAST_NAME");
		String designation = rs.getString("DESIGNATION");
		long contactNumber = rs.getLong("CONTACT_NO");

		Double salary = rs.getDouble("SALARY");
		ProjectDetails projectDetails = projectDetailsRepository.getProjectByProjectId(rs.getInt("PROJECT_ID"));
		String address = rs.getString("ADDRESS");
		String city = rs.getString("CITY");
		String state = rs.getString("STATE");
		int pincode = rs.getInt("PINCODE");
		String skill1 = rs.getString("SKILL1");
		String skill2 = rs.getString("SKILL2");
		String skill3 = rs.getString("SKILL3");
		LoginDetails loginDetails = loginDetailsRepository.getLoginDetailsByLoginId(rs.getInt("USER_ID"));

		EmployeeDetails employeeDetails = new EmployeeDetails(employeeId, firstName, lastName, contactNumber,
				designation, salary, projectDetails, address, city, state, pincode, skill1, skill2, skill3,
				loginDetails);
		return employeeDetails;

	}

}
