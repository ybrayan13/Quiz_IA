package co.com.bancolombia.certificacion.advange.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\feactures\\registrar_usuario.feature",
        glue = "co.com.bancolombia.certificacion.advange.stepdefinitions",
        snippets = SnippetType.CAMELCASE,tags = "@CuentaExitosa")

// para ejecutar uno o unos
// tags = "@CuentaExitosa, @CuentaFallida"
// tags = "not @CuentaExitosa" >> ignora este y ejecuta los otros
public class RegistrarUsuario {

}
