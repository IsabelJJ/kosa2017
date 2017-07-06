package com.coderby.myapp.hr.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderby.myapp.hr.service.IEmpService;
import com.coderby.myapphr.model.EmpVO;

@Controller
public class EmpController {
	@Autowired
	IEmpService empService;
	static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	//로그인

	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login(HttpSession session){

		return"emp/loginform";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(@RequestParam("employeeId")int empId, String email ,Model model, HttpSession session){
		try{			
			EmpVO emp = empService.getEmpInfo(empId);
			model.addAttribute("emp", emp);
			if(empService.checkEmail(empId, email)){
				session.setMaxInactiveInterval(300); // 5분 이상 넘어가면 초기화
				session.setAttribute("empId", empId);
				return"redirect:/";
			}
			else{				
				model.addAttribute("message","이메일이 잘 못 됐습니다.");
				session.invalidate();
				return"emp/loginform";			
			}
		}
		catch(Exception e){
			session.invalidate();
			model.addAttribute("message", "아이디어가 없음");
			return"emp/loginform";
		}
	}
	@RequestMapping(value="/logout" , method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return"redirect:/";
	}
	

	// view
	@RequestMapping(value="/{empId}", method=RequestMethod.GET)
	public String getEmpInfo(@PathVariable int empId,Model model){
		model.addAttribute("emp",empService.getEmpInfo(empId));
		EmpVO emp = empService.getEmpInfo(empId);
		model.addAttribute("result2", empService.getEmpCount(emp.getDepartmentId()));
		return "emp/view";
	}
	
	// list
	@RequestMapping("/list")
	public String getEmpList(Model model){	
		model.addAttribute("result", empService.getEmpCount());
		model.addAttribute("empList", empService.getEmpList());
		return "emp/list";		
	}
	/*//ȭ�鿡 ���� ���� job ����Ʈ
	//@ModelAttribute("jobs")
	public List<Map<String, Object>>  getAllJobId(){
		List<Map<String, Object>> jobs =  empService.getAllJobId();
		int index=0;
		for(Map<String, Object> jobs2 : jobs){
			for(Map.Entry<String, Object>entry:jobs2.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				jobs2.put(key,value);
				System.out.println(key + " = " + value);
			}
			index++;
		}
		return jobs;
	}
	 */
	// insert get
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insertEmp(Model model){

		model.addAttribute("jobs",empService.getAllJobId());
		model.addAttribute("managers",empService.getAllManagerId());
		model.addAttribute("depts",empService.getAllDeptId());
		return "emp/insertform";
	}
	
	//insert post
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insertEmp(EmpVO emp, Model model){
		System.out.println(emp);
		try{
			empService.insertEmp(emp);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "emp/error"; // ${message}
		}
		return "redirect:/";//��
	}
	
	 //update get
	   @RequestMapping(value="/update/{empId}" , method = RequestMethod.GET)
	   public String updateEmp(@PathVariable int empId,Model model){
	      model.addAttribute("emp", empService.getEmpInfo(empId));
	      model.addAttribute("depts", empService.getAllDeptId());
	      model.addAttribute("jobs", empService.getAllJobId());
	      model.addAttribute("managers", empService.getAllManagerId());
	      return "emp/updateform";
	   }

	   //update post
	   @RequestMapping(value="/update/{empId}", method = RequestMethod.POST)
	   public String updateEmp(@RequestParam("employeeId") int empId,@ModelAttribute("emp") @Valid EmpVO emp, 
	         BindingResult result, RedirectAttributes redirectAttrs, Model model){         
	      if(result.hasErrors()){
	         model.addAttribute("depts", empService.getAllDeptId());
	         model.addAttribute("jobs", empService.getAllJobId());
	         model.addAttribute("managers", empService.getAllManagerId());
	         return"emp/updateform";
	      }try{
	         empService.updateEmp(emp);
	      }catch(RuntimeException e){
	         redirectAttrs.addFlashAttribute("message", e.getMessage());
	         return"emp/updateform";
	      }   
	      return "redirect:/list";               
	   }   


	//delete get
	@RequestMapping(value="/delete/{empId}",method = RequestMethod.GET)
	public String deleteEmp(@PathVariable int empId,Model model){
		model.addAttribute("emp", empService.getEmpInfo(empId));	
		return "emp/deleteform";
	}

	//delete post
	@RequestMapping(value="/delete/{empId}", method = RequestMethod.POST)
	public String deleteEmp(@RequestParam("employeeId") int empId , @RequestParam("email")String empEmail){			
		// @RequestParam�� ����Ͽ� get���� ���� ���̵�� �̸����� ������ ������ �Ѵ�.
		EmpVO emp = empService.getEmpInfo(empId);
		
		if(empEmail.equals(emp.getEmail())) {
			empService.deleteEmp(empId, empEmail);
			return "redirect:/list";	
		}
		else{
			return "redirect:/delete/"+empId;
		}
			
	}
	@ExceptionHandler({SQLException.class, DataAccessException.class})
	public ModelAndView databaseError(HttpServletRequest request, Exception ex){
		logger.error("request:" + request.getRequestURL()+" raised"+ex);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName("hr/error");
		return mav;
	}
	
	

}
