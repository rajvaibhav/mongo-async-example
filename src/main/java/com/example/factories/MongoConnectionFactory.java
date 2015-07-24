package com.example.factories;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;

/**
 * Exposes getMongoClient method which returns singleton instance of
 * mongoClient.
 * 
 * @author vaibhavraj
 *
 */
public class MongoConnectionFactory {

	private static volatile MongoClient mongoClient;

	/**
	 * Returns singleton instance of MongoClient.
	 * 
	 * @return
	 */
	public static MongoClient getMongoClient() {

		if (null == mongoClient) {

			synchronized (MongoConnectionFactory.class) {

				if (null == mongoClient) {
					mongoClient = MongoClients
							.create("mongodb://localhost:27017");
				}

			}

		}
		return mongoClient;
	}

	/**
	 * 
	 * @return
	 */
	public static MongoDatabase getMongoDatabase() {
		final MongoClient mongoClient = getMongoClient();
		return mongoClient.getDatabase("dealcms");
	}
}
