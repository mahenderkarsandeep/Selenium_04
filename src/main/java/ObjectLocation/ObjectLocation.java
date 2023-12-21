package ObjectLocation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectLocation {

	@Test(priority = 1)
	public void objectLocation() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.nopcommerce.com/en/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement element = driver.findElement(By.xpath("//img[@title=\"nopCommerce\"]"));
		
		Point p = element.getLocation();
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		Dimension d = element.getSize();
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());

		// Get the location and size of the WebElement
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		System.out.println(x + " " + y + " " + width + " " + height);

		driver.quit();

	}
}
