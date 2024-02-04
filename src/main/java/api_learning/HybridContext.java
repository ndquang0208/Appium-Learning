package api_learning;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.List;

public class HybridContext {
    public static void main(String[] args){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
        try{
            MobileElement navigateFormScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Webview"));
            navigateFormScreenBtn.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver,15L);
            wait.until(new WaitMoreThanOneContext((appiumDriver)));

            for(String contextHandle : appiumDriver.getContextHandles()){
                System.out.println("contextHandle "+contextHandle);

            }
            appiumDriver.context(Contexts.WEB_VIEW);
            WebElement mavToggleBtn = appiumDriver.findElement(By.cssSelector(".navbar__toggle"));
            mavToggleBtn.click();
            List<MobileElement> mobileElements = appiumDriver.findElements(By.cssSelector(".menu__list li a"));
            for(MobileElement e : mobileElements){
                System.out.print("text :"+ e.getText());
            }
            // find element in web view

        }catch(Exception e){
            e.printStackTrace();
        }

        if(appiumDriver != null ) appiumDriver.quit();



    }
}
