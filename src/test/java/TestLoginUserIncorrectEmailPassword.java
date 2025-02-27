import base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LogueoUsuarioExitoso;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginUserIncorrectEmailPassword extends BaseTest {

    private HomePage homePage;
    private LogueoUsuarioExitoso logueoUsuarioExitoso;

    @BeforeEach
    public void setUp() {
        iniciarNavegador();
        homePage = new HomePage(driver);
        logueoUsuarioExitoso = new LogueoUsuarioExitoso(driver);
        homePage.visitarPagina("https://automationexercise.com/");
    }

    @Test
    public void testLoginUserIncorrectEmailPassword() {
        String tituloPagina = homePage.obtenerTituloPagina();
        assertEquals("Automation Exercise", tituloPagina);
        homePage.hacerClickEnLogin();
        assertEquals("Login to your account", logueoUsuarioExitoso.verificarInicioSesionVisible());

        logueoUsuarioExitoso.ingresaeEmail("Alexis3@gmail.com");
        logueoUsuarioExitoso.ingresarPassword("password123");

        logueoUsuarioExitoso.hacerClickEnLogin();

        assertEquals("Your email or password is incorrect!", logueoUsuarioExitoso.obtenerMensajeErrorLogin());
    }

    @AfterEach
    public void tearDown() {
        cerrarNavegador();
    }
}

