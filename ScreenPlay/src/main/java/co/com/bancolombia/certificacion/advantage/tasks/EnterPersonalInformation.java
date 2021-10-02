package co.com.bancolombia.certificacion.advantage.tasks;

import co.com.bancolombia.certificacion.advantage.models.Person;
import co.com.bancolombia.certificacion.advantage.userinterfaces.FormTheLastStep;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.bancolombia.certificacion.advantage.userinterfaces.FormCreateAccount.*;
import static co.com.bancolombia.certificacion.advantage.userinterfaces.FormTheLastStep.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EnterPersonalInformation implements Task {

    private String  firstName, lastName,email, month, day, year, password, confirmpassword;;

    private List<Person> data;

    public EnterPersonalInformation(List<Person> data) {
        this.data = data;
        this.firstName = data.get(0).getFirstName();
        this.lastName = data.get(0).getLastName();
        this.email = data.get(0).getEmail();
        this.month = data.get(0).getMonth();
        this.day = data.get(0).getDay();
        this.year = data.get(0).getYear();
        this.password = data.get(0).getPassword();
        this.confirmpassword = data.get(0).getConfirmpassword();


        // no siempre se debe crear de esta manera
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BTN_JOINTODAY, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(BTN_JOINTODAY));

        actor.attemptsTo(Enter.theValue(firstName).into(TXT_FIRSTNAME),
                Enter.theValue(lastName).into(TXT_LASTNAME),
                Enter.theValue(email).into(TXT_EMAIL),
                SelectFromOptions.byVisibleText(month).from(SLC_MONTH),
                SelectFromOptions.byVisibleText(day).from(SLC_DAY),
                SelectFromOptions.byVisibleText(year).from(SLC_YEAR));

        actor.attemptsTo(WaitUntil.the(BTN_LOCATION, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(BTN_LOCATION),
                Click.on(BTN_DEVICES),
                Click.on(BTN_LASTSTEP),
                Enter.theValue(password).into(TXT_PASSWORD),
                Enter.theValue(password).into(TXT_CONFIRMPASSWORD),
                Click.on(CHECK_STAYINFORMED),
                Click.on(CHECK_CODECONDUCT),
                Click.on(CHECK_PRIVACYSECURITYPOLICY));

    }

    public static EnterPersonalInformation withData(List<Person> data) {

        return Tasks.instrumented(EnterPersonalInformation.class, data);
    }
}