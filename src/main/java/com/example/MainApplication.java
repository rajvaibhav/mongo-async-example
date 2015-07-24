package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import scala.concurrent.Await;
import scala.concurrent.Future;
import akka.util.Timeout;

import com.example.entities.Person;
import com.example.factories.MongoConnectionFactory;
import com.example.repositories.PersonRepository;
import com.example.repositories.impl.PersonRepositoryImpl;
import com.mongodb.async.client.MongoClient;

public class MainApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(MainApplication.class);

	public static void main(String[] args) {
		logger.debug("Initializing mongo client.");
		MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
		logger.debug("Initialized mongo client:: " + mongoClient);
		PersonRepository repo = new PersonRepositoryImpl();
		Future<Person> response = repo.findOne("1");
		try {
			Person person = Await.result(response,
					new Timeout(50000l).duration());
			System.out.println(person.getFirstName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
