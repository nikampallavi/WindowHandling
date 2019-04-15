import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindow {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\jars file\\WebDrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		String parentWindow=driver.getWindowHandle();
		Set<String> allwindows=driver.getWindowHandles();
		Iterator itr=allwindows.iterator();
		for(String child:allwindows)
		{
			if(!parentWindow.equalsIgnoreCase(child))
			{
				String str=driver.switchTo().window(child).getTitle();
				//System.out.println(driver.switchTo().window(child).getTitle());
				if(str.equalsIgnoreCase("Amazon"))
				{
					driver.close();
				}
				else if(str.equalsIgnoreCase("Genpact"))
				{
					driver.close();
				}
				else if(str.equalsIgnoreCase("HCL"))
				{
					driver.close();
				}
			}
		}
		driver.quit();
	}

}
