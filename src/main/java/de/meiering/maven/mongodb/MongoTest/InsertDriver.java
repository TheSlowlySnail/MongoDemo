package de.meiering.maven.mongodb.MongoTest;

import java.net.UnknownHostException;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * 
 * @author helge_000
 * @throws UnknownHostException
 */
public class InsertDriver 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        DB db = (new MongoClient("localhost",27017)).getDB("helge");
        DBCollection dbCollection = (DBCollection) db.getCollection("adresses");
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("name", "test");
        basicDBObject.put("subscriptions", 4100);
        dbCollection.insert(basicDBObject);
        
    }
}
