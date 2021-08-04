/**
 * Copyright(C) 2021  Luvina
 * MstGroupLogicImpl.java, 13/05/2021, NguyenDucThanh
 * 
 */
package manageuser.logics.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import manageuser.dao.MstGroupDao;
import manageuser.dao.impl.MstGroupDaoImpl;
import manageuser.entities.MstGroup;
import manageuser.logics.MstGroupLogic;

/**
 * Implement MstGroupLogicImpl Xử lý logic của bảng mst_group
 * 
 * @author NguyenDucThanh
 *
 */
public class MstGroupLogicImpl implements MstGroupLogic{
	/**
	 * Lấy ra tất cả các group từ bảng mst_group
	 * @return danh sách tất cả các group
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<MstGroup> getAllMstGroup() throws ClassNotFoundException, SQLException {
		try {
			// Khởi tạo đối tượng MstGroupDaoImpl
			MstGroupDao mstGroup = new MstGroupDaoImpl();
			// Trả về danh sách group trong bảng mst_group
			return mstGroup.getAllMstGroup();
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("MstGroupLogicImpl-getAllMstGroup-" + e.getMessage());
				throw e;
				}
		}
	
	/**
	 * Lấy ra tất cả các group_name từ bảng mst_group theo group_id
	 * @return tất cả các group_name theo yêu cầu
	 * @throws ClassNotFoundException, SQLException, IOException
	 */
	public String getGroupNameByGroupId (int groupId) throws ClassNotFoundException, SQLException, IOException {
		try {
			// Khởi tạo đối tượng MstGroupDaoImpl
			MstGroupDao mstGroup = new MstGroupDaoImpl();
			// Trả về danh sách group trong bảng mst_group
			return mstGroup.getGroupNameByGroupId(groupId);
			} catch (Exception e) { // nếu có lỗi
				// in ra lỗi
				System.out.println("MstGroupLogicImpl-getGroupNameByGroupId-" + e.getMessage());
				throw e;
			}
	}
}
