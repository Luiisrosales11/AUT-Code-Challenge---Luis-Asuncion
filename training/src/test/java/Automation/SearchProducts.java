package Automation;

import Commands.Commands;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchProducts extends BaseTest{

    Commands commands = null;

    @BeforeClass
    public void beforeClass(){
        commands = new Commands(driver);
    }

    @Test(groups = "Search")
    public void SearchAProduct() {
        try {
            //Search Item
            String clothe = "dress";
            commands.SearchItemPositive(clothe);

        }catch (Exception e){
            System.out.println("Error "+ e);
        }
    }

    @Test(groups = "Search")
    public void SearchNoProducts() {
        try {
            String clothe = "Pant";
            commands.CleanTextbox();
            commands.SearchItemNegative(clothe);

        }catch (Exception e){
            System.out.println("Error "+ e);
        }
    }
}
