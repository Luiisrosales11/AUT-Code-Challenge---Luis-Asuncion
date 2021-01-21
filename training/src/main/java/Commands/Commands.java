package Commands;

import PageObjects.CartPageObject;
import PageObjects.DetailPageObject;
import PageObjects.HomeScreenPageObject;
import PageObjects.SearchPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Commands {

    public WebDriver driver;
    CartPageObject oCartPageObject;
    HomeScreenPageObject oHomeScreenPageObject;
    DetailPageObject oDetailPageObject;
    SearchPageObject oSearchPageObject;

    public Commands(WebDriver driver){
    this.driver = driver;
    oCartPageObject = new CartPageObject(driver);
    oHomeScreenPageObject = new HomeScreenPageObject(driver);
    oDetailPageObject = new DetailPageObject(driver);
    oSearchPageObject = new SearchPageObject(driver);
    }

    //==========================================================START PAGE ACTIONS==========================================================

    public void SelectProduct() {
        WebElement productSelection = oHomeScreenPageObject.getProductImage();
        productSelection.click();
    }


    public void AddToCartButton(){
        WebElement addToCart = oDetailPageObject.getAddToCart();
        addToCart.click();
    }

    public void CloseSuccesfullMessage(){
        WebElement closeButton = oHomeScreenPageObject.getCloseButton();
        closeButton.click();
    }

    public void SeeProductsOnCart(){
        Actions builder = new Actions(driver);
        WebElement cart = oHomeScreenPageObject.getCart();
        builder.moveToElement(cart).build().perform();
    }

    public void RemoveItemCart(){
        WebElement removeFromCart = oHomeScreenPageObject.getRemoveFromCart();
        removeFromCart.click();
    }

    public void EmptyCartValidation(){
        WebElement noProduct = oHomeScreenPageObject.getNoProducts();
        String noProductsLabel= "(empty)";
        Assert.assertEquals(noProduct.getText(),noProductsLabel);
    }

    public void SearchItemPositive(String clothe){
        WebElement txtSearch = oHomeScreenPageObject.getTxtSearch();
        txtSearch.sendKeys(clothe);
        WebElement btnSearch = oHomeScreenPageObject.getBtnSearch();
        btnSearch.click();
                List<WebElement> productNames = oSearchPageObject.getProductNames();
                if (productNames.size() > 1)
                    System.out.println(productNames.size() + " items have been found");
                else
                    System.out.println(productNames.size() + " item has been found");

                for (int i = 0; i < productNames.size(); i++) {
                    System.out.println(productNames.get(i).getText());
                }
    }
    public void CleanTextbox(){
        WebElement txtSearch = oHomeScreenPageObject.getTxtSearch();
        txtSearch.clear();
    }

    public void SearchItemNegative(String clothe){
            WebElement txtSearch = oHomeScreenPageObject.getTxtSearch();
            txtSearch.sendKeys(clothe);
            WebElement btnSearch = oHomeScreenPageObject.getBtnSearch();
            btnSearch.click();
            WebElement noResults = oSearchPageObject.getNoResults();
            String noResultsMessage = "No results were found for your search " + "\"" + clothe + "\"";
            Assert.assertEquals(noResults.getText(), noResultsMessage);
            System.out.println("No results");
    }

    public void ScrollToASection(){
        WebElement storeInfo = oDetailPageObject.getStoreInfo();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", storeInfo);
    }

    public void FooterValidation(String location, String phone, String email){
        WebElement infoLocation = oDetailPageObject.getInfoLocation();
        WebElement infoPhone = oDetailPageObject.getInfoPhone();
        WebElement infoEmail = oDetailPageObject.getInfoEmail();

        Assert.assertEquals(infoLocation.getText(),location);
        Assert.assertEquals(infoPhone.getText(),phone);
        Assert.assertEquals(infoEmail.getText(),email);
    }

    public void ProductImageHover(){
        Actions builder = new Actions(driver);
        WebElement productImage = oHomeScreenPageObject.getProductImage();
        builder.moveToElement(productImage).build().perform();
    }

    public void AddToCartFromCard(){
        WebElement btnAddToCart = oHomeScreenPageObject.getBtnAddtoCardFromCard();
        btnAddToCart.click();
    }

    public void CartProducts(){
        WebElement cart = oHomeScreenPageObject.getCart();
        cart.click();
    }

    public void RemoveFromCart(String emptyCart){
        //CartPage
        WebElement removeFromCart = oCartPageObject.getRemoveFromCart();
        removeFromCart.click();
        //CartPage
        WebElement emptyCartMessage = oCartPageObject.getEmptyCartMessage();
        Assert.assertEquals(emptyCartMessage.getText(),emptyCart);
    }

    public void QuickViewProduct(){
        //HomeScreen
        WebElement btnQuickView = oHomeScreenPageObject.getQuickView();
        btnQuickView.click();
    }

    public void homeScreen(){
        WebElement homePage = oHomeScreenPageObject.getHomePage();
        homePage.click();
    }
}
