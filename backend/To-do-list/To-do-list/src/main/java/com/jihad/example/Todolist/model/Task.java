package com.jihad.example.Todolist.model;

import java.io.Serializable;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name ="Task_TB")
@Entity
public class Task   implements Serializable{
	private static final long serialVersionUID = 6470090944414208496L;
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="Description",nullable = false)
	private String description;
	
	@Column(name="Created_Date",nullable = false)
	private String created_date;
	
	@Column(name="Status",nullable = false)
	private String status;
	
	   @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "email",referencedColumnName = "EMAIL_USER")
	   private Utilisateur user;
	

}
