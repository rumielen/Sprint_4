package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;



public class OrderPage {
    private final WebDriver driver;
    private final By nameField = (By.xpath(".//div/input[@placeholder='* Имя']"));
    private final By surnameField = (By.xpath(".//div/input[@placeholder='* Фамилия']"));
    private final By addressField = (By.xpath(".//div/input[@placeholder='* Адрес: куда привезти заказ']"));
    private final By metroField = (By.xpath(".//input[@placeholder='* Станция метро']"));
    private final By metroStationList = (By.xpath(".//div[@class='select-search__select']"));
    private final By phoneField = (By.xpath(".//div/input[@placeholder='* Телефон: на него позвонит курьер']"));
    private final By nextButton = (By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    private final By calendarField = (By.xpath(".//input[@placeholder='* Когда привезти самокат']"));
    private final By fieldRentalPeriod = (By.xpath(".//div[@class='Dropdown-placeholder']"));
    private final By rentPeriodList = (By.xpath(".//div[@class='Dropdown-menu']"));
    private final By scooterBlackColor = (By.xpath(".//label[@for='black']"));
    private final By scooterGreyColor = (By.xpath(".//label[@for='grey']"));
    private final By commentCourier = (By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']"));
    private final By doOrderButton = (By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    private final By yesDoOrderButton = (By.xpath(".//button[text()='Да']"));
    private final By orderSuccessDone = (By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']"));
    public OrderPage (WebDriver driver){
        this.driver = driver;
    }

    //метод для заполнения полей Имя, Фамилия, Адрес, Телефон
    // проверяет открытость поля, удаяет текст из поля, вводит новое значение из параметра

    //заполнить поле Имя
    public OrderPage setName(String clientName) {
        //проверка открытости поля
        Assert.assertTrue(driver.findElement(nameField).isEnabled());
        // ввод нового значения
        driver.findElement(nameField).sendKeys(clientName);
        return this;
    }

    //заполнить поле Фамилия
    public OrderPage setSurname(String clientSurname) {
        //проверка открытости поля
        Assert.assertTrue(driver.findElement(surnameField).isEnabled());
        // ввод нового значения
        driver.findElement(surnameField).sendKeys(clientSurname);
        return this;
    }
    //заполнить поле Адрес
    public OrderPage setAddress(String clientAddress) {
        //проверка открытости поля
        Assert.assertTrue(driver.findElement(addressField).isEnabled());
        // ввод нового значения
        driver.findElement(addressField).sendKeys(clientAddress);
        return this;
    }

    // выбрать станцию метро
    public OrderPage setMetro(String clientMetro) {

        driver.findElement(metroField).click();
        List<WebElement> elements = driver.findElements(metroStationList);
        for (WebElement element : elements) {
            element.findElement(By.xpath(clientMetro)).click();
        }
        return this;
    }

    public OrderPage setPhone(String clientPhone) {
        //проверка открытости поля
        Assert.assertTrue(driver.findElement(phoneField).isEnabled());
        // ввод нового значения
        driver.findElement(phoneField).sendKeys(clientPhone);
        return this;
    }

    public OrderPage setDeliveryDate(String clientDeliveryDate) {

        driver.findElement(calendarField).click();
        driver.findElement(By.xpath(clientDeliveryDate)).click();

        return this;
    }

    public OrderPage setRentPeriod(String clientRentPeriod) {

        driver.findElement(fieldRentalPeriod).click();
        List<WebElement> elements = driver.findElements(rentPeriodList);
        for (WebElement element : elements) {
            element.findElement(By.xpath(clientRentPeriod)).click();
        }
        return this;
    }

    public OrderPage setColorScooter(String clientColor) {

        if (clientColor.equals("black")) {
            driver.findElement(scooterBlackColor).click();
        }
        if (clientColor.equals("grey")) {
            driver.findElement(scooterGreyColor).click();
        }
        return this;
    }

    public OrderPage setComment(String clientComment) {
        driver.findElement(commentCourier).sendKeys(clientComment);
        return this;
    }



    // метод для нажатия на кнопку Далее, Заказать
    public OrderPage clickNextPageButtonOrderForm() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage clickDoOrderButton() {
        driver.findElement(doOrderButton).click();
        driver.findElement(yesDoOrderButton).click();
        return this;
    }


    public boolean orderSuccessDoneIsDisplayed() {
        boolean orderDoneSuccessWindowIsDisplayed = driver.findElement(orderSuccessDone).isDisplayed();
        return orderDoneSuccessWindowIsDisplayed;

    }
}
