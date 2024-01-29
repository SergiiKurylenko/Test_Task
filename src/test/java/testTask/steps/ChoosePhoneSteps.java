package testTask.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testTask.pages.CartPage;
import testTask.pages.DeviceDetailsPage;
import testTask.pages.DeviceListPage;
import testTask.pages.MainPage;
import testTask.utils.Driver;
import testTask.utils.ScenarioContext;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.xpath;

public class ChoosePhoneSteps{
    Driver driver = new Driver();
    MainPage mainPage = new MainPage();
    DeviceListPage deviceListPage = new DeviceListPage();
    DeviceDetailsPage deviceDetailsPage = new DeviceDetailsPage();
    CartPage cartPage = new CartPage();

    private static final Logger logger = LoggerFactory.getLogger(ChoosePhoneSteps.class);

    private final ScenarioContext scenarioContext = new ScenarioContext();

    @Given("Otwórz odpowiednią przeglądarkę {string}")
    public void openBrowser(String browser) {
        logger.info("Opening browser: {}", browser);
        driver.setUpDriverBeforeScenario(browser);
    }

    @When("Przejdź na stronę {string}")
    public void goToSitePage(String url) {
        logger.info("Navigating to URL: {}", url);
        open(url);
    }

    @Then("Strona główna jest widoczna.")
    public void homepageIsVisible() {
        assertEquals("Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile", title());
        if(mainPage.acceptCookies.isDisplayed()) mainPage.acceptCookies.click();
    }

    @When("Z górnej belki wybierz {string}")
    public void chooseFromTopBar(String arg0) {
        mainPage.mainMenu.shouldBe(visible);
        mainPage.mainMenuChoose(arg0).hover();
    }

    @Then("Widoczna rozwijana lista")
    public void visibleDropdownList() {
        mainPage.dropDownMenu.shouldBe(visible);
    }

    @When("Kliknij {string} z kolumny {string}")
    public void clickFromColumn(String arg0, String arg1) {
        mainPage.dropDownMenuChoose(arg1, arg0).shouldBe(visible).click();
    }

    @Then("Widoczna lista smartfonów {int} szt")
    public void visibleSmartphoneList(int arg0) {
        deviceListPage.deviceList.shouldHave(size(arg0));
    }

    @When("Kliknij w {int} element z listy")
    public void clickOnFirstElementFromList(int arg0) {
        int index = arg0-1;
        logger.info("Clicking on {} element from list", index+1);
        String deviceTitle = deviceListPage.deviceList.get(index).find(xpath(".//h2")).getAttribute("title");

        scenarioContext.setContextValue("deviceTitle", deviceTitle);

        deviceListPage.deviceList.get(index).shouldBe(visible).click();
    }

    @Then("Widoczna strona produktu")
    public void visibleProductPage() {
        logger.info("Verifying product page");
        deviceDetailsPage.deviceTitle.shouldHave(text(scenarioContext.getContextValue("deviceTitle")));
        assertEquals(scenarioContext.getContextValue("deviceTitle") + " - strona produktu, cena, opis urządzenia | T-Mobile",title());

        String startPrice = deviceDetailsPage.priceForStart.shouldBe(visible).getText();
        String monthlyInstallment = deviceDetailsPage.monthlyInstallment.shouldBe(visible).getText();

        scenarioContext.setContextValue("cenaNaStart", startPrice);
        scenarioContext.setContextValue("rataMiesieczna", monthlyInstallment);
    }

    @When("Dodaj produkt do koszyka")
    public void addToCart() {
        logger.info("Adding product to cart");
        deviceDetailsPage.addToCartBtn.shouldBe(visible).click();
    }

    @Then("Widoczna strona {string}. Kwoty Cena na start oraz Rata miesięczna zgadzają się z kwotami z poprzedniej strony.")
    public void visibleAmountPageAndMatchWithPreviousPage(String arg0) {
        logger.info("Verifying amount page: {}", arg0);
        cartPage.title.shouldHave(text(arg0));
        cartPage.startPrice.shouldHave(text(scenarioContext.getContextValue("cenaNaStart")));
        logger.info("Verifying monthly installment: {}", scenarioContext.getContextValue("cenaNaStart"));
        cartPage.monthlyInstallment.shouldHave(text(scenarioContext.getContextValue("rataMiesieczna")));
        logger.info("Verifying monthly installment: {}", scenarioContext.getContextValue("rataMiesieczna"));
    }

    @When("Przejdź na stronę główną T-Mobile")
    public void goToTMobileHomePage() {
        logger.info("Navigating to T-Mobile home page");
        cartPage.homeBtn.shouldBe(visible).click();
    }

    @Then("Widoczna strona główna. W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku {string}.")
    public void visibleHomePageWithProductsInBasket(String arg0) {
        logger.info("Verifying home page");
        assertEquals("Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile", title());
        logger.info("Verifying cart icon");
        mainPage.cartIcon.shouldBe(visible);
        logger.info("Verifying cart count: {}", arg0);
        mainPage.cartCount.shouldHave(text(arg0));
    }
}
