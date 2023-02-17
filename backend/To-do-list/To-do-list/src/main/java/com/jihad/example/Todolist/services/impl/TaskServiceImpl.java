package com.jihad.example.Todolist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jihad.example.Todolist.dto.Taskdto;
import com.jihad.example.Todolist.dto.Userdto;
import com.jihad.example.Todolist.mapper.TaskMapper;
import com.jihad.example.Todolist.mapper.UserMapper;
import com.jihad.example.Todolist.model.Task;
import com.jihad.example.Todolist.model.Utilisateur;
import com.jihad.example.Todolist.repository.TaskRepository;
import com.jihad.example.Todolist.services.LtaskService;
import com.jihad.example.Todolist.utils.APIResponse;
@Service
public class TaskServiceImpl implements LtaskService {
	
	@Autowired
	TaskRepository taskrepository;
	@Autowired
	TaskMapper Tmapper;
	@Autowired
	UserMapper Umapper;
	@Autowired
	private UserServiceImpl userservice;
	

	@Override
	public  APIResponse saveTaskdto(Taskdto task,String email ) {
		Task taskEntity = Tmapper.dtoToEntity(task);
		Userdto user = userservice.findUserByEmail(email);
		Utilisateur userEntity = Umapper.dtoToEntity(user);
		  if(userEntity!=null) {
		 taskEntity.setUser(userEntity);
		taskrepository.save(taskEntity);
		return new APIResponse ("Task Added Succesful",HttpStatus.OK);
	}
		  else {
				return new APIResponse ("Error",HttpStatus.CONFLICT);
		  }
		
}


	public APIResponse deleteTaskdto(Long id) {
	try {
		taskrepository.deleteById(id);
		return new APIResponse ("Task Deleted Succesful",HttpStatus.OK);
		
		
	} catch (Exception e) {

		return new APIResponse ("Error",HttpStatus.CONFLICT);
	}
	
		
	
}
}