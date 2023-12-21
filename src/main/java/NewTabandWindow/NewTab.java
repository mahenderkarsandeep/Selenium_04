package NewTabandWindow;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab {
	
	@Test(priority=1)
	public void newTab() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nopcommerce.com/en/demo");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.navigate().to("https://digitalbhem.com/internships/");
		
		driver.quit();

}
	@Test(priority=2)
	public void newWindow() throws IOException
	{		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nopcommerce.com/en/demo");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.navigate().to("https://digitalbhem.com/internships/");
		
		driver.quit();
}
}
