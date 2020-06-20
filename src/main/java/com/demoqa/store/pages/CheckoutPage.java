package com.demoqa.store.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends Page {

	@CacheLookup
	@FindBy(css = "table.checkout_cart")
	private WebElement checkoutCart_tbl;

	@FindBy(xpath = "//table[@class='checkout_cart']/tbody/tr[2]/td[3]/form/input")
	private WebElement quantity_tbox;

	@FindBy(css = "input#wpsc_checkout_form_9")
	private WebElement emailAddress_tbox;

	@FindBy(css = "input#wpsc_checkout_form_2")
	private WebElement firstName_tbox;

	@FindBy(css = "input#wpsc_checkout_form_3")
	private WebElement lastName_tbox;

	@FindBy(css = "textarea#wpsc_checkout_form_4")
	private WebElement address_tarea;

	@FindBy(css = "input#wpsc_checkout_form_5")
	private WebElement city_tbox;

	@FindBy(css = "input#wpsc_checkout_form_6")
	private WebElement province_tbox;

	@FindBy(css = "select#wpsc_checkout_form_7")
	private WebElement country_select;

	@FindBy(css = "input#wpsc_checkout_form_18")
	private WebElement phone_tbox;

	@FindBy(css = "a.step2")
	private WebElement continue_lnk;

	@FindBy(css = "div.input-button-buy input")
	private WebElement purchase_lnk;

	Properties prop;
	InputStream in;

	public CheckoutPage(WebDriver driver, WebDriverWait wait) throws IOException {
		super(driver,wait);
		prop = new Properties();
		in = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/utilities/data.properties");
		prop.load(in);
		in.close();
	}

	public String returnCartContents() {
		List<WebElement> Rows = checkoutCart_tbl.findElements(By.tagName("tr"));
		String celltext = null;
		for (int row = 0; row < Rows.size(); row++) {
			List<WebElement> Columns_row = Rows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < Columns_row.size(); column++) {
				celltext += Columns_row.get(column).getText();
			}
		}
		return celltext;
	}

	public String returnQuantity() {
		String quantity = quantity_tbox.getAttribute("value");
		return quantity;
	}

	public void continueToCartPartTwo() {
		continue_lnk.click();
	}

	public void enterBillingInfo() {
		emailAddress_tbox.sendKeys(prop.getProperty("email"));
		firstName_tbox.sendKeys(prop.getProperty("firstname"));
		lastName_tbox.sendKeys(prop.getProperty("lastname"));
		address_tarea.sendKeys(prop.getProperty("address"));
		city_tbox.sendKeys(prop.getProperty("city"));
		province_tbox.sendKeys(prop.getProperty("province"));
		Select country = new Select(country_select);
		country.selectByVisibleText(prop.getProperty("country"));
		phone_tbox.sendKeys(prop.getProperty("phone"));
	}

	public void purchaseProduct() {
		purchase_lnk.submit();
	}
}