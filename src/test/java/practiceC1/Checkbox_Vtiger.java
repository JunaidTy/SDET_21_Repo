package practiceC1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.JASONutilities;

public class Checkbox_Vtiger {
	WebDriver driver;
	
	@Test

	public void contactTest() throws Throwable {
			
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
			List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
			 
			/*to click on 5th checkbox
			int index=1;
			for(int i=0;i<list.size();i++)
			{
				index++;
				 if(index==4) {
					 list.get(index).click();
				 }
				} */
				 
			//to click all the checkbox except last
			for(WebElement ele:list) {
				ele.click();
			}
			list.get(list.size()-1).click();
			Thread.sleep(3000);
			driver.close();
	}
	

}
