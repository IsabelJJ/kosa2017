package com.coderby.myapp.hr.service;

import java.util.List;
import java.util.Map;

import com.coderby.myapphr.model.EmpVO;

public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptid);
	EmpVO getEmpInfo(int empid);
	List<EmpVO> getEmpList();
	void insertEmp(EmpVO emp);
	void updateEmp(EmpVO emp);
	void deleteEmp(int empid, String email);
	void deleteJobHistory(int empid);
	boolean checkEmail(int empId, String email);
	List<Map<Integer, String>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();

}
