package com.coderby.myapp.hr.dao;

import java.util.List;

import com.coderby.myapp.hr.model.Employee;

public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(int depid);
	int getEmpCountBySalary(int salary);
	
	List<Employee> getEmplist();
	Employee getEmpInfoByEmpId(int empid);
	
	void setSalaryByEmpId(int empid);
	
	void insertEmp(Employee emp);
	void deleteEmp(int empid);
	
}
