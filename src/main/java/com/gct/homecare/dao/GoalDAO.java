package com.gct.homecare.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.gct.homecare.pojo.Goal;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class GoalDAO {

	/** function to insert the data to the database */

	public String insertData(String dbName, String collectionName, Goal objGoal)
			throws UnknownHostException {

		/** Connecting to MongoDB */
		DBCollection table = DBManager.getConnection("HomeCareDB", "GoalTest");

		/** creating a document to store as key and value */
		BasicDBObject document = new BasicDBObject();
		document.put("patientID", objGoal.getPatientID());
		document.put("goalID", objGoal.getGoalID());
		document.put("goal", objGoal.getGoal());
		/** inserting to the document to collection or table */
		table.insert(document);
		return "Goal added successfully with the record number :"
				+ table.count();
	}

	/** function to get Details from the database */
	public List<Goal> findData(String dbName, String collectionName)
			throws UnknownHostException {

		/** Connecting to database */
		DBCollection table = DBManager.getConnection("test", "goaltest");

		/** getting results from the database */
		DBCursor cursor = table.find();
		List<Goal> list = new ArrayList<Goal>();

		/** iterating over the documents got from the database */
		while (cursor.hasNext()) {

			DBObject obj = cursor.next();

			System.out.println(obj);

			Goal objGoal = new Goal();
			objGoal.setPatientID(((Double) obj.get("patientID")).intValue());
			objGoal.setGoalID(((Double) obj.get("goalID")).intValue());
			objGoal.setGoal((String) obj.get("goal"));

			/** inner While closed */
			list.add(objGoal);
		}
		/** while iterating over the cursor records closed here */
		return list;
	}

	/** Utility to remove un wanted contents */
	public static String subStringUtility(String s) {

		return s.substring(2, s.length() - 2);
	}

	/** Utility to convert the document to map */
	public static Map<String, String> documentToMapUtility(String s) {
		s = s.substring(1, s.length() - 1);
		String sArr[] = s.split(",");
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 1; i < sArr.length; i++) {
			if (!sArr[i].contains("$date")) {
				String keyValue[] = sArr[i].split(":");
				map.put(keyValue[0], keyValue[1]);
				System.out.println(keyValue[0] + "," + keyValue[1]);
			} else {
				String keyValue[] = sArr[i].split(":");
				map.put(keyValue[0], keyValue[2]);
			}
		}
		return map;
	}

}