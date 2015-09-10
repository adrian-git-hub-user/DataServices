package database;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Singleton {

	private static final Singleton INSTANCE = new Singleton();
	private DB db;

	// Private constructor prevents instantiation from other classes
	private Singleton() {
		try {
			MongoClient mongoClient = new MongoClient(Constants.MONGODB_IP, 27017);
			db = mongoClient.getDB(Constants.DB);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DBCollection getCollection(String collection) {
		return db.getCollection(collection);
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}
}