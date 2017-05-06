package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateUtil;
import com.model.TuVungUtil;
import com.object.TuVung;

/**
 * Servlet implementation class Sua
 */
@WebServlet("/sua")
public class Sua extends HttpServlet { 
	public String UPLOAD_DIRECTORY1 = "uploadFiles";
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
		String filePath = "";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id").trim();
		
		String tuvung;
		String nghia;
		String vidu1 ;
		String vidu2 ;
		String tuloai ;
		String noihoc;
		String tudongnghia;
		String tutrainghia ;
		String ngaynhap;
		String ghichu ;
		String dathuoc  ="";
		String solanon ;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
//		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		String uploadPath = getServletContext().getRealPath("")
				+ File.separator + UPLOAD_DIRECTORY1;
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
			ngaynhap = formItems.get(8).getString();
			String filecu = getServletContext().getRealPath("")
					 + formItems.get(9).getString();
			dathuoc = formItems.get(10).getString();
			File filecucu = new File(filecu);
			System.out.println("file cu" + filecu);
			filecucu.deleteOnExit();
			System.out.println("deleted");
			
			solanon = formItems.get(11).getString();
			String fileName = new File(formItems.get(12).getName()).getName();
			filePath = uploadPath + File.separator + fileName;
			File storeFile = new File(filePath);
			
			
			formItems.get(12).write(storeFile);
			
			ghichu = UPLOAD_DIRECTORY1 + File.separator + fileName;
			if (tuvung != null && nghia != null && !tuvung.equals("")
					&& !nghia.equals("")) {
				TuVung tuVung2 = new TuVung(tuvung, nghia, vidu1, vidu2, tuloai,
						noihoc, tudongnghia, tutrainghia, new Date(), ghichu,
						false, 0);
				// TuVungUtil.addTuVung(tuVung2);
				
				
				TuVungUtil.updateTuVung(id, tuvung, nghia, vidu1, vidu2, tuloai, 
						noihoc, tudongnghia, tutrainghia, ngaynhap, ghichu, dathuoc, solanon);
 
				System.out.println("insert thanh cong");

			}
			 
		} catch (Exception ex) {
			request.setAttribute("message",
					"There was an error: " + ex.getMessage());
		}
		
		
		
		System.out.println("dathuoc = " + dathuoc);
		System.out.println("id = " + id);
		
		response.sendRedirect(request.getContextPath() + "/chitiet?id=" + id);
	}

}
