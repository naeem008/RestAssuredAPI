package jsonXMMLvalidation;

import javax.annotation.meta.When;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;

public class XMLSchemaValidation {
	
	@Test
	void xmlvalidation()
	{
		
		given()
			
		.when()
			.get("http://localhost:3000/students")
			
		
		.then()
		.assertThat().and().body(RestAssuredMatchers.matchesXsdInClasspath("students.xsd"));
		
		
	}
}
