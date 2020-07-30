package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class LoginPage extends DriverScript {

	            @FindBy(id="username") WebElement usernameTbox;
				@FindBy(name="pwd") WebElement passwordTbox;
				@FindBy(id="loginButton") WebElement loginButton;
				@FindBy(xpath="//div[@class='atLogoImg']") WebElement actiLogo;
				
				
				public LoginPage() throws Exception
				{
					PageFactory.initElements(driver, this);
				}
				
				public void validateLoginFunction(String username,String password)
				{
					usernameTbox.sendKeys("admin");
					passwordTbox.sendKeys("manager");
					loginButton.click();
				}
				
				public boolean verifyActiLogo()
				{
					return actiLogo.isDisplayed();
				}
				
				public String verifyLoginPageTitle()
				{
					return driver.getTitle();
				}
	             
	
	

}

