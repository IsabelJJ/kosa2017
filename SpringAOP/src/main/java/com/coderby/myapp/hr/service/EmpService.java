package com.coderby.myapp.hr.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderby.myapp.hr.dao.IEmpRepository;
import com.coderby.myapp.hr.model.Employee;
@Service
public class EmpService implements IEmpService {
	@Autowired
	IEmpRepository empRepository;
	
	@Override
	public int getEmpCount() {
		// TODO Auto-generated method stub
		return empRepository.getEmpCount();
	}

	@Override
	public int getEmpCount(int deptid) {
		// TODO Auto-generated method stub
		return empRepository.getEmpCount(deptid);
	}

	@Override
	public int getEmpCountBySalary(int salary) {
		// TODO Auto-generated method stub
		return empRepository.getEmpCountBySalary(salary);
	}

	@Override
	public List<Employee> getList() {
		// TODO Auto-generated method stub
		return empRepository.getEmplist();
	}

	@Override
	public Employee getEmpInfoByEmpId(int empid) {
		// TODO Auto-generated method stub
		return empRepository.getEmpInfoByEmpId(empid);
	}

	@Override
	public void setSalaryByEmpId(int empid) {
		empRepository.setSalaryByEmpId(empid);

	}

	@Override
	public void insertEmp(Employee emp) {
		// TODO Auto-generated method stub
		empRepository.insertEmp(emp);
	}

	@Override
	public void deleteEmp(int empid) {
		// TODO Auto-generated method stub
		empRepository.deleteEmp(empid);
	}}

