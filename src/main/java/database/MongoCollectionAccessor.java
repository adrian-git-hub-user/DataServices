package database;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import common.Constants;

public class MongoCollectionAccessor {
	
	private static final MongoCollectionAccessor INSTANCE = new MongoCollectionAccessor();
	private DB db;
	
	// Private constructor prevents instantiation from other classes
	private MongoCollectionAccessor() {
		try {
			MongoClient mongoClient = new MongoClient(Constants.MONGODB_IP, 27017);
			db = mongoClient.getDB(Constants.DB);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public DBCollection getCollection(String collection){
		return db.getCollection(collection);
	}
	
	public static MongoCollectionAccessor getInstance() {
		return INSTANCE;
	}
}