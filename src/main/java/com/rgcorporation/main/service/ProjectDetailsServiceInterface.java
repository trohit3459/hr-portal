package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.ProjectDetails;

public interface ProjectDetailsServiceInterface {

	public boolean addNewProjectDetails(ProjectDetails projectDetails);

	public boolean updateProjectDeatilsByProjectId(ProjectDetails projectDetails);

	public boolean deleteProjectDetailsByProjectId(int projectId);

	public ProjectDetails getProjectDetailsByProjectId(int projectId);

	public List<ProjectDetails> getAllProjectsDetails();

	public List<ProjectDetails> getAllProjectsDetailsByProjectId(int projectId);
}
