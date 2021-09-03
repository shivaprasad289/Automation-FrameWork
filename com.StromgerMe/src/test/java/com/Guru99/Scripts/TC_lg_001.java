package com.Guru99.Scripts;


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
				logger.warn("Login Failed");
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				
			}
			else
			{
				logger.info("Login Passed");
				homePage.ClickOnLogOutBtn();
				Thread.sleep(2000);
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}
		}
		else if(expResult.equalsIgnoreCase("Invalid")) {
			if(isAlertPresent()==true) {
				logger.warn("Login Passed");
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
				
			}
			else
			{
				logger.info("Login Failed");
				homePage.ClickOnLogOutBtn();
				Thread.sleep(2000);
				wUtil.acceptAlert(staticDriver);
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				
			}
		}
		}	
	@DataProvider(name = "LoginData")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] data = eUtil.getExcelData(IAutoConstant.LOGINDATASHEETNAME);
		return data;
	}
}
