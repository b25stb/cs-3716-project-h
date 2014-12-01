/*
 * Checks values for validity
 */
package grouph;

public class ValueChecker
{
	
	/*
	 * Reads a string and returns if it is an integer or not
	 * @param input The string value we are checking
	 */
	static boolean isInteger(String input)
	{
		try { 
	        Integer.parseInt(input); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	
}
