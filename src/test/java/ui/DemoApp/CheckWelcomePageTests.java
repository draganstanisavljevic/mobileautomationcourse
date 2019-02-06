package ui.DemoApp;

import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckWelcomePageTests extends DemoAppBaseTest {

    @Test(groups = {"Regression"})
    public void checkLoginButton(){
        MobileElement button = driver.findElementByClassName("android.widget.Button");
        String text = button.getText();
        String expectedText = "LOGOUT";

        Assert.assertEquals(text, expectedText, "Expected greeting: " + text + " Actually: " + expectedText );
    }
}
