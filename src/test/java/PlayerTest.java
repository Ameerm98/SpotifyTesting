import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlayerTest {
    WebDriver driver;

    private static final String baseURL = "http://localhost:8082";
    private static final String expectedPageTitle = "Spotify Clone";
    private static final String expectedPageMessage = "Oops.... Not Available";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    void testPlayButton() {
        driver.get(baseURL);
        WebElement playerButton = driver.findElement(By.id("masterPlay"));
        playerButton.click();
        String currentStart = driver.findElement((By.id("currentStart"))).getText();
        String res = String.valueOf(currentStart.charAt(0));
        res =res.concat(String.valueOf(currentStart.charAt(2)));
        res= res.concat(String.valueOf(currentStart.charAt(3)));
        Integer time = Integer.parseInt(res);

        assertTrue(time>0);
    }

    @Test
    void testClickingSong() {
        driver.get(baseURL);
        WebElement img = driver.findElement(By.cssSelector(".img_play img[src]"));
        img.click();
        String currentStart = driver.findElement((By.id("currentStart"))).getText();
        String res = String.valueOf(currentStart.charAt(0));
        res =res.concat(String.valueOf(currentStart.charAt(2)));
        res= res.concat(String.valueOf(currentStart.charAt(3)));
        Integer time = Integer.parseInt(res);

        assertTrue(time>0);
    }


    @AfterEach
    public void teardown() {
        driver.quit();
    }
}



