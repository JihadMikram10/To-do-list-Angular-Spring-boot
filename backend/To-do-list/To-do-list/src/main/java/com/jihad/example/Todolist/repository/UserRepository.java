package com.jihad.example.Todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jihad.example.Todolist.model.Utilisateur;
@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
	public Utilisateur findUserByemail(String email);
	public Utilisateur findUserByusername(String username);
	
	

}
