package model;

import java.sql.Timestamp;

public class PostModel {
	public PostModel() { }
	
	private int id;
	private int accountId;
	private String item;
	private int toId;
	private int isDeleted;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	
}
