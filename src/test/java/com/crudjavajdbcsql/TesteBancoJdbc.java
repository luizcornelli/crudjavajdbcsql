package com.crudjavajdbcsql;


import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.model.BeanUserFone;
import com.model.Telefone;
import com.model.Usercrudjdbcsql;

import dao.UsercrudjdbcsqlDAO;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {

		UsercrudjdbcsqlDAO usercrudjdbcsqlDAO = new UsercrudjdbcsqlDAO();
		Usercrudjdbcsql user = new Usercrudjdbcsql();
		
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
	
	@Test
	public void buscar() {
		
		try {
			
			UsercrudjdbcsqlDAO dao = new UsercrudjdbcsqlDAO();
			
			Usercrudjdbcsql user = dao.buscar(4);
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void atualizar() {
		
		try {
			UsercrudjdbcsqlDAO dao = new UsercrudjdbcsqlDAO();
			
			Usercrudjdbcsql user;
			
			user = dao.buscar(4);
			user.setNome("Paulo atualizado");
			
			dao.atualizar(user);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		
		UsercrudjdbcsqlDAO dao = new UsercrudjdbcsqlDAO();
		dao.deletar(1);
		
	}
	
	@Test
	public void insertTelefone() {
			
		UsercrudjdbcsqlDAO dao = new UsercrudjdbcsqlDAO();
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(081) 88889-9999");
		telefone.setTipo("Celular");
		telefone.setUsuario(3);
		
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testCarregaFonesUser() {
		
		UsercrudjdbcsqlDAO dao = new UsercrudjdbcsqlDAO();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(22);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			
			System.out.println(beanUserFone);
		}
	}
}
