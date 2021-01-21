package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPageObject {
    public WebDriver driver;

    public SearchPageObject(WebDriver driver){this.driver = driver;}

    // ================================================== BY VARIABLE SECTION =============================================================
    private final By results = By.cssSelector("div[class='product-container']");

    private final By noResults = By.cssSelector("p[class='alert alert-warning']");

    private final By productNames = By.xpath("//div[@class='product-container']//a[@class='product-name']");

    // ================================================== LOCATE OBJECT SECTION =============================================================

    public List<WebElement> getResults() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement weElement = wait.until(ExpectedConditions.visibilityOfElementLocated(results));
        return weElement.findElements(results);
    }

    public WebElement getNoResults() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noResults));
    }

    public List<WebElement> getProductNames() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement weElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productNames));
        return weElement.findElements(productNames);
    }
}
