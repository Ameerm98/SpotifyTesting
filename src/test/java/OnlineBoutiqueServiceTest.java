import org.example.DriverFactory;
import org.example.HomePage;
import org.example.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class OnlineBoutiqueServiceTest {
    private WebDriver driver;
    private org.example.OnlineBoutiqueshop.HomePage HomePage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");   // to launch Chrome without GUI
//        driver = new RemoteWebDriver(new URL("http://16.171.132.126:4444"), options);
//        //driver = new ChromeDriver();
//        //driver.manage().window().maximize();
        driver = DriverFactory.getDriver();
        HomePage = new org.example.OnlineBoutiqueshop.HomePage(driver).get();


    }

    @Test
    public void testMakeOrderInDollar() {
        assertTrue(HomePage.selectProduct("2ZYFJ3GM2N").addToCart().placeOrder().isOrderCompleted());
    }
    @Test
    public void testMakeOrderInEuro() {
        assertTrue(HomePage.setCurrency(0).selectProduct("OLJCESPC7Z").addToCart().placeOrder().isOrderCompleted());
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }



}
