import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AAHomePage;

public class SearchForFlight {

    public WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aa.com/");
    }

    @Test
    public void searchForAFlight() throws InterruptedException {

        AAHomePage homePage = new AAHomePage(driver);

        homePage.setFlightOrigin("BUE - Buenos Aires, Argentina");
        homePage.setFlightDestination("MIA - Miami International, FL");
        homePage.setPassengers("2");
        homePage.setDepartureDate("12/04/2021");
        homePage.setReturnDate("30/05/2021");
        homePage.confirmSearch();
        Thread.sleep(8000);
        Assert.assertTrue(String.valueOf(driver.getTitle().equals("Elegir vuelos")), true);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
