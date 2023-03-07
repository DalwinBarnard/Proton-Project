package ObjectRepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mailVerification.genericLb.DataUtility;

public class HomePage {
	
	@FindBy(xpath="//div//a[@class='btn inline-block rounded-full font-bold btn-small btn-outlined-purple text-center !leading-4 lg:!leading-6']")
	private WebElement signInBtn;
	
	@FindBy(css="[data-testid='search-keyword']")
	private WebElement searchTB;
	@FindBy(id="search-keyword")
	private WebElement searchTB1;
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;
	@FindBy(xpath="//div[contains(@class,'flex-item-fluid flex flex-nowrap')]")
	private WebElement messageBox;
	@FindBy(xpath="//div[@class='flex flex-nowrap']/h1")
	private WebElement actualTB;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	public WebElement getSearchTB() {
		return searchTB;
	}

	public WebElement getSearchTB1() {
		return searchTB1;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getMessageBox() {
		return messageBox;
	}
	

	public WebElement getActualTB() {
		return actualTB;
	}

	public void clickSignInButton()
	{
		signInBtn.click();
	}

	public void deleteMailAndVarify(WebDriver driver,DataUtility du,String message) throws Throwable
	{
		searchTB.click();
		searchTB1.sendKeys(du.getDataFromPropertiesFile("msg"));
		searchButton.click();
		System.out.println("Test1");
//		WebDriverWait wait= new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(messageBox));
		WebElement resultPresent = driver.findElement(By.xpath("//div[contains(@class,'flex-item-fluid flex flex-nowrap')]"));
		boolean displayed = resultPresent.isDisplayed();
		System.out.println(displayed);
		if(displayed==false) {
		messageBox.click();
		String actual = actualTB.getText();
		System.out.println(actual);
		if(du.getDataFromPropertiesFile("msg").equals(actual)) {
			System.out.println("true");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='flex toolbar-inner']/button[3]")).click();
		}
		else {
			System.out.println("false");
		}
		}
		else
		{
			System.out.println("No mail recived");
			System.out.println("false");
		}
	}

}
