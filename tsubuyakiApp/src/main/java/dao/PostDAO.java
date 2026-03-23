package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountModel;
import model.PostModel;

public class PostDAO {
	private String baseSQL = "select "
			+ "p.id, "
			+ "p.account_id, "
			+ "p.item, "
			+ "p.to_id, "
			+ "p.is_deleted, "
			+ "p.created_at, "
			+ "p.updated_at, "
			+ "a.id, "
			+ "a.email, "
			+ "a.password, "
			+ "a.name, "
			+ "a.is_deleted, "
			+ "a.created_at, "
			+ "a.updated_at "
			+ "from posts p "
			+ "join accounts a on p.account_id=a.id ";
	public List<PostModel> findAll(Connection conn) {
		List<PostModel> posts = new ArrayList<PostModel>();
		try {
			String sql = baseSQL
					+ "where p.is_deleted=0 and "
					+ "a.is_deleted=0 "
					+ "order by p.created_at desc";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				try(ResultSet rs = pStmt.executeQuery()) {
					while(rs.next()) {
						PostModel model = new PostModel();
						
						model.setId(rs.getInt("posts.id"));
						model.setAccountId(rs.getInt("posts.account_id"));
						model.setItem(rs.getString("posts.item"));
						model.setToId((Integer)rs.getObject("posts.to_id"));
						model.setIsDeleted(rs.getInt("posts.is_deleted"));
						model.setCreatedAt(rs.getTimestamp("posts.created_at"));
						model.setUpdatedAt(rs.getTimestamp("posts.updated_at"));
						model.setPostUserName(rs.getString("accounts.name"));
						
						posts.add(model);
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		return posts;
	}
	
	public List<PostModel> findByAccountId(Connection conn, PostModel model) {
		List<PostModel> posts = new ArrayList<PostModel>();
		try {
			String sql = baseSQL
					+ "where p.is_deleted=0 and "
					+ "a.is_deleted=0 and "
					+ "p.account_id=? "
					+ "order by p.created_at desc";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				
				pStmt.setInt(1, model.getAccountId());
				
				try(ResultSet rs = pStmt.executeQuery()) {
					while(rs.next()) {
						PostModel model2 = new PostModel();
						
						model2.setId(rs.getInt("posts.id"));
						model2.setAccountId(rs.getInt("posts.account_id"));
						model2.setItem(rs.getString("posts.item"));
						model2.setToId((Integer)rs.getObject("posts.to_id"));
						model2.setIsDeleted(rs.getInt("posts.is_deleted"));
						model2.setCreatedAt(rs.getTimestamp("created_at"));
						model2.setUpdatedAt(rs.getTimestamp("posts.updated_at"));
						model2.setPostUserName(rs.getString("accounts.name"));
						
						posts.add(model2);
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		return posts;
	}
	
	public List<PostModel> findByAccountId(Connection conn, AccountModel model) {
		List<PostModel> posts = new ArrayList<PostModel>();
		try {
			String sql = baseSQL
					+ "where p.is_deleted=0 and "
					+ "a.is_deleted=0 and "
					+ "p.account_id=? "
					+ "order by p.created_at desc";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				
				pStmt.setInt(1, model.getId());
				
				try(ResultSet rs = pStmt.executeQuery()) {
					while(rs.next()) {
						PostModel model2 = new PostModel();
						
						model2.setId(rs.getInt("posts.id"));
						model2.setAccountId(rs.getInt("posts.account_id"));
						model2.setItem(rs.getString("posts.item"));
						model2.setToId((Integer)rs.getObject("posts.to_id"));
						model2.setIsDeleted(rs.getInt("posts.is_deleted"));
						model2.setCreatedAt(rs.getTimestamp("posts.created_at"));
						model2.setUpdatedAt(rs.getTimestamp("posts.updated_at"));
						model2.setPostUserName(rs.getString("accounts.name"));
						
						posts.add(model2);
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		return posts;
	}
	
	public List<PostModel> findByReply(Connection conn, PostModel model) {
		List<PostModel> posts = new ArrayList<PostModel>();
		try {
			String sql = baseSQL
					+ "where p.to_id=? and "
					+ "p.is_deleted=0 and "
					+ "a.is_deleted=0 "
					+ "order by p.created_at desc";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				
				pStmt.setInt(1, model.getId());
				
				try(ResultSet rs = pStmt.executeQuery()) {
					while(rs.next()) {
						PostModel model2 = new PostModel();
						
						model2.setId(rs.getInt("posts.id"));
						model2.setAccountId(rs.getInt("posts.account_id"));
						model2.setItem(rs.getString("posts.item"));
						model2.setToId((Integer)rs.getObject("posts.to_id"));
						model2.setIsDeleted(rs.getInt("posts.is_deleted"));
						model2.setCreatedAt(rs.getTimestamp("posts.created_at"));
						model2.setUpdatedAt(rs.getTimestamp("posts.updated_at"));
						model2.setPostUserName(rs.getString("accounts.name"));
						
						posts.add(model2);
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		return posts;
	}
	
	public List<PostModel> findByAccountIdIsGood(Connection conn, AccountModel model) {
		List<PostModel> posts = new ArrayList<PostModel>();
		try {
			String sql = "select "
					+ "p.id, "
					+ "p.account_id, "
					+ "p.item, "
					+ "p.to_id, "
					+ "p.is_deleted, "
					+ "p.created_at, "
					+ "p.updated_at, "
					+ "a.id, "
					+ "a.email, "
					+ "a.password, "
					+ "a.name, "
					+ "a.is_deleted, "
					+ "a.created_at, "
					+ "a.updated_at, "
					+ "g.id, "
					+ "g.account_id, "
					+ "g.post_id, "
					+ "g.is_good, "
					+ "g.created_at, "
					+ "g.updated_at "
					+ "from posts p "
					+ "join accounts a on p.account_id=a.id "
					+ "left join good_table g on p.id=g.post_id "
					+ "where g.account_id=? and "
					+ "g.is_good=1 and "
					+ "p.is_deleted=0 and "
					+ "a.is_deleted=0 "
					+ "order by g.updated_at desc";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, model.getId());
				
				try(ResultSet rs = pStmt.executeQuery()) {
					while(rs.next()) {
						PostModel model2 = new PostModel();
						
						model2.setId(rs.getInt("posts.id"));
						model2.setAccountId(rs.getInt("posts.account_id"));
						model2.setItem(rs.getString("posts.item"));
						model2.setToId((Integer)rs.getObject("posts.to_id"));
						model2.setIsDeleted(rs.getInt("posts.is_deleted"));
						model2.setCreatedAt(rs.getTimestamp("posts.created_at"));
						model2.setUpdatedAt(rs.getTimestamp("posts.updated_at"));
						model2.setPostUserName(rs.getString("accounts.name"));
						
						posts.add(model2);
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		return posts;
	}
	
	public PostModel findOne(Connection conn, PostModel model) {
		try {
			String sql = baseSQL
					+ "where p.is_deleted=0 and "
					+ "a.is_deleted=0 and "
					+ "p.id=?";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				
				pStmt.setInt(1, model.getId());
				
				try(ResultSet rs = pStmt.executeQuery()) {
					if(rs.next()) {
						model.setId(rs.getInt("posts.id"));
						model.setAccountId(rs.getInt("posts.account_id"));
						model.setItem(rs.getString("posts.item"));
						model.setToId((Integer)rs.getObject("posts.to_id"));
						model.setIsDeleted(rs.getInt("posts.is_deleted"));
						model.setCreatedAt(rs.getTimestamp("posts.created_at"));
						model.setUpdatedAt(rs.getTimestamp("posts.updated_at"));
						model.setPostUserName(rs.getString("accounts.name"));
					} else {
						return null;
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		return model;
	}
	
	public int createPost(Connection conn, PostModel model) {
		try {
			String sql = "insert into posts (account_id, item) values (?, ?)";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, model.getAccountId());
				pStmt.setString(2, model.getItem());
				
				pStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			return e.getErrorCode();
		}
		return 1;
	}
	
	public int createReply(Connection conn, PostModel model) {
		try {
			String sql = "insert into posts (account_id, item, to_id) values (?, ?, ?)";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, model.getAccountId());
				pStmt.setString(2, model.getItem());
				pStmt.setInt(3, model.getToId());
				
				pStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
			 return e.getErrorCode();
		}
		return 1;
	}
	
	public void deletePost(Connection conn, PostModel model) {
		try {
			String sql = "update posts set is_deleted=1 where id=?";
			
			try(PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, model.getId());
				
				pStmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
