package com.demoqa.store.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.demoqa.store.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
    public WebDriverWait wait;
	public Page page;
	

	@BeforeClass
	public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		driver.manage().window().maximize(); // Maximizing browser for better visibility
        wait = new WebDriverWait(driver,5);
		page = new Page(driver,wait); // Page class instantiation
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}