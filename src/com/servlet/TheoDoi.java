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
 * Servlet implementation class HomQua
 */
@WebServlet("/theodoi")
public class TheoDoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheoDoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("ma");
		if(ma==null){
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			long homnay = TuVungUtil.getAllTuVungDays(0).size();
			long homqua = TuVungUtil.getAllTuVungDays(1).size();
			long homkia = TuVungUtil.getAllTuVungDays(2).size();
			long homkiaf = TuVungUtil.getAllTuVungDays(3).size();
			long homkiax = TuVungUtil.getAllTuVungDays(4).size();
			long homkiar = TuVungUtil.getAllTuVungDays(5).size();
			long homkiaj = TuVungUtil.getAllTuVungDays(6).size();
			
			
			request.setAttribute("homnay", homnay + "");
			request.setAttribute("homqua", homqua + "");
			request.setAttribute("homkia", homkia + "");
			request.setAttribute("homkiaf", homkiaf + "");
			request.setAttribute("homkiax", homkiax + "");
			request.setAttribute("homkiar", homkiar + "");
			request.setAttribute("homkiaj", homkiaj + "");
			
			
			
			RequestDispatcher rd=request.getRequestDispatcher("theodoi.jsp");  
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
