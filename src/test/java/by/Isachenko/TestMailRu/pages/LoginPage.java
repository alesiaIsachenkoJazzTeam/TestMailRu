package by.Isachenko.TestMailRu.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class LoginPage extends Page
 */
@Slf4j
public class LoginPage extends Page{

    @FindBy(css="form [value='Ввести пароль']")
    private WebElement passwordButton;

    @FindBy(css="[value='Войти']")
    private WebElement loginButton;

    @FindBy(css="[id='mailbox:password']")
    private WebElement passwordField;

    @FindBy(css="[id='mailbox:login']")
    private WebElement loginField;

    @FindBy(css="[title=Выход]")
    private WebElement exitButton;

    /** locator - button "Password" */
    private final By passwordButtonLocator = By.cssSelector(".mailbox__body [value='Ввести пароль']");

    /** locator - button "Exit" */
    private final By exitdButtonLocator = By.cssSelector("[title=Выход]");

    /**
     * Parameterized constructor*
     * @param driver - WebDriver
     */
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     * method -- click Exit (if this element is on the page)
     * @return -- LoginPage
     */
    public LoginPage checkExit(){
        if (areElementsPresent(exitdButtonLocator)){
            exitButton.click();
        }
        return this;
    }

    /**
     * method -- enter login Name
     * @param loginName - login name
     * @return -- LoginPage
     */
    public LoginPage typeLogin(String loginName){
        loginField.clear();
        loginField.sendKeys(loginName);
        log.info("Set Login -- {}.", loginName);
        return this;
    }

    /**
     * method -- enter password
     * @param password - password
     * @return -- LoginPage
     */
    public LoginPage typePassword(String password){
        if (areElementsPresent(passwordButtonLocator)){
            WebElement form = driver.findElement(By.cssSelector("form#auth"));
            form.findElement(By.cssSelector("[value='Ввести пароль']")).click();
        }
        passwordField.clear();
        passwordField.sendKeys(password);
        log.info("Set Password  -- {}.", password);
        return this;
    }

    /**
     * method -- click button Log In
     */
    public void submitLogin(){
        if (areElementsPresent(passwordButtonLocator)){
            passwordButton.click();
        }else{
            loginButton.click();
        }
        log.info("Click -- Log in.");
    }
}
