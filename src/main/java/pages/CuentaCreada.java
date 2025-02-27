package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CuentaCreada extends CommonAccionPages {

    public CuentaCreada(WebDriver driver) {
        super(driver);
    }

    By mensajeCuentaCreada = By.xpath("//p[contains(text(), 'Congratulations!')]");
    By continueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    By logoutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");


    public String obtenerMensajeCuentaCreada() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeCuentaCreada));
        return driver.findElement(mensajeCuentaCreada).getText();
    }

    public void hacerClickEnContinue() {
        driver.findElement(continueButton).click();
    }

    public void hacerClickEnLogout() {
        driver.findElement(logoutButton).click();
    }
}
