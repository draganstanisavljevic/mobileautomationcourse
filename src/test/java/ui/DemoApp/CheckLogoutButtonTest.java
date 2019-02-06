package ui.DemoApp;

import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLogoutButtonTest extends DemoAppBaseTest {

    @Test(groups = {"Smoke", "Regression"})
    public void checkLogoutButton(){

        driver.navigate().back();

        MobileElement button = driver.findElementById("io.testproject.demo:id/logout");
        String text = button.getText();
        String expectedText = "LOGOUT";

        Assert.assertEquals(text, expectedText, "Expected greeting: " + text + " Actually: " + expectedText );

    }
}
