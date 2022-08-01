package com.sjiang2020.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class JdbcUsingConnection {
	public void jdbcUpdate(Connection conn, String sql, Object... args) {

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			int update = ps.executeUpdate();

			System.out.println(update);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.jdbcCloseResouce(null, ps);
		}

	}


	
	public void jdbcQuery(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);

			}

			rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if (rs.next()) {

				for (int i = 0; i < columnCount; i++) {

					String columnLabel = rsmd.getColumnLabel(i + 1);

					System.out.print(columnLabel + "\t");
				}

				System.out.println();

				for (int i = 0; i < columnCount; i++) {
					Object columnValue = rs.getObject(i + 1);

					System.out.print(columnValue + "\t");

				}
				System.out.println();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.jdbcCloseResouce(null, ps, rs);
		}

	}
	

	

	public <T> T jdbcQuery(Connection conn, Class<T> clazz, String sql, Object... args) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conn.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);

			}

			rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if (rs.next()) {
				@SuppressWarnings("deprecation")
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					Object columnValue = rs.getObject(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}

				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.jdbcCloseResouce(null, ps, rs);
		}

		return null;
	}
	
	
	public <T> List<T> jdbcQueryAll(Connection conn, Class<T> clazz, String sql, Object... args) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conn.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);

			}

			rs = ps.executeQuery();
			
			List<T> list = new ArrayList<>();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if (rs.next()) {
				@SuppressWarnings("deprecation")
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					Object columnValue = rs.getObject(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
					
					list.add(t);
				}

				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.jdbcCloseResouce(null, ps, rs);
		}

		return null;
	}
}
