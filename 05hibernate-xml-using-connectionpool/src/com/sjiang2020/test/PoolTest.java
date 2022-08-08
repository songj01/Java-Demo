package com.sjiang2020.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolTest {
	@Test
	public void testPool() {
		DataSource ds = new ComboPooledDataSource();
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(conn != null) {
			System.out.println(conn);
		}else {
			System.out.println("DB is not connected!!");
		}
	}

}
