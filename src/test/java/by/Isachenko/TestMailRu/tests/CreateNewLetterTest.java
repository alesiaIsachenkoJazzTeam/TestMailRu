package by.Isachenko.TestMailRu.tests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Slf4j
class CreateNewLetterTest extends TestBase {

    /**
     *  test -- create a new letter
     *  @param - String array ()
     */
    @ParameterizedTest
    @CsvSource("testLab2019@mail.ru, Стихи про осень., Унылая пора! Очей очарованье!")
    void CreateNewLetterTest(String fieldTo, String subject, String text) {
        app.navigateToLoginPage();
        app.loginToTestAccount();
        app.createNewLetter(fieldTo, subject, text);
        app.goToMailPage();
        log.info("Test is over.");
    }
}
