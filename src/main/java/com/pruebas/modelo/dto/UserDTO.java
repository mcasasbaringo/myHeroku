package com.pruebas.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salesforce.user")
public class UserDTO {

	/** Cadena que representa la contraseña del usuario */
	@Column(name = "username__c")
	private String name;
	/** Cadena que representa el nombre del usuario */
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "password__c")
	private String pass;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
