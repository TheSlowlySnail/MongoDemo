package de.meiering.maven.mongodb.MongoTest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class QueryDriver {

	public static void main(String[] args) {
		DB db = (new MongoClient("localhost", 27017)).getDB("helge");
		DBCollection dbCollection = (DBCollection) db.getCollection("adresses");
		BasicDBObject basicDBObject = new BasicDBObject();
		//basicDBObject.put("name", "test");
		DBCursor dbCursor = dbCollection.find();
		while (dbCursor.hasNext()) {
			System.out.println(dbCursor.next());
			
		}
	}

}
