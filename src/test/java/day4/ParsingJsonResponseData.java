package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.VoiceStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJsonResponseData {

	// Approach 1
//	@Test
	void testJsonResponse() {

		given()

				.when().get("http://localhost:3000/book")

				.then()

				.statusCode(200).body("[9].title", equalTo("Deep Work"));

	}

	// Approach 2
	//@Test
	void testJsonResponse2() throws JSONException {
		Response response = given()

				.contentType(ContentType.JSON)

				.when().get("http://localhost:3000/books");

		/*
		 * Assert.assertEquals(response.getStatusCode(),200); //
		 * Assert.assertEquals(response.header("Content-Type"),"aa"
		 * 
		 * 
		 * String bookname = response.jsonPath().get("[0].title").toString();
		 * 
		 * Assert.assertEquals(bookname, "The Alchemist");
		 */

		// Json object class

		JSONArray jsonArray = new JSONArray(response.asString());   /// write this code 
		
		boolean status = false;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject book = jsonArray.getJSONObject(i);
			String title = book.getString("title");
			//System.out.println("Book Title: " + title);
			
			if (title.equals("Sword of Honour")) {
				status = true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);

	}
	
	@Test
	void testJsonResponse3() throws JSONException
	{
		Response response = given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/books");
		
		JSONArray jsonArray = new JSONArray(response.asString());
		 
		double totalprice = 0;
		for(int i=0;i<jsonArray.length();i++)
		{
			String price = jsonArray.getJSONObject(i).get("price").toString();
			
			totalprice = totalprice+Double.parseDouble(price);
			
			
			
		}
		System.out.println("Total Price"+ totalprice);
		
		Assert.assertEquals(totalprice, 526);
				
		
	}
	
	void xmldatavalid()
	{
	Response response = given()
		
		.when()
		.get("");
		
		XmlPath xxPath = new XmlPath(response.asString());
		
		    List<String> name =xxPath.getList("Tra");
		    
		    for( String Traverles_name:name)
		    {
		    	
		    }
		
		
		
		
		
	}
	
	
	}
