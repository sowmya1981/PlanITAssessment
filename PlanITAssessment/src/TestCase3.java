import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[@class='btn btn-success btn-large']")).click();
		// String[] itemsNeeded = {"Stuffed Frog","Fluffy Bunny","Valentine Bear"};

		driver.findElement(By.xpath("//h4[@class='product-title ng-binding' and text()='Stuffed Frog']")).isDisplayed();
		
		//Add Stuffed Frog 2 times
		String stuffedFrogPrice = driver.findElement(By.xpath(
				"//h4[@class='product-title ng-binding' and text()='Stuffed Frog']/..//span[@class='product-price ng-binding']"))
				.getText().substring(1);
		
	  // String trimFrogPrice = stuffedFrogPrice.replaceAll("[$]", "");
		
		int frogCount = 2;
		
		
		for (int i = 1; i <= frogCount; i++) {
			driver.findElement(By.xpath(
					"//h4[@class='product-title ng-binding' and text()='Stuffed Frog']/..//a[@class='btn btn-success']"))
					.click();
		}
		
		//Add Fluffy Bunny
		driver.findElement(By.xpath("//h4[@class='product-title ng-binding' and text()='Fluffy Bunny']")).isDisplayed();
		
		String fluffyBunnyPrice = driver.findElement(By.xpath(
				"//h4[@class='product-title ng-binding' and text()='Fluffy Bunny']/..//span[@class='product-price ng-binding']"))
				.getText().substring(1);
		
		//String trimBunnyPrice = fluffyBunnyPrice.replaceAll("[$]", "");
		
		int bunnyCount = 5;
		
		for (int i = 1; i <= bunnyCount; i++) {
			driver.findElement(By.xpath(
					"//h4[@class='product-title ng-binding' and text()='Fluffy Bunny']/..//a[@class='btn btn-success']"))
					.click();
		}
		
		//Add Valentine Bear
		driver.findElement(By.xpath("//h4[@class='product-title ng-binding' and text()='Valentine Bear']"))
				.isDisplayed();
		
		
		String valentineBearPrice = driver.findElement(By.xpath(
				"//h4[@class='product-title ng-binding' and text()='Valentine Bear']/..//span[@class='product-price ng-binding']"))
				.getText().substring(1);
		
		//String trimBearPrice = valentineBearPrice.replaceAll("[$]", "");
		
		int bearCount = 3;

		for (int i = 1; i <= bearCount; i++) {
			driver.findElement(By.xpath(
					"//h4[@class='product-title ng-binding' and text()='Valentine Bear']/..//a[@class='btn btn-success']"))
					.click();
		}

		//Adding items to Cart
		driver.findElement(By.cssSelector("a[href='#/cart']")).click();
		
		
		double frogPriceInt = Double.valueOf(stuffedFrogPrice);
		double bunnyPriceInt = Double.valueOf(fluffyBunnyPrice);
		double bearPriceInt = Double.valueOf(valentineBearPrice);
		
		
		double totalFrogPrice = frogCount*frogPriceInt;
		double totalBunnyPrice = bunnyCount*bunnyPriceInt;
		double totalBearPrice = bearCount*bearPriceInt;
	
		
		
		/*System.out.println("Integer value: " + frogPriceInt);
		System.out.println("Integer value: " + bunnyPriceInt);
		System.out.println("Integer value: " + bearPriceInt);*/
		
		//System.out.println("Total Frog Price " + totalFrogPrice);
		
		//Assert.assertEquals(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Stuffed Frog']/..//td[4]")).getText(), totalFrogPrice);
		
		

		

		
		
		/*
		String actualFrogPrice = driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Stuffed Frog']/..//td[2]")).getText();
		String actualBunnyPrice= driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Fluffy Bunny']/..//td[2]")).getText();
		String actualValentineBearPrice = driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Valentine Bear']/..//td[2]")).getText();
		
		
		
		//System.out.println(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Stuffed Frog']/..//td[3]/input[@name='quantity']")).getText());
		//System.out.println(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Fluffy Bunny']/..//td[3]/input[@name='quantity']")).getText());
		//System.out.println(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Valentine Bear']/..//td[3]/input[@name='quantity']")).getText());
	*/	
		System.out.println(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Stuffed Frog']/..//td[4]")).getText());
		System.out.println(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Fluffy Bunny']/..//td[4]")).getText());
		System.out.println(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Valentine Bear']/..//td[4]")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Stuffed Frog']/..//td[4]")).getText(), "$"+totalFrogPrice);
        Assert.assertEquals(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Fluffy Bunny']/..//td[4]")).getText(), "$"+totalBunnyPrice);
        Assert.assertEquals(driver.findElement(By.xpath("//td[@class='ng-binding' and text()=' Valentine Bear']/..//td[4]")).getText(), "$"+totalBearPrice);
		
		

		
	}

}
