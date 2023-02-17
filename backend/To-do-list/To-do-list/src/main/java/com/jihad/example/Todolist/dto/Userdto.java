package com.jihad.example.Todolist.dto;

import java.util.List;

import lombok.Data;

 @Data
public class Userdto {
	private Long user_id;
	private String username;
	private String email;
	private String password;
	private List<Taskdto> tasks;
}
