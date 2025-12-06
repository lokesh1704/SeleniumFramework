package org.example.Tests;

import io.qameta.allure.Description;
//import org.example.Pages.Appvwo.Login;
import org.example.Pages.Pagefactory.VWO.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class loginpagewithPF {

    public static final Logger logger= LogManager.getLogger(loginpagewithPF.class);
    @Test
    @Description("invalid case")
    public void Invalidcreds() throws IOException {
        logger.info("Start of test case");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        Login login = new Login(driver);
        String errormessage = login.logintopage("lokesh", "123");
        logger.info("End of Test case");

        Assert.assertEquals(errormessage,"Your email, password, IP address or location did not match");
        driver.quit();

    }
}
