package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.BookEntity;

public  class BookDAO { // naver에 팔기 위해 추상 클래스로~.
//추상 다시 빼고...
	
	//class 내부에서 DB 접속 관련만 띄어내겠다. 리팩토링! 1단계
	/*
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/library";
		String id = "javadong";
		String pw = "zprtn124";
		return DriverManager.getConnection(url,id,pw);
		
	}*/
	
	//NaverBookDAO dao;  // daum이면 DaumBookDAO로 해야 하니;;; 더 안좋아진 케이스
	// 차라리 상속이 나음.  이건 재사용성이 안돼..;; 이건 상속을 굳이 해결하고자!
	// 장점은 네이버측에선 NaverBookDAO가 독립적인 클래스라 좋아.
	// 팔아먹는 측면에선 우리 클래스가 NaverBookDAO로 클래스 명이 바뀌니 안 좋은 케이스.
	// 여튼 이게 4번째 단계
	
	// 인터페이스 이름이 나오는 거야!
	ConnectionMaker dao; // is-a 관계로 클래스명 대신 인터페이스이름으로!
	//해당 클래스끼리 결합도가 낮아짐. 인터페이스가 필요한 이유.
	
	public BookDAO(ConnectionMaker dao){
		//this.dao = new NaverBookDAO();//인터페이스해결이후 얜 해결안되나.. 반드시 클래스명이 나와야해! 음.. 그래도. 객체주입!!!하자.
		this.dao = dao; // <- 인자로 받아서 커넥션 주입해서 사용하는!
		//BookDAO 안에서 다른 클래스 이름이 나오면 상속급의 유사한 정도가 나오는...
		//같이 다녀야하는... 해결하자. 바로 인터페이스로!
	}
	
	
	//public abstract Connection getConnection() throws Exception;
	
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







