/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * TblUserDaoImpl.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TblUserDao;
import manageuser.entities.TblUser;
import manageuser.entities.UserInfor;
import manageuser.utils.Constant;

/**
 * Implement TblUserDao lấy ra user trong database theo loginName
 * @author NguyenDucThanh
 *
 */
public class TblUserDaoImpl extends BaseDaoImpl implements TblUserDao {
	/**
	 * Lấy ra user từ database theo loginName nhập vào
	 * @param loginName tên đăng nhập người dùng nhập vào
	 * @return đối tượng TblUser thỏa mãn loginName truyền vào
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public TblUser getTblUserByLoginName (String loginName) throws ClassNotFoundException, SQLException {
		try {
			//Mở kết nối tới db
			openConnection();
			int index = 1;
			////Khởi tạo câu lệnh sql
			StringBuilder sqlQuery = new StringBuilder ("SELECT login_name, password, salt FROM tbl_user ");
			sqlQuery.append("WHERE login_name = ? AND rule = ?");
			//Khởi tạo statement
			PreparedStatement statment = conn.prepareStatement(sqlQuery.toString());
			// set giá trị cho login_name, rule
			statment.setString(index, loginName);
			statment.setInt(++index, Constant.ADMIN);
			//Thực hiện câu lệnh sql
			ResultSet resultSet = statment.executeQuery();
			//Khai báo user làm kết quả trả về
			TblUser user = null;
			//Nếu lấy được kết quả
			if (resultSet.next()) {
				// khởi tạo đối tượng user
				user = new TblUser();
				// set giá trị cho các thuộc tính
				user.setLoginName(resultSet.getString(Constant.LOGIN_NAME));
				user.setPassword(resultSet.getString(Constant.PASSWORD));
				user.setSalt(resultSet.getString(Constant.SALT));
			}
			//Trả về user
			return user;
		} catch (ClassNotFoundException | SQLException e) {
			// in ra lỗi
			System.out.println("TblUserDaoImpl-getTblUserByName-" + e.getMessage());
			throw e;
		} finally {
			//nếu kết nối mở thành công, đóng kết nối sau khi dùng xong
			if (conn != null) {
				closeConnection();
			}
		}
	}
	
	/**
	 * Lấy ra tổng số lượng user
	 * @param groupId group_id trong db
	 * @param fullName full_name trong db
	 * @return tổng số lượng user
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int getTotalUser(int groupId, String fullName) throws SQLException, ClassNotFoundException {
		// khởi tạo biến total = 0
		try {
			// mở kết nối
			openConnection();
			// khởi tạo total
			int total = 0;
			int index = 1;
			// câu lênh sql
			StringBuilder sqlQuery = new StringBuilder("SELECT count(*) FROM tbl_user u ");
			sqlQuery.append("INNER JOIN mst_group g ON u.group_id = g.group_id ");				
			sqlQuery.append("WHERE u.rule = ? ");
			// khởi tạo prepareStatement
			PreparedStatement prepareStatment = conn.prepareStatement(sqlQuery.toString());
			prepareStatment.setInt(index++, Constant.USER);
			// thực thi câu sql 
			ResultSet resultSet = prepareStatment.executeQuery();
			if (resultSet.next()) {
				// lấy tổng số user
				total = resultSet.getInt(1);
			}
			// trả về số user
			return total;
		} catch (SQLException e) {
			// in ra lỗi
			System.out.println("TblUserDaoImpl-getTotalUser-" + e.getMessage());
			throw e;
		} finally {
			// đóng connection
			closeConnection();
		}

	}
	
	/**
	 * Lấy ra list UserInfor
	 * @param offset
	 * @param limit
	 * @param groupId
	 * @param fullName
	 * @param sortType
	 * @param sortByFullName
	 * @param sortByCodeLevel
	 * @param sortByEndDate
	 * @return
	 * @throws IOException,SQLException,ClassNotFoundException
	 */
	public List<UserInfor> getListUserInfor(int groupId, String fullName) throws SQLException, ClassNotFoundException {
		try {
			// mở kết nối
			openConnection();
			// khởi tạo listUserInfor
			List<UserInfor> listUserInfor = new ArrayList<UserInfor>();
			int index = 1;
			// câu lênh sql
			StringBuilder sqlQuery = new StringBuilder("SELECT u.user_id, u.full_name, u.email,");
			sqlQuery.append("u.tel, u.birthday, g.group_name, j.name_level, dj.end_date, dj.total ");
			sqlQuery.append("FROM tbl_user u ");
			sqlQuery.append("JOIN mst_group g ON u.group_id = g.group_id ");
			sqlQuery.append("LEFT JOIN tbl_detail_user_japan dj ON dj.user_id = u.user_id ");
			sqlQuery.append("LEFT JOIN mst_japan j ON j.code_level = dj.code_level ");
			sqlQuery.append("WHERE u.rule = ? ");
			// khởi tạo prepareStatement
			PreparedStatement prepareStatment = conn.prepareStatement(sqlQuery.toString());
			prepareStatment.setInt(index++, Constant.USER);
			// thực thi câu sql 
			ResultSet resultSet = prepareStatment.executeQuery();
			while (resultSet.next()) {
				// khởi tạo userInfor
				UserInfor userInfor = new UserInfor();
				// set các giá trị vào userInfor
				userInfor.setUserId(resultSet.getInt(Constant.USER_ID));
				userInfor.setFullName(resultSet.getString(Constant.FULL_NAME));
				userInfor.setBirthday(resultSet.getDate(Constant.BIRTHDAY));
				userInfor.setGroupName(resultSet.getString(Constant.GROUP_NAME));
				userInfor.setEmail(resultSet.getString(Constant.EMAIL));
				userInfor.setTel(resultSet.getString(Constant.TEL));
				userInfor.setNameLevel(resultSet.getString(Constant.NAME_LEVEL));
				userInfor.setEndDate(resultSet.getDate(Constant.END_DATE));
				userInfor.setTotal(resultSet.getString(Constant.TOTAL));
				listUserInfor.add(userInfor);
			}
			return listUserInfor;
		} catch (SQLException e) {
			// in ra lỗi
			System.out.println("TblUserDaoImpl-getListUserInfor-" + e.getMessage());
			throw e;
		} finally {
			// đóng kết nối
			closeConnection();
		}
	}
}
