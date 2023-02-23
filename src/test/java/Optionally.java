import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practikum.pageobject.OptionallyMainPage;


public class Optionally {

    private static final By INPUT_FIELD = By.xpath(".//*[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private static final By STATUS_STATE_BUTTON = By.cssSelector("button.Header_Link__1TAG7");
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By GO_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    private static final By IMG_NOT_FOUND = By.cssSelector("div.Track_NotFound__6oaoY > img");

    private WebDriver driver;

    @Before
    public void setUp() {driver = new ChromeDriver();}
    @After
    public void tearDown() {driver.quit();}


    @Test
    public void findOrder_withPom_expectNotFound() {
        OptionallyMainPage page = new OptionallyMainPage(driver);
        page.open();
        page.clickOrderStatusButton();
        page.enterOrderNumber("1234");
        Assert.assertTrue(page.isImageNotFoundDisplayed());
    }
}

