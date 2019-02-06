package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ApiDemoWithNGTest extends BaseTest{

    public static String VIEW_BUTTON_LOCATOR = "//android.widget.TextView[@content-desc='Views']";
    public static String EXPANDAPLE_LIST_BUTTON_LOCATOR = "//android.widget.TextView[@content-desc='Expandable Lists']";
    public static String SIMPLE_ADAPTER_BUTTON_LOCATOR = "//android.widget.TextView[@content-desc='3. Simple Adapter']";


    @Test(groups = {"Smoke", "Regression"},
            description = "Demo test",
            successPercentage = 60)
    public void testSmth() {

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

        if(elements.get(2).getText().equals("Child 0")){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL");
        }

        System.out.println("Text = " + elements.get(2).getText());

        Assert.assertEquals(elements.get(2).getText(), "Child 0", "Expected Child 0, found: " + elements.get(2).getText() );
    }

    private void openAccessibilityNodePage(AppiumDriver driver){
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Querying']")).click();

    }

    private MobileElement getCheckBox(AppiumDriver driver){
        List<MobileElement> elementsByClassName = driver.findElementsByClassName("android.widget.CheckBox") ;
        return elementsByClassName.get(0);
    }

}
