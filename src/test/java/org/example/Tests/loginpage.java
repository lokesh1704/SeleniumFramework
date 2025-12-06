package org.example.Tests;

import io.qameta.allure.Description;
import io.qameta.allure.testng.TestInstanceParameter;
import org.example.Pages.Appvwo.Login;
//import org.junit.Assert;
//import org.junit.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;


public class loginpage {
    @Test
    @Description("invalid case")
    public void Invalidcreds() throws IOException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        Login login = new Login(driver);
        String errormessage = login.logintopage("lokesh", "123");

        Assert.assertEquals(errormessage,"Your email, password, IP address or location did not match");
        driver.quit();

    }
}



