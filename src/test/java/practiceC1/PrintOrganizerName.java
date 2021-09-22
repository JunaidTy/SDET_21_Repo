package practiceC1;
/**
 * 
 * @author JAnsari
 *  
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.JASONutilities;

public class PrintOrganizerName {
	WebDriver driver;
	@Test
	
	public void PrintOrganizer() throws Throwable {
		
	JASONutilities jsonlib = new JASONutilities(); 
	String URL=jsonlib.readDataFromJSON("url");
	String USERNAME=jsonlib.readDataFromJSON("username");
	String PASSWORD=jsonlib.readDataFromJSON("password");
	String browser=jsonlib.readDataFromJSON("browser");
	
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
	List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
	//to print organizer name
	for(WebElement oname:list)
	{
	    String organizername= oname.getText();
	    System.out.println(organizername);
	}
	Thread.sleep(3000);
	driver.close();
}
}
