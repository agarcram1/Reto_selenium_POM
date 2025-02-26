package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonAccionPages {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By LoginButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public String obtenerTituloPagina() {
        return driver.getTitle();
    }

    public void hacerClickEnLogin() {
        driver.findElement(LoginButton).click();
    }
}

