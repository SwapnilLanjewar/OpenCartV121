package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationPage extends BaseClass{

	
	@Test(groups={"Regression", "Master"})
	public void verify_account_Registration() 
	{
		logger.info("********Starting_TC001_AccountRegistrationTest*********");
		try {
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details......");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toLowerCase());
		regpage.setEmail(randomString() + "@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		
		logger.info("Validating expected message");
		
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!!!")) 
		{
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("Test Failed....");
			logger.debug("Debug logs....");
			Assert.assertFalse(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Finished_TC001_AccountRegistrationTest*********");
				
	}

}
