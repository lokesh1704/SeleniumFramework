package org.example.Pages.Appvwo;

import org.example.Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Login {

    private final WebDriver driver;

    public Login(WebDriver driver)
    {
        this.driver=driver;
    }

    private By username= By.id("login-username");
    private By password=By.id("login-password");
    private By submit=By.xpath("(//span[@data-qa='ezazsuguuy'])[1]");
    private By errormessage = By.xpath("//div[@class='notification-box-description']");


    public String logintopage(String user,String pwd) throws IOException {

        String url= PropertyReader.Readkeys("url");

        driver.get(url);
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(submit).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errormessage));
        WebElement validation=driver.findElement(By.xpath("//div[@class='notification-box-description']"));
        return validation.getText();
    }

}
