/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * Common.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import manageuser.dao.TblUserDao;
import manageuser.dao.impl.TblUserDaoImpl;



/**
 * Chứa các hàm common của dự án
 * @author NguyenDucThanh
 *
 */
public class Common {
	
	/**
	 * Thực hiện encrytPassword
	 * @param password: pass cần encrytPassword
	 * @param salt: mã mã thêm vào ở trong database
	 * @return mã đã encrytPassword
	 * @throws NoSuchAlgorithmException, UnsupportedEncodingException
	 */
	public static String encrytPassword(String password, String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String encrytPassword = "";
		try {
			// Khai báo String
			String input = password + salt;
			// Sử dụng thuật toán mã hóa sha-1
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			// Reset messageDigest
			messageDigest.reset();
			 // mã hoá value dưới dạng mảng byte và update vào digest
			messageDigest.update(input.getBytes("utf8"));
			 // Convert mảng byte thành kiểu BigInteger
			BigInteger bigInterger = new BigInteger(1, messageDigest.digest());
			// format giá trị vê kiểu hex 
			encrytPassword = String.format("%x", bigInterger );
			// Trả về String

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println("Common-encrytPass-" + e.getMessage());
			throw e;
		}
		return encrytPassword;
	}
	
	/**
	 * Thực hiện checkPass
	 * @param encrytPass: mã đã encrytPass
	 * @param passData: mã trong DB
	 * @return true nếu giống, false nếu khác
	 */
	public static boolean checkPassword(String encrytPassword, String passData) {
		return encrytPassword.equals(passData);
	}
	
	/**
	 * check login
	 */
	public static boolean checkLogin (HttpSession session) throws SQLException, ClassNotFoundException {
		// khởi tạo biến check
		boolean check = false;
		// nếu không có sesion
		if (session == null) {
			// trẻ về false
			return false;
		}
		try { // nếu tồn tại session
			// lấy ra loginName trong sesion
			String loginName = (String) session.getAttribute(Constant.LOGIN_NAME_STRING);
			// khởi tạo tblUserDao
			TblUserDao tblUserDao = new TblUserDaoImpl();
			// nếu tồn tại loginName
			if (tblUserDao.getTblUserByLoginName(loginName) != null) {
				// trả về true
				check = true;
				}
			} catch (SQLException | ClassNotFoundException e) { // nếu có lỗi
				// in ra lỗi
				System.out.println("Common-checkLogin-" + e.getMessage());
				throw e;
				}
		// trả về biến check
		return check;
		}
}

	

