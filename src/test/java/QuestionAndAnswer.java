import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
@RunWith(Parameterized.class)
public class QuestionAndAnswer {
    private WebDriver driver;
    public By question;
    public By locator;
    public String answer;
    public static By question1 = By.id("accordion__heading-0");
    public static By answer1Locator = By.xpath("//*[@id='accordion__panel-0']/p");
    public final static String answer1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    public static By question2 = By.id("accordion__heading-1");
    public static By answer2Locator = By.xpath("//*[@id='accordion__panel-1']/p");
    public final static String answer2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    public static By question3 = By.id("accordion__heading-2");
    public static By answer3Locator = By.xpath("//*[@id='accordion__panel-2']/p");
    public final static String answer3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    public static By question4 = By.id("accordion__heading-3");
    public static By answer4Locator = By.xpath("//*[@id='accordion__panel-3']/p");
    public final static String answer4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    public static By question5 = By.id("accordion__heading-4");
    public static By answer5Locator = By.xpath("//*[@id='accordion__panel-4']/p");
    public final static String answer5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    public static By question6 = By.id("accordion__heading-5");
    public static By answer6Locator = By.xpath("//*[@id='accordion__panel-5']/p");
    public final static String answer6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    public static By question7 = By.id("accordion__heading-6");
    public static By answer7Locator = By.xpath("//*[@id='accordion__panel-6']/p");
    public final static String answer7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    public static By question8 = By.id("accordion__heading-7");
    public static By answer8Locator = By.xpath("//*[@id='accordion__panel-7']/p");
    public final static String answer8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public QuestionAndAnswer(By question, By locator, String answer) {
        this.question = question;
        this.locator = locator;
        this.answer = answer;
    }
    @Parameterized.Parameters
    public static Object[][] getDataForTest() {
        return new Object[][]{
                { question1, answer1Locator, answer1},
                { question2, answer2Locator, answer2},
                { question3, answer3Locator, answer3},
                { question4, answer4Locator, answer4},
                { question5, answer5Locator, answer5},
                { question6, answer6Locator, answer6},
                { question7, answer7Locator, answer7},
                { question8, answer8Locator, answer8},
      };
    }
    @Before
    public void setBrowser() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options); }
    @After
    public void teardown() {
        driver.quit();}

    // Проверка всех текстов ответов на вопросы
    @Test
    public void checkAnswers() {
        // создаем объект класса главной страницы приложения
        HomePage objHomePage = new HomePage(driver);
        // переход на главную страницу тестового приложения
        objHomePage.openMainPage();
        // клик на вопрос
        objHomePage.clickToQuestion(question);
        // проверяем текст ответа на вопрос
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String expected = answer;
        String actual = driver.findElement(locator).getText();
        String message = "Ошибка: Неверный текст ответа на вопрос";
        assertEquals(message, actual,expected);
    }
}