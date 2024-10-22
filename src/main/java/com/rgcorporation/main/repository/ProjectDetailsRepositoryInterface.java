package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.ProjectDetails;

public interface ProjectDetailsRepositoryInterface {

	public boolean addNewProject(ProjectDetails projectDetails);

	public boolean updateProjectByProjectId(ProjectDetails projectDetails);

	public boolean deleteProjectByProjectId(int projectId);

	public ProjectDetails getProjectByProjectId(int projectId);

	public List<ProjectDetails> getAllProjectsDetails();

	public List<ProjectDetails> getAllProjectsDetailsByProjectId(int projectId);

}
