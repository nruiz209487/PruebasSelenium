package prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class PruebasSelenium {
	
	static WebDriver driver1;

	@BeforeAll
	static void setURL() {
		driver1 = new FirefoxDriver();
		
	}

	@Test
	void test1() {
		driver1.get("https://elenarivero.github.io/examen/index.html");
		WebElement usuarioBox = driver1.findElement(By.id("usuario"));        
        WebElement passwordBox = driver1.findElement(By.id("password"));
        
        usuarioBox.sendKeys("Elena1234");
        passwordBox.sendKeys("Contra1234.");
        
        
        WebElement submitButton = driver1.findElement(By.id("enviar"));
        submitButton.click();
        
        // Resultado esperado: Login Correcto
        WebElement loginCorrecto = driver1.findElement(By.id("login"));
        String textoLogin = loginCorrecto.getText();
        assertEquals("LOGIN CORRECTO", textoLogin);
        
	}

	@Test
	void test2() {
		driver1.get("https://elenarivero.github.io/examen/index.html");
		WebElement usuarioBox = driver1.findElement(By.id("usuario"));        
        WebElement passwordBox = driver1.findElement(By.id("password"));
        
        usuarioBox.sendKeys("E");
        passwordBox.sendKeys("Contra1234.");
        
        
        WebElement submitButton = driver1.findElement(By.id("enviar"));
        submitButton.click();
        
        
        WebElement errorUsuario = driver1.findElement(By.id("errorUsuario"));
        boolean texto = errorUsuario.isDisplayed();
        assertTrue(texto);
        
        
	}
	
	@Test
	void test3() {
		driver1.get("https://elenarivero.github.io/examen/index.html");
		WebElement usuarioBox = driver1.findElement(By.id("usuario"));        
        WebElement passwordBox = driver1.findElement(By.id("password"));
        
        usuarioBox.sendKeys("Elen");
        passwordBox.sendKeys("Contra1234.");
        
        
        WebElement submitButton = driver1.findElement(By.id("enviar"));
        submitButton.click();
        
        // Resultado esperado: Login Correcto
        WebElement loginCorrecto = driver1.findElement(By.id("login"));
        String textoLogin = loginCorrecto.getText();
        assertEquals("LOGIN CORRECTO", textoLogin);
        
        
	}
	/*
	@AfterAll
	static void exitDriver() {
		driver1.quit();
	}*/
}
