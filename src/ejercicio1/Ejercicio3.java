package ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio3 {
	static WebDriver driver1;

	@BeforeAll
	static void setUp() {
		driver1 = new ChromeDriver();
	}

	@Test
	void testInstagram() {
		driver1.get("http://localhost:3000/redes-sociales/");

		// Encuentra y hace clic en el enlace de Baidu
		WebElement instagram = driver1.findElement(By.id("instagram"));
		assertNotNull(instagram, "El enlace de Buscadores no se encontró");
		assertEquals("instagram", instagram.getText());
		instagram.click();

		// Guarda la ventana original
		String ventanaPrincipal = driver1.getWindowHandle();

		// Espera a que haya más de una ventana abierta
		new WebDriverWait(driver1, Duration.ofSeconds(5)).until(driver -> driver.getWindowHandles().size() > 1);

		// Obtiene todos los identificadores de ventana
		Set<String> ventanas = driver1.getWindowHandles();
		String nuevaVentana = null;

		// Encuentra la nueva ventana
		for (String ventana : ventanas) {
			if (!ventana.equals(ventanaPrincipal)) {
				nuevaVentana = ventana;
				break;
			}
		}

		// Cambia a la nueva ventana
		assertNotNull(nuevaVentana, "No se encontró una nueva ventana");
		driver1.switchTo().window(nuevaVentana);

		// Verifica la URL
		String url = driver1.getCurrentUrl();
		assertEquals("https://www.instagram.com/", url, "No se navegó a la página esperada");

		// Cierra la nueva ventana y vuelve a la original
		driver1.close();
		driver1.switchTo().window(ventanaPrincipal);
	}

	@Test
	void testTikTok() {
		driver1.get("http://localhost:3000/redes-sociales/");

		// Encuentra y hace clic en el enlace de Baidu
		WebElement tikTok = driver1.findElement(By.id("tikTok"));
		assertNotNull(tikTok, "El enlace de Buscadores no se encontró");
		assertEquals("tikTok", tikTok.getText());
		tikTok.click();

		// Guarda la ventana original
		String ventanaPrincipal = driver1.getWindowHandle();

		// Espera a que haya más de una ventana abierta
		new WebDriverWait(driver1, Duration.ofSeconds(5)).until(driver -> driver.getWindowHandles().size() > 1);

		// Obtiene todos los identificadores de ventana
		Set<String> ventanas = driver1.getWindowHandles();
		String nuevaVentana = null;

		// Encuentra la nueva ventana
		for (String ventana : ventanas) {
			if (!ventana.equals(ventanaPrincipal)) {
				nuevaVentana = ventana;
				break;
			}
		}

		// Cambia a la nueva ventana
		assertNotNull(nuevaVentana, "No se encontró una nueva ventana");
		driver1.switchTo().window(nuevaVentana);

		// Verifica la URL
		String url = driver1.getCurrentUrl();
		assertEquals("https://www.tiktok.com/es/", url, "No se navegó a la página esperada");

		// Cierra la nueva ventana y vuelve a la original
		driver1.close();
		driver1.switchTo().window(ventanaPrincipal);
	}

	@Test
	void testFacebook() {

		driver1.get("http://localhost:3000/redes-sociales/");
		// Encuentra y hace clic en el enlace de Baidu
		WebElement facebook = driver1.findElement(By.id("facebook"));
		assertNotNull(facebook, "El enlace de Buscadores no se encontró");
		assertEquals("facebook", facebook.getText());
		facebook.click();

		// Guarda la ventana original
		String ventanaPrincipal = driver1.getWindowHandle();

		// Espera a que haya más de una ventana abierta
		new WebDriverWait(driver1, Duration.ofSeconds(5)).until(driver -> driver.getWindowHandles().size() > 1);

		// Obtiene todos los identificadores de ventana
		Set<String> ventanas = driver1.getWindowHandles();
		String nuevaVentana = null;

		// Encuentra la nueva ventana
		for (String ventana : ventanas) {
			if (!ventana.equals(ventanaPrincipal)) {
				nuevaVentana = ventana;
				break;
			}
		}

		// Cambia a la nueva ventana
		assertNotNull(nuevaVentana, "No se encontró una nueva ventana");
		driver1.switchTo().window(nuevaVentana);

		// Verifica la URL
		String url = driver1.getCurrentUrl();
		assertEquals("https://es-es.facebook.com/", url, "No se navegó a la página esperada");

		// Cierra la nueva ventana y vuelve a la original
		driver1.close();
		driver1.switchTo().window(ventanaPrincipal);
	}

	@Test
	void testPaginaAtras() {
		driver1.get("http://localhost:3000/buscadores/");
		WebElement indice = driver1.findElement(By.id("indice"));
		assertNotNull(indice, "El enlace de Buscadores no se encontró");
		indice.click();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println("Error");
		}
		String url = driver1.getCurrentUrl();
		assertEquals("http://localhost:3000/", url, "No se navegó a la página esperada");
	}
}
