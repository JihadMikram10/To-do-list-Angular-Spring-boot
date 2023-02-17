package com.jihad.example.Todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihad.example.Todolist.model.Task;


public interface TaskRepository extends JpaRepository<Task,Long> {
	
}
