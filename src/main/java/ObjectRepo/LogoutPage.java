package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(xpath ="//span[contains(@class,'myauto text-sm rounded border')]")
	private WebElement profileBtn;
	@FindBy(xpath="//button[text()='Sign out']")
	private WebElement signOutBtn;
	
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	public void logout()
	{
		profileBtn.click();
		signOutBtn.click();
		System.out.println("Sign out from the applicatin Successfully");
	}

}
