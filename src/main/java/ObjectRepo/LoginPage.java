package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="username")
	private WebElement userNameTB;
	@FindBy(xpath="//input[contains(@id,'password')]")
	private WebElement passwordTB;
	@FindBy(xpath ="//button[.='Sign in']")
	private WebElement submitBtn;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getUserNameTB() {
		return userNameTB;
	}
	public WebElement getPasswordTB() {
		return passwordTB;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void loginToProton(String username, String password)
	{
		userNameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		submitBtn.click();
	}
	

}
