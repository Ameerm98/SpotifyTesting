package org.example.OnlineBoutiqueshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Cart {
    WebDriver driver;
    private By placeOrderButton = By.cssSelector(".cymbal-button-primary[type='submit']");
    public Cart(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }


    public Checkout placeOrder(){
        WebElement placeOrderButton = driver.findElement(this.placeOrderButton);
        placeOrderButton.click();
        return new Checkout(driver);
    }

}
