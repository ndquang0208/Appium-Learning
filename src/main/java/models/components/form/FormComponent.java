package models.components.form;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By inputField = MobileBy.AccessibilityId("text-input");
    private final static By textAreaField = MobileBy.AccessibilityId("input-text-result");
    private final static By switchToggle = MobileBy.AccessibilityId("switch");

    private final static By dropdown = MobileBy.xpath("//android.widget.EditText[@text=\"Select an item...\"]");
    private final static By dropdownValue = MobileBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"webdriver.io is awesome\"]");

    private final static By activeButton = MobileBy.xpath("//android.widget.TextView[@text=\"Active\"]");



    public FormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    @Step("Input textbox as {inputValue}")
    public void inputTextboxname(String inputValue) {
            MobileElement usernameElem = appiumDriver.findElement(inputField);
            usernameElem.clear();
            usernameElem.sendKeys(inputValue);
    }

    @Step("Input textArea as {inputValue}")
    public void inputTextAreaname(String inputValue) {
        MobileElement usernameElem = appiumDriver.findElement(textAreaField);
        usernameElem.click();
        usernameElem.sendKeys(inputValue);
    }

    @Step("Click On Switch Toggle")
    public void clickOnSwitchButtn() {
        MobileElement usernameElem = appiumDriver.findElement(switchToggle);
        usernameElem.click();
    }

    @Step("Click On Dropdown Toggle")
    public void clickOnDropdownButtn() {
        MobileElement usernameElem = appiumDriver.findElement(dropdown);
        usernameElem.click();
        MobileElement dropdownValueElem = appiumDriver.findElement(dropdownValue);
        dropdownValueElem.click();
    }

    @Step("Click On Active Button")
    public void clickOnActiveButtn() {
        MobileElement activeButtonElem = appiumDriver.findElement(activeButton);
        activeButtonElem.click();
    }



}
