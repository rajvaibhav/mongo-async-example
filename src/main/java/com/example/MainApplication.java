package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import scala.concurrent.Await;
import scala.concurrent.Future;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.util.Timeout;

import com.example.akka.factories.ActorSystemFactory;
import com.example.akka.factories.DistributedPubSubMediatorFactory;
import com.example.entities.Person;
import com.example.factories.MongoConnectionFactory;
import com.example.repositories.PersonRepository;
import com.example.repositories.impl.PersonRepositoryImpl;
import com.mongodb.async.client.MongoClient;

public class MainApplication {

    private static final Logger logger = LoggerFactory
	    .getLogger(MainApplication.class);

    public static void main(String[] args) {
	initConfigurations();

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

    public static void initConfigurations() {
	logger.debug("Initializing mongo client.");
	final MongoClient mongoClient = MongoConnectionFactory.getMongoClient();
	logger.debug("Initialized mongo client:: " + mongoClient);
	logger.debug("Initializing actor system.");
	final ActorSystem system = ActorSystemFactory.getActorSystem();
	logger.debug("Actor system initialized successfully.");
	logger.debug("Initializing mediator.");
	final ActorRef mediator = DistributedPubSubMediatorFactory
		.getDistributedPubSubMediator();
	logger.debug("Mediator initialized successfully.");
    }

}
