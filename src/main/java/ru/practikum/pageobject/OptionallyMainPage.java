package ru.practikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OptionallyMainPage {
    private static final By INPUT_FIELD = By.xpath(".//*[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private static final By STATUS_STATE_BUTTON = By.cssSelector("button.Header_Link__1TAG7");
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By GO_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    private static final By IMG_NOT_FOUND = By.cssSelector("div.Track_NotFound__6oaoY > img");
    private final WebDriver driver;
    public OptionallyMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOrderStatusButton() {
        driver.findElement(STATUS_STATE_BUTTON).click();
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public void enterOrderNumber(String orderNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD));
        driver.findElement(INPUT_FIELD).clear();
        driver.findElement(INPUT_FIELD).sendKeys(orderNumber);
        driver.findElement(GO_BUTTON).click();
    }

    public boolean isImageNotFoundDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(IMG_NOT_FOUND));
        return driver.findElement(IMG_NOT_FOUND).isDisplayed();
    }



}
