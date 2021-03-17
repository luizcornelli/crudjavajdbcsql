package com.crudjavajdbcsql;

import org.junit.Test;

import com.conexaojdbc.SingleConnection;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {

		SingleConnection.getConnection();
	}
}
