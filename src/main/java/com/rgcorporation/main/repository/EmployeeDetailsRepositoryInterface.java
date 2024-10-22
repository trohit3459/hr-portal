package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.EmployeeDetails;

public interface EmployeeDetailsRepositoryInterface {

	public boolean addNewEmployee(EmployeeDetails employeeDetails);

	public boolean updateEmployeeDetailsByEmployeeId(EmployeeDetails employeeDetails);

	public boolean deleteEmployeeByEmployeeId(int employeeId);

	public EmployeeDetails getEmployeeByEmployeeId(int employeeId);

	public List<EmployeeDetails> getAllEmployee();

	public EmployeeDetails getEmployeeByUserId(int userid);

	public EmployeeDetails getProjectDetail(int projectId);

	public List<EmployeeDetails> getAllEmployeeBySkills(EmployeeDetails employeeDetails);

	public boolean updateProjectId(EmployeeDetails employeeDetails);

}
