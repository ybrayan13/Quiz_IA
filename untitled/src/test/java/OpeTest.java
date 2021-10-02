import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpeTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.drive",
                "C:/Drivers/chromedriver_win32/chromedriver.exe");
        webDriver=new ChromeDriver();
        webDriver.get("https://www.colmenaseguros.com/Paginas/default.aspx");

    }
    @Test
    public void inicio (){

    }

    @AfterClass
    public static void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
