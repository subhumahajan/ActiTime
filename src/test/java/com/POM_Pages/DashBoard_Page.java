package com.POM_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard_Page {
	WebDriver driver;
	
	//WEBELEMENT 
	@FindBy(xpath="//a[text()='Enter Time-Track']")
	private WebElement SelectedTabTitle;
	
	@FindBy(xpath="//div[text()='TIME-TRACK']")
	private WebElement SelectedTitleTab;
	
	@FindBy(xpath="//a[contains(@class,'content')]")
	private List<WebElement> NumberOfTabDisplayed;
	
	
	//CONSTRUCTOR
	public DashBoard_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//PAGE ACTION
	public void isSelectedTabTitle()
	{
		SelectedTabTitle.isSelected();
	}
	public void isSelectedTitleTab()
	{
		SelectedTitleTab.isSelected();
	}
	public boolean isNumberOfTabDisplayed()
	{
		for(int i=0; i<NumberOfTabDisplayed.size();i++)
		{
			if(!NumberOfTabDisplayed.get(i).isSelected())
			{
				return false;				
			}
		}
		return true;

	}
	public String isGetDashBoardTitle()
	{
		return driver.getTitle();
	}
	public String isGetDashboardURL()
	{
		return driver.getCurrentUrl();
	}
}
