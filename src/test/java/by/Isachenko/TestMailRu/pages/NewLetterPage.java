package by.Isachenko.TestMailRu.pages;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class NewLetterPage extends Page
 */
@Slf4j
public class NewLetterPage extends Page{

    @FindBy(css="[data-name=to] [type=text]")
    private WebElement toField;

    @FindBy(css="[name=Subject]")
    private WebElement topicField;

    @FindBy(css=".cke_editable")
    private WebElement editTable;

    @FindBy(css="[title=Отправить]")
    private WebElement sendLetterButton;

    /** locator - to find button "Send" */
    private final By sendLetterLocator = By.cssSelector("[title=Отправить]");

    /** locator - to find button "Save as template" */
    private final By sentPageMessageLocator = By.cssSelector(".layer-sent-page .button2__txt");

    /**
     * Parameterized constructor
     * @param driver - WebDriver
     */
    public NewLetterPage(WebDriver driver){
        super(driver);
    }

    /**
     * method -- enter data in the To field
     * @param to - mail addressee
     * @return -- NewLetterPage
     */
    public NewLetterPage typeTo(String to){
        toField.sendKeys(to);
        log.info("Set To -- {}.", to);
        return this;
    }

    /**
     * method -- enter data in the Subject field
     * @param topic - topic of the letter
     * @return -- NewLetterPage
     */
    public NewLetterPage typeTopic(String topic){
        topicField.sendKeys(topic);
        log.info("Set Topic -- {}.", topic);
        return this;
    }

    /**
     * method -- enter data to letter body
     * @param text - message text
     * @return -- NewLetterPage
     */
    public NewLetterPage typeBodyText(String text){
        editTable.clear();
        editTable.sendKeys(text);
        log.info("Set Text.");
        return this;
    }

    /**
     * method -- click "Send"
     */
    public void submitSendLetter(){
        if (areElementsPresent(sendLetterLocator)){
            sendLetterButton.click();
            log.info("Click -- Send.");
        }
    }

    /**
     * Method - check to see if an email has been sent
     */
    public void checkSendEmail(){
        assertTrue(isElementPresent(sentPageMessageLocator));
    }

    /**
     * method -- waiting for the page to load (waiting for a unique element)
     */
    public void waitLoadPage(){
        wait.until(ExpectedConditions.visibilityOf(sendLetterButton));
    }
}
