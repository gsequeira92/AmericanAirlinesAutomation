package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AAHomePage {

    public AAHomePage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@id='countrySelector']")
    WebElement pageLanguageMenu;

    @FindBy(xpath = "//select[@id='aa-country-selector']")
    WebElement languageCountrySelector;

    @FindBy(xpath = "//input[@id='aa-choose-locale']")
    WebElement submitNewLanguage;

    public void changeSiteLanguage(String language) throws InterruptedException {

        pageLanguageMenu.click();
        Select selectDropdown = new Select(languageCountrySelector);
        selectDropdown.selectByVisibleText(language);
        Thread.sleep(3000);
        System.out.println("Se seleccionó el nuevo lenguaje");
        submitNewLanguage.click();
        System.out.println("Se hizo click en submit");
    }

}
