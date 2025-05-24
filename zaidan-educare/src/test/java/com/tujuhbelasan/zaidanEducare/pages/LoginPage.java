package com.tujuhbelasan.zaidanEducare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//  Implementasi Page Factory
    @FindBy(name = "username")
    WebElement usernameTextBox;
    @FindBy(name = "password")
    WebElement passwordTextBox;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/form/button")
    WebElement loginButton;
    @FindBy(xpath = "//div[contains(@class, 'flex') and contains(@class, 'justify-between')]//p")

    WebElement errorMessage;

//    Implementasi tanpa Page Factory
//    private By usernameTextBoxId = By.name("username");
//    private By passwordTextBoxId = By.name("password");
//    private By loginButtonId = By.xpath("/html/body/div[2]/div/div[2]/div/div/form/button");
//    private By errorMessageId = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]");

    public void enterUsername(String username) {
    //        driver.findElement(passwordTextBox).clear();
    //        driver.findElement(usernameTextBox).sendKeys(username);
        usernameTextBox.clear();
        usernameTextBox.sendKeys(username);
    }

    public void enterPassword(String password) {
//        driver.findElement(passwordTextBox).clear();
//        driver.findElement(passwordTextBox).sendKeys(password);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
//        driver.findElement(loginButton).click();
        loginButton.click();
    }

    public String getErrorMessage() {
//        return driver.findElement(errorMessage).getText();
        return errorMessage.getText().trim();
    }

}
