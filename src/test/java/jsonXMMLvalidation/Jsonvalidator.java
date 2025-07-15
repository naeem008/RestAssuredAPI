package jsonXMMLvalidation;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.VoiceStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Jsonvalidator {
	
	@Test
    void jsonvalidation() {
        given()
            .when().get("http://localhost:3000/book")
            .then()
            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("booksSchema.json"));
    }
}
