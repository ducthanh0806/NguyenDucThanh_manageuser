/**
 * Copyright(C) 2021  Luvina
 * UserInfor.java, 13/05/2021, NguyenDucThanh
 * 
 */
package manageuser.entities;

import java.util.Date;

/**
 * Tạo đối tượng UserInfo
 * @author NguyenDucThanh
 */
public class UserInfor {
	private int userID;
	private String fullName;
	private Date birthday;
	private int groupID;
	private String groupName;
	private String email;
	private String tel;
	private String codeLevel;
	private String nameLevel;
	private Date endDate;
	private String total;
	/**
	 * @return the userID
	 */
	public int getUserId() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserId(int userId) {
		this.userID = userId;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the codeLevel
	 */
	public String getCodeLevel() {
		return codeLevel;
	}
	/**
	 * @param codeLevel the codeLevel to set
	 */
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}
	/**
	 * @return the nameLevel
	 */
	public String getNameLevel() {
		return nameLevel;
	}
	/**
	 * @param nameLevel the nameLevel to set
	 */
	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	/**
	 * @return the groupID
	 */
	public int getGroupId() {
		return groupID;
	}
	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupId(int groupID) {
		this.groupID = groupID;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
