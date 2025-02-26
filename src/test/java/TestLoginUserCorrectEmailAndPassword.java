import base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LogueoUsuarioExitoso;
import pages.EliminarCuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginUserCorrectEmailAndPassword extends BaseTest {

    private HomePage homePage;
    private LogueoUsuarioExitoso logueoUsuarioExitoso;
    private EliminarCuenta eliminarCuenta;

    @BeforeEach
    public void setUp() {
        iniciarNavegador();
        homePage = new HomePage(driver);
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


        logueoUsuarioExitoso.ingresaeEmail("luisa@gmail.com");
        logueoUsuarioExitoso.ingresarPassword("123456");

        logueoUsuarioExitoso.hacerClickEnLogin();


        assertEquals("Logged in as Luisa", logueoUsuarioExitoso.obtenerTextoUsuarioLogueado());
        eliminarCuenta.hacerClickEnDeleteAccount();

        assertEquals("ACCOUNT DELETED!", eliminarCuenta.obtenerMensajeCuentaEliminada());
        eliminarCuenta.hacerClickEnContinue();
    }

    @AfterEach
    public void tearDown() {
        cerrarNavegador();
    }
}
