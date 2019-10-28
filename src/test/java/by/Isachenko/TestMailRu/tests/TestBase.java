package by.Isachenko.TestMailRu.tests;
import by.Isachenko.TestMailRu.app.Application;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    /**
     * method -- start the driver. exit the driver, when all tests have been completed
     */
    @BeforeEach
    public  void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }
}
