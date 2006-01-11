package bizcal.swing;

import java.awt.Font;
import java.awt.FontMetrics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.JLabel;

import bizcal.util.TextUtil;


/**
 * @author wmjnkal
 *
*/

public class StringLengthFormater
{

	public static String formatDateString(Date aDate, Font aFont, int aWidth, ArrayList aPatternList)
	throws Exception
	{
		boolean fontFits = false;
		String string = new String();
		if(aPatternList==null)
		{
			aPatternList = new ArrayList();
			aPatternList.add("EEEE");
			aPatternList.add("EEE");
			aPatternList.add("EE");
			aPatternList.add("E");
		}
		FontMetrics currentMetrics = new JLabel().getFontMetrics(aFont);
		DateFormat format = new SimpleDateFormat();		
		
		int i = 0;
		while(!fontFits)
		{
			if(aPatternList.size() > i)
			{
				format = new SimpleDateFormat(aPatternList.
						get(i).toString(), Locale.getDefault());
				string = TextUtil.formatCase(format.format(aDate));
			}
			else
			{
				string = TextUtil.formatCase(format.format(aDate)).substring(0,1);
				fontFits = true;
			}
			if(currentMetrics.stringWidth(string) <= aWidth)
			{
				fontFits = true;
			}
			i++;						
		}	
		return string;
	}
	
	public static String getCommonDateFormat(List aDateList, Font aFont, int aWidth, ArrayList aPatternList)
	throws Exception
	{
		String string = new String();
		int minFormat = 0;
		if(aPatternList==null)
		{
			aPatternList = new ArrayList();
			aPatternList.add("EEEE");
			aPatternList.add("EEE");
			aPatternList.add("EE");
			aPatternList.add("E");
		}
		FontMetrics currentMetrics = new JLabel().getFontMetrics(aFont);
		DateFormat format = new SimpleDateFormat();		
		
		Iterator iter = aDateList.iterator();
		while(iter.hasNext())
		{
			Date date = (Date) iter.next();
			int i = 0;
			boolean fontFits = false;
			while(!fontFits)
			{
				if(aPatternList.size() > i)
				{
					format = new SimpleDateFormat((String) aPatternList.
							get(i), Locale.getDefault());
					string = TextUtil.formatCase(format.format(date));
				}
				else
				{
					string = TextUtil.formatCase(format.format(date)).substring(0,1);
					fontFits = true;
				}
				if(currentMetrics.stringWidth(string) <= aWidth)
				{
					fontFits = true;
					if(i>minFormat)
						minFormat = i;
				}
				i++;						
			}	
		}
		if(minFormat < aPatternList.size())
			return (String) aPatternList.get(minFormat);
		else
			return (String) aPatternList.get(aPatternList.size()-1);
	}
	
	/**
	 * Tries combination of name in the following order:
	 * aName:"Per Anders Svensson"
	 * 1."Per Anders Svensson"
	 * 2."Per A Svensson"
	 * 3."Per A S"
	 * 4."PAS" 
	 * 
	 * @param aName
	 * @param aFont
	 * @param aWidth
	 * @return
	 * @throws Exception
	 */
	public static String formatNameString(String aName, Font aFont, int aWidth)
	throws Exception
	{
		if(aName==null || aName =="")
			return "";
		String string = new String();
		StringTokenizer tok = new StringTokenizer(aName);
		String first = new String();
		String last = new String();
		ArrayList middleList = new ArrayList();
		String middles = new String();
		int noOfNames = tok.countTokens();
		int i = 1;
		while(tok.hasMoreTokens())
		{
			if(i==1)
				first = tok.nextToken();
			else if(i==noOfNames)
				last = tok.nextToken();
			else
				middleList.add(tok.nextToken());
			i++;
		}
		
		FontMetrics currentMetrics = new JLabel().getFontMetrics(aFont);
		
		string = first;
		Iterator iter = middleList.iterator();
		while(iter.hasNext())
			middles = " " + middles + iter.next();
		string = string + middles; 
		string = string + " " + last;
		
		if(currentMetrics.stringWidth(string) <= aWidth)
			return string;
				
		string = first;
		middles = "";
		iter = middleList.iterator();
		while(iter.hasNext())
			middles = " " + middles + ((String)iter.next()).substring(0,1);
		string = string + middles; 
		string = string + " " + last;
		
		if(currentMetrics.stringWidth(string) <= aWidth)
			return string;
		
		string = first;
		middles = "";
		iter = middleList.iterator();
		while(iter.hasNext())
			middles = " " + middles + ((String)iter.next()).substring(0,1);
		string = string + middles; 
		if (last.length() > 0)
			string = string + " " + last.substring(0,1);
		
		if(currentMetrics.stringWidth(string) <= aWidth)
			return string;
		
		string = first.substring(0,1);
		middles = "";
		iter = middleList.iterator();
		while(iter.hasNext())
			middles = middles + ((String)iter.next()).substring(0,1);
		string = string + middles;
		if (last.length() > 0)
			string = string + last.substring(0,1);
		
		if(currentMetrics.stringWidth(string) <= aWidth)
			return string;
		
		string = aName.substring(0,1);
		return string;
	}
}
