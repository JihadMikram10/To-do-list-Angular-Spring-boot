package com.jihad.example.Todolist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jihad.example.Todolist.dto.Userdto;
import com.jihad.example.Todolist.mapper.UserMapper;
import com.jihad.example.Todolist.model.Utilisateur;
import com.jihad.example.Todolist.repository.UserRepository;
import com.jihad.example.Todolist.services.LuserService;
import com.jihad.example.Todolist.utils.APIResponse;
import com.jihad.example.Todolist.utils.JwtUtils;

@Service
public class UserServiceImpl implements LuserService {
	@Autowired
	UserRepository repository;
	@Autowired
	UserMapper mapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtils jwtUtils;

	  public Userdto findUserByEmail(String email) {
		  Utilisateur userentity= repository.findUserByemail(email);
		  return  mapper.entityToDto(userentity);
		  }

	public  APIResponse  signIn(Userdto userDto) {
		
		Utilisateur userEntity = repository.findUserByemail(userDto.getEmail());
		if (userEntity != null && passwordEncoder.matches(userDto.getPassword(),userEntity.getEncryptedPassword())) {
			String token = jwtUtils.generateJwt(userEntity);
			return new APIResponse ("Login successful",HttpStatus.OK, token);
			

		} else {

			 return new APIResponse("Incorrect email or password",HttpStatus.CONFLICT,"error token");
		}
	}

	public boolean checkIfEmailExist(String email) {
		Utilisateur userEntity = repository.findUserByemail(email);
		return userEntity != null;
	}
	public boolean checkIfUserNameExist(String username) {
		Utilisateur userEntity = repository.findUserByusername(username);
		return userEntity != null;
	}
	@Override
	public Userdto saveUserdto(Userdto user) {
		Utilisateur userEntity = mapper.dtoToEntity(user);
		userEntity.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
		repository.save(userEntity);
		return mapper.entityToDto(userEntity);
	}



}
