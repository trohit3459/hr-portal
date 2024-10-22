package com.rgcorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rgcorporation.main.model.EmployeeDetails;

@Repository
public class EmployeeDetailsRepository implements EmployeeDetailsRepositoryInterface{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeDetailsRowMapper employeeDetailsRowMapper;
	
	private static final String INSERT_EMPLOYEE_DETAILS = "INSERT INTO EMPLOYEE_DETAILS(FIRST_NAME, LAST_NAME,DESIGNATION, SALARY, PROJECT_ID ,ADDRESS, CITY ,STATE, PINCODE ,USER_ID ,CONTACT_NO ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_EMPLOYEE_DETAILS = "SELECT * FROM EMPLOYEE_DETAILS";
	private static final String SELECT_SINGLE_EMPLOYEE_DETAILS = "SELECT * FROM EMPLOYEE_DETAILS WHERE EMPLOYEE_ID = ?";
	private static final String UPDATE_EMPLOYEE_DETAILS = "UPDATE EMPLOYEE_DETAILS SET FIRST_NAME = ?, LAST_NAME = ?, CONTACT_NO = ? ,DESIGNATION = ?, SALARY = ?, PROJECT_ID = ?, ADDRESS = ? ,CITY= ? ,STATE = ? ,PINCODE = ?, USER_ID =? ,CONTACT_NO "
			+ "	WHERE EMPLOYEE_ID = ?";
	private static final String DELETE_EMPLOYEE_DETAILS = "DELETE EMPLOYEE_DETAILS WHERE EMPLOYEE_ID = ?";

	 int resultCount;

	
	@Override
	public boolean addNewEmployee(EmployeeDetails employeeDetails) {
//		System.out.println("inserting new employee into database");
//		System.out.println(employeeDetails);

		Object[] args = { employeeDetails.getFirstName(), employeeDetails.getLastName(), employeeDetails.getContactNumber(), employeeDetails.getDesignation(), employeeDetails.getSalary(), employeeDetails.getProjectDetails(), employeeDetails.getAddress(), employeeDetails.getCity(),employeeDetails.getState(), employeeDetails.getPincode(), employeeDetails.getLoginDetails()};

		resultCount = jdbcTemplate.update(INSERT_EMPLOYEE_DETAILS, args);

		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateEmployeeDetailsByEmployeeId(EmployeeDetails employeeDetails) {
		Object[] args = { employeeDetails.getFirstName(), employeeDetails.getLastName(), employeeDetails.getContactNumber(), employeeDetails.getDesignation(), employeeDetails.getSalary(), employeeDetails.getProjectDetails(), employeeDetails.getAddress(), employeeDetails.getCity(),employeeDetails.getState(), employeeDetails.getPincode(), employeeDetails.getLoginDetails(), employeeDetails.getEmployeeId() };
		resultCount = jdbcTemplate.update(UPDATE_EMPLOYEE_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		Object[] args = { employeeId };
		resultCount = jdbcTemplate.update(DELETE_EMPLOYEE_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public EmployeeDetails getEmployeeByEmployeeId(int employeeId) {
		Object[] args = { employeeId };
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_EMPLOYEE_DETAILS, employeeDetailsRowMapper,args);
		return employeeDetails;
	}

	@Override
	public List<EmployeeDetails> getAllEmployee() {
		List<EmployeeDetails> allEmployeeDetails = jdbcTemplate.query(SELECT_ALL_EMPLOYEE_DETAILS,employeeDetailsRowMapper);
		return allEmployeeDetails;
	}

	private static final String SELECT_SINGLE_EMPLOYEE_DETAILS_BY_USERID = "SELECT * FROM EMPLOYEE_DETAILS WHERE USER_ID = ?";

	@Override
	public EmployeeDetails getEmployeeByUserId(int userid) {
		// TODO Auto-generated method stub
		//System.out.println(userid);
		Object[] args = {userid};
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_EMPLOYEE_DETAILS_BY_USERID, employeeDetailsRowMapper,args);
		return employeeDetails;
	}

	private static final String GET_PROJECT_BY_PROJECT_ID = "SELECT * FROM EMPLOYEE_DETAILS WHERE PROJECT_ID = ?";

	@Override
	public EmployeeDetails getProjectDetail(int projectId) {
		// TODO Auto-generated method stub
		Object[] args= {projectId};
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(GET_PROJECT_BY_PROJECT_ID, employeeDetailsRowMapper,args);

		return  employeeDetails;
	}

	
	private static final String Get_ALL_BY_SKILLS_AND_PROJECTID ="SELECT * FROM EMPLOYEE_DETAILS WHERE SKILL1=? AND SKILL2 =? AND SKILL3=? AND PROJECT_ID =1";
	@Override
	public List<EmployeeDetails> getAllEmployeeBySkills(EmployeeDetails employeeDetails) {
		
		Object[] args = {employeeDetails.getSkill1(),employeeDetails.getSkill2(),employeeDetails.getSkill3()};
		// TODO Auto-generated method stub
		List<EmployeeDetails> allEmployeeDetails = jdbcTemplate.query(Get_ALL_BY_SKILLS_AND_PROJECTID,employeeDetailsRowMapper,args);
		return allEmployeeDetails;
	}

	private static final String UPDATE_EMPLOYEE_DETAILS_PROJECT_ID = "UPDATE EMPLOYEE_DETAILS SET PROJECT_ID = ? WHERE EMPLOYEE_ID = ?";
	@Override
	public boolean updateProjectId(EmployeeDetails employeeDetails) {
		//System.out.println("In Employee Reposi");
		Object [] args = {employeeDetails.getProjectDetails().getProjectId(),employeeDetails.getEmployeeId()};
		//System.out.println("In Employee Repo 2");
		resultCount = jdbcTemplate.update(UPDATE_EMPLOYEE_DETAILS_PROJECT_ID, args);
	
		if (resultCount > 0)
			return true;
		else
			return false;
	}
	}

	

