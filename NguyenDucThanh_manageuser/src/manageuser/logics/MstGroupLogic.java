/**
 * Copyright(C) 2021  Luvina
 * MstGroupLogic.java, 13/05/2021, NguyenDucThanh
 * 
 */
package manageuser.logics;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstGroup;

/**
 * interface MstGroupLogic
 * @author NguyenDucThanh
 *
 */
public interface MstGroupLogic {
	/**
	 * Lấy ra tất cả các group từ bảng mst_group
	 * @return danh sách tất cả các group
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	List<MstGroup> getAllMstGroup() throws SQLException, ClassNotFoundException;
	
	/**
	 * Lấy ra tất cả các group_name từ bảng mst_group theo group_id
	 * @return tất cả các group_name theo yêu cầu
	 * @throws ClassNotFoundException, SQLException, IOException
	 */
	public String getGroupNameByGroupId (int groupId) throws ClassNotFoundException, SQLException, IOException;
}
