package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AppiumDriver<MobileElement> driver;

    @BeforeClass(alwaysRun = true)
    public void preConditions() throws DriverIsNotInitException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "GGGGNexus  6 MobileAutomation");
        desiredCapabilities.setCapability("platformVersion", "8.0");
        desiredCapabilities.setCapability("app", new File("src/app/ApiDemos-debug.apk"));
        desiredCapabilities.setCapability("newCommandTimeout", "300000");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch(NullPointerException e){
            throw new DriverIsNotInitException("Driver was not init");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @BeforeSuite(alwaysRun = true)
    public void setEnv(){
        System.out.println("Im setting environment");
    }

    @BeforeSuite(alwaysRun = true)
    public void initDataBase(){
        System.out.println("Init DB");
    }

    @AfterClass
    private void postConditions(){
        driver.quit();
    }
}
