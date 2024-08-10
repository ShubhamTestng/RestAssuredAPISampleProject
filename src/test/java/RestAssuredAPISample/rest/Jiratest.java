package RestAssuredAPISample.rest;

import static io.restassured.RestAssured.*;



import java.io.File;



import org.testng.Assert;

import org.testng.annotations.Test;



import io.restassured.RestAssured;

import io.restassured.filter.session.SessionFilter;

import io.restassured.path.json.JsonPath;



import static io.restassured.RestAssured.*;



public class Jiratest {

	@Test

	public static void main(String[] args) {

		

		RestAssured.baseURI = "http://localhost:8080/";

		

		//Login Scenario

		

		SessionFilter session = new SessionFilter();

		

		String response = given().header("Content-Type","application/json")

		.body("{ \"username\": \"skulkarni\", \"password\": \"Shubham@@11\" }")

		.log().all()

		.filter(session)

		.when() 

		.post("/rest/auth/1/session")

		.then()

		.extract()

		.response()

		.asString();

		

		// Add comment

		

String expectedMessage = "how are you";		

		

String addComment = given().pathParam("key", "SPP-4")

        .log().all()

        .header("Content-Type", "application/json")

		.body("{\r\n"

				+ "    \"body\": \""+expectedMessage+"\",\r\n"

				+ "    \"visibility\": {\r\n"

				+ "        \"type\": \"role\",\r\n"

				+ "        \"value\": \"Administrators\"\r\n"

				+ "    }\r\n"

				+ "}")

		.filter(session)

		.when()

		.post("rest/api/2/issue/{key}/comment")

		.then()

		.log()

		.all()

		.assertThat()

		.statusCode(201)

		.extract()

		.response()

		.asString();

		

        JsonPath js = new JsonPath(addComment);

        String commentId = js.getString("id");

        

        

		//Add attachment 

		

		given().header("X-Atlassian-Token", "no-check")

		.filter(session)

		.pathParam("key", "SPP-4")

		.header("Content-Type", "multipart/form-data")

		.multiPart("file", new File("json.txt"))

		.when()

		.post("/rest/api/2/issue/{key}/attachments")

		.then()

		.log().all()

		.assertThat().statusCode(200);

		

		

		//Get Issue Details

		

		

		String issueDeatail = given()

		.pathParam("key", "SPP-4")

		.queryParam("fields", "comment")

		.filter(session)

		.log().all()

		.when()

		.get("rest/api/2/issue/{key}")

		.then()

		.log().all()

		.extract()

		.response()

		.asString();

		

		System.out.println("Here is info of issue" + issueDeatail);

		

		JsonPath js1 = new JsonPath(issueDeatail);

		int commentsCount = js1.getInt("fields.comment.comments.size()");

		

		for(int i=0; i<commentsCount; i++) {

			

			String commentIssue = js1.get("fields.comment.comments["+i+"].id").toString();

			

			if(commentIssue.equalsIgnoreCase(commentId)) {

				

				String message = js1.get("fields.comment.comments["+i+"].body").toString();

			    System.out.println(message);

			    Assert.assertEquals(message, expectedMessage);

			    

			}

		}

		

		

	}


}

