package com.example.entities.reader;

import org.bson.Document;

import com.example.entities.Person;

public interface PersonReader {
	public Person readPersonFromDocument(final Document document);
}
