package prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class PruebasSeleniumParam {
	
	static WebDriver driver1;

	@BeforeAll
	static void setURL() {
		driver1 = new FirefoxDriver();
		
	}

	@ParameterizedTest
	@MethodSource("pruebasOK")
	void test1(String usuario, String password) {
		driver1.get("https://elenarivero.github.io/examen/index.html");
		WebElement usuarioBox = driver1.findElement(By.id("usuario"));        
        WebElement passwordBox = driver1.findElement(By.id("password"));
        
        usuarioBox.sendKeys(usuario);
        passwordBox.sendKeys(password);
        
        
        WebElement submitButton = driver1.findElement(By.id("enviar"));
        submitButton.click();
        
        // Resultado esperado: Login Correcto
        WebElement loginCorrecto = driver1.findElement(By.id("login"));
        String textoLogin = loginCorrecto.getText();
        assertEquals("LOGIN CORRECTO", textoLogin);
        
	}

	private static Stream<Arguments> pruebasOK(){
		return Stream.of(Arguments.of("Elena1234","Contra1234."),
				Arguments.of("Ele1","Contra1234."),
				Arguments.of("Elen1","Contra1234."),
				Arguments.of("Elena1240","Con1234?"),
				Arguments.of("Elena1241","Con12345?"));
	}
	
	@ParameterizedTest
	@MethodSource("pruebasKO")
	void test2(String usuario, String password, String idError) {
		driver1.get("https://elenarivero.github.io/examen/index.html");
		WebElement usuarioBox = driver1.findElement(By.id("usuario"));        
        WebElement passwordBox = driver1.findElement(By.id("password"));
        
        usuarioBox.sendKeys(usuario);
        passwordBox.sendKeys(password);
        
        
        WebElement submitButton = driver1.findElement(By.id("enviar"));
        submitButton.click();
        
        WebElement error = driver1.findElement(By.id(idError));
        boolean texto = error.isDisplayed();
        assertTrue(texto);
        
	}

	private static Stream<Arguments> pruebasKO(){
		return Stream.of(Arguments.of("E","Contra1234.", "errorUsuario"),
				Arguments.of("Ele","Contra1234.", "errorUsuario"),
				Arguments.of("Elena1234","Con12?", "errorPassword"),
				Arguments.of("Elena1235","contra1234.", "errorPassword"),
				Arguments.of("Elena1236","CONTRA1234.", "errorPassword"));
	}
	
	/*
	@AfterAll
	static void exitDriver() {
		driver1.quit();
	}*/
}
