/**
 * Copyright(C) 2021  Luvina
 * SystemErrorController.java, 09/05/2021, NguyenDucThanh
 * 
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.properties.ErrorProperties;
import manageuser.utils.Constant;

/**
 * Servlet implementation class SystemErrorController
 * @author NguyenDucThanh
 */
public class SystemErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemErrorController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * Phương thức xử lý khi người dùng gọi phương thức get
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lấy ra mã lỗi
		String type = request.getParameter("type");
		// khởi tạo string error
		String error = "";
		if("ER015".equals(type)) { // nếu là lỗi ER015
			// lấy ra thông báo ER015
			error = ErrorProperties.getKey("ER015");
		}
		// đấy lỗi lên request
		request.setAttribute("error", error);
		// chuyển đến màn hình báo lỗi
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.SYSTEM_ERROR_URL);
		requestDispatcher.forward(request, response);
	}

}
