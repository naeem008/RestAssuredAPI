package ApiChaining;
import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class DeleteUser {
	
	@Test
	void test_deleteUser(ITestContext iContext)
	{
		
		String bearerToken = "1edb053a26ce810562adf2d090e645ff5c9f53eed3beaf2e37f6fc0083d8edbb";
		
		int id = (int) iContext.getAttribute("user_id");
		
		
		given()
		.header("Authorization", "Bearer " + bearerToken)
		
		.pathParam("id", id)
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(204)
		.log().all();
		
		System.out.println("User ID to delete: " + id);

		
	}
	
}
