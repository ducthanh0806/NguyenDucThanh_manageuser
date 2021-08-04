/**
 * Copyright(C) 2021  Luvina
 * MstGroupLogic.java, 13/05/2021, NguyenDucThanh
 * 
 */
package manageuser.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.MstGroup;

/**
 * interface MstGroupDao
 * @author NguyenDucThanh
 *
 */
public interface MstGroupDao extends BaseDao{
	/**
	 * Lấy ra tất cả các group từ bảng mst_group
	 * @return danh sách tất cả các group
	 * @throws ClassNotFoundException
	 * @throw SQLException
	 */
	public List<MstGroup> getAllMstGroup() throws ClassNotFoundException, SQLException;
	
	/**
	 * Lấy ra tất cả các group_name từ bảng mst_group theo group_id
	 * @return tất cả các group_name theo yêu cầu
	 * @throws ClassNotFoundException, SQLException, IOException
	 */
	public String getGroupNameByGroupId (int groupId) throws ClassNotFoundException, SQLException, IOException;
}
