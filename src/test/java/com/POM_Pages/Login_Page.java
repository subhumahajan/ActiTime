package com.POM_Pages;

import java.time.Duration;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login_Page {
	
	WebDriver driver;
	@FindBy(id="username")
	private WebElement userNameField;

	@FindBy(css=".textField.pwdfield")
	private WebElement passWordField;
	
	@FindBy(css="#loginButton>div")
	private WebElement loginButton;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement checkMeLogBox;
	
	@FindBy(css="#logoContainer>div")
	private List<WebElement> loginLogos;
	
	@FindBy(css="a#logoutLink")
	private WebElement logoutButton;
	

	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;

	}

	
	public boolean isuserNameFieldDisplayed()
	{
		return userNameField.isDisplayed();
	}

	public boolean ispassWordFieldDisplayed()
	{
		return passWordField.isDisplayed();
	}

	public boolean isloginButtonDisplayed()
	{
		return loginButton.isDisplayed();
	}

	public boolean ischeckMeLogBoxdDisplayed()
	{
		return checkMeLogBox.isDisplayed();
	}
	
	public boolean ischeckMeLogBoxdEnabled()
	{
		return checkMeLogBox.isEnabled();
	}

	public boolean isloginLogosDisplayed()
	{
		for (int i=0; i<loginLogos.size(); i++)
		{
			if (!loginLogos.get(i).isDisplayed())
			{
				return false;
			}
		}
		return true;
	}
	
	public void ValidateUserNameField()
	{
		userNameField.sendKeys("admin");
	}

	public void ValidatePassWordField()
	{
		passWordField.sendKeys("manager");
	}
	
	public void ValidateLoginButton()
	{
		loginButton.click();
	}
	
	public void ValidatelogoutButton()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		logoutButton.click();
	}
	
}
