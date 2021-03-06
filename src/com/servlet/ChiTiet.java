package com.servlet;

import java.io.IOException;
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
 * Servlet implementation class ChiTiet
 */
@WebServlet("/chitiet")
public class ChiTiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TuVungUtil TuVungUtil = new TuVungUtil();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTiet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		String tip  = request.getParameter("tip");
		if(id == null){
			TuVung tuVung = TuVungUtil.getTuVungByOrder(0).get(0);
			request.setAttribute("listTuVung", tuVung);
		} else {
			TuVung tuVung = null;
			if (tip == null || tip.equals("next")){
			 tuVung = TuVungUtil.getTuVungById(Integer.valueOf(id));
			if(tuVung == null){
				  tuVung = TuVungUtil.getTuVungLast();
			}
			} else {
				tuVung = TuVungUtil.getTuVungPrev(Integer.valueOf(id));
				if (tuVung == null) {
					tuVung = TuVungUtil.getTuVungByOrder(0).get(0);
				}
			}
			
			request.setAttribute("listTuVung", tuVung);
		}
		RequestDispatcher rd=request.getRequestDispatcher("chitiet.jsp");  
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
