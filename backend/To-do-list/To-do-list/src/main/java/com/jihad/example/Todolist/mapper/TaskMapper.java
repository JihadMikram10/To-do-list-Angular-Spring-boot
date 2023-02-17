package com.jihad.example.Todolist.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jihad.example.Todolist.dto.Taskdto;
import com.jihad.example.Todolist.model.Task;
@Component
public class TaskMapper {
	@Autowired
	public
	DozerBeanMapper mapper;
	public Taskdto entityToDto(Task src) {

		Taskdto tsk_Dto = mapper.map(src, Taskdto.class);
		return tsk_Dto;

	}
	public Task dtoToEntity(Taskdto src) {
		Task tsk_Entity = mapper.map(src, Task.class);
		return tsk_Entity;
	}
	
	public List<Taskdto> entityToDto(List<Task> src) {
		return src.stream().map(tsk_source ->entityToDto(tsk_source))
		.collect(Collectors.toList());
	}
	
	public List<Task> dtoToEntity(List<Taskdto> src) {
		return src.stream().map(tsk_source ->dtoToEntity(tsk_source))
		.collect(Collectors.toList());
	}
	
}
