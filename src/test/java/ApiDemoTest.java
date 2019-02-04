import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiDemoTest {
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


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10000);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();
        openAccessibilityNodePage(driver);
        getCheckBox(driver).click();



        System.out.println(driver.getPageSource());
        System.out.println("----------------------------------------------------------------------------");

        driver.navigate().back();
        openAccessibilityNodePage(driver);
        if(getCheckBox(driver).isSelected()){
            System.out.println("Selected");
        }else{
            System.out.println("Not Selected");
        }

        assert getCheckBox(driver).isSelected();
    }

    private static void openAccessibilityNodePage(AppiumDriver driver){
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Querying']")).click();

    }

    private static MobileElement getCheckBox(AppiumDriver driver){
        List<MobileElement> elementsByClassName = driver.findElementsByClassName("android.widget.CheckBox") ;
        return elementsByClassName.get(0);
    }
}