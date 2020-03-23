package com.bridge.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.bridge.model.Bridge;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class BridgeDAOImpl implements BridgeDAO {

	/*
	 * This method used to get the bridge details from the Mango DB
	 */
	public ArrayList<Bridge> getBridgeDetails() {

		ArrayList<Bridge> bList = new ArrayList<Bridge>();

		MongoDatabase database = getDatabaseConnection();
		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("BridgeDetails");
		System.out.println("Collection sampleCollection selected successfully");

		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();

		// Getting the iterator
		Iterator<Document> it = iterDoc.iterator();

		while (it.hasNext()) {
			Document d = (Document) it.next();
			System.out.println(d.toString());
			bList.add(new Bridge(d.getString("name"), d.getString("length"), d.getString("heigth"),
					d.getString("width"), d.getString("gpsLocation")));

		}

		return bList;

	}
	/*
	 * This method used to save the Bridge object into Mango database
	 */

	public void addNewBridge(Bridge b) {

		MongoDatabase database = getDatabaseConnection();

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("BridgeDetails");
		System.out.println("Collection sampleCollection selected successfully");

		Document document = new Document("title", "Bridge").append("name", b.getName()).append("length", b.getLength())
				.append("heigth", b.getHeight()).append("width", b.getWidth())
				.append("gpsLocation", b.getGpsLocation());
		collection.insertOne(document);
		System.out.println("Bridge Document inserted successfully");
	}

	/*
	 * Used to get the get the connection to Mango database
	 */
	public MongoDatabase getDatabaseConnection() {
		// Creating a Mongo client
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Creating Credentials
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
		System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongo.getDatabase("myDb");

		return database;
	}

}
