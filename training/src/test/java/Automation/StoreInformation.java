package Automation;

import Commands.Commands;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreInformation extends BaseTest{
    Commands commands = null;

    @BeforeClass
    public void beforeClass(){
        commands = new Commands(driver);
    }

    @Test(priority = 1, groups = "StoreInfo")
    public void StoreInformationValidation() {
        try {
            commands.ScrollToASection();
            String location = "Selenium Framework, Research Triangle Park, North Carolina, USA";
            String phone = "(347) 466-7432";
            String email = "support@seleniumframework.com";
            commands.FooterValidation(location, phone, email);

        }catch (Exception e){
            System.out.println("Error "+ e);
        }
    }
}
