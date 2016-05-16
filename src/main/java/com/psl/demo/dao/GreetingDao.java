package com.psl.demo.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psl.demo.model.Greeting;

@Transactional
public interface GreetingDao extends CrudRepository<Greeting, Serializable> {
	public Greeting findById(long id);
	
	@Query("SELECT g FROM Greeting g WHERE g.content=?1")
	public Greeting findByContent(String content);
}
