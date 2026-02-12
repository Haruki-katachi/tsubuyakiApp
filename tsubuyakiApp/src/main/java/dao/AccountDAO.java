package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountModel;

public class AccountDAO {
	
	public AccountModel findOne(Connection conn, AccountModel model) {
		
		try {
			String sql = "select * from accounts where is_deleted = 0 and email = ? and password = ?";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setString(1, model.getEmail());
				pStmt.setString(2, model.getPassword());
				
				try(ResultSet rs = pStmt.executeQuery()) {
					if(rs.next()) {
						model.setId(rs.getInt("id"));
						model.setEmail(rs.getString("email"));
						model.setPassword(rs.getString("password"));
						model.setName(rs.getString("name"));
						model.setIsDeleted(rs.getInt("is_deleted"));
						model.setCreatedAt(rs.getTimestamp("created_at"));
						model.setUpdatedAt(rs.getTimestamp("updated_at"));
					} else {
						model = null;
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		
		return model;
	}
}
