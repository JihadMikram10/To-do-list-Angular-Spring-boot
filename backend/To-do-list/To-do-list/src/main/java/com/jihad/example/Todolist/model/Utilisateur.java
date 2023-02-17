package com.jihad.example.Todolist.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name ="User_TB")
@Data
public class Utilisateur implements Serializable  {
	
	private static final long serialVersionUID = 8452935085124283708L;

	@Id
	@GeneratedValue
	@Column(name="USER_Id")
	private Long user_id;

	@Column(name="UserName",nullable = false,length=50,unique=true)
	private String username;
	
	@Column(name="EMAIL_USER",nullable = false,length=120,unique=true)
	private String email;
	
	
	@Column(name="encryptedPassword",nullable = false,unique=true)
	private String encryptedPassword;
	
	  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<Task> tasks;
}
