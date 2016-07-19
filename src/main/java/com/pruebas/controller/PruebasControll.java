package com.pruebas.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Scope("session")
public class PruebasControll {

	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String init(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("init", "Hola Init");
		return "pruebas";
	}
	
	@RequestMapping(value = { "/consult" }, method = RequestMethod.GET)
	public ModelAndView consult(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session == null){
			model.setViewName("pruebas");
		}else{
			 model.addObject("att",(String) session.getAttribute("init"));
			 model.setViewName("pruebas");
		}
		return model;
	}
}
