package RestAssuredAPISample.rest;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
public static void main(String[] args) {

		

		JsonPath js = new JsonPath(DataStore.coursePrice());

		

		

		//print number of courses returned by api

		

		int count = js.getInt("courses.size()");

		

		System.out.println(count);

		

		

		//print purchaseAmount

		

		int amount = js.getInt("dashboard.purchaseAmount");

		

		System.out.println(amount);



		//print title of first course

		

		String title = js.getString("courses.title[1]");

		

		System.out.println(title);

		

		//print all course title and thier respective prices 

		





		for(int i=0; i<count; i++) {

			

			String allcourses = js.getString("courses["+i+"].title");

			

			int allprice = js.getInt("courses["+i+"].price");

			

			System.out.println(allcourses);

			

			System.out.println(allprice);

		}

		

		//print number of copies sold by RPA

		

         for(int i=0; i<count; i++) {

			

			String allcourses = js.getString("courses["+i+"].title");

			

            if (allcourses.equalsIgnoreCase("RPA")) {

            		

            		int copies = js.getInt("courses["+i+"].copies");

            		

            		System.out.println(copies);

            		

            		break;

            }



		}

		

         

         //verify if some all course matches with purchase amount 

         

         

	}



}
	
	


