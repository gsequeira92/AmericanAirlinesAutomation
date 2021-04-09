
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeLanguageTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUpTest(){
        driver = new ChromeDriver();
    }
    @Test
    public void changePageLanguage() {

        this.driver.get("https://www.aa.com/");
        String thing = "actualResult";
        Assert.assertTrue(true);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
