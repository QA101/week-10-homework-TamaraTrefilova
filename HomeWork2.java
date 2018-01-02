package seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import com.google.common.io.Files;

public class HomeWork2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		// Initialize browser
//		WebDriver driver=new ChromeDriver();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver= new ChromeDriver(chromeOptions);
		String baseUrl ="https://www.google.com/"; 
		driver.get(baseUrl);
		Thread.sleep(500);
		String link = "https://www.expedia.com/";
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys(link);
		element.submit();
		driver.findElement(By.linkText("Vacation Packages")).click();
		driver.findElement(By.id("package-origin-plp-fh")).sendKeys("Seattle");
		driver.findElement(By.id("package-destination-plp-fh")).sendKeys("Cancun, Quintana Roo, Mexico");	
		driver.findElement(By.id("package-departing-plp-fh")).sendKeys("03/11/2018");
		driver.findElement(By.id("package-returning-plp-fh")).sendKeys("03/18/2018");		
		driver.findElement(By.id("package-rooms-plp-fh")).sendKeys("1");
		driver.findElement(By.id("package-1-adults-plp-fh")).sendKeys("2");		
		driver.findElement(By.id("package-1-children-plp-fh")).sendKeys("2");
		driver.findElement(By.id("package-1-age-select-1-plp-fh")).sendKeys("12");	
		driver.findElement(By.id("package-1-age-select-2-plp-fh")).sendKeys("15");
		driver.findElement(By.id("package-advanced-preferred-class-plp-fh")).sendKeys("Economy/Coach");		
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile,new File("C:\\Users\\tamara\\Desktop\\screenshotB.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("search-button-plp-fh")).click();
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.className("btn-sort"));
		Thread.sleep(3000);
		list = driver.findElements(By.className("btn-sort"));
		for(WebElement el:list) {
			if(el.getText().equals("Price")) {
				el.click();
			}
		}
		scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile,new File("C:\\Users\\tamara\\Desktop\\screenshotD.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);		
		driver.quit();
	}

}
