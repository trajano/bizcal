package bizcal.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Fredrik Bertilsson
 */
public class DateUtil 
{
	public static Date round2Day(Date date)
		throws Exception
	{
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);		
		return cal.getTime();
	}
	
	public static Date round2Minute(Date date)
		throws Exception
	{
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(date);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	
	public static int getDayOfWeek(Date date)
		throws Exception
	{
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
		
	}
	
	public static String getWeekday(Date date)
		throws Exception
	{
	    DateFormat format = new SimpleDateFormat("EEEEE", Locale.getDefault());
        format.setTimeZone(TimeZone.getDefault());
	    return format.format(date);
	}
	
	public static TimeOfDay getTimeOfDay(Date date)
		throws Exception
	{
		return new TimeOfDay(date.getTime() - round2Day(date).getTime());
	}
	
	public static Date getStartOfWeek(Date date)
		throws Exception
	{
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();		
	}
	
	public static int getYear(Date date) throws Exception
    {
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
        cal.setTime(date);
        return cal.get(Calendar.YEAR);

    }

	public static int getMonth(Date date) throws Exception
    {
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

	public static int getDayOfMonth(Date date) throws Exception
    {
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }
	
	public static Date getDiffDay(Date date, int diff)
		throws Exception
	{
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
        cal.setTime(date);
		cal.add(Calendar.DAY_OF_WEEK, diff);
		return cal.getTime();
	}
	
	public static int getDateDiff(Date date2, Date date1) throws Exception {
		return (int) ((date2.getTime() - date1.getTime()) / 24 / 3600 / 1000);
	}
	
	public static Date setTimeOfDate(Date date, TimeOfDay time)
			throws Exception {
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, time.getHour());
		cal.set(Calendar.MINUTE, time.getMinute());
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();

	}
	
	public static Date round2Week(Date date) throws Exception {
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date round2Month(Date date) throws Exception {
		Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	
	
}
