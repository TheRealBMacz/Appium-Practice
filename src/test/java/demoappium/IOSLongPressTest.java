package demoappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSLongPressTest extends IOSBaseTest {

    @Test
    public void IOSLongPress(){
        driver.findElement(AppiumBy.accessibilityId("Steppers"));
        WebElement incrementBtn = driver.findElement(AppiumBy.iOSClassChain
                ("**/XCUIElementTypeButton[`label =='Increment'`][3]"));
        Map<String, Object> param = new HashMap<>();
        param.put("element",((RemoteWebElement)incrementBtn).getId());
        param.put("duration",5);
        driver.executeScript("mobile:touchAndHold",param);
    }
}
