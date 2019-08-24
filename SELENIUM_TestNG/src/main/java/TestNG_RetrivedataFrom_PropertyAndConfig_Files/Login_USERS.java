package TestNG_RetrivedataFrom_PropertyAndConfig_Files;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_USERS 
{
	WebDriver driver;
	
	  String keys; String values; String url; String BID; String UN; String PWD;
	 
	
	ReadFileData data = new  ReadFileData();


	
	@BeforeMethod
	@Parameters({"Browser"})
	public void Enter_Url(String Browser ) throws IOException
	{
		data.readPropertiesFile();
		if(Browser.equalsIgnoreCase("chrome"))
		{
		data.openbrowser();
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			data.openbrowser();
			driver=new FirefoxDriver();
		}
		driver.get(data.enter_url());
	}

	@Test
	public void Login()
	{
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/span/input")).sendKeys(BID);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[4]/span/input")).sendKeys(UN);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[6]/span/input")).sendKeys(PWD);
		driver.findElement(By.xpath("//*[@id=\"clicked_when_enter_id\"]")).click();
	}
	

	
	@AfterMethod
	public void Logout() throws InterruptedException
	{
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/span")).click();

	}

}
