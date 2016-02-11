package com.service;

import org.springframework.data.repository.CrudRepository;

import com.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
