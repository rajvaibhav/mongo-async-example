package com.example.repositories;

import java.util.List;

import scala.concurrent.Future;

import com.example.entities.Person;

/**
 * 
 * @author vaibhavraj
 *
 */
public interface PersonRepository {

	public Future<Person> findOne(final String id);

	public Future<List<Person>> find(final Person person);

	public Future<Boolean> saveOne(final Person person);

	public Future<Boolean> save(final List<Person> persons);
}
