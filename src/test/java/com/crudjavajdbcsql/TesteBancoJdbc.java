package com.crudjavajdbcsql;

import org.junit.Test;

import com.conexaojdbc.SingleConnection;
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
}
