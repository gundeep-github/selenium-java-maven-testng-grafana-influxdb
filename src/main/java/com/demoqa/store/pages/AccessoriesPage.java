package com.demoqa.store.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccessoriesPage extends Page {


	@FindBy(xpath = "//div/h2/a[text()='Magic Mouse']/../../form/div/div/span/input")
	private WebElement addToCart_btn;
	
	@FindBy(css = "a[href$='checkout/']")
	private WebElement checkout_lnk;
	
	public AccessoriesPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver,wait);
	}
	
	public void addMagicMouseToCart()
	{
		addToCart_btn.click();
	}
	
	public void navigateToCheckoutPage()
	{
		checkout_lnk.click();
	}
}
