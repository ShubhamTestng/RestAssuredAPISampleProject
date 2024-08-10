package RestAssuredAPISample.rest;

public class DataStore {

public static String Addplace() {

		

		return "{\r\n"

				+ "  \"location\": {\r\n"

				+ "    \"lat\": -328.383494,\r\n"

				+ "    \"lng\": 33.427362\r\n"

				+ "  },\r\n"

				+ "  \"accuracy\": 22,\r\n"

				+ "  \"name\": \"shubham kulkarni\",\r\n"

				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"

				+ "  \"address\": \"233, south kasba , datta chwok, solapur \",\r\n"

				+ "  \"types\": [\r\n"

				+ "    \"shoe park\",\r\n"

				+ "    \"shop\"\r\n"

				+ "  ],\r\n"

				+ "  \"website\": \"http://google.com\",\r\n"

				+ "  \"language\": \"english-IN\"\r\n"

				+ "}\r\n"

				;

	}

	

	public static String coursePrice() {

		

		return "{\r\n"

				+ "\r\n"

				+ "\"dashboard\": {\r\n"

				+ "\r\n"

				+ "\"purchaseAmount\": 910,\r\n"

				+ "\r\n"

				+ "\"website\": \"rahulshettyacademy.com\"\r\n"

				+ "\r\n"

				+ "},\r\n"

				+ "\r\n"

				+ "\"courses\": [\r\n"

				+ "\r\n"

				+ "{\r\n"

				+ "\r\n"

				+ "\"title\": \"Selenium Python\",\r\n"

				+ "\r\n"

				+ "\"price\": 50,\r\n"

				+ "\r\n"

				+ "\"copies\": 6\r\n"

				+ "\r\n"

				+ "},\r\n"

				+ "\r\n"

				+ "{\r\n"

				+ "\r\n"

				+ "\"title\": \"Cypress\",\r\n"

				+ "\r\n"

				+ "\"price\": 40,\r\n"

				+ "\r\n"

				+ "\"copies\": 4\r\n"

				+ "\r\n"

				+ "},\r\n"

				+ "\r\n"

				+ "{\r\n"

				+ "\r\n"

				+ "\"title\": \"RPA\",\r\n"

				+ "\r\n"

				+ "\"price\": 45,\r\n"

				+ "\r\n"

				+ "\"copies\": 10\r\n"

				+ "\r\n"

				+ "}\r\n"

				+ "\r\n"

				+ "]\r\n"

				+ "\r\n"

				+ "}";

	}

	

	public static String addBook(String isbn, String aisle) {

		

		String payload = "{\r\n"

		+ "\r\n"

		+ "\"name\":\"Learn Appium Automation with Java\",\r\n"

		+ "\"isbn\":\""+isbn+"\",\r\n"

		+ "\"aisle\":\""+aisle+"\",\r\n"

		+ "\"author\":\"John foe\"\r\n"

		+ "}\r\n"

		+ "";

		

		return payload;

	}

	
}
