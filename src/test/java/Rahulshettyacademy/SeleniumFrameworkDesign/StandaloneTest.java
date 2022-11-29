package Rahulshettyacademy.SeleniumFrameworkDesign;

import java.sql.DriverAction;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Rahulshettyacademy.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {
	
	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		landingpage.loginApplication("ms1088440@gmail.com", "Mohammedsadiq@123");
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List <WebElement> as = driver.findElements(By.cssSelector(".mb-3"));
		
	
		
		/*for (int i = 0; i < as.size(); i++) {
			
				driver.findElements(By.cssSelector("b")).contains("ZARA COAT 3");
			   driver.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click(); 		*/	
		WebElement prod = as.stream().filter(pro->pro.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Product Added To Cart']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
		List <WebElement>  cartProducts =   driver.findElements(By.cssSelector("div[class='cart'] h3"));
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		System.out.println(match);
		
		driver.findElement(By.xpath("//ul[@style='list-style-type: none;']//button")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[contains(@class,'ta-results')])")));
		driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
		driver.findElement(By.className("btnn")).click();

		String confirmMesssage = driver.findElement(By.className("hero-primary")).getText();
        System.out.println(driver.findElement(By.className("hero-primary")).getText());
        Assert.assertTrue(confirmMesssage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        System.out.println("Order confirm message = "+confirmMesssage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
        
	}
}


