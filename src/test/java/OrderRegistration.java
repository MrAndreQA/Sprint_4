import ru.practikum.pageobject.HomePage;
import ru.practikum.pageobject.Order;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.*;

public class OrderRegistration {
    private WebDriver driver;

    @Before
    public void setBrowser() { // Поставили во всех тестах Хром
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options); }
    @After
    public void teardown() {  // Закрываем браузер
        driver.quit();}

    // Офомление заказа на серый самокат через нижнюю кнопку "Заказать"
    @Test
    public void registerGrayDownOrder() {
        // создаем объект класса главной страницы приложения
        HomePage objHomePage = new HomePage(driver);
        // создаем объект класса страницы заказа
        Order objOrder = new Order(driver);
        // переход на главную страницу тестового приложения
        objHomePage.openMainPage();
        // нажимаем на нижнюю кнопку "Заказать"
        objHomePage.clickDownOrder();
        // Вводим Имя, Фамилию, Адрес и Телефон
        objOrder.setRenter("Джон", "Леннон", "Дакота", "89996331239");
        // Выбираем станцию Метро
        objOrder.setMetroStationRedGates();
        // Нажимаем на кнопку "Далее"
        objOrder.clickToButtonNext();
        // Ожидаем загрузки формы заказа № 2 и заполняем поле "Дата доставки"
        objOrder.setDeliveryDateField("08.12.1980");
        // Выбираем срок аренды
        objOrder.setRentalPeriodTwoDays();
        // Выбираем черный самокат
        objOrder.clickToGreyScooter();
        // Оставляем комментарий курьеру
        objOrder.setCommentForCourierField("Imagine!");
        // Нажимаем на кнопку "Заказать"
        objOrder.clickButtonBook();
        // Нажимаем на кнопку "Да" (подтверждаем заказ)
        objOrder.clickButtonConfirmOrder();

        // Ожидаем окна-сообщения об оформленном заказе  и проверяем, что окно содержит текст
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='Order_ModalHeader__3FDaJ']")));
        String expected = "Заказ оформлен";
        String actual = driver.findElement(By.xpath(".//*[@class='Order_ModalHeader__3FDaJ']")).getText();
        MatcherAssert.assertThat(actual, containsString(expected));
    }

    // Офомление заказа на черный самокат через верхнюю кнопку "Заказать"
    @Test
    public void registerBlackUpOrder() {
        // создаем объект класса главной страницы приложения
        HomePage objHomePage = new HomePage(driver);
        // создаем объект класса страницы заказа
        Order objOrder = new Order(driver);
        // переход на главную страницу тестового приложения
        objHomePage.openMainPage();
        // нажимаем на верхню кнопку "Заказать"
        objHomePage.clickUpOrder();
        // Вводим Имя, Фамилию, Адрес и Телефон
        objOrder.setRenter("Глеб", "Жеглов", "Сокольническая площадь, 4", "89241283211");
        // Выбираем станцию Метро
        objOrder.setMetroStationRokosovsky();
        // Нажимаем на кнопку "Далее"
        objOrder.clickToButtonNext();
        // Ожидаем загрузки формы заказа № 2 и заполняем поле "Дата доставки"
        objOrder.setDeliveryDateField("27.02.2023");
        // Выбираем срок аренды
        objOrder.setRentalPeriodTwoDays();
        /// Выбираем черный самокат
        objOrder.clickToBlackScooter();
        // Оставляем комментарий курьеру
        objOrder.setCommentForCourierField("Место встречи изменить нельзя!");
        // Нажимаем на кнопку "Заказать"
        objOrder.clickButtonBook();
        // Нажимаем на кнопку "Да" (подтверждаем заказ)
        objOrder.clickButtonConfirmOrder();

        /// Ожидаем окна-сообщения об оформленном заказе  и проверяем, что окно содержит текст
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='Order_ModalHeader__3FDaJ']")));
        String expected = "Заказ оформлен";
        String actual = driver.findElement(By.xpath(".//*[@class='Order_ModalHeader__3FDaJ']")).getText();;
        MatcherAssert.assertThat(actual, containsString(expected));
    }
}