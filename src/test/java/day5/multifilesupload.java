package day5;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class multifilesupload {

		
	@Test
	void fileUpload() {
	    File file1 = new File("C:\\Users\\User\\OneDrive\\Desktop\\API\\Upload File\\Test1.txt");
	    File file2 = new File("C:\\Users\\User\\OneDrive\\Desktop\\API\\Upload File\\Test2.txt");

	    given()
	        .multiPart("files", file1)
	        .multiPart("files", file2)
	        .contentType("multipart/form-data")
	    .when()
	        .post("http://localhost:8080/upload")
	    .then()
	        .statusCode(200)
	        .body("[0].fileName", equalTo("Test1.txt"))
	        .body("[1].fileName", equalTo("Test2.txt"));
	        
	}

 }
