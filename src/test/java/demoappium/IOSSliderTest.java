package demoappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSliderTest extends IOSBaseTest{

    @Test
    public void IOSSliderTestDemo(){

        WebElement elementSlider = driver.findElement(
                AppiumBy.iOSClassChain("**/XCUIEleentTypeSlider[`label == 'AppElem'`]"));
        //RANGE 0-1
        elementSlider.sendKeys("0%");
        Assert.assertEquals(elementSlider.getAttribute("value"),"0%");
        elementSlider.sendKeys("1%");
        Assert.assertEquals(elementSlider.getAttribute("value"),"100%");
    }
}
