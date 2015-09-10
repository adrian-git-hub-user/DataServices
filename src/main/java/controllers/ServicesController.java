package controllers;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import services.DataService;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import common.Constants;
import database.MongoCollectionAccessor;

@Controller
@RequestMapping("crawled")
public class ServicesController {

	private DataService dataService = new DataService();
	
	@RequestMapping(value = "/getItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getItems(@RequestParam(value = "category", required = false) String category, 
			@RequestParam(value = "afterDate", required = false) String afterDate,
			@RequestParam(value = "minutesInPast", required = false) Integer minutesInPast) {

		System.out.println("category is " + category);
		System.out.println("date is " + afterDate);
		System.out.println("minutesInPast is " + minutesInPast);
		
		if(!afterDate.isEmpty())
			return dataService.getDataByCategoryAndDate(category , afterDate);
		if(minutesInPast != 0)
			return dataService.getDataByCategoryAndMinutesInPast(category, minutesInPast);
		else
			return dataService.getDataByCategory(category);

	}

}