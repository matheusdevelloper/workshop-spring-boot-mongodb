package com.matheusitech.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusitech.workshopmongo.domain.User;
import com.matheusitech.workshopmongo.dto.UserDTO;
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
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	//Inserir um usuario no banco de dados.
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
	    repo.deleteById(id);
	
	}
	
	//UserDTO passa  os objetos para a classe User inserindo os dados no banco .
	public User fromDTO(UserDTO objDTO) {
		return  new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	
}
