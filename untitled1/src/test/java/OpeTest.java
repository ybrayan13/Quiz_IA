import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OpeTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Drivers/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.epssura.com/");
        webDriver.manage().window().fullscreen();
    }

    @Before
    public  void before() {
        webDriver.manage().window().maximize();
    }

    @Test
    public void inicio (){
        webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[1]/a/img")).isDisplayed();
    }

    @Test
    public void seccionEncuesta (){
        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).click();

        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/nav/div[2]/div/div/a[1]")).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotEquals("EPS SURAMERICANA S.A.",
                webDriver.getTitle());
    }

    @Test
    public void listaTest () throws InterruptedException {
        /*Select lista= new Select(webDriver.findElement(By.xpath("//*[@id=\"ctl00_ContentMain_suraType\"]")));
        List<WebElement> documento=lista.getOptions();
        for (WebElement i :
                documento) {
            System.out.println(i.getText());
        }*/
//        Thread.sleep(2000);
//        webDriver.findElement(By.xpath("//*[@id=\"suraName\"]")).sendKeys("1216725076");
//        Thread.sleep(2000);


        //Get the Web Element corresponding to the Password Field
        WebElement email = webDriver.findElement(By.id("//*[@id=\"suraName\"]"));

        //Find the Sign me in button
        email.sendKeys("1216725076");
        Thread.sleep(2000);
    }

    @AfterClass
    public static void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
