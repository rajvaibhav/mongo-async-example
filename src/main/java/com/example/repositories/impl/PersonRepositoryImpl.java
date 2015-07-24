package com.example.repositories.impl;

import static com.mongodb.client.model.Filters.eq;

import java.util.List;

import org.bson.Document;

import scala.concurrent.Future;
import scala.concurrent.Promise;
import akka.dispatch.Futures;

import com.example.entities.Person;
import com.example.entities.reader.PersonReader;
import com.example.entities.reader.impl.PersonReaderImpl;
import com.example.factories.MongoConnectionFactory;
import com.example.repositories.PersonRepository;
import com.example.repositories.exception.DataNotFoundException;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

public class PersonRepositoryImpl implements PersonRepository {

    private MongoCollection<Document> personCollection;
    private PersonReader personReader;

    public PersonRepositoryImpl() {
	final MongoDatabase mongoDatabase = MongoConnectionFactory
		.getMongoDatabase();
	personCollection = mongoDatabase.getCollection("person");
	personReader = new PersonReaderImpl();
    }

    @Override
    public Future<Person> findOne(final String id) {

	final Promise<Person> promise = Futures.promise();

	personCollection.find(eq("id", id)).first(

		(Document document, final Throwable throwable) -> {
		    if (null == throwable) {
			if (null == document) {
			    promise.failure(new DataNotFoundException(
				    "No data found for the query."));
			} else {
			    promise.success(personReader
				    .readPersonFromDocument(document));
			}

		    } else {
			promise.failure(throwable);
		    }
		});

	return promise.future();
    }

    @Override
    public Future<List<Person>> find(final Person person) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Future<Boolean> saveOne(Person person) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Future<Boolean> save(List<Person> persons) {
	// TODO Auto-generated method stub
	return null;
    }

}
