package mailVerification.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjectRepo.HomePage;
import mailVerification.genericLb.BaseClass;

public class ReciveMail extends BaseClass{
	@Test 
public void reciveMail() throws Throwable   {
		HomePage hp = new HomePage(driver);
		hp.deleteMailAndVarify(driver, du,du.getDataFromPropertiesFile("msg"));
}
}


