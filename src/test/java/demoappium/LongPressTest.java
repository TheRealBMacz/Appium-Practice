package demoappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressTest extends BaseTest {

    @Test
    public void longPressGuesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(peopleNames);
        WebElement sampleMenu = driver.findElement(By.id("android:id/title"));
        Assert.assertEquals(sampleMenu.getText().trim(),"Sample menu");
        Assert.assertTrue(sampleMenu.isDisplayed());
    }
}
