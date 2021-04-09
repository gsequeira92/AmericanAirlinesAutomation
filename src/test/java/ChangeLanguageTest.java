
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AAHomePage;

public class ChangeLanguageTest {
    public WebDriver driver;

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUpTest(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.aa.com/");
    }
    @Test
    public void changePageLanguage() throws InterruptedException {

        AAHomePage homePage = new AAHomePage(driver);
        homePage.changeSiteLanguage("Japón");
        String newUrl = "https://www.americanairlines.jp/intl/jp/index.jsp?locale=ja_JP";
        Assert.assertTrue(newUrl.equalsIgnoreCase(driver.getCurrentUrl()));
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
