package org.example.Base;

import org.example.Driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class CommontoAll {

  @BeforeMethod
    public void setup() throws IOException {
      DriverManager.init();
  }

  @AfterMethod
   public void teardown()
   {
       DriverManager.quit();
   }

}


