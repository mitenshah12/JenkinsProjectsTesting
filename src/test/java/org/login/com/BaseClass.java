package org.login.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	@BeforeMethod
	public void InitBro() throws Exception {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	FileInputStream fs = new FileInputStream("C:\\Users\\mnshah\\eclipse-workspace\\JenkisSimpleDemoWithMaven\\src\\test\\resources\\resource\\Config.properties");
	prop=new Properties();
	prop.load(fs);
	String url=prop.getProperty("browser");
	String usenme=prop.getProperty("username");
	String passwrd=prop.getProperty("password");
	driver.get(url);
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys(usenme);
	driver.findElement(By.id("password")).sendKeys(passwrd,Keys.ENTER);
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}
