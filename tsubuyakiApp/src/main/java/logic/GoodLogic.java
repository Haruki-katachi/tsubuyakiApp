package logic;

import java.sql.Connection;
import java.sql.SQLException;

import dao.GoodDAO;
import database.DBConnection;
import model.AccountModel;
import model.GoodModel;
import model.PostModel;

public class GoodLogic {
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see GoodDAO#findOne(Connection, AccountModel, PostModel)
	 * @see DBConnection
	 * @param model id
	 * @param model2 id
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public GoodModel findOne(AccountModel model, PostModel model2) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.findOne(conn, model, model2);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see GoodDAO#findOne(Connection, int, int)
	 * @see DBConnection
	 * @param accountId
	 * @param postId
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public GoodModel findOne(int accountId, int postId) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.findOne(conn, accountId, postId);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行して返す
	 * 
	 * @see GoodDAO#goodCount(Connection, int)
	 * @see DBConnection
	 * @param postId
	 * @return　DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int goodCount(int postId) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			return dao.goodCount(conn, postId);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行する
	 * 
	 * @see GoodDAO#create(Connection, int, int)
	 * @see DBConnection
	 * @param accountId
	 * @param postId
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void create(int accountId, int postId) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			dao.create(conn, accountId, postId);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行する
	 * 
	 * @see GoodDAO#update(Connection, GoodModel)
	 * @see DBConnection
	 * @param model
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void update(GoodModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			GoodDAO dao = new GoodDAO();
			
			dao.update(conn, model);
		}
	}
}
