package org.login.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public WebDriver driver;
	@BeforeMethod
	public void InitBro() {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	driver.get("https://cygnet.hrinnova.com/");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("mnshah");
	driver.findElement(By.id("password")).sendKeys("Sep@2022",Keys.ENTER);
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}
