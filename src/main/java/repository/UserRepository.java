package repository;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import database.DatabaseManager;
import exception.DataNotFoundException;
import mapper.UserDataMapper;
import model.User;

public class UserRepository {

	private static final String DB_COLLECTION_NAME_USER = "user";
	
	private MongoDatabase dbConnection;
	private MongoCollection<Document> userCollection;
	private UserDataMapper userDataMapper;
	
	public UserRepository() {
		this.dbConnection = DatabaseManager.getConnection();
		this.userCollection = this.dbConnection.getCollection(UserRepository.DB_COLLECTION_NAME_USER);
		this.userDataMapper = new UserDataMapper();
	}
	
	public User fetchUserByUsername(String username) throws DataNotFoundException {
		Document whereClause = new Document("username", username);
		FindIterable<Document> result = this.userCollection.find(whereClause);
		Iterator<Document> resultIterator = result.iterator();
		User user;
		
		if (resultIterator.hasNext()) {
			Document userDocument = (Document) resultIterator.next();
			user = userDataMapper.mapUserData(userDocument);
		} else {
			throw new DataNotFoundException();
		}
		
		return user;
	}
}
