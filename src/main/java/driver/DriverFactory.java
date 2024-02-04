package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    private AppiumDriver<MobileElement> appiumDriver;

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(UDID, "3300d3672cca62b9");
        desiredCapabilities.setCapability(APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        URL appiumServer = null;

        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appiumServer == null)
            throw new RuntimeException("Can't construct the appium server url @http://localhost:4723/wd/hub");

        switch (platform) {
            case android:
                appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
                break;
            case ios:
                appiumDriver = new IOSDriver<>(appiumServer, desiredCapabilities);
                break;
        }

        // Implicit wait | Interval time 500ms
        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return appiumDriver;
    }

    public AppiumDriver<MobileElement> getDriver(Platform platform, String udid, String systemPort, String platformVersion) {

        //String isRemote = System.getenv("env") == null? System.getProperty("env") : System.getenv("env");
        String isRemote = "true";
        if (isRemote == null){
            throw new IllegalArgumentException("Please prodive env via variable [env]!");
        }
        String targetServer = "http://localhost:4723/wd/hub";
        if(isRemote.equals("true")) {
            String hubIPAddress="http://192.168.0.102";
           // String hubIPAddress = System.getenv("hub");
            if (hubIPAddress == null) hubIPAddress = System.getProperty("hub");
            if (hubIPAddress == null) {
                throw new IllegalArgumentException("Please prodive hub IP Address via variable [hub]!");
            }
            targetServer = hubIPAddress + ":4444/wd/hub";

        }


        if(appiumDriver == null) {
            URL appiumServer = null;
            try {
                appiumServer = new URL(targetServer);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (appiumServer == null)
                throw new RuntimeException("Can't construct the appium server url "+ targetServer);
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PLATFORM_NAME, platform);
            switch (platform) {
                case android:
                    desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
                    desiredCapabilities.setCapability(UDID, udid);
                    desiredCapabilities.setCapability(APP_PACKAGE, "com.wdiodemoapp");
                    desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
                    desiredCapabilities.setCapability(SYSTEM_PORT, systemPort);
                    appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
                    break;
                case ios:
                    desiredCapabilities.setCapability(AUTOMATION_NAME, "XCUITest");
                    desiredCapabilities.setCapability(DEVICE_NAME, udid);
                    desiredCapabilities.setCapability(PLATFORM_VERSION, platformVersion);
                    desiredCapabilities.setCapability(BUNDLE_ID, "org.wdioDemoApp");
                    desiredCapabilities.setCapability(WDA_LOCAL_PORT, systemPort);
                    appiumDriver = new IOSDriver<>(appiumServer, desiredCapabilities);
                    break;
            }
            // Implicit wait | Interval time 500ms
            appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        return appiumDriver;
    }

    public void quitAppiumDriver(){
        if(appiumDriver != null){
            appiumDriver.quit();
            appiumDriver = null;
        }
    }


    }