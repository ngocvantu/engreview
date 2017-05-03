package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateUtil;
import com.model.TuVungUtil;
import com.object.TuVung;

/**
 * Servlet implementation class NhapTuvung
 */
@WebServlet("/nhaptuvung")
public class NhapTuvung extends HttpServlet {
	private static final String UPLOAD_DIRECTORY = "uploadFiles";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhapTuvung() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filePath = "";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		request.getSession().setAttribute("sotuvung",
				TuVungUtil.getAllTuVung().size());

		String tuvung = request.getParameter("tuvung");
		String nghia = request.getParameter("nghia");
		String vidu1 = request.getParameter("vidu1");
		String vidu2 = request.getParameter("vidu2");
		String tuloai = request.getParameter("tuloai");
		String noihoc = request.getParameter("noihoc");
		String tudongnghia = request.getParameter("tudongnghia");
		String tutrainghia = request.getParameter("tutrainghia");
		String ngaynhap = request.getParameter("ngaynhap");
		String ghichu = request.getParameter("ghichu");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
//		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		String uploadPath = getServletContext().getRealPath("")
				+ File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		System.out.println("start");
		try {
			// parses the request's content to extract file data
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
			tuvung = formItems.get(0).getString();
			nghia = formItems.get(1).getString("UTF-8");
			vidu1 = formItems.get(2).getString();
			vidu2 = formItems.get(3).getString();
			tuloai = formItems.get(4).getString();
			noihoc = formItems.get(5).getString();
			tudongnghia = formItems.get(6).getString();
			tutrainghia = formItems.get(7).getString();
			String fileName = new File(formItems.get(10).getName()).getName();
			filePath = uploadPath + File.separator + fileName;
			File storeFile = new File(filePath);
			
			formItems.get(10).write(storeFile);
			
			ghichu = UPLOAD_DIRECTORY + File.separator + fileName;
			if (tuvung != null && nghia != null && !tuvung.equals("")
					&& !nghia.equals("")) {
				TuVung tuVung2 = new TuVung(tuvung, nghia, vidu1, vidu2, tuloai,
						noihoc, tudongnghia, tutrainghia, new Date(), ghichu,
						false, 0);
				// TuVungUtil.addTuVung(tuVung2);

				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(tuVung2);
				session.getTransaction().commit();
				session.close();
				System.out.println("insert thanh cong");

			}
			 
		} catch (Exception ex) {
			request.setAttribute("message",
					"There was an error: " + ex.getMessage());
		}

		
		System.out.println(tuvung);

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

		// rd.forward(request, response);
		response.sendRedirect(request.getContextPath() + "");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
