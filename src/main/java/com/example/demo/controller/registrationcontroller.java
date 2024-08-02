package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.registration;

import com.example.demo.services.registrationservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1") 

public class registrationcontroller {
	
	@Autowired
	registrationservice service;  //giving registrationservice name as service
	
	@PostMapping("/inserting") //postmapping is used to post data into database and inserting like a name
	
	public registration insertion(@RequestBody registration reg) {  //executeupdate=requestbody
		
		return service.insertion(reg);   //now service contains data that we are inserting in the order of registartion
		
	}
	@PostMapping("/multiadd")
	public Iterable<registration> multiadd(@RequestBody List<registration> reg) {
		return service.multiadd(reg);
	}
	@GetMapping("/fetching")
	public List<registration> fetchall(){
		
		return service.fetchall();
	}
	@GetMapping("/fetchwithid/{id}")
	public Optional<registration> getbyid(@PathVariable int id) {
		return service.getbyid(id);
	}
	@DeleteMapping("/deleting/{id}")
	public String remove(@PathVariable int id) {
		return service.remove(id);
	}
	@GetMapping("/fetchwithemail/{email}")
	public registration getbyemail(@PathVariable String email) {
		return service.getbyemail(email);
	}
	@PutMapping("/update")
	public registration updating(@RequestBody registration reg) {
		return service.update(reg);
	}
	
	

}