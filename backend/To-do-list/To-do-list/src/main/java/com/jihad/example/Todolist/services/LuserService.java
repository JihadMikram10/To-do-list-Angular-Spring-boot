package com.jihad.example.Todolist.services;

import org.springframework.stereotype.Service;

import com.jihad.example.Todolist.dto.Userdto;
@Service
public interface LuserService   {
	Userdto saveUserdto(Userdto user) throws Exception;

	
	

}
