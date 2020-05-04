package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.Customer;
import com.movie.entity.CustomerEntity;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;


@RestController
@RequestMapping("/loginpage")
public class MovieController {

	@Autowired
	private MovieService movieService;
		
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/all")
	public List<CustomerEntity> showAll(){
		return (List<CustomerEntity>) movieRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/register")
	public void register(@RequestBody Customer customer){
		movieService.register(customer);
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/login")
	public ResponseEntity<String> login(Customer customer){
		return new ResponseEntity<String>(movieService.login(customer),HttpStatus.OK);
	}
	
	
}
