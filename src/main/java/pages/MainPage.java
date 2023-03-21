package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.util.Arrays;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver driver;
    private final By UpOrderButton = (By.className("Button_Button__ra12g"));
    private final By importantQuestionsList = (By.xpath(".//div[@data-accordion-component='AccordionItemHeading']"));
    private final By importantQuestions =
            (By.xpath(".//div[@data-accordion-component='AccordionItemHeading']"));
    private final By answerRelativeLocator = RelativeLocator.with(By.tagName("p")).below(importantQuestions);
    public String[] actualAnswers = new String[8];

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.actualAnswers = actualAnswers;
    }

    public String[] getActualAnswers() {return actualAnswers;}

    public OrderPage clickUpOrderButton() {
        driver.findElement(UpOrderButton).click();
        return new OrderPage(driver);
    }

    public MainPage clickImportantQuestion() {

        List<WebElement> questionElementsList = driver.findElements(importantQuestions);
        int i = 0;
        for (WebElement elementWithQuestion : questionElementsList) {
            //прокрутка
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementWithQuestion);
            elementWithQuestion.click();
            //занесем отображаемый текст в строковый массив
            actualAnswers[i] = driver.findElement(answerRelativeLocator).getText();
            System.out.println(actualAnswers[i]);

        }
        return this;
    }
}

