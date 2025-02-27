import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LogueoUsuarioExitoso;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogoutUser extends BaseTest {

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
    public void testLogoutUser() {
        String tituloPagina = homePage.obtenerTituloPagina();
        assertEquals("Automation Exercise", tituloPagina);
        homePage.hacerClickEnLogin();
        assertEquals("Login to your account", logueoUsuarioExitoso.verificarInicioSesionVisible());

        logueoUsuarioExitoso.ingresaeEmail("luisa@gmail.com");
        logueoUsuarioExitoso.ingresarPassword("123456");
        logueoUsuarioExitoso.hacerClickEnLogin();
        assertEquals("Logged in as Luisa", logueoUsuarioExitoso.obtenerTextoUsuarioLogueado());

        logueoUsuarioExitoso.hacerClickEnLogout();
        assertEquals("Login to your account", logueoUsuarioExitoso.verificarInicioSesionVisible());
    }

}
