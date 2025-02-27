package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EliminarCuenta extends CommonAccionPages {

    public EliminarCuenta(WebDriver driver) {
        super(driver);
    }

    By DeleteAccountButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By mensajeDeleteAccount = By.xpath("//*[@id=\"form\"]/div/div/div/p[1]");
    By botonDeleteAccountcontinue = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    By accountDelateMessage = By.xpath("//b[contains(text(), 'Account Deleted!')]");

    public void hacerClickEnDeleteAccount() {
        driver.findElement(DeleteAccountButton).click();
    }

    public String obtenerMensajeDeleteAccount() {
        return driver.findElement(mensajeDeleteAccount).getText();
    }

    public void hacerClickEnContinue() {
        driver.findElement(botonDeleteAccountcontinue).click();
    }

    public String obtenerMensajeCuentaEliminada() {
        return driver.findElement(accountDelateMessage).getText();
    }
}
