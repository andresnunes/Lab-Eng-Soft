package br.com.torneio.gerenciador.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
	
	  public static Iterator sortedIterator(Iterator it, Comparator comparator) {
	      List list = new ArrayList();
	      while (it.hasNext()) {
	          list.add(it.next());
	      }

	      Collections.sort(list, comparator);
	      return list.iterator();
	  }

}
