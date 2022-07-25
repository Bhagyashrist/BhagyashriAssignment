package Assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikiAssignment {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("pushpa");
		driver.findElement(By.xpath("(//div[@class='suggestion-text'])[1]")).click();
		
		WebElement date1 =driver.findElement(By.xpath("//div[text()='Release date']"));
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();",date1);
		
		String Text1=driver.findElement(By.xpath("(//div [@class= 'plainlist'])[4]")).getText();
		
		System.out.println(Text1);
		
		WebElement country = driver.findElement(By.xpath("//th[text()= 'Country']"));
		
		String Text2 = driver.findElement(By.xpath("//td[text()= 'India']")).getText();
		
		System.out.println(Text2);
		
		driver.quit();
		
	}

}
