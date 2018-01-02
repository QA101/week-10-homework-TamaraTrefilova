package seleniumPractice;

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
		String linkedIn = "https://www.linkedin.com/in/tamara-trefilova/"; 
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys(linkedIn);
		element.submit();
//		WebElement link = driver.findElement(By.partialLinkText("Tamara Trefilova"));
//		String text = link.getText();
//		if(!text.equals("Tamara Trefilova | Professional Profile - LinkedIn")) {
//			throw new Exception("Link not found");
//		}
//		driver.quit();
//		
	}

}
