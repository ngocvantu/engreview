package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.TuVungUtil;

/**
 * Servlet implementation class Sua
 */
@WebServlet("/sua")
public class Sua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sua() {
        super();
        // TODO Auto-generated constructor stub
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
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id").trim();
		
		String tuvung = request.getParameter("tuvung").trim();
		String nghia = request.getParameter("nghia").trim();
		String vidu1 = request.getParameter("vidu1").trim();
		String vidu2 = request.getParameter("vidu2").trim();
		String tuloai = request.getParameter("tuloai").trim();
		String noihoc = request.getParameter("noihoc").trim();
		String tudongnghia = request.getParameter("tudongnghia").trim();
		String tutrainghia = request.getParameter("tutrainghia").trim();
		String ngaynhap = request.getParameter("ngaynhap").trim();
		String ghichu = request.getParameter("ghichu").trim();
		String dathuoc = request.getParameter("dathuoc").trim();
		String solanon = request.getParameter("solanon").trim();
		
		TuVungUtil.updateTuVung(id, tuvung, nghia, vidu1, vidu2, tuloai, 
				noihoc, tudongnghia, tutrainghia, ngaynhap, ghichu, dathuoc, solanon);
		
		System.out.println("dathuoc = " + dathuoc);
		System.out.println("id = " + id);
		
		response.sendRedirect(request.getContextPath() + "/chitiet?id=" + id);
	}

}
