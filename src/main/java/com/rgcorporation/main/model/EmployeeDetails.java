package com.rgcorporation.main.model;

public class EmployeeDetails {
	private int employeeId;
	private String firstName;
	private String lastName;
	private long contactNumber;
	private String designation;
	private Double salary;
	private String address;
	private String city;
	private String state;
	private int pincode;
	private String skill1;
	private String skill2;
	private String skill3;
	private LoginDetails loginDetails;
	private ProjectDetails projectDetails;

	public EmployeeDetails() {
	}

	public EmployeeDetails(int employeeId, String firstName, String lastName, long contactNumber, String designation,
			Double salary, ProjectDetails projectDetails, String address, String city, String state, int pincode,
			String skill1, String skill2, String skill3, LoginDetails loginDetails) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.designation = designation;
		this.salary = salary;
		this.projectDetails = projectDetails;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.loginDetails = loginDetails;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}

	public String getSkill3() {
		return skill3;
	}

	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", designation=" + designation + ", salary=" + salary
				+ ", projectDetails=" + projectDetails + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", skill1=" + skill1 + ", skill2=" + skill2 + ", skill3=" + skill3
				+ ", loginDetails=" + loginDetails + "]";
	}

}
