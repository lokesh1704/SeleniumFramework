package org.example.Pages.Pagefactory.VWO;

import org.example.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(xpath = "(//span[@data-qa='ezazsuguuy'])[1]")
    private WebElement submit;

    @FindBy(xpath = "//div[@class='notification-box-description']")
    private WebElement error;

    public String logintopage(String user, String pwd) throws IOException {

        String url = PropertyReader.Readkeys("url");
        driver.get(url);

        username.sendKeys(user);
        password.sendKeys(pwd);
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(error));

        return error.getText();
    }
}
