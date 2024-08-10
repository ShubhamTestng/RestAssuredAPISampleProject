package RestAssuredAPISample.rest;

import org.testng.annotations.Test;



import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;

import io.restassured.http.Headers;

import io.restassured.http.Method;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

import junit.framework.Assert;

import static org.hamcrest.Matchers.*;



import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;


public class Httpmethods {
	
	@Test
	public void getheaderdetail() throws IOException {

			

		//given - all input details 

		//when - submit api resources, http methods 

		//then - validate the response

		//content of the file to string -> content of file can convert into byte -> byte data to string 

		//post data

		

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		

		String response  = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")

		//.body(DataStore.Addplace()).when().post("maps/api/place/add/json")

				.body(Files.readAllBytes(Paths.get("‪C:\\Users\\wbox62\\eclipse-workspace\\RestAssuresdAPIProject\\GooglePlaceAPIpostmancollection.json")))

				.when().post("maps/api/place/add/json")

		        .then().assertThat().statusCode(200).body("scope", equalTo("APP"))

		        .header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

		    

		System.out.println("And response is " + response );

		

		JsonPath js = new JsonPath(response);

		

		    String placeID = js.getString("place_id");

		    

		    System.out.println("and placeid is" + placeID);

			

		    

		    //update data 

		    

		    

		    given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")

		    .body("{\r\n"

		    		+ "\"place_id\":\""+placeID+ "\",\r\n"

		    		+ "\"address\":\"crystal it park indore\",\r\n"

		    		+ "\"key\":\"qaclick123\"\r\n"

		    		+ "}\r\n"

		    		+"" ).when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

		    		

		    // Get Data

		    

		    given().log().all().queryParam("kay", "qaclick123").queryParam("place_id", placeID)

		    .when().get("maps/api/place/add/json")

		    .then().assertThat().log().all().statusCode(200);

		    
	}
}
