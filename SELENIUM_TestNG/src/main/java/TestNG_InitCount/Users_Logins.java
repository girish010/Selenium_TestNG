package TestNG_InitCount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Users_Logins 
{
	WebDriver driver;
	@BeforeMethod
	public void open_browser()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://mykidsbank.org");	
	}
	
	@Test
	public void Login()
	{
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/span/input")).sendKeys("50092");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[4]/span/input")).sendKeys("banker");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[6]/span/input")).sendKeys("girish010");
		driver.findElement(By.xpath("//*[@id=\"clicked_when_enter_id\"]")).click();
		System.out.println("user_Login");
	}
	
	@Test(invocationCount = 10)
	public void Verify_Logedin_Page() throws InterruptedException
	{
		Thread.sleep(5000);
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "relgo Bank");
		System.out.println("Verify_Logedin_Page");
	}
	
	@AfterMethod
	public void Test_Success()
	{
		
		System.out.println("Tested Sussessfully!!");
	}
	

}
