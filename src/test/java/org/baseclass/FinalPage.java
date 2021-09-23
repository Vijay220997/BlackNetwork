package org.baseclass;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FinalPage extends BaseClass {
	RegisterPage r;
	Loginpage loginpage;
	Homepage homepage;
	
	
	@DataProvider(name = "login")
	public Object[][] getData() throws IOException {
		return new Object[][] {

				{ getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "Sheet1", 0, 0), getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "Sheet1", 0, 1) }

		};

	}
	
	@BeforeClass
	public void browserlaunch() {
		getDriver("chrome");
		launchUrl("https://test.smartblacknetwork.com/login/1");
		
		

	}
	@Test(dataProvider="login")
	public void tc1(String username,String password) {
		loginpage=new Loginpage();
		WebElement txtUserName = loginpage.getTxtUserName();
		txtUserName.sendKeys(username);
		WebElement txtPassword = loginpage.getTxtPassword();
		txtPassword.sendKeys(password);
		
		WebElement btnLogin = loginpage.getBtnLogin();
		btnLogin.click();
		
		
		

	}
	@Test()
	public void tc2() throws AWTException, InterruptedException, IOException {
		 homepage= new Homepage();
		 Thread.sleep(3000);
		 WebElement createPostBtn = homepage.getCreatePostBtn();
		 createPostBtn.click();
		 Thread.sleep(2000);
		 WebElement addPostBtn = homepage.getAddPostBtn();
		 addPostBtn.click();
		 Thread.sleep(2000);
		 keyBoardAction(KeyEvent.VK_P);
		 
		 getScreenShot("C:\\Pictures\\output.png");
		 
		 Thread.sleep(2000);
		 WebElement addPostBtn2 = homepage.getAddPostBtn();
		 addPostBtn2.click();
		 keyBoardAction(KeyEvent.VK_B);
		 getScreenShot("C:\\Pictures\\output1.png");
		 WebElement postBtn = homepage.getPostBtn();
		 postBtn.click();WebElement img = driver.findElement(By.xpath(
					"//p[text()=\"Camera\"]/parent::div/parent::div//following-sibling::app-feed-post/child::div/div/div/following-sibling::div"));
			boolean displayed = img.isDisplayed();
			Assert.assertEquals(displayed, true);
			System.out.println("Image uploaded");

		}

		 
		

	

	@Test(enabled = false)
	public void tc3() throws IOException {
		r = new RegisterPage();
		
		WebElement registerbtnclk = r.getRegisterbtnclk();
		registerbtnclk.click();
		r.getRegFirstName().sendKeys(getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "sheet1", 1, 0));
		r.getRegLastName().sendKeys(getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "sheet1", 1, 1));
		r.getRegUserName().sendKeys(getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "sheet1", 1, 2));
		r.getRegEmail().sendKeys(getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "sheet1", 1, 3));
		r.getRegPassword().sendKeys(getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "sheet1", 1, 4));
		r.getRegConfirmPassword().sendKeys(getExcel("C:\\Users\\Dell\\eclipse-workspace\\AutomateBlackNetWork\\SampleDate\\Blacknetwork.xlsx", "sheet1", 1, 5));
		r.getToggleBtn().click();
		r.getSubmitBtn().click();
		

	}
@AfterClass
public static void close() {
	quit();

}
	

}
