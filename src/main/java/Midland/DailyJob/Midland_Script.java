package Midland.DailyJob;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Midland_Script {

@Test
public static void qwerty() throws InterruptedException, AWTException
{
		
	   System.setProperty("webdriver.chrome.driver",
			"H:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	   
	    driver.get("https://curecam.mycurecloud.com/Login.aspx");
	    driver.manage().window().maximize();
	    //driver.manage().window().setSize(new Dimension(1920,1080));
	    
	    Thread.sleep(2000);
	    
	    Thread.sleep(1000);driver.findElement(By.xpath("//input[@id='MainContent_UserName']")).sendKeys("irfan.khalid");
	    Thread.sleep(1000);driver.findElement(By.xpath("//input[@id='MainContent_Password']")).sendKeys("B@bar123");
	    Thread.sleep(1000);driver.findElement(By.xpath("//input[@id='MainContent_LoginButton']")).click();	
	    Thread.sleep(1000);driver.findElement(By.xpath("//input[@id='MainContent_txtPracticeFilter']")).sendKeys("Midland Medical Broward");	
	    
	    Robot robot = new Robot();
	    
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    Thread.sleep(1000);driver.findElement(By.xpath("//input[@id='chk254']")).click();
	    Thread.sleep(1000);driver.findElement(By.xpath("//a[contains(@href,'Javascript')]")).click();
	    Thread.sleep(9000);
	    
	    String parent_window = driver.getWindowHandle();System.out.println("Parent Window Handle is :"+parent_window);
	    
	    Set <String> allwindows = driver.getWindowHandles();
	    
	    for (String childwindow : allwindows)
	    {
	    	if (!childwindow.contentEquals(parent_window))
	    	{
	    		driver.switchTo().window(childwindow);System.out.println("Child Window Handle is :"+childwindow);driver.getCurrentUrl();
	    		
	    	    if (driver.getCurrentUrl().contentEquals("https://app5.curemd.com/curemdg/datCureMD.aspx#/"))
	    	    {
	    	    	System.out.println("Current Child Window Handle is :"+childwindow);
	    	    	driver.switchTo().frame("fraCureMD_Menu");
	    	    	Thread.sleep(2000);driver.findElement(By.xpath("//span[@id='izenda7']")).click();
	    	    	System.out.println("Izenda 7 Clicked");
	    	    	
	    	    	System.out.println(driver.getCurrentUrl());
	    	    	
	    	    	Thread.sleep(20000);
	    	    	
	    	    
	    	    }
	    	}
	    }    

}
}
