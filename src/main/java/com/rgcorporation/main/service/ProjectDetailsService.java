package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.ProjectDetails;
import com.rgcorporation.main.repository.ProjectDetailsRepositoryInterface;

@Service
public class ProjectDetailsService implements ProjectDetailsServiceInterface {

	@Autowired
	private ProjectDetailsRepositoryInterface projectDetailsRepository;

	@Override
	public boolean addNewProjectDetails(ProjectDetails projectDetails) {
		// TODO Auto-generated method stub
		return projectDetailsRepository.addNewProject(projectDetails);
	}

	@Override
	public boolean updateProjectDeatilsByProjectId(ProjectDetails projectDetails) {
		// TODO Auto-generated method stub
		return projectDetailsRepository.updateProjectByProjectId(projectDetails);
	}

	@Override
	public boolean deleteProjectDetailsByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return projectDetailsRepository.deleteProjectByProjectId(projectId);
	}

	@Override
	public ProjectDetails getProjectDetailsByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return projectDetailsRepository.getProjectByProjectId(projectId);
	}

	@Override
	public List<ProjectDetails> getAllProjectsDetails() {
		// TODO Auto-generated method stub
		return projectDetailsRepository.getAllProjectsDetails();
	}

	@Override
	public List<ProjectDetails> getAllProjectsDetailsByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return projectDetailsRepository.getAllProjectsDetailsByProjectId(projectId);
	}

}
