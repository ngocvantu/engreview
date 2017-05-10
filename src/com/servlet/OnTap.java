package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.TuVungUtil;
import com.object.TuVung;

/**
 * Servlet implementation class OnTap
 */
@WebServlet("/ontap")
public class OnTap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TuVungUtil TuVungUtil = new TuVungUtil();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnTap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain;charset=UTF-8");
		String method = request.getParameter("method");
//		String id = request.getParameter("id");
		System.out.println("method = " + method);
		PrintWriter writer = response.getWriter();
		if(method!= null && method.equals("ontap")){
			
			String data = getNextVocal(0);
			writer.write(data);
		} else {
		RequestDispatcher rd=request.getRequestDispatcher("ontap.jsp");  
		rd.forward(request, response);
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
	
	protected String getNextVocal(int id) {
		TuVung tuVung = TuVungUtil.getTuVungById2(id);
		
		return new String("{\"" + "tuvung" + "\": \"" + tuVung.getTuvung() + "\","
							 
				
				+"}");
	}

}
