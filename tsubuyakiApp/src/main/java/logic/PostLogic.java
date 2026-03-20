package logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.PostDAO;
import database.DBConnection;
import model.AccountModel;
import model.PostModel;

public class PostLogic {
	public List<PostModel> findAll() throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findAll(conn);
		}
	}
	
	public List<PostModel> findByAccountId(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByAccountId(conn, model);
		}
	}
	
	public List<PostModel> findByAccountId(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByAccountId(conn, model);
		}
	}
	
	public List<PostModel> findByAccountIdIsGood(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByAccountIdIsGood(conn, model);
		}
	}
	
	public List<PostModel> findByReply(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByReply(conn, model);
		}
	}
	
	public PostModel findOne(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findOne(conn, model);
		}
	}
	
	public int createPost(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.createPost(conn, model);
		}
	}
	
	public int createRply(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.createReply(conn, model);
		}
	}
	
	public void deletePost(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao =  new PostDAO();
			
			dao.deletePost(conn, model);
		}
	}
}
