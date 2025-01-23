package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class LoginPage {
    private WebDriver driver;

    private By emailFieldBy = By.id("email");
    private By passwordFieldBy = By.id("password");
    private By loginButtonBy = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        if (!driver.getTitle().contains("Login")) {
            throw new IllegalStateException("This is not the Login Page. Current page: " + driver.getCurrentUrl());
        }
    }

    public HomePage loginAsValidUser(String userName, String password) {
        driver.findElement(emailFieldBy).sendKeys(userName);
        driver.findElement(passwordFieldBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();

        return new HomePage(driver);
    }

    public LoginPage loginAsInvalidUser(String userName, String password){
        driver.findElement(emailFieldBy).sendKeys(userName);
        driver.findElement(passwordFieldBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
        return new LoginPage(driver);
    }
    public boolean isNotLoggedIn(){
        String title = driver.getTitle();
        return title.equals("Login - Spotify");
    }



}
