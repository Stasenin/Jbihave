package com.jbhvtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.jbhvtest.utils.DriverUtil.getDriver;


public class MainPage {

    private By inputField = By.id("lst-ib");

    public void assertDriver () { if ( getDriver() != null ) {
        System.out.println("Right Driver");
    } else { System.out.println("Wrong Driver");}
    }
    public void getGooglePage () {
        getDriver().get("https://www.google.com");
    }
    public void searchForSomething () {
        getDriver().findElement(this.inputField).sendKeys("Something");
        getDriver().findElement(this.inputField).sendKeys(Keys.ENTER);

    }




}

