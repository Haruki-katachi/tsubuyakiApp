package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			+ "a.updated_at, "
			+ "from posts p "
			+ "join accounts a on p.account_id=a.id ";
	public List<PostModel> findAll(Connection conn) {
		List<PostModel> posts = new ArrayList<PostModel>();
		try {
			String sql = baseSQL
					+ "where p.is_deleted=0 "
					+ "order by p.created_at desc";
			
			try(PreparedStatement pStmt =conn.prepareStatement(sql)) {
				try(ResultSet rs = pStmt.executeQuery()) {
					while(rs.next()) {
						PostModel model = new PostModel();
						
						model.setId(rs.getInt("posts.id"));
						model.setAccountId(rs.getInt("posts.account_id"));
						model.setItem(rs.getString("posts.item"));
						model.setToId(rs.getInt("to_id"));
						model.setIsDeleted(rs.getInt("is_deleted"));
						model.setCreatedAt(rs.getTimestamp("created_at"));
						model.setUpdated(rs.getTimestamp("updated_at"));
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
}
