package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.EmployeeDetails;
import com.rgcorporation.main.model.RequirementRequestDetails;
import com.rgcorporation.main.repository.EmployeeDetailsRepositoryInterface;
import com.rgcorporation.main.repository.RequirementRequestDetailsRepository;

@Service
public class EmployeeDetailsService implements EmployeeDetailsServiceInterface {

	@Autowired
	private EmployeeDetailsRepositoryInterface employeeDetailsRepository;
	@Autowired
	private RequirementRequestDetailsRepository requirementRequestDetailsRepository;

	@Override
	public boolean addNewEmployee(EmployeeDetails employeeDetails) {

		return employeeDetailsRepository.addNewEmployee(employeeDetails);
	}

	@Override
	public boolean updateEmployeeDetailsByEmployeeId(EmployeeDetails employeeDetails) {
		return employeeDetailsRepository.updateEmployeeDetailsByEmployeeId(employeeDetails);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		return employeeDetailsRepository.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public EmployeeDetails getEmployeeByEmployeeId(int employeeId) {
		return employeeDetailsRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployee() {
		return employeeDetailsRepository.getAllEmployee();
	}

	@Override
	public EmployeeDetails getEmployeeByUserId(int userId) {
		return employeeDetailsRepository.getEmployeeByUserId(userId);
	}

	@Override
	public EmployeeDetails getProjectDetail(int projectId) {
		return employeeDetailsRepository.getProjectDetail(projectId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeBySkills(EmployeeDetails employeeDetails) {
		return employeeDetailsRepository.getAllEmployeeBySkills(employeeDetails);
	}

	@Override
	public boolean updateProjectId(EmployeeDetails employeeDetails) {
		System.out.println("In employee service");
		boolean result = employeeDetailsRepository.updateProjectId(employeeDetails);
		int requestId = employeeDetails.getPincode();
		int requiredEmployee = requirementRequestDetailsRepository.getRequiredNoOfVacanciesByRequestId(requestId);
		requiredEmployee = requiredEmployee - 1;
		RequirementRequestDetails requirementRequestDetails = requirementRequestDetailsRepository
				.getRequirementRequestByRequirementRequestId(requestId);
		requirementRequestDetails.setVacancies(requiredEmployee);
		boolean updateRequiredNoOfVacancies = requirementRequestDetailsRepository
				.updateRequirementRequestByRequirementRequestId(requirementRequestDetails);
		if (result && updateRequiredNoOfVacancies) {
			return result;

		}
		return false;
	}

}
