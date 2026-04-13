package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountModel;

/**
 * accountsテーブルを扱うクラス
 */
public class AccountDAO {
	
	/**
	 * emailとpasswordでisDeletedが0のデータを探して返す
	 * 
	 * @param conn
	 * @param model email, password
	 * @return accountデータ
	 */
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
	
	/**
	 * modelにセットされたemail,password,nameの内容でaccountsテーブルに保存する
	 * 
	 * @param conn
	 * @param model email, password, name
	 * @return 正常に実行できたら1,失敗したらエラーコードを返す
	 */
	public int create(Connection conn, AccountModel model) {
		try {
			String sql = "insert into accounts (email, password, name) values (?, ?, ?)";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setString(1, model.getEmail());
				pStmt.setString(2, model.getPassword());
				pStmt.setString(3, model.getName());
				
				pStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return e.getErrorCode();
		}
		
		return 1;
	}
	
	/**
	 * モデルのidのデータをemail,password,nameの内容に更新する
	 * @param conn
	 * @param model id=更新対象のデータのid email,password,name=更新したい内容
	 * @return 正常に更新したら1,失敗したらエラーコードを返す
	 */
	public int update(Connection conn, AccountModel model) {
		try {
			String sql = "update accounts set email=?, password=?, name=? where id=?";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setString(1, model.getEmail());
				pStmt.setString(2, model.getPassword());
				pStmt.setString(3, model.getName());
				pStmt.setInt(4, model.getId());
				
				pStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return e.getErrorCode();
		}
		return 1;
	}
}
