package org.example.OnlineBoutiqueshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Checkout {
    private WebDriver driver;
    private By tag = By.tagName("h3");

    Checkout(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }


    public boolean isOrderCompleted(){
        String tag = driver.findElement(this.tag).getText();
        return tag.equals("Your order is complete!");
    }


}
