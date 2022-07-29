package com.sjiang2020.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.jupiter.api.Test;

public class JdbcTransaction {
	@Test
	public void TransactionEx() {
		Connection conn  = null;

		Savepoint point =null;
		try {
			conn  = JDBCUtils.jdbcConnection();
			conn.setAutoCommit(false);
			JdbcUsingConnection jdbcUsingConnection = new JdbcUsingConnection();
			String sql = "Update contact set tel=? where id = ?";
			jdbcUsingConnection.jdbcUpdate(conn, sql,"1111111", 1);
			
			//point = conn.setSavepoint("point1");
			
			jdbcUsingConnection.jdbcUpdate(conn, sql, "22222222", 2);
			
			System.out.println(10/0);
			
			jdbcUsingConnection.jdbcUpdate(conn, sql, "4444444", 4);
		
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
			//	conn.rollback(point);
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			JDBCUtils.jdbcCloseResouce(conn, null);
		}
		
		
	}

}
