/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * LoginController.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.utils.Constant;
import manageuser.validates.ValidateUser;

/**
 * Controller để xử lý cho màn hình ADM001
 * 
 * @author NguyenDucThanh
 *
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Khởi tạo LoginController
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Phương thức xử lý khi người dùng gọi phương thức get
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// forward đến trang jsp ADM001
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.ADM001_URL);
		    requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// in ra lỗi
			System.out.println("LoginController-doGet-" + e.getMessage());
			// đi đến màn hình lỗi
			response.sendRedirect(Constant.SYSTEM_ERROR + "?type=ER015");
		}
	}

	/**
	 * Phương thức xử lý khi người dùng gọi phương thức post
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				// Lấy loginName từ trang ADM001
				String loginName = request.getParameter(Constant.LOGIN_NAME_STRING);
				// Lấy password từ trang ADM001
				String password = request.getParameter(Constant.PASSWORD);
				List<String> listError = ValidateUser.validateLogin(loginName, password);
				if (listError.isEmpty()) { // nếu không có lỗi
					// Tạo session
					HttpSession session = request.getSession();
					// đưa loginName vào session
					session.setAttribute(Constant.LOGIN_NAME_STRING, loginName);
					// set thời gian inactive tối đa cho 1 sesion
					session.setMaxInactiveInterval(300);
					// chuyển đến màn hình ADM002 
					response.sendRedirect(Constant.LIST_USER);
				} else { // nếu có lỗi
					// hiển thị lỗi lên màn hình
					request.setAttribute(Constant.LIST_ERROR, listError);
					// gửi lại giá trị loginName vừa mới cài đặt
					request.setAttribute(Constant.LOGIN_NAME_STRING, loginName);
					// chuyển về màn hình ADM001
					RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.ADM001_URL);
					requestDispatcher.forward(request, response); 
				}
			} catch(Exception e){
				// in ra lỗi
				System.out.println("LoginController-doPost-" + e.getMessage());
				// đi đến màn hình lỗi
				response.sendRedirect(Constant.SYSTEM_ERROR + "?type=ER015");
			}
	}

}
