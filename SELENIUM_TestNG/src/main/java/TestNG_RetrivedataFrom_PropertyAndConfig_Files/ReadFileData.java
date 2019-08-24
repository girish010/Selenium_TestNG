package TestNG_RetrivedataFrom_PropertyAndConfig_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadFileData 
{
	static WebDriver driver;
	static Properties prop = new Properties();
	//@Test
	public static void readPropertiesFile() throws IOException
	{
	    
	    
	        InputStream input = new FileInputStream("./Login_Details.properties");
	        prop.load(input);
	        
	    	System.setProperty(prop.getProperty("Keys"),prop.getProperty("Values"));
			driver=new ChromeDriver();
		
			
			driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/span/input")).sendKeys(prop.getProperty("BankerID"));
			driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[4]/span/input")).sendKeys(prop.getProperty("UserName"));
			driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[6]/span/input")).sendKeys(prop.getProperty("Password"));
			driver.findElement(By.xpath("//*[@id=\"clicked_when_enter_id\"]")).click();
  
	}
	
	public void openbrowser()
	{
		System.setProperty(prop.getProperty("Keys"),prop.getProperty("Values"));
		driver=new ChromeDriver();
		
	}
	
	public String enter_url()
	{
		driver.get(prop.getProperty("URL"));
		return null;
		
	}

}
