import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ExpandGroups {

    public static String VIEW_BUTTON_LOCATOR = "//android.widget.TextView[@content-desc='Views']";
    public static String EXPANDAPLE_LIST_BUTTON_LOCATOR = "//android.widget.TextView[@content-desc='Expandable ListsTask1']";
    public static String SIMPLE_ADAPTER_BUTTON_LOCATOR = "//android.widget.TextView[@content-desc='3. Simple Adapter']";


    public static void main(String[] args) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "GGGGNexus  6 MobileAutomation");
        desiredCapabilities.setCapability("platformVersion", "8.0");
        desiredCapabilities.setCapability("app", new File("src/app/ApiDemos-debug.apk"));
        desiredCapabilities.setCapability("newCommandTimeout", "300000");

        AppiumDriver driver = null;

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Wait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(VIEW_BUTTON_LOCATOR)));
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EXPANDAPLE_LIST_BUTTON_LOCATOR)));
        driver.findElementByXPath(EXPANDAPLE_LIST_BUTTON_LOCATOR).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(SIMPLE_ADAPTER_BUTTON_LOCATOR)));
        driver.findElementByXPath(SIMPLE_ADAPTER_BUTTON_LOCATOR).click();

        List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));

        elements.get(1).click();

        elements = driver.findElements(By.className("android.widget.TextView"));

        if(elements.get(2).getText().equals("Child 23")){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL");
        }

        System.out.println("Text = " + elements.get(2).getText());

        //TODO why assert does not fail???
        assert elements.get(2).getText().equals("Child 23");


    }
}
