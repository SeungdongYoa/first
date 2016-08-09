package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NaverBookDAO implements ConnectionMaker {
	//없애자 상속!extends BookDAO{// 네이버가 사왔다고 상황설정.

	
	//네이버 환경에 맞게 오러라이딩
	//오버라이딩 지우고!
	//인터페이스 쓰며 다시 오버라이드
	@Override
	public Connection getConnection() throws Exception {
		// naver 환경에 맞는 Database Connection 얻어오는 코드
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/library";
		String id = "javadong";
		String pw = "zprtn124";
		return DriverManager.getConnection(url,id,pw);
		
		// 이후 서비스에서 바꿔야 할 것들이 있다. NaverBookDAO로!
		
	} 

	
	
	
}
