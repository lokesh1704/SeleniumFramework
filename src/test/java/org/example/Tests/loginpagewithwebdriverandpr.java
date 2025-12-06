package org.example.Tests;

import io.qameta.allure.Description;
import org.example.Base.CommontoAll;
import org.example.Driver.DriverManager;
import org.example.Pages.Appvwo.Login;
import org.example.Utils.PropertyReader;
//import org.junit.Assert;
//import org.junit.Test;
import org.testng.annotations.Test;
import org.testng.Assert;



import java.io.IOException;

import static org.example.Driver.DriverManager.driver;

public class loginpagewithwebdriverandpr extends CommontoAll {


        @Test
        @Description("invalid case")
        public void Invalidcreds() throws IOException {

            //DriverManager.init();
            //EdgeOptions edgeOptions = new EdgeOptions();
            //edgeOptions.addArguments("--start-maximized");
            //WebDriver driver = new EdgeDriver(edgeOptions);

            Login login = new Login(driver);


            String username= PropertyReader.Readkeys("username");
            String password=PropertyReader.Readkeys("Password");

            String errormessage = login.logintopage(username,password);



            Assert.assertEquals("Your email, password, IP address or location did not match", errormessage);
            //DriverManager.quit();

        }

}
