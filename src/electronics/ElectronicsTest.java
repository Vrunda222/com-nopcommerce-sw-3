package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // Locating the Main Menu (Parent element)
        WebElement mainMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //Instantiating Actions class
        Actions actions = new Actions(driver);

        //Hovering on main menu
        actions.moveToElement(mainMenu);

        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //To mouseover on sub menu
        actions.moveToElement(subMenu);

        //build()- used to compile all the actions into a single step
        actions.click().build().perform();

        // 1.3 Verify the text “Cell phones”
        Assert.assertEquals("Cell phones", getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']")));
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        // Locating the Main Menu (Parent element)
        WebElement mainMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //Instantiating Actions class
        Actions actions = new Actions(driver);

        //Hovering on main menu
        actions.moveToElement(mainMenu);

        //2.2 Mouse Hover on “Cell phones” and click
        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //To mouseover on sub menu
        actions.moveToElement(subMenu);

        //build()- used to compile all the actions into a single step
        actions.click().build().perform();
        //2.3 Verify the text “Cell phones”
        Assert.assertEquals("Cell phones", getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']")));
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
        //2.6 Verify the text “Nokia Lumia 1020”
        Assert.assertEquals("Nokia Lumia 1020", getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']")));
        //2.7 Verify the price “$349.00”
        Assert.assertEquals("$349.00", getTextFromElement(By.xpath("//span[@id='price-value-20']")));
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green BarAfter that close the bar clicking on the cross button.
        Assert.assertEquals("The product has been added to your shopping cart", getTextFromElement(By.xpath("//p[@class='content']")));
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(5000);

        // Locating the Main Menu (Parent element)
        WebElement mainMenu1 = driver.findElement(By.xpath("//span[@class='cart-label']"));

        //Instantiating Actions class
        Actions actions1 = new Actions(driver);

        //Hovering on main menu
        actions.moveToElement(mainMenu1);

        // Locating the element from Sub Menu
        WebElement subMenu1 = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));

        //To mouseover on sub menu
        actions.moveToElement(subMenu1);

        //build()- used to compile all the actions into a single step
        //actions.click().build().perform();
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(2000);
        //2.12 Verify the message "Shopping cart"
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']")));
        //2.13 Verify the quantity is 2
        //Assert.assertEquals("1", getTextFromElement(By.xpath("//input[@id='itemquantity11220']")));
        //2.14 Verify the Total $698.00
        Assert.assertEquals("$698.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]")));
        //2.15 click on checkbox “I agree with the terms of service”
        if (!driver.findElement(By.xpath("//input[@id='termsofservice']")).isSelected()) {
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
        }
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")));
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        //2.19 Verify the text “Register”
        Assert.assertEquals("Register",getTextFromElement(By.xpath("//h1[normalize-space()='Register']")));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Vrunda");
        sendTextToElement(By.id("LastName"), "Vyas");
        sendTextToElement(By.name("Email"), "vrunda@gmail.com");
        sendTextToElement(By.id("Password"), "123456");
        sendTextToElement(By.id("ConfirmPassword"), "123456");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        Assert.assertEquals("Your registration completed", getTextFromElement(By.xpath("//div[@class='result']")));
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        //2.24 Verify the text “Shopping card”
        Assert.assertEquals("Shopping card", getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']")));
        //2.25 click on checkbox “I agree with the terms of service”
        if (!driver.findElement(By.xpath("//input[@id='termsofservice']")).isSelected()) {
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
        }
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.27 Fill the Mandatory fields
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
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(3000);
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.32 Select “Visa” From Select credit card dropdown
        WebElement dropDownCreditCard = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select selectCreditCard = new Select(dropDownCreditCard);
        selectCreditCard.selectByVisibleText("Visa");
        //2.33 Fill all the details
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
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep((2000));
        //2.35 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Credit Card", getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']")));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("2nd Day Air", getTextFromElement(By.xpath("//span[normalize-space()='2nd Day Air']")));
        //2.37 Verify Total is “$698.00”
        Assert.assertEquals("Price not matching", "$698.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]")));
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.39 Verify the Text “Thank You”
        Assert.assertEquals("Thank You", getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']")));
        //2.40 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")));
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        //2.42 Verify the text “Welcome to our store”
        Assert.assertEquals("Welcome to our store", getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']")));
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//button[contains(text(),'Logout')"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }
}
