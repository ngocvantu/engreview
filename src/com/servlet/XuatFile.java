package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.model.TuVungUtil;
import com.object.TuVung;

/**
 * Servlet implementation class XuatFile
 */
@WebServlet("/XuatFile")
public class XuatFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "uploadFiles";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuatFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(getServletContext().getRealPath("")
					+ File.separator + UPLOAD_DIRECTORY + File.separator + "vocal.pdf"));
			document.open();

			List<TuVung> listTuVung = TuVungUtil.getAllTuVung();
			for (TuVung tuVung : listTuVung) {
				PdfPTable table = new PdfPTable(2); 
				float[] columnWidths = {2f, 1f};
//				table.setWidths(columnWidths);
				//cell1
				Paragraph pCell1 = new Paragraph(tuVung.getTuvung() + "\nVD1: " + tuVung.getVidu1() + "\nVD2: " + tuVung.getVidu2());
		        PdfPCell cell1 = new PdfPCell(pCell1);
		        //cell2
		        Paragraph pCell2 = new Paragraph();
	            PdfPCell cell2 = new PdfPCell(pCell2);
	            System.out.println("ghichu: " + tuVung.getGhichu());
	            /**
	             * 
	             * xuat hinh anh
	             */
//	            if (tuVung.getGhichu()!= null && tuVung.getGhichu().toString()!="") {
//	            	String imagePath = "";
//	            	String realPath = getServletContext().getRealPath("")
//							+ File.separator;
//		           	imagePath = getServletContext().getRealPath("")
//							+ File.separator + tuVung.getGhichu();
//		           	if ((!imagePath.equals(realPath))&&(imagePath!="")) {
//		           		File imgFile = new File(imagePath);
//			           	if (imgFile.exists()) {
//			           		Image image2 = Image.getInstance(imagePath);
//				            if (image2!=null) {
//				            	image2.scaleAbsolute(image2.width() * 150f/image2.height(), 150f);
//					            cell2.addElement(image2);
//							}
//			            
//						}
//					}
//		           	
//				}
	             
	            
	            table.addCell(cell1);
	            table.addCell(cell2); 
	            
				document.add(table);
			}
			
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		String filePath = getServletContext().getRealPath("")
		+ File.separator + UPLOAD_DIRECTORY + File.separator + "vocal.pdf";
		File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        
        ServletContext context = getServletContext();
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
     // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close(); 
		
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
