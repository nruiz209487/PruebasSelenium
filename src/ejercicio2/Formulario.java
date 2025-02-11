package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Formulario {
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
	void testNombre() {
		driver1.get("http://localhost:3000/formulario");
		WebElement nombre = driver1.findElement(By.id("nombre"));
		nombre.sendKeys("Juan Pérez");
		assertNotNull(nombre);
	}

	@Test
	void testApelido() {
		driver1.get("http://localhost:3000/formulario");
		WebElement apellidos = driver1.findElement(By.id("apellidos"));
		apellidos.sendKeys("Juan Pérez");
		assertNotNull(apellidos);
	}

	@Test
	void testSexoFemenino() {
		driver1.get("http://localhost:3000/formulario");
		WebElement sexoFemenino = driver1.findElement(By.id("sexoFemenino"));
		sexoFemenino.click();
		assertNotNull(sexoFemenino);
	}

	@Test
	void testSexoMasculino() {
		driver1.get("http://localhost:3000/formulario");
		WebElement sexoMasculino = driver1.findElement(By.id("sexoMasculino"));
		sexoMasculino.click();
		assertNotNull(sexoMasculino);
	}

	@Test
	void testCorreo() {
		driver1.get("http://localhost:3000/formulario");
		WebElement correo = driver1.findElement(By.id("email"));
		correo.sendKeys("Juanpa@iesnervion.es");
		assertNotNull(correo);
	}

	@Test
	void testCasilaVerificacion1() {
		driver1.get("http://localhost:3000/formulario");
		WebElement verificacion1 = driver1.findElement(By.id("verificacion1"));
		verificacion1.click();
		assertNotNull(verificacion1);
	}

	@Test
	void testCasilaVerificacion2() {
		driver1.get("http://localhost:3000/formulario");
		WebElement verificacion2 = driver1.findElement(By.id("verificacion2"));
		verificacion2.click();
		assertNotNull(verificacion2);
	}

	@Test
	void testPaginaBoton() {
		driver1.get("http://localhost:3000/formulario");
		WebElement indice = driver1.findElement(By.id("boton"));
		assertNotNull(indice, "El enlace de Buscadores no se encontró");
		indice.click();
	}

}
