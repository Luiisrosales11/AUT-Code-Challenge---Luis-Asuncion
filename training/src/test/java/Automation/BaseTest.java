package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;


    @BeforeTest()
    public void OpenBrowser(){
        driverBuilder();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest()
    public void CloseBrowser(){
        driver.close();
    }


    public WebDriver driverBuilder() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\luis-\\Documents\\GitHub\\AUT-Code-Challenge---Luis-Asuncion\\training\\src\\Core\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this.driver;
    }
}
