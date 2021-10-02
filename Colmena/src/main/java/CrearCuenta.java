import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CrearCuenta extends Principal {

    By tipoId =By.xpath("//*[@id=\"appRegistroUsuarioCovid\"]/div[2]/div[2]/div[1]/select");
    By id =By.xpath("//*[@id=\"appRegistroUsuarioCovid\"]/div[2]/div[2]/div[2]/input");
    By pass = By.xpath("//*[@id=\"appRegistroUsuarioCovid\"]/div[2]/div[2]/div[3]/input");


    public CrearCuenta(WebDriver webDriver) {
        super(webDriver);
    }

    public void seleccionarTipoDocumento(String doc){
        selectList(tipoId, doc);
    }

    public boolean ingresarId(String numeroId){
        sendKeys(id, numeroId);
        System.out.println(isDisplayed(id)+" ingresarId");
        return isDisplayed(id);
    }

    public boolean ingresarPass(String contrasena){
        sendKeys(pass, contrasena);
        return isDisplayed(pass);
    }
}
