package com.jbhvtest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtil {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } catch (Exception e) {
                System.out.println("Wrong Web Driver URL provided");
                e.printStackTrace();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }


}
