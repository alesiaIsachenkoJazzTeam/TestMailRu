package by.Isachenko.TestMailRu.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;

/**
 * Class Page
 */
@Slf4j
public abstract class Page {
    protected WebDriver driver;

    protected WebDriverWait wait;

    @FindBy(css="#ph_mail")
    private WebElement hrefMailEl;

    @FindBy(css="[title=\"Фильтр по письмам\"]")
    private WebElement filterEl;

    /**
     * Parameterized constructor*
     * @param driver - WebDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 4);
        PageFactory.initElements(driver, this);
    }

    /**
     * method - go to main page "Входящие - Почта Mail.ru"
     */
    public final void submitMail(){
        hrefMailEl.click();
        wait.until(ExpectedConditions.visibilityOf(filterEl));
        log.info("Went to the main page.");
    }

    /**
     * method determines the presence of elements on the page
     * @return true - list size > 0
     * @return false - list size = 0
     */
    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    /**
     * method determines the presence of an element on the page
     * @return true - the element is on the page
     * @return false - the element is not on the page
     */
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex) {
            throw ex;
        }catch (NoSuchElementException ex) {
            return false;
        }
    }

}
