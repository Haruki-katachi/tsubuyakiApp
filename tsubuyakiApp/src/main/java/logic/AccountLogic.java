package logic;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AccountDAO;
import database.DBConnection;
import model.AccountModel;

public class AccountLogic {
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行し内容を返す
	 * 
	 * @see AccountDAO#findOne(Connection, AccountModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public AccountModel findOne(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			AccountDAO dao = new AccountDAO();
			
			return dao.findOne(conn, model);
		}
	}
	
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行し内容を返す
	 * 
	 * @see AccountDAO#create(Connection, AccountModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int create(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			AccountDAO dao = new AccountDAO();
			
			return dao.create(conn, model);
		}
	}
	/**
	 * データベースとの接続を確立しDAOの同名メソッドを実行し内容を返す
	 * 
	 * @see AccountDAO#update(Connection, AccountModel)
	 * @see DBConnection
	 * @param model
	 * @return DAOの同名メソッドの実行内容
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int update(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			AccountDAO dao = new AccountDAO();
			
			return dao.update(conn, model);
		}
	}
}
