package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FourthTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		//WebDriverWait wait;
		
		System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");
		
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");	
		driver=new ChromeDriver(o);
		driver.get("http://qa-counterstrike.codefirm.net/");
		//wait = new WebDriverWait(driver, 2);
		//driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("123admin@");
		driver.findElement(By.xpath("html/body/div[1]/div/div/form/div/div/button")).click();
	}

}
