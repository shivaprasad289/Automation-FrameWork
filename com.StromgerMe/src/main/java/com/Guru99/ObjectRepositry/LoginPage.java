package com.Guru99.ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userNameTF;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//input[@type='reset']")
	private WebElement resetBtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method helps to login to Guru99 applications.
	 * @param userName
	 * @param password
	 * @return
	 */
	public void login(String userName,String password) {
		userNameTF.sendKeys(userName);
		passwordTF.sendKeys(password);
		loginBtn.click();
	}
	public WebElement getUserNameTF() {
		return userNameTF;
	}
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
}
