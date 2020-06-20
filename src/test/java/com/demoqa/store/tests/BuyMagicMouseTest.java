package com.demoqa.store.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.store.pages.AccessoriesPage;
import com.demoqa.store.pages.CheckoutPage;
import com.demoqa.store.pages.HomePage;
import com.demoqa.store.pages.TransactionResultsPage;

public class BuyMagicMouseTest extends BaseTest {

	@Test(priority = 0)
	public void navigateToAccessoriesPage() throws InterruptedException {
		page.GetInstance(HomePage.class).gotoHomePage();
		page.GetInstance(HomePage.class).gotoAccessoriesPage();
		Assert.assertTrue(driver.getTitle().contains("Google"), "User couldn't navigate to Accessories page");
	}

	@Test(priority = 1)
	public void addMagicMouseToCart() throws InterruptedException {
		page.GetInstance(AccessoriesPage.class).addMagicMouseToCart();
		page.GetInstance(AccessoriesPage.class).navigateToCheckoutPage();
		Assert.assertTrue(driver.getTitle().contains("Checkout"), "User couldn't navigate to Checkout page");
	}

	@Test(priority = 2)
	public void confirmMagicMouseInCart() throws InterruptedException {
		String cartContents = page.GetInstance(CheckoutPage.class).returnCartContents();
		String quantity = page.GetInstance(CheckoutPage.class).returnQuantity();
		Assert.assertTrue(cartContents.contains("Magic Mouse"), "Magic mouse not added to cart");
		Assert.assertEquals(quantity, "1", "Magic mouse quantity not equal to one");
	}

	@Test(priority = 3)
	public void enterBillingDetails() throws InterruptedException {
		page.GetInstance(CheckoutPage.class).continueToCartPartTwo();
		Thread.sleep(3000);
		page.GetInstance(CheckoutPage.class).enterBillingInfo();
		page.GetInstance(CheckoutPage.class).purchaseProduct();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Transaction Results"),
				"User couldn't navigate to TransactionResults page");
	}

	@Test(priority = 4)
	public void confirmOrder(){
		int orderCount = page.GetInstance(TransactionResultsPage.class)
				.confirmOrder();
		Assert.assertEquals(orderCount,2,"Magic mouse order not placed");
	}
}