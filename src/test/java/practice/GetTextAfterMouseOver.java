package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextAfterMouseOver {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8888");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Leads")).click();
			
			WebElement ele = driver.findElement(By.xpath("//img[@title='Create Lead...']"));
			Actions a=new Actions(driver);	
			a.moveToElement(ele).perform();
			//text=ele.getAttribute("title");
			System.out.println(ele.getAttribute("title"));
			System.out.println("..................");
			driver.close();

	}

}
