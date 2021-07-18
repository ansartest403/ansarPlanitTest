package com.planit.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//a[text()='Log in']")
	WebElement signButton;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;

	@FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
	WebElement welcomeMessage;

	/*
	 * @Description : This method enter the username
	 * 
	 * @Return : void
	 * 
	 */
	public void enterUserName(String uname) {
		userName.sendKeys(uname);
	}

	/*
	 * @Description : This method enter the password
	 * 
	 * @Return : void
	 * 
	 */
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	/*
	 * @Description : This method click on the submit button
	 * 
	 * @Return : void
	 * 
	 */

	public void clickSubmit() {
		loginButton.click();
	}

	/*
	 * @Description : This method click on the sign button
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnSigin() {
		signButton.click();
	}

	/*
	 * @Description : This method validate the welcome message
	 * 
	 * @Return : void
	 * 
	 */

	public void validateWelcomeMessage() {
		Assert.assertTrue(welcomeMessage.isDisplayed());

	}

}
