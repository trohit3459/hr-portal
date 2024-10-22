package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.ProjectDetails;
import com.rgcorporation.main.service.ProjectDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("projectdetails")
public class ProjectDetailsController {
    @Autowired
	private ProjectDetailsServiceInterface projectDetailsServiceInterface; 
	 
	@RequestMapping(value = "projectdetail" , method = RequestMethod.GET)
	public List<ProjectDetails> getAllDocumentDetails(){
		return projectDetailsServiceInterface.getAllProjectsDetails();
	}
	
//	@RequestMapping(value = "projectdetail/{projectId}" , method = RequestMethod.GET)
//	public ProjectDetails getDetails(@PathVariable int projectId) {
//		return projectDetailsServiceInterface.getProjectDetailsByProjectId(projectId);
//	}
	
	@RequestMapping(value = "projectdetailbyprojectid/{projectid}" , method = RequestMethod.GET)
	public List<ProjectDetails> getAllProjectsDetailsByProjectId(@PathVariable int projectid) {
		return projectDetailsServiceInterface.getAllProjectsDetailsByProjectId(projectid);
	}
}
