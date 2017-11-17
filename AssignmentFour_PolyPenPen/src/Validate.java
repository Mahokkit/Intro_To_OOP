/* Student: Edward Ma
 * Student ID: W0057568
 * OOP Assignment 1
 * Validation class
 */

public class Validate 
{ 	// validating name and numeric input
	public boolean isLatitude(String lat) 
	{
	    String expression = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$"; // the list of ranges
    	return lat.matches(expression); 
	}

	public boolean isLongitude(String lon) 
	{
	    String expression = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$"; // the list of ranges
    	return lon.matches(expression); 
	}
	//http://stackoverflow.com/questions/3518504/regular-expression-for-matching-latitude-longitude-coordinates#18690202
	
	public boolean isWeight(String wei)
	{
		String expression = "^\\d+.+\\d+";
		return wei.matches(expression);
	}
	
	public boolean isNumeric(String num)
	{
		String expression = "^\\d+"; // a short cut for all digit 0 to 9
		return num.matches(expression);
	}
	
}
