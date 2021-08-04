/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * TblUserLogicImpl.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.logics.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TblUserDao;
import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.entities.TblUser;
import manageuser.entities.UserInfor;
import manageuser.logics.TblUserLogic;
import manageuser.utils.Common;

/**
 * Implement UserLogic Chứa logic để xử lý login
 * 
 * @author NguyenDucThanh
 *
 */
public class TblUserLogicImpl implements TblUserLogic {

	/**
	 * Kiểm tra loginName và password nhập vào
	 * @param loginName: tên đăng nhập nhập vào
	 * @param password: mật khẩu nhập vào
	 * @return true nếu đúng, false nếu sai
	 */
	@Override
	public boolean checkExistLogin(String loginName, String password) throws IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		boolean check = false;
		try {
			// Khởi tạo đối tượng TblUserDaoImpl
			TblUserDao tblUserDao = new TblUserDaoImpl();
			// Lấy user có login_name trong db == loginName nhập vào
			TblUser user = tblUserDao.getTblUserByLoginName(loginName);
			// nếu tồn tại user thỏa mãn
			if (user != null) {
				// Kiểm tra password có hợp lệ hay không
				String encrytPassword = Common.encrytPassword(password, user.getSalt());
				// nếu password đúng, trả về true
				// nếu password nhập vào bằng password trong DB
				if (Common.checkPassword(encrytPassword, user.getPassword())) {
					// trả về true
					check = true;
				}
			}
		} catch (ClassNotFoundException | IOException | SQLException | NoSuchAlgorithmException e) {
			System.out.println("TblUserLogicImpl-checkExistLogin-" + e.getMessage());
			throw e;
		}
		// Return kết quả
		return check;
	}
	
	/**
	 * getTotalUser Lấy tổng số user
	 */
	public int getTotalUser(int groupId, String fullName) throws SQLException, ClassNotFoundException {
		try {
			// khởi tạo đối tượng TblUserDao
			TblUserDao tblUserDao = new TblUserDaoImpl();
			// trả về tổng số user
			return tblUserDao.getTotalUser(groupId, fullName);
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("TblUserLogicImpl-getTotalUser-" + e.getMessage());
				throw e;
				}
		}
	
	/**
	 * List<UserInfor> Lấy danh sách thông tin user
	 * @throws IOException 
	 */
	public List<UserInfor> getListUserInfor(int groupId, String fullName) throws SQLException, ClassNotFoundException, IOException {
		try {
			TblUserDao tblUserDao = new TblUserDaoImpl();
			List<UserInfor> listUserInfor = new ArrayList<UserInfor>();
			listUserInfor = tblUserDao.getListUserInfor(groupId, fullName);
			//trả về listUser
			return listUserInfor;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("TblUserLogicImpl-getListUsers-" + e.getMessage());
			throw e;
		}
	}
}
