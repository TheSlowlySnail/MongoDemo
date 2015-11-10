package de.meiering.maven.mongodb.MongoTest;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class NewInsertDriver {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		MongoDatabase db = mongoClient.getDatabase("helge");
		MongoCollection<Document> collection = db.getCollection("adresses");
		MongoCursor<Document> cursor = collection.find().iterator();
		//collection.findOneAndUpdate(new Document("name", "Helge"), new Document("name","Ina"));
		collection.findOneAndReplace(new Document("name", "Helge"), new Document("name","Ina"));
		//collection.deleteMany(new Document("name", "helge"));
		int count = 0;
		
		while (cursor.hasNext()) {
			
			count++;
			
			System.out.println(count + ". Cursor " + cursor.next());
		
		}
		System.out.println("Collection count" + collection.count());
		

	}

	private static  Document doSomeData() {
		Document document = new Document();
		document.put("id", "1234");
		document.put("name", "helge");
		document.put("alter", "alter Sack");
		return document;
	}

}
