package com.movie.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.movie.dto.Customer;
import com.movie.entity.CustomerEntity;
import com.movie.repository.MovieRepository;

@Service
@Transactional
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	

	public String register(Customer customer) {
		// TODO Auto-generated method stub
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setUserid(customer.getUserid());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setUsername(customer.getUsername());
		customerEntity.setUserpassword(customer.getUserpassword());
		customerEntity.setUserphone(customer.getUserphone());
		customerEntity.setUsertype(customer.getUsertype());
		movieRepository.save(customerEntity);
		return "User Registered successfully";
	}

	public String login(Customer customer) {
		// TODO Auto-generated method stub
		CustomerEntity customerEntity = movieRepository.findById(customer.getUserid()).get();
		if(customer.getUserpassword().equals(customerEntity.getUserpassword()))
			return "Login Successfull";
		else
			return "Unauthorised User";
	}

}
