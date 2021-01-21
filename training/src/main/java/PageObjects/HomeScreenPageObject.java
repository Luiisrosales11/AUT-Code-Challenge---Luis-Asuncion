package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreenPageObject {
    public WebDriver driver;

    public HomeScreenPageObject(WebDriver driver){this.driver = driver;}

    // ================================================== BY VARIABLE SECTION =============================================================
    //variable to find Product Image
    private final By productImage = By.cssSelector("img[class='replace-2x img-responsive']");

    private final By closeButton = By.cssSelector("span[title='Close window']");

    private final By cart = By.cssSelector("a[title='View my shopping cart']");

    private final By removeFromCart = By.className("ajax_cart_block_remove_link");

    private final By noProducts = By.className("ajax_cart_no_product");

    private final By txtSearch = By.id("search_query_top");

    private final By btnSearch = By.name("submit_search");

    private final By btnAddtoCardFromCard = By.cssSelector("a[title='Add to cart']");

    private final By quickView = By.cssSelector("a[class='quick-view']");

    private final By homeScreen = By.cssSelector("img[class='logo img-responsive']");

    // ================================================== LOCATE OBJECT SECTION =============================================================

    public WebElement getProductImage(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productImage));
    }

    public WebElement getCloseButton(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
    }

    public WebElement getCart(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
    }

    public WebElement getRemoveFromCart() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeFromCart));
    }

    public WebElement getNoProducts() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noProducts));
    }

    public WebElement getTxtSearch() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtSearch));
    }

    public WebElement getBtnSearch() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearch));
    }

    public WebElement getBtnAddtoCardFromCard() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnAddtoCardFromCard));
    }

    public WebElement getQuickView() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(quickView));
    }

    public WebElement getHomePage(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeScreen));
    }
}
