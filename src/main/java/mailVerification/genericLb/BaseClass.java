package mailVerification.genericLb;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.LogoutPage;

public class BaseClass {
	public WebDriver driver;
	public ExcellUtility eu= new ExcellUtility();
	public DataUtility du=new DataUtility();
	@BeforeClass(alwaysRun=true)
	public void lunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
	}
	@Parameters({"USERNAME","PASSWORD"})
	@BeforeMethod(alwaysRun=true)
	public void login(String un, String pwd) throws IOException {
		driver.get(du.getDataFromPropertiesFile("url"));
		HomePage hp= new HomePage(driver);
		hp.clickSignInButton();
		LoginPage lp= new LoginPage(driver);
		lp.loginToProton(un, pwd);
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void logout() {
		LogoutPage lp= new LogoutPage(driver);
		lp.logout();
				
		
	}
	 
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
	driver.close();
	}
}
