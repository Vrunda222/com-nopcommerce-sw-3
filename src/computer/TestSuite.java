package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.id("products-orderby"));
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='products-container']"));


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.id("products-orderby"));
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name: A to Z");
        Thread.sleep(3000);
        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        //2.5 Verify the Text "Build your own computer"
        Assert.assertEquals("Build your own computer", getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']")));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        //clickOnElement(By.xpath("//select[@id='product_attribute_1']"));
        WebElement dropDownProcessor = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
        Select selectProcessor = new Select(dropDownProcessor);
        selectProcessor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        WebElement dropDownRam = driver.findElement(By.xpath("//select[@id='product_attribute_2']"));
        Select selectRam = new Select(dropDownRam);
        selectRam.selectByVisibleText("8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        if (!driver.findElement(By.xpath("//input[@id='product_attribute_5_10']")).isSelected()) {
            clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        }
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        //Assert.assertEquals("Price not matching", "$1,475.00", getTextFromElement(By.xpath("//span[@id='price-value-1']")));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        Assert.assertEquals("The product has been added to your shopping cart", getTextFromElement(By.xpath("//p[@class='content']")));
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(5000);

        // Locating the Main Menu (Parent element)
        WebElement mainMenu = driver.findElement(By.xpath("//span[@class='cart-label']"));

        //Instantiating Actions class
        Actions actions = new Actions(driver);

        //Hovering on main menu
        actions.moveToElement(mainMenu);

        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));

        //To mouseover on sub menu
        actions.moveToElement(subMenu);

        //build()- used to compile all the actions into a single step
        //actions.click().build().perform();
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(2000);
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']")));
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        //sendTextToElement(By.xpath("//input[@id='itemquantity11234']"), "2");


        //String productQuantity = driver.findElement(By.xpath("//input[@id='itemquantity11234']")).getText();

        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals("Price not matching", "$2,950.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']")));
        //2.18 click on checkbox “I agree with the terms of service”
        if (!driver.findElement(By.xpath("//input[@id='termsofservice']")).isSelected()) {
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
        }
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals( "Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")));
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        //2.22 Fill the all mandatory field
        //Add name
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Vrunda");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Vyas");
        // Add email
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Vrunda@gmail.com");
        // select country
        WebElement dropDownCountry = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select selectCountry = new Select(dropDownCountry);
        selectCountry.selectByVisibleText("India");
        //Add city
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Nadiad");
        //Add address
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "22, Abc Street");
        //Add zip code
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "990099");
        //Add phone number
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9909909909");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep((2000));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        WebElement dropDownCreditCard = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select selectCreditCard = new Select(dropDownCreditCard);
        selectCreditCard.selectByVisibleText("Master card");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "vrunda");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), " 5431 1111 1111 1111");
        //select expiry date
        WebElement dropDownDate = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));
        Select selectDate = new Select(dropDownDate);
        selectDate.selectByVisibleText("12");

        WebElement dropDownYear = driver.findElement(By.xpath("//select[@id='ExpireYear']"));
        Select selectYear = new Select(dropDownYear);
        selectYear.selectByVisibleText("2034");

        sendTextToElement(By.xpath("//input[@id='CardCode']"), "009");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep((2000));
        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Credit Card", getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']")));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals("Next Day Air", getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']")));
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals("Price not matching", "$2,950.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$1,475.00')]")));
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.35 Verify the Text “Thank You”
        Assert.assertEquals("Thank You", getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']")));
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")));
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals("Welcome to our store", getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']")));
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }
}
