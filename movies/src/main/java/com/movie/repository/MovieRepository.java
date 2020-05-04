package com.movie.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.entity.CustomerEntity;

public interface MovieRepository extends CrudRepository<CustomerEntity, Integer>{

}
