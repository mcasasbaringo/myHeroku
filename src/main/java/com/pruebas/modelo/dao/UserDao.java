package com.pruebas.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	 * Funci�n que devuelve toda la informaci�n del usuario cuyo name y password coinciden con los par�metros pasados
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	@Transactional
	public UserDTO getUser(String name, String password){

		System.out.println("Inicio getUser - UserDTO");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		UserDTO miUser = new UserDTO();
	    try{
		    tx = session.beginTransaction();
			Query query = session.createQuery("from UserDTO as user WHERE user.name = :name and user.pass = :pass");
			query.setString("name", name);
			query.setString("pass", password);
			
			List userList = query.list(); 	 
			
			for (Iterator iterator = userList.iterator(); iterator.hasNext();){
				miUser = (UserDTO) iterator.next(); 
				System.out.print("First Name: " + miUser.getName()); 
			}
			tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	      return miUser;
//		SQLQuery query = session.createSQLQuery("select id, username__c, password__c, name from salesforce.herokuuser__c "
//				+ "where username__c = '" +name + "' and password__c ='" + password +"'");
//		
//		List<Object[]> lista = query.list();
//		
//		List<UserDTO> listaDir = new ArrayList<UserDTO>();
//		
//		for(int i=0; i<lista.size();i++){
//
//			Object[] ob = lista.get(i);
//			UserDTO userAux = new UserDTO();
//			
//			userAux.setId((Integer) ob[0]);
//			userAux.setName((String)ob[1]);
//			userAux.setPass((String)ob[2]);
//			
//			listaDir.add(userAux);
//			
//		}
//
//		UserDTO  user = new UserDTO();
//		if(listaDir.size()>0)
//			user = listaDir.get(0);
//		session.close();
//		
//		return user;
	}
	
	@Transactional
	public void createTable(){

		System.out.println("Create table");
		Session session = sessionFactory.openSession();

		System.out.println("Antes de update");
		

		
		SQLQuery query = session.createSQLQuery("CREATE TABLE salesforce.miTabla(col1 character varying(80),createddate timestamp without time zone,"
				+ " col3 character varying(255))");

		System.out.println("query -- " + query);
		query.executeUpdate();
		System.out.println("despues de update");
	    
	    //Commit the transaction
//        session.getTransaction().commit();
        session.close();

        
	}
	

	@Transactional
	public void updateUser(){

		System.out.println("Inicio updateUser - UserDTO");
		Session session = sessionFactory.openSession();

		System.out.println("Antes de update");
		
//		UserDTO user = new UserDTO();
//		user.setId(1);
//		user.setName("userp2");
//		session.update(user);
		
		SQLQuery query = session.createSQLQuery("update salesforce.herokuuser__c set username__c='CambioElUserName' where id=4");

//		System.out.println("query -- " + query);
		int i = query.executeUpdate();
		System.out.println("despues de update");
	    
	    //Commit the transaction
//        session.getTransaction().commit();
        session.close();

        
	}

	@Transactional
	public void insertUser(){

		System.out.println("Inicio updateUser - insertUser");
		Session session = sessionFactory.openSession();

		System.out.println("Antes de update");
		
//		UserDTO user = new UserDTO();
//		user.setId(4);
//		user.setName("userp4");
//		user.setPass("pass4");
//		session.save(user);
		
		SQLQuery query = session.createSQLQuery("INSERT INTO salesforce.HerokuUser__c(name, username__c, password__c,"
				+ " id, email__c) VALUES ('namePruebas', 'userName', 'pass', 4,'email@pruebas.com')");

//		System.out.println("query -- " + query);
//		int i = query.executeUpdate();
		query.executeUpdate();
		System.out.println("despues de update");
	    
	    //Commit the transaction
//        session.getTransaction().commit();
        session.close();
        
	}
	
	
	
}
