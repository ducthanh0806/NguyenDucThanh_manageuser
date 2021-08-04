/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * BaseDao.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.dao;

import java.sql.SQLException;

/**
 * Interface Xử lý thao tác với DB
 * @author NguyenDucThanh
 *
 */

public interface BaseDao {
	/**
	 * Mở kết nối tới database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void openConnection() throws ClassNotFoundException, SQLException;
	
	/**
	 * Đóng kết nối tới database
	 * @throws SQLException
	 * @throws NullPointerException
	 */
	public void closeConnection() throws NullPointerException, SQLException;
}
