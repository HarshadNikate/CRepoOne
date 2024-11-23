package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String browserName = "ie";
		WebDriver driver=null;
		
		if(browserName.equals("chrome"))
		{
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
	         driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			 driver = new EdgeDriver();
		}
		else if(browserName.equals("safari"))
		{
			  driver = new SafariDriver();
		}
		else if(browserName.equals("ie"))
		{
			driver = new InternetExplorerDriver();
		}
		
		

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		String Expectedtitle = "Your Store";
		String title = driver.getTitle();
		System.out.println(title);
		if(Expectedtitle.equals(title))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		driver.quit();
		
		

	}

	
}
