package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    static String baseUrl= "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu){
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='"+menu+"']"));
    }

    @Test
    public void verifyPageNavigation(){
        // use selectMenu method to select the Menu and click on it
        String menu = "Computers";
        selectMenu(menu);

        // and verify the page navigation.
        String expectedUrl = "https://demo.nopcommerce.com/"+menu;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
