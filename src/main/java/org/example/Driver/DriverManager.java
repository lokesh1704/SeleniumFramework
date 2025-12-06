package org.example.Driver;

import org.example.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class DriverManager {

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static WebDriver driver;

public static void init() throws IOException {
    String browser=PropertyReader.Readkeys("browser");
    browser=browser.toLowerCase();
    switch (browser)
    {
        case "edge":
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            driver = new EdgeDriver(edgeOptions);
            break;
        case "chrome":
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver=new ChromeDriver(chromeOptions);
            break;
        default:
            System.out.println("Unable to find ur browser");
    }


}

public static void quit()
{
driver.quit();

}

}
