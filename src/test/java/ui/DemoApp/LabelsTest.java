package ui.DemoApp;

import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LabelsTest extends  DemoAppBaseTest{

    @Test(groups = {"Smoke", "Regression"})
    public void checkGreetingLabel(){

        MobileElement label = driver.findElementById("io.testproject.demo:id/greetings");
        String greeting = label.getText();
        String expectedGreeting = "Hello Dragan";

        Assert.assertEquals(greeting, expectedGreeting, "Expected greeting: " + expectedGreeting + " Actually: " + greeting );

    }

    @Test(groups = {"Smoke"})
    public void checkSaveButton(){

        driver.navigate().back();
        MobileElement saveButton = driver.findElementById("io.testproject.demo:id/save");

        String text = saveButton.getText();
        String expectedText = "SAVE";

        Assert.assertEquals(text, expectedText, "Expected button text: " + text + "; Actually: " + expectedText );
    }
}
