package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class testQueryandParameter {
	
	
    //https://reqres.in/api/users?page=2&id=5
	@Test
	void voidtestquryparameter() {
		
		given()
		.header("x-api-key","reqres-free-v1")
		.pathParam("path","users")
		.queryParam("page", 2)
		.queryParam("id",5)
		
		.when()
		.get("https://reqres.in/api/{path}")
		
		.then()
		.statusCode(200);
	
	}
}
