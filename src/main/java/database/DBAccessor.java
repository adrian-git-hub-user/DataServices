package database;

import java.util.List;

import database.Constants;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class DBAccessor {

	public void insertData(String category, String title, String fullText, String hrefTitle) {

		DBCollection collection = Singleton.getInstance().getCollection(Constants.COLLECTION_NAME);
		DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.DATE_FORMAT);

		Long currentDateTime = System.currentTimeMillis();
		
		BasicDBObject obj = new BasicDBObject("category", category).append("unique", "true")
				.append("title", title).append("fullText", fullText).append("hrefTitle", hrefTitle)
				.append("dateAdded", currentDateTime).append("formattedDateTime" , dtf.print(currentDateTime));

		
		collection.insert(obj);
		System.out.println("Successfully added doc with details : " + obj.toString());

	}

	public static void main(String[] args) {
			new DBAccessor().insertData(Constants.SPORT, "Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland Sport Ireland supports easing of budget rules on Ireland France supports easing of budget rules on Ireland France supports easing of budget rules on Ireland France supports easing of budget rules on Ireland France supports easing of budget rules on Ireland", "t", "http://www.google.com");
		
	}
}
