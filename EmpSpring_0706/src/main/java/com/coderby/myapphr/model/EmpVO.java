package com.coderby.myapphr.model;

import java.sql.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmpVO {

	@Min(value=100, message="사원번호는 100이상이어야 합니다.")
	private int employeeId;
	@Pattern(regexp="[[alpha]A-a-z가-힣]{1,}", message="이름을 입력")
	private String firstName;	
	@Pattern(regexp="[[alpha]A-a-z가-힣]{1,}", message="성을 입력")
	private String lastName;
	@Pattern(regexp="[a-zA-Z0-9]{2,}", message="이메일을 입력")
	private String email;
	@Pattern(regexp="^[0-9]{2,3}.[0-9]{3,4}.[0-9]{4}$", message="전화번호 입력")
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	@DecimalMin(value="0", message="급여는 0보다 작을 수 없음")
	@DecimalMax(value="99999", message="급여는 99999보다 작아야 한다")
	private double salary;
	@Digits(integer=0, fraction=2, message="1보다 같거나 클 수 없다.")
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "EmpVO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId="
				+ departmentId + "]";
	}
	
	
}
