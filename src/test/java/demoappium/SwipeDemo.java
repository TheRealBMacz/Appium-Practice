package demoappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest{


    @Test
    public void swipeDemo(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        WebElement photoElement1 = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));

        //CHECK THE FOCUS OF THE ELEMENT IN VIEW IS TRUE
        Assert.assertEquals(photoElement1.getAttribute("focusable").trim(),"true");
        //PERFORM SWIPE ACTION
        swipeAction(photoElement1,"left");
        //CHECK THE FOCUS OF THE ELEMENT IN VIEW IS FALSE
        Assert.assertEquals(photoElement1.getAttribute("focusable").trim(),"false");



    }
}
