package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork1 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		// Initialize browser
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver= new ChromeDriver(chromeOptions);
		String baseUrl ="https://www.google.com/"; 
		driver.get(baseUrl);
		Thread.sleep(500);
		String linkedIn = "Tamara Trefilova"; 
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys(linkedIn);
		element.submit();
		driver.findElement(By.partialLinkText("Tamara Trefilova")).click();
		Thread.sleep(3000);
		WebElement header = driver.findElement(By.className("headline"));	
		String textTitle = header.getText();
		if(!(textTitle.equals("Mobile QA tester at Denali Advanced Integration"))) {
			throw new Exception("Link not found");
		}
		driver.quit();
		
	}

}
