package Screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot 
{
	@Test(priority=1)
	public void normalScreenShot() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nopcommerce.com/en/demo");

		driver.manage().window().maximize();
		
		TakesScreenshot jss = (TakesScreenshot) driver;
		
		File source = jss.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("normalScreenshot.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.quit();
	}
	
	
	@Test(priority=2)
	public void logoScreenShot() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nopcommerce.com/en/demo");

		driver.manage().window().maximize();
		
		WebElement logo = driver.findElement(By.xpath("//img[@title=\"nopCommerce\"]"));
		
		highLightElement(logo, driver);
		
		File source = logo.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("logoscreenshot.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.quit();
	}
	
	@Test(priority=3)
	public void webElementScreenShot() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nopcommerce.com/en/demo");

		driver.manage().window().maximize();
		
		WebElement webElement = driver.findElement(By.xpath("//span[text()=\"Case studies\"]"));
		
		highLightElement(webElement, driver);
		
		File source = webElement.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("webelementscreenshot.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.quit();
	}
	
	@Test(priority=4)
	public void sessionScreenShot() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nopcommerce.com/en/demo");

		driver.manage().window().maximize();
		
		WebElement sessionElement = driver.findElement(By.xpath("//img[@class='desktop-store-image']"));
		
		highLightElement(sessionElement, driver);
		
		File source = sessionElement.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("sessionscreenshot.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.quit();
	}
	
	public void highLightElement( WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].style.border='2px solid red'", element);
	}

}
