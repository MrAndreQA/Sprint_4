package ru.practikum.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Order {
    private WebDriver driver;
    // Добавляем локаторы полей Формы заказа № 1
    private By nameField = By.xpath(".//*[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//*[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.xpath(".//*[@class='select-search__input']");
    private By metroStationRokosovsky = By.xpath(".//*[@class='select-search__row' and @data-index='0']");
    private By metroStationRedGates = By.xpath(".//*[@class='select-search__row' and @data-index='6']");
    private By telephoneField = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    // Добавляем локатор кнопки "Далее" (переход к форме заказа № 2)
    private By buttonNext = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");


    // Добавляем локаторы полей Формы заказа № 2
    private By deliveryDateField = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath(".//*[@class='Dropdown-control']");
    private By rentTwoDays = By.xpath(".//*[@class='Dropdown-option' and text()='двое суток']");

    // ссылка на чек-бокс, где цвет самоката = Черный жемчуг
    private By scooterColorBlack = By.xpath(".//*[@class='Checkbox_Input__14A2w' and @id='black']");

    // ссылка на чек-бокс, где цвет самоката = Серая безысходность
    private By scooterColorGrey = By.xpath(".//*[@class='Checkbox_Input__14A2w' and @id='grey']");

    private By commentForCourierField = By.xpath(".//*[@placeholder='Комментарий для курьера']");

    // Добавляем локатор формы заказа 1-2
    private  By orderForm = By.xpath(".//div[@class='Order_Form__17u6u']");

    // Добавляем локатор кнопки "Заказать" (переход к окну подтверждения заказа)
    private By buttonBook = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Добавляем окно для подтверждения заказа
    private  By windowConfirmOrder = By.xpath(".//*[@class='Order_Modal__YZ-d3']");

    // Добавляем локатор кнопки "Да" при подтверждении заказа (переход на уведомление о заказе)
    private By buttonConfirmOrder = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    // Добавляем локатор окна-сообщения об оформленном заказе
    private By windowSuccessOrder = By.xpath(".//*[@class='Order_ModalHeader__3FDaJ']");


    // Добавляем конструктор класса
    public Order(WebDriver driver) {
        this.driver = driver;
    }


    // Добавляем методы

    // Метод ввода имени + ожидаем загрузку формы заказа № 1
    public void setName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm));
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }
    // Метод ввода фамилии
    public void setSurname(String surname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
    }
    // Метод ввода адреса
    public void setAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }
    // Метод ввода станции метро - "Бульвар Рокосовского"
    public void setMetroStationRokosovsky() {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationRokosovsky).click();
    }
    // Метод ввода станции метро - "Красные ворота"
    public void setMetroStationRedGates() {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationRedGates).click();
    }
    // Метод ввода телефона
    public void setTelephoneField(String telephone) {
        driver.findElement(telephoneField).clear();
        driver.findElement(telephoneField).sendKeys(telephone);
    }
    // Общий метод для ввода Имени, Фамилии, Адреса и Телефона
    public void setRenter (String name, String surname, String address, String telephone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setTelephoneField(telephone);
    }
    // Метод нажатия кнопки "Далее" + ожидаем ее кликабельности(переход к форме заказа № 2)
    public void clickToButtonNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNext));
        driver.findElement(buttonNext).click();
    }
    // Метод ввода даты доставки + ожидаем загрузки формы заказа № 2
    public void setDeliveryDateField(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm));
        driver.findElement(deliveryDateField).click();
        driver.findElement(deliveryDateField).clear();
        driver.findElement(deliveryDateField).sendKeys(date, (Keys.ENTER));
    }
    // Метод выбора срока аренды
    public void setRentalPeriodTwoDays() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentTwoDays).click();
    }
    // Метод выбора черного самоката
    public void clickToBlackScooter() {
        driver.findElement(scooterColorBlack).click();
    }
    // Метод выбора серого самоката
    public void clickToGreyScooter() {
        driver.findElement(scooterColorGrey).click();
    }
    // Метод - оставить комментарий курьеру
    public void setCommentForCourierField(String comment) {
        driver.findElement(commentForCourierField).clear();
        driver.findElement(commentForCourierField).sendKeys(comment);
    }
    // Метод - нажать на кнопку "Заказать" + ожидание кликабельности этой кнопки
    public void clickButtonBook() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonBook));
        driver.findElement(buttonBook).click();
    }
    // Метод - дождаться появления окна-подтверждения заказа + нажимаем кнопку "Да"
    public void clickButtonConfirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(windowConfirmOrder));
        driver.findElement(buttonConfirmOrder).click();
    }
}