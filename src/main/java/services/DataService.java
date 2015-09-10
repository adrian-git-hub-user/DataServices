package services;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import common.Constants;
import database.MongoCollectionAccessor;

public class DataService {
	
	public String getDataByCategory(String category) {

		DBCollection collection = MongoCollectionAccessor.getInstance().getCollection(Constants.COLLECTION_NAME);

		BasicDBObject dbOjb = new BasicDBObject("category", category);
		List<DBObject> objList = collection.find(dbOjb).toArray();

		return new BasicDBObject("modules", objList).toString();
	}

	public String getDataByCategoryAndDate(String category, String afterDate) {

		DBCollection collection = MongoCollectionAccessor.getInstance().getCollection(Constants.COLLECTION_NAME);
		List<DBObject> data = new ArrayList<DBObject>();

		DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.DATE_FORMAT);

		BasicDBObject query = new BasicDBObject("dateAdded", new BasicDBObject("$gt", dtf.parseDateTime(afterDate).getMillis()));
		
		data.addAll(collection.find(query).sort(new BasicDBObject("dateAdded", -1)).toArray());
		return new BasicDBObject("modules", data).toString();
	}


	public String getDataByCategoryAndMinutesInPast(String category, Integer minutesInPast) {

		DateTime dateTime = new DateTime();		
		DateTime secondsInPast = dateTime.plus(-(minutesInPast * 1000 * 60));
		
		DBCollection collection = MongoCollectionAccessor.getInstance().getCollection(Constants.COLLECTION_NAME);
		List<DBObject> data = new ArrayList<DBObject>();

		BasicDBObject query = new BasicDBObject("dateAdded", new BasicDBObject("$gt", secondsInPast.getMillis()));
		
		data.addAll(collection.find(query).sort(new BasicDBObject("dateAdded", -1)).toArray());
		return new BasicDBObject("modules", data).toString();
	}

}
