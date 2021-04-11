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

    @FindBy(xpath = "//input[@id='reservationFlightSearchForm.originAirport']")
    WebElement originTextBox;

    @FindBy(xpath = "//input[@id='reservationFlightSearchForm.destinationAirport']")
    WebElement destinationTextBox;

    @FindBy(xpath = "//select[@id='flightSearchForm.adultOrSeniorPassengerCount']")
    WebElement passengersDropdown;

    @FindBy(xpath = "//input[@id='aa-leavingOn']")
    WebElement departureDateInput;

    @FindBy(xpath = "//input[@id='aa-returningFrom']")
    WebElement returnDateInput;

    @FindBy(xpath = "//input[@id='flightSearchForm.button.reSubmit']")
    WebElement submitFlightSearch;

    public void setFlightOrigin(String origin){
        originTextBox.clear();
        originTextBox.sendKeys(origin);
    }

    public void setFlightDestination(String destination){
        destinationTextBox.sendKeys(destination);
    }

    public void setPassengers(String passengers){
        new Select(passengersDropdown).selectByValue(passengers);
    }

    public void setDepartureDate(String date){
        departureDateInput.sendKeys(date);
    }

    public void setReturnDate(String returnDate){
        returnDateInput.sendKeys(returnDate);
    }

    public void confirmSearch(){
        submitFlightSearch.click();
    }

    public void changeSiteLanguage(String language) throws InterruptedException {

        pageLanguageMenu.click();
         new Select(languageCountrySelector).selectByVisibleText(language);
        Thread.sleep(3000);
        submitNewLanguage.click();

    }

}
