package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClientDAO implements ConnectionMaker {

	@Override
	public Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/library";
		String id = "javadong";
		String pw = "zprtn124";
		return DriverManager.getConnection(url,id,pw);
	}

	
}
