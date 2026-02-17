package logic;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AccountDAO;
import database.DBConnection;
import model.AccountModel;

public class AccountLogic {
	public AccountModel findOne(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			AccountDAO dao = new AccountDAO();
			
			return dao.findOne(conn, model);
		}
	}
	
	public int create(AccountModel model) throws ClassNotFoundException, SQLException {
		try(DBConnection db = new DBConnection()) {
			Connection conn = db.getInstance();
			AccountDAO dao = new AccountDAO();
			
			return dao.create(conn, model);
		}
	}
}
