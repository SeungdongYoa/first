package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.BookEntity;

public class BookDAO {

	ConnectionMaker dao; 
	
	
	public BookDAO() {
		super();
	}

	public BookDAO(ConnectionMaker dao){
		
		this.dao = dao; 
		
	}
	
	
	public ArrayList<BookEntity> select(BookEntity entity) {
		// JDBC code를 이용해서 DB처리!!
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookEntity> list = new ArrayList<BookEntity>();
		
		try {
			con = dao.getConnection();
			String sql = "select * from book where b_title like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + entity.getbTitle() + "%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookEntity tmp = new BookEntity();
				tmp.setbTitle(rs.getString("b_title"));
				list.add(tmp);
			}			
		} catch (Exception e) {
			System.out.println(e);	
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);	
			}
		}
		return list;
	}
	
	public int delete(BookEntity entity) {
		// JDBC code를 이용해서 DB처리!!
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dao.getConnection();
			String sql = "delete from book where b_isbn=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getbIsbn());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);	
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);	
			}
		}
		return count;
	}
	
	public int update(BookEntity entity) {
		// JDBC code를 이용해서 DB처리!!
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dao.getConnection();
			String sql = "update book set b_title =? where b_isbn=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getbTitle());
			pstmt.setString(2, entity.getbIsbn());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);	
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);	
			}
		}
		return count;
	}
	
	public int insert(BookEntity entity) {
		// JDBC code를 이용해서 DB처리!!
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dao.getConnection();
			String sql = "insert into book values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getbIsbn());
			pstmt.setString(2, entity.getbTitle());
			pstmt.setString(3, entity.getbAuthor());
			pstmt.setInt(4, entity.getbPrice());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);	
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);	
			}
		}
		return count;
	}
}
