package com.sjiang2020.jdbc;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;



public class JDBCCRUD {

	public Connection jdbcConn() throws SQLException {

		final String url = "jdbc:mysql://localhost:3306/music";
		final String username = "root";
		final String password = "1023";
		Connection conn = DriverManager.getConnection(url, username, password);
		if (conn != null) {
			System.out.println("Database is connected!!");
		}

		return conn;
	}

	public Connection jdbcConnUsingProperties() throws SQLException, IOException {

		InputStream rs = JDBCCRUD.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties p = new Properties();
		p.load(rs);

		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");

		Connection conn = DriverManager.getConnection(url, username, password);

		if (conn != null) {
			System.out.println("Database is connected!!");
		} else {
			System.out.println("Database is not connected!!");
		}

		return conn;
	}

	public void jdbcCreate() throws SQLException, IOException {
		Connection conn = jdbcConnUsingProperties();
		String sql = "create table users(id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, "
				+ " firstName VARCHAR(15) NOT NULL,"
				+ "lastName VARCHAR(15) NOT NULL,"
				+ "employeeID INTEGER NOT NULL,"
				+ "department VARCHAR(20) NOT NULL)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		closeJDBCResource(conn, ps);
	}
	
	public void jdbcInsert() throws SQLException, IOException {
		Connection conn = jdbcConnUsingProperties();

		String sql = "Insert into contact(firstName, lastName, tel) Values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, "Cindy");
		ps.setObject(2, "Jiang");
		ps.setObject(3, "1234561023");

		int execute = ps.executeUpdate();
		
		System.out.println(execute);
		
		closeJDBCResource(conn, ps);

	}
	
	public void jdbcUpdate() throws SQLException, IOException {
		
		Connection conn = jdbcConnUsingProperties();
		
		
		String sql ="Update contact set tel =? where id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "0000000000");
		ps.setInt(2, 4);
		int update = ps.executeUpdate();
		
		
		System.out.println(update);
		
		closeJDBCResource(conn, ps);
		
	}
	
	public void jdbcDelete() throws SQLException, IOException {
		Connection conn = jdbcConnUsingProperties();
		
		String sql="delete from contact where id =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, 3);
		int update = ps.executeUpdate();
		System.out.println(update);
		closeJDBCResource(conn, ps);
	}
	
	
	public void jdbcQuery() throws SQLException, IOException {
		Connection conn = jdbcConnUsingProperties();
		String sql="select * from contact";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		if(rs.next()) {
		
			for(int i = 0; i < rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnLabel(i+1)+ "  ");
				
			}
			System.out.println();
			System.out.println(rs.getObject("id") + "      "+ rs.getObject("firstName") + "      " + rs.getObject("lastName") + "      " + rs.getObject("tel") );

			
		}
		
	
		
		closeJDBCResources(conn, ps, rs);
	}
	

	public void closeJDBCResource(Connection conn, PreparedStatement ps) throws SQLException {
		if (conn != null) {
			conn.close();
		}

		if (ps != null) {
			ps.close();
		}
	}
	

	public void closeJDBCResources(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (conn != null) {
			conn.close();
		}

		if (ps != null) {
			ps.close();
		}
		
		if (rs != null) {
			rs.close();
		}
	}

	public static void main(String[] args) throws SQLException, IOException {
		JDBCCRUD jdbccrud = new JDBCCRUD();
		jdbccrud.jdbcQuery();
	}

}
