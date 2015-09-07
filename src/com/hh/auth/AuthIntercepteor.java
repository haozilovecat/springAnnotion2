package com.hh.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthIntercepteor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println(" ------- auth");
		 if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
			 AuthPassport authPassport = ((HandlerMethod)handler).getMethodAnnotation(AuthPassport.class);
			 System.out.println("-----:"+authPassport.name());
			 if(authPassport==null || authPassport.validate()==false){				
				 return true;
			 }else{
				 if(false){
					 System.out.println("----验证成功了aaaaaaa！");
					 return true;
				 }else{
					 System.out.println("----验证失败了！");
					 response.sendRedirect("/SpringAnnotion/loginController/loginPage.do");
				 }
			 }
		 }else{
			 return true;
		 }
		return super.preHandle(request, response, handler);
	}

   
}
