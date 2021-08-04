/**
 * Copyright(C) 2021  Luvina
 * MstGroupEntity.java, 13/05/2021, NguyenDucThanh
 * 
 */
package manageuser.entities;

/**
 * Tạo đối tượng MstGroup
 * @author NguyenDucThanh
 *
 */
public class MstGroup {
	private int groupID;
	private String groupName;
	/**
	 * @return the groupID
	 */
	public int getGroupId() {
		return groupID;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupID = groupId;
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
