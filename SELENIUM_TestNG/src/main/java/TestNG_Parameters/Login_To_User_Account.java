package TestNG_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_To_User_Account 
{
	WebDriver driver;

	
	@BeforeTest
	@Parameters({"Keys","Values","Browser"})
	public void OpenBrowser(String Keys,String Values,String Browser)
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty(Keys, Values);
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(Keys, Values);
			driver=new FirefoxDriver();
		}
	}
	
	@BeforeClass
	@Parameters({"url"})
	public void Enter_Url(String url)
	{
		driver.get(url);
	}

	@Test
	@Parameters({"BankerID","UserName","Password"})
	public void Login(String BankerID,String UserName,String Password)
	{
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/span/input")).sendKeys(BankerID);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[4]/span/input")).sendKeys(UserName);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[6]/span/input")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"clicked_when_enter_id\"]")).click();
	}
	
	@AfterClass
	public void Verify_Logedin_Page() throws InterruptedException
	{
		Thread.sleep(5000);
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "relgo Bank");
	}
	
	@AfterTest
	public void Logout() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/span")).click();

	}

}
