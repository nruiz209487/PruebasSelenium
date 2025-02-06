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

public class Ejercicio2 {
	static WebDriver driver1;

	@BeforeAll
	static void setUp() {
		driver1 = new ChromeDriver();
	}

	@Test
	void testGoogle() {
		driver1.get("http://localhost:3000/buscadores/");

		// Encuentra y hace clic en el enlace de Baidu
		WebElement google = driver1.findElement(By.id("google"));
		assertNotNull(google, "El enlace de Buscadores no se encontró");
		assertEquals("google", google.getText());
		google.click();

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
		assertEquals("https://www.google.es/", url, "No se navegó a la página esperada");

		// Cierra la nueva ventana y vuelve a la original
		driver1.close();
		driver1.switchTo().window(ventanaPrincipal);
	}

	@Test
	void testBing() {
		driver1.get("http://localhost:3000/buscadores/");

		// Encuentra y hace clic en el enlace de Baidu
		WebElement bing = driver1.findElement(By.id("bing"));
		assertNotNull(bing, "El enlace de Buscadores no se encontró");
		assertEquals("bing", bing.getText());
		bing.click();

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
		assertEquals("https://www.bing.com/?setlang=es&brdr=1", url, "No se navegó a la página esperada");

		// Cierra la nueva ventana y vuelve a la original
		driver1.close();
		driver1.switchTo().window(ventanaPrincipal);
	}

	@Test
	void testBaidu() {
		driver1.get("http://localhost:3000/buscadores/");

		// Encuentra y hace clic en el enlace de Baidu
		WebElement baidu = driver1.findElement(By.id("baidu"));
		assertNotNull(baidu, "El enlace de Buscadores no se encontró");
		assertEquals("baidu", baidu.getText());
		baidu.click();

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
		assertEquals("https://www.baidu.com/index.htm", url, "No se navegó a la página esperada");

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