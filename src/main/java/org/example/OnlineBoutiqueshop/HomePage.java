package org.example.OnlineBoutiqueshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class HomePage extends LoadableComponent<HomePage> {
    private final String baseURL = "https://cymbal-shops.retail.cymbal.dev";
    private WebDriver driver;
    int currencyInd = 1;



    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.titleIs("Online Boutique"));
    }
    @Override
    protected void load(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(baseURL);
    }

    @Override
    protected void isLoaded() throws Error {
        assert(driver.getTitle().contains("Online Boutique"));
    }


    public Product selectProduct(String productId){
        String selector = "a[href=\"/product/"+ productId +"\"]";
        WebElement productElm = driver.findElement(By.cssSelector(selector));
        productElm.click();
        return new Product(driver);
    }


    public HomePage setCurrency(int index){
        WebElement selectElm = driver.findElement(By.name("currency_code"));
        Select select = new Select(selectElm);
        select.selectByIndex(index);
        this.currencyInd =index;
        return this;
    }



}
