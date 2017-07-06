package com.coderby.myapp;
 
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.hr.service.IEmpService;
 
public class EmpMain {
  public static void main(String[] args) {
    AbstractApplicationContext context =
      new ClassPathXmlApplicationContext("spring/application-config.xml");
    IEmpService empService = context.getBean("empService", IEmpService.class);
     
    System.out.println("-- ����� �� ��ȸ");
    System.out.println(empService.getEmpCount());
    System.out.println(empService.getEmpCount(50));
     
    System.out.println("-- 103�� ����� ������ ��ȸ�մϴ�.");
    System.out.println(empService.getEmpInfo(103));
     
    System.out.println("-- ��� ��ü ������ ��ȸ�մϴ�.");
    System.out.println(empService.getEmpList());
     
    System.out.println("-- ���ο� ��� ������ �Է��մϴ�.");
    EmpVO emp = new EmpVO();
    emp.setEmployeeId(210);
    emp.setFirstName("JinKyoung");
    emp.setLastName("Heo");
    emp.setEmail("HEOJK");
    emp.setPhoneNumber("222-222");
    emp.setJobId("IT_PROG");
    emp.setSalary(8000);
    emp.setCommissionPct(0.2);
    emp.setManagerId(100);
    emp.setDepartmentId(10);
    try {
      empService.insertEmp(emp);
      System.out.println("insert ok");
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
     
    System.out.println("-- �ű� ����� ������ ��ȸ/����մϴ�.");
    EmpVO emp210 = empService.getEmpInfo(210);
    System.out.println(emp210);
     
    System.out.println("-- 210�� ����� �޿��� 10% �λ��ŵ�ϴ�.");
    emp210.setSalary(emp210.getSalary() * 1.1);
     
    System.out.println("-- ������ ����� ��������ȸ/����մϴ�.");
    emp210 = empService.getEmpInfo(210);
    System.out.println(emp210);
     
    System.out.println("-- 210�� ����� ������ �����մϴ�.");
    empService.deleteEmp(210, "HEOJK");
     
    System.out.println("-- ��� �μ���ȣ�� �μ��̸� ������ ����մϴ�.");
    System.out.println(empService.getAllDeptId());
     
    System.out.println("-- ��� �������̵�� ����Ÿ��Ʋ�� ����մϴ�.");
    System.out.println(empService.getAllJobId());
     
    System.out.println("-- ��� �Ŵ�����ȣ�� �Ŵ����̸��� ����մϴ�.");
    System.out.println(empService.getAllManagerId());
  }
}