package day1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
Given:
    - Set content type
    - Set cookies
    - Add authentication
    - Add parameters
    - Set headers and other info

When:
    - Send HTTP methods like GET, POST, PUT, DELETE

Then:
    - Validate status codes
    - Extract response body
    - Extract headers, cookies, and other response details
*/

public class HTTPRequests {
	int id;

	 @Test(priority = 1)
	void getUsers() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 2)
	void createUser() {
		HashMap data = new HashMap();

		data.put("name", "nayeem");
		data.put("job", "SQA");

		id = given().contentType(ContentType.JSON).header("x-api-key", "reqres-free-v1").body(data)

				.when()
				.post("https://reqres.in/api/users").jsonPath().getInt("id");

		/*
		 * .then() .statusCode(201) .log().all();
		 */
	}
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap data = new HashMap();

		data.put("name", "Zannatun Nayeem");
		data.put("job", "Sr. SQA");

		given().contentType(ContentType.JSON).header("x-api-key", "reqres-free-v1").body(data)

				.when().put("https://reqres.in/api/users/+id")

				.then()
				.statusCode(200)
				.log().all();
	}

}
