package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//pageFactory design pattern
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	public void loginApplication(String user,String Pass) {
		userEmail.sendKeys(user);
		Password.sendKeys(Pass);
		loginbtn.click();
}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
}


