/**
 * Copyright(C) 2021  Luvina
 * MstGroupDaoImpl.java, 13/05/2021, NguyenDucThanh
 * 
 */
package manageuser.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.MstGroupDao;
import manageuser.entities.MstGroup;
import manageuser.utils.Constant;

/**
 * MstGroupDaoImpl thực hiện truy vấn đến table MstGroup trong DB
 * @author NguyenDucThanh
 *
 */
public class MstGroupDaoImpl extends BaseDaoImpl implements MstGroupDao {
	public List<MstGroup> getAllMstGroup() throws ClassNotFoundException, SQLException {
		// khởi tạo listGroup
		List<MstGroup> listMstGroup = new ArrayList<MstGroup>();
		try {
			// câu truy vấn sql
			String sqlQuery = "select * from mst_group";
			// mở kết nối
			openConnection();
			// khởi tạo preparestatement
			PreparedStatement prepareStatement = conn.prepareStatement(sqlQuery);
			ResultSet resultSet = prepareStatement.executeQuery();
			// thực hiện câu truy vấn trả về thể hiện của đối tượng MstGroup
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				// khởi tạo đối tượng MstGroup
				MstGroup mstGroup = new MstGroup();
				// set giá trị cho group_id
				mstGroup.setGroupId(resultSet.getInt(Constant.GROUP_ID));
				// set giá trị cho group_name
				mstGroup.setGroupName(resultSet.getString(Constant.GROUP_NAME));
				// thêm đối tượng group vào listgroup
				listMstGroup.add(mstGroup);
			}
			return listMstGroup;// trả về listMstGroup
			// nếu ngoại lệ
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(" MstGroupDaoImpl-getAllMstGroup-" + e.getMessage());;// ghi lỗi
			throw e;// ném ngoại lệ
		} finally {
			closeConnection();// đóng kết nối
		}
	}
	
	/**
	 * Lấy ra tất cả các group_name từ bảng mst_group theo group_id
	 * @return tất cả các group_name theo yêu cầu
	 * @throws ClassNotFoundException, SQLException, IOException
	 */
	public String getGroupNameByGroupId (int groupId) throws ClassNotFoundException, SQLException, IOException { 
		try {
			// khởi tạo groupName
			String groupName = null;
			// mở kết nối
			openConnection();
			// câu lệnh sql
			String selectQuery = "select mg.group_name from mst_group mg where mg.group_id = ?"; 
			// khởi tạo preparestatement
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			// khởi tạo index=0
			int index = 0; 
			// set giá trị group_id được xét
			ps.setInt(++index, groupId); 
			// thực thi câu lệnh sql
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				// lấy ra group_name thỏa mãn
				groupName = rs.getString(Constant.GROUP_NAME);
				}
			// trả về group_name
			return groupName; 
		} catch (Exception e) { // nếu có lỗi
			// ghi ra lỗi
			System.out.println("MstGroupDao Impl_getGroupNameByGroupId_" + e.getMessage());
			throw e; 
			} finally {
				// đóng kết nối
				closeConnection();
				}
		}
}
