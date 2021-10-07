package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BLR");
		List<WebElement> from = driver.findElements(By.xpath("//li[@class='react-autosuggest__suggestion']"));
		
		for(WebElement e:from)
		{
			String get = e.getText();
			if(get.contains("Banglore")
					{
						from.
					}
		}
		
		

	}

}
