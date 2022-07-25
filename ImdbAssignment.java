package Assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImdbAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.imdb.com/");
		driver.findElement(By.xpath("//input[@id='suggestion-search']")).sendKeys("pushpa");
		driver.findElement(By.xpath("//div[contains(text(),'Pushpa: The Rise - Part 1')]")).click();

		WebElement date = driver.findElement(By.xpath("//a[contains(text(),'Release date')]"));
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();",date);
		String text = driver.findElement(By.xpath("//a[contains(text(),'January 7, 2022 (United States)')]")).getText();
		System.out.println(text);
		String text2 = driver.findElement(By.xpath("//a[contains(text(),'India')]")).getText();
		System.out.println(text2);
		driver.quit();

	}

}
