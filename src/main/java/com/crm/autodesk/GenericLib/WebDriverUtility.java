package com.crm.autodesk.GenericLib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author JAnsari
 *
 */
public class WebDriverUtility {
	/**
	 * This method is use to wait for 20 sec.
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * this method is use to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	   
	   /**
	    * This method wait for the element to be visible
	    * @param driver
	    * @param element
	    * 
	    */
	   public void waitForElementVisible(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOf(element));
	   }
	   /**
	    * this method is use to select the element by index
	    * @param element
	    * @param index
	    */
	   public void select(WebElement element,int index)
	   {
		   Select sel=new Select(element);
		   sel.selectByIndex(index);
		   
	   }
	   public void select(WebElement element,String text)
	   {
		   Select sel=new Select(element);
		   sel.selectByVisibleText(text);
	   }
	   public void Scrollbar(WebDriver driver,WebElement ele) {
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	   }
	   /**
	    * this method is use to mouse over on the element
	    * @param driver
	    * @param element
	    */
	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	
	}
	/**
	 * this method is use to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();

	}
	/**
	 * this method is use to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is use to click on cancel button
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String alertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * this method is use to swithch the frame through index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is use to switch the frame through frame id
	 * @param driver
	 * @param frameid
	 */
	public void switchToFrame(WebDriver driver,String frameid)
	{
		driver.switchTo().frame(frameid);
	}
	/**
	 * this method is use to switch the frame through web element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * this method is use to switch the frame through partial title
	 * @param driver
	 * @param partialwinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialwinTitle)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String actTitle=driver.switchTo().window(winId).getTitle();
			if(actTitle.contains(partialwinTitle))
			{
				driver.switchTo().window(actTitle);
				break;
			}
		}
	}
	
	
	
}
