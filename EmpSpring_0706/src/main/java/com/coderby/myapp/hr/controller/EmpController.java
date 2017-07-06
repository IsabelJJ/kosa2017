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
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.hr.service.IEmpService;
import com.coderby.myapp.user.model.UserVO;
import com.coderby.myapp.user.service.IUserService;

@Controller
public class EmpController {

	@Autowired
	IEmpService empService;	
	@Autowired
	IUserService userService;
	static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	/*
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

*/
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
		model.addAttribute("emp", new EmpVO());
		model.addAttribute("jobs",empService.getAllJobId());
		model.addAttribute("managers",empService.getAllManagerId());
		model.addAttribute("depts",empService.getAllDeptId());
		return "emp/insertform";
	}
	
	//insert post
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insertEmp(@RequestParam("employeeId") int empId,@ModelAttribute("emp") @Valid EmpVO emp, 
	         BindingResult result, RedirectAttributes redirectAttrs, Model model){
		   if(result.hasErrors()){
		         model.addAttribute("depts", empService.getAllDeptId());
		         model.addAttribute("jobs", empService.getAllJobId());
		         model.addAttribute("managers", empService.getAllManagerId());
		         return"emp/insertform";
		      }try{
		         empService.updateEmp(emp);
		      }catch(RuntimeException e){
		         redirectAttrs.addFlashAttribute("message", e.getMessage());
		         return"emp/insertform";
		      }   
		      return "redirect:/list";  
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
	//-----------------------------------------------------------------------
	public Map<String, String> getRole(){
		Map<String, String> role = new HashMap<String, String>();
		role.put("1", "관리자");
		role.put("2", "사용자");
		return role;
	}

	@RequestMapping(value="/insertUser", method = RequestMethod.GET)
	public String insertUser(Model model){
		model.addAttribute("role", getRole());
		logger.info("insertUser");
		return "user/insertform";
	}
	@RequestMapping(value="/insertUser", method = RequestMethod.POST)
	public String insertUser(UserVO user){
		userService.insertUser(user);
		return "redirect:/";
	}

	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login(HttpSession session){

		return"user/loginform";
	}
	@RequestMapping(value="/after" , method=RequestMethod.GET)
	public String after(){

		return"user/afterform";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(String userId, String userPassword,Model model, HttpSession session){
		try{
			if(userService.checkPassword(userId, userPassword)){
				session.setMaxInactiveInterval(300); // 5분 이상 넘어가면 초기화
				session.setAttribute("userId", userId);
				return"redirect:/";
			}
			else{
				model.addAttribute("message","아이티 또는 비밀 번호가 잘 못 됐습니다.");
				session.invalidate();
				return"user/loginform";
			}
		}
		catch(Exception e){
			session.invalidate();
			model.addAttribute("message", e.getMessage());
			return"user/loginform";
		}
	}
	@RequestMapping(value="/logout" , method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return"redirect:/";
	}

	//삭제  o
	@RequestMapping(value="/deleteUser", method = RequestMethod.GET)
	public String deleteUser(HttpSession session,Model model){
		String userId=(String)session.getAttribute("userId");
		model.addAttribute("user", userService.selectUser(userId));
		return "user/deleteform";
	}

	@RequestMapping(value="/deleteUser", method = RequestMethod.POST)
	public String deleteUser(String userPassword,Model model,HttpSession session){

		String userId = (String)session.getAttribute("userId");
		if(userId==null||userId.equals("")){
			model.addAttribute("message","로그인 사용자가 아닙니다");
			session.invalidate();
			return "user/loginform";
		}else{
			if(userService.checkPassword(userId, userPassword)){
				userService.deleteUser(userId, userPassword);
				session.invalidate();
				return "redirect:/";
			}
			else{
				model.addAttribute("message",": 비밀번호가 다릅니다.");
				return "redirect:/deleteform";
			}

		}
	}

	//조회 o
	@RequestMapping(value="/viewUser", method=RequestMethod.GET)
	public String getUser(HttpSession session, Model model){
		String userId=(String)session.getAttribute("userId");
		if(userId==null||userId.equals("")){
			model.addAttribute("message","로그인 사용자가 아닙니다");
			return "user/loginform";
		}
		else{
			model.addAttribute("user", userService.selectUser(userId));
			return "user/viewUser";
		}
	}

	
	// 수정	
	@RequestMapping(value="/updateUser", method= RequestMethod.GET)
	public String updateUser(HttpSession session,Model model){
		String userId=(String)session.getAttribute("userId");
		model.addAttribute("role", getRole());
		if(userId==null||userId.equals("")){
			model.addAttribute("message","로그인 사용자가 아닙니다");
			return "user/loginform";
		}
		else{
			model.addAttribute("user", userService.selectUser(userId));
			return "user/updateform";
		}

	}
	@RequestMapping(value="/updateUser", method= RequestMethod.POST)
	public String updateUser(UserVO user,HttpSession session ,Model model){
		String userId=(String)session.getAttribute("userId");
		model.addAttribute("role", getRole());
		if(userId==null||userId.equals("")){
			model.addAttribute("message","로그인 사용자가 아닙니다");
			return "user/loginform";
		}
		else{
			userService.updateUser(user);
			return "redirect:/viewUser";
		}
	}


	@RequestMapping("/listUser")
	public String getUserList(Model model){
		List<UserVO> users = userService.seletAllUser();		
		model.addAttribute("users", users);
		return "user/list";
	}

}
