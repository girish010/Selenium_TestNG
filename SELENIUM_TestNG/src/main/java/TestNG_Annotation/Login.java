package TestNG_Annotation;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login 
{
	/*Order of Execution
	1.Setup_SystemPropertys
	2.lanuchBrowser
	3.enter_url
	4.Logins
	5.Get_LoginPage_Title
	6.waits
	7.deleteAllCookies
	8.CloseBrowser
	9.genrateTestReport
	*/
	WebDriver driver;
	String Keys="webdriver.chrome.driver";
	String Values="./Drivers/chromedriver.exe";
	String url="http://mykidsbank.org";
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite_Started");
	}
	@BeforeClass
	public void enter_url()
	{
		driver.get(url);
	}
	@BeforeTest
	public void lanuchBrowser()
	{
		System.setProperty(Keys, Values);
		driver=new ChromeDriver();

	}
	@BeforeMethod
	public void Verify_LoginPage()
	{
		String title= driver.getTitle();
		System.out.println(title);		
		Assert.assertEquals(title, "MyKidsBank.org home1");
	}
	@Test
	public void User_Login()
	{
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/span/input")).sendKeys("50092");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[4]/span/input")).sendKeys("banker");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[6]/span/input")).sendKeys("girish010");
		driver.findElement(By.xpath("//*[@id=\"clicked_when_enter_id\"]")).click();
		
	}
	@AfterMethod
	public void Verify_Logedin_Page() throws InterruptedException
	{
		Thread.sleep(5000);
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "relgo Bank");
	}
	@AfterClass
	public void deleteAllCookies()
	{
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/span")).click();

	}
	@AfterTest
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();

	}
	@AfterSuite
	public void genrateTestReport()
	{
		System.out.println("genrateTestReport");

	}
}
