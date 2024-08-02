package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.registration;

public interface registrationrepository extends CrudRepository<registration, Integer>{

	registration findByEmail(String email);


}
