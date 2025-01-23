import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;




public class WebFormAccessibilityTest {

    WebDriver driver;
    private static final String baseURL = "https://www.selenium.dev/selenium/web/web-form.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }



    @Test
    public void testWebFormAccessibility(){
        driver.get(baseURL);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        WebElement textInputElm = driver.findElement(By.id("my-text-id"));
        assertEquals(textInputElm,driver.switchTo().activeElement());
        action.sendKeys("john").perform();
        assertEquals("john",driver.findElement(By.id("my-text-id")).getDomProperty("value"));
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys("1234").perform();
        assertEquals("1234",driver.findElement(By.name("my-password")).getDomProperty("value"));
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys("Elvis has left the building").perform();
        assertEquals("Elvis has left the building",driver.findElement(By.name("my-textarea")).getDomProperty("value"));
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        WebElement selectElm = driver.findElement(By.id("my-select"));
        assertEquals(selectElm,driver.switchTo().activeElement());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        Select select = new Select(selectElm);
        assertEquals("Two",select.getFirstSelectedOption());
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        WebElement dataListElm = driver.findElement(By.id("my-datalist"));
        assertEquals("Seattle",dataListElm.getDomProperty("value"));
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        WebElement checkedBox = driver.findElement(By.id("my-check-1"));
        assertEquals(checkedBox,driver.switchTo().activeElement());
        if (!driver.switchTo().activeElement().isSelected()){
            action.sendKeys(Keys.SPACE).perform();
        }
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.SPACE).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        WebElement myRange = driver.findElement(By.name("my-range"));
        assertEquals(myRange,driver.switchTo().activeElement());
        action.keyDown(Keys.ARROW_RIGHT);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        action.keyUp(Keys.ARROW_RIGHT);
    }

    @AfterEach
    public void close(){
        driver.quit();
    }






}
