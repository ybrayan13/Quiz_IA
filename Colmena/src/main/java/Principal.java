import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Principal {

    private WebDriver webDriver;

    public Principal(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public WebDriver iniciarDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Drivers/chromedriver_win32/chromedriver.exe");
        this.webDriver=new ChromeDriver();
        return this.webDriver;
    }

    public void clcikElement(By locator){
        webDriver.findElement(locator).click();
    }

    public void sendKeys(By locator, String texto){
        System.out.println("entro");
        webDriver.findElement(locator).sendKeys(texto);
    }

    public boolean isDisplayed(By locator){
        return webDriver.findElement(locator).isDisplayed();
    }

    public void isDisplayed(String url){
        webDriver.get(url);
    }

    public void selectList(By locator, String texto){
        System.out.println("inicio lista");
        Select lista= new Select(webDriver.findElement(locator));
        List<WebElement> documento=lista.getOptions();
        lista.selectByVisibleText(texto);
        for (WebElement i :
                documento) {
            System.out.println(i.getText());
        }
        System.out.println(lista.getFirstSelectedOption().getText());
        System.out.println("fin lista");
    }

}
