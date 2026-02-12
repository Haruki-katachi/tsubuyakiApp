package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements AutoCloseable {
	private final Connection connection;
	private final String JBDC_URL = "jdbc:h2:tcp://localhost/~/tsubuyaki_app";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public DBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		
		this.connection = DriverManager.getConnection(JBDC_URL, DB_USER, DB_PASS);
	}
	
	public Connection getInstance() {
		return this.connection;
	}
	
	@Override
	public void close() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		this.connection.close();
	}

}
