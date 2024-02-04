package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.form.FormComponent;
import models.components.global.BottomNavComponent;
import models.components.login.LoginFormComponent;

public class FormScreen {

    private final AppiumDriver<MobileElement> appiumDriver;

    public FormScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public FormComponent formComponent(){
        return new FormComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComp(){
        return new BottomNavComponent(appiumDriver);
    }
}
