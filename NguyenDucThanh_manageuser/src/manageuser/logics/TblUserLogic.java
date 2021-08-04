/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * TblUserLogic.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.logics;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.UserInfor;


/**
 * Interface Xử lý logic kiểm tra xem loginName có tồn tại trong database không
 * @author NguyenDucThanh
 *
 */
public interface TblUserLogic {
	/**
	 * Lấy ra user từ database theo loginName nhập vào
	 * @param loginName tên đăng nhập người dùng nhập vào
	 * @return đối tượng TblUser thỏa mãn loginName truyền vào
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	boolean checkExistLogin(String loginName, String password ) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException;
		
	/**
	 * Lấy ra tổng số lượng user
	 * @param groupId
	 * @param groupName
	 * @return tổng số lượng user
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int getTotalUser(int groupId, String groupName) throws SQLException, ClassNotFoundException;
	
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
	List<UserInfor> getListUserInfor(int groupID, String fullName) throws IOException,SQLException,ClassNotFoundException;
}
