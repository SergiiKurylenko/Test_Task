package testTask.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    public SelenideElement title = $x("//h1");
    public SelenideElement startPrice = $x("//div[@data-qa = 'BKT_TotalupFrontCurrCOde']");
    public SelenideElement monthlyInstallment = $x("//div[@data-qa = 'BKT_TotalMonthlyCurrCOde']");
    public SelenideElement homeBtn = $x("//a[@class='logoWrap']");
}
