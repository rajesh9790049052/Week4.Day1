package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Openwindows {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.xpath("//button[text() ='Open Home Page']")).click();
		
	 Set<String> windowHandles=driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String secWindow = list.get(1);
		driver.switchTo().window(secWindow);
		System.out.println("Second URL : " + driver.getCurrentUrl());
		System.out.println("Second Title : " +driver.getTitle());
		driver.close();
		String firstWindow = list.get(0);
		driver.switchTo().window(firstWindow);
		System.out.println("First URL : " + driver.getCurrentUrl());
		System.out.println("First Title : "+ driver.getTitle());

	}
		}
