package mailVerification.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjectRepo.NewMessagePage;
import mailVerification.genericLb.BaseClass;

public class SendMail extends BaseClass {
	@Test 
public void sendMail() throws Throwable { 
		NewMessagePage nmp = new NewMessagePage(driver);
		nmp.sendMail(du.getDataFromPropertiesFile("user2"), du.getDataFromPropertiesFile("msg"));
}

}
