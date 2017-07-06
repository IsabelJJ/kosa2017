package com.coderby.myapp.hr.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.hr.service.IEmpService;

@Controller
public class EmpController {

	@Autowired
	IEmpService empService;
	
	static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	
	@RequestMapping(value={"/hr/count", "/hr/cnt"})
	public String empCount(@RequestParam(value="deptid", required=false, defaultValue="0") int deptid, Model model) {
		if(deptid==0) {
			model.addAttribute("count", empService.getEmpCount());
		}else {
			model.addAttribute("count", empService.getEmpCount(deptid));
		}
		return "hr/count";
	}
	
	@RequestMapping(value={"/hr", "/hr/list"})
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "hr/list";
	}

	
	@RequestMapping(value="/hr/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp", emp);
		return "hr/view";
	}
	
	@RequestMapping(value="/hr/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
		model.addAttribute("emp", new EmpVO());
		model.addAttribute("depts", empService.getAllDeptId());
		model.addAttribute("jobs", empService.getAllJobId());
		model.addAttribute("managers", empService.getAllManagerId());
		return "hr/form";
	}

	@RequestMapping(value="/hr/insert", method=RequestMethod.POST)
	public String insertEmp(@ModelAttribute("emp") @Valid EmpVO emp, 
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {
		if(result.hasErrors()){
			model.addAttribute("depts", empService.getAllDeptId());
			model.addAttribute("jobs", empService.getAllJobId());
			model.addAttribute("managers", empService.getAllManagerId());
			return"hr/form";
		}try{
			empService.insertEmp(emp);
		}catch(RuntimeException e){
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}	
		return "redirect:/hr/list";
	}
	
	@RequestMapping(value="/hr/update", method=RequestMethod.GET)
	public String updateEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("depts", empService.getAllDeptId());
		model.addAttribute("jobs", empService.getAllJobId());
		model.addAttribute("managers", empService.getAllManagerId());
		return "hr/updateform2";
	}

	@RequestMapping(value="/hr/update", method=RequestMethod.POST)
	public String updateEmp(@ModelAttribute("emp") @Valid EmpVO emp, 
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {
		if(result.hasErrors()){
			model.addAttribute("depts", empService.getAllDeptId());
			model.addAttribute("jobs", empService.getAllJobId());
			model.addAttribute("managers", empService.getAllManagerId());
			return"hr/updateform2";
		}try{
			empService.updateEmp(emp);
		}catch(RuntimeException e){
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}	
		return "redirect:/hr/list";

	}
	
	@RequestMapping(value="/hr/delete", method=RequestMethod.GET)
	public String deleteEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		return "hr/deleteform";
	}

	@RequestMapping(value="/hr/delete", method=RequestMethod.POST)
	public String deleteEmp(int empid, String email, Model model) {
		empService.deleteEmp(empid, email);
		return "redirect:/hr";	
			
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
	
}//end class
