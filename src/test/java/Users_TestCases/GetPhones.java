package Users_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Data;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class GetPhones {
	
	@Test
		void getPhones() {
		
		
		
		Response res= given()
						.contentType("ContentType.JSON")
				
						.when()	
							.get("https://api.restful-api.dev/objects");
		
		JsonPath jsonpath=res.jsonPath();
		String id=jsonpath.getString("id");
		System.out.println(id);
		Assert.assertNotNull(id);
		
//		String price=res.jsonPath().get("data[3].price").toString();
//		System.out.println(price);
		
		
		JSONArray jsonArray=new JSONArray(res.asString());
		
		for (int i=0;i<jsonArray.length();i++)
		{
			JSONObject jsonObject1=jsonArray.getJSONObject(i);
//			
//			String price1= jsonObject1.get("data").toString();
//			System.out.println(price1);
			
			String value1= jsonObject1.getString("name");	
			String value2="Apple";
//			String price1= jsonObject1.getJSONObject("data").getString("price");	
			
			if (value1.contains(value2)) {
				System.out.println(value1);
			}
			
//			String price1= jsonObject1.get("data").toString();
//			System.out.println(price1);
		}
		
	}
}
