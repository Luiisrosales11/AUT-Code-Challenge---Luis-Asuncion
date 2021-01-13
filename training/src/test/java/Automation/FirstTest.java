package Automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class FirstTest {



    public static void main(String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /*
        Logo
	b. All the elements in the menu
	c. Title of the page (the one that is on the tab)
	d. All the radio buttons
	e. Input Countries
	f. Dropdown
	g. Checkbox number three
	h. The Open Window button
	i. The web Table example (The table not the title)
	j. The label of the "Element Displayed Example"
	k. The iFrame
	l. One element of the menu (Login)
        */
        By logo = By.className("logoClass");
        By menu = By.cssSelector("header button");
        String title = driver.getTitle();
        By radios = By.cssSelector("fieldset label");
        By countries = By.id("autocomplete");
        By dropwdown = By.name("dropdown-class-example");
        By checkbox3 = By.id("checkBoxOption3");
        By openbutton = By.xpath("//*[@id=\"openwindow\"]");
        By webtable = By.cssSelector("table[name='courses']");
        By elementDisplayed = By.xpath("/html/body/div[3]/div[2]/fieldset/legend");
        By Iframe = By.id("courses-iframe");
        By loginButton = By.cssSelector("body > header > div > button:nth-child(3)");

        //2. Find the elements with the methods findElement or FindElements with the locators created in the previous bullet.

        WebElement Element1 = driver.findElement(logo);
        List<WebElement> Element2 = driver.findElements(menu);
        List<WebElement> Element3 = driver.findElements(radios);
        List<WebElement> Element4 = driver.findElements(countries);
        List<WebElement> Element5 = driver.findElements(dropwdown);
        WebElement Element6 = driver.findElement(checkbox3);
        WebElement Element7 = driver.findElement(openbutton);
        WebElement Element8 = driver.findElement(webtable);
        WebElement Element9 = driver.findElement(elementDisplayed);
        WebElement Element10= driver.findElement(Iframe);
        WebElement Element11 = driver.findElement(loginButton);

        /*
        3. Print the text for al the elements (except for options b and i).
        Note: If the element does not have text, print element's description (or any text that makes reference to it) (e.g. Logo's image)
        */

        System.out.println("Logo: " + Element1.getText());
        for (int i=0; i<= Element2.size(); i++){
            System.out.println(Element2.get(i).getText());
        }
        for (int i=0; i<= Element3.size(); i++){
            System.out.println(Element3.get(i).getText());
        }
        System.out.println("Value: " + Element4.get(0).getAttribute("Placeholder"));
        System.out.println("");



        driver.close();

    }
}
