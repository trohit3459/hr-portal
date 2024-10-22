package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.RequirementRequestDetails;
import com.rgcorporation.main.repository.RequirementRequestDetailsRepositoryInterface;

@Service
public class RequirementRequestDetailsService implements RequirementRequestDetailsServiceInterface {

	@Autowired
	private RequirementRequestDetailsRepositoryInterface requirementRequestDetailsRepositoryInterface;

	@Override
	public boolean addNewRequirementRequest(RequirementRequestDetails requirementRequestDetails) {
		return requirementRequestDetailsRepositoryInterface.addNewRequirementRequest(requirementRequestDetails);
	}

	@Override
	public boolean updateRequirementRequestByRequirementRequestId(RequirementRequestDetails requirementRequestDetails) {
		return requirementRequestDetailsRepositoryInterface
				.updateRequirementRequestByRequirementRequestId(requirementRequestDetails);
	}

	@Override
	public boolean deleteRequirementRequestByRequirementRequestId(int requirementRequestId) {
		return requirementRequestDetailsRepositoryInterface
				.deleteRequirementRequestByRequirementRequestId(requirementRequestId);
	}

	@Override
	public RequirementRequestDetails getRequirementRequestByRequirementRequestId(int requirementRequestId) {
		return requirementRequestDetailsRepositoryInterface
				.getRequirementRequestByRequirementRequestId(requirementRequestId);
	}

	public List<RequirementRequestDetails> getAllRequirementRequest() {
		return requirementRequestDetailsRepositoryInterface.getAllRequirementRequest();
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestUsingProjectId(int projectId) {
		return requirementRequestDetailsRepositoryInterface.getAllRequirementRequestUsingProjectId(projectId);
	}

	@Override
	public List<RequirementRequestDetails> hrportaldb() {
		return null;
	}

	@Override
	public int getRequiredNoOfVacanciesByRequestId(int requestId) {
		// TODO Auto-generated method stub
		return requirementRequestDetailsRepositoryInterface.getRequiredNoOfVacanciesByRequestId(requestId);
	}

	@Override
	public boolean updateRequirementRequestDetailStatus(RequirementRequestDetails requirementRequestDetails) {
		// TODO Auto-generated method stub
		return requirementRequestDetailsRepositoryInterface
				.updateRequirementRequestDetailStatus(requirementRequestDetails);
	}

	@Override
	public boolean updateRequirementRequestDetailStatusAsSelected(RequirementRequestDetails requirementRequestDetails) {
		// TODO Auto-generated method stub
		return requirementRequestDetailsRepositoryInterface
				.updateRequirementRequestDetailStatusAsSelected(requirementRequestDetails);
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestAsSelected() {
		// TODO Auto-generated method stub
		return requirementRequestDetailsRepositoryInterface.getAllRequirementRequestAsSelected();
	}

	@Override
	public List<RequirementRequestDetails> getAllNewRequirementRequestUsingEmployeeId(int employeeId) {
		return requirementRequestDetailsRepositoryInterface.getAllNewRequirementRequestUsingEmployeeId(employeeId);
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestAsNew() {
		// TODO Auto-generated method stub
		return requirementRequestDetailsRepositoryInterface.getAllRequirementRequestAsNew();
	}

	@Override
	public List<RequirementRequestDetails> getAllRequirementRequestAsInprocess() {
		// TODO Auto-generated method stub
		return requirementRequestDetailsRepositoryInterface.getAllRequirementRequestAsInprocess();
	}

}
