import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class WebFormTest {
    WebDriver driver;
    private static final String baseURL = "https://www.selenium.dev/selenium/web/web-form.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testTextInputField(){
        driver.get(baseURL);
        WebElement textField = driver.findElement(By.id("my-text-id"));
        textField.sendKeys("Ameer Masarwa");
        String s = textField.getAttribute("value");
        assertEquals("Ameer Masarwa", s);
    }

    @Test
    public void testTextArea(){
        driver.get(baseURL);
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        textArea.sendKeys("trying to test the webform using sellenium");
        String s = textArea.getAttribute("value");
        assertEquals("trying to test the webform using sellenium", s);
    }

    @Test
    public void testDisabledInputField(){
        driver.get(baseURL);
        WebElement Disabled = driver.findElement(By.name("my-disabled"));
        try {
            Disabled.sendKeys("Bla Bla");
        } catch (ElementNotInteractableException e) {

        }
    }
    @Test
    public void testreadOnlyField(){
        driver.get(baseURL);
        WebElement readOnlyField = driver.findElement(By.name("my-readonly"));
        String s = readOnlyField.getAttribute("value");
        assertEquals("Readonly input", s);
        readOnlyField.sendKeys("I cant Write");
        s = readOnlyField.getAttribute("value");
        assertEquals("Readonly input", s);
    }

    @Test
    public void testDropDownSelect(){
        driver.get(baseURL);
        WebElement selectElement = driver.findElement(By.className("form-select"));
        Select select = new Select(selectElement);
        WebElement oneElement = driver.findElement(By.cssSelector("option[value]"));
        select.selectByValue("1");
        assertTrue(oneElement.isSelected());
    }

    @Test
    public void testDropDownDataList(){
        driver.get(baseURL);
        WebElement dropDownDataListInput = driver.findElement(By.name("my-datalist"));
        dropDownDataListInput.click();
        dropDownDataListInput.sendKeys("Seattle");
        ///WebElement seattleOption = driver.findElement(By.cssSelector("option[value=Seattle]"));
        assertEquals("Seattle",dropDownDataListInput.getDomProperty("value"));


    }

    @Test
    public void testSubmit(){
        driver.get(baseURL);
        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();
        WebElement title = driver.findElement(By.className("display-6"));
        assertEquals("Form submitted",title.getText());

    }

    @Test
    public void testAddBoxAndTextBox(){
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement addBox = driver.findElement(By.id("adder"));
        addBox.click();
        addBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        WebElement box1 = driver.findElement(By.id("box1"));
        assertTrue(box1!=null);
        WebElement revealButton = driver.findElement(By.id("reveal"));
        WebElement revealed = driver.findElement(By.id("revealed"));
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(3),Duration.ofMillis(500));
        revealButton.click();
        wait.until(d->revealed.isDisplayed());
        revealed.sendKeys("ameer masarwa");
        assertEquals("ameer masarwa",revealed.getDomProperty("value"));

    }

    @AfterEach
    public void end(){
        driver.quit();
    }






}
