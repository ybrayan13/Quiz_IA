package co.com.bancolombia.certificacion.advantage.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormCreateAccount {

    public static final Target BTN_JOINTODAY = Target.the("boton para ingresar").
            located(By.linkText("Join Today"));

    public static final Target TXT_FIRSTNAME = Target.the("campo para el nombre").
            located(By.name("firstName"));

    public static final Target TXT_LASTNAME = Target.the("campo para el apellido").
            located(By.name("lastName"));

    public static final Target TXT_EMAIL = Target.the("campo para el correo electronico").
            located(By.name("email"));

    public static final Target SLC_MONTH = Target.the("campo para el mes").
            located(By.name("birthMonth"));

    public static final Target SLC_DAY = Target.the("campo para el dia").
            located(By.name("birthDay"));

    public static final Target SLC_YEAR = Target.the("campo para la año").
            located(By.name("birthYear"));

    public static final Target BTN_LOCATION = Target.the("botonpara formulario Location").
            located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[2]/a"));

    public static final Target BTN_DEVICES = Target.the("boton para el formulario Devices").
            located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[2]/div/a"));

    public static final Target BTN_LASTSTEP = Target.the("boton para el formulario Last Step").
            located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/div[2]/div/a"));
}