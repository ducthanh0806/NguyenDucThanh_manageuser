/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * ValidateUser.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.validates;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.properties.ErrorProperties;
import manageuser.utils.Constant;


/**
 * Validate User
 * @author NguyenDucThanh
 *
 */
public class ValidateUser {
	/**
	 * Validate giá trị LoginName và password của user
	 * @param loginName tên đăng nhập người dùng nhập vào
	 * @param password  mật khẩu người fung nhập vào
	 * @return danh sách mã lỗi
	 * @throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException
	 */
	public static List<String> validateLogin(String loginName, String password) throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		TblUserLogic tblUserLogicImpl = new TblUserLogicImpl();
		List<String> listError = new ArrayList<>();
		// check login name
		if ("".equals(loginName)) { // nếu chưa nhập login name
			// thêm lỗi vào list error
			listError.add(ErrorProperties.getKey(Constant.ER001_LOGINNAME));
		}
		// check password
		if ("".equals(password)) { // nếu chưa nhập password
			// thêm lỗi vào list error
			listError.add(ErrorProperties.getKey(Constant.ER001_PASSWORD));
		}
		try {
			// nếu đã nhập loginName hoặc password 
			if (!"".equals(loginName) && !"".equals(password)) {
				// nếu nhập sai loginName hoặc password 
				if (!tblUserLogicImpl.checkExistLogin(loginName, password)) {
					// thêm lỗi vào list error
					listError.add(ErrorProperties.getKey(Constant.ER016));
				}
			}
		} catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// in ra lỗi
			System.out.println("ValidateUser-validateLogin-" + e.getMessage());
			throw e;
		}
		return listError;
	}
}
