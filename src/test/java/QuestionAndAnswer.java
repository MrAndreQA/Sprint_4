import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practikum.pageobject.HomePage;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

// Тест проверки вопросов и ответов
public class QuestionAndAnswer {
    private WebDriver driver;

    @Before
    public void setBrowser() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options); }
    @After
    public void teardown() {
        driver.quit();}

    // Проверка текста ответа на вопрос № 1
    @Test
    public void checkAnswerOne() {
        // создаем объект класса главной страницы приложения
        HomePage objHomePage = new HomePage(driver);
        // переход на главную страницу тестового приложения
        objHomePage.openMainPage();
        ////// "Нажать на вопрос № 5"
        objHomePage.clickQuestionOne();
        // проверяем текст ответа на вопрос
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-0']/p")));
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = driver.findElement(By.xpath(".//div[@id='accordion__panel-0']/p")).getText();
        String message = "Ошибка: Неверный текст ответа на вопрос";
        assertEquals(message, actual,expected);
    }

    // Проверка текста ответа на вопрос № 5
    @Test
    public void checkAnswerFive() {
        // создаем объект класса главной страницы приложения
        HomePage objHomePage = new HomePage(driver);
        // переход на главную страницу тестового приложения
        objHomePage.openMainPage();
        ////// "Нажать на вопрос № 5"
        objHomePage.clickQuestionFive();

        // проверяем текст ответа на вопрос
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-4']/p")));
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = driver.findElement(By.xpath(".//div[@id='accordion__panel-4']/p")).getText();
        String message = "Ошибка: Неверный текст ответа на вопрос";
        assertEquals(message, expected, actual);
    }
}