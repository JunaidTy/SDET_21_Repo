package practiceC1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.JASONutilities;

public class DeleteThirdRow {
WebDriver driver;
	
	@Test

	public void contactTest() throws Throwable {
		
		//read the data from json file
		JASONutilities jsonlib = new JASONutilities(); 
		String URL=jsonlib.readDataFromJSON("url");
		String USERNAME=jsonlib.readDataFromJSON("username");
		String PASSWORD=jsonlib.readDataFromJSON("password");
		String browser=jsonlib.readDataFromJSON("browser");
		
		//choose the browser
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")){
		driver=new FirefoxDriver();	
		}else {
			System.out.println("invalid browser");
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[8]//a[text()='del'])[3]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.close();
		 
}
}

	