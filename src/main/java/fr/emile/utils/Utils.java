package fr.emile.utils;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class Utils {

// ------------------------------------------------------------------------------------------------
	public static Date addDate(Date date, int nbDay) {

//		Utils.trace(Utils.date2String(date,"dd/MM/yyyy"));
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); // original date
//		System.out.println("now: "  + calendar.getTime());
		
//		Utils.trace(Utils.date2String(calendar.getTime(),"dd/MM/yyyy"));
		calendar.add(Calendar.DATE, nbDay); // Adding 5 days

		
//		System.out.println("After 50 days: "             + calendar.getTime());
//		Utils.trace(Utils.date2String(calendar.getTime(),"dd/MM/yyyy"));

		return calendar.getTime() ; 
	}

	// ------------------------------------------------------------------------------------------------
	public static String date2String(Date date, String dateFormat) {

		String returnValue = "";
		if (date != null)
			returnValue = new SimpleDateFormat(dateFormat).format(date);

		return returnValue;
	}

// ------------------------------------------------------------------------------------------------
	public static String firstToUpper(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();

	}

	public static List<String> JsonFile2List(String filename, String key) {

		return null;
	}

	// -----------------------------------------------------------------------
// fonction random qui renvoie une fonction entre minValue et maxValue
// attention dans le cas de l'utilisation pour indexer un tableau (maxIndex =
// length)
	public static int randInt(int minValue, int maxValue) {
		// minvalue er maxValue inclus
		return (int) (Math.random() * (maxValue + 1 - minValue) + minValue);
	}

	// create date from a string format
	public static Date string2Date(String dateString, String dateFormat) {

		Date returnDate = null;
		try {
			returnDate = new SimpleDateFormat(dateFormat).parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return returnDate;

	}

	// create string from date with format

	// convert SQL date to java Date
	public static Date toJavaDate(java.sql.Date sqlDate) {
		if (sqlDate != null)
			return new Date(sqlDate.getTime());
		return null;
	}

	// convert java Date to SQL date
	public static java.sql.Date toSqlDate(Date myDate) {
		if (myDate != null)
			return new java.sql.Date(myDate.getTime());
		return null;
	}

	public static Date localDate2Date(LocalDate myLocalDate) {
		if (myLocalDate != null)
			return Date.from(myLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return null;
	}

//-------------------------------------------------------------------------------------------------
	public static LocalDate date2localDate(Date myDate) {
		if (myDate != null)
			return myDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return null;
	}

// -------------------------------------------------------------------------------------------------
	public static String stripAccent(String inputString) {
		inputString = Normalizer.normalize(inputString, Normalizer.Form.NFD);
		inputString = inputString.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return inputString;
	}
// display debug information with filename and line number

	public static void trace(String msg) {
		Throwable sys = new Throwable();

		System.out.printf("=>[%s]:%d : %s\n", sys.getStackTrace()[1].getFileName(),
				sys.getStackTrace()[1].getLineNumber(), msg);

	}
}