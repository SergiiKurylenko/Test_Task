package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.t-mobile.pl/
public class MainPage {
  public SelenideElement mainMenu = $x("//nav[@id='main-menu']");
  public SelenideElement dropDownMenu = $x("//div[contains(@class, 'hidden menu-dropdown-submenu')]");
  public SelenideElement mainMenuChoose(String menuItem){
    return $x("//button[contains(text(), '"+ menuItem +"')]");
  }
  public SelenideElement dropDownMenuChoose(String menuItem, String subMenuItem){
    return $x("//p[contains(text(), '"+ menuItem +"')]/..//span[contains(text(), '"+ subMenuItem +"')]");
  }
  public SelenideElement acceptCookies = $x("//button[@id= 'didomi-notice-agree-button']");
  public SelenideElement cartIcon = $x("//div[contains(@class, 'flex ml-auto lg:mt-auto group-[.shrank-header]/header:lg:mt-0')]/a[@data-ma = 'menu-basket']");
  public SelenideElement cartCount = $x("//div[@class ='container mx-auto lg:px-6 max-lg:hidden']//div[contains(@class,'rounded-full')]");
}
