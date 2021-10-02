import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CrearCuenta extends Principal {

    By username =By.name("usernameRegisterPage");
    By email =By.name("emailRegisterPage");
    By lista = By.name("countryListboxRegisterPage");
    By pass = By.name("passwordRegisterPage");
    By passConfirm = By.name("confirm_passwordRegisterPage");


    public CrearCuenta(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean ingresarUsuario(String usuario){
        sendKeys(username, usuario);
        return isDisplayed(email);
    }
    public boolean ingresarPass(String contrasena){
        sendKeys(pass, contrasena);
        return isDisplayed(pass);
    }
    public boolean ingresarPassConfirm(String contrasenaConfirm){
        sendKeys(passConfirm, contrasenaConfirm);
        return isDisplayed(passConfirm);
    }
}
