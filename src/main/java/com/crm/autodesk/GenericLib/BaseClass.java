package com.crm.autodesk.GenericLib;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.autodesk.elementRepository.CreateLeadInfo;
import com.crm.autodesk.elementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public JASONutilities jsonLib=new JASONutilities();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;
	
	@BeforeSuite (groups = {"SmokeSuite","RegressionSuite"})
	public void connectDB() throws Throwable
	{
		//dbLib.connectToDB();
		System.out.println("======MakeDBConnection========");
	}
	//@Parameters("Browser")
	@BeforeClass (groups = {"SmokeSuite","RegressionSuite"})
	public void launchBrowser(/*String BROWSER*/) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		System.out.println("======LaunchBrowser========");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		
		//launch the browser
				if(BROWSER.equalsIgnoreCase("chrome")) 
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
				driver=new FirefoxDriver();	
				}
				else
				{
					
					System.out.println("invalid browser");
				}
				
				wLib.waitForPageLoad(driver);
				wLib.maximizeWindow(driver);
				driver.get(URL);
				staticdriver=driver;
	}
	@BeforeMethod (groups = {"SmokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable
	{
		System.out.println("======loginToApp========");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		
	    LoginPage lp=new LoginPage(driver);
	    lp.login(USERNAME, PASSWORD);
	}
	@AfterMethod (groups = {"SmokeSuite","RegressionSuite"})
	public void logoutOfApp()
	{
		System.out.println("======logoutOfApp========");
		CreateLeadInfo cli=new CreateLeadInfo(driver);
		cli.logout(driver);
	}
	@AfterClass (groups = {"SmokeSuite","RegressionSuite"})
	public void closeBrowser()
	{
		System.out.println("======closeBrowser========");
		driver.close();
	}
	@AfterSuite (groups = {"SmokeSuite","RegressionSuite"})
	/**
	 * this method is use to close the connection of data base
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		//dbLib.closeDB();
		System.out.println("======closeDB========");
	}
	/**
	 * this method is use to take screenshort with the method name
	 * @param name
	 * @return
	 * @throws Throwable
	 */
	public String screenShot(String name) throws Throwable  
	{
		 File srcfile =((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		 String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		 File finaldest=new File(destfile);
		 FileUtils.copyFile(srcfile, finaldest);
    
		 return destfile;
	}
	
	
	
}
