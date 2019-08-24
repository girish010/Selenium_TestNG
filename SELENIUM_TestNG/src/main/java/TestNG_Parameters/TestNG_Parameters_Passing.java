package TestNG_Parameters;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestNG_Parameters_Passing 
{
	WebDriver driver;

	@Test(priority=1,groups={"openbrowser"}, alwaysRun = true )
	public void open_browser()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("open_browser");
	}
	@Test(priority=2,groups={"enterurl"} , dependsOnMethods ="open_browser")
	public void enter_url()
	{
		driver.get("http://mykidsbank.org");
		System.out.println("enter_url");

	}
	@Test(priority=3,groups={"Verification_Page","user_Login"}, dependsOnGroups ="enterurl")
	public void Verify_LoginPage()
	{
		String title= driver.getTitle();
		System.out.println(title);		
		Assert.assertEquals(title, "MyKidsBank.org home");
		System.out.println("Verify_LoginPage");

	}
	@Test(priority=4,groups={"userLogin"})
	public void user_Login()
	{
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/span/input")).sendKeys("50092");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[4]/span/input")).sendKeys("banker");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[6]/span/input")).sendKeys("girish010");
		driver.findElement(By.xpath("//*[@id=\"clicked_when_enter_id\"]")).click();
		System.out.println("user_Login");

	}
	@Test(priority=5,groups={"Verification_Page","userLogin"})
	public void Verify_Logedin_Page() throws InterruptedException
	{
		Thread.sleep(5000);
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "relgo Bank");
		System.out.println("Verify_Logedin_Page");

	}
	@Test(priority=6,groups={"userLogin","user_Logout"})
	public void user_Logout()
	{
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/span")).click();
		System.out.println("user_Logout");

	}
	
	@Test(priority=7,groups={"CloseBrowser"})
	public void close_browser()
	{
		driver.close();
		System.out.println("close_browser");

	}
	
}
