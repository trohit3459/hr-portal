package com.rgcorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rgcorporation.main.model.ProjectDetails;

@Repository
public class ProjectDetailsRepository implements ProjectDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_PROJECT_DETAILS = "INSERT INTO PROJECT_DETAILS(PROJECT_NAME,START_DATE,END_DATE) VALUES(?,?,?)";
	private static final String SELECT_ALL_PROJECT_DETAILS = "SELECT * FROM PROJECT_DETAILS";
	private static final String SELECT_SINGLE_PROJECT_DETAILS = "SELECT * FROM PROJECT_DETAILS WHERE PROJECT_ID = ?";
	private static final String UPDATE_PROJECT_DETAILS = "UPDATE PROJECT_DETAILS SET PROJECT_NAME = ?, START_DATE = ?, END_DATE=?"
			+ "	WHERE PROJECT_ID = ?";
	private static final String DELETE_PROJECT_DETAILS = "DELETE PROJECT_DETAILS WHERE PROJECT_ID = ?";
	private static final String GET_ALL_PROJECT_DETAILS_BY_PROJECT_ID = "SELECT * FROM PROJECT_DETAILS WHERE PROJECT_ID = ?";

	int resultCount;

	@Override
	public boolean addNewProject(ProjectDetails projectDetails) {

//		System.out.println("inserting new project into database");
//		System.out.println(projectDetails);

		Object[] args = { projectDetails.getProjectName(), projectDetails.getStartDate(), projectDetails.getEndDate() };

		resultCount = jdbcTemplate.update(INSERT_PROJECT_DETAILS, args);

		if (resultCount > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean updateProjectByProjectId(ProjectDetails projectDetails) {
		Object[] args = { projectDetails.getProjectName(), projectDetails.getStartDate(), projectDetails.getEndDate(),
				projectDetails.getProjectId() };
		resultCount = jdbcTemplate.update(UPDATE_PROJECT_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteProjectByProjectId(int projectId) {

		Object[] args = { projectId };
		resultCount = jdbcTemplate.update(DELETE_PROJECT_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public ProjectDetails getProjectByProjectId(int projectId) {

		Object[] args = { projectId };
		ProjectDetails projectDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_PROJECT_DETAILS, args,
				new ProjectDetailsRowMapper());
		return projectDetails;
	}

	@Override
	public List<ProjectDetails> getAllProjectsDetails() {
		List<ProjectDetails> allProjectDetails = jdbcTemplate.query(SELECT_ALL_PROJECT_DETAILS,
				new ProjectDetailsRowMapper());
		return allProjectDetails;
	}

	@Override
	public List<ProjectDetails> getAllProjectsDetailsByProjectId(int projectId) {
		Object[] args = { projectId };
		List<ProjectDetails> allProjectDetails = jdbcTemplate.query(GET_ALL_PROJECT_DETAILS_BY_PROJECT_ID,
				new ProjectDetailsRowMapper(), args);
		return allProjectDetails;
	}

}
