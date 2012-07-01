package uk.co.jarofgreen.phonenumbersindnsandroid.lib;

import java.util.StringTokenizer;


public class Result {

	
	public static Result parse(String text) throws ResultParseException {
		
		if (text.substring(0, 8).compareTo("v=phone1") == 0) {
		
			text = text.substring(8);
			
			StringTokenizer st = new StringTokenizer(text, " ");
			
			if (st.countTokens() >= 2) {
				
				String countryCode;
				String number;
				String description;
				
				countryCode = st.nextToken();
				number = st.nextToken();
				description = st.nextToken();
				while(st.hasMoreTokens()) { 
					description = description + " " + st.nextToken();
				}
				
				// TODO check countryCode and number are valid, return null if not.
				
				return new Result(countryCode, number, description);
				
			}
		}
		
		throw new ResultParseException();
		
	}
	
	private String countryCode;
	private String number;
	private String description;
	
	
	public Result(String countryCode, String number, String description) {
		super();
		this.countryCode = countryCode;
		this.number = number;
		this.description = description;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public String getNumber() {
		return number;
	}


	public String getDescription() {
		return description;
	}
	

	
	
}
