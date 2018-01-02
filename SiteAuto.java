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
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SiteAuto {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		// Initialize browser
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver= new ChromeDriver(chromeOptions);
		// Open demoqa
		String baseUrl ="http://demoqa.com/"; 
		driver.get(baseUrl);
		
		Thread.sleep(1000);
		driver.findElement(By.id("menu-registration")).click();
		driver.findElement(By.id("name_3_firstname")).sendKeys("Tamara");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Trefilova");
		List<WebElement> list = driver.findElements(By.name("radio_4[]"));
		for(WebElement el:list) {
			if(el.getAttribute("value").equals("Married"));
			el.click();
		}
		List<WebElement> listA = driver.findElements(By.name("checkbox_5[]"));
		for(WebElement el:listA) {
			if(el.getAttribute("value").equals("Dance"));
			el.click();
		}
		Select country = new Select(driver.findElement(By.id("dropdown_7")));
		String count = "United States";
		country.selectByVisibleText(count);
		
		Select month = new Select(driver.findElement(By.id("mm_date_8")));
		month.selectByVisibleText("1");
		
		Select date = new Select(driver.findElement(By.id("dd_date_8")));
		date.selectByVisibleText("16");
		
		Select year = new Select(driver.findElement(By.id("yy_date_8")));
		year.selectByVisibleText("2000");
		
		driver.findElement(By.id("phone_9")).sendKeys("111111111111");
		
		driver.findElement(By.id("username")).sendKeys("toma");
		
		driver.findElement(By.id("email_1")).sendKeys("toma@gmail.com");
		
		WebElement uploadElement = driver.findElement(By.id("profile_pic_10"));
		uploadElement.sendKeys("C:\\Users\\tamara\\Desktop\\21765266_1515357288541863_336013603962322329_n.jpg");
		
		driver.findElement(By.id("description")).sendKeys("My name is Tamara");
		driver.findElement(By.id("password_2")).sendKeys("qwerty1234");
		driver.findElement(By.id("confirm_password_password_2")).sendKeys("qwerty1234");
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile,new File("C:\\Users\\tamara\\Desktop\\screenshotA.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("pie_submit")).click();

//		driver.quit();
//		driver.close();
		
		
		
		
		 
		 
	}

}
