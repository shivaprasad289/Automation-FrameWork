package com.StromgerMe.Scripts;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru99.ObjectRepositry.HomePage;
import com.Guru99.ObjectRepositry.LoginPage;
import com.Guru99.generics.BaseClass;
import com.Guru99.generics.IAutoConstant;

import junit.framework.Assert;

public class TC_lg_001 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void LoginTest(String testId,String userName,String password,String expResult) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		logger.info("User name entered");
		loginPage.getUserNameTF().sendKeys(userName);
		System.out.println(userName);
		logger.info("Password entered");
        loginPage.getPasswordTF().sendKeys(password);
		Thread.sleep(2000);
		logger.info("Clicking on Login button");
		loginPage.getLoginBtn().click();
		Thread.sleep(2000);
		
		if(expResult.equalsIgnoreCase("Valid")) {
			if(isAlertPresent()==true) {
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.warn("Login Failed");
			}
			else
			{
				homePage.ClickOnLogOutBtn();
				Thread.sleep(2000);
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
				logger.info("Login Passed");
			}
		}
		else if(expResult.equalsIgnoreCase("Invalid")) {
			if(isAlertPresent()==true) {
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.warn("Login Passed");
			}
			else
			{
				homePage.ClickOnLogOutBtn();
				Thread.sleep(2000);
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.info("Login Failed");
			}
		}
		}	
	@DataProvider(name = "LoginData")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] data = eUtil.getExcelData(IAutoConstant.LOGINDATASHEETNAME);
		return data;
	}
}
