import base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.EliminarCuenta;
import pages.LogueoUsuarioExitoso;
import pages.HomePage;
import pages.LoginPage;
import pages.CrearUsuario;
import pages.CuentaCreada;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegistroUsuario extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private CrearUsuario crearUsuario;
    private CuentaCreada cuentaCreada;
    private LogueoUsuarioExitoso LogueoUsuarioExitoso;
    private EliminarCuenta eliminarCuenta;


    @BeforeEach
    public void setUp() {
        iniciarNavegador();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        crearUsuario = new CrearUsuario(driver);
        cuentaCreada = new CuentaCreada(driver);
        LogueoUsuarioExitoso = new LogueoUsuarioExitoso(driver);
        eliminarCuenta = new EliminarCuenta(driver);
        homePage.visitarPagina("https://automationexercise.com/");
    }

    @Test
    public void testRegistroUsuario() {
        String tituloPagina = homePage.obtenerTituloPagina();
        assertEquals("Automation Exercise", tituloPagina);
        homePage.hacerClickEnLogin();
        assertEquals("New User Signup!", loginPage.obtenerMensajeRegistro());
        loginPage.login("Alexis", "alexis@gmail.com");
        loginPage.hacerClickEnSignup();

        assertEquals("ENTER ACCOUNT INFORMATION", crearUsuario.obtenerMensajeEnterAccountInformation());
        crearUsuario.completarDatosCuenta("password123");
        crearUsuario.seleccionarFechaNacimiento("10", "5", "1990");
        crearUsuario.seleccionarPais("India");
        crearUsuario.completarDatosaddress("Alexis", "Garcia", "Sofka", "Cr 43 # 123", "Apt 2", "Medellin", "Antioquia", "10001", "3142572381");
        crearUsuario.hacerClickEnCreateAccount();


        assertEquals("Congratulations! Your new account has been successfully created!", cuentaCreada.obtenerMensajeCuentaCreada());
        cuentaCreada.hacerClickEnContinue();
        cuentaCreada.hacerClickEnLogout();



        assertEquals("Login to your account", LogueoUsuarioExitoso.verificarInicioSesionVisible());
        LogueoUsuarioExitoso.ingresaeEmail("alexis@gmail.com");
        LogueoUsuarioExitoso.ingresarPassword("password123");
        LogueoUsuarioExitoso.hacerClickEnLogin();


        eliminarCuenta.hacerClickEnDeleteAccount();
        assertEquals("Your account has been permanently deleted!", eliminarCuenta.obtenerMensajeDeleteAccount());
        eliminarCuenta.hacerClickEnContinue();



    }

@AfterEach
protected void tearDown() {
    cerrarNavegador();
    }
}