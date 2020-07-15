package br.com.torneio.gerenciador.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.torneio.gerenciador.model.Torneio;

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
	
	public static List<Torneio> ordenarTorneioDataBS(Iterable<Torneio> torneios) throws ParseException {


		List<Torneio> torneioSort = new ArrayList<Torneio>() ;
        for(Torneio torneio : torneios) {        	
        	Calendar cal = Convert.convertStringToCalendar("yyyy-MM-dd", torneio.getData_inicio());
    		torneio.setData_inicio(Convert.convertCalendarToString("yyyyMMdd", cal));
        	torneioSort.add(torneio); 
        }
       //BUBBLE SORT        
        for(int i = 0; i<torneioSort.size(); i++){
            for(int j = 0; j<torneioSort.size()-1; j++){
            	int temp = Integer.parseInt(torneioSort.get(j).getData_inicio());
            	int temp2 = Integer.parseInt(torneioSort.get(j+1).getData_inicio()); 
                if(temp > temp2){
                    Torneio aux = torneioSort.get(j);
                    torneioSort.set(j, torneioSort.get(j+1));
                    torneioSort.set(j+1, aux);
                }
            }
        }
        for(Torneio torneio : torneioSort) {     	
            Calendar cal = Convert.convertStringToCalendar("yyyyMMdd", torneio.getData_inicio());
    		torneio.setData_inicio(Convert.convertCalendarToString("dd/MM/yyyy", cal));
        } 
		
		return torneioSort;
			
	}
	
}
