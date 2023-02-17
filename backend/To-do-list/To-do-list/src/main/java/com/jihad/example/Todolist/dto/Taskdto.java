package com.jihad.example.Todolist.dto;

import lombok.Data;
@Data
public class Taskdto {
	private Long id;
	private String description;
	private String created_date;
	private String status;
}
