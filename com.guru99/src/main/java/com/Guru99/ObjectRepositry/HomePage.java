package com.Guru99.ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logOutBtn;
	
	
	public void ClickOnLogOutBtn() {
		logOutBtn.click();
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
}
