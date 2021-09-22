package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LensKart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
	   WebElement ele1 = driver.findElement(By.xpath("//input[@class='search_input-bar autoSuggest']"));
		ele1.click();
		/*List<WebElement> ele2 = driver.findElements(By.xpath("//div[@class='trending']"));
		
		
		for(WebElement b:ele2) {
			System.out.println(b.getText());
		}*/
		//driver.findElement(By.xpath("//div[@class='Sunclasses']")).click();
		
		
		
		
	}

}
