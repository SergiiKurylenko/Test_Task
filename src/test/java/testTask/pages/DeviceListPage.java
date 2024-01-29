package testTask.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class DeviceListPage {
    public ElementsCollection deviceList = $$x("//div[contains(@data-qa, 'LST_ProductCard')]");
}
