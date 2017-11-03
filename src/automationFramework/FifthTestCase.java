package automationFramework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FifthTestCase {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");
		driver= new ChromeDriver();
	}

    /*
     * @Test
	public void login()
	{
		// TODO Auto-generated method stub		
		driver.get("http://qa-counterstrike.codefirm.net/");
		WebElement userNameElement =driver.findElement(By.name("username"));
		WebElement passwordElement =driver.findElement(By.name("password"));
		WebElement formElement = driver.findElement(By.xpath("html/body/div[1]/div/div/form/div/div/button"));		
		userNameElement.sendKeys("admin");
		passwordElement.sendKeys("123admin@");
		formElement.submit();
		driver.quit();
	}
	*/
    @Test
    public void blankLogin(){
    	LoginFormPage objLogin;
    	System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");
		driver= new ChromeDriver();
    	driver.get("http://qa-counterstrike.codefirm.net/");
    	driver.manage().window().maximize();
    	WebDriverWait wait= new WebDriverWait(driver, 2);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div/form/div/div/button")));
    	objLogin = new LoginFormPage(driver);
    	objLogin.clickLogin();
    	Assert.assertEquals("Error!Username/Password is Incorrrect", objLogin.getErrorMessage());
    	driver.quit();	
    	
    }
    @Test
    public void invalidUsername(){
    	LoginFormPage objLogin;
    	System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");
		driver= new ChromeDriver();
    	driver.get("http://qa-counterstrike.codefirm.net/");
    	driver.manage().window().maximize();
    	WebDriverWait wait= new WebDriverWait(driver, 2);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div/form/div/div/button")));
    	objLogin = new LoginFormPage(driver);
    	objLogin.loginToHourNPay("admin1","123admin@" );
    	Assert.assertEquals("Error!Username/Password is Incorrrect", objLogin.getErrorMessage());
    	driver.quit();
    	
    }
    
    
    @DataProvider(name="TestData")
    public Object[][] getData()
    {
    	Object[][] data= new Object[2][2];
    	data[0][0]="admins";
    	data[0][1]="123Admin";
    	
    	data[1][0]="user2";
    	data[1][1]="pass2";
    	
    	return data;
    }

}
