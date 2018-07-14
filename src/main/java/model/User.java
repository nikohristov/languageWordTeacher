package model;

import java.util.ArrayList;

public class User {

	private String username;
	private String password;
	private String id;
	private ArrayList<Word> wordList;

	public User(String username) {
		this.username = username;
	}

	public User(String username, String password, String id, ArrayList<Word> wordList) {
		this.username = username;
		this.password = password;
		this.id = id;
		this.wordList = wordList;
	}

	public String getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Word> getWordList() {
		return wordList;
	}

	public String getUsername() {
		return this.username;
	}
}
