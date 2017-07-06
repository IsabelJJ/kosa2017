package com.coderby.myapp.hr.dao;

import java.util.List;
import java.util.Map;

import com.coderby.myapphr.model.EmpVO;

public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(int deptid);
	EmpVO getEmpInfo(int empid);
	List<EmpVO> getEmpList();
	void insertEmp(EmpVO emp);
	void updateEmp(EmpVO emp);
	void deleteEmp(int empid, String email);
	void deleteJobHistory(int empid);
	String getEmail(int empId); 
	List<Map<Integer, String>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}
