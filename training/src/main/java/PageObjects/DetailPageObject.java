package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailPageObject {
    public WebDriver driver;

    public DetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    // ================================================== BY VARIABLE SECTION =============================================================

    private final By addToCart = By.cssSelector("button[name='Submit']");

    private final By storeInfo = By.xpath("//section[@id='block_contact_infos']");

    private final By infoLocation = By.xpath("//section[@id='block_contact_infos']//li[1]");

    private final By infoPhone = By.xpath("//section[@id='block_contact_infos']//li[2]//span");

    private final By infoEmail = By.xpath("//section[@id='block_contact_infos']//li[3]//span");

    // ================================================== LOCATE OBJECT SECTION =============================================================

    public WebElement getAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return driver.findElement(addToCart);
    }

    public WebElement getStoreInfo() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return driver.findElement(storeInfo);
    }

    public WebElement getInfoLocation() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return driver.findElement(infoLocation);
    }

    public WebElement getInfoPhone() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return driver.findElement(infoPhone);
    }

    public WebElement getInfoEmail() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return driver.findElement(infoEmail);
    }


}
