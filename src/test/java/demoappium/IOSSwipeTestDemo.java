package demoappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IOSSwipeTestDemo extends IOSBaseTest{


    @Test
    public void IOSSwipeTestDemo(){
        Map<String,String> params = new HashMap<>();
        params.put("bundledId","com.apple.mobileSlideShow");
        driver.executeScript("mobile:launchApp",params);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List<WebElement> photosList = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(photosList.size());

        for (int i=0; i< photosList.size();i++) {
            System.out.println(driver.findElement
                    (AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            Map<String, Object> param2 = new HashMap<>();
            param2.put("direction","left");
            //BY DEFAULT SWIPE EVENT SWIPES ON THE CENTER OF THE SCREEN
            driver.executeScript("mobile:swipe",param2);
         }
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();
    }
}
