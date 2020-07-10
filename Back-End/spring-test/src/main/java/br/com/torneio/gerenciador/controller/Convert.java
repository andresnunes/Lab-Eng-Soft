package br.com.torneio.gerenciador.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Calendar myDate = Calendar.getInstance();
//System.out.println( Convert.convertCalendarToString( "dd/MM/yyyy", myDate) );
//System.out.println( Convert.convertCalendarToString( "dd/MMM/yyyy", myDate) );
//System.out.println( Convert.convertCalendarToString( "dd/MM HH'h'", myDate) );
public class Convert {
	public static String convertCalendarToString(String format, Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}

	public static Calendar convertStringToCalendar(String format, String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(strDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

}
