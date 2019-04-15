import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\jars file\\WebDrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.canarabank.in/");
		driver.manage().window().maximize();
		String ParentWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//button[contains(text(),'NetBanking')]")).click();
		
		Set<String> allWindows=driver.getWindowHandles();
		Iterator itr=allWindows.iterator();
		for(String Child:allWindows)
		{
			if(!ParentWindow.equalsIgnoreCase(Child))
			{
				driver.switchTo().window(Child);
				driver.findElement(By.xpath("//input[@id='fldLoginUserId']")).sendKeys("Pallavi");
				driver.findElement(By.xpath("//input[@id='fldPassword']")).sendKeys("xyz@123");
				driver.findElement(By.xpath("//input[@value='SIGN IN']")).click();
				
			}
		}
		
	}

}
