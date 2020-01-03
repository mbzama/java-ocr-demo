import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripTest {

	public static void main(String[] args) throws InterruptedException {
		//For Windows OS
		System.setProperty("webdriver.chrome.driver", "/home/zama/software/QA/chromedriver/chromedriver_linux64/chromedriver");


		//For Ubuntu OS
		//System.setProperty("webdriver.chrome.driver", "/home/zama/software/QA/chromedriver/chromedriver_linux64/chromedriver");

		/*
		WebDriver driver = new ChromeDriver();
		//Maximize the browser window
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Enter the URL
		driver.get("https://www.makemytrip.com/");

		//Set the From City 
		driver.findElement(By.id("fromCity")).sendKeys("Hyderabad");
		 */



		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		Date date=new Date();
		String todaysDate=""+date;
		todaysDate=todaysDate.substring(0,11)+todaysDate.substring(24);
		System.out.println(todaysDate);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);				
		String seventhDate=""+cal.getTime();
		seventhDate=seventhDate.substring(0,11)+seventhDate.substring(24);
		System.out.println(seventhDate);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ul[@class='fswTabs latoBlack greyText']//li[2]")).click();

		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bangalore");
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("react-autowhatever-1-section-0-item-0"))).click();
		//driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Hyderabad");
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		Thread.sleep(5000);
		/*driver.findElement(By.xpath("//label[@for='departure']")).click();
		System.out.println("clicked");
		Thread.sleep(5000);*/
		driver.findElement(By.xpath("//div[@aria-label='"+todaysDate+"']")).click();

		driver.findElement(By.xpath("//div[@aria-label='"+seventhDate+"']")).click();


		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")).click();
	}

}
