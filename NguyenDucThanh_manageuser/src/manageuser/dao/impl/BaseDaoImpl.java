/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * BaseDaoImpl.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import manageuser.dao.BaseDao;
import manageuser.properties.DatabaseProperties;

/**
 * Implement BaseDaoImpl kết nối tới database
 * @author NguyenDucThanh
 *
 */

public class BaseDaoImpl implements BaseDao {
	protected Connection conn = null;
	private String driver = DatabaseProperties.getKey("driver");
	private String url = DatabaseProperties.getKey("url");
	private String username = DatabaseProperties.getKey("username");
	private String password = DatabaseProperties.getKey("password");

	/**
	 * Kết nối kết nối tới database
	 * @throws ClassNotFoundException, SQLException
	 */
	@Override
	public void openConnection() throws ClassNotFoundException, SQLException {
		try {
			// Khai báo class Driver cho SQL
			Class.forName(driver); 
			// Mở kết nối
			conn = DriverManager.getConnection(url, username, password); 
		} catch (ClassNotFoundException | SQLException e) {
			// in ra lỗi
			System.out.println("Common-openConnection-" + e.getMessage());
			throw e;
		}
		
	}

	/**
	 * Đóng kết nối
	 * @throws NullPointerException, SQLException
	 */
	@Override
	public void closeConnection() throws NullPointerException, SQLException {
		try{
			if (conn != null || conn.isClosed()) { // nếu có kết nối
				//Đóng kết nối
				conn.close();
			}
			// in ra lỗi
		} catch (NullPointerException | SQLException e) {
			System.out.println("Common-closeConnection-" + e.getMessage());
			throw e;
		}
		
	}
}
