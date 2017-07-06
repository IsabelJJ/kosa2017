package com.coderby.myapp.hr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderby.myapp.hr.dao.IEmpRepository;
import com.coderby.myapp.hr.model.EmpVO;

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
	public EmpVO getEmpInfo(int empid) {
		// TODO Auto-generated method stub
		return empRepository.getEmpInfo(empid);
	}

	@Override
	public List<EmpVO> getEmpList() {
		// TODO Auto-generated method stub
		return empRepository.getEmpList();
	}

	@Override
	public void insertEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		empRepository.insertEmp(emp);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		empRepository.updateEmp(emp);
	}

	@Override
	public void deleteEmp(int empid, String email) {
		// TODO Auto-generated method stub
		empRepository.deleteEmp(empid, email);
	}

	@Override
	public void deleteJobHistory(int empid) {
		// TODO Auto-generated method stub
		empRepository.deleteJobHistory(empid);
	}

	@Override
	public List<Map<Integer, String>> getAllDeptId() {
		// TODO Auto-generated method stub
		return empRepository.getAllDeptId();
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		// TODO Auto-generated method stub
		return empRepository.getAllJobId();
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		// TODO Auto-generated method stub
		return empRepository.getAllManagerId();
	}
	@Override
	public boolean checkEmail(int empId, String email) {
		// TODO Auto-generated method stub
		String dbpw = empRepository.getEmail(empId);
		if(email.equals(dbpw) && dbpw != null){
			return true;
		}
		else {
			return false;
		}
	}

}
