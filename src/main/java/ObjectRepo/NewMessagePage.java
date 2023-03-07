package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {
	
	@FindBy(xpath="//button[@class=\"button button-large button-solid-norm w100 no-mobile\"]")
	private WebElement newMessageBtn;
	
	@FindBy(css="[placeholder='Email address']")
	private WebElement toTB;
	@FindBy(xpath="//input[contains(@id,'subject-composer')]")
	private WebElement subjectTB;
	@FindBy(xpath="//span[text()='Send']")
	private WebElement sendBtn;
	
	public NewMessagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewMessageBtn() {
		return newMessageBtn;
	}

	public WebElement getToTB() {
		return toTB;
	}

	public WebElement getSubjectTB() {
		return subjectTB;
	}

	public WebElement getSendBtn() {
		return sendBtn;
	}
	//Business Lib
	
	public void sendMail(String to,String subject) throws Throwable
	{
		newMessageBtn.click();
		toTB.sendKeys(to);
		subjectTB.sendKeys(subject);
		Thread.sleep(2000);
		sendBtn.click();
		System.out.println("Mail Sent");
	}									
	
	

}
