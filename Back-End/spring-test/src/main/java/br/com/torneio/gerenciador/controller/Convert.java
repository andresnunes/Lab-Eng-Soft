package br.com.torneio.gerenciador.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;



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
	public static Date convertStringToDate(String format, String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(strDate);
		return date;
	}
	
	public static LocalDate convertStringToLocalDate(String format, String strDate) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);		
		return LocalDate.parse(strDate, formatter);
		
	}
	public static String calculaIdade(String format, String strDate) throws ParseException{
		LocalDate dtToday = LocalDate.now();
		LocalDate dtOther = convertStringToLocalDate(format, strDate);
		long idade = (long) (ChronoUnit.DAYS.between(dtOther, dtToday)/(365.25f));
		return ""+idade;
	}
	

	
	
	
	
	
}
