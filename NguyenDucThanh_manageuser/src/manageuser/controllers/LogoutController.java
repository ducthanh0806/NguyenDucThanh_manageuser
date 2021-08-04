/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * LogoutController.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.utils.Constant;

/**
 * Controller để xử lý Logout
 * @author NguyenDucThanh
 *
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Khởi tạo LogoutController
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Phương thức xử lý khi Client gọi phương thức get
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy session hiện tại
		HttpSession session = request.getSession();
		//Thực hiện xóa session
		session.invalidate();
		//Chuyển về màn hình ADM001
		response.sendRedirect(Constant.LOGIN);
	}
}