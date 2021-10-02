package co.com.bancolombia.certificacion.advantage.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormTheLastStep {
    public static final Target TXT_PASSWORD = Target.the("campo para la contraseña").
            located(By.name("password"));

    public static final Target TXT_CONFIRMPASSWORD = Target.the("campo para confirmar contraseña").
            located(By.name("confirmPassword"));

    public static final Target CHECK_STAYINFORMED = Target.the("campo para el apellido").
            located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[4]/label/span"));

    public static final Target CHECK_CODECONDUCT = Target.the("campo para el correo electronico").
            located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[5]/label/span[1]"));

    public static final Target CHECK_PRIVACYSECURITYPOLICY = Target.the("campo para el mes").
            located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[6]/label/span[1]"));
}
