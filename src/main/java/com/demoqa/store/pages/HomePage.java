package com.demoqa.store.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

	@FindBy(xpath = "//a[text()='Product Category']")
	private WebElement productCategory_lnk;

	@FindBy(css = "a[href$='accessories/']")
	private WebElement accessories_lnk;

	final private String baseUrl = "http://store.demoqa.com";

	public HomePage(WebDriver driver,WebDriverWait wait) {
		super(driver,wait);
	}

	public void gotoHomePage() {
		driver.get(baseUrl);
	}

	public void gotoAccessoriesPage() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(productCategory_lnk).perform();
		accessories_lnk.click();
	}
}