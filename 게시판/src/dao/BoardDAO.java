package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.BoardEntity;

public class BoardDAO {

	// database 테이블에 글 내용을 입력하는 method
	public boolean insert(BoardEntity entity){
		boolean result = false;
		
		// database 처리를 위해 JDBC 코드가 나오게 돼요!
		// 기본적으로 JDBC(Java에서 데이터베이스를 핸들링)을 사용하기위해서는
		// 사용하려는 DB에 맞는 Driver class가 필요.
		
		try {
			// 1. Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			// 2. database에 연결
			String id = "web";
			String pw = "web";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url, id, pw);
			// 1. SQL문장을 만들어서 PreparedStatement를 생성
			String sql = "select MAX(articleNum) from Board";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int num = rs.getInt(1)+1;
			
			sql = "insert into board values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  num);
			pstmt.setString(2,  entity.getArticleTitle());
			pstmt.setString(3,  entity.getArticleContent());
			pstmt.setString(4, entity.getArticleWriter());
			pstmt.setString(5, entity.getArticleDate());
			
			// SQL을 실행시켜요! 결과값은 영향을 받은 행의 수
			int count = pstmt.executeUpdate();
			
			if(count == 1){
				result = true;
			}else{
				result = false;
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;		
	}
}
