package com.jbhvtest.steps;


import com.jbhvtest.pages.MainPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class JbhvSteps extends Steps {
        MainPage mainPage = new MainPage();


        @Given("a right browser")

        public void aRightbBowser() {
           mainPage.assertDriver();
        }

        @When("get google page")
        public  void whenGetGooglePage () {
            mainPage.getGooglePage();
        }

        @Then("search for 'Something'")
        public void thenSearchForSomething () {
        mainPage.searchForSomething();
        }


    }

