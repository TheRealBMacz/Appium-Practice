package demoappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IOSScrollTest extends IOSBaseTest{

    @Test
    public void IOSScrollTestDemo() throws  InterruptedException{

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> param = new HashMap<>();
        param.put("element",((RemoteWebElement)element).getId());
        param.put("direction","down");

        driver.executeScript("mobile:scroll",param);
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        //DROPDOWN PICKER SCENARIO
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");

        String dropDownValue = driver.findElement(AppiumBy.
                iOSNsPredicateString("label == 'Blue color component value'")).getText();
        Assert.assertEquals(dropDownValue,"105");






    }
}
