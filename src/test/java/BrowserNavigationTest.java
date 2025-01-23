import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;


public class BrowserNavigationTest {
    WebDriver driver;

    private static final String baseFile = "file:///Users/ameermasarwa/IdeaProjects/BeyonDev4/selenium_exercises/pagination/pagination1.html";
    private static final String expectedPageTitle = "Spotify Clone";
    private static final String expectedPageMessage = "Oops.... Not Available";

    @BeforeEach
    public void set(){
        driver = new ChromeDriver();
        driver.get(baseFile);
    }


    @Test
    public void testBackForward(){

        WebElement page2 = driver.findElement(By.id("page-number2"));
        page2.click();
        assertEquals("Welcome to Page 2! This is the content of the first page.",driver.findElement(By.cssSelector("div[id=content] p")).getText());
        driver.navigate().back();
        assertEquals("Welcome to Page 1! This is the content of the first page.",driver.findElement(By.cssSelector("div[id=content] p")).getText());
        driver.navigate().forward();
        assertEquals("Welcome to Page 2! This is the content of the first page.",driver.findElement(By.cssSelector("div[id=content] p")).getText());
    }

    @Test
    public void testJumpToPage(){


        WebElement jumpToPage = driver.findElement(By.id("jump-to-page"));
        jumpToPage.click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("2");
        prompt.accept();
        assertEquals("Welcome to Page 2! This is the content of the first page.",driver.findElement(By.cssSelector("div[id=content] p")).getText());
    }


    @Test
    public void testHoveringOnClickableButton(){
        WebElement page2 = driver.findElement(By.id("page-number2"));

        String colorBefore = page2.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(page2).perform();
        String colorAfter = page2.getCssValue("background-color");
        assertNotEquals(colorAfter,colorBefore);
        WebElement page1 = driver.findElement(By.id("page-number1"));
        String colorBefore1 = page1.getCssValue("background-color");
        actions.moveToElement(page1).perform();
        String colorAfter1 = page1.getCssValue("background-color");
        assertEquals(colorAfter1,colorBefore1);
    }

    @Test
    public void testNextButton(){
        WebElement next = driver.findElement(By.id("next"));
        next.click();
        WebElement page2 = driver.findElement(By.id("page-number2"));
        assertFalse(page2.isEnabled());
    }


    @AfterEach
    public void close(){
        driver.quit();
    }
}
