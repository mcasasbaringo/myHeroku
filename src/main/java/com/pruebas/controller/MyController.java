package com.pruebas.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
//		@RequestMapping(value="/hello", method=RequestMethod.GET)
//		public String printWelcome(ModelMap model){
//			model.addAttribute("message", "Spring 3 MVC Hello World");
//			return "index";
//		}
//		
//		@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//		public ModelAndView hello(@PathVariable("name") String name) {
//
//			ModelAndView model = new ModelAndView();
//			model.setViewName("index");
//			model.addObject("msg", name);
//
//			return model;
//
//		}
		
		@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
		public ModelAndView welcomePage(@PathVariable("username") String username, @PathVariable("password") String password) {

			ModelAndView model = new ModelAndView();
			
			if(username.equals(password)){
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

		@RequestMapping(value = "/admin**", method = RequestMethod.GET)
		public ModelAndView adminPage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Hello World");
			model.addObject("message", "This is protected page!");
			model.setViewName("admin");

			return model;

		}

		
//		@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
//	    public String welcomePage(Model model) {
//	        model.addAttribute("title", "Welcome");
//	        model.addAttribute("message", "This is welcome page!");
//	        return "welcomePage";
//	    }
//		
//		@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	    public String adminPage(Model model) {
//	        return "adminPage";
//	    }
//	 
//	    @RequestMapping(value = "/login", method = RequestMethod.GET)
//	    public String loginPage(Model model ) {
//	         
//	        return "loginPage";
//	    }
//	 
//	    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//	    public String logoutSuccessfulPage(Model model) {
//	        model.addAttribute("title", "Logout");
//	        return "logoutSuccessfulPage";
//	    }
//	 
//	    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//	    public String userInfo(Model model, Principal principal) {
//	 
//	        // After user login successfully.
//	        String userName = principal.getName();
//	 
//	        System.out.println("User Name: "+ userName);
//	 
//	        return "userInfoPage";
//	    }
//	 
//	    @RequestMapping(value = "/403", method = RequestMethod.GET)
//	    public String accessDenied(Model model, Principal principal) {
//	         
//	        if (principal != null) {
//	            model.addAttribute("message", "Hi " + principal.getName()
//	                    + "<br> You do not have permission to access this page!");
//	        } else {
//	            model.addAttribute("msg",
//	                    "You do not have permission to access this page!");
//	        }
//	        return "403Page";
//	    }

}
