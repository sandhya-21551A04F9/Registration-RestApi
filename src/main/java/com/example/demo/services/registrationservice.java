package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.registration;
import com.example.demo.repository.registrationrepository;

@Service

public class registrationservice {
	
	@Autowired     //for connecting service an repository layer
	registrationrepository repo;   //giving name for repository layer
	
	public registration insertion(registration reg) {   //used registration as database returns registration details
		
		return repo.save(reg); //repo contains all cruds in that we are using save which means inserting single value
	}
	
	public  Iterable<registration> multiadd(List<registration> reg) {
		return repo.saveAll(reg);
	}
	public List<registration> fetchall(){
		return (List<registration>) repo.findAll();
	}
	public Optional<registration> getbyid(int id) {
		return repo.findById(id);
	}
	public String remove(int id) {
		repo.deleteById(id);
		return "successfully deleted"+id;
	}
	public registration getbyemail(String email) {
		return repo.findByEmail(email);
	}
	public registration update(registration reg) {
		int id= reg.getId();
		registration regl=repo.findById(id).get();
		regl.setEmail(reg.getEmail());
		regl.setName(reg.getName());
		regl.setPassword(reg.getPassword());
		return repo.save(regl);
		
		
	}
	

	
}