import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;


public class ImportantQuestionsTest {
    private WebDriver driver;


    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }


    public ImportantQuestionsTest() {

    }

    @Test
    public void checkImportantQuestionsList_textAnswerIsDisplayedCorrectly_AfterClick () {
        MainPage page = new MainPage(driver);
        page.clickImportantQuestion();
    }

    @After
    public void tearDown () {
        driver.quit();
    }
}

