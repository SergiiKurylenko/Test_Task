package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public void setUpDriverBeforeScenario(String browser){
        Configuration.browser = browser;
        if(Configuration.browser.equals("chrome")) Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }
}
