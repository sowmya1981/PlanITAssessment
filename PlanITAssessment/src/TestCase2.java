import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("Contact")).click();

		for (int i = 0; i <= 5; i++) {

			driver.findElement(By.id("forename")).sendKeys("Sonya");
			driver.findElement(By.id("email")).sendKeys("sonyad@gmail.com");
			driver.findElement(By.id("message")).sendKeys("Test");

			// Click on submit button
			driver.findElement(By.cssSelector(".btn-contact.btn.btn-primary")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
			Thread.sleep(5000);

			driver.findElement(By.xpath("//a[@class='btn']")).click();

		}
	}
}
