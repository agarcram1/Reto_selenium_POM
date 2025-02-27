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
    By loggedInAsUsername = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    By mensajeErrorLogin = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
    By logoutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

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

    public String obtenerTextoUsuarioLogueado() {
        return driver.findElement(loggedInAsUsername).getText();
    }

    public String obtenerMensajeErrorLogin() {
        return driver.findElement(mensajeErrorLogin).getText();
    }

    public void hacerClickEnLogout() {
        driver.findElement(logoutButton).click();
    }
}
