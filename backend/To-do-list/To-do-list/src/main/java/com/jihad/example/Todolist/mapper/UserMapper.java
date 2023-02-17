package com.jihad.example.Todolist.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jihad.example.Todolist.dto.Userdto;
import com.jihad.example.Todolist.model.Utilisateur;
@Component
public class UserMapper {
	
	@Autowired
	public
	DozerBeanMapper mapper;
	public Userdto entityToDto(Utilisateur src) {

		Userdto user_Dto = mapper.map(src, Userdto.class);
		return user_Dto;

	}
	public Utilisateur dtoToEntity(Userdto src) {
		Utilisateur user_Entity = mapper.map(src, Utilisateur.class);
		return user_Entity;
	}
	
	public List<Userdto> entityToDto(List<Utilisateur> src) {
		return src.stream().map(user_source ->entityToDto(user_source))
		.collect(Collectors.toList());
	}
	
	public List<Utilisateur> dtoToEntity(List<Userdto> src) {
		return src.stream().map(user_source ->dtoToEntity(user_source))
		.collect(Collectors.toList());
	}
	
	
}
