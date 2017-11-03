package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTestCase {
	WebDriver dvr;
	WebDriverWait wait;
	WebElement usernameInput;
	WebElement passwordInput;
	WebElement loginBtn;
	
	@BeforeTest
	public void printTest(){
		System.out.println("Test has started");
	 
	}
	@BeforeMethod
	public void printMethod(){
		System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");
		dvr = new ChromeDriver();
		wait = new WebDriverWait(dvr, 2);
		dvr.manage().window().maximize(); 
		dvr.get("http://qa-counterstrike.codefirm.net/");
		usernameInput=dvr.findElement(By.name("username"));
		passwordInput=dvr.findElement(By.name("password"));
		loginBtn=dvr.findElement(By.xpath("html/body/div[1]/div/div/form/div/div/button"));
		
	
	}
	@Test
	public void login(){
		usernameInput.sendKeys("admin");
		passwordInput.sendKeys("123admin");
		loginBtn.click();
	}
	@Test
	public void exploreSel(){
		
		WebElement reportBtn=dvr.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span"));
		wait.until(ExpectedConditions.elementToBeClickable(reportBtn));
		reportBtn.click();	
	}
	@AfterMethod
	public void afterMethod(){
		dvr.quit();
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("Test has finished");
		
	}
}
