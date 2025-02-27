package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends CommonAccionPages {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By ConfirmarmensajePaginaResgistro = By.xpath("//*[@id='form']/div/div/div[3]/div/h2");
    private By CampoUsuario = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private By CampoEmail = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By SignupButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

    public String obtenerMensajeRegistro() {
        return driver.findElement(ConfirmarmensajePaginaResgistro).getText();
    }

    public void login(String user, String Email) {
        driver.findElement(CampoUsuario).sendKeys(user);
        driver.findElement(CampoEmail).sendKeys(Email);
    }
    public void hacerClickEnSignup() {
        driver.findElement(SignupButton).click();
    }

}
