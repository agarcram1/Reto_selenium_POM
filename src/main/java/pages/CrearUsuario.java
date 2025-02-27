package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrearUsuario extends CommonAccionPages {

    public CrearUsuario(WebDriver driver) {
            super(driver);
    }

    By mensajeEnterAccountInformation = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
    By title =  By.xpath("//*[@id=\"id_gender1\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By day = By.xpath("//*[@id=\"days\"]");
    By month = By.xpath("//*[@id=\"months\"]");
    By year = By.xpath("//*[@id=\"years\"]");
    By newsletter = By.xpath("//*[@id=\"newsletter\"]");
    By partners = By.xpath("//*[@id=\"optin\"]");
    By firstName = By.xpath("//*[@id=\"first_name\"]");
    By lastName = By.xpath("//*[@id=\"last_name\"]");
    By company = By.xpath("//*[@id=\"company\"]");
    By address = By.xpath("//*[@id=\"address1\"]");
    By address2 = By.xpath("//*[@id=\"address2\"]");
    By country = By.xpath("//*[@id=\"country\"]");
    By state = By.xpath("//*[@id=\"state\"]");
    By city = By.xpath("//*[@id=\"city\"]");
    By zipcode = By.xpath("//*[@id=\"zipcode\"]");
    By mobileNumber = By.xpath("//*[@id=\"mobile_number\"]");
    By  createAccount = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");

    public String obtenerMensajeEnterAccountInformation() {
        return driver.findElement(mensajeEnterAccountInformation).getText();
    }

    public void completarDatosCuenta(String password){
        WebElement titleRadioButton = esperarElemento(title, 10);
        titleRadioButton.click();
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(newsletter).click();
        driver.findElement(partners).click();

    }

    public void completarDatosaddress(String firstName, String lastName, String company, String address, String address2, String city, String state, String zipcode, String mobileNumber) {
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.company).sendKeys(company);
        driver.findElement(this.address).sendKeys(address);
        driver.findElement(this.address2).sendKeys(address2);
        driver.findElement(this.city).sendKeys(city);
        driver.findElement(this.state).sendKeys(state);
        driver.findElement(this.zipcode).sendKeys(zipcode);
        driver.findElement(this.mobileNumber).sendKeys(mobileNumber);
    }

    public void seleccionarFechaNacimiento(String dia, String mes, String ano) {
        WebElement dayDropdown = esperarElemento(day, 10);
        Select daySelect = new Select(dayDropdown);
        daySelect.selectByValue(dia);

        WebElement monthDropdown = esperarElemento(month, 10);
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByValue(mes);

        WebElement yearDropdown = esperarElemento(year, 10);
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByValue(ano);
    }

    public void seleccionarPais(String pais) {
        WebElement countryDropdown = esperarElemento(country, 10);
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByValue(pais);
    }

    public void hacerClickEnCreateAccount() {
        esperarElemento(createAccount, 10);
        driver.findElement(createAccount).click();
    }


}


