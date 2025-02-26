import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRegistroUsuario extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        iniciarNavegador();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
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
    }

//    @AfterEach
//    protected void tearDown() {
//        cerrarNavegador();
//    }
}