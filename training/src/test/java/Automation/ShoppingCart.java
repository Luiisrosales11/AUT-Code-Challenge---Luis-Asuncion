package Automation;

import Commands.Commands;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingCart extends BaseTest{

        Commands commands = null;

        @BeforeClass
        public void beforeClass(){
            commands = new Commands(driver);
        }

        @Test(priority = 1,groups = "Cart")
        public void AddToCartFromProductDetailPage() {
            try {
                //On Details Page a product will be added to the Cart
                commands.SelectProduct();
                commands.AddToCartButton();
                commands.CloseSuccesfullMessage();
                commands.SeeProductsOnCart();
                //Remove a product from Cart and Check Empty Cart Message
                commands.RemoveItemCart();
                commands.EmptyCartValidation();
            }catch (Exception e){
                System.out.println("Error "+ e);
            }
        }

    @Test(priority = 2, groups = "Cart")
    public void AddToCartFromCard(){
        commands.homeScreen();
        //Add a product to Cart from card product
        commands.ProductImageHover();
        commands.AddToCartFromCard();
        commands.CloseSuccesfullMessage();
        //Remove the Item from Cart and validate the Empty Cart Message
        String emptyCart = "Your shopping cart is empty.";
        commands.CartProducts();
        commands.RemoveFromCart(emptyCart);
    }
    @Test(priority = 3, groups = "Cart")
    public void AddToCartFromMIframe(){
        commands.homeScreen();
        commands.ProductImageHover();
        commands.QuickViewProduct();
        driver.switchTo().frame(1);
        commands.AddToCartButton();
        driver.switchTo().defaultContent();
        commands.CloseSuccesfullMessage();
        commands.SeeProductsOnCart();
        commands.RemoveItemCart();
        commands.EmptyCartValidation();
    }
}
