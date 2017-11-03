package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFormPage {
	WebDriver driver;
	

	String user;
	
	String passwd;
	
	
	public LoginFormPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//--------------------------------------------------------------------------------------------------------------------------------------
	@FindBy(name="username")
	WebElement userNameElement;
	
	@FindBy(name="password")
	WebElement passwordElement;
	
	@FindBy(xpath="html/body/div[1]/div/div/form/div/div/button")
	WebElement loginBtnHnP;
	
	@FindBy(xpath="html/body/div[1]/div/div[1]")
	WebElement toastMessage;
	//toastMessage
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	public void setUsername(String user)
	{
		userNameElement.clear();
		userNameElement.sendKeys(user);
	}
	public void setPassword(String passwd){
		passwordElement.clear();
		passwordElement.sendKeys(passwd);
	}
	public void clickLogin()
	{
		loginBtnHnP.click();
	}
	public void loginToHourNPay(String user, String passwd)
	{
		this.setUsername(user);
		this.setPassword(passwd);
		this.clickLogin();
		
		WebDriverWait wait=new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(toastMessage));
		getErrorMessage();
	}
	public String getErrorMessage(){
		String errorMessage= toastMessage.getText();
		return errorMessage;
	}
}
