package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexaojdbc.SingleConnection;
import com.model.Usercrudjdbcsql;

public class UsercrudjdbcsqlDAO {

	private Connection connection;

	public UsercrudjdbcsqlDAO() {

		connection = SingleConnection.getConnection();
	}

	public void salvar(Usercrudjdbcsql pUser) {

		try {

			String sql = "INSERT INTO usercrudjdbcsql(nome, email) VALUES (?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql); // preparando a declaração do nosso comando de
																			// insert

			insert.setString(1, pUser.getNome());
			insert.setString(2, pUser.getEmail());

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

	public List<Usercrudjdbcsql> listar() throws SQLException {

		List<Usercrudjdbcsql> list = new ArrayList<Usercrudjdbcsql>();

		String sql = "SELECT * FROM usercrudjdbcsql";

		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(sql);

		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {

			Usercrudjdbcsql user = new Usercrudjdbcsql();
			user.setId(result.getInt(("id")));
			user.setEmail(result.getString("email"));
			user.setNome(result.getString("nome"));

			list.add(user);
		}
		return list;
	}
	
	public Usercrudjdbcsql buscar(Integer id) throws SQLException {

		Usercrudjdbcsql user = new Usercrudjdbcsql();
		String sql = "SELECT * FROM usercrudjdbcsql WHERE id = " + id ;
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(sql);

		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {

			user.setId(result.getInt(("id")));
			user.setEmail(result.getString("email"));
			user.setNome(result.getString("nome"));

		}
		return user;
	}
	
	public void atualizar(Usercrudjdbcsql user) {
		
		try {
			
			String update = "UPDATE usercrudjdbcsql SET nome = ? WHERE id = " + user.getId();
			
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, user.getNome()); 
			
			preparedStatement.execute();
			connection.commit();
			
		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace();
		}
	}
	
	public void deletar(Integer id) {
		
		try {
			
			String delete = "DELETE FROM usercrudjdbcsql WHERE id = " + id; 
			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			preparedStatement.execute(); 
			
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
