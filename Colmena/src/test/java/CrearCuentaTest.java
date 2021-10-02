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
        cuenta.isDisplayed("https://www.colmenaseguros.com/Paginas/default.aspx");
    }

    @Test
    public void _1click() {
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"WebPartWPQ3\"]/div[2]")).click();
    }

    @Test
    public void _2seleccionarTipoDocumento() {
        cuenta.seleccionarTipoDocumento("CEDULA DE CIUDADANIA");
    }

    @Test
    public void _3Id()  {
        Assert.assertTrue("Cedula lista",
                cuenta.ingresarId("1216725076"));
    }
    @Test
    public void _4xContrasena()  {
        Assert.assertTrue("Contraseña lista",
                cuenta.ingresarPass("1216725076Yb@"));
    }

    @AfterClass
    public static void fin() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }

//    @Test
//    public void _1() throws InterruptedException {
//        // Click
//        Thread.sleep(2000);
//        webDriver.findElement(By.xpath("//*[@id=\"WebPartWPQ3\"]/div[2]")).click();
//    }
//
//    @Test
//    public void _2() throws InterruptedException {
//        // Seleccionar "Cedula"
//        Thread.sleep(2000);
//        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//        cuenta.seleccionarTipoDocumento("CEDULA DE CIUDADANIA");
//    }
//
//    @Test
//    public void _3() throws InterruptedException {
//        // Ingresar cedula
//        Thread.sleep(2000);
//        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//        Assert.assertTrue("Cedula lista",
//                cuenta.ingresarId("1216725076"));
//    }
//    @Test
//    public void _4() throws InterruptedException {
//        // ingresar contraseña
//        Thread.sleep(2000);
//        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//        Assert.assertTrue("Contraseña lista",
//                cuenta.ingresarPass("1216725076Yb@"));
//    }
//
//    @AfterClass
//    public static void fin() throws InterruptedException {
//        Thread.sleep(2000);
//        webDriver.quit();
//    }
}
