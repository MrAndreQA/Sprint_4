import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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

@RunWith(Parameterized.class)
public class OrderRegistration {
    private WebDriver driver;

    public String name;
    public final static String name1 = "Джон";
    public final static String name2 = "Глеб";
    public String surname;
    public final static String surname1 = "Леннон";
    public final static String surname2 = "Жеглов";
    public String address;
    public final static String address1 = "Дакота";
    public final static String address2 = "Сокольническая площадь, 4";
    public By metroStation;
    public static By metroStation1 = By.xpath(".//*[@class='select-search__row' and @data-index='0']");
    public static By metroStation2 = By.xpath(".//*[@class='select-search__row' and @data-index='6']");
    public String telephone;
    public final static String telephone1 = "89996331239";
    public final static String telephone2 = "89241283211";
    public String deliveryDate;
    public final static String deliveryDate1 = "08.12.1980";
    public final static String deliveryDate2 = "27.02.2023";
    public By rentDays;
    public static By rentDays1 = By.xpath(".//*[@class='Dropdown-option' and text()='сутки']");
    public static By rentDays2 = By.xpath(".//*[@class='Dropdown-option' and text()='двое суток']");
    public By scooterColor;
    public static By scooterColor1 = By.xpath(".//*[@class='Checkbox_Input__14A2w' and @id='black']");
    public static By scooterColor2 = By.xpath(".//*[@class='Checkbox_Input__14A2w' and @id='grey']");
    public String commentForCourier;
    public final static String commentForCourier1 = "Imagine!";
    public final static String commentForCourier2 = "Место встречи изменить нельзя!";
    public By orderButton;
    public static By orderButton1 = By.xpath(".//*[@class='Button_Button__ra12g']");
    public static By orderButton2 = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderRegistration(String name, String surname, String address, By metroStation, String telephone,
                             String deliveryDate, By rentDays, By scooterColor, String commentForCourier, By orderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.deliveryDate = deliveryDate;
        this.rentDays = rentDays;
        this.scooterColor = scooterColor;
        this.commentForCourier = commentForCourier;
        this.orderButton = orderButton;
    }
    @Parameterized.Parameters
    public static Object[][] getDataTest() {
        return new Object[][]{
                {name1, surname1, address1, metroStation1, telephone1, deliveryDate1, rentDays1, scooterColor1, commentForCourier1, orderButton1},
                {name2, surname2, address2, metroStation2, telephone2, deliveryDate2, rentDays2, scooterColor2, commentForCourier2, orderButton2},
        };
        }
    @Before
    public void setBrowser() { // Поставили во всех тестах Хром
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);}
        @After
    public void teardown() {  // Закрываем браузер
        driver.quit();}

    // Офомление заказа
    @Test
    public void registerOrder() {
        // создаем объект класса главной страницы приложения
        HomePage objHomePage = new HomePage(driver);
        // создаем объект класса страницы заказа
        Order objOrder = new Order(driver);//
        // переход на главную страницу тестового приложения
        objHomePage.openMainPage();
        // нажимаем на кнопку "Заказать"
        objHomePage.clickToOrderButton(orderButton);
        // Вводим Имя, Фамилию, Адрес, Телефон и Метро + нажать кнопку "Далее"
         objOrder.setRenter(name, surname, address, telephone, metroStation);
        // Ожидаем загрузки формы заказа № 2. Вводим: дату доставки, срок аренды, цвет самоката и комментарий. Жмем на "Заказать" > "Да"
        objOrder.setOrderOptions(deliveryDate, rentDays, scooterColor,commentForCourier);
        // Ожидаем окна-сообщения об оформленном заказе  и проверяем, что окно содержит текст "Заказ оформлен"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='Order_ModalHeader__3FDaJ']")));
        String expected = "Заказ оформлен";
        String actual = driver.findElement(By.xpath(".//*[@class='Order_ModalHeader__3FDaJ']")).getText();
        MatcherAssert.assertThat(actual, containsString(expected));
    }
}