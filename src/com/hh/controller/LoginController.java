package com.hh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hh.auth.AuthPassport;
/**
 * 登录拦截
 * @author Administrator
 *
 */
@Controller
@RequestMapping("loginController")
public class LoginController {
	@AuthPassport(validate=false,name="hahahah")
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		System.out.println("----------- i an in");
		ModelAndView modelAndView = new ModelAndView("/main");
		return modelAndView;
	}
	
	@RequestMapping("loginPage")
	public ModelAndView loginPge(HttpServletRequest request,HttpServletResponse response){
		System.out.println("----------- i an loginPge");
		ModelAndView modelAndView = new ModelAndView("/login");
		return modelAndView;
	}
}
