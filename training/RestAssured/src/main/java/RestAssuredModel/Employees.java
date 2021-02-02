package RestAssuredModel;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    public int idUser;
    public String name;

    @BeforeSuite
    public void SetUp(){

    }

    public static RequestSpecification getCommonSpec(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://dummy.restapiexample.com/api/v1/");

        RequestSpecification requestSpec = builder.build();

        return requestSpec;
    }

    public int getUserID(List<String> Names, String name){
        for (int i=0; i<Names.size();i++){
            if (Names.get(i).contains(name)){
                idUser = i;
            }
        }

        return idUser;

    }



}
