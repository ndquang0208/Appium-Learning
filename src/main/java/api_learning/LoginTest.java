package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Platform;

public class  LoginTest {
    public static void main(String[] args){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
        try{
            MobileElement navigateLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigateLoginScreenBtn.click();

            MobileElement emailTxtboxEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordTxtboxEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            passwordTxtboxEle.sendKeys("12345789");
            emailTxtboxEle.sendKeys("ndquang@gmail.com");
            loginButton.click();
            Thread.sleep(3000);
            //
            //
            MobileElement okButton = appiumDriver.findElement(MobileBy.id("android:id/button1"));
            okButton.click();





        }catch(Exception e){
            e.printStackTrace();
        }

        if(appiumDriver != null ) appiumDriver.quit();



    }
}
