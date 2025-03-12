import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
		
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Contact")).click();
		driver.findElement(By.cssSelector(".btn-contact.btn.btn-primary")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']")).getText(), "We welcome your feedback - but we won't get it unless you complete the form correctly.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='forename-err']")).getText(), "Forename is required");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='email-err']")).getText(), "Email is required");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='message-err']")).getText(), "Message is required");
		
		
		//Filling form with valid details
		driver.findElement(By.id("forename")).sendKeys("Sonya");
		driver.findElement(By.id("email")).sendKeys("sonyad@gmail.com");
		driver.findElement(By.id("message")).sendKeys("Test");
		
		//Click on submit button
		driver.findElement(By.cssSelector(".btn-contact.btn.btn-primary")).click();
		
		
	
	}

}
