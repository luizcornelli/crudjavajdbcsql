package dao;

import java.sql.Connection;

import com.conexaojdbc.SingleConnection;

public class UsercrudjdbcsqlDAO {
	
	private Connection connection; 
	
	public UsercrudjdbcsqlDAO() {
		
		connection = SingleConnection.getConnection();
	}
}
