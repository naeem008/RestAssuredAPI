package ApiChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONException;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;


public class GetUser {
	
	@Test
	void test_getuser(ITestContext iContext)
	{
		int id = (int) iContext.getAttribute("user_id");
		String bearerToken = "1edb053a26ce810562adf2d090e645ff5c9f53eed3beaf2e37f6fc0083d8edbb";
		
		given()
		.header("Authorization", "Bearer " + bearerToken)
        .contentType(ContentType.JSON)
        .pathParams("id",id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200);
		
		
	}
}
