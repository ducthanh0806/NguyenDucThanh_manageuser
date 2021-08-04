/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * TblUserDao.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TblUser;
import manageuser.entities.UserInfor;

/**
 * Interface Xử lý thao tác với bảng tbl_user trong DB
 * @author NguyenDucThanh
 *
 */
public interface TblUserDao {
	/**
	 * Lấy ra user từ database theo loginName nhập vào
	 * @param loginName tên đăng nhập người dùng nhập vào
	 * @return đối tượng TblUser thỏa mãn loginName truyền vào
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TblUser getTblUserByLoginName(String loginName) throws ClassNotFoundException, SQLException;

	/**
	 * Lấy ra tổng số lượng user
	 * @param groupId
	 * @param fullName
	 * @return tổng số lượng user
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int getTotalUser(int groupId, String fullName) throws SQLException, ClassNotFoundException;
	
	/**
	 * Lấy ra list UserInfo
	 * @param offset
	 * @param limit
	 * @param groupID
	 * @param fullName
	 * @param sortType
	 * @param sortByFullName
	 * @param sortByCodeLevel
	 * @param sortByEndDate
	 * @return
	 * @throws IOException,SQLException,ClassNotFoundException
	 */
	public List<UserInfor> getListUserInfor(int groupID, String fullName) throws IOException,SQLException,ClassNotFoundException;
}


