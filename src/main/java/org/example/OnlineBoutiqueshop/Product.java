package org.example.OnlineBoutiqueshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Product {
    WebDriver driver;
    private By addToCartButton = By.cssSelector("button[type]");


    public Product(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }


    public Cart addToCart(){
        WebElement button = driver.findElement(addToCartButton);
        button.click();
        return new Cart(driver);


    }


}
