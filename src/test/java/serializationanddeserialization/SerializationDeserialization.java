package serializationanddeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {
		
	//@Test
	void cnvertPojo2Json() throws JsonProcessingException
	{
		//create java object using pojjo classs
		 Students studpojo = new Students();
		 
		 studpojo.setName("nayeem");
		 studpojo.setName("Dhaka");
		 studpojo.setPhone("321321");
		 
		 String[] courseArr = {"java", "C++"};
		 studpojo.setCourse(courseArr);
		 
		 //convert java object ---- json object (serilization)
		 
		 ObjectMapper objectMapper = new ObjectMapper();
		 
		 String jsondata = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studpojo);
		 
		 System.out.println(jsondata);
	} 
	
	
	@Test
	void cnvertJson2Pojo() throws JsonMappingException, JsonProcessingException
	{
		String jsondata="{\r\n"
				+ "  \"name\" : \"Dhaka\",\r\n"
				+ "  \"location\" : null,\r\n"
				+ "  \"phone\" : \"321321\",\r\n"
				+ "  \"course\" : [ \"java\", \"C++\" ]\r\n"
				+ "}";
		
		ObjectMapper stuObject = new ObjectMapper();
		
		Students stupojo = stuObject.readValue(jsondata, Students.class);
		
		 System.out.println("Name: " + stupojo.getName());
	        System.out.println("Location: " + stupojo.getLocation());
	        System.out.println("Phone: " + stupojo.getPhone());
	        System.out.println("Course 1: " + stupojo.getCourse()[0]);  // "java"
	        System.out.println("Course 2: " + stupojo.getCourse()[1]);
	}
	
}
