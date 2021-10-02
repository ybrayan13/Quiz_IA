package co.com.bancolombia.certificacion.advange.stepdefinitions;

import co.com.bancolombia.certificacion.advantage.models.Person;
import co.com.bancolombia.certificacion.advantage.tasks.EnterPersonalInformation;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RegistrarUsuarioStepDefinitions {
    @Managed
    WebDriver driver;

    @Before
    public void setUp (){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
        OnStage.theActorCalled("user");
    }

    @Given("^El usuario se encuentra en la pagina$")
    public void elUsuarioSeEncuentraEnLaPagina() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.utest.com/"));
    }

    @When("^El usuario (.*) la informacion (.*)$")
    public void elUsuarioIngresaLaInformacion(String arg1, String arg2, List<Person> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterPersonalInformation.withData(data));
    }

    @Then("^El usuario vera su nombre en el perfil$")
    public void elUsuarioVeraSuNombreEnElPerfil() {
    }

    @Given("^El usuario ya se encuentra en la pagina$")
    public void elUsuarioYaSeEncuentraEnLaPagina() {
    }

    @When("^El usuario ingresa sus credenciales$")
    public void elUsuarioIngresaSusCredenciales(List<Person> lista) {
    }

    @Then("^El usuario obtiene un mensaje de error$")
    public void elUsuarioObtieneUnMensajeDeError() {
    }
}
