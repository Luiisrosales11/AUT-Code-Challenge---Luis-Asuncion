package RestAssuredExercises;
import static io.restassured.RestAssured.*;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

import RestAssuredModel.CharactersInfo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GetEmployees {

    private int id = 0;

    static RequestSpecification getCommonSpec(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://dummy.restapiexample.com/api/v1/");

        RequestSpecification requestSpec = builder.build();

        return requestSpec;

    }

    @Test(priority = 1)
    public void GetEmployeesNameAge() {
         
        Response response = RestAssured.
                given().
                spec(getCommonSpec()).
                when().
                get("/employees");
        Assert.assertEquals(response.getStatusCode(),200);


        JsonPath extractor = response.jsonPath();
        List<String> employeesName =  extractor.get("data.employee_name");

        List<String> employeesAge = extractor.get("data.employee_age");

        //Using RestAssured
        //Name
        String fName = extractor.get("data.employee_name[0]");
        String lName = extractor.get("data.employee_name[" + (employeesName.size()-1) +"]");

        //Age
        String fAge = extractor.get("data.employee_age[0]");
        String lAge = extractor.get("data.employee_age["+(employeesAge.size()-1) +"]");

        System.out.println("First Employee Name: " + fName + "|| Last Employee Name : " + lName);
        System.out.println("First Employee Age: " + fAge + "|| Last Employee Age : " + lAge);

        System.out.println("Names: \n");
        for (String e: employeesName){
            System.out.println(e);
        }

        System.out.println("Ages: \n");
        for (String ea: employeesAge){
            System.out.println(ea);
        }
    }

    @Test(priority = 2)

    //Validate that "Airi Satou", "Colleen Hurst" and "Haley Kennedy" are listed in your response when getting all employees records.
    public void infoValidation(){
        given().
                spec(getCommonSpec()).
                get("/employees").
                then().
                statusCode(200).
                assertThat().
                body("data.employee_name", hasItems("Airi Satou", "Colleen Hurst", "Haley Kennedy"));
    }

    @Test(priority = 3)
    public void NewEmployee(){
        JSONObject request = new JSONObject();
        request.put("name", "Luis");
        request.put("salary", "1300");
        request.put("age", "25");
        Response response =
        given().
            spec(getCommonSpec()).
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("/create").
        then().
            statusCode(200).
            extract().
            response();
        response.getBody().prettyPrint();
        id = response.getBody().path("data.id");
        System.out.println("User ID: " + id);
    }

    @Test(priority = 4)
    public void employeeUpdate(){
        JSONObject request = new JSONObject();
        request.put("salary", "1300");
        request.put("age", "25");

        /*int idRhoana = given().spec(getCommonSpec()).when().get("/employees").then().extract().path("data.employee_name")*/
        Response response =
                given().
                        spec(getCommonSpec()).
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        body(request.toJSONString()).
                        when().
                        put("/update/8") .
                        then().
                        statusCode(200).
                        extract().
                        response();
        response.getBody().prettyPrint();
    }

    @Test(priority = 5)
    public void userDeletion(){
        Response response = given().
                spec(getCommonSpec()).
                when().
                delete("/delete/" + id).
                then().
                statusCode(200).
                extract().
                response();

        response.getBody().prettyPrint();
    }

}
