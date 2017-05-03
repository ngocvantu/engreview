package com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tunguyen
 *
 */
public class DateUtil {
	
	
	/**
	 * tra ve so ngay khac biet
	 * @param date1_
	 * @param today_
	 * @return
	 */
	public static long dateDiff(Date date1_, Date today_) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		long diff = today_.getTime() - date1_.getTime(); 
		long diffDays = diff / (24 * 60 * 60 * 1000);
		return diffDays;
	}
	
	public static long dateStringDiff(String date1, String today) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date d1 = null;
		Date d2 = null;
		long diffDays = 0;
			try {
				d1 = format.parse(date1);
				d2 = format.parse(today);
				long diff = d2.getTime() - d1.getTime();
			    diffDays = diff / (24 * 60 * 60 * 1000);
				 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return diffDays;
	}

	public static void main(String[] args) { 
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(format.format(date));
		String dateStart = "01/14/2012 00:00:00.0";
		String dateStop = "02/14/2012 00:00:00.0";

		//HH converts hour in 24 hours format (0-23), day calculation
		

		Date d1 = null;
		Date d2 = null;

			try {
				d1 = format.parse(dateStart);
				d2 = format.parse(dateStop);
				
				
				System.out.println(DateUtil.dateStringDiff(dateStart, dateStop));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

}
