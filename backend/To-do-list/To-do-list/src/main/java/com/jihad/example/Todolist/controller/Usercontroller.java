package com.jihad.example.Todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jihad.example.Todolist.dto.Userdto;
import com.jihad.example.Todolist.services.impl.UserServiceImpl;
import com.jihad.example.Todolist.utils.APIResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Usercontroller {
	@Autowired
	private UserServiceImpl service;

	@GetMapping("user/{email}")
	public  Userdto findById(@PathVariable("email")String email){
		return service.findUserByEmail(email);
		
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<?> saveUserDto(@RequestBody Userdto userDto) throws Exception
	
	{	
		 if (service.checkIfEmailExist(userDto.getEmail())) {
		      return new ResponseEntity<String>("Email already exist", HttpStatus.CONFLICT);
	        }
		 if (service.checkIfUserNameExist(userDto.getUsername())) {
		      return new ResponseEntity<String>("Username already exist", HttpStatus.CONFLICT);
	        }
		 service.saveUserdto(userDto);
		 return new ResponseEntity<String>("Register passed Succesful", HttpStatus.OK);
	}
	
	
	  @PostMapping("/signin")
	  
	    public  ResponseEntity<?> login(@RequestBody Userdto userDto ){
		  
	       APIResponse apiresponse=  service.signIn(userDto);

	       return  ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
	    }
	
}
