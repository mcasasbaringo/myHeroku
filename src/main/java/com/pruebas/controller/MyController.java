package com.pruebas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pruebas.modelo.dao.UserDao;
import com.pruebas.modelo.dto.UserDTO;
import com.pruebas.service.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService userService;

		@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
		public ModelAndView welcomePage(@RequestParam("username") String username, @RequestParam("password") String password) {

			System.out.println("Inicio welcomePage, user: " +username +" password: " + password);
			ModelAndView model = new ModelAndView();

			
			boolean isUser = userService.isUser(username, password);
			if(isUser){
				model.addObject("title", "Heroku Hello World");
				model.addObject("name", username);
				model.setViewName("hello");
			}else{
				model.addObject("title", "Heroku No User");
				model.addObject("name", username);
				model.setViewName("error");
			}
		
			return model;

		}

		@RequestMapping(value={"/"}, method = RequestMethod.GET)
		public ModelAndView goInicio(HttpServletRequest request, HttpServletResponse response) {
			
			ModelAndView model = new ModelAndView();
			model.setViewName("loginNoSec");
			return model;
			
		}
}
