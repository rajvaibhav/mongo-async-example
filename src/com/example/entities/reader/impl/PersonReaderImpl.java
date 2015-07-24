package com.example.entities.reader.impl;

import org.bson.Document;

import com.example.entities.Person;
import com.example.entities.reader.PersonReader;

/**
 * 
 * @author vaibhavraj
 *
 */
public class PersonReaderImpl implements PersonReader {

	@Override
	public Person readPersonFromDocument(final Document document) {
		Person person = new Person.Builder()
				.firstName(document.getString("firstName"))
				.lastName(document.getString("lastName"))
				.email(document.getString("email"))
				.mobile(document.getString("mobile")).build();
		return person;
	}

}
