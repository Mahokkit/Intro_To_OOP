/* Student: Edward Ma
 * Student ID: W0057568
 * OOP Assignment 1
 * Validation class
 */
public class Validate 
{ 	// validating name and numeric input
	public boolean isFullname(String str) 
	{
	    String expression = "^[a-zA-Z\\S][^0-9]+"; // the list of ranges
	    if (str == null) // if they try to enter nothing.
	    {
	    	return true; // if user hit cancel
	    }
	    else
	    {
	    	return str.matches(expression); 
	    }
	}

	public boolean isNumeric(String num)
	{
		String expression = "^[1-2]"; // a short cut for all digit 0 to 9
		if (num == null)
		{
			return false;
		}
		else
		{
			return num.matches(expression);
		}
	}
	
}
