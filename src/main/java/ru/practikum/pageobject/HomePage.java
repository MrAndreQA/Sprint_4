package ru.practikum.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    // Добавляем конструктор класса
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
                                                        // БЛОК МЕТОДОВ: //
    // Открыть главную страницу приложения
    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }
    // Общий метод нажатия на кнопку "Заказать"
    public void clickToOrderButton(By orderButton) {
        // Найди Элемент
        WebElement element = driver.findElement(orderButton);
        // Прокрути страницу до элемента
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        // Дождаться элемент и нажать на него
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        driver.findElement(orderButton).click();
    }
    // Клик на вопрос
    public void clickToQuestion(By question) {
        WebElement element = driver.findElement(question);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.isEnabled();
        element.click();
    }
}