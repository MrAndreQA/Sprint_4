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
    private String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    // Добавляем ЛОКАТОРЫ вопросов и ответов
    private By questionOne = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    private By answerOne = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By questionFive = By.xpath(".//div[@id='accordion__heading-4']");
    private By answerFive = By.xpath(".//div[@id='accordion__panel-4']/p");

    // Добавляем ЛОКАТОР кнопки "Заказать" (вверху страницы)
    private By upOrderButton = By.xpath(".//*[@class='Button_Button__ra12g']");

    // Добавляем ЛОКАТОР кнопки "Заказать" (внизу страницы)
    private By downOrderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Добавляем конструктор класса
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    // БЛОК МЕТОДОВ: //
    // Открыть главную страницу приложения
    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    // Метод "Нажать на вопрос № 1"
    public void clickQuestionOne() {
        // Найди Элемент
        WebElement element = driver.findElement(questionOne);
        // Прокрути страницу до элемента
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        // Дождаться элемент и нажать на него
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(questionOne));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionOne));
        driver.findElement(questionOne).click();
    }

    // Метод "Нажать на вопрос № 5"
    public void clickQuestionFive() {
        // Найди Элемент
        WebElement element = driver.findElement(questionFive);
        // Прокрути страницу до элемента
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        // Дождаться элемент и нажать на него
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(questionFive));
        driver.findElement(questionFive).click();
    }

    // Метод "Нажать на верхнюю кнопку Заказать"
    public void clickUpOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(upOrderButton));
        driver.findElement(upOrderButton).click();
    }

    // Метод "Нажать на нижнюю кнопку Заказать" + скролл
    public void clickDownOrder() {
        // Найди Элемент
        WebElement element = driver.findElement(downOrderButton);
        // Прокрути страницу до элемента
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        // Дождаться элемент и нажать на него
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(downOrderButton));
        driver.findElement(downOrderButton).click();
    }
}