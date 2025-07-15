package ApiChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONException;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;

public class Test_CreatUser {
	
	
	@Test
	void test_createuser(ITestContext iContext) throws JSONException
	{
		  Faker faker = new Faker();

	        JSONObject data = new JSONObject();
	        data.put("name", faker.name().fullName());
	        data.put("gender", "male");
	        data.put("email", faker.internet().emailAddress());
	        data.put("status", "Inactive");

	        String bearerToken = "1edb053a26ce810562adf2d090e645ff5c9f53eed3beaf2e37f6fc0083d8edbb";

	        // Step 1: Send POST request and get Response
	        Response res = given()
	                .header("Authorization", "Bearer " + bearerToken)
	                .contentType(ContentType.JSON)
	                .body(data.toString())
	            .when()
	                .post("https://gorest.co.in/public/v2/users");

	        // Optional: Print raw response for debugging
	        System.out.println("Response Body:\n" + res.getBody().asString());

	        // Step 2: Extract 'id' from the response
	        int id = res.jsonPath().getInt("id");

	        // Step 3: Print the ID
	        System.out.println("Generated ID: " + id);
	        iContext.setAttribute("user_id", id);
	}
}
