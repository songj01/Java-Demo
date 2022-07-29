package com.sjiang2020.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

	public static Connection jdbcConnection() {

		Connection conn = null;

		try {

			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

			Properties properties = new Properties();

			properties.load(is);

			final String url = properties.getProperty("url");
			final String username = properties.getProperty("username");
			final String password = properties.getProperty("password");
			final String driverURL = properties.getProperty("driverURL");

			Class.forName(driverURL);

			conn = DriverManager.getConnection(url, username, password);

			if (conn != null) {
				System.out.println("Database is connected");
			} else {
				System.out.println("Error to connect database!!");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return conn;

	}
	
	public static Connection jdbcConnection(Connection conn) {


		try {

			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

			Properties properties = new Properties();

			properties.load(is);

			final String url = properties.getProperty("url");
			final String username = properties.getProperty("username");
			final String password = properties.getProperty("password");
			final String driverURL = properties.getProperty("driverURL");

			Class.forName(driverURL);

			conn = DriverManager.getConnection(url, username, password);

			if (conn != null) {
				System.out.println("Database is connected");
			} else {
				System.out.println("Error to connect database!!");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return conn;

	}

	public static void jdbcCloseResouce(Connection conn, PreparedStatement ps) {

		try {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void jdbcCloseResouce(Connection conn, PreparedStatement ps, ResultSet rs) {

		try {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
