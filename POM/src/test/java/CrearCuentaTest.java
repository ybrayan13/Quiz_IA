import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrearCuentaTest {
    static WebDriver webDriver;
    static CrearCuenta cuenta;

    @BeforeClass
    public static void inicio(){
        cuenta=new CrearCuenta(webDriver);
        webDriver= cuenta.iniciarDriver();
        webDriver.manage().window().maximize();
        cuenta.isDisplayed("https://www.advantageonlineshopping.com/#/register");
    }

    @Test
    public void ingresarUsuario(){
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(cuenta.ingresarUsuario("ybraya13"));
    }
    @Test
    public void _1(){
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(cuenta.ingresarPass("ybraya13"));
    }
    @Test
    public void _2(){
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(cuenta.ingresarPassConfirm("ybraya13"));
    }

    @Test
    public void lista() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("inicio lista");

        Assert.assertTrue("la lista",
                webDriver.findElement(By.name("countryListboxRegisterPage")).isDisplayed());

        Select lista= new Select(webDriver.findElement(By.name("countryListboxRegisterPage")));
        List<WebElement> documento=lista.getOptions();
        lista.selectByVisibleText("Colombia");
        for (WebElement i :
                documento) {
            System.out.println(i.getText());
        }
        System.out.println(lista.getFirstSelectedOption().getText());
        System.out.println("fin lista");
    }

    @AfterClass
    public static void fin() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
