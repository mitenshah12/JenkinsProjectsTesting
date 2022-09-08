package org.login.com;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RealTest extends BaseClass {

	RealTest(){
		super();
	}

	@Test
	public void testCase1() {
		String titleOfHomePage=driver.getTitle();
		System.out.println("The Title of the webpage is "+titleOfHomePage);
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(titleOfHomePage, "Dashboard");
		assert1.assertAll();
	}

	@Test

	public void testCase2() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for(int i=0;i<2;i++) {
			driver.findElement(By.xpath("//li[@class='menu-item menu-tmpl' and @id='UcMenu1_adminMenu_DXI0_2']")).click();
		}
		driver.findElement(By.xpath("//a[@data-parent='Covid Data']")).click();
		driver.findElement(By.xpath("//div[@id='drpEmployee_chosen']//a[@class='chosen-single']//div//b")).click();
		List<WebElement> EmployeeName=driver.findElements(By.xpath("//*[contains(text(),'Select Employee')]//parent::select/option"));
		
    	for(int i=0;i<EmployeeName.size();i++) {
    		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Select Employee')]//parent::select/option["+(i+1)+"]")).getAttribute("value"));
    	}




	}

}
