package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conexaojdbc.SingleConnection;
import com.model.Usercrudjdbcsql;

public class UsercrudjdbcsqlDAO {

	private Connection connection;

	public UsercrudjdbcsqlDAO() {

		connection = SingleConnection.getConnection();
	}

	public void salvar(Usercrudjdbcsql pUser) {

		try {

			String sql = "INSERT INTO usercrudjdbcsql(id, nome, email) VALUES (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql); // preparando a declaração do nosso comando de insert

			insert.setInt(1, pUser.getId());
			insert.setString(2, pUser.getNome());
			insert.setString(3, pUser.getEmail());

			insert.execute();

			connection.commit();

		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			e.printStackTrace();
		}
	}
}
