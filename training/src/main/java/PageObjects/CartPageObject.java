package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageObject {
    public WebDriver driver;

    public CartPageObject(WebDriver driver){this.driver = driver;}

    // ================================================== BY VARIABLE SECTION =============================================================


    private final By removeFromCart = By.className("cart_quantity_delete");

    private final By emptyCartMessage = By.cssSelector("p[class='alert alert-warning']");

    // ================================================== LOCATE OBJECT SECTION =============================================================

    public WebElement getRemoveFromCart() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeFromCart));
    }

    public WebElement getEmptyCartMessage() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
    }
}
