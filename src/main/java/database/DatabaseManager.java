package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DatabaseManager {
	
	private static String MONGO_URI = "mongodb://localhost:27017";
	private static String DATABASE_NAME = "language-word-teacher";
	
	private static MongoClient mongoClient;
	
	private DatabaseManager() {

	}
	
	public static MongoDatabase getConnection() {
		if (null == DatabaseManager.mongoClient) {
			DatabaseManager.mongoClient = new MongoClient(new MongoClientURI(DatabaseManager.MONGO_URI));
		}
		return DatabaseManager.mongoClient.getDatabase(DatabaseManager.DATABASE_NAME);
	}
}

//class Now {
//	public static void main(String[] args) {
//		MongoDatabase db = DatabaseManager.getConnection();
//		System.out.println(db.getCollection("user").find());
//	}
//}

