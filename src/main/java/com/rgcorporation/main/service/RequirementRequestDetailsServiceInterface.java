package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.RequirementRequestDetails;

public interface RequirementRequestDetailsServiceInterface {

	public boolean addNewRequirementRequest(RequirementRequestDetails requirementRequestDetails);

	public boolean updateRequirementRequestByRequirementRequestId(RequirementRequestDetails requirementRequestDetails);

	public boolean deleteRequirementRequestByRequirementRequestId(int requirementRequestId);

	public RequirementRequestDetails getRequirementRequestByRequirementRequestId(int requirementRequestId);

	public List<RequirementRequestDetails> hrportaldb();

	public List<RequirementRequestDetails> getAllRequirementRequestUsingProjectId(int projectId);

	public List<RequirementRequestDetails> getAllRequirementRequest();

	public int getRequiredNoOfVacanciesByRequestId(int requestId);

	public boolean updateRequirementRequestDetailStatus(RequirementRequestDetails requirementRequestDetails);

	public boolean updateRequirementRequestDetailStatusAsSelected(RequirementRequestDetails requirementRequestDetails);

	public List<RequirementRequestDetails> getAllRequirementRequestAsSelected();

	public List<RequirementRequestDetails> getAllNewRequirementRequestUsingEmployeeId(int employeeId);

	public List<RequirementRequestDetails> getAllRequirementRequestAsNew();

	public List<RequirementRequestDetails> getAllRequirementRequestAsInprocess();

}
