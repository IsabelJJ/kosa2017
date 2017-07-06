package com.coderby.myapp.hr.commom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respone, Object handler) throws Exception {
		// TODO Auto-generated method stub
		try{
			HttpSession session = request.getSession();
			String contextName = request.getContextPath();
			String url = request.getRequestURI().replaceFirst(contextName, "");
			String userid = (String) request.getSession().getAttribute("empId");
			String param = request.getQueryString();
			if(userid == null || userid.equals("")){
				respone.sendRedirect(request.getContextPath()+"/login"); // /user/login 컨트롤러를 실행해라
				return false;
			}
			if(!url.contains("/user/login")&& !url.contains("hr/logout")){
				session.setAttribute("url", url);
				session.setAttribute("param", param);
			}else{
				//nothing
				//로그인 또는 로그아웃 uri 일 경우에는 uri 정보를 저장하지 않습니다.
			}		
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return true;
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object handler, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object handler, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	
}
