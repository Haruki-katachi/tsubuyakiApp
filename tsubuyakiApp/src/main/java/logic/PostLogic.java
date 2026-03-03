package logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.PostDAO;
import database.DBConnection;
import model.PostModel;

public class PostLogic {
	public List<PostModel> findAll() throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findAll(conn);
		}
	}
	
	public int createPost(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.createPost(conn, model);
		}
	}
}
