package testTask.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DeviceDetailsPage {
    public SelenideElement deviceTitle = $x("//h1");
    public SelenideElement addToCartBtn = $x("//div[contains(@class, 'isNewUxHeaderEnabled')]//button[contains(@data-qa, 'PRD_AddToBasket')]");
    public SelenideElement priceForStart = $x("//span//div[@data-qa='PRD_TotalUpfront']");
    public SelenideElement monthlyInstallment = $x("//span//div[text()='Do zapłaty miesięcznie']/../following-sibling::div/div");
}
