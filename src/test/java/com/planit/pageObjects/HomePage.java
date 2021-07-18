package com.planit.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planit.commonMethods.CommonMethods;

import junit.framework.Assert;

public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='testdemowebshop@gmail.com']")
	WebElement accountId;
	@FindBy(xpath = "//div[@class='order-summary-content']")
	WebElement cartProducts;
	@FindBy(xpath = "//input[@name='removefromcart']")
	WebElement checkBox;
	@FindBy(xpath = "//input[@name='updatecart']")
	WebElement updateCartButton;
	@FindBy(xpath = "//li[@id='topcartlink']")
	WebElement shopingCart;
	@FindBy(xpath = "//div[@class='block block-category-navigation']//li/a")
	List<WebElement> categorie;
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logout;
	@FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']")
	WebElement homeButton;
	@FindBy(xpath = "//div[@class='product-grid']/div//h2/a")
	List<WebElement> book;

	/*
	 * @Description : This method validate the account id
	 * 
	 * @Return : void
	 * 
	 */

	public void validateAccountIdIsDisplayed() {
		Assert.assertTrue(accountId.isDisplayed());

	}

	/*
	 * @Description : This method clear the cart
	 * 
	 * @Return : void
	 * 
	 */

	public void clearTheCart() {
		shopingCart.click();
		if (!cartProducts.getText().equals("Your Shopping Cart is empty!")) {
			CommonMethods.elementToBeClickableWithWebElement(20, checkBox, ldriver);
			checkBox.click();
			updateCartButton.click();
		}
	}

	/*
	 * @Description : This method click on the logout
	 * 
	 * @Return : void
	 * 
	 */

	public void clickLogout() {
		logout.click();
	}

	/*
	 * @Description : This method select the categories from the drop down
	 * 
	 * @Return : void
	 * 
	 */

	public void selectCategories(String categories) {

		CommonMethods.selectNGetIndexByText(categorie, categories, true, ldriver);
	}

	/*
	 * @Description : This method select the books from the drop down
	 * 
	 * @Return : void
	 * 
	 */

	public void selectBook(String iteam) {

		CommonMethods.selectNGetIndexByText(book, iteam, true, ldriver);
	}

	/*
	 * @Description : This method click on the home button
	 * 
	 * @Return : void
	 * 
	 */

	public void clickonHomeButton() {
		homeButton.click();
	}

	/*
	 * @Description : This method click on the shopping cart button
	 * 
	 * @Return : void
	 * 
	 */

	public void clickOnShoppingCart() {
		shopingCart.click();
	}

}
