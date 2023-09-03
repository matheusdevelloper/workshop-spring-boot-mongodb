package com.matheusitech.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusitech.workshopmongo.domain.User;
import com.matheusitech.workshopmongo.repository.UserRepository;
import com.matheusitech.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	//Retorna todos usuarios do banco de dados.
	public List<User> findAll(){
		return repo.findAll();
	}
	
	//Retorna o usuário pelo o id
	public User findById(String id) {
		return repo.findById(id)
	            .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
