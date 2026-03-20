package logic;

import java.sql.Connection;
import java.sql.SQLException;

import dao.GoodDAO;
import database.DBConnection;
import model.AccountModel;
import model.GoodModel;
import model.PostModel;

public class GoodLogic {
	public GoodModel findOne(AccountModel model, PostModel model2) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.findOne(conn, model, model2);
		}
	}
	
	public GoodModel findOne(int accountId, int postId) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.findOne(conn, accountId, postId);
		}
	}
	
	public int goodCount(int postId) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.goodCount(conn, postId);
		}
	}
	
	public int create(int accountId, int postId) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.create(conn, accountId, postId);
		}
	}
	
	public int update(GoodModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.update(conn, model);
		}
	}
}
