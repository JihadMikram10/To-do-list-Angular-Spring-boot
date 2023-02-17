package com.jihad.example.Todolist.services;

import com.jihad.example.Todolist.dto.Taskdto;
import com.jihad.example.Todolist.utils.APIResponse;

public interface LtaskService {
	APIResponse saveTaskdto(Taskdto task,String email);
	APIResponse deleteTaskdto(Long id);



}
