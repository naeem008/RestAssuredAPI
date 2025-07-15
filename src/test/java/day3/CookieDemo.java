package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookieDemo {

	// @Test
	void testCookie() {

		given()

				.when().get("https://www.google.com/").then().statusCode(200).cookie("AEC", "").log().all();

	}

	@Test
	void getCookieinfo()
	{ 
     
		
	Response response =	 given()
		
		
		.when()
		  .get("https://www.google.com/");
		
		// single single cookie
		//String cookString = response.getCookie("AEC");
		//System.out.println("Value of cookie====>"+ cookString );
	
		//get all cookies
	
		Map<String, String> cookies_values = response.getCookies();
		
		for( String k:cookies_values.keySet())
		{
			String cookie_value = response.getCookie(k);
			System.out.println(k+"       "+cookie_value);
		}
		
		
		
	}
}
