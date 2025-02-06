package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio1 {
	static WebDriver driver1;

	@BeforeAll
	static void setUp() {
		driver1 = new ChromeDriver();
	}
	@Test
	void testCabecera() {
		driver1.get("http://localhost:3000/");
		WebElement cabecera = driver1.findElement(By.id("cabecera"));
		assertEquals("Enlaces favoritos", cabecera.getText());
	}

	@Test
	void testEnlaceBuscadores() {
		driver1.get("http://localhost:3000/");
		WebElement enlace1 = driver1.findElement(By.id("buscadores"));
		assertNotNull(enlace1, "El enlace de Buscadores no se encontró");
		assertEquals("Buscadores", enlace1.getText());
		enlace1.click();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println("Error");
		}
		String url = driver1.getCurrentUrl();
		assertEquals("http://localhost:3000/buscadores/", url, "No se navegó a la página esperada");

	}

	@Test
	void testEnlaceRedesSociales() {
		driver1.get("http://localhost:3000/");
		WebElement enlace2 = driver1.findElement(By.id("redes-sociales"));
		assertNotNull(enlace2, "El enlace de Redes Sociales no se encontró");
		assertEquals("Redes Sociales", enlace2.getText(), "El texto del enlace no es el esperado");
		enlace2.click();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println("Error");
		}
		String url = driver1.getCurrentUrl();
		assertEquals("http://localhost:3000/redes-sociales/", url, "No se navegó a la página esperada");
	}

}
