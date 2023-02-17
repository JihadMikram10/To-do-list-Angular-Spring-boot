package com.jihad.example.Todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jihad.example.Todolist.dto.Taskdto;
import com.jihad.example.Todolist.services.impl.TaskServiceImpl;
import com.jihad.example.Todolist.utils.APIResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Taskcontroller {
	@Autowired
	private TaskServiceImpl service;

	
	@PostMapping("{email}/add-task")
public ResponseEntity<?> saveTaskdto(@PathVariable String email,@RequestBody Taskdto taskDto) throws Exception
	
	{ 
		 APIResponse apiresponse= service.saveTaskdto(taskDto,email);
		 return  ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
}
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable("id") Long id){
		 service.deleteTaskdto(id);
		
		
	}
	
}