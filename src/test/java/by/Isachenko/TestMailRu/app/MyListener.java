package by.Isachenko.TestMailRu.app;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

@Slf4j
public class MyListener extends AbstractWebDriverEventListener {
    /**
     * listener - print locator before find
     */
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Find element -- {}.", by);
    }

    /**
     * listener - print locator after find
     */
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Element was found -- {}.", by);
    }

    /**
     * listener - print url before navigate to
     */
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info("Navigate to -- {}.", url);
    }

    /**
     * listener - print Exception
     */
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        log.info("Exception -- {}.", throwable);
    }
}
