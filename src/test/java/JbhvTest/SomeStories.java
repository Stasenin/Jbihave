package JbhvTest;


public class SomeStories extends JbhvSteps{

    public static void main (String[]args) {
        JbhvSteps jbhvSteps = new JbhvSteps();
        jbhvSteps.givenAProppertiesOfABrowser();
        jbhvSteps.whenGetGooglePage();
        jbhvSteps.thenSearchForSomething();




    }


}

