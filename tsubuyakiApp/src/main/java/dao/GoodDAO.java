package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountModel;
import model.GoodModel;
import model.PostModel;

public class GoodDAO {
	
	public GoodModel findOne(Connection conn, AccountModel model, PostModel model2) {
		GoodModel good = new GoodModel();
		try {
			String sql = "select * from good_table where account_id=? and post_id=?";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, model.getId());
				pStmt.setInt(2, model2.getId());
				
				try(ResultSet rs = pStmt.executeQuery()) {
					if(rs.next()) {
						good.setId(rs.getInt("id"));
						good.setAccountId(rs.getInt("account_id"));
						good.setPostId(rs.getInt("post_id"));
						good.setIsGood(rs.getInt("is_good"));
						good.setCreatedAt(rs.getTimestamp("created_at"));
						good.setUpdatedAt(rs.getTimestamp("updated_at"));
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return good;
	}
	
	public GoodModel findOne(Connection conn, int accountId, int postId) {
		GoodModel good = new GoodModel();
		try {
			String sql = "select * from good_table where account_id=? and post_id=?";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, accountId);
				pStmt.setInt(2, postId);
				
				try(ResultSet rs = pStmt.executeQuery()) {
					if(rs.next()) {
						good.setId(rs.getInt("id"));
						good.setAccountId(rs.getInt("account_id"));
						good.setPostId(rs.getInt("post_id"));
						good.setIsGood(rs.getInt("is_good"));
						good.setCreatedAt(rs.getTimestamp("created_at"));
						good.setUpdatedAt(rs.getTimestamp("updated_at"));
					} else {
						return null;
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		return good;
	}
	
	public int goodCount(Connection conn, int postId) {
		int goodCount = 0;
		try {
			String sql = "select count(*) from good_table where post_id=? and is_good=1";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, postId);
				
				try(ResultSet rs = pStmt.executeQuery()) {
					if(rs.next()) {
						goodCount = rs.getInt("count(*)");
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return 0;
		}
		return goodCount;
	}
	
	public int create(Connection conn, int accountId, int postId) {
		try {
			String sql = "insert into good_table (account_id, post_id, is_good) values (?, ?, 1)";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, accountId);
				pStmt.setInt(2, postId);
				
				pStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return e.getErrorCode();
		}
		return 1;
	}
	
	public int update(Connection conn, GoodModel model) {
		try {
			String sql = "update good_table set "
					+ "is_good=? "
					+ "where "
					+ "account_id=? and "
					+ "post_id=?";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, model.getIsGood());
				pStmt.setInt(2, model.getAccountId());
				pStmt.setInt(3, model.getPostId());
				
				pStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return e.getErrorCode();
		}
		return 1;
	}
}
