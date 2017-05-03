package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MacDinh
 */
@WebServlet("/macdinh")
public class MacDinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MacDinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd=request.getRequestDispatcher("macdinh.jsp");  
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String tuloai = request.getParameter("tuloai").trim();
		String noihoc = request.getParameter("noihoc").trim();
		String ghichu = request.getParameter("ghichu").trim();
		
		request.getSession().setAttribute("tuloai", tuloai);
		request.getSession().setAttribute("noihoc", noihoc);
		request.getSession().setAttribute("ghichu", ghichu);
		
		request.setAttribute("daxong", "Successfully install !");
		
		RequestDispatcher rd=request.getRequestDispatcher("macdinh.jsp");  
		rd.forward(request, response);
	}

}
