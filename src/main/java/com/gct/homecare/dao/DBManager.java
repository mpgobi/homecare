package com.gct.homecare.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DBManager {
	/** Utility to Get the Connection from the database */
	public static DBCollection getConnection(String dbName,
			String collectionName) throws UnknownHostException {

		/** Connecting to MongoDB */
		MongoClient mongo = new MongoClient("localhost", 27017);

		/**
		 * Gets database, incase if the database is not existing MongoDB Creates
		 * it for you
		 */
		DB db = mongo.getDB(dbName);

		/**
		 * Gets collection / table from database specified if collection doesn't
		 * exists, MongoDB will create it for you
		 */
		DBCollection table = db.getCollection(collectionName);
		return table;
	}
}
