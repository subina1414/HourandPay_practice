package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ThirdTestCase {
	WebDriver dvr;
	WebDriverWait wait;
	WebElement usernameInput;
	WebElement passwordInput;
	WebElement loginBtn;

	@BeforeTest
	public void printTest()
	{
		System.out.println("Test has now Started");
		
	}
	@BeforeMethod
	public void printMethod()
	{
		System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");

		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");	
		dvr=new ChromeDriver(o);
		wait=new WebDriverWait(dvr, 2);
		dvr.manage().window().maximize();
		dvr.get("http://qa-counterstrike.codefirm.net/");
		
		usernameInput=dvr.findElement(By.name("username"));
		passwordInput=dvr.findElement(By.name("password"));
		loginBtn=dvr.findElement(By.xpath("html/body/div[1]/div/div/form/div/div/button"));
		
		
	}
	@Test
	public void login(){
		
		usernameInput.sendKeys("admin");
		passwordInput.sendKeys("123admin@");
		loginBtn.click();
	}
	@Test
	public void explrCS(){
		  usernameInput.sendKeys("admin");
		  passwordInput.sendKeys("123admin@");
		  loginBtn.click();
		  WebElement reportBtn=dvr.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span"));
		  wait.until(ExpectedConditions.elementToBeClickable(reportBtn));
		  reportBtn.click();
		  
		  WebElement taskMgmt=dvr.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[5]/a/span"));
		  wait.until(ExpectedConditions.elementToBeClickable(taskMgmt));
		  taskMgmt.click();
		  
		  //add task dialog
		  WebElement addTask=dvr.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[5]/div[2]/form/div[2]/button"));
		  wait.until(ExpectedConditions.elementToBeClickable(addTask));
		  addTask.click();	  
	}
	@Test
	public void logout(){
		  WebElement logoutDrpdown=dvr.findElement(By.xpath("html/body/div[1]/div/div[1]/div[4]/div/a/span"));
		  wait.until(ExpectedConditions.elementToBeClickable(logoutDrpdown));
		  logoutDrpdown.click();
		 
		  WebElement logoutBtn=dvr.findElement(By.xpath("html/body/div[1]/div/div[1]/div[4]/div/div/div/div[2]/a"));
		  wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		  logoutBtn.click();
	}
	@AfterMethod
	public void afterMethod(){
		dvr.quit();
	}
	@AfterTest
	public void afterTest(){
		//System.out.println("Test has now Completed");
	}
}
