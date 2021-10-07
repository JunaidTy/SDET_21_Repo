package practice;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriWindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.naukri.com/");
		String parent = driver.getWindowHandle();
		System.out.println("Parent window id is:"+parent);
		Set<String> alwindow = driver.getWindowHandles();
		ArrayList<String> tabs=new ArrayList<>(alwindow);
		System.out.println(tabs);
		driver.switchTo().window(tabs.get(2 ));
		//driver.close();
		driver.switchTo().window(tabs.get(1) );
		driver.findElement(By.xpath("//img[@alt='Tech Mahindra']")).click();
		//driver.close();
		driver.switchTo().window(tabs.get(0));
		//driver.close();
	}

}
