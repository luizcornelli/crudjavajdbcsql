package com.crudjavajdbcsql;


import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.model.Usercrudjdbcsql;

import dao.UsercrudjdbcsqlDAO;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {

		UsercrudjdbcsqlDAO usercrudjdbcsqlDAO = new UsercrudjdbcsqlDAO();
		Usercrudjdbcsql user = new Usercrudjdbcsql();
		
		user.setId(4);
		user.setNome("Paulo");
		user.setEmail("paulo@gmail.com");
		
		usercrudjdbcsqlDAO.salvar(user);
	}
	
	@Test
	public void initListar() {
		
		try {
			
			UsercrudjdbcsqlDAO dao = new UsercrudjdbcsqlDAO();
			
			List<Usercrudjdbcsql> users;
			
			users = dao.listar();
			for (Usercrudjdbcsql user : users) {
				
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
}
