package org.example.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

 public static String Readkeys(String key) throws IOException {
     Properties p = new Properties();
     try {
         FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
         p.load(fileInputStream);

     }catch (IOException e){
         System.out.println(e.getMessage());
     }
     return p.getProperty(key);
     }
}
