package burger_king;

import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage {
	public static void main(String[]args) {
		
		// Setup driver
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.manage().window().maximize();
			driver.get("https://www.bk.com/");
			
			//Adding Duration to view somemore time
			Thread.sleep(15000);
			
			//Handle Cookie Consent Visible
			try {
				WebElement cookieAccept = driver.findElement(By.xpath("//button[contains(text(), 'Cookies Settings')]"));
				if (cookieAccept.isDisplayed()) {
					cookieAccept.click();
					System.out.println("🍪 Cookie Consent Accepted");
					
					// Wait for the second popup to appear
					Thread.sleep(10000);
					
					// Click on "Confirm My Choices" button
					WebElement cookieConfirm = driver.findElement(By.xpath("//button[contains(text(), 'Confirm My Choices')]"));
					if(cookieConfirm.isDisplayed()) {
						cookieConfirm.click();
						System.out.println("✅ Confirmed cookie choices.");
					}
				}
			} catch (Exception e) {
				System.out.println("ℹ️ Cookie Consent not Found or Already accepted");
			}
			
			//Add Time for UI to Fully Appear After Cookie Modal is Gone
			Thread.sleep(10000);
			
			//Navigate to Menu page
			try {
				WebElement menuLink = driver.findElement(By.xpath("//*[text()='Menu' or contains(.,'Menu')]"));
				if(menuLink.isDisplayed()) {
					menuLink.click();
					System.out.println("🍔 Navigated to the Menu Page");
					Thread.sleep(10000);
					System.out.println("Menu Page Title :" + driver.getTitle());
				}
			} catch (Exception e) {
				System.out.println("⚠️ Menu Link not Found or failed or failed to click");
			}
			
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
		} finally {
			driver.quit();
		}
	}
}
