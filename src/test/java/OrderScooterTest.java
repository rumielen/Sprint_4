import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.MainPage;


import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final String clName;
    private final String clSurname;
    private final String clAddress;
    private final String clMetro;
    private final String clPhone;
    private final String clDelivery;
    private final String clRentTime;
    private final String clColor;
    private final String clComment;
    private WebDriver driver;


    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    public OrderScooterTest (String clName, String clSurname, String clAddress, String clMetro, String clPhone, String clDelivery, String clRentTime, String clColor, String clComment) {
        this.clName = clName;
        this.clSurname = clSurname;
        this.clAddress = clAddress;
        this.clMetro = clMetro;
        this.clPhone = clPhone;
        this.clDelivery = clDelivery;
        this.clRentTime = clRentTime;
        this.clColor = clColor;
        this.clComment = clComment;
    }

    @Parameterized.Parameters
    public static Object[][] getClientInformation() {
        return new Object[][] {
                { "Иван", "Иванов", "Ленина 168", ".//div[text()='Черкизовская']", "79001205522", ".//div[@class='react-datepicker__day react-datepicker__day--024']", ".//div[text()='двое суток']", "black", "Побыстрее"},
                { "Петр", "Сидоров", "Московская 12", ".//div[text()='Сокольники']", "79998881155", ".//div[@class='react-datepicker__day react-datepicker__day--023']", ".//div[text()='сутки']", "grey", "Привет"},
        };
    }



    @Test
    public void checkShowsWindow_orderSuccessDone_positiveCase() {
        boolean isOrderSuccessDisplayed;
        isOrderSuccessDisplayed = new MainPage(driver)
                .clickUpOrderButton()
                .setName(clName) // заполняем поле Имя
                .setSurname(clSurname)  // заполняем поле Фамилия
                .setAddress(clAddress)  // заполняем поле Адрес
                .setMetro(clMetro)
                .setPhone(clPhone)
                .clickNextPageButtonOrderForm()
                .setDeliveryDate(clDelivery)
                .setRentPeriod(clRentTime)
                .setColorScooter(clColor)
                .setComment(clComment)
                .clickDoOrderButton()
                .orderSuccessDoneIsDisplayed();
        assertTrue(isOrderSuccessDisplayed);


    }
    @After
    public void tearDown () {
        driver.quit();
    }
}
