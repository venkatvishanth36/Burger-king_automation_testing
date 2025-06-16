package burger_king;

import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class homepage {
	public static void main(String[]args) {
		
		// Setup driver
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.manage().window().maximize();
			driver.get("https://www.bk.com/");
			//Adding Duration to view somemore time
			Thread.sleep(20000);

			
			// Wait for page to load, and print title
			String Title = driver.getTitle();
			System.out.println("Page Title: " + Title);
			
			if(Title.contains("Burger King")) {
				System.out.println("✅ Homepage Loaded Successfully");
			} else {
				System.out.println("❌ Unexpected Page Title");
			}
		} catch (Exception e) {
			System.out.println("❗ Error: " + e.getMessage());
		}finally {
			driver.quit();
		}
	}

}
