package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogueoUsuarioExitoso extends CommonAccionPages {

    public LogueoUsuarioExitoso(WebDriver driver) {
        super(driver);
    }

    By InicioSesionVisible = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/h2");
    By email = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[2]");
    By password = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[3]");
    By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button");

    public String verificarInicioSesionVisible() {
        return driver.findElement(InicioSesionVisible).getText();
    }

    public void ingresaeEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void  ingresarPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void hacerClickEnLogin() {
        driver.findElement(loginButton).click();
    }
}
