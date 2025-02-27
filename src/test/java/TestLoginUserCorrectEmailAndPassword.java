package test;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginUserCorrectEmailAndPassword extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private LogueoUsuarioExitoso logueoUsuarioExitoso;
    private EliminarCuenta eliminarCuenta;

    @BeforeEach
    public void setUp() {
        iniciarNavegador();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        logueoUsuarioExitoso = new LogueoUsuarioExitoso(driver);
        eliminarCuenta = new EliminarCuenta(driver);
        homePage.visitarPagina("https://automationexercise.com/");
    }

    @Test
    public void testLoginUserCorrectEmailAndPassword() {
        String tituloPagina = homePage.obtenerTituloPagina();
        assertEquals("Automation Exercise", tituloPagina);
        homePage.hacerClickEnLogin();
        assertEquals("Login to your account", logueoUsuarioExitoso.verificarInicioSesionVisible());


        logueoUsuarioExitoso.ingresaeEmail("alexis@gmail.com");
        logueoUsuarioExitoso.ingresarPassword("password123");

        logueoUsuarioExitoso.hacerClickEnLogin();

//        // Verify that 'Logged in as username' is visible
//        assertEquals("Logged in as Alexis", homePage.obtenerTextoUsuarioLogueado());
//
//        // Click 'Delete Account' button
//        eliminarCuenta.hacerClickEnDeleteAccount();
//
//        // Verify that 'ACCOUNT DELETED!' is visible
//        assertEquals("Your account has been permanently deleted!", eliminarCuenta.obtenerMensajeDeleteAccount());
//        eliminarCuenta.hacerClickEnContinue();
    }
}
