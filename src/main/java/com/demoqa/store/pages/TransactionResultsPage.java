package com.demoqa.store.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransactionResultsPage extends Page {

	@FindBy(css = "table.wpsc-purchase-log-transaction-results")
	private WebElement transactionResults_tbl;

	public TransactionResultsPage(WebDriver driver, WebDriverWait wait) {
		super(driver,wait);
	}

	public int confirmOrder() {
		List<WebElement> Rows = transactionResults_tbl.findElements(By.tagName("tr"));
		return Rows.size();
	}
}
