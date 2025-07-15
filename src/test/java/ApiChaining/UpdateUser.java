package ApiChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class UpdateUser {

	@Test
	void test_updateuser(ITestContext iContext) throws JSONException {

		Faker faker = new Faker();

		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "Active");

		String bearerToken = "1edb053a26ce810562adf2d090e645ff5c9f53eed3beaf2e37f6fc0083d8edbb";

		int id = (int) iContext.getAttribute("user_id");
		// Step 1: Send POST request and get Response
		given()
		.header("Authorization", "Bearer " + bearerToken)
		.contentType(ContentType.JSON)
		.pathParam("id", id)
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")

		.then()
		.statusCode(200)
		.log().all();

		
	}
}
