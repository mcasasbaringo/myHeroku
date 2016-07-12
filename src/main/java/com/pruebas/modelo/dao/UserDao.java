package com.pruebas.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.modelo.dto.UserDTO;


@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Función que devuelve toda la información del usuario cuyo name y password coinciden con los parámetros pasados
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	@Transactional
	public UserDTO getUser(String name, String password){

		System.out.println("Inicio getUser - UserDTO");
		Session session = sessionFactory.openSession();
		
		SQLQuery query = session.createSQLQuery("select id, username__c, password__c, name from salesforce.HerokuUser__c where name = '" +name + "'");
		
		List<Object[]> lista = query.list();
		
		List<UserDTO> listaDir = new ArrayList<UserDTO>();
		
		for(int i=0; i<lista.size();i++){

			Object[] ob = lista.get(i);
			UserDTO userAux = new UserDTO();
			
			userAux.setId((Integer) ob[0]);
			userAux.setName((String)ob[1]);
			userAux.setPass((String)ob[2]);
			
			listaDir.add(userAux);
			
		}

		UserDTO  user = new UserDTO();
		if(listaDir.size()>0)
			user = listaDir.get(0);
		session.close();
		
		return user;
	}

	@Transactional
	public void updateUser(){

		System.out.println("Inicio updateUser - UserDTO");
		Session session = sessionFactory.openSession();

		System.out.println("Antes de update");
		
		SQLQuery query = session.createSQLQuery("update salesforce.HerokuUser__c set username__c='userp2123' where id=1");

		System.out.println("query -- " + query);
		int i = query.executeUpdate();
		System.out.println("despues de update");
	    
	    //Commit the transaction
//        session.getTransaction().commit();
        session.close();

        
	}

	
}
