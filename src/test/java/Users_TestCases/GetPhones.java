package Users_TestCases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GetPhones {

    @Test
    void getPhones() {

        Response res = given()
                .contentType("ContentType.JSON")

                .when()
                .get("https://api.restful-api.dev/objects");

        JsonPath jsonpath = res.jsonPath();
        String id = jsonpath.getString("id");
        System.out.println(id);

        //Validate that id is not null.
        Assert.assertNotNull(id);

        String price = res.jsonPath().get("data.price").toString();
        System.out.println(price);

        JSONArray jsonArray = new JSONArray(res.asString());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

            String value1 = jsonObject1.getString("name");
            String value2 = "Apple";

            //get All Phones starting with value Apple.
            if (value1.contains(value2)) {
                System.out.println(value1);
            }
        }
    }
}