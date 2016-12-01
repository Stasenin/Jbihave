package JbhvTest;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JbhvSteps {

    public WebDriver driver = null;

        @Given("a propperties of a browser")

        public void givenAProppertiesOfABrowser(){
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();




        }
        @When("get google page")

        public void whenGetGooglePage () {
            driver.get("https://www.google.com");

        }
        @Then("search for 'Something'")

        public void thenSearchForSomething () {
            driver.findElement(By.id("lst-ib")).sendKeys("Something");
            driver.findElement(By.cssSelector("input[type =\"submit\"][name=\"btnK\"]")).click();
        }


    }

