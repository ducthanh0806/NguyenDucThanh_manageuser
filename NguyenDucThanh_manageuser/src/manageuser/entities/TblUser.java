/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * TblUser.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.entities;

/**
 * Chứa các thuộc tính của bảng tbl_user trong db
 * @author NguyenDucThanh
 *
 */
public class TblUser {
	private String loginName, password, salt;
	private int rule;
	
	/*
	 * Hàm tạo mặc định 
	 */
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the rule
	 */
	public int getRule() {
		return rule;
	}
	/**
	 * @param rule the rule to set
	 */
	public void setRule(int rule) {
		this.rule = rule;
	}
	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
}

