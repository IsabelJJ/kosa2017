package com.coderby.myapp.hr;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import com.coderby.myapp.hr.model.Employee;
import com.coderby.myapp.hr.service.IEmpService;



public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context= 
				new ClassPathXmlApplicationContext("application-config.xml");
	IEmpService empService =context.getBean("empService",IEmpService.class);
	System.out.println(empService.getEmpCount());
	System.out.println(empService.getEmpCount(50));
	System.out.println(empService.getEmpCountBySalary(5000));
	System.out.println(empService.getEmpInfoByEmpId(103));
	System.out.println(empService.getList());
	
	Employee emp= new Employee();
	emp.setEmployeeId(300);
	emp.setFirstName("JinKyoung");
	emp.setLastName("Heo");
	emp.setEmail("HEOJK");
	emp.setPhoneNumber("222-222");
	emp.setJobId("IT_PROG");
	emp.setSalary(8000);
	emp.setCommissionPct(0.2);
	emp.setManagerId(100);
	emp.setDepartmentId(10);
	try{
		empService.insertEmp(emp);
		System.out.println("insert ok");
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	}

}
