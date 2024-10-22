package com.rgcorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.rgcorporation.main.model.ProjectDetails;

public class ProjectDetailsRowMapper implements RowMapper<ProjectDetails> {

	@Override
	public ProjectDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		int projectId = rs.getInt("PROJECT_ID");
		String projectName = rs.getString("PROJECT_NAME");
		LocalDate startDate = rs.getDate("START_DATE").toLocalDate();
		LocalDate endDate = rs.getDate("END_DATE").toLocalDate();

		ProjectDetails projectDetails = new ProjectDetails(projectId, projectName, startDate, endDate);
		return projectDetails;
	}

}
