package by.Isachenko.TestMailRu.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class MailPage extends Page
 */
@Slf4j
public class MailPage extends Page{
    @FindBy(css="[title*='Написать письмо']")
    private WebElement createNewLetter;

    @FindBy(css="[title=\"Фильтр по письмам\"]")
    private WebElement filterEl;
    /**
     * Parameterized constructor*
     * @param driver - WebDriver
     */
    public MailPage(WebDriver driver){
        super(driver);
    }

    /**
     * method -- click create New Letter
     */
    public void submitCreateNewLetter() {
        createNewLetter.click();
        log.info("Click -- New letter.");
    }

    /**
     * method -- waiting for the page to load (waiting for a unique element)
     */
    public void waitLoadPage(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewLetter));
    }
}
