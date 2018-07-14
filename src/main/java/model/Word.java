package model;

import java.util.TreeSet;

public class Word {
	
	private String title;
	private TreeSet<String> meaningList;
	
	public Word(String title, TreeSet<String> meaningList) {
		this.setTitle(title);
		this.setMeaningList(meaningList);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public TreeSet<String> getMeaningList() {
		return meaningList;
	}

	private void setMeaningList(TreeSet<String> meaningList) {
		this.meaningList = meaningList;
	}
}
