package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;

public class SwipeVertically {
    static AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
    public static void main(String[] args){

        MobileElement navigateFormScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
        navigateFormScreenBtn.click();
        verticalSwipe(2,50);
        MobileElement notification = appiumDriver.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id=\"android:id/header_text\" and @text=\"USB để truyền file\"]"));
        notification.click();
        MobileElement notificationExpaned = appiumDriver.findElement(MobileBy.xpath("  //android.widget.TextView[@resource-id=\"android:id/text\" and @text=\"Chạm để có các tùy chọn USB khác.\"]"));
        if(appiumDriver != null ) appiumDriver.quit();
    }

    static public void verticalSwipe(int yStartPercentage, int yEndPercentage) {
        try {


            Thread.sleep(2000);
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = yStartPercentage * screenHeight / 100;
            int yEndPoint = yEndPercentage * screenHeight / 100;

            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Swipe down
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500))).moveTo(endPoint).release().perform();
            Thread.sleep(2000);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
