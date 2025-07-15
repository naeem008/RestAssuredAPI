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
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class testHeader {

	@Test
	void getHeaderss() {

		Response res = given()

		.when()
		.get("https://www.google.com/");
		
		//String headervalues = res.getHeader("Content-Type");
		//System.out.println("Header values are :"+   headervalues);
		
		
		     Headers allheaders = res.getHeaders();
		     
		     for(Header header:allheaders)
		     {
		    	 System.out.println(header.getName()+"         "+header.getValue());
		     }
		     
		      
		

	}

}
