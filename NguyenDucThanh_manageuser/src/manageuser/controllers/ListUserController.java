package manageuser.controllers;
/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * ListUserController.java, 08/05/2021 NguyenDucThanh
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.entities.MstGroup;
import manageuser.entities.UserInfor;
import manageuser.logics.MstGroupLogic;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Constant;


/**
 * Controller xử lý chuyển đến màn hình ADM002
 * @author NguyenDucThanh
 *
 */
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Khởi tạo ListUserController
     */
    public ListUserController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * Phương thức xử lý khi người dùng gọi phương thức get
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Set giá trị măc định của khung tìm kiếm theo group
			int groupId = Constant.GROUP_ID_DEFAULT;
			// Set giá trị tìm kiếm theo tên mặc định là rỗng
			String fullName = Constant.FULL_NAME_DEFAULT;
			// Khởi tạo đối tượng MstGroupLogic
			MstGroupLogic mstGroupLogic = new MstGroupLogicImpl();
			// Khởi tạo đối tượng tblUserLogic
			TblUserLogic tblUserLogic = new TblUserLogicImpl();
			// lấy tất cả tên MstGroup
			List<MstGroup> listMstGroup = new ArrayList<MstGroup>();
			// lấy tất cả tên MstGroup
			listMstGroup = mstGroupLogic.getAllMstGroup();
			// Khởi tạo đối tượng listUserInfor
			List<UserInfor> listUserInfor = new ArrayList<UserInfor>();
			// lấy ra tống số user
			int totalUser = tblUserLogic.getTotalUser(groupId, fullName);
			if (totalUser > 0) { // nếu có user
				// lấy ra các giá trị cho userInfor
				listUserInfor = tblUserLogic.getListUserInfor(groupId, fullName);
			}
			
			// gửi các giá trị lên request
			request.setAttribute(Constant.LIST_USER_INFOR, listUserInfor);
			request.setAttribute(Constant.LIST_MST_GROUP, listMstGroup);
	            
			// chuyển đến màn hình ADM002
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.ADM002_URL);
			requestDispatcher.forward(request, response);
			} catch (Exception e) {
				// in ra lỗi
				System.out.println("ListUserController-doGet-" + e.getMessage());
				// chuyển đến màn hình lỗi
				response.sendRedirect(Constant.SYSTEM_ERROR + "?type=ER015");
				}
		}
}
