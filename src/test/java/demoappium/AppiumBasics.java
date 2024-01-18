package demoappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AppiumBasics extends BaseTest{

    @Test
    public void AppiumTest() {
        //LOCATORS SUPPORTED - Xpath,Id, accessibilityId, className, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String popupText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText().trim();
        Assert.assertEquals(popupText,"WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Wifi Network");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}
