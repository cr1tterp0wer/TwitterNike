package Selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Sscraper {

	private WebDriver driver;
	String userName;
	String password;
	String url;
	boolean launched = false;
	
	
	
	public Sscraper(String _username, String _pass)
	{
		userName = _username;
		password = _pass;
		
		
		
	}
	
	public void launch(String _url) 
	{
	  
	  url = _url;
	  
	  this.driver = new FirefoxDriver();
	  System.out.println("help");
	   // And now use this to visit Google
	   driver.get(url);
	  driver .quit();
	   //check for image link if exists
       /*
		 WebElement imageLink = (new WebDriverWait(driver, 10))  
				    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[9]/div/div/div/div/div[2]/div[3]/div[2]/div/div/div/div/div/div/a")));
		
	   
		   System.out.println("Clicking image link...");
		   imageLink.click();
		    */
	 
	 
	     
	   // driver.quit();
	    //WebDriver driver = new HtmlUnitDriver();
	  
	}
	
	
	public boolean isLaunched()
	{
		return launched;
	}
}
