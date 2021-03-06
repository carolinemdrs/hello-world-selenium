// pacotes

package primeiroTesteSite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//bibliotecas
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//classe
public class Cursos {
	//atributos / caracteristicas
	String url; //endere�o do site alvo
	WebDriver driver; //objeto do Selenium webdriver
	
	//m�todos/fun��es
	@Before
	public void iniciar () {
		url = "https://www.iterasys.com.br";
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\TEMP\\eclipse-workspace\\PrimeiroTesteSite\\drives\\chrome\\versao83\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void finalizar () {
		driver.quit();
	}
	
	@Test  
	public void consultarCurso () {
		//HOME
		driver.get(url); //abre navegador na p�gina indicada na url
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis"));
		//tirar o screenshot
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		
		//LISTA DE CURSOS
		driver.findElement(By.cssSelector("span.comprar")).click();
		
		//CARRINHO
		
		String titulo = "Mantis";
		String preco = "R$ 89,99";
		
		assertEquals(titulo, driver.findElement(By.cssSelector("span.item-title")).getText());
		assertEquals(preco, driver.findElement(By.cssSelector("span.new-price")).getText());
		
		
		
		
	}
}
