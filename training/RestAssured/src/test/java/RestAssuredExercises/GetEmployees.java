package RestAssuredExercises;
import static io.restassured.RestAssured.*;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;
import RestAssuredModel.Employees;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import java.util.List;

public class GetEmployees extends Employees {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
    private int id = 0;
    List<String> employeesName;
    List<String> employeesAge;
    JsonPath extractor;

    @BeforeSuite
    public void setUp(){
        htmlReporter = new ExtentHtmlReporter("./Reports/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }
    @AfterSuite
    public void tearDown(){
        extent.flush();
    }

    @Test(priority = 1)
    public void GetEmployeesNameAge() {
        try {
            test = extent.createTest("Get Employees Names and Ages");
            System.out.println("Test #1 Get all Names and ages from Employees");
            test.log(Status.INFO, "Starting Test");
            Response response = RestAssured.
                    given().
                    spec(getCommonSpec()).
                    when().
                    get("/employees")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            JsonPath extractor = response.jsonPath();
            employeesName = extractor.get("data.employee_name");
            employeesAge = extractor.get("data.employee_age");

            System.out.println("Getting Employees Names");
            test.log(Status.INFO,"Getting all Names");
            System.out.println("Names: \n");
            for (String e : employeesName) {
                System.out.println(e);
            }
            test.log(Status.INFO,"Getting all Ages");
            System.out.println("Getting Employees Ages");
            System.out.println("\nAges: \n");
            for (String ea : employeesAge) {
                System.out.println(ea);
            }
            test.log(Status.PASS, "All Names and Ages were getting");
        }
        catch (Exception e){
            test.log(Status.FAIL, "Names and Ages couldn't be get " + e);
            Assert.fail();
        }

    }

    @Test(priority = 2)
    public void getFirstAndLastValue(){
        test = extent.createTest("Get First and Last Employee Name and Age");
        System.out.println("Test #1 Get First and Last Employee Name and Age");
        test.log(Status.INFO, "Starting Test");
        Response response = RestAssured.
                given().
                spec(getCommonSpec()).
                when().
                get("/employees")
                .then()
                .statusCode(200)
                .extract()
                .response();
        extractor = response.jsonPath();
        //First and Last Employee Name
        String fName = extractor.get("data.employee_name[0]");
        String lName = extractor.get("data.employee_name[" + (employeesName.size() - 1) + "]");
        //Age
        String fAge = extractor.get("data.employee_age[0]");
        String lAge = extractor.get("data.employee_age[" + (employeesAge.size() - 1) + "]");

        System.out.println("Getting First and Last Employee Name");
        test.log(Status.INFO,"Getting First and Last Employee Name: 1. " + fName + " Last: " + lName);
        System.out.println("First Employee Name: " + fName + " || Last Employee Name : " + lName);

        System.out.println("Getting First and Last Employee Age");
        test.log(Status.INFO,"Getting First and Last Employee Age: 1. " + fAge + " Last: " + lAge);
        System.out.println("First Employee Age: " + fAge + "|| Last Employee Age : " + lAge);
    }

    @Test(priority = 3)
    //Validate that "Airi Satou", "Colleen Hurst" and "Haley Kennedy" are listed in your response when getting all employees records.
    public void infoValidation() {
        try {
            test = extent.createTest("Names are Listed on Employees List");
            test.log(Status.INFO, "Validating Names are listed on Employees List");
            String[] employees = {"Airi Satou", "Colleen Hurst", "Haley Kennedy"};
            System.out.println("Test #2 \n Validate that \"Airi Satou\", \"Colleen Hurst\" and \"Haley Kennedy\" are listed in your response when getting all employees records.");
            given().
                    spec(getCommonSpec()).
                    get("/employees").
                    then().
                    assertThat().
                    statusCode(200).
                    body("data.employee_name", hasItems(employees));
            test.log(Status.PASS, "Names are listed");
        }catch (Exception e){
            test.log(Status.FAIL, e);
            Assert.fail();
        }
    }

    @Test(priority = 4)
    public void NewEmployee(){
        test = extent.createTest("Create a new Employee Record");
        test.log(Status.INFO,"Creating a new Employee");
        System.out.println("Test #3 \n Create a new employee record.");

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
        test.log(Status.INFO, "Getting Status from the JSON");
        String status = response.getBody().path("status");
        test.log(Status.INFO, "Validating Status of the JSON");
        Assert.assertEquals(status, "success");
        id = response.getBody().path("data.id");
        System.out.println("User ID: " + id);
        test.log(Status.PASS, "Employee was created");
    }

    @Test(priority = 5)
    public void employeeUpdate(){
        test = extent.createTest("Updating a Employee Record");
        test.log(Status.INFO, "Updating salary and Age of Rhoana Davidson");
        System.out.println("Test #3 \n Update \"Rhona Davidson\" salary and age values.");
        JSONObject request = new JSONObject();
        request.put("salary", "1300");
        request.put("age", "25");

        Response response =
                given().
                        spec(getCommonSpec()).
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        body(request.toJSONString()).
                        when().
                        put("/update/" + (getUserID(employeesName, "Rhona Davidson")+1)).
                        then().
                        statusCode(200).
                        extract().
                        response();
        test.log(Status.INFO, "Getting Status from the JSON");
        String status = response.getBody().path("status");
        test.log(Status.INFO, "Validating Status of the JSON");
        Assert.assertEquals(status, "success");
        test.log(Status.PASS, "Employee was updated");
    }

    @Test(priority = 6)
    public void userDeletion(){
        test = extent.createTest("Delete a Employee Record");
        test.log(Status.INFO, "Deleting the record before created");
        System.out.println("Test #3 \n Delete the employee record created in step #4.");
        Response response = given().
                spec(getCommonSpec()).
                when().
                delete("/delete/" + id).
                then().
                statusCode(200).
                extract().
                response();
        test.log(Status.INFO, "Getting Status from the JSON");
        String status = response.getBody().path("status");
        test.log(Status.INFO, "Validating Status of the JSON");
        Assert.assertEquals(status, "success");
        test.log(Status.PASS, "Employee was Deleted");
    }

}
