package mapper;

import java.util.ArrayList;
import java.util.TreeSet;

import org.bson.Document;

import model.User;
import model.Word;

public class UserDataMapper {
	
	public User mapUserData(Document fetchedUserData) {
    	String username = fetchedUserData.getString("username");
    	String password = fetchedUserData.getString("password");
    	String id = fetchedUserData.get("_id").toString();
    	ArrayList<Document> wordList = (ArrayList<Document>) fetchedUserData.get("wordList");
    	ArrayList<Word> userWordList = new ArrayList<Word>();
    	
    	for (Document wordDocument: wordList) {
    		String wordTitle = wordDocument.getString("title");
    		ArrayList<String> meaningList = (ArrayList<String>) wordDocument.get("meaningList");
    		TreeSet<String> wordMeaningList = new TreeSet<String>();
    		
    		meaningList.forEach(meaning -> wordMeaningList.add(meaning));
    		
    		userWordList.add(new Word(wordTitle, wordMeaningList));
    	}
    	
    	return new User(username, password, id, userWordList);
	}
	
}
