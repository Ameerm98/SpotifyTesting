import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class IframeTest {

    WebDriver driver;
    private static final String BASE_URL = "file:///Users/ameermasarwa/IdeaProjects/BeyonDev4/selenium_exercises/iframe.html";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void playpausetest() throws InterruptedException {
        driver.navigate().to(BASE_URL);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        WebElement playButton = driver.findElement(By.cssSelector(".playButton.medium"));
        playButton.click();
        WebElement pauseButton = driver.findElement(By.className("playButton__overlay"));
        pauseButton.click();
        driver.switchTo().defaultContent();
    }

    @Test
    public void likedsignintest() throws InterruptedException {
        driver.navigate().to(BASE_URL);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        WebElement playButton = driver.findElement(By.cssSelector(".playButton.medium"));
        playButton.click();
        WebElement heartbutton = driver.findElement(By.cssSelector(".likeButton"));
        heartbutton.click();
        Thread.sleep(2000);
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        Thread.sleep(2000);
        WebElement google = driver.findElement(By.cssSelector(".google-plus-signin"));
        google.click();
        Thread.sleep(2000);
        windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[2]);
        driver.close();
        Thread.sleep(2000);
        driver.switchTo().window((String) windowHandles[1]);
        driver.close();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
