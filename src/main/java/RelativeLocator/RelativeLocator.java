package RelativeLocator;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocator 
{
	@Test(priority=1)
	public void newTab() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nopcommerce.com/en/demo");
		
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//a[text()='Get started']"));
		WebElement password = driver.findElement(RelativeLocator.withTagName("input").toLeftOf(element));

}
}
