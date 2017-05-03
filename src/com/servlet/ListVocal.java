package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateUtil;
import com.object.TuVung;

/**
 * Servlet implementation class ListVocal
 */
@WebServlet("/listvocal")
public class ListVocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListVocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asdkgh");
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session =   sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM TuVung");
//		query.setCacheable(false);
		List<TuVung> list = query.list(); 
		session.getTransaction().commit();
		session.close();
		response.setContentType("text/plain;charset=UTF-8");
		
		String data = new String ("{\"name\": \"tunguyen\"}");
		writer.write(data);
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
		
	}

}
