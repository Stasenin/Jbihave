package JbhvTest;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class JbhvSteps extends  SomeStories{
        private WebDriver driver;

        public WebDriver getDriver() {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        return driver;
        }

        @Given("a right browser")

        public void aRightbBowser() {
            if (driver != null ) {
                System.out.println("Right Driver");
            } else { System.out.println("Wrong Driver");}
        }

        @When("get google page")
        public  void whenGetGooglePage () {


            driver.get("https://www.google.com");

        }
        @Then("search for 'Something'")

        public void thenSearchForSomething () {
            driver.findElement(By.id("lst-ib")).sendKeys("Something");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
        }


    }

