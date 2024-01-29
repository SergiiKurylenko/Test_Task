package utils;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class AfterSteps {
    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
