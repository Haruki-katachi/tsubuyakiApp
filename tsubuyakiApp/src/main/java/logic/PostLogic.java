package logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.h2.message.DbException;

import dao.PostDAO;
import database.DBConnection;
import model.AccountModel;
import model.PostModel;

public class PostLogic {
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see PostDAO#findAll(Connection)
	 * @see DBConnection
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PostModel> findAll() throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findAll(conn);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see PostDAO#findByAccountId(Connection, PostModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PostModel> findByAccountId(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByAccountId(conn, model);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see PostDAO#findByAccountId(Connection, AccountModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PostModel> findByAccountId(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByAccountId(conn, model);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see PostDAO#findByAccountIdIsGood(Connection, AccountModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PostModel> findByAccountIdIsGood(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByAccountIdIsGood(conn, model);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see PostDAO#findByReply(Connection, PostModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PostModel> findByReply(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findByReply(conn, model);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see PostDAO#findOne(Connection, PostModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public PostModel findOne(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			return dao.findOne(conn, model);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行する
	 * 
	 * @see PostDAO#createPost(Connection, PostModel)
	 * @see DBConnection
	 * @param model
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createPost(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			dao.createPost(conn, model);
		}
	}
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行する
	 * 
	 * @see PostDAO#createReply(Connection, PostModel)
	 * @see DBConnection
	 * @param model
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createReply(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao = new PostDAO();
			
			dao.createReply(conn, model);
		}
	}
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行する
	 * 
	 * @see PostDAO#deletePost(Connection, PostModel)
	 * @see DBConnection
	 * @param model
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deletePost(PostModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			PostDAO dao =  new PostDAO();
			
			dao.deletePost(conn, model);
		}
	}
}
