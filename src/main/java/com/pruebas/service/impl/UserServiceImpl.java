package com.pruebas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebas.modelo.dao.UserDao;
import com.pruebas.modelo.dto.UserDTO;
import com.pruebas.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean isUser(String name, String password) {

		System.out.println("Inicio isUser - UserService");
		

//		userDao.updateUser();
//		userDao.insertUser();
		
		UserDTO userDto = new UserDTO();
		userDto = userDao.getUser(name, password);
		System.out.println("Usuario recuperado, user: " + userDto.getName());
		
		if("".equals(userDto.getName()) || userDto.getName() == null)
			return false;
		else
			return true;
	}

}
