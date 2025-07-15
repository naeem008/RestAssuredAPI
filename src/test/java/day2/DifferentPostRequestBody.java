package day2;

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
public class DifferentPostRequestBody {
	
//	@Test
	void testPostusinghashMap() {
		
		HashMap data = new HashMap();
		
		data.put("name", "Nayeem");
		data.put("location", "Bangladesh");
		data.put("Phone", "01685726097");
	//	data.put("Bank Account","2132132");
		
		String coursearr[] = {"java", "c++"};
		
		data.put("courses", coursearr);
		
		given()
			.contentType(ContentType.JSON)
			.body(data)
		.when()
		.post("http://localhost:3000/students")
		
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Nayeem"))
		.body("location",equalTo("Bangladesh"))
		.body("Phone", equalTo("01685726097"))
	//	.body("`Bank Account`", equalTo("2132132")) 
		.body("courses", hasItems("java", "c++"))
		.log().all();

		

		
		
		
}
	
	///post request body using org.json library

//@Test
void testPostUsingJsonLibrary() throws JSONException {
    JSONObject data = new JSONObject();
    data.put("name", "Jsonobject");
    data.put("location", "Dhaka");
    data.put("phone", "3132221321321");

    String coursearr[] = {"Automation", "Manual"};
    data.put("courses", coursearr);

    given()
        .contentType(ContentType.JSON)
        .body(data.toString()) // ✅ FIXED: Convert JSONObject to String
    .when()
        .post("http://localhost:3000/students")
    .then()
        .statusCode(201)
        .body("name", equalTo("Jsonobject"))
        .body("location", equalTo("Dhaka"))
        .body("phone", equalTo("3132221321321"))
        .body("courses", hasItems("Automation", "Manual"))
        .log().all();
}

//@Test
void testPostUsingPojo() throws JSONException{
    
	Pojo_PostRequest data = new Pojo_PostRequest();
	
	data.setName("fdfsfdsfsdf");
	data.setLocation("Mohammadpur");
	data.setPhone("01685726097");
	String corsearr[]= {"SOC", "ACT"};
	
	data.setCourse(corsearr);
	
	

    given()
        .contentType(ContentType.JSON)
        .body(data)
    .when()
        .post("http://localhost:3000/students")
    .then()
        .statusCode(201)
        .body("name", equalTo("fdfsfdsfsdf"))
        .body("location", equalTo("Mohammadpur"))
        .body("phone", equalTo("01685726097"))
        .body("course[0]",equalTo("SOC"))
        .body("course[1]",equalTo("ACT"))
        .log().all();
}
 //using external json file
@Test
void testPostUsingExternalFile() throws JSONException, FileNotFoundException {
    
	File file = new File(".\\body.json");
	FileReader fileReader = new FileReader(file);
	
	JSONTokener jsonTokener = new JSONTokener(fileReader);
	
	JSONObject data = new JSONObject(jsonTokener);
	
	
	
	

    given()
        .contentType(ContentType.JSON)
        .body(data.toString())
    .when()
        .post("http://localhost:3000/students")
    .then()
        .statusCode(201)
        .body("name", equalTo("Zannatun Nayeem"))
        .body("location", equalTo("Bangladesh"))
        .body("phone", equalTo("01685726097"))
        .body("courses[0]",equalTo("Java"))
        .body("courses[1]",equalTo("Selenium"))
        .log().all();
}
}
