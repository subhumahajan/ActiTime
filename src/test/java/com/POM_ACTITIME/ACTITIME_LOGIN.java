package com.POM_ACTITIME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM_Pages.DashBoard_Page;
import com.POM_Pages.Login_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ACTITIME_LOGIN {
	WebDriver driver ;

	@BeforeMethod
	public void SetUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:90/login.do");
}
	
	
	@Test(priority=1)
	public void VerifyLoginPageField()
	{
		Login_Page lp = new Login_Page(driver);
		Assert.assertTrue(lp.isuserNameFieldDisplayed());
		Assert.assertTrue(lp.ispassWordFieldDisplayed());
		Assert.assertTrue(lp.isloginButtonDisplayed());
		Assert.assertTrue(lp.ischeckMeLogBoxdDisplayed());
		Assert.assertTrue(lp.ischeckMeLogBoxdEnabled());
		Assert.assertTrue(lp.isloginLogosDisplayed());	
		Reporter.log(" LOGIN PAGE FUNCTIONALITY VERIFICATION SUCCESS ");
	}
	
	@Test(priority=2)
	public void ValidateLoginPageField()
	{
		Login_Page lp = new Login_Page(driver);
		lp.ValidateUserNameField();
		lp.ValidatePassWordField();
		lp.ValidateLoginButton();
		lp.ValidatelogoutButton();
		Reporter.log(" LOGIN PAGE FUNCTIONALITY VALIDATION SUCCESS ");

		
	}

	
	@Test(priority=3)
	public void VerifyDahboardField()
	{
		DashBoard_Page dp = new DashBoard_Page(driver);
		Assert.assertSame(dp.isGetDashBoardTitle(),"actiTIME - Login");
		Assert.assertSame(dp.isGetDashboardURL(),"http://localhost:90/login.do");
		Assert.assertTrue(dp.isNumberOfTabDisplayed());
		
		Reporter.log(" DASHBOARD PAGE FUNCTIONALITY VERIFICATION SUCCESS ");

		
	}

	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		
	}
}
