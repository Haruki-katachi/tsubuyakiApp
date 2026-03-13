package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class GoodModel implements Serializable {
	private int id;
	private int accountId;
	private int postId;
	private int isGood;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public GoodModel() { }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public int getPostId() {
		return postId;
	}
}
