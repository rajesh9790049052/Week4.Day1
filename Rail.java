package week4.day1;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rail {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("TPJ",Keys.TAB);
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU",Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		WebElement elementTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> listRows=elementTable.findElements(By.tagName("tr"));
		for (int i=0; i<listRows.size();i++) {
			WebElement currentRows=listRows.get(i);
			
			List<WebElement> listColumn = currentRows.findElements(By.tagName("td"));
			
			if(listColumn.get(1).getText().contains("SF")) {
				System.out.println(listColumn.get(0).getText());
				System.out.println(listColumn.get(1).getText());
			}
		
		
		}
		
		
	}

	}


