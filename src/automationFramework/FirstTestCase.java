package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FirstTestCase {

	public static void main(String args[]) throws InterruptedException{
		
		WebDriver driver;
		WebDriverWait wait;
	
	System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");

	ChromeOptions o = new ChromeOptions();
	o.addArguments("disable-extensions");
	o.addArguments("--start-maximized");	
	driver=new ChromeDriver(o);
	  driver.get("http://qa-counterstrike.codefirm.net/");
	  wait = new WebDriverWait(driver, 2);
	  driver.manage().window().maximize();
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("123admin@");
	  driver.findElement(By.xpath("html/body/div[1]/div/div/form/div/div/button")).click();

	  WebElement reportBtn=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[3]/a/span"));
	  wait.until(ExpectedConditions.elementToBeClickable(reportBtn));
	  reportBtn.click();
	  
	  WebElement taskMgmt=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[5]/a/span"));
	  wait.until(ExpectedConditions.elementToBeClickable(taskMgmt));
	  taskMgmt.click();
	  
	  //add task dialog
	  WebElement addTask=driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[5]/div[2]/form/div[2]/button"));
	  wait.until(ExpectedConditions.elementToBeClickable(addTask));
	  addTask.click();	  
	  //To select finish labor option from dropdown menu
	  Select taskName= new Select(driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[7]/div/div/div/form/div[1]/div/div/div[1]/div/select")));
	  taskName.selectByVisibleText("Finish Labor");
	  Thread.sleep(2000);
	  
	  WebElement cancelButton=driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[7]/div/div/div/form/div[2]/button[1]"));
	  wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
	  cancelButton.click();
	  
	  WebElement leadMgmt=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[13]/a/span"));
	  wait.until(ExpectedConditions.elementToBeClickable(leadMgmt));
	  leadMgmt.click();
	  
	  WebElement addLead=driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[3]/div/a")); 	
	  wait.until(ExpectedConditions.elementToBeClickable(addLead));
	  addLead.click();
	  
	  //fil up the textfields inside form
	  driver.findElement(By.name("name")).sendKeys("Test Data Automation");
	  driver.findElement(By.name("email")).sendKeys("test@auto.com");
	  driver.findElement(By.name("phone")).sendKeys("9841225355");
	  driver.findElement(By.name("source")).sendKeys("smtg company");
	  WebElement radioBtn= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[5]/div/form/div[5]/div/label[3]/input"));
	  radioBtn.click();
	  
	  //click submit form
	  //WebElement submitBtn=driver.findElement(By.xpath(""));
	  //wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
	  //submitBtn.click();
	  
	  //For LOGOUT
	  WebElement logoutDrpdown=driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[4]/div/a/span"));
	  wait.until(ExpectedConditions.elementToBeClickable(logoutDrpdown));
	  logoutDrpdown.click();
	 
	  WebElement logoutBtn=driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[4]/div/div/div/div[2]/a"));
	  wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
	  logoutBtn.click();
}
}
