package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.TuVungUtil;
import com.object.TuVung;

/**
 * Servlet implementation class VietAnh
 */
@WebServlet("/vietanh")
public class VietAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TuVungUtil TuVungUtil = new TuVungUtil();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VietAnh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("ma");
		if(ma==null){
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			List<TuVung> listTuVung = TuVungUtil.getAllTuVungChuaThuoc();
			request.setAttribute("listTuVung", listTuVung);
			RequestDispatcher rd=request.getRequestDispatcher("vietanh.jsp");  
			rd.forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/anhviet.jsp");
		} else if(ma.equals("xoa")) {
			PrintWriter writer = response.getWriter();
			response.setContentType("text/plain;charset=UTF-8");
			String id = request.getParameter("id");
			TuVungUtil.xoa(id);
//			RequestDispatcher rd=request.getRequestDispatcher("anhviet.jsp");  
//			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
