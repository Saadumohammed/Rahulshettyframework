package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//pageFactory design pattern
	
	@FindBy(css=".mb-3")
	List <WebElement> products;
	
}


