package demoappium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class eCommerce_TC_3 extends BaseTest{

    @Test
    public void addToCart() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test User");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"),"text","Products"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"),"text","Cart"));
        double cartSum =0;
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        for (WebElement product: productPrices){
           double productPrice = getFormattedAmountFromString(product.getText().trim());
            cartSum = cartSum +productPrice;
        }

        WebElement totalPurchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"));
        double totalPurchaseAmountVal = getFormattedAmountFromString(totalPurchaseAmount.getText().trim());

        Assert.assertEquals(cartSum,totalPurchaseAmountVal);

        WebElement termsAndConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(termsAndConditions);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
         Set<String> contextHandles=driver.getContextHandles();
         for (String context : contextHandles){
             System.out.println(context);
         }
         driver.context("WEBVIEW_com.androidsample.generalstore");
         driver.findElement(By.name("q")).sendKeys("Swag Labs"+ Keys.ENTER);
         driver.pressKey(new KeyEvent(AndroidKey.BACK));
         driver.context("NATIVE_APP");
    }

}
